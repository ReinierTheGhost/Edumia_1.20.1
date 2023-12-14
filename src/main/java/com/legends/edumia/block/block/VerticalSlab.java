package com.legends.edumia.block.block;


import com.legends.edumia.block.block.util.PlacementHelper;
import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import com.legends.edumia.core.block.base.WaterloggedHorizontalDirectionalShape;
import com.legends.edumia.core.block.builder.Props;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(
                name = "%s_vertical_slab",
                template = "parent_vertical_slab"
        ),
        item = @Model(
                name = "item/%s_vertical_slab",
                parent = "block/%s_vertical_slab_4",
                template = "item/parent_vertical_slab"
        ),
        block = {@Model(
                name = "block/%s_vertical_slab_1",
                template = "block/parent_vertical_slab_1"
        ), @Model(
                name = "block/%s_vertical_slab_2",
                template = "block/parent_vertical_slab_2"
        ), @Model(
                name = "block/%s_vertical_slab_4",
                template = "block/parent_vertical_slab_4"
        ), @Model(
                name = "block/%s_vertical_slab_6",
                template = "block/parent_vertical_slab_6"
        )}
)
public class VerticalSlab extends WaterloggedHorizontalDirectionalShape {
    public static final IntegerProperty LAYERS = IntegerProperty.create("layer", 1, 4);
    public static final VoxelShape[] EAST_SHAPE = new VoxelShape[]{Block.box(0.0, 0.0, 0.0, 2.0, 16.0, 16.0), Block.box(0.0, 0.0, 0.0, 4.0, 16.0, 16.0), Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 16.0), Block.box(0.0, 0.0, 0.0, 12.0, 16.0, 16.0)};
    public static final VoxelShape[] WEST_SHAPE = new VoxelShape[]{Block.box(14.0, 0.0, 0.0, 16.0, 16.0, 16.0), Block.box(12.0, 0.0, 0.0, 16.0, 16.0, 16.0), Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 16.0), Block.box(4.0, 0.0, 0.0, 16.0, 16.0, 16.0)};
    public static final VoxelShape[] SOUTH_SHAPE = new VoxelShape[]{Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 2.0), Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 4.0), Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 8.0), Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 12.0)};
    public static final VoxelShape[] NORTH_SHAPE = new VoxelShape[]{Block.box(0.0, 0.0, 14.0, 16.0, 16.0, 16.0), Block.box(0.0, 0.0, 12.0, 16.0, 16.0, 16.0), Block.box(0.0, 0.0, 8.0, 16.0, 16.0, 16.0), Block.box(0.0, 0.0, 4.0, 16.0, 16.0, 16.0)};
    private Block fullBlock;

    public VerticalSlab(Props props) {
        super(props.toProperties());
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(DIRECTION, Direction.NORTH)).setValue(WATERLOGGED, false));
        this.fullBlock = props.getParent().getBlock();
    }

    public VoxelShape getShape(BlockState state) {
        switch ((Direction)state.getValue(DIRECTION)) {
            case NORTH:
            default:
                return NORTH_SHAPE[(Integer)state.getValue(LAYERS) - 1];
            case SOUTH:
                return SOUTH_SHAPE[(Integer)state.getValue(LAYERS) - 1];
            case WEST:
                return WEST_SHAPE[(Integer)state.getValue(LAYERS) - 1];
            case EAST:
                return EAST_SHAPE[(Integer)state.getValue(LAYERS) - 1];
        }
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        int i = (Integer)state.getValue(LAYERS);
        if (context.getItemInHand().getItem() == this.asItem() && i <= 4) {
            if (PlacementHelper.replacingClickedOnBlock(context)) {
                return context.getClickedFace() == state.getValue(DIRECTION);
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.getBlock() == this) {
            int i = (Integer)blockstate.getValue(LAYERS);
            return i == 4 ? this.fullBlock.defaultBlockState() : (BlockState)blockstate.setValue(LAYERS, Math.min(4, i + 1));
        } else {
            return super.getStateForPlacement(context);
        }
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LAYERS});
    }
}
