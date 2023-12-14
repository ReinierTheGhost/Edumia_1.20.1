package com.legends.edumia.block.directional;

import com.legends.edumia.core.block.base.AxisShape;
import com.legends.edumia.core.block.builder.Props;
import java.util.List;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AxisDirectional extends AxisShape {
    private final List<VoxelShape> hitBox;

    public AxisDirectional(Props props) {
        super(props.toProperties());
        this.hitBox = (List)props.get("hitBox", List.class);
    }

    public VoxelShape getShape(BlockState state) {
        boolean hasThreeShapes = this.hitBox.size() == 3;
        if (state.getValue(AXIS) == Axis.Y) {
            return (VoxelShape)this.hitBox.get(hasThreeShapes ? 1 : 0);
        } else {
            return state.getValue(AXIS) == Axis.X ? (VoxelShape)this.hitBox.get(hasThreeShapes ? 2 : 0) : (VoxelShape)this.hitBox.get(0);
        }
    }
}
