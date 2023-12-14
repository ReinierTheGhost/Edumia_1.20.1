package com.legends.edumia.worldgen;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.util.ModTags;
import com.legends.edumia.worldgen.features.*;
import com.legends.edumia.worldgen.placement.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.valueproviders.ClampedInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.NoOpFeature;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.minecraft.core.Vec3i.ZERO;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> APPLE_PLACED_KEY = registerKey
            ("apple_placed");
    public static final ResourceKey<PlacedFeature> ALEXANDRITE_ORE_PLACED_KEY = registerKey
            ("alexandrite_ore_placed");
    public static final ResourceKey<PlacedFeature> ALEXANDRITE_GEODE_PLACED_KEY = registerKey
            ("alexandrite_geode_placed");

    public static final ResourceKey<PlacedFeature> CLAY_PATCH_PLACED_KEY = registerKey("alpha/clay_patch");
    public static final ResourceKey<PlacedFeature>  FLOWERS_PLACED_KEY = registerKey("alpha/flowers");
    public static final ResourceKey<PlacedFeature>  FLOWERS_2_PLACED_KEY = registerKey("alpha/flowers_2");
    public static final ResourceKey<PlacedFeature>  SAND_BEACHES_PLACED_KEY = registerKey("alpha/sand_beaches");
    public static final ResourceKey<PlacedFeature>  TREES_PLACED_KEY = registerKey("alpha/trees");
    public static final ResourceKey<PlacedFeature> CLOUD_TREE_TALL_PLACED_KEY = registerKey
            ("birch/cloud_tree_tall");

    public static final ResourceKey<PlacedFeature> JUNGLE_MOUNTAINS_SLAB_STONE_PLACED_KEY = registerKey("jungle/mountains/slab_stone");

    public static final ResourceKey<PlacedFeature> CAVE_GENERIC_MEGA_GEODE_PLACED_KEY = registerKey("cave/generic/mega_geode");

    public static final ResourceKey<PlacedFeature> NOTING_PLACED_KEY = registerKey("nothing");



    public static void bootstrap(BootstapContext<PlacedFeature> context) {


        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> holder5 = holdergetter.getOrThrow(BirchFeatures.CLOUD_TREE_TALL_KEY);

        AlphaPlaced.bootstrap(context);
        BirchPlaced.bootstrap(context);
        ForestPlacement.bootstrap(context);
        HighElvenPlaced.bootstrap(context);
        ModTreePlacements.bootstrap(context);
        MountainPlaced.bootstrap(context);
        TaigaPlaced.bootstrap(context);
        CanyonPlaced.bootstrap(context);
        YellowstonePlacement.bootstrap(context);
        YosemitePlaced.bootstrap(context);
        SakuraPlaced.bootstrap(context);
        SnowPlaced.bootstrap(context);
        HighlandPlaced.bootstrap(context);
        SavannaPlacement.bootstrap(context);

        register(context, APPLE_PLACED_KEY, holdergetter.getOrThrow(ModConfiguredFeatures.APPLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra
                                (3, 0.1f, 2),
                        BlockLoader.APPLE_SAPLING.get()));

        register(context, ALEXANDRITE_ORE_PLACED_KEY, holdergetter.getOrThrow
                        (ModConfiguredFeatures.ALEXANDRITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(80))));

        register(context, ALEXANDRITE_GEODE_PLACED_KEY, holdergetter.getOrThrow
                        (ModConfiguredFeatures.ALEXANDRITE_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6),
                                VerticalAnchor.absolute(50)),
                        BiomeFilter.biome()));

        register(context, JUNGLE_MOUNTAINS_SLAB_STONE_PLACED_KEY, holdergetter.getOrThrow(ModConfiguredFeatures.JUNGLE_MOUNTAINS_SLAB_STONE_KEY),
                List.of(CountPlacement.of(20), CountPlacement.of(30), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 0), Blocks.AIR),
                                BlockPredicate.matchesBlocks(new BlockPos(0, -1, 0), Blocks.STONE),
                                BlockPredicate.anyOf(BlockPredicate.allOf(
                                                BlockPredicate.matchesBlocks(new BlockPos(-1,0,0), Blocks.STONE),
                                                BlockPredicate.matchesBlocks(new BlockPos(-1, 1, 0), Blocks.AIR),
                                                BlockPredicate.matchesBlocks(new BlockPos(1, -1, 0), Blocks.STONE)),
                                        BlockPredicate.allOf(
                                                BlockPredicate.matchesBlocks(new BlockPos(1,0,0), Blocks.STONE),
                                                BlockPredicate.matchesBlocks(new BlockPos(1, 1, 0), Blocks.AIR),
                                                BlockPredicate.matchesBlocks(new BlockPos(-1, -1, 0), Blocks.STONE)),
                                        BlockPredicate.allOf(
                                                BlockPredicate.matchesBlocks(new BlockPos(0,0,1), Blocks.STONE),
                                                BlockPredicate.matchesBlocks(new BlockPos(0, 1, 1), Blocks.AIR),
                                                BlockPredicate.matchesBlocks(new BlockPos(0, -1, -1), Blocks.STONE)
                                        )))), BiomeFilter.biome()));

        register(context, CAVE_GENERIC_MEGA_GEODE_PLACED_KEY, holdergetter.getOrThrow(ModConfiguredFeatures.CAVE_GENERIC_MEGA_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(200), RandomOffsetPlacement.horizontal(UniformInt.of(8, 8)),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(-44)),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.not(BlockPredicate.anyOf(
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 0), Blocks.AIR, Blocks.WATER)/*,
                                BlockPredicate.matchesBlocks(new BlockPos(16, 0, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-16, 0, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, -16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(16, 0, 16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(16, 0, -16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-16, 0, 16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-16, 0, -16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 16, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(16, 16, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 16, 16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-16, 16, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 16, -16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(16, 16, 16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(16, 16, -16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-16, 16, 16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-16, 16, -16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, -16, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(16, -16, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, -16, 16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-16, -16, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, -16, -16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(16, -16, 16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(16, -16, -16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-16, -16, 16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-16, -16, -16), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(8, 0, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, 8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-8, 0, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 0, -8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(8, 0, 8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(8, 0, -8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-8, 0, 8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-8, 0, -8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 8, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(8, 8, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 8, 8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-8, 8, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, 8, -8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(8, 8, 8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(8, 8, -8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-8, 8, 8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-8, 8, -8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, -8, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(8, -8, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, -8, 8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-8, -8, 0), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(0, -8, -8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(8, -8, 8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(8, -8, -8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-8, -8, 8), Blocks.AIR, Blocks.WATER),
                                BlockPredicate.matchesBlocks(new BlockPos(-8, -8, -8), Blocks.AIR, Blocks.WATER)*/
                        )))), BiomeFilter.biome()));

        register(context, NOTING_PLACED_KEY, holdergetter.getOrThrow(ModConfiguredFeatures.NOTHING_KEY),
                List.of());

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
