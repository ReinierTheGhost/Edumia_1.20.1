package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.features.HighElvenFeatures;
import com.legends.edumia.worldgen.features.SakuraFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class SakuraPlaced {
    public static final ResourceKey<PlacedFeature> CLAY_BEACHES = registerKey("sakura/clay_beaches");
    public static final ResourceKey<PlacedFeature> PATCH_PODZOL = registerKey("sakura/patch_podzol");
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, CLAY_BEACHES, holdergetter.getOrThrow(SakuraFeatures.CLAY_BEACHES),
                List.of(CountPlacement.of(120), InSquarePlacement.spread(), NoiseBasedCountPlacement.of(1, 175,-0.1D ),
                        HeightRangePlacement.of(ConstantHeight.of(VerticalAnchor.absolute(61))), BiomeFilter.biome()));

        register(context, PATCH_PODZOL, holdergetter.getOrThrow(SakuraFeatures.PATCH_PODZOL),
                List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(),
                        HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                        BiomeFilter.biome()));

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