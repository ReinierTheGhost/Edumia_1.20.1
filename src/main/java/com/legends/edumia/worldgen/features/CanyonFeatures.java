package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.InclusiveRange;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.DualNoiseProvider;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class CanyonFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> CLIFF_KEY = registryKey("canyon/blooming/cliff");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERS_KEY = registryKey("canyon/blooming/flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERS_WHITE_KEY = registryKey("canyon/blooming/flowers_white");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CLIFF_2_KEY = registryKey("canyon/generic/cliff");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SLAB_STONE = registryKey("canyon/generic/slab_stone");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SANDSTONE_CLIFF_KEY = registryKey("canyon/sandstone/cliff");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SANDSTONE_SANDSTONE_KEY = registryKey("canyon/sandstone/sandstone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SANDSTONE_SLAB_KEY = registryKey("canyon/sandstone/slab");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SANDSTONE_SLAB_SMOOTH_KEY = registryKey("canyon/sandstone/slab_smooth");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SANDSTONE_LAKES_KEY = registryKey("canyon/sandstone/lakes");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<Block> blockHolderGetter = context.lookup(Registries.BLOCK);

        RuleTest stone = new BlockMatchTest(Blocks.STONE);
        List<OreConfiguration.TargetBlockState> sandstone = List.of(OreConfiguration.target(stone,
                Blocks.SANDSTONE.defaultBlockState()));

        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);

        Holder<PlacedFeature> holder = placedFeatureHolderGetter.getOrThrow(TreePlacements.OAK_CHECKED);

        register(context, CLIFF_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration
                (List.of(new WeightedPlacedFeature(holder, 0F)), holder));

        register(context, FLOWERS_KEY, Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new DualNoiseProvider(new InclusiveRange<>(1, 1),
                        new NormalNoise.NoiseParameters(-8, 1.1D, 1.3D, 2D, 2.4D), 1.0F,
                        2345L, new NormalNoise.NoiseParameters(-4, 0.01D, 0.005D, 0.04D), 1.0F,
                        List.of(Blocks.ALLIUM.defaultBlockState(), Blocks.PINK_TULIP.defaultBlockState(), Blocks.CORNFLOWER.defaultBlockState(),
                                Blocks.WHITE_TULIP.defaultBlockState(), Blocks.DANDELION.defaultBlockState(), Blocks.ORANGE_TULIP.defaultBlockState(),
                                Blocks.RED_TULIP.defaultBlockState()))))));

        register(context, FLOWERS_WHITE_KEY, Feature.FLOWER, new RandomPatchConfiguration(55, 8, 2,
                PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new DualNoiseProvider(new InclusiveRange<>(1, 1),
                        new NormalNoise.NoiseParameters(-7, 1.6D, 1.3D, 2D, 3.5D, 0D, 2D, 1D), 1.0F,
                        2345L, new NormalNoise.NoiseParameters(-4, 0.01D, 0.02D, 0.03D), 1.0F,
                        List.of(Blocks.OXEYE_DAISY.defaultBlockState(), Blocks.AZURE_BLUET.defaultBlockState(),
                                Blocks.LILY_OF_THE_VALLEY.defaultBlockState(), Blocks.WHITE_TULIP.defaultBlockState()))))));

        register(context, CLIFF_2_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration
                (List.of(new WeightedPlacedFeature(holder, 0F)), holder));

        register(context, SLAB_STONE, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.STONE_SLAB)));


        register(context, SANDSTONE_CLIFF_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration
                (List.of(new WeightedPlacedFeature(holder, 0F)), holder));

        register(context, SANDSTONE_SANDSTONE_KEY, Feature.ORE, new OreConfiguration(sandstone, 64));

        register(context, SANDSTONE_SLAB_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SANDSTONE_SLAB)));

        register(context, SANDSTONE_SLAB_SMOOTH_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SMOOTH_SANDSTONE_SLAB)));

        register(context, SANDSTONE_LAKES_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration
                (List.of(new WeightedPlacedFeature(holder, 0F)), holder));
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
