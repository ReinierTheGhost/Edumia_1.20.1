package com.legends.edumia.dynamictrees.systems.substance;

import com.legends.edumia.dynamictrees.api.substance.SubstanceEffect;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class FertilizeSubstance implements SubstanceEffect {

    private int amount = 2;
    private boolean displayParticles = true;
    private boolean grow;
    private Supplier<Integer> pulses = () -> 1;

    public FertilizeSubstance setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    /**
     * If growth is enabled then the tree will take an update and the item will be consumed.  Regardless of if it is
     * fully fertilised.
     *
     * @param grow
     * @return
     */
    public FertilizeSubstance setGrow(boolean grow) {
        this.grow = grow;
        return this;
    }

    public FertilizeSubstance setPulses(final int pulses) {
        return this.setPulses(() -> pulses);
    }

    public FertilizeSubstance setPulses(final Supplier<Integer> pulses) {
        this.pulses = pulses;
        return this;
    }

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
