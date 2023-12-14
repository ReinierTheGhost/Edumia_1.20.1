package com.legends.edumia.worldgen.features;

import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.IntProviderType;

public class FeatureSpread extends IntProvider {

    public FeatureSpread(int fixed, int i) {
    }

    public static FeatureSpread fixed(int fixed){
        return new FeatureSpread(fixed, 0);
    }

    public static FeatureSpread of(int i, int o){
        return new FeatureSpread(i, o);
    }
    @Override
    public int sample(RandomSource p_216855_) {
        return 0;
    }

    @Override
    public int getMinValue() {
        return 0;
    }

    @Override
    public int getMaxValue() {
        return 0;
    }

    @Override
    public IntProviderType<?> getType() {
        return null;
    }
}
