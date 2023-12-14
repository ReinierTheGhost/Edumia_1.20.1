package com.legends.edumia.util;

import com.legends.edumia.block.GenericSkullBlock;
import com.legends.edumia.blockentity.HeadBlockEntity;
import com.legends.edumia.entity.EntityTypeContainer;
import com.legends.edumia.entity.interfaces.IVariantTypes;
import com.legends.edumia.entity.util.builder.IEntityBuilder;
import com.legends.edumia.entity.util.variant.IVariant;
import com.legends.edumia.item.ItemBlockHeadType;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HeadType {
    private final EntityTypeContainer<? extends LivingEntity> container;

    public HeadType(EntityTypeContainer<? extends LivingEntity> container, String name,
                    PlacementType placement, String modid, IVariant singletonVariant, Consumer<RegistrarManager> registerVariants) {
        this.container = container;
        this.name = name;
        this.placement = placement;
        this.modid = modid;
        this.singletonVariant = singletonVariant;
        this.registerVariants = registerVariants;
    }
    protected static final Set<HeadType> HEADS = new HashSet<>();
    protected static final Map<String, HeadType> HEADS_MAP = new HashMap<>();
    protected static final Map<ResourceLocation, HeadType> HEADS_BLOCK_MAP = new HashMap<>();
    private final String name;
    private final PlacementType placement;

    private final String modid;
    @OnlyIn(Dist.CLIENT)
    public Supplier<Function<ModelPart, EntityModel<? extends Entity>>> modelSupplier;
    public String modelLocation;
    private IVariant singletonVariant;
    private final Map<IVariant, Pair<RegistrySupplier<GenericSkullBlock>,
    RegistrySupplier<ItemBlockHeadType>>> heads = new HashMap<>();
    //private final Set<RegistrySupplier<ItemBlockHeadType>> items = new HashSet<>();
    private final Set<RegistrySupplier<GenericSkullBlock>> blocks = new HashSet<>();
    private final Map<ResourceLocation, IVariant> reverseVariantMap = new HashMap<>();
    private final Consumer<RegistrarManager> registerVariants;

   /* public HeadType(String modid, CreativeModeTab group, String name, PlacementType placement
            , HeadIDMapping mapping, @Nullable Function<IVariant, String> variantMapper,
                    @Nullable IVariant singletonVariant, @Nullable String singletonID,
                    EntityTypeContainer<? extends LivingEntity> container) {
        this.name = name;
        this.modid = modid;
        this.placement = placement;
        this.container = container;
        if (!container.hasVariants() && mapping != HeadIDMapping.SINGLETON) {
            throw new RuntimeException("Tried to create non-singleton head type with a variantless entity!");
        }
        this.registerVariants = (registries) -> {
            switch (mapping) {
                case NAMES:
                    for (IVariant variant : container.getVariants()) {
                        if (variant.hasHead()) {
                            setupVariant(registries, variant, group, variant.getName());
                        }
                    }
                    break;
                case NUMBERS:
                    for (IVariant variant : container.getVariants()) {
                        if (variant.hasHead()) {
                            setupVariant(registries, variant, group, String.valueOf(container.getVariants().indexOf(variant) + 1));
                        }
                    }
                    break;
                case CUSTOM:
                    for (IVariant variant : container.getVariants()) {
                        if (variant.hasHead()) {
                            setupVariant(registries, variant, group, variantMapper.apply(variant));
                        }
                    }
                    break;
                case SINGLETON:
                    setupVariant(registries, singletonVariant, group, singletonID);
                    this.singletonVariant = singletonVariant;
                    break;
                default:
                    break;
            }
        };
        HEADS.add(this);
        HEADS_MAP.put(name, this);
    }*/

    public static Set<HeadType> values() {
        return HEADS;
    }

    public Set<RegistrySupplier<GenericSkullBlock>> getBlockObjects() {
        return blocks;
    }

    public static GenericSkullBlock[] getAllBlocks() {
        return HeadType.values().stream().map(type ->
                type.getBlockObjects()).flatMap(Collection::stream).map(Supplier::get)
                .collect(Collectors.toList()).toArray(new GenericSkullBlock[0]);
    }
    public Pair<RegistrySupplier<GenericSkullBlock>,
            RegistrySupplier<ItemBlockHeadType>> getPairForVariant(IVariant variant) {
        return heads.get(variant);
    }
   public RegistrySupplier<ItemBlockHeadType> getItemForVariant(IVariant variant) {
       if (getPairForVariant(variant) == null)
           return null;
       return getPairForVariant(variant).getRight();
   }

    public HeadBlockEntity createTE(BlockPos pos, BlockState state) {
        return new HeadBlockEntity(this, pos, state);
    }

    public String getName() {
        return name;
    }

    public PlacementType getPlacementType() {
        return placement;
    }

   @OnlyIn(Dist.CLIENT)
    public Supplier<Function<ModelPart, EntityModel<? extends Entity>>> getModelSupplier() {
        return modelSupplier;
    }

    public String getModelLocation() {
        return modelLocation;
    }

    public EntityTypeContainer<? extends LivingEntity> getContainer() {
        return this.container;
    }

    public IVariant getSingletonVariant() {
        return this.singletonVariant;
    }

    public void drop(Mob entity, int chance) {
        drop(entity, chance, getHeadID(entity).orElse(null));
    }

    public void drop(Mob entity, int chance, IVariant variant) {
        if (variant != null && !entity.level().isClientSide && !entity.isBaby()) {
            if (entity.getRandom().nextInt(chance) == 0) {
                ItemStack stack = new ItemStack(this.getItemForVariant(variant).get());
                entity.spawnAtLocation(stack, 0.5F);
            }
        }
    }
    private Optional<IVariant> getHeadID(Mob entity) {
        if (entity instanceof IVariantTypes<?> && this.container.hasVariants()) {
            IVariantTypes<?> ent = (IVariantTypes<?>) entity;
            return ent.getVariant();
        } else {
            return Optional.of(this.singletonVariant);
        }
    }

    public String getMod() {
        return this.modid;
    }

    public enum PlacementType {
        FLOOR_AND_WALL,
        WALL_ONLY
    }

    public enum HeadIDMapping {
        NAMES,
        NUMBERS,
        CUSTOM,
        SINGLETON
    }

    public static class Builder<T extends Mob, C extends EntityTypeContainer<T>,
            B extends IEntityBuilder<T, C, B>> {

    }
}
