package com.legends.edumia.worldgen.tree.treegrower;

import com.legends.edumia.worldgen.ModConfiguredFeatures;
import com.legends.edumia.worldgen.features.ModTreeFeatures;
import com.legends.edumia.worldgen.features.MountainsFeatures;
import com.legends.edumia.worldgen.placement.ModTreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class AspenTreeGrower  extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_,
                                                                        boolean p_222911_) {
        return MountainsFeatures.MISTY_TREES_BIRCH;
    }
}
