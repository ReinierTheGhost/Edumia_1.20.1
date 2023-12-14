package com.legends.edumia.worldgen;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.util.ModTags;
import com.legends.edumia.worldgen.features.*;
import com.legends.edumia.worldgen.placement.ForestPlacement;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_KEY = registryKey("apple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALEXANDRITE_ORE_KEY = registryKey("alexandrite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALEXANDRITE_GEODE_KEY = registryKey("alexandrite_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALDERA_LAKES_KEY= registryKey("caldera/lakes");

    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_MOUNTAINS_SLAB_STONE_KEY = registryKey("jungle/mountains/slab_stone");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CAVE_GENERIC_MEGA_GEODE_KEY = registryKey("cave/generic/mega_geode");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NOTHING_KEY = registryKey("nothing");

    private static TreeConfiguration.TreeConfigurationBuilder createForkedBlobTree
            (Block block, Block block1, int base_height, int height_rand_a, int height_rand_b, int radius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(block),
                new ForkingTrunkPlacer(base_height, height_rand_a, height_rand_b),
                BlockStateProvider.simple(block1), new BlobFoliagePlacer(ConstantInt.of(radius), ConstantInt.of(2), 2),
                new TwoLayersFeatureSize(1, 0, 1));
    }
    private static TreeConfiguration.TreeConfigurationBuilder createBirch() {
        return createForkedBlobTree(Blocks.BIRCH_LOG, Blocks.BIRCH_LEAVES, 5, 4, 8, 2).ignoreVines();
    }


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        AlphaFeatures.bootstrap(context);
        BirchFeatures.bootstrap(context);
        ForestFeatures.bootstrap(context);
        HighElvenFeatures.bootstrap(context);
        ModTreeFeatures.bootstrap(context);
        MountainsFeatures.bootstrap(context);
        TaigaFeatures.bootstrap(context);
        CanyonFeatures.bootstrap(context);
        YellowstoneFeatures.bootstrap(context);
        YosemiteFeatures.bootstrap(context);
        SakuraFeatures.bootstrap(context);
        SnowyFeatures.bootstrap(context);
        HighlandFeatures.bootstrap(context);
        SavannahFeatures.bootstrap(context);

        RuleTest stoneReplaceabeles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceabeles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest sandReplacables = new BlockMatchTest(Blocks.SAND);
        RuleTest soilGravelReplacable = new TagMatchTest(ModTags.Blocks.SOIL_AND_GRAVEL);

        List<OreConfiguration.TargetBlockState> overworldAlexandriteOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                BlockLoader.ALEXANDRITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> sandClayReplace = List.of(OreConfiguration.target(sandReplacables,
                Blocks.CLAY.defaultBlockState()));

        List<OreConfiguration.TargetBlockState> soilGravelReplace = List.of(OreConfiguration.target(soilGravelReplacable,
                Blocks.SAND.defaultBlockState()));

        HolderGetter<PlacedFeature> holdergetter = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> holder = holdergetter.getOrThrow(TreePlacements.OAK_CHECKED);
        Holder<PlacedFeature> holder1 = holdergetter.getOrThrow(TreePlacements.FANCY_OAK_CHECKED);
        Holder<PlacedFeature> holder3 = holdergetter.getOrThrow(TreePlacements.SUPER_BIRCH_BEES_0002);
        Holder<PlacedFeature> holder4 = holdergetter.getOrThrow(ModPlacedFeatures.CLOUD_TREE_TALL_PLACED_KEY);
        Holder<PlacedFeature> holder5 = holdergetter.getOrThrow(ModPlacedFeatures.NOTING_PLACED_KEY);
        Holder<PlacedFeature> holder6 = holdergetter.getOrThrow(ForestPlacement.CLOUD_TREE_PLACED_KEY);

        BeehiveDecorator beehivedecorator = new BeehiveDecorator(0.03F);


        register(context, APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockLoader.APPLE_LOG.get()),
                new StraightTrunkPlacer(4, 3, 2),
                BlockStateProvider.simple(BlockLoader.APPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, ALEXANDRITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAlexandriteOres, 9));

        register(context, ALEXANDRITE_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(Blocks.DEEPSLATE),
                        BlockStateProvider.simple(BlockLoader.ALEXANDRITE_ORE.get()),
                        BlockStateProvider.simple(Blocks.DIRT),
                        BlockStateProvider.simple(Blocks.EMERALD_BLOCK),
                        List.of(BlockLoader.ALEXANDRITE_BLOCK.get().defaultBlockState()),
                        BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerSettings(1.7D, 1.2D, 2.5D, 3.5D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 8),
                        UniformInt.of(2, 6), UniformInt.of(1, 2),
                        -18, 18, 0.075D, 1));

        register(context, JUNGLE_MOUNTAINS_SLAB_STONE_KEY, Feature.SIMPLE_BLOCK,
                new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.STONE_SLAB)));

        register(context, CAVE_GENERIC_MEGA_GEODE_KEY, Feature.GEODE, new GeodeConfiguration
                (new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                BlockStateProvider.simple(Blocks.AMETHYST_BLOCK),
                BlockStateProvider.simple(Blocks.BUDDING_AMETHYST),
                BlockStateProvider.simple(Blocks.CALCITE),
                BlockStateProvider.simple(Blocks.DEEPSLATE),
                List.of(Blocks.SMALL_AMETHYST_BUD.defaultBlockState(), Blocks.MEDIUM_AMETHYST_BUD.defaultBlockState(),
                        Blocks.LARGE_AMETHYST_BUD.defaultBlockState(), Blocks.AMETHYST_CLUSTER.defaultBlockState()),
                BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),
                new GeodeLayerSettings(2.9D, 4D, 4.8D, 6.3D),
                new GeodeCrackSettings(0.95D, 3.15D, (int) 2.25D), 0.25D, 0.083D,
                true, UniformInt.of(2, 10),
                UniformInt.of(5, 5), UniformInt.of(2, 3),
                -22, 22, 0.041375D, 0));

        register(context, NOTHING_KEY, Feature.NO_OP, new NoneFeatureConfiguration());
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
