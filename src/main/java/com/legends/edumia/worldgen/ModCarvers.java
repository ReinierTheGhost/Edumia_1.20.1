package com.legends.edumia.worldgen;

import com.legends.edumia.Edumia;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.TrapezoidFloat;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CanyonCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

public class ModCarvers {

    public static final ResourceKey<ConfiguredWorldCarver<?>> DEEP_RAVINE = register("deep_ravine");

    public static void bootstrap(BootstapContext<ConfiguredWorldCarver<?>> context) {
        HolderGetter<Block> holdergetter = context.lookup(Registries.BLOCK);
        context.register(DEEP_RAVINE, WorldCarver.CANYON.configured(new CanyonCarverConfiguration
                (0.00003F, UniformHeight.of(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(70)),
                        ConstantFloat.of(13.0F), VerticalAnchor.aboveBottom(8), CarverDebugSettings.of(false,
                        Blocks.WARPED_BUTTON.defaultBlockState()), holdergetter.getOrThrow(BlockTags.OVERWORLD_CARVER_REPLACEABLES),
                        UniformFloat.of(-1.0F, 1.0F),
                        new CanyonCarverConfiguration.CanyonShapeConfiguration(UniformFloat.of(0.75F, 1.25F),
                                TrapezoidFloat.of(5.0F, 12.0F, 2.0F), 3,
                                UniformFloat.of(0.75F, 1.0F), 1.0F, 0.0F))));
    }

    private static ResourceKey<ConfiguredWorldCarver<?>> register(String name) {
        return ResourceKey.create(Registries.CONFIGURED_CARVER, new ResourceLocation(Edumia.MODID, name));
    }
}
