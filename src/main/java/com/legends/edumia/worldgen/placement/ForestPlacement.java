package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.features.ForestFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.minecraft.core.Vec3i.ZERO;

public class ForestPlacement {

    public static final ResourceKey<PlacedFeature> BEACHES_PLACED_KEY = registerKey("forest/flower/beaches");
    public static final ResourceKey<PlacedFeature> CLOUD_TREE_PLACED_KEY = registerKey("forest/flower/cloud_tree");
    public static final ResourceKey<PlacedFeature> CLOUD_TREES_PLACED_KEY = registerKey("forest/flower/cloud_trees");


    public static final ResourceKey<PlacedFeature> OAK_TINY_PLACED_KEY = registerKey("forest/flower/tiny/oak_tiny");
    public static final ResourceKey<PlacedFeature> TREES_TINY_PLACED_KEY = registerKey("forest/flower/tiny/trees_tiny");

    public static final ResourceKey<PlacedFeature> BIRCH_SMALL_PLACED_KEY = registerKey("forest/flower/small/birch_small");
    public static final ResourceKey<PlacedFeature> OAK_SMALL_PLACED_KEY = registerKey("forest/flower/small/oak_small");
    public static final ResourceKey<PlacedFeature> OAK_SMALL_M_PLACED_KEY = registerKey("forest/flower/small/oak_small_m");
    public static final ResourceKey<PlacedFeature> TREES_SMALL_PLACED_KEY = registerKey("forest/flower/small/trees_small");

    public static final ResourceKey<PlacedFeature> BIRCH_MID_PLACED_KEY = registerKey("forest/flower/mid/birch_mid");
    public static final ResourceKey<PlacedFeature> OAK_MID_PLACED_KEY = registerKey("forest/flower/mid/oak_mid");
    public static final ResourceKey<PlacedFeature> OAK_MID_M_PLACED_KEY = registerKey("forest/flower/mid/oak_mid_m");
    public static final ResourceKey<PlacedFeature> TREES_MID_PLACED_KEY = registerKey("forest/flower/mid/trees_mid");

    public static final ResourceKey<PlacedFeature> BIRCH_TALL_PLACED_KEY = registerKey("forest/flower/tall/birch_tall");
    public static final ResourceKey<PlacedFeature> TREES_TALL_PLACED_KEY = registerKey("forest/flower/tall/trees_tall");
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, BEACHES_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.BEACHES_KEY),
                List.of(PlacementUtils.countExtra(160, 0.01f, 0), InSquarePlacement.spread(),
                        NoiseBasedCountPlacement.of(1, 144D, 0.4D),
                        RarityFilter.onAverageOnceEvery(1), HeightRangePlacement.of(ConstantHeight.of(VerticalAnchor.absolute(62))),
                        BiomeFilter.biome()));

        register(context, CLOUD_TREE_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.CLOUD_TREE_KEY),
                List.of());

        register(context, CLOUD_TREES_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.CLOUD_TREES_KEY),
                List.of(CountPlacement.of(2), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 0), Blocks.AIR),
                                BlockPredicate.wouldSurvive(Blocks.FERN.defaultBlockState(), ZERO))),
                        BiomeFilter.biome()));


        register(context, OAK_TINY_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.OAK_TINY_KEY),
                List.of(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), SurfaceWaterDepthFilter.forMaxDepth(0)));

        register(context, TREES_TINY_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.TREES_TINY_KEY),
                List.of(PlacementUtils.countExtra(6, 0.0111111111111111F, 1), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                        NoiseBasedCountPlacement.of(1, 215, -0.5),
                        NoiseBasedCountPlacement.of(-1, 215, -1), BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 0), Blocks.AIR),
                                BlockPredicate.wouldSurvive(Blocks.FERN.defaultBlockState(), ZERO))),
                        BiomeFilter.biome()));


        register(context, BIRCH_SMALL_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.BIRCH_SMALL_KEY),
                List.of(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), SurfaceWaterDepthFilter.forMaxDepth(0)));

        register(context, OAK_SMALL_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.OAK_SMALL_KEY),
                List.of(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), SurfaceWaterDepthFilter.forMaxDepth(0)));

        register(context, OAK_SMALL_M_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.OAK_SMALL_M_KEY),
                List.of(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), SurfaceWaterDepthFilter.forMaxDepth(0)));

        register(context, TREES_SMALL_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.TREES_SMALL_KEY),
                List.of(PlacementUtils.countExtra(8, 0.0111111111111111F, 1), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                        NoiseBasedCountPlacement.of(1, 215, 0),
                        NoiseBasedCountPlacement.of(-1, 215, -0.5), BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                                BlockPredicate.replaceable(),
                                BlockPredicate.wouldSurvive(Blocks.FERN.defaultBlockState(), ZERO))),
                        BiomeFilter.biome()));


        register(context, BIRCH_MID_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.BIRCH_MID_KEY),
                List.of());

        register(context, OAK_MID_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.OAK_MID_KEY),
                List.of());

        register(context, OAK_MID_M_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.OAK_MID_M_KEY),
                List.of());

        register(context, TREES_MID_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.TREES_MID_KEY),
                List.of(PlacementUtils.countExtra(9, 0.0111111111111111F, 1), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                        NoiseBasedCountPlacement.of(1, 215, 0.5),
                        NoiseBasedCountPlacement.of(-1, 215, 0), BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                                BlockPredicate.replaceable(),
                                BlockPredicate.wouldSurvive(Blocks.FERN.defaultBlockState(), ZERO))),
                        BiomeFilter.biome()));


        register(context, BIRCH_TALL_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.BIRCH_TALL_KEY),
                List.of(HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), SurfaceWaterDepthFilter.forMaxDepth(0)));

        register(context, TREES_TALL_PLACED_KEY, holdergetter.getOrThrow(ForestFeatures.TREES_TALL_KEY),
                List.of(PlacementUtils.countExtra(13, 0.0111111111111111F, 1), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                        NoiseBasedCountPlacement.of(1, 215, 1),
                        NoiseBasedCountPlacement.of(-1, 215, 0.5), BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                                BlockPredicate.replaceable(),
                                BlockPredicate.wouldSurvive(Blocks.FERN.defaultBlockState(), ZERO))),
                        BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Edumia.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
