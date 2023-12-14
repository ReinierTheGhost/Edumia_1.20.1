package com.legends.edumia.dynamictrees.systems.substance;

import com.legends.edumia.dynamictrees.api.substance.SubstanceEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class GrowthSubstance implements SubstanceEffect {
    @Override
    public boolean apply(Level level, BlockPos rootPos) {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean isLingering() {
        return false;
    }
}
