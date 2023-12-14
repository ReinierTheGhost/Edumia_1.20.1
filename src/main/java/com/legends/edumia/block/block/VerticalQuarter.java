package com.legends.edumia.block.block;


import com.legends.edumia.block.block.util.PlacementHelper;
import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import com.legends.edumia.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.legends.edumia.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(
                name = "%s_vertical_quarter",
                template = "parent_vertical_quarter"
        ),
        item = @Model(
                name = "item/%s_vertical_quarter",
                parent = "block/%s_vertical_quarter_4",
                template = "item/parent_vertical_quarter"
        ),
        block = {@Model(
                name = "block/%s_vertical_quarter_1",
                template = "block/parent_vertical_quarter_1"
        ), @Model(
                name = "block/%s_vertical_quarter_2",
                template = "block/parent_vertical_quarter_2"
        ), @Model(
                name = "block/%s_vertical_quarter_4",
                template = "block/parent_vertical_quarter_4"
        ), @Model(
                name = "block/%s_vertical_quarter_6",
                template = "block/parent_vertical_quarter_6"
        )}
)
public class VerticalQuarter extends WaterloggedHorizontalDirectionalShape {
    public static final IntegerProperty LAYERS = IntegerProperty.create("layer", 1, 4);
    public static final VoxelShape[] NORTH_SHAPE = new VoxelShape[]{Block.box(14.0, 0.0, 14.0, 16.0, 16.0, 16.0), Block.box(12.0, 0.0, 12.0, 16.0, 16.0, 16.0), Block.box(8.0, 0.0, 8.0, 16.0, 16.0, 16.0), Block.box(4.0, 0.0, 4.0, 16.0, 16.0, 16.0)};
    public static final VoxelShape[] SOUTH_SHAPE = new VoxelShape[]{Block.box(0.0, 0.0, 0.0, 2.0, 16.0, 2.0), Block.box(0.0, 0.0, 0.0, 4.0, 16.0, 4.0), Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 8.0), Block.box(0.0, 0.0, 0.0, 12.0, 16.0, 12.0)};
    public static final VoxelShape[] EAST_SHAPE = new VoxelShape[]{Block.box(0.0, 0.0, 14.0, 2.0, 16.0, 16.0), Block.box(0.0, 0.0, 12.0, 4.0, 16.0, 16.0), Block.box(0.0, 0.0, 8.0, 8.0, 16.0, 16.0), Block.box(0.0, 0.0, 4.0, 12.0, 16.0, 16.0)};
    public static final VoxelShape[] WEST_SHAPE = new VoxelShape[]{Block.box(14.0, 0.0, 0.0, 16.0, 16.0, 2.0), Block.box(12.0, 0.0, 0.0, 16.0, 16.0, 4.0), Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 8.0), Block.box(4.0, 0.0, 0.0, 16.0, 16.0, 12.0)};
    private Block fullBlock;

    public VerticalQuarter(Props props) {
        super(props.toProperties());
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(DIRECTION, Direction.NORTH)).setValue(WATERLOGGED, false));
        this.fullBlock = props.getParent().getBlock();
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        switch (mirrorIn) {
            case FRONT_BACK:
                switch ((Direction)state.getValue(DIRECTION)) {
                    case NORTH:
                        return (BlockState)state.setValue(DIRECTION, Direction.EAST);
                    case EAST:
                        return (BlockState)state.setValue(DIRECTION, Direction.NORTH);
                    case SOUTH:
                        return (BlockState)state.setValue(DIRECTION, Direction.WEST);
                    case WEST:
                        return (BlockState)state.setValue(DIRECTION, Direction.SOUTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
            case LEFT_RIGHT:
                switch ((Direction)state.getValue(DIRECTION)) {
                    case NORTH:
                        return (BlockState)state.setValue(DIRECTION, Direction.WEST);
                    case EAST:
                        return (BlockState)state.setValue(DIRECTION, Direction.SOUTH);
                    case SOUTH:
                        return (BlockState)state.setValue(DIRECTION, Direction.EAST);
                    case WEST:
                        return (BlockState)state.setValue(DIRECTION, Direction.NORTH);
                    default:
                        return super.mirror(state, mirrorIn);
                }
            default:
                return super.mirror(state, mirrorIn);
        }
    }

    public VoxelShape getShape(BlockState state) {
        switch ((Direction)state.getValue(DIRECTION)) {
            case NORTH:
            default:
                return NORTH_SHAPE[(Integer)state.getValue(LAYERS) - 1];
            case EAST:
                return EAST_SHAPE[(Integer)state.getValue(LAYERS) - 1];
            case SOUTH:
                return SOUTH_SHAPE[(Integer)state.getValue(LAYERS) - 1];
            case WEST:
                return WEST_SHAPE[(Integer)state.getValue(LAYERS) - 1];
        }
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        int i = (Integer)state.getValue(LAYERS);
        if (context.getItemInHand().getItem() == this.asItem() && i <= 4) {
            if (!PlacementHelper.replacingClickedOnBlock(context)) {
                return true;
            } else {
                return context.getClickedFace() == state.getValue(DIRECTION) || context.getClickedFace() == ((Direction)state.getValue(DIRECTION)).getCounterClockWise();
            }
        } else {
            return false;
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Direction facing = PlacementHelper.getHitVecHorizontalAxisDirection(context.getHorizontalDirection().getOpposite(), blockpos, context);
        BlockState blockstate = context.getLevel().getBlockState(blockpos);
        if (blockstate.getBlock() == this) {
            int i = (Integer)blockstate.getValue(LAYERS);
            return i == 4 ? this.fullBlock.defaultBlockState() : (BlockState)blockstate.setValue(LAYERS, Math.min(4, i + 1));
        } else {
            return (BlockState)super.getStateForPlacement(context).setValue(DIRECTION, facing);
        }
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LAYERS});
    }
}
