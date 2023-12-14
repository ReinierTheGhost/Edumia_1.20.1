package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.features.MountainsFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.minecraft.core.Vec3i.ZERO;

public class MountainPlaced {

    public static final ResourceKey<PlacedFeature> MISTY_TREES_BASE  = registerKey("mountains/misty/trees_base");
    public static final ResourceKey<PlacedFeature> MISTY_TREES_BIRCH  = registerKey("mountains/misty/trees_birch");
    public static final ResourceKey<PlacedFeature> MISTY_TREES_MID  = registerKey("mountains/misty/trees_mid");
    public static final ResourceKey<PlacedFeature> MISTY_TREES_TOP  = registerKey("mountains/misty/trees_top");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, MISTY_TREES_BASE, holdergetter.getOrThrow(MountainsFeatures.MISTY_TREES_BASE),
                List.of(CountPlacement.of(2), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                        CountPlacement.of(UniformInt.of(7, 16)),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.FERN.defaultBlockState(), ZERO)),
                        BiomeFilter.biome()));

        register(context, MISTY_TREES_BIRCH, holdergetter.getOrThrow(MountainsFeatures.MISTY_TREES_BIRCH),
                List.of(CountPlacement.of(2), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                        CountPlacement.of(UniformInt.of(5, 9)),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.FERN.defaultBlockState(), ZERO)),
                        BiomeFilter.biome()));

        register(context, MISTY_TREES_MID, holdergetter.getOrThrow(MountainsFeatures.MISTY_TREES_MID),
                List.of(CountPlacement.of(4), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                        CountPlacement.of(UniformInt.of(7, 16)),
                        BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.FERN.defaultBlockState(), ZERO)),
                        BiomeFilter.biome()));

        register(context, MISTY_TREES_TOP, holdergetter.getOrThrow(MountainsFeatures.MISTY_TREES_TOP),
                List.of(CountPlacement.of(2), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                        CountPlacement.of(UniformInt.of(5, 16)),
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
