package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;

import java.util.List;

public class SakuraFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> CLAY_BEACHES  = registryKey("sakura/clay_beaches");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PODZOL  = registryKey("sakura/patch_podzol");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){
        register(context, CLAY_BEACHES, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.CLAY), BlockPredicate
                .matchesBlocks(Blocks.GRAVEL, Blocks.SAND, Blocks.DIRT, Blocks.GRASS_BLOCK), UniformInt.of(4, 8), 3));

        register(context, PATCH_PODZOL, Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.CLAY), BlockPredicate
                .matchesBlocks(Blocks.GRAVEL, Blocks.SAND, Blocks.DIRT, Blocks.GRASS_BLOCK), UniformInt.of(4, 8), 3));
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
