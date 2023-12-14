package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.features.CanyonFeatures;
import com.legends.edumia.worldgen.features.YosemiteFeatures;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.minecraft.core.Vec3i.ZERO;

public class YosemitePlaced {
    public static final ResourceKey<PlacedFeature> CALCITE_PLACED_KEY = registerKey("yosemite/calcite");
    public static final ResourceKey<PlacedFeature> CLIFF_VEGETATION_PLACED_KEY = registerKey("yosemite/cliff_vegetation");
    public static final ResourceKey<PlacedFeature> DIORITE_PLACED_KEY = registerKey("yosemite/diorite");
    public static final ResourceKey<PlacedFeature> DISK_STONE_PLACED_KEY = registerKey("yosemite/disk_stone");
    public static final ResourceKey<PlacedFeature> GRASS_PLACED_KEY = registerKey("yosemite/grass");
    public static final ResourceKey<PlacedFeature> OAK_PLACED_KEY = registerKey("yosemite/oak");
    public static final ResourceKey<PlacedFeature> OAK_MEGA_PLACED_KEY = registerKey("yosemite/oak_mega");
    public static final ResourceKey<PlacedFeature> OAKS_PLACED_KEY = registerKey("yosemite/oaks");
    public static final ResourceKey<PlacedFeature> PATCH_DIRT_PLACED_KEY = registerKey("yosemite/patch_dirt");
    public static final ResourceKey<PlacedFeature> WATERFALL_PLACED_KEY = registerKey("yosemite/waterfall");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {


        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, CALCITE_PLACED_KEY, holdergetter.getOrThrow(YosemiteFeatures.CALCITE_KEY),
                List.of(CountPlacement.of(150), InSquarePlacement.spread(),
                        NoiseBasedCountPlacement.of(1, 75, 1),
                        NoiseBasedCountPlacement.of(-1, 75, 0.5),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        BiomeFilter.biome()));

        register(context, CLIFF_VEGETATION_PLACED_KEY, holdergetter.getOrThrow(YosemiteFeatures.CLIFF_VEGETATION),
                List.of());

        register(context, DIORITE_PLACED_KEY, holdergetter.getOrThrow(YosemiteFeatures.DIORITE_KEY),
                List.of(CountPlacement.of(150), InSquarePlacement.spread(),
                        NoiseBasedCountPlacement.of(1, 75, 0.6),
                        NoiseBasedCountPlacement.of(-1, 75, 0.2),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        BiomeFilter.biome()));

        register(context, DISK_STONE_PLACED_KEY, holdergetter.getOrThrow(YosemiteFeatures.DISK_STONE),
                List.of(PlacementUtils.countExtra(128, 0.01f, 100),
                        InSquarePlacement.spread(), NoiseBasedCountPlacement.of(1, 175, 1),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BiomeFilter.biome()));

        register(context, GRASS_PLACED_KEY, holdergetter.getOrThrow(YosemiteFeatures.GRASS_KEY),
                List.of(CountPlacement.of(150), InSquarePlacement.spread(),
                        NoiseBasedCountPlacement.of(1, 75, -0.2),
                        NoiseBasedCountPlacement.of(-1, 75, -1),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        BiomeFilter.biome()));

        register(context, OAK_PLACED_KEY, holdergetter.getOrThrow(YosemiteFeatures.OAK_KEY),
                List.of());

        register(context, OAK_MEGA_PLACED_KEY, holdergetter.getOrThrow(YosemiteFeatures.OAK_MEGA_KEY),
                List.of());

        register(context, OAKS_PLACED_KEY, holdergetter.getOrThrow(YosemiteFeatures.OAKS_KEY),
                List.of(PlacementUtils.countExtra(7, 0.02F, 1), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.replaceable(),
                                BlockPredicate.wouldSurvive(Blocks.FERN.defaultBlockState(), ZERO))), BiomeFilter.biome()
                        ));

        register(context, PATCH_DIRT_PLACED_KEY, holdergetter.getOrThrow(YosemiteFeatures.PATCH_DIRT_KEY),
                List.of(CountPlacement.of(30), CountPlacement.of(30), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        InSquarePlacement.spread(), NoiseBasedCountPlacement.of(1, 400, 1),
                        NoiseBasedCountPlacement.of(98, 34, -0.6), BiomeFilter.biome()));

        register(context, WATERFALL_PLACED_KEY, holdergetter.getOrThrow(YosemiteFeatures.WATERFALL_KEY),
                List.of(CountPlacement.of(6), InSquarePlacement.spread(),
                        NoiseBasedCountPlacement.of(-1, 75, 0.6),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(256), VerticalAnchor.absolute(256)),
                        EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(),  BlockPredicate.ONLY_IN_AIR_PREDICATE, 32),
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
