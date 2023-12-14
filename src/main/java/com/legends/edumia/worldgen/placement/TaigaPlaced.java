package com.legends.edumia.worldgen.placement;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.features.TaigaFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class TaigaPlaced {

    public static final ResourceKey<PlacedFeature> BIRCH_TREE = registerKey("taiga/birch/birch");
    public static final ResourceKey<PlacedFeature> BIRCH_TREE_SMALL = registerKey("taiga/birch/birch_small");
    public static final ResourceKey<PlacedFeature> BIRCH_BOULDER = registerKey("taiga/birch/boulder");
    public static final ResourceKey<PlacedFeature> BIRCH_CLOUD_TREE = registerKey("taiga/birch/cloud_tree");
    public static final ResourceKey<PlacedFeature> BIRCH_OAK = registerKey("taiga/birch/oak");
    public static final ResourceKey<PlacedFeature> BIRCH_POND = registerKey("taiga/birch/pond");
    public static final ResourceKey<PlacedFeature> BIRCH_TREES_SMALL = registerKey("taiga/birch/trees_small");

    public static final ResourceKey<PlacedFeature> LUSH_FLOWERS = registerKey("taiga/lush/flowers");

    public static final ResourceKey<PlacedFeature> MID_PINE = registerKey("taiga/mid/pine");
    public static final ResourceKey<PlacedFeature> MID_SPRUCE = registerKey("taiga/mid/spruce");
    public static final ResourceKey<PlacedFeature> MID_SPRUCE_M = registerKey("taiga/mid/spruce_m");
    public static final ResourceKey<PlacedFeature> MID_TREES = registerKey("taiga/mid/trees");

    public static final ResourceKey<PlacedFeature> SIBERIAN_TALL_TREE = registerKey("taiga/siberian/tall_tree");
    public static final ResourceKey<PlacedFeature> SIBERIAN_TALL_TREE_ORANGE = registerKey("taiga/siberian/tall_tree_orange");
    public static final ResourceKey<PlacedFeature> SIBERIAN_NEW_TREES = registerKey("taiga/siberian/trees_new");
    public static final ResourceKey<PlacedFeature> SIBERIAN_NEW_TREES_ORANGE = registerKey("taiga/siberian/trees_new_orange");
    public static final ResourceKey<PlacedFeature> SIBERIAN_TREES = registerKey("taiga/siberian/trees");

    public static final ResourceKey<PlacedFeature> SIBERIAN_TREES_ORANGE = registerKey("taiga/siberian/trees_orange");

    public static final ResourceKey<PlacedFeature> SMALL_PINE = registerKey("taiga/small/pine");
    public static final ResourceKey<PlacedFeature> SMALL_SPRUCE = registerKey("taiga/small/spruce");
    public static final ResourceKey<PlacedFeature> SMALL_SPRUCE_M = registerKey("taiga/small/spruce_m");
    public static final ResourceKey<PlacedFeature> SMALL_TREES = registerKey("taiga/small/trees");

    public static final ResourceKey<PlacedFeature> TALL_PINE = registerKey("taiga/tall/pine");
    public static final ResourceKey<PlacedFeature> TALL_SPRUCE = registerKey("taiga/tall/spruce");
    public static final ResourceKey<PlacedFeature> TALL_SPRUCE_M = registerKey("taiga/tall/spruce_m");
    public static final ResourceKey<PlacedFeature> TALL_TREES = registerKey("taiga/tall/trees");

    public static final ResourceKey<PlacedFeature> TINY_PINE = registerKey("taiga/tiny/pine");
    public static final ResourceKey<PlacedFeature> TINY_SPRUCE = registerKey("taiga/tiny/spruce");
    public static final ResourceKey<PlacedFeature> TINY_SPRUCE_M = registerKey("taiga/tiny/spruce_m");
    public static final ResourceKey<PlacedFeature> TINY_TREES = registerKey("taiga/tiny/trees");
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SIBERIAN_TALL_TREE, holdergetter.getOrThrow(TaigaFeatures.SIBERIAN_TALL_TREE),
                List.of(CountPlacement.of(UniformInt.of(1, 4))));
        register(context, SIBERIAN_TALL_TREE_ORANGE, holdergetter.getOrThrow(TaigaFeatures.SIBERIAN_TALL_TREE_ORANGE),
                List.of(CountPlacement.of(UniformInt.of(2, 5))));
        register(context, SIBERIAN_NEW_TREES, holdergetter.getOrThrow(TaigaFeatures.SIBERIAN_TALL_TREE),
                List.of(CountPlacement.of(UniformInt.of(1, 4))));
        register(context, SIBERIAN_NEW_TREES_ORANGE, holdergetter.getOrThrow(TaigaFeatures.SIBERIAN_TALL_TREE_ORANGE),
                List.of(CountPlacement.of(UniformInt.of(2, 5))));
        register(context, SIBERIAN_TREES, holdergetter.getOrThrow(TaigaFeatures.SIBERIAN_TALL_TREE),
                List.of(CountPlacement.of(UniformInt.of(1, 4))));
        register(context, SIBERIAN_TREES_ORANGE, holdergetter.getOrThrow(TaigaFeatures.SIBERIAN_TALL_TREE_ORANGE),
                List.of(CountPlacement.of(UniformInt.of(2, 5))));


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
