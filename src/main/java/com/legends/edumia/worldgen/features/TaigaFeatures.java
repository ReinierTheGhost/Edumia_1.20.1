package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.placement.ModTreePlacements;
import com.legends.edumia.worldgen.placement.TaigaPlaced;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class TaigaFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_TREE = registryKey("taiga/birch/birch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_TREE_SMALL = registryKey("taiga/birch/birch_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_BOULDER = registryKey("taiga/birch/boulder");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_CLOUD_TREE = registryKey("taiga/birch/cloud_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_OAK = registryKey("taiga/birch/oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_POND = registryKey("taiga/birch/pond");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_TREES_SMALL = registryKey("taiga/birch/trees_small");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LUSH_FLOWERS = registryKey("taiga/lush/flowers");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MID_PINE = registryKey("taiga/mid/pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MID_SPRUCE = registryKey("taiga/mid/spruce");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MID_SPRUCE_M = registryKey("taiga/mid/spruce_m");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MID_TREES = registryKey("taiga/mid/trees");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SIBERIAN_TALL_TREE = registryKey("taiga/siberian/tall_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SIBERIAN_TALL_TREE_ORANGE = registryKey("taiga/siberian/tall_tree_orange");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SIBERIAN_TREES = registryKey("taiga/siberian/trees");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SIBERIAN_NEW_TREES = registryKey("taiga/siberian/trees_new");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SIBERIAN_NEW_TREES_ORANGE = registryKey("taiga/siberian/trees_new_orange");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SIBERIAN_TREES_ORANGE = registryKey("taiga/siberian/trees_orange");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PINE = registryKey("taiga/small/pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_SPRUCE = registryKey("taiga/small/spruce");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_SPRUCE_M = registryKey("taiga/small/spruce_m");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_TREES = registryKey("taiga/small/trees");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_PINE = registryKey("taiga/tall/pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SPRUCE = registryKey("taiga/tall/spruce");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_SPRUCE_M = registryKey("taiga/tall/spruce_m");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_TREES = registryKey("taiga/tall/trees");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TINY_PINE = registryKey("taiga/tiny/pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TINY_SPRUCE = registryKey("taiga/tiny/spruce");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TINY_SPRUCE_M = registryKey("taiga/tiny/spruce_m");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TINY_TREES = registryKey("taiga/tiny/trees");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){

        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> holder = placedFeatureHolderGetter.getOrThrow(TaigaPlaced.SIBERIAN_TALL_TREE);
        Holder<PlacedFeature> holder2 = placedFeatureHolderGetter.getOrThrow(TaigaPlaced.SIBERIAN_TREES);
        Holder<PlacedFeature> holder3 = placedFeatureHolderGetter.getOrThrow(TaigaPlaced.SIBERIAN_NEW_TREES);
        Holder<PlacedFeature> holder4 = placedFeatureHolderGetter.getOrThrow(TaigaPlaced.SIBERIAN_TALL_TREE_ORANGE);
        Holder<PlacedFeature> holder5 = placedFeatureHolderGetter.getOrThrow(TaigaPlaced.SIBERIAN_TREES_ORANGE);
        Holder<PlacedFeature> holder6 = placedFeatureHolderGetter.getOrThrow(TaigaPlaced.SIBERIAN_NEW_TREES_ORANGE);

        register(context, SIBERIAN_TALL_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.SPRUCE_LOG),
                new StraightTrunkPlacer(10, 4, 8),
                BlockStateProvider.simple(Blocks.SPRUCE_LEAVES),
                new PineFoliagePlacer(UniformInt.of(4, 6), ConstantInt.of(1), ConstantInt.of(4)),
                new TwoLayersFeatureSize(0,0,0)).dirt(BlockStateProvider.simple(Blocks.DIRT)).ignoreVines().build());

        register(context, SIBERIAN_TALL_TREE_ORANGE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.DARK_OAK_LOG),
                new StraightTrunkPlacer(10, 4, 12),
                BlockStateProvider.simple(Blocks.DARK_OAK_LEAVES),
                new MegaPineFoliagePlacer(UniformInt.of(0, 1), ConstantInt.of(1), UniformInt.of(3, 8)),
                new TwoLayersFeatureSize(1,0,1)).dirt(BlockStateProvider.simple(Blocks.DIRT)).ignoreVines().build());

        register(context, SIBERIAN_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(holder2, 0.6F)), holder3));

        register(context, SIBERIAN_TREES_ORANGE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                new WeightedPlacedFeature(holder6, 0.6F)), holder5));

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
