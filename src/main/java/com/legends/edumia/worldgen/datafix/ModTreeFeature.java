package com.legends.edumia.worldgen.datafix;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

public class ModTreeFeature extends TreeFeature {
    public ModTreeFeature(Codec<TreeConfiguration> p_67201_) {
        super(p_67201_);
    }

    public static void setBlockKnownShape(LevelWriter p_67257_, BlockPos p_67258_, BlockState p_67259_) {
        p_67257_.setBlock(p_67258_, p_67259_, 19);
    }
}
