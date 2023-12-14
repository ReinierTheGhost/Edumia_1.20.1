package com.legends.edumia.dynamictrees.tree.species;

import com.legends.edumia.dynamictrees.api.registry.RegistryEntry;
import com.legends.edumia.dynamictrees.api.registry.TypedRegistry;
import com.legends.edumia.dynamictrees.api.substance.Emptiable;
import com.legends.edumia.dynamictrees.api.substance.SubstanceEffect;
import com.legends.edumia.dynamictrees.api.substance.SubstanceEffectProvider;
import com.legends.edumia.dynamictrees.block.leaves.DynamicLeavesBlock;
import com.legends.edumia.dynamictrees.block.leaves.LeavesProperties;
import com.legends.edumia.dynamictrees.compat.season.SeasonHelper;
import com.legends.edumia.dynamictrees.data.DTItemTags;
import com.legends.edumia.dynamictrees.entity.LingeringEffectorEntity;
import com.legends.edumia.dynamictrees.init.DTConfigs;
import com.legends.edumia.dynamictrees.init.DTTrees;
import com.legends.edumia.dynamictrees.resources.Resources;
import com.legends.edumia.dynamictrees.systems.substance.FertilizeSubstance;
import com.legends.edumia.dynamictrees.systems.substance.GrowthSubstance;
import com.legends.edumia.dynamictrees.tree.Resettable;
import com.legends.edumia.dynamictrees.tree.family.Family;
import com.legends.edumia.dynamictrees.util.BranchDestructionData;
import com.legends.edumia.dynamictrees.util.LevelContext;
import com.mojang.datafixers.util.Function3;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;

public class Species extends RegistryEntry<Species> implements Resettable<Species> {

    public static final Species NULL_SPECIES = new Species() {

    };

    /**
     * A list of leaf blocks the species accepts as its own. Used for the falling tree renderer
     */
    private final List<LeavesProperties> validLeaves = new LinkedList<>();


    /**
     * The family of tree this belongs to. E.g. "Oak" and "Swamp Oak" belong to the "Oak" Family
     */
    protected Family family = Family.NULL_FAMILY;

    //Leaves
    protected LeavesProperties leavesProperties = LeavesProperties.NULL;

    public static final TypedRegistry.EntryType<Species> TYPE = createDefaultType(Species::new);
    public static final Codec<Species> CODEC = ResourceLocation.CODEC.comapFlatMap(Species::read, Species::getRegistryName);

    public static TypedRegistry.EntryType<Species> createDefaultType(final Function3<ResourceLocation, Family, LeavesProperties, Species> constructor) {
        return TypedRegistry.newType(createDefaultCodec(constructor));
    }

    public static Codec<Species> createDefaultCodec(final Function3<ResourceLocation, Family, LeavesProperties, Species> constructor) {
        return RecordCodecBuilder.create(instance -> instance
                .group(ResourceLocation.CODEC.fieldOf(Resources.RESOURCE_LOCATION.toString())
                                .forGetter(Species::getRegistryName),
                        Family.REGISTRY.getGetterCodec().fieldOf("family").forGetter(Species::getFamily),
                        LeavesProperties.REGISTRY.getGetterCodec().optionalFieldOf("leaves_properties",
                                LeavesProperties.NULL).forGetter(Species::getLeavesProperties))
                .apply(instance, constructor));
    }

    private static DataResult<Species> read(ResourceLocation name) {
        final Species species = Species.REGISTRY.get(name);
        return species == null ? DataResult.error(() -> "Species not found: " + name) : DataResult.success(species);
    }
    /**
     * Central registry for all {@link Species} objects.
     */
    public static final TypedRegistry<Species> REGISTRY = new TypedRegistry<>(Species.class, NULL_SPECIES, TYPE);

    private String unlocalizedName = "";

    /**
     * Blank constructor for {@link #NULL_SPECIES}.
     */
    public Species() {
        this.setRegistryName(DTTrees.NULL);
    }

    /**
     * Constructor suitable for derivative mods that defaults the leavesProperties to the common type for the family
     *
     * @param name   The simple name of the species e.g. "oak"
     * @param family The {@link Family} that this species belongs to.
     */
    public Species(ResourceLocation name, Family family) {
        this(name, family, family.getCommonLeaves());
    }

    /**
     * Constructor suitable for derivative mods
     *
     * @param name             The simple name of the species e.g. "oak"
     * @param leavesProperties The properties of the leaves to be used for this species
     * @param family           The {@link Family} that this species belongs to.
     */
    public Species(ResourceLocation name, Family family, LeavesProperties leavesProperties) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name.toString());
        this.family = family;
        this.family.addSpecies(this);
        this.setLeavesProperties(leavesProperties.isValid() ? leavesProperties : family.getCommonLeaves());
    }

    private boolean canBoneMealTree = true;

    public void setCanBoneMealTree(boolean canBoneMealTree) {
        this.canBoneMealTree = canBoneMealTree;
    }

    public boolean canBoneMealTree() {
        return canBoneMealTree;
    }


    //////////////////////////////
    // INTERACTIVE
    //////////////////////////////

    @Nullable
    public SubstanceEffect getSubstanceEffect(ItemStack itemStack) {

        // Bonemeal fertilizes the soil and causes a single growth pulse.
        if (canBoneMealTree() && itemStack.is(DTItemTags.FERTILIZER)) {
            return new FertilizeSubstance().setAmount(2).setGrow(true).setPulses(DTConfigs.BONE_MEAL_GROWTH_PULSES::get);
        }

        // Use substance provider interface if it's available.
        if (itemStack.getItem() instanceof SubstanceEffectProvider) {
            SubstanceEffectProvider provider = (SubstanceEffectProvider) itemStack.getItem();
            return provider.getSubstanceEffect(itemStack);
        }

        // Enhanced fertilizer applies the Burgeoning potion effect.
        if (itemStack.is(DTItemTags.ENHANCED_FERTILIZER)) {
            return new GrowthSubstance();
        }

        return null;
    }

    /**
     * Apply an item to the treepart(e.g. bonemeal). Developer is responsible for decrementing itemStack after
     * applying.
     *
     * @param level     The current level
     * @param hitPos    Position
     * @param player    The player applying the substance
     * @param itemStack The itemstack to be used.
     * @return true if item was used, false otherwise
     */
    public boolean applySubstance(Level level, BlockPos rootPos, BlockPos hitPos, Player player, InteractionHand hand, ItemStack itemStack) {
        final SubstanceEffect effect = getSubstanceEffect(itemStack);

        if (effect != null) {
            boolean applied = effect.apply(level, rootPos);
            if (applied && effect.isLingering()) {
                level.addFreshEntity(new LingeringEffectorEntity(level, rootPos, effect));
                return true;
            } else {
                return applied;
            }
        }

        return false;
    }

    /**
     * A convenience function to decrement or otherwise consume an item in use.
     *
     * @param player   The player
     * @param hand     Hand holding the item
     * @param heldItem The item to be consumed
     */
    public static void consumePlayerItem(Player player, InteractionHand hand, ItemStack heldItem) {
        if (!player.isCreative()) {
            if (heldItem.getItem() instanceof Emptiable) { // A substance deployed from a refillable container.
                final Emptiable emptiable = (Emptiable) heldItem.getItem();
                player.setItemInHand(hand, emptiable.getEmptyContainer());
            } else if (heldItem.getItem() == Items.POTION) { // An actual potion.
                player.setItemInHand(hand, new ItemStack(Items.GLASS_BOTTLE));
            } else {
                heldItem.shrink(1); // Just a regular item like bonemeal.
            }
        }
    }


    /**
     * Called when a player right clicks a {@link Species} of tree anywhere on it's branches.
     *
     * @return True if action was handled, false otherwise.
     */
    public boolean onTreeActivated(Family.TreeActivationContext context) {
        if (context.heldItem != null) { // Ensure there is something in the player's hand.
            if (applySubstance(context.level, context.rootPos, context.hitPos, context.player, context.hand,
                    context.heldItem)) {
                consumePlayerItem(context.player, context.hand, context.heldItem);
                return true;
            }
        }

        return false;
    }

    public Species setUnlocalizedName(String name) {
        this.unlocalizedName = "species." + name.replace(":", ".");
        return this;
    }
    public Family getFamily() {
        return family;
    }

    ///////////////////////////////////////////
    //LEAVES
    ///////////////////////////////////////////

    public Species setLeavesProperties(LeavesProperties leavesProperties) {
        this.leavesProperties = leavesProperties;
        leavesProperties.setFamily(getFamily());
        addValidLeafBlocks(leavesProperties);
        return this;
    }

    public LeavesProperties getLeavesProperties() {
        return leavesProperties;
    }

    public void addValidLeafBlocks(LeavesProperties... leaves) {
        for (LeavesProperties leaf : leaves) {
            if (!this.validLeaves.contains(leaf)) {
                this.validLeaves.add(leaf);
            }
        }
    }

    protected CommonOverride commonOverride;

    public boolean hasCommonOverride() {
        return this.commonOverride != null;
    }

    public boolean shouldOverrideCommon(final BlockGetter level, final BlockPos trunkPos) {
        return this.hasCommonOverride() && this.commonOverride.test(level, trunkPos);
    }

    public boolean canEncodeLeavesBlocks (BlockPos pos, BlockState state, Block block, BranchDestructionData data){
        return block instanceof DynamicLeavesBlock;
    }

    public int encodeLeavesPos(BlockPos pos, BlockState state, Block block, BranchDestructionData data) {
        return (state.getValue(DynamicLeavesBlock.DISTANCE) << 24) | BranchDestructionData.encodeRelBlockPos(pos);
    }

    public int encodeLeavesBlocks(BlockPos pos, BlockState state, Block block, BranchDestructionData data) {
        return getLeafBlockIndex((DynamicLeavesBlock) block);
    }

    public int getLeafBlockIndex(DynamicLeavesBlock block) {
        int index = validLeaves.indexOf(block.properties);
        if (index < 0) {
            LogManager.getLogger().warn("Block {} not valid leaves for {}.", block, this);
            return 0;
        }
        return index;
    }

    public boolean isValidLeafBlock(final DynamicLeavesBlock leavesBlock) {
        return this.validLeaves.stream().anyMatch(properties ->
                properties.getDynamicLeavesBlock().orElse(null) == leavesBlock);
    }

    @Nullable
    protected Float seasonalSeedDropOffset = 0f;

    public float seasonalSeedDropFactor(LevelContext levelContext, BlockPos pos) {
        return seasonalSeedDropOffset != null ? SeasonHelper.globalSeasonalSeedDropFactor(levelContext, pos, -seasonalSeedDropOffset)
                : 1.0f;
    }
    @FunctionalInterface
    public interface CommonOverride extends BiPredicate<BlockGetter, BlockPos> {

    }

}
