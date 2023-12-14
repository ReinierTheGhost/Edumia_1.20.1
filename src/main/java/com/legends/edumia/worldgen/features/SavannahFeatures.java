package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.PointedDripstoneConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;

public class SavannahFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> TERRACOTTA= registryKey("savanna/terracotta");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRASS= registryKey("savanna/badlands/grass");
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){

        register(context, TERRACOTTA, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct(PlacementUtils.inlinePlaced(Feature.POINTED_DRIPSTONE,
                new PointedDripstoneConfiguration(0.2F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.DOWN,
                        BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1))),
                PlacementUtils.inlinePlaced(Feature.POINTED_DRIPSTONE, new PointedDripstoneConfiguration(0.2F, 0.7F, 0.5F, 0.5F),
                        EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12),
                        RandomOffsetPlacement.vertical(ConstantInt.of(-1))))));


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
