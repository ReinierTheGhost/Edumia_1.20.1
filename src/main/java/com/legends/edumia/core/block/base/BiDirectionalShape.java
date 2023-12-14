package com.legends.edumia.core.block.base;

import javax.annotation.Nonnull;

import com.legends.edumia.core.block.properties.BidirectionalShape;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

public abstract class BiDirectionalShape extends Shape {
    public static final EnumProperty DIRECTION = EnumProperty.create("direction", BidirectionalShape.class);

    public BiDirectionalShape(BlockBehaviour.Properties builder) {
        super(builder);
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.getValue(DIRECTION) == BidirectionalShape.NORTH_SOUTH ? (BlockState)state.setValue(DIRECTION, BidirectionalShape.EAST_WEST) : (BlockState)state.setValue(DIRECTION, BidirectionalShape.NORTH_SOUTH);
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state;
    }

    @Nonnull
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BidirectionalShape facing = BidirectionalShape.EAST_WEST;
        if (context.getHorizontalDirection() == Direction.NORTH || context.getHorizontalDirection() == Direction.SOUTH) {
            facing = BidirectionalShape.NORTH_SOUTH;
        }

        return (BlockState)super.getStateForPlacement(context).setValue(DIRECTION, facing);
    }

    protected final void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{DIRECTION});
        this.addProperties(builder);
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
    }
}
