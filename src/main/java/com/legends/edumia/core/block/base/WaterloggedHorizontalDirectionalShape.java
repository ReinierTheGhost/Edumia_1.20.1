package com.legends.edumia.core.block.base;

import javax.annotation.Nonnull;

import com.legends.edumia.core.block.properties.Waterloggable;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public abstract class WaterloggedHorizontalDirectionalShape extends Shape implements Waterloggable {
    public static final DirectionProperty DIRECTION;

    public WaterloggedHorizontalDirectionalShape(BlockBehaviour.Properties builder) {
        super(builder);
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue(DIRECTION, rot.rotate((Direction)state.getValue(DIRECTION)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return (BlockState)state.setValue(DIRECTION, mirrorIn.mirror((Direction)state.getValue(DIRECTION)));
    }

    @Nonnull
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection().getOpposite();
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        return (BlockState)((BlockState)super.getStateForPlacement(context).setValue(DIRECTION, facing)).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    protected final void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{DIRECTION, WATERLOGGED});
        this.addProperties(builder);
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
    }

    static {
        DIRECTION = BlockStateProperties.HORIZONTAL_FACING;
    }
}
