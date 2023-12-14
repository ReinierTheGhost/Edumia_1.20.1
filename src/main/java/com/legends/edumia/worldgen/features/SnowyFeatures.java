package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class SnowyFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> LAYER_FIRST = registryKey("snowy/layer/first");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAYER_SECOND = registryKey("snowy/layer/second");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAYER_THIRD = registryKey("snowy/layer/third");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){

        register(context, LAYER_FIRST, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList
                .<BlockState>builder().add(Blocks.SNOW.defaultBlockState(), 5).add(Blocks.SNOW.defaultBlockState(), 4))));

        register(context, LAYER_SECOND, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList
                .<BlockState>builder().add(Blocks.SNOW.defaultBlockState(), 1).add(Blocks.SNOW.defaultBlockState(), 1))));

        register(context, LAYER_THIRD, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList
                .<BlockState>builder().add(Blocks.SNOW.defaultBlockState(), 4).add(Blocks.SNOW.defaultBlockState(), 3))));
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
