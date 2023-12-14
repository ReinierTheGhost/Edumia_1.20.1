package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.worldgen.ModPlacedFeatures;
import com.legends.edumia.worldgen.placement.ModTreePlacements;
import com.legends.edumia.worldgen.tree.foliageplacers.AspenFoliagePlacer;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MangrovePropaguleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.rootplacers.AboveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;
import java.util.Optional;

public class ModTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_OAK_KEY  = registryKey("green_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_KEY = registryKey("aspen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEQUOIA_KEY = registryKey("sequoia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_BAOBAB_TRUNK_KEY = registryKey("baobab/large/trunk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_BAOBAB_CANOPY_KEY = registryKey("baobab/large/canopy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_BAOBAB_BUILDER_KEY = registryKey("baobab/large/tree_builder");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EMPTY_KEY = registryKey("baobab/empty");

    @SuppressWarnings("deprecated")
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<Block> blockHolderGetter = context.lookup(Registries.BLOCK);

        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> holder = placedFeatureHolderGetter.getOrThrow(ModTreePlacements.LARGE_BAOBAB_CANOPY_KEY);
        Holder<PlacedFeature> holder1 = placedFeatureHolderGetter.getOrThrow(ModTreePlacements.LARGE_BAOBAB_TRUNK_KEY);
        Holder<PlacedFeature> holder2 = placedFeatureHolderGetter.getOrThrow(ModTreePlacements.EMPTY_KEY);

        LeaveVineDecorator leaveVineDecorator = new LeaveVineDecorator(0.5f);

        AlterGroundDecorator alterGroundDecorator = new AlterGroundDecorator(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(Blocks.GRASS_BLOCK.defaultBlockState(), 3).add(Blocks.COARSE_DIRT.defaultBlockState(), 2)
                .add(Blocks.ROOTED_DIRT.defaultBlockState(), 1)));

        register(context, GREEN_OAK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockLoader.GREEN_OAK_LOG.get()), new DarkOakTrunkPlacer(5, 4, 6),
                BlockStateProvider.simple(BlockLoader.GREEN_OAK_LEAVES.get()),
                new RandomSpreadFoliagePlacer(UniformInt.of(9, 11),UniformInt.of(0,1),
                        UniformInt.of(2, 4), 250),
                Optional.of(new MangroveRootPlacer(UniformInt.of(4, 7), BlockStateProvider.simple(BlockLoader.GREEN_OAK_WOOD.get()),
                        Optional.of(new AboveRootPlacement(BlockStateProvider.simple(Blocks.MOSS_CARPET), 0.5F)),
                        new MangroveRootPlacement(blockHolderGetter.getOrThrow(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH),
                                HolderSet.direct(Block::builtInRegistryHolder, Blocks.MUD, Blocks.MUDDY_MANGROVE_ROOTS),
                                BlockStateProvider.simple(Blocks.MUDDY_MANGROVE_ROOTS), 10, 30, 0F))),
                new TwoLayersFeatureSize(3, 2, 3)).ignoreVines().decorators(List.of(alterGroundDecorator)).build());

        register(context, SEQUOIA_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(15, 1, 3, PlacementUtils.inlinePlaced(
                Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(BlockLoader.PINE_LOG.get()),
                        new GiantTrunkPlacer(32, 22, 24),
                        BlockStateProvider.simple(BlockLoader.PINE_LEAVES.get()),
                        new MegaPineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0),  ConstantInt.of(8)),
                        new TwoLayersFeatureSize(0,0,0)).build()
        )));

        register(context, ASPEN_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockLoader.ASPEN_LOG.get()),
                new StraightTrunkPlacer(8, 7, 0),
                BlockStateProvider.simple(BlockLoader.ASPEN_LEAVES.get()),
                new AspenFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2),
                        UniformInt.of(2,2)),
                new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());


        register(context, LARGE_BAOBAB_TRUNK_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(50, 1, 2,
                PlacementUtils.inlinePlaced(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockLoader.GREEN_OAK_LOG.get()), new DarkOakTrunkPlacer(5, 4, 6),
                        BlockStateProvider.simple(BlockLoader.GREEN_OAK_LEAVES.get()),
                        new RandomSpreadFoliagePlacer(UniformInt.of(9, 11),UniformInt.of(0,1),
                                UniformInt.of(2, 4), 250),
                        Optional.of(new MangroveRootPlacer(UniformInt.of(4, 7), BlockStateProvider.simple(BlockLoader.GREEN_OAK_WOOD.get()),
                                Optional.of(new AboveRootPlacement(BlockStateProvider.simple(Blocks.MOSS_CARPET), 0.5F)),
                                new MangroveRootPlacement(blockHolderGetter.getOrThrow(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH),
                                        HolderSet.direct(Block::builtInRegistryHolder, BlockLoader.GREEN_OAK_LOG.get()),
                                        BlockStateProvider.simple(BlockLoader.GREEN_OAK_LOG.get()), 3, 15, 0.25F))),
                        new TwoLayersFeatureSize(3, 2, 3)).ignoreVines().decorators(List.of(alterGroundDecorator)).build())));

        register(context, LARGE_BAOBAB_CANOPY_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(2, 1, 0,
                PlacementUtils.inlinePlaced(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(BlockLoader.GREEN_OAK_LOG.get()), new ForkingTrunkPlacer(17, 1, 2),
                        BlockStateProvider.simple(BlockLoader.GREEN_OAK_LEAVES.get()),
                        new AcaciaFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1)),
                        new TwoLayersFeatureSize(0, 0, 0)).ignoreVines().dirt(BlockStateProvider.simple
                        (BlockLoader.GREEN_OAK_LOG.get())).build())));

        register(context, LARGE_BAOBAB_BUILDER_KEY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(35, 0, 0,
                PlacementUtils.inlinePlaced(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of
                        (new WeightedPlacedFeature(holder, 0.6F), new WeightedPlacedFeature(holder1, 0.4f)), holder2))));

        register(context, EMPTY_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.AIR)));

    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registryKey(String name){
        return  ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(Edumia.MODID, name));
    }


    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register
            (BootstapContext<ConfiguredFeature<?, ?>> context,
             ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
