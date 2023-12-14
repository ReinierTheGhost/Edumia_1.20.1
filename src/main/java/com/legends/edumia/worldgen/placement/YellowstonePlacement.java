package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.features.YellowstoneFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class YellowstonePlacement {

    public static final ResourceKey<PlacedFeature> ACID_BASALT = registerKey("yellowstone/acid_basalt");
    public static final ResourceKey<PlacedFeature> ACID_BLACK = registerKey("yellowstone/acid_black");
    public static final ResourceKey<PlacedFeature> ACID_GRAVEL = registerKey("yellowstone/acid_gravel");
    public static final ResourceKey<PlacedFeature> ACID_ORANGE = registerKey("yellowstone/acid_orange");
    public static final ResourceKey<PlacedFeature> ACID_YELLOW = registerKey("yellowstone/acid_yellow");
    public static final ResourceKey<PlacedFeature> BIRCH = registerKey("yellowstone/birch");
    public static final ResourceKey<PlacedFeature> BIRCH_TREES = registerKey("yellowstone/birch_trees");
    public static final ResourceKey<PlacedFeature> BIRCH_ALT = registerKey("yellowstone/birch_alt");
    public static final ResourceKey<PlacedFeature> BIRCH_TREES_ALT = registerKey("yellowstone/birch_trees_alt");
    public static final ResourceKey<PlacedFeature> LAKES = registerKey("yellowstone/lakes");
    public static final ResourceKey<PlacedFeature> MAGMA = registerKey("yellowstone/magma");
    public static final ResourceKey<PlacedFeature> SPRUCE_BIG = registerKey("yellowstone/spruce_big");
    public static final ResourceKey<PlacedFeature> SPRUCE_BIG_TREES = registerKey("yellowstone/spruce_big_trees");
    public static final ResourceKey<PlacedFeature> SPRUCE_BIG_ALT = registerKey("yellowstone/spruce_big_alt");
    public static final ResourceKey<PlacedFeature> SPRUCE_BIG_TREES_ALT = registerKey("yellowstone/spruce_big_trees_alt");
    public static final ResourceKey<PlacedFeature> TERRA_SAND = registerKey("yellowstone/terra_sand");
    public static final ResourceKey<PlacedFeature> VENTS = registerKey("yellowstone/vents");
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, BIRCH, holdergetter.getOrThrow(YellowstoneFeatures.BIRCH),
                List.of());

        register(context, BIRCH_ALT, holdergetter.getOrThrow(YellowstoneFeatures.BIRCH_ALT),
                List.of());

        register(context, SPRUCE_BIG, holdergetter.getOrThrow(YellowstoneFeatures.SPRUCE_BIG),
                List.of());
        register(context, SPRUCE_BIG_ALT, holdergetter.getOrThrow(YellowstoneFeatures.SPRUCE_BIG_ALT),
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
