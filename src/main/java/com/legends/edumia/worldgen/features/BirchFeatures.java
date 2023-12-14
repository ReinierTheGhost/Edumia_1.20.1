package com.legends.edumia.worldgen.features;

import com.google.common.collect.ImmutableList;
import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.worldgen.ModPlacedFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class BirchFeatures {

        public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_TALL_KEY = registryKey("birch/birch_tall");
        public static final ResourceKey<ConfiguredFeature<?, ?>> CLOUD_TREE_TALL_KEY = registryKey("birch/cloud_tree_tall");
        public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_STONE_KEY = registryKey("birch/disk_stone");
        public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_TREE_BASE_KEY = registryKey("birch/fallen_tree_base");
        public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERS_KEY = registryKey("birch/flowers");
        public static final ResourceKey<ConfiguredFeature<?, ?>> MINECON_FLOWERS_KEY = registryKey("birch/minecon_flowers");
        public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_LOG_BASE_KEY = registryKey("birch/tree_log_base");
        public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_LOG_EXTRA_BASE_KEY = registryKey("birch/tree_log_extra_base");
        public static final ResourceKey<ConfiguredFeature<?, ?>> TREE_MOSS_BASE_KEY = registryKey("birch/tree_moss_base");
        public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_1_KEY = registryKey("birch/trees_1");
        public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_FOREST_KEY = registryKey("birch/trees_forest");


        private static TreeConfiguration.TreeConfigurationBuilder createForkedBlobTree
                (Block block, Block block1, int base_height, int height_rand_a, int height_rand_b, int radius) {
                return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(block),
                        new ForkingTrunkPlacer(base_height, height_rand_a, height_rand_b),
                        BlockStateProvider.simple(block1), new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(2), 2),
                        new TwoLayersFeatureSize(1, 0, 1));
        }
        private static TreeConfiguration.TreeConfigurationBuilder createBirch() {
                return createForkedBlobTree(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 5, 4, 8, 2).ignoreVines();
        }
        public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){

                HolderGetter<PlacedFeature> holdergetter = context.lookup(Registries.PLACED_FEATURE);
                Holder<PlacedFeature> holder = holdergetter.getOrThrow(TreePlacements.SUPER_BIRCH_BEES_0002);
                Holder<PlacedFeature> holder1 = holdergetter.getOrThrow(ModPlacedFeatures.CLOUD_TREE_TALL_PLACED_KEY);
                Holder<PlacedFeature> holder2 = holdergetter.getOrThrow(TreePlacements.FANCY_OAK_CHECKED);

                BeehiveDecorator beehivedecorator = new BeehiveDecorator(0.03F);

                register(context, BIRCH_TALL_KEY, Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder, 0.5F)), holder1));

                register(context, CLOUD_TREE_TALL_KEY, Feature.TREE, createBirch().decorators(List.of(beehivedecorator)).build());


                //should also have a random selector on top
                register(context, DISK_STONE_KEY, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.STONE),
                                BlockPredicate.matchesBlocks(Blocks.GRASS_BLOCK, Blocks.DIRT),
                        UniformInt.of(3, 5), 2));

                //is a simple random selector
                register(context, FALLEN_TREE_BASE_KEY, Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder, 0.5F)), holder1));

                register(context, FLOWERS_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 8, 3,
                        PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.DANDELION)),
                                BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks
                                (new BlockPos(0, -1, 0), Blocks.GRASS_BLOCK))))));

                register(context, MINECON_FLOWERS_KEY, Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder, 0.5F)), holder1));

                register(context, TREE_LOG_BASE_KEY, Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder, 0.5F)), holder1));

                register(context, TREE_LOG_EXTRA_BASE_KEY, Feature.RANDOM_SELECTOR,
                        new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder, 0.5F)), holder1));

                register(context, TREE_MOSS_BASE_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                        BlockStateProvider.simple(Blocks.MOSS_BLOCK)));

                register(context, TREES_1_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockLoader.WHITE_ASH_LOG.get()),
                        new GiantTrunkPlacer(13, 2, 10),
                        BlockStateProvider.simple(BlockLoader.WHITE_ASH_LEAVES.get()),
                        new MegaPineFoliagePlacer(UniformInt.of(0, 2), ConstantInt.of(9), UniformInt.of(13, 17)),
                        new TwoLayersFeatureSize(1, 1, 2)
                ).decorators(ImmutableList.of(new AlterGroundDecorator(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(Blocks.CALCITE.defaultBlockState(), 1).add(Blocks.GRASS_BLOCK.defaultBlockState(), 2))))).ignoreVines().build());

                register(context, TREES_FOREST_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockLoader.SILVER_SPRUCE_LOG.get()),
                        new StraightTrunkPlacer(4, 3, 6),
                        BlockStateProvider.simple(BlockLoader.SILVER_SPRUCE_LEAVES.get()),
                        new PineFoliagePlacer(UniformInt.of(2, 3), ConstantInt.of(1), ConstantInt.of(3)),
                        new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());

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
