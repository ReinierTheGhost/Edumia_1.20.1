package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.ModConfiguredFeatures;
import com.legends.edumia.worldgen.features.AlphaFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ClampedInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.minecraft.core.Vec3i.ZERO;

public class AlphaPlaced {
    public static final ResourceKey<PlacedFeature> CLAY_PATCH_PLACED_KEY = registerKey("alpha/clay_patch");
    public static final ResourceKey<PlacedFeature>  FLOWERS_PLACED_KEY = registerKey("alpha/flowers");
    public static final ResourceKey<PlacedFeature>  FLOWERS_2_PLACED_KEY = registerKey("alpha/flowers_2");
    public static final ResourceKey<PlacedFeature>  SAND_BEACHES_PLACED_KEY = registerKey("alpha/sand_beaches");
    public static final ResourceKey<PlacedFeature>  TREES_PLACED_KEY = registerKey("alpha/trees");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, CLAY_PATCH_PLACED_KEY, holdergetter.getOrThrow(AlphaFeatures.CLAY_PATCH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(57), VerticalAnchor.absolute(62)),
                        BiomeFilter.biome()));

        register(context, FLOWERS_PLACED_KEY, holdergetter.getOrThrow(AlphaFeatures.FLOWERS_KEY),
                List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES),
                        CountPlacement.of(ClampedInt.of(UniformInt.of(-3, 1), 0, 1)), BiomeFilter.biome()));

        register(context, FLOWERS_2_PLACED_KEY, holdergetter.getOrThrow(AlphaFeatures.FLOWERS_KEY),
                List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES),
                        CountPlacement.of(ClampedInt.of(UniformInt.of(-3, 1), 0, 1)), BiomeFilter.biome()));

        register(context, SAND_BEACHES_PLACED_KEY, holdergetter.getOrThrow(AlphaFeatures.SAND_BEACHES_KEY),
                List.of(CountPlacement.of(30), CountPlacement.of(50), InSquarePlacement.spread(),
                        NoiseBasedCountPlacement.of(1, 275D, 0.2D),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(61)),
                        BiomeFilter.biome()));

        register(context, TREES_PLACED_KEY, holdergetter.getOrThrow(AlphaFeatures.TREES_KEY),
                List.of(PlacementUtils.countExtra(4, 0.01111111111111111f, 1), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.FERN.defaultBlockState(), ZERO)),
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
