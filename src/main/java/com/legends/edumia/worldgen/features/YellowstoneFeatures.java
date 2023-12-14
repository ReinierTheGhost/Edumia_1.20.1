package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import com.legends.edumia.util.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.OptionalInt;

public class YellowstoneFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> ACID_BASALT = registryKey("yellowstone/acid_basalt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ACID_BLACK = registryKey("yellowstone/acid_black");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ACID_GRAVEL = registryKey("yellowstone/acid_gravel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ACID_ORANGE = registryKey("yellowstone/acid_orange");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ACID_YELLOW = registryKey("yellowstone/acid_yellow");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH = registryKey("yellowstone/birch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_ALT = registryKey("yellowstone/birch_alt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAKES = registryKey("yellowstone/lakes");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGMA = registryKey("yellowstone/magma");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_BIG = registryKey("yellowstone/spruce_big");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_BIG_ALT = registryKey("yellowstone/spruce_big_alt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TERRA_SAND = registryKey("yellowstone/terra_sand");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VENTS = registryKey("yellowstone/vents");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<Block> blockHolderGetter = context.lookup(Registries.BLOCK);
        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> holder = placedFeatureHolderGetter.getOrThrow(TreePlacements.OAK_CHECKED);
        Holder<PlacedFeature> holder1 = placedFeatureHolderGetter.getOrThrow(TreePlacements.FANCY_OAK_CHECKED);

        register(context, ACID_BASALT, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple
                (Blocks.SMOOTH_BASALT), BlockPredicate.matchesBlocks(Blocks.GRAVEL, Blocks.COARSE_DIRT, Blocks.SAND,
                        Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.CALCITE), UniformInt.of(4, 6), 3));

        register(context, ACID_BLACK, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple
                (Blocks.BLACKSTONE), BlockPredicate.matchesBlocks(Blocks.GRAVEL, Blocks.COARSE_DIRT, Blocks.SAND,
                Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.CALCITE, Blocks.SMOOTH_BASALT), UniformInt.of(3, 4), 2));

        register(context, ACID_GRAVEL, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple
                (Blocks.GRAVEL), BlockPredicate.matchesBlocks(Blocks.COARSE_DIRT, Blocks.SAND,
                Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.CALCITE), UniformInt.of(4, 8), 4));

        register(context, ACID_ORANGE, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple
                (Blocks.RED_SAND), BlockPredicate.matchesBlocks(Blocks.GRAVEL, Blocks.COARSE_DIRT, Blocks.SAND,
                Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.CALCITE, Blocks.SMOOTH_BASALT, Blocks.BLACKSTONE),
                UniformInt.of(2, 3), 1));

        register(context, ACID_YELLOW, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple
                (Blocks.RED_SAND), BlockPredicate.matchesBlocks(Blocks.GRAVEL, Blocks.COARSE_DIRT, Blocks.SAND,
                Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.CALCITE, Blocks.BASALT, Blocks.BLACKSTONE, Blocks.RED_SAND),
                UniformInt.of(1,1), 0));

        register(context, BIRCH , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.BIRCH_LOG),
                new StraightTrunkPlacer(5,2,3),
                BlockStateProvider.simple(Blocks.BIRCH_LEAVES),
                new SpruceFoliagePlacer(UniformInt.of(2,2), UniformInt.of(0,2),
                        UniformInt.of(0,1)),
                new TwoLayersFeatureSize(1, 0, 0, OptionalInt.of(0))
        ).ignoreVines().dirt(BlockStateProvider.simple(Blocks.COARSE_DIRT.defaultBlockState())).forceDirt().build());

        register(context, BIRCH_ALT, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.BIRCH_LOG),
                new StraightTrunkPlacer(5,2,2),
                BlockStateProvider.simple(Blocks.BIRCH_LEAVES),
                new PineFoliagePlacer(UniformInt.of(1,2), UniformInt.of(0,1),
                        UniformInt.of(1,3)),
                new TwoLayersFeatureSize(1, 0, 0, OptionalInt.of(0))
        ).ignoreVines().dirt(BlockStateProvider.simple(Blocks.COARSE_DIRT.defaultBlockState())).forceDirt().build());

        register(context, LAKES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                List.of(new WeightedPlacedFeature(holder, 0.85F)), holder1));

        register(context, MAGMA, Feature.UNDERWATER_MAGMA,
                new UnderwaterMagmaConfiguration(2, 3, 0.3f));

        register(context, SPRUCE_BIG, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.SPRUCE_LOG),
                new StraightTrunkPlacer(8,2,9),
                BlockStateProvider.simple(Blocks.SPRUCE_LEAVES),
                new MegaPineFoliagePlacer(UniformInt.of(0,1), UniformInt.of(1,3),
                        UniformInt.of(12,17)),
                new TwoLayersFeatureSize(1, 0, 0, OptionalInt.of(0))
        ).ignoreVines().dirt(BlockStateProvider.simple(Blocks.COARSE_DIRT.defaultBlockState())).forceDirt().build());

        register(context, SPRUCE_BIG_ALT, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.SPRUCE_LOG),
                new StraightTrunkPlacer(6,2,7),
                BlockStateProvider.simple(Blocks.SPRUCE_LEAVES),
                new SpruceFoliagePlacer(UniformInt.of(2,3), UniformInt.of(0,2),
                        UniformInt.of(1,3)),
                new TwoLayersFeatureSize(1, 0, 0, OptionalInt.of(0))
        ).ignoreVines().dirt(BlockStateProvider.simple(Blocks.COARSE_DIRT.defaultBlockState())).forceDirt().build());

        register(context, TERRA_SAND, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                BlockStateProvider.simple(Blocks.RED_SAND)));

        register(context, VENTS, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(
                SimpleWeightedRandomList.<BlockState>builder().add(Blocks.CAMPFIRE.defaultBlockState(), 3)
                        .add(Blocks.CAMPFIRE.defaultBlockState(), 1))));
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
