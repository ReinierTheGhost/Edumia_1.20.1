package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.ModPlacedFeatures;
import com.legends.edumia.worldgen.placement.ForestPlacement;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ForestFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> BEACHES_KEY = registryKey("forest/flower/beaches");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOUD_TREE_KEY = registryKey("forest/flower/cloud_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLOUD_TREES_KEY = registryKey("forest/flower/cloud_trees");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_TINY_KEY = registryKey("forest/flower/tiny/oak_tiny");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_TINY_KEY = registryKey("forest/flower/tiny/trees_tiny");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_SMALL_KEY = registryKey("forest/flower/small/birch_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_SMALL_KEY = registryKey("forest/flower/small/oak_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_SMALL_M_KEY = registryKey("forest/flower/small/oak_small_m");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_SMALL_KEY = registryKey("forest/flower/small/trees_small");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_MID_KEY = registryKey("forest/flower/mid/birch_mid");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_MID_KEY = registryKey("forest/flower/mid/oak_mid");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_MID_M_KEY = registryKey("forest/flower/mid/oak_mid_m");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_MID_KEY = registryKey("forest/flower/mid/trees_mid");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_TALL_KEY = registryKey("forest/flower/tall/birch_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_TALL_KEY = registryKey("forest/flower/tall/trees_tall");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        HolderGetter<PlacedFeature> holdergetter = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> holder = holdergetter.getOrThrow(ModPlacedFeatures.NOTING_PLACED_KEY);
        Holder<PlacedFeature> holder1 = holdergetter.getOrThrow(ForestPlacement.CLOUD_TREE_PLACED_KEY);
        Holder<PlacedFeature> holder2 = holdergetter.getOrThrow(ForestPlacement.OAK_TINY_PLACED_KEY);
        Holder<PlacedFeature> holder3 = holdergetter.getOrThrow(ForestPlacement.BIRCH_SMALL_PLACED_KEY);
        Holder<PlacedFeature> holder4 = holdergetter.getOrThrow(ForestPlacement.OAK_SMALL_PLACED_KEY);
        Holder<PlacedFeature> holder5 = holdergetter.getOrThrow(ForestPlacement.OAK_SMALL_M_PLACED_KEY);
        Holder<PlacedFeature> holder6 = holdergetter.getOrThrow(ForestPlacement.BIRCH_MID_PLACED_KEY);
        Holder<PlacedFeature> holder7 = holdergetter.getOrThrow(ForestPlacement.OAK_MID_PLACED_KEY);
        Holder<PlacedFeature> holder8 = holdergetter.getOrThrow(ForestPlacement.OAK_MID_M_PLACED_KEY);
        Holder<PlacedFeature> holder9 = holdergetter.getOrThrow(ForestPlacement.BIRCH_TALL_PLACED_KEY);

        BeehiveDecorator beehivedecorator = new BeehiveDecorator(0.01F);
        BeehiveDecorator beehivedecorator1 = new BeehiveDecorator(0.03F);
        AlterGroundDecorator alterGroundDecorator = new AlterGroundDecorator(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(Blocks.GRASS_BLOCK.defaultBlockState(), 2)));

        register(context, BEACHES_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration
                (List.of(new WeightedPlacedFeature(holder1, 0F)), holder));

        register(context, CLOUD_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG), new ForkingTrunkPlacer(2, 8, 4),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.AZALEA_LEAVES.defaultBlockState(), 5)
                        .add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 2),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().forceDirt().decorators(List.of(beehivedecorator)).build());

        register(context, CLOUD_TREES_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration
                (List.of(new WeightedPlacedFeature(holder1, 0.6F)), holder));


        register(context, OAK_TINY_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(3, 2, 0),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.AZALEA_LEAVES.defaultBlockState(), 8)
                        .add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                new TwoLayersFeatureSize(2, 1, 2)).ignoreVines().decorators(List.of(beehivedecorator1)).build());

        register(context, TREES_TINY_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration
                (List.of(new WeightedPlacedFeature(holder3, 0.25F), new WeightedPlacedFeature(holder5, 0.1F)), holder2));


        register(context, BIRCH_SMALL_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.BIRCH_LOG), new StraightTrunkPlacer(4, 2, 1),
                BlockStateProvider.simple(Blocks.BIRCH_LEAVES),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().decorators(List.of(beehivedecorator1)).build());

        register(context, OAK_SMALL_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(4, 2, 2),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.AZALEA_LEAVES.defaultBlockState(), 6)
                        .add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1)),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().decorators(List.of(beehivedecorator1)).build());

        register(context, OAK_SMALL_M_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG), new FancyTrunkPlacer(5, 2, 2),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.AZALEA_LEAVES.defaultBlockState(), 6)
                        .add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1)),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(3), 3),
                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().decorators(List.of(beehivedecorator1)).build());

        register(context, TREES_SMALL_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration
                (List.of(new WeightedPlacedFeature(holder3, 0.25F), new WeightedPlacedFeature(holder5, 0.2F)), holder4));


        register(context, BIRCH_MID_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.BIRCH_LOG), new StraightTrunkPlacer(5, 2, 3),
                BlockStateProvider.simple(Blocks.BIRCH_LEAVES),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().forceDirt().decorators(List.of(beehivedecorator1))
                .build());

        register(context, OAK_MID_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG), new StraightTrunkPlacer(5, 2, 3),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.AZALEA_LEAVES.defaultBlockState(), 4)
                        .add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1)),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().forceDirt().decorators(List.of(alterGroundDecorator))
                .build());

        register(context, OAK_MID_M_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.OAK_LOG), new FancyTrunkPlacer(8, 2, 3),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.AZALEA_LEAVES.defaultBlockState(), 4)
                        .add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1)),
                new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().decorators(List.of(beehivedecorator1)).build());

        register(context, TREES_MID_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration
                (List.of(new WeightedPlacedFeature(holder6, 0.3F), new WeightedPlacedFeature(holder8, 0.4F)), holder7));


        register(context, BIRCH_TALL_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.BIRCH_LOG), new FancyTrunkPlacer(7, 4, 2),
                BlockStateProvider.simple(Blocks.BIRCH_LEAVES),
                new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().decorators(List.of(beehivedecorator1)).build());

        register(context, TREES_TALL_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration
                (List.of(new WeightedPlacedFeature(holder6, 0.2F), new WeightedPlacedFeature(holder8, 0.4F)), holder8));
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
