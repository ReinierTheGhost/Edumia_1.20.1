package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.features.CanyonFeatures;
import com.legends.edumia.worldgen.features.HighElvenFeatures;
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

public class CanyonPlaced {

    public static final ResourceKey<PlacedFeature> CLIFF_PLACED_KEY = registerKey("canyon/blooming/cliff");
    public static final ResourceKey<PlacedFeature> FLOWERS_PLACED_KEY = registerKey("canyon/blooming/flowers");
    public static final ResourceKey<PlacedFeature> FLOWERS_WHITE_PLACED_KEY = registerKey("canyon/blooming/flowers_white");

    public static final ResourceKey<PlacedFeature> CLIFF_2_PLACED_KEY = registerKey("canyon/generic/cliff");
    public static final ResourceKey<PlacedFeature> SLAB_STONE = registerKey("canyon/generic/slab_stone");

    public static final ResourceKey<PlacedFeature> SANDSTONE_CLIFF_PLACED_KEY = registerKey("canyon/sandstone/cliff");
    public static final ResourceKey<PlacedFeature> SANDSTONE_SANDSTONE_PLACED_KEY = registerKey("canyon/sandstone/sandstone");
    public static final ResourceKey<PlacedFeature> SANDSTONE_SLAB_PLACED_KEY = registerKey("canyon/sandstone/slab");
    public static final ResourceKey<PlacedFeature> SANDSTONE_SLAB_SMOOTH_PLACED_KEY = registerKey("canyon/sandstone/slab_smooth");
    public static final ResourceKey<PlacedFeature> SANDSTONE_LAKES_PLACED_KEY = registerKey("canyon/sandstone/lakes");



    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, CLIFF_PLACED_KEY, holdergetter.getOrThrow(CanyonFeatures.CLIFF_KEY),
                List.of(PlacementUtils.countExtra(256, 0.01f, 0), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        BiomeFilter.biome()));

        register(context, FLOWERS_PLACED_KEY, holdergetter.getOrThrow(CanyonFeatures.FLOWERS_KEY),
                List.of(CountPlacement.of(10), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                BiomeFilter.biome()));

        register(context, FLOWERS_WHITE_PLACED_KEY, holdergetter.getOrThrow(CanyonFeatures.FLOWERS_WHITE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                        BiomeFilter.biome()));

        register(context, CLIFF_2_PLACED_KEY, holdergetter.getOrThrow(CanyonFeatures.CLIFF_2_KEY),
                List.of(PlacementUtils.countExtra(128, 0.01f, 0), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        BiomeFilter.biome()));

        register(context, SLAB_STONE, holdergetter.getOrThrow(CanyonFeatures.SLAB_STONE),
                List.of(CountPlacement.of(20), CountPlacement.of(30), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 0), Blocks.AIR),
                                BlockPredicate.matchesBlocks(new BlockPos(0, -1, 0), Blocks.STONE),
                                BlockPredicate.anyOf(BlockPredicate.anyOf(
                                        BlockPredicate.matchesBlocks(new BlockPos(-1, 0, 0), Blocks.STONE),
                                        BlockPredicate.matchesBlocks(new BlockPos(-1, 1, 0), Blocks.AIR),
                                        BlockPredicate.matchesBlocks(new BlockPos(1, -1, 0), Blocks.STONE)
                                        ), BlockPredicate.allOf(
                                        BlockPredicate.matchesBlocks(new BlockPos(1, 0, 0), Blocks.STONE),
                                        BlockPredicate.matchesBlocks(new BlockPos(1, 1, 0), Blocks.AIR),
                                        BlockPredicate.matchesBlocks(new BlockPos(-1, -1, 0), Blocks.STONE)
                                ),BlockPredicate.allOf(
                                        BlockPredicate.matchesBlocks(new BlockPos(0, 0, -1), Blocks.STONE),
                                        BlockPredicate.matchesBlocks(new BlockPos(0, 1, -1), Blocks.AIR),
                                        BlockPredicate.matchesBlocks(new BlockPos(0, -1, 1), Blocks.STONE)
                                        ),BlockPredicate.allOf(
                                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 1), Blocks.STONE),
                                                BlockPredicate.matchesBlocks(new BlockPos(0, 1, 1), Blocks.AIR),
                                                BlockPredicate.matchesBlocks(new BlockPos(0, -1, -1), Blocks.STONE)
                                        )))), BiomeFilter.biome()));


        register(context, SANDSTONE_CLIFF_PLACED_KEY, holdergetter.getOrThrow(CanyonFeatures.SANDSTONE_CLIFF_KEY),
                List.of(PlacementUtils.countExtra(256, 0.01f, 0), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        BiomeFilter.biome()));

        register(context, SANDSTONE_SANDSTONE_PLACED_KEY, holdergetter.getOrThrow(CanyonFeatures.SANDSTONE_SANDSTONE_KEY),
                List.of(PlacementUtils.countExtra(256, 0.01f, 0), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        BiomeFilter.biome()));

        register(context, SANDSTONE_SLAB_PLACED_KEY, holdergetter.getOrThrow(CanyonFeatures.SANDSTONE_SLAB_KEY),
                List.of(PlacementUtils.countExtra(256, 0.01f, 0), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        BiomeFilter.biome()));

        register(context, SANDSTONE_SLAB_SMOOTH_PLACED_KEY, holdergetter.getOrThrow(CanyonFeatures.SANDSTONE_SLAB_SMOOTH_KEY),
                List.of(PlacementUtils.countExtra(256, 0.01f, 0), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        BiomeFilter.biome()));

        register(context, SANDSTONE_LAKES_PLACED_KEY, holdergetter.getOrThrow(CanyonFeatures.SANDSTONE_LAKES_KEY),
                List.of(CountPlacement.of(20), CountPlacement.of(30), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG), BiomeFilter.biome()));

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
