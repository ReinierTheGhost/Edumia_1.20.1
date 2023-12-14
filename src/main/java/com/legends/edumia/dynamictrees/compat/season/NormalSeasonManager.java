package com.legends.edumia.dynamictrees.compat.season;

import com.legends.edumia.dynamictrees.api.season.SeasonManager;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class NormalSeasonManager implements SeasonManager {

    public static final Supplier<NormalSeasonManager> NULL = NormalSeasonManager::new;
    @Override
    public void updateTick(Level level, long dayTime) {

    }

    @Override
    public void flushMappings() {

    }

    @Override
    public float getGrowthFactor(Level level, BlockPos rootPos, float offset) {
        return 0;
    }

    @Override
    public float getSeedDropFactor(Level level, BlockPos rootPos, float offset) {
        return 0;
    }

    @Override
    public float getFruitProductionFactor(Level level, BlockPos rootPos, float offset, boolean getAsScan) {
        return 0;
    }

    @Override
    public Float getSeasonValue(Level level, BlockPos rootPos) {
        return null;
    }

    @Override
    public Float getPeakFruitProductionSeasonValue(Level level, BlockPos rootPos, float offset) {
        return null;
    }

    @Override
    public boolean isTropical(Level level, BlockPos rootPos) {
        return false;
    }

    @Override
    public boolean shouldSnowMelt(Level level, BlockPos pos) {
        return false;
    }
}
