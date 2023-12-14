package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class MountainsFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> MISTY_TREES_BASE  = registryKey("mountains/misty/trees_base");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MISTY_TREES_BIRCH  = registryKey("mountains/misty/trees_birch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MISTY_TREES_MID  = registryKey("mountains/misty/trees_mid");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MISTY_TREES_TOP  = registryKey("mountains/misty/trees_top");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        register(context, MISTY_TREES_BASE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockLoader.ASPEN_LOG.get()),
                new StraightTrunkPlacer(4,7, 9),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BlockLoader.ASPEN_LEAVES.get().defaultBlockState(), 2)
                        .add(Blocks.AIR.defaultBlockState(), 1)),
                new PineFoliagePlacer(UniformInt.of(2, 3), ConstantInt.of(0), ConstantInt.of(3)),
                new TwoLayersFeatureSize(1, 1, 1)
        ).ignoreVines().build());

        register(context, MISTY_TREES_BIRCH , Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockLoader.ASPEN_LOG.get()),
                new StraightTrunkPlacer(7,2, 7),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BlockLoader.ASPEN_LEAVES.get().defaultBlockState(), 4)
                        .add(Blocks.AIR.defaultBlockState(), 1)),
                new MegaPineFoliagePlacer(ConstantInt.of(0), UniformInt.of(0, 4), UniformInt.of(3, 9)),
                new TwoLayersFeatureSize(1, 1, 1)
        ).ignoreVines().build());

        register(context, MISTY_TREES_MID, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockLoader.ASPEN_LOG.get()),
                new StraightTrunkPlacer(4, 7, 7),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BlockLoader.ASPEN_LEAVES.get().defaultBlockState(), 2)
                        .add(Blocks.AIR.defaultBlockState(), 1)),
                new PineFoliagePlacer(UniformInt.of(1, 2), UniformInt.of(0, 1), ConstantInt.of(3)),
                new TwoLayersFeatureSize(1, 1, 1)
        ).ignoreVines().build());

        register(context, MISTY_TREES_TOP, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockLoader.ASPEN_LOG.get()),
                new StraightTrunkPlacer(4, 2, 2),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(BlockLoader.ASPEN_LEAVES.get().defaultBlockState(), 2)
                        .add(Blocks.AIR.defaultBlockState(), 1)),
                new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(0), ConstantInt.of(2)),
                new TwoLayersFeatureSize(1, 1, 1)
        ).ignoreVines().build());
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
