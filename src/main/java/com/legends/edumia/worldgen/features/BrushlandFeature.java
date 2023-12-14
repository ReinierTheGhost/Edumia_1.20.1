package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class BrushlandFeature {

    public static final ResourceKey<ConfiguredFeature<?, ?>> BOULDER_KEY= registryKey("brushland/boulder");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BOULDERS_KEY= registryKey("brushland/boulders");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUSHES_KEY= registryKey("brushland/bushes");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS_KEY= registryKey("brushland/grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS_EXTRA_KEY= registryKey("brushland/grass_extra");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_GRASS_KEY= registryKey("brushland/patch_tall_grass");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){

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
