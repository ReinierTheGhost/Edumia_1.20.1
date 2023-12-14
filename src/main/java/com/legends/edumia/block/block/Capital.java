package com.legends.edumia.block.block;

import com.legends.edumia.core.block.properties.CapitalDirection;
import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import com.legends.edumia.core.block.base.WaterloggedShape;
import com.legends.edumia.core.block.properties.Waterloggable;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(
                name = "%s_capital",
                template = "parent_capital"
        ),
        item = @Model(
                name = "item/%s_capital",
                parent = "block/%s_capital_down_flat",
                template = "item/parent_capital"
        ),
        block = {@Model(
                name = "block/%s_capital_down_flat",
                template = "block/parent_capital_down_flat"
        ), @Model(
                name = "block/%s_capital_down_side",
                template = "block/parent_capital_down_side"
        ), @Model(
                name = "block/%s_capital_up_flat",
                template = "block/parent_capital_up_flat"
        ), @Model(
                name = "block/%s_capital_up_side",
                template = "block/parent_capital_up_side"
        )}
)
public class Capital extends WaterloggedShape implements Waterloggable {
    public static final EnumProperty<CapitalDirection> FACING = EnumProperty.create("facing", CapitalDirection.class);
    public static final EnumProperty<Half> TYPE = EnumProperty.create("type", Half.class);
    private static final VoxelShape TOP_FLAT_BIG = Block.box(0.0, 8.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape TOP_FLAT_MIDDLE = Block.box(4.0, 0.0, 4.0, 12.0, 10.0, 12.0);
    private static final VoxelShape TOP_FLAT;
    private static final VoxelShape BOTTOM_FLAT_BIG;
    private static final VoxelShape BOTTOM_FLAT_MIDDLE;
    private static final VoxelShape BOTTOM_FLAT;
    private static final VoxelShape BOTTOM_SIDE_BIG;
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_N;
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_S;
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_E;
    private static final VoxelShape BOTTOM_SIDE_MIDDLE_W;
    private static final VoxelShape BOTTOM_SIDE_N;
    private static final VoxelShape BOTTOM_SIDE_S;
    private static final VoxelShape BOTTOM_SIDE_E;
    private static final VoxelShape BOTTOM_SIDE_W;
    private static final VoxelShape TOP_SIDE_BIG;
    private static final VoxelShape TOP_SIDE_MIDDLE_N;
    private static final VoxelShape TOP_SIDE_MIDDLE_S;
    private static final VoxelShape TOP_SIDE_MIDDLE_E;
    private static final VoxelShape TOP_SIDE_MIDDLE_W;
    private static final VoxelShape TOP_SIDE_N;
    private static final VoxelShape TOP_SIDE_S;
    private static final VoxelShape TOP_SIDE_E;
    private static final VoxelShape TOP_SIDE_W;

    public Capital(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(TYPE, Half.TOP)).setValue(FACING, CapitalDirection.NORTH)).setValue(WATERLOGGED, false));
    }

    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TYPE) == Half.TOP) {
            if (state.getValue(FACING) == CapitalDirection.NORTH) {
                return TOP_SIDE_N;
            } else if (state.getValue(FACING) == CapitalDirection.SOUTH) {
                return TOP_SIDE_S;
            } else if (state.getValue(FACING) == CapitalDirection.EAST) {
                return TOP_SIDE_E;
            } else {
                return state.getValue(FACING) == CapitalDirection.WEST ? TOP_SIDE_W : TOP_FLAT;
            }
        } else if (state.getValue(FACING) == CapitalDirection.NORTH) {
            return BOTTOM_SIDE_N;
        } else if (state.getValue(FACING) == CapitalDirection.SOUTH) {
            return BOTTOM_SIDE_S;
        } else if (state.getValue(FACING) == CapitalDirection.EAST) {
            return BOTTOM_SIDE_E;
        } else {
            return state.getValue(FACING) == CapitalDirection.WEST ? BOTTOM_SIDE_W : BOTTOM_FLAT;
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        Direction facing = context.getClickedFace();
        CapitalDirection horizontalFacing;
        switch (facing) {
            case NORTH:
                horizontalFacing = CapitalDirection.SOUTH;
                break;
            case SOUTH:
                horizontalFacing = CapitalDirection.NORTH;
                break;
            case WEST:
                horizontalFacing = CapitalDirection.EAST;
                break;
            case EAST:
                horizontalFacing = CapitalDirection.WEST;
                break;
            default:
                horizontalFacing = CapitalDirection.FLAT;
        }

        Half verticalFacing;
        if (facing == Direction.DOWN || facing != Direction.UP && !(context.getClickLocation().y <= 0.5)) {
            verticalFacing = Half.TOP;
        } else {
            verticalFacing = Half.BOTTOM;
        }

        return (BlockState)((BlockState)((BlockState)super.getStateForPlacement(context).setValue(TYPE, verticalFacing)).setValue(FACING, horizontalFacing)).setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{TYPE, FACING});
    }

    static {
        TOP_FLAT = Shapes.or(TOP_FLAT_BIG, TOP_FLAT_MIDDLE);
        BOTTOM_FLAT_BIG = Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);
        BOTTOM_FLAT_MIDDLE = Block.box(4.0, 6.0, 4.0, 12.0, 16.0, 12.0);
        BOTTOM_FLAT = Shapes.or(BOTTOM_FLAT_BIG, BOTTOM_FLAT_MIDDLE);
        BOTTOM_SIDE_BIG = Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0);
        BOTTOM_SIDE_MIDDLE_N = Block.box(3.0, 6.0, 0.0, 13.0, 12.0, 13.0);
        BOTTOM_SIDE_MIDDLE_S = Block.box(3.0, 6.0, 3.0, 13.0, 12.0, 16.0);
        BOTTOM_SIDE_MIDDLE_E = Block.box(3.0, 6.0, 3.0, 16.0, 12.0, 13.0);
        BOTTOM_SIDE_MIDDLE_W = Block.box(0.0, 6.0, 3.0, 13.0, 12.0, 13.0);
        BOTTOM_SIDE_N = Shapes.or(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_N);
        BOTTOM_SIDE_S = Shapes.or(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_S);
        BOTTOM_SIDE_E = Shapes.or(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_E);
        BOTTOM_SIDE_W = Shapes.or(BOTTOM_SIDE_BIG, BOTTOM_SIDE_MIDDLE_W);
        TOP_SIDE_BIG = Block.box(0.0, 10.0, 0.0, 16.0, 16.0, 16.0);
        TOP_SIDE_MIDDLE_N = Block.box(12.0, 4.0, 0.0, 16.0, 10.0, 12.0);
        TOP_SIDE_MIDDLE_S = Block.box(4.0, 4.0, 4.0, 12.0, 10.0, 16.0);
        TOP_SIDE_MIDDLE_E = Block.box(4.0, 4.0, 4.0, 16.0, 10.0, 12.0);
        TOP_SIDE_MIDDLE_W = Block.box(0.0, 4.0, 4.0, 12.0, 10.0, 12.0);
        TOP_SIDE_N = Shapes.or(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_N);
        TOP_SIDE_S = Shapes.or(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_S);
        TOP_SIDE_E = Shapes.or(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_E);
        TOP_SIDE_W = Shapes.or(TOP_SIDE_BIG, TOP_SIDE_MIDDLE_W);
    }
}