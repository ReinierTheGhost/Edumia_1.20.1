package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.worldgen.ModConfiguredFeatures;
import com.legends.edumia.worldgen.ModPlacedFeatures;
import com.legends.edumia.worldgen.features.ModTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModTreePlacements {

    public static final ResourceKey<PlacedFeature> ASPEN_PLACED_KEY = registerKey("aspen");
    public static final ResourceKey<PlacedFeature> GREEN_OAK_PLACED_KEY = registerKey
            ("green_oak");
    public static final ResourceKey<PlacedFeature> SEQUOIA_PLACED_KEY = registerKey("sequoia");
    public static final ResourceKey<PlacedFeature> LARGE_BAOBAB_TRUNK_KEY = registerKey("baobab/large/trunk");
    public static final ResourceKey<PlacedFeature> LARGE_BAOBAB_CANOPY_KEY = registerKey("baobab/large/canopy");
    public static final ResourceKey<PlacedFeature> EMPTY_KEY = registerKey("baobab/empty");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, GREEN_OAK_PLACED_KEY, holdergetter.getOrThrow(ModTreeFeatures.GREEN_OAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra
                                (3, 0.1f, 2),
                        BlockLoader.GREEN_OAK_SAPLING.get()));

        register(context, SEQUOIA_PLACED_KEY, holdergetter.getOrThrow(ModTreeFeatures.SEQUOIA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra
                                (3, 0.1f, 2),
                        BlockLoader.PINE_SAPLING.get()));

        register(context, ASPEN_PLACED_KEY, holdergetter.getOrThrow(ModTreeFeatures.ASPEN_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra
                                (3, 0.1f, 2),
                        BlockLoader.ASPEN_SAPLING.get()));

        register(context, LARGE_BAOBAB_TRUNK_KEY, holdergetter.getOrThrow(ModTreeFeatures.LARGE_BAOBAB_TRUNK_KEY),
                List.of());

        register(context, LARGE_BAOBAB_CANOPY_KEY, holdergetter.getOrThrow(ModTreeFeatures.LARGE_BAOBAB_CANOPY_KEY),
                List.of());

        register(context, EMPTY_KEY, holdergetter.getOrThrow(ModTreeFeatures.EMPTY_KEY),
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
