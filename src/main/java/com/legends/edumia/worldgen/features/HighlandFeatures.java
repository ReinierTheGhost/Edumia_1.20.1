package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import com.legends.edumia.util.ModTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.VegetationPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import static net.minecraft.data.worldgen.features.CaveFeatures.MOSS_VEGETATION;

public class HighlandFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PILLAR = registryKey("highland/pillar");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAKE = registryKey("highland/lake");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_GRAVEL = registryKey("highland/disk_gravel");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PILLAR, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(ModTags.Blocks.SOIL_STONE,
                BlockStateProvider.simple(Blocks.STONE), PlacementUtils.inlinePlaced(holdergetter.getOrThrow(MOSS_VEGETATION)),
                CaveSurface.FLOOR, ConstantInt.of(1), 0F, 9, 1.0F,
                BiasedToBottomInt.of(0, 2), 0.5F));

        register(context, LAKE, Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(ModTags.Blocks.SOIL_STONE,
                BlockStateProvider.simple(Blocks.STONE), PlacementUtils.inlinePlaced(holdergetter.getOrThrow(MOSS_VEGETATION)),
                CaveSurface.FLOOR, ConstantInt.of(1), 0F, 9, 0.05F,
                BiasedToBottomInt.of(1, 2), 0.5F));

        register(context, DISK_GRAVEL, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRAVEL), BlockPredicate
                .matchesBlocks(Blocks.DIRT, Blocks.GRASS_BLOCK), UniformInt.of(4, 8), 2));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registryKey(String name){
        return  ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Edumia.MODID, name));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registryMinecraftKey(String name){
        return  ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation (ResourceLocation.DEFAULT_NAMESPACE, name));
    }


    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register
            (BootstapContext<ConfiguredFeature<?, ?>> context,
             ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
