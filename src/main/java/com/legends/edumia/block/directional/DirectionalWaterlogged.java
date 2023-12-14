package com.legends.edumia.block.directional;

import com.legends.edumia.core.block.base.DirectionalShape;
import com.legends.edumia.core.block.builder.Props;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class DirectionalWaterlogged extends DirectionalShape {
    private final List<VoxelShape> hitBox;

    public DirectionalWaterlogged(Props props) {
        super(props.toProperties());
        this.hitBox = (List)props.get("hitBox", List.class);
    }

    public VoxelShape getShape(BlockState state) {
        boolean hasSixShapes = this.hitBox.size() == 6;
        switch ((Direction)state.getValue(DIRECTION)) {
            case EAST:
                return (VoxelShape)this.hitBox.get(hasSixShapes ? 1 : 0);
            case SOUTH:
                return (VoxelShape)this.hitBox.get(hasSixShapes ? 2 : 0);
            case WEST:
                return (VoxelShape)this.hitBox.get(hasSixShapes ? 3 : 0);
            case UP:
                return (VoxelShape)this.hitBox.get(hasSixShapes ? 4 : 0);
            case DOWN:
                return (VoxelShape)this.hitBox.get(hasSixShapes ? 5 : 0);
            default:
                return (VoxelShape)this.hitBox.get(0);
        }
    }
}
