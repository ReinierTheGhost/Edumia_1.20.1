package com.legends.edumia.worldgen.tree.treegrower;

import com.legends.edumia.worldgen.ModConfiguredFeatures;
import com.legends.edumia.worldgen.features.YosemiteFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class RedOakTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_,
                                                                        boolean p_222911_) {
        return p_222911_ ? YosemiteFeatures.OAK_KEY : YosemiteFeatures.OAK_MEGA_KEY;
    }
}
