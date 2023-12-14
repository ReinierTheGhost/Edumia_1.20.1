package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.features.HighElvenFeatures;
import com.legends.edumia.worldgen.features.SnowyFeatures;
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
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class SnowPlaced {
    public static final ResourceKey<PlacedFeature> LAYER_FIRST = registerKey("snowy/layer/first");
    public static final ResourceKey<PlacedFeature> LAYER_SECOND = registerKey("snowy/layer/second");
    public static final ResourceKey<PlacedFeature> LAYER_THIRD = registerKey("snowy/layer/third");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, LAYER_FIRST, holdergetter.getOrThrow(SnowyFeatures.LAYER_FIRST),
                List.of(CountPlacement.of(80), CountPlacement.of(10), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(0, -1, 0),
                                        Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE), BlockPredicate.matchesBlocks(
                                        new BlockPos(0, 0, 0), Blocks.AIR, Blocks.SNOW))),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(1,
                                        0, 0), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, 1), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE),
                                BlockPredicate.matchesBlocks(new BlockPos(-1,
                                        0, 0), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, -1), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE))),
                        BiomeFilter.biome()));

        register(context, LAYER_SECOND, holdergetter.getOrThrow(SnowyFeatures.LAYER_SECOND),
                List.of(CountPlacement.of(80), CountPlacement.of(10), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(0, -1, 0),
                                        Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE), BlockPredicate.matchesBlocks(
                                        new BlockPos(0, 0, 0), Blocks.AIR, Blocks.SNOW))),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(1,
                                        0, 0), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, 1), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE),
                                BlockPredicate.matchesBlocks(new BlockPos(-1,
                                        0, 0), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, -1), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE))),
                        BiomeFilter.biome()));

        register(context, LAYER_THIRD, holdergetter.getOrThrow(SnowyFeatures.LAYER_THIRD),
                List.of(CountPlacement.of(80), CountPlacement.of(10), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BlockPredicateFilter.forPredicate(
                                BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(0, -1, 0),
                                        Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE), BlockPredicate.matchesBlocks(
                                        new BlockPos(0, 0, 0), Blocks.AIR, Blocks.SNOW))),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks(new BlockPos(1,
                                        0, 0), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, 1), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE),
                                BlockPredicate.matchesBlocks(new BlockPos(-1,
                                        0, 0), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE),
                                BlockPredicate.matchesBlocks(new BlockPos(0,
                                        0, -1), Blocks.GRASS_BLOCK, Blocks.SNOW_BLOCK, Blocks.BLACKSTONE))),
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
