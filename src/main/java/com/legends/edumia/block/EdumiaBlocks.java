package com.legends.edumia.block;

import net.minecraft.world.level.block.state.BlockState;

import java.util.function.ToIntFunction;

public class EdumiaBlocks {
    public static ToIntFunction<BlockState> constantLight(int light) {
        return (state) -> {
            return light;
        };
    }
}
