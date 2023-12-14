package com.legends.edumia.dynamictrees.block.leaves;

import com.legends.edumia.dynamictrees.api.cell.CellKit;
import com.legends.edumia.dynamictrees.api.registry.RegistryEntry;
import com.legends.edumia.dynamictrees.api.registry.TypedRegistry;
import com.legends.edumia.dynamictrees.cell.CellKits;
import com.legends.edumia.dynamictrees.init.DTTrees;
import com.legends.edumia.dynamictrees.loot.DTLootContextParams;
import com.legends.edumia.dynamictrees.loot.DTLootParameterSets;
import com.legends.edumia.dynamictrees.resources.Resources;
import com.legends.edumia.dynamictrees.tree.Resettable;
import com.legends.edumia.dynamictrees.tree.family.Family;
import com.legends.edumia.dynamictrees.tree.species.Species;
import com.legends.edumia.dynamictrees.util.BlockStates;
import com.legends.edumia.dynamictrees.util.LevelContext;
import com.legends.edumia.dynamictrees.util.LootTableSupplier;
import com.legends.edumia.dynamictrees.util.ResourceLocationUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.LootDataManager;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * This class provides a means of holding individual properties for leaves.  This is necessary since leaves can contain
 * sub blocks that may behave differently.  Each leaves properties object must have a reference to a tree family.
 *
 * @author ferreusveritas
 */
public class LeavesProperties extends RegistryEntry<LeavesProperties> implements Resettable<LeavesProperties> {

    public static final Codec<LeavesProperties> CODEC = RecordCodecBuilder.create(instance -> instance
            .group(ResourceLocation.CODEC.fieldOf(Resources.RESOURCE_LOCATION.toString()).forGetter(LeavesProperties::getRegistryName))
            .apply(instance, LeavesProperties::new));

    public static final LeavesProperties NULL = new LeavesProperties() {

    };

    /**
     * Central registry for all {@link LeavesProperties} objects.
     */
    public static final TypedRegistry<LeavesProperties> REGISTRY = new TypedRegistry<>(LeavesProperties.class, NULL,
            new TypedRegistry.EntryType<>(CODEC));

    protected static final int maxHydro = 7;

    /**
     * The primitive (vanilla) leaves are used for many purposes including rendering, drops, and some other basic
     * behavior.
     */
    protected BlockState primitiveLeaves;

    /**
     * The {@link CellKit}, which is for leaves automata.
     */
    protected CellKit cellKit;

    protected Family family;
    protected BlockState[] dynamicLeavesBlockHydroStates = new BlockState[maxHydro + 1];
    protected int flammability = 60;// Mimic vanilla leaves
    protected int fireSpreadSpeed = 30;// Mimic vanilla leaves

    protected int smotherLeavesMax = 4;
    protected int lightRequirement = 13;
   // protected AgeingConfiguration ageingConfiguration = AgeingConfiguration.ALWAYS;
    protected boolean connectAnyRadius = false;
    protected boolean requiresShears = true;
    protected ResourceLocation texturePath;

    private LeavesProperties() {
        this.blockLootTableSupplier = new LootTableSupplier("null/", DTTrees.NULL);
        this.lootTableSupplier = new LootTableSupplier("null/", DTTrees.NULL);
    }

    public LeavesProperties(final ResourceLocation registryName) {
        this(null, registryName);
    }

    public LeavesProperties(@Nullable final BlockState primitiveLeaves, final ResourceLocation registryName) {
        this(primitiveLeaves, CellKits.DECIDUOUS, registryName);
    }

    public LeavesProperties(@Nullable final BlockState primitiveLeaves, final CellKit cellKit, final ResourceLocation registryName) {
        this.family = Family.NULL_FAMILY;
        this.primitiveLeaves = primitiveLeaves != null ? primitiveLeaves : BlockStates.AIR;
        this.cellKit = cellKit;
        this.setRegistryName(registryName);
        this.blockRegistryName = ResourceLocationUtils.suffix(registryName, this.getBlockRegistryNameSuffix());
        this.blockLootTableSupplier = new LootTableSupplier("blocks/", blockRegistryName);
        this.lootTableSupplier = new LootTableSupplier("trees/leaves/", registryName);
    }

    ///////////////////////////////////////////
    // DYNAMIC LEAVES BLOCK
    ///////////////////////////////////////////

    /**
     * The registry name for the leaves block. This allows for built-in compatibility where the dynamic leaves may
     * otherwise share the same name as their regular leaves block.
     */
    private ResourceLocation blockRegistryName;

    /**
     * Returns a default suffix for {@link #blockRegistryName}. Note that this will be overridden if the {@link
     * #blockRegistryName} is changed in the Json.
     *
     * @return A default suffix for {@link #blockRegistryName}.
     */
    protected String getBlockRegistryNameSuffix() {
        return "_leaves";
    }


    /**
     * Sets the type of tree these leaves connect to.
     *
     * @param family The {@link Family} object to set.
     * @return This {@link LeavesProperties} object.
     */
    public LeavesProperties setFamily(Family family) {
        this.family = family;
        if (family.isFireProof()) {
            flammability = 0;
            fireSpreadSpeed = 0;
        }
        return this;
    }


    public Optional<DynamicLeavesBlock> getDynamicLeavesBlock() {
        Block block = this.getDynamicLeavesState().getBlock();
        return Optional.ofNullable(block instanceof DynamicLeavesBlock ? (DynamicLeavesBlock) block : null);
    }

    public BlockState getDynamicLeavesState() {
        return getDynamicLeavesState(getCellKit().getDefaultHydration());
    }

    public BlockState getDynamicLeavesState(int hydro) {
        return Optional.ofNullable(dynamicLeavesBlockHydroStates[Mth.clamp(hydro, 0, maxHydro)])
                .orElse(Blocks.AIR.defaultBlockState());
    }

    /**
     * Gets the {@link CellKit}, which is for leaves automata.
     *
     * @return The {@link CellKit} object.
     */
    public CellKit getCellKit() {
        return cellKit;
    }

    private final LootTableSupplier blockLootTableSupplier;

    private final LootTableSupplier lootTableSupplier;

    public LootTable getLootTable(LootDataManager lootTables, Species species) {
        return lootTableSupplier.get(lootTables, species);
    }

    public List<ItemStack> getDrops(Level level, BlockPos pos, ItemStack tool, Species species) {
        if (level.isClientSide) {
            return Collections.emptyList();
        }
        return getLootTable(level.getServer().getLootData(), species)
                .getRandomItems(createLootParams(level, pos, tool, species));
    }

    private LootParams createLootParams(Level level, BlockPos pos, ItemStack tool, Species species) {
        return new LootParams.Builder(LevelContext.getServerLevelOrThrow(level))
                .withParameter(LootContextParams.BLOCK_STATE, level.getBlockState(pos))
                .withParameter(DTLootContextParams.SPECIES, species)
                .withParameter(DTLootContextParams.SEASONAL_SEED_DROP_FACTOR, species.seasonalSeedDropFactor(LevelContext.create(level), pos))
                .withParameter(LootContextParams.TOOL, tool)
                .create(DTLootParameterSets.LEAVES);
    }
}
