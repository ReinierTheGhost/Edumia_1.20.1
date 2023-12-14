package com.legends.edumia.datafix;

import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

public class ModWeightedStateProvider extends WeightedStateProvider {

    public final SimpleWeightedRandomList<BlockState> weightedList;
    public ModWeightedStateProvider(SimpleWeightedRandomList<BlockState> p_161596_, SimpleWeightedRandomList<BlockState> weightedList) {
        super(p_161596_);
        this.weightedList = weightedList;
    }
}
