package com.legends.edumia.block.directional;

import java.util.List;

import com.legends.edumia.core.block.base.BiDirectionalShape;
import com.legends.edumia.core.block.builder.Props;
import com.legends.edumia.core.block.properties.BidirectionalShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BiDirectional extends BiDirectionalShape {
    private final List<VoxelShape> hitBox;

    public BiDirectional(Props props) {
        super(props.toProperties());
        this.hitBox = (List)props.get("hitBox", List.class);
    }

    public VoxelShape getShape(BlockState state) {
        boolean hasTwoShapes = this.hitBox.size() == 2;
        return state.getValue(DIRECTION) == BidirectionalShape.EAST_WEST ? (VoxelShape)this.hitBox.get(hasTwoShapes ? 1 : 0) :
                (VoxelShape)this.hitBox.get(0);
    }
}
