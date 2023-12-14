package com.legends.edumia.worldgen.features;

import com.legends.edumia.Edumia;
import com.legends.edumia.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class AlphaFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> CLAY_PATCH_KEY = registryKey("alpha/clay_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERS_KEY = registryKey("alpha/flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERS_2_KEY = registryKey("alpha/flowers_2");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAND_BEACHES_KEY = registryKey("alpha/sand_beaches");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TREES_KEY = registryKey("alpha/trees");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context){

        RuleTest sandReplacables = new BlockMatchTest(Blocks.SAND);
        RuleTest soilGravelReplacable = new TagMatchTest(ModTags.Blocks.SOIL_AND_GRAVEL);

        List<OreConfiguration.TargetBlockState> sandClayReplace = List.of(OreConfiguration.target(sandReplacables,
                Blocks.CLAY.defaultBlockState()));

        List<OreConfiguration.TargetBlockState> soilGravelReplace = List.of(OreConfiguration.target(soilGravelReplacable,
                Blocks.SAND.defaultBlockState()));

        HolderGetter<PlacedFeature> holdergetter = context.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> holder = holdergetter.getOrThrow(TreePlacements.OAK_CHECKED);
        Holder<PlacedFeature> holder1 = holdergetter.getOrThrow(TreePlacements.FANCY_OAK_CHECKED);



        register(context, CLAY_PATCH_KEY, Feature.ORE, new OreConfiguration(sandClayReplace, 50));

        register(context, FLOWERS_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(64, 7, 3, PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.POPPY))
                        , BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks
                                (new BlockPos(0, -1, 0), Blocks.GRASS_BLOCK))))));

        register(context, FLOWERS_2_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(64, 7, 3, PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.DANDELION))
                        , BlockPredicateFilter.forPredicate(BlockPredicate.allOf(BlockPredicate.matchesBlocks
                                (new BlockPos(0, -1, 0), Blocks.GRASS_BLOCK))))));

        register(context, SAND_BEACHES_KEY, Feature.ORE,
                new OreConfiguration(soilGravelReplace, 50));

        register(context, TREES_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(holder, 0.85F)), holder1));

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
