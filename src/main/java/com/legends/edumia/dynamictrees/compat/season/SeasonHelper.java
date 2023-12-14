package com.legends.edumia.dynamictrees.compat.season;

import com.legends.edumia.dynamictrees.api.season.SeasonManager;
import com.legends.edumia.dynamictrees.init.DTConfigs;
import com.legends.edumia.dynamictrees.util.LevelContext;
import net.minecraft.core.BlockPos;

public class SeasonHelper {

    private static SeasonManager seasonManager = NormalSeasonManager.NULL.get();
    static public float globalSeasonalSeedDropFactor(LevelContext levelContext, BlockPos pos, float offset) {
        return DTConfigs.ENABLE_SEASONAL_SEED_DROP_FACTOR.get() ? seasonManager.getSeedDropFactor(levelContext.level(), pos, offset) : 1.0F;
    }
}
