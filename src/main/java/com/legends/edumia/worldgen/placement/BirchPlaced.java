package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.features.BirchFeatures;
import com.legends.edumia.worldgen.features.CanyonFeatures;
import com.legends.edumia.worldgen.features.MountainsFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.blockpredicates.WouldSurvivePredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.minecraft.core.Vec3i.ZERO;

public class BirchPlaced {

    public static final ResourceKey<PlacedFeature> BIRCH_TALL_KEY = registerKey("birch/birch_tall");
    public static final ResourceKey<PlacedFeature> CLOUD_TREE_TALL_KEY = registerKey("birch/cloud_tree_tall");
    public static final ResourceKey<PlacedFeature> DISK_STONE_KEY = registerKey("birch/disk_stone");
    public static final ResourceKey<PlacedFeature> FALLEN_TREE_BASE_KEY = registerKey("birch/fallen_tree_base");
    public static final ResourceKey<PlacedFeature> FLOWERS_KEY = registerKey("birch/flowers");
    public static final ResourceKey<PlacedFeature> MINECON_FLOWERS_KEY = registerKey("birch/minecon_flowers");
    public static final ResourceKey<PlacedFeature> TREE_LOG_BASE_KEY = registerKey("birch/tree_log_base");
    public static final ResourceKey<PlacedFeature> TREE_LOG_EXTRA_BASE_KEY = registerKey("birch/tree_log_extra_base");
    public static final ResourceKey<PlacedFeature> TREE_MOSS_BASE_KEY = registerKey("birch/tree_moss_base");
    public static final ResourceKey<PlacedFeature> TREES_1_KEY = registerKey("birch/trees_1");
    public static final ResourceKey<PlacedFeature> TREES_FOREST_KEY = registerKey("birch/trees_forest");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, BIRCH_TALL_KEY, holdergetter.getOrThrow(BirchFeatures.BIRCH_TALL_KEY),
                List.of(PlacementUtils.countExtra(10, 0.1111111111111111F, 1),
                        InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR),
                        BiomeFilter.biome()));

        register(context, CLOUD_TREE_TALL_KEY, holdergetter.getOrThrow(BirchFeatures.CLOUD_TREE_TALL_KEY),
                List.of(BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.BIRCH_SAPLING.defaultBlockState(), ZERO))));

        register(context, DISK_STONE_KEY, holdergetter.getOrThrow(BirchFeatures.DISK_STONE_KEY),
                List.of(CountPlacement.of(64), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BiomeFilter.biome()));

        register(context, FALLEN_TREE_BASE_KEY, holdergetter.getOrThrow(BirchFeatures.FALLEN_TREE_BASE_KEY),
                List.of(CountPlacement.of(64), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BiomeFilter.biome()));

        register(context, FLOWERS_KEY, holdergetter.getOrThrow(BirchFeatures.FLOWERS_KEY),
                List.of(CountPlacement.of(64), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BiomeFilter.biome()));

        register(context, MINECON_FLOWERS_KEY, holdergetter.getOrThrow(BirchFeatures.MINECON_FLOWERS_KEY),
                List.of(CountPlacement.of(8), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BiomeFilter.biome()));

        register(context, TREE_LOG_BASE_KEY, holdergetter.getOrThrow(BirchFeatures.TREE_LOG_BASE_KEY),
                List.of(CountPlacement.of(64), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BiomeFilter.biome()));

        register(context, TREE_LOG_EXTRA_BASE_KEY, holdergetter.getOrThrow(BirchFeatures.TREE_LOG_EXTRA_BASE_KEY),
                List.of(CountPlacement.of(64), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BiomeFilter.biome()));

        register(context, TREE_MOSS_BASE_KEY, holdergetter.getOrThrow(BirchFeatures.TREE_MOSS_BASE_KEY),
                List.of(CountPlacement.of(64), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BiomeFilter.biome()));

        register(context, TREES_1_KEY, holdergetter.getOrThrow(BirchFeatures.TREES_1_KEY),
                List.of(CountPlacement.of(64), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BiomeFilter.biome()));

        register(context, TREES_FOREST_KEY, holdergetter.getOrThrow(BirchFeatures.TREES_FOREST_KEY),
                List.of(CountPlacement.of(64), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BiomeFilter.biome()));

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
