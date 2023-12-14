package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.util.ModTags;
import com.legends.edumia.worldgen.placement.YellowstonePlacement;
import com.legends.edumia.worldgen.placement.YosemitePlaced;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.InclusiveRange;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.DualNoiseProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class YosemiteFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALCITE_KEY = registryKey("yosemite/calcite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLIFF_VEGETATION = registryKey("yosemite/cliff_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIORITE_KEY = registryKey("yosemite/diorite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_STONE = registryKey("yosemite/disk_stone");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS_KEY = registryKey("yosemite/grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_KEY = registryKey("yosemite/oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_MEGA_KEY = registryKey("yosemite/oak_mega");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAKS_KEY = registryKey("yosemite/oaks");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DIRT_KEY = registryKey("yosemite/patch_dirt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WATERFALL_KEY = registryKey("yosemite/waterfall");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneDioriteReplaceabeles = new TagMatchTest(ModTags.Blocks.STONE_DIORITE);
        RuleTest stoneReplaceabeles = new BlockMatchTest(Blocks.STONE);

        List<OreConfiguration.TargetBlockState> calciteOre = List.of(OreConfiguration.target(stoneDioriteReplaceabeles,
                Blocks.CALCITE.defaultBlockState()));

        List<OreConfiguration.TargetBlockState> dioriteOre = List.of(OreConfiguration.target(stoneReplaceabeles,
                Blocks.DIORITE.defaultBlockState()));

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<Block> blockHolderGetter = context.lookup(Registries.BLOCK);

        HolderGetter<PlacedFeature> placedFeatureHolderGetter = context.lookup(Registries.PLACED_FEATURE);

        Holder<PlacedFeature> holder = placedFeatureHolderGetter.getOrThrow(YosemitePlaced.CLIFF_VEGETATION_PLACED_KEY);
        Holder<PlacedFeature> holder2 = placedFeatureHolderGetter.getOrThrow(YosemitePlaced.OAK_PLACED_KEY);
        Holder<PlacedFeature> holder3 = placedFeatureHolderGetter.getOrThrow(YosemitePlaced.OAK_MEGA_PLACED_KEY);
        Holder<PlacedFeature> holder4 = placedFeatureHolderGetter.getOrThrow(YellowstonePlacement.BIRCH);
        Holder<PlacedFeature> holder5 = placedFeatureHolderGetter.getOrThrow(YellowstonePlacement.BIRCH_ALT);
        Holder<PlacedFeature> holder6 = placedFeatureHolderGetter.getOrThrow(YellowstonePlacement.SPRUCE_BIG);
        Holder<PlacedFeature> holder7 = placedFeatureHolderGetter.getOrThrow(YellowstonePlacement.SPRUCE_BIG_ALT);


        register(context, CALCITE_KEY, Feature.ORE, new OreConfiguration(calciteOre, 45));

        register(context, CLIFF_VEGETATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider
                (SimpleWeightedRandomList.<BlockState>builder().add(Blocks.GRASS.defaultBlockState(), 50)
                        .add(Blocks.TALL_GRASS.defaultBlockState(), 10))));

        register(context, DIORITE_KEY, Feature.ORE, new OreConfiguration(dioriteOre, 45));

        register(context, DISK_STONE, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                List.of(new WeightedPlacedFeature(holder, 0F)), holder));

        register(context, GRASS_KEY, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(ModTags.Blocks.STONE_ONLY,
                BlockStateProvider.simple(Blocks.GRASS_BLOCK), PlacementUtils.inlinePlaced(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                List.of(new WeightedPlacedFeature(holder, 0f)), holder)),
                CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.3F, UniformInt.of(1, 5),
                0.4F));

        register(context, OAK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockLoader.LARCH_LOG.get()),
                new StraightTrunkPlacer(6, 5, 8),
                BlockStateProvider.simple(BlockLoader.LARCH_LEAVES.get()),
                new SpruceFoliagePlacer(UniformInt.of(2,3), UniformInt.of(0,2),
                        UniformInt.of(3,4)),
                new TwoLayersFeatureSize(2, 1, 2))
                .dirt(BlockStateProvider.simple(Blocks.STONE.defaultBlockState())).ignoreVines().build());

        register(context, OAK_MEGA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockLoader.HOLLY_LOG.get()),
                new StraightTrunkPlacer(6, 5, 8),
                BlockStateProvider.simple(BlockLoader.HOLLY_LEAVES.get()),
                new MegaPineFoliagePlacer(UniformInt.of(1,2), UniformInt.of(1,3),
                        UniformInt.of(10,13)),
                new TwoLayersFeatureSize(2, 1, 2))
                .dirt(BlockStateProvider.simple(Blocks.DIRT.defaultBlockState())).forceDirt().build());

        register(context, OAKS_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                List.of(new WeightedPlacedFeature(holder3, 0.3F),
                        new WeightedPlacedFeature(holder4, 0.075F),
                        new WeightedPlacedFeature(holder5, 0.075F),
                        new WeightedPlacedFeature(holder6, 0.075F),
                        new WeightedPlacedFeature(holder6, 0.075F)), holder2
        ));

        register(context, PATCH_DIRT_KEY,Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                List.of(new WeightedPlacedFeature(holder, 0F)), holder));

        register(context, WATERFALL_KEY, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(ModTags.Blocks.CALCITE,
                BlockStateProvider.simple(Blocks.AIR), PlacementUtils.inlinePlaced(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.WATER),
                new StraightTrunkPlacer(2, 0, 0),
                BlockStateProvider.simple(Blocks.AIR),
                new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
                ).dirt(BlockStateProvider.simple(Blocks.CALCITE)).build()),
                CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.3F, UniformInt.of(1, 5),
                0.4F));



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
