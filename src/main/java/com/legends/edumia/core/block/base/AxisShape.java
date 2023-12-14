package com.legends.edumia.core.block.base;

import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public abstract class AxisShape extends Shape {
    public static final EnumProperty<Direction.Axis> AXIS;

    public AxisShape(BlockBehaviour.Properties builder) {
        super(builder);
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        switch (rot) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch ((Direction.Axis)state.getValue(AXIS)) {
                    case X:
                        return (BlockState)state.setValue(AXIS, Direction.Axis.Z);
                    case Z:
                        return (BlockState)state.setValue(AXIS, Direction.Axis.X);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AXIS});
        this.addProperties(builder);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState)this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis());
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
    }

    static {
        AXIS = BlockStateProperties.AXIS;
    }
}
