package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.features.HighElvenFeatures;
import com.legends.edumia.worldgen.features.HighlandFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ClampedNormalInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class HighlandPlaced {
    public static final ResourceKey<PlacedFeature> PILLAR = registerKey("highland/pillar");
    public static final ResourceKey<PlacedFeature> LAKE = registerKey("highland/lake");
    public static final ResourceKey<PlacedFeature> DISK_GRAVEL = registerKey("highland/disk_gravel");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PILLAR, holdergetter.getOrThrow(HighlandFeatures.PILLAR),
                List.of(RarityFilter.onAverageOnceEvery(35), InSquarePlacement.spread(),
                        CountPlacement.of(ClampedNormalInt.of(7f, 4f, 5, 15)),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE), BiomeFilter.biome()));

        register(context, LAKE, holdergetter.getOrThrow(HighlandFeatures.LAKE),
                List.of(RarityFilter.onAverageOnceEvery(19), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING), BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 0),
                                        Blocks.AIR, Blocks.GRASS, Blocks.FERN),
                                BlockPredicate.matchesBlocks(new BlockPos(1, 0, 0),
                                        Blocks.AIR, Blocks.GRASS, Blocks.FERN),
                                BlockPredicate.matchesBlocks(new BlockPos(2, 0, 0),
                                        Blocks.AIR, Blocks.GRASS, Blocks.FERN),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 1),
                                        Blocks.AIR, Blocks.GRASS, Blocks.FERN),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 2),
                                        Blocks.AIR, Blocks.GRASS, Blocks.FERN),
                                BlockPredicate.matchesBlocks(new BlockPos(-1, 0, 0),
                                        Blocks.AIR, Blocks.GRASS, Blocks.FERN),
                                BlockPredicate.matchesBlocks(new BlockPos(-2, 0, 0),
                                        Blocks.AIR, Blocks.GRASS, Blocks.FERN),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, -1),
                                        Blocks.AIR, Blocks.GRASS, Blocks.FERN),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, -2),
                                        Blocks.AIR, Blocks.GRASS, Blocks.FERN)
                                )), BiomeFilter.biome()));


        register(context, DISK_GRAVEL, holdergetter.getOrThrow(HighlandFeatures.PILLAR),
                List.of(CountPlacement.of(32), InSquarePlacement.spread(),
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

