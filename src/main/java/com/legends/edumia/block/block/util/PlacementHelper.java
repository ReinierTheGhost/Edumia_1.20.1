package com.legends.edumia.block.block.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.DirectionalPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;

public class PlacementHelper {
    public PlacementHelper() {
    }

    public static boolean replacingClickedOnBlock(BlockPlaceContext context) {
        return context instanceof DirectionalPlaceContext ? false : context.replacingClickedOnBlock();
    }

    public static boolean isDuringWorldGen(BlockGetter reader) {
        return !(reader instanceof Level);
    }

    public static Direction getHitVecHorizontalAxisDirection(Direction facing, BlockPos pos, BlockPlaceContext context) {
        switch (facing) {
            case NORTH:
                return !(context.getClickLocation().x - (double)pos.getX() > 0.5) ? facing.getClockWise() : facing;
            case SOUTH:
                return !(context.getClickLocation().x - (double)pos.getX() < 0.5) ? facing.getClockWise() : facing;
            case EAST:
                return !(context.getClickLocation().z - (double)pos.getZ() > 0.5) ? facing.getClockWise() : facing;
            default:
                return !(context.getClickLocation().z - (double)pos.getZ() < 0.5) ? facing.getClockWise() : facing;
        }
    }
}
