package com.legends.edumia.block.block;

import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import com.legends.edumia.core.block.base.WaterloggedHorizontalDirectionalShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(
                name = "%s_vertical_corner_slab",
                template = "parent_vertical_corner_slab"
        ),
        item = @Model(
                name = "item/%s_vertical_corner_slab",
                parent = "block/%s_vertical_corner_slab_left",
                template = "item/parent_slab_corner"
        ),
        block = {@Model(
                name = "block/%s_vertical_corner_slab_left",
                template = "block/parent_vertical_corner_slab_left"
        ), @Model(
                name = "block/%s_vertical_corner_slab_bottom_left",
                template = "block/parent_vertical_corner_slab_bottom_left"
        ), @Model(
                name = "block/%s_vertical_corner_slab_right",
                template = "block/parent_vertical_corner_slab_right"
        ), @Model(
                name = "block/%s_vertical_corner_slab_bottom_right",
                template = "block/parent_vertical_corner_slab_bottom_right"
        )}
)
public class VerticalSlabCorner extends WaterloggedHorizontalDirectionalShape {
    public static final EnumProperty<Half> TYPE_UPDOWN = EnumProperty.create("type", Half.class);
    public static final EnumProperty<DoorHingeSide> HINGE;
    private static final VoxelShape ARCH_NORTH_R_SHAPE;
    private static final VoxelShape ARCH_NORTH_L_SHAPE;
    private static final VoxelShape ARCH_WEST_L_SHAPE;
    private static final VoxelShape ARCH_WEST_R_SHAPE;
    private static final VoxelShape ARCH_EAST_R_SHAPE;
    private static final VoxelShape ARCH_EAST_L_SHAPE;
    private static final VoxelShape ARCH_SOUTH_L_SHAPE;
    private static final VoxelShape ARCH_SOUTH_R_SHAPE;
    private static final VoxelShape ARCH_NORTH_R_BOTTOM_SHAPE;
    private static final VoxelShape ARCH_NORTH_L_BOTTOM_SHAPE;
    private static final VoxelShape ARCH_WEST_L_BOTTOM_SHAPE;
    private static final VoxelShape ARCH_WEST_R_BOTTOM_SHAPE;
    private static final VoxelShape ARCH_EAST_R_BOTTOM_SHAPE;
    private static final VoxelShape ARCH_EAST_L_BOTTOM_SHAPE;
    private static final VoxelShape ARCH_SOUTH_L_BOTTOM_SHAPE;
    private static final VoxelShape ARCH_SOUTH_R_BOTTOM_SHAPE;

    public VerticalSlabCorner(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(DIRECTION,
                Direction.NORTH)).setValue(TYPE_UPDOWN, Half.BOTTOM)).setValue(WATERLOGGED, false));
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluid = context.getLevel().getFluidState(blockpos);
        Direction facingHorizontal = context.getHorizontalDirection().getOpposite();
        BlockState state2 = (BlockState)((BlockState)((BlockState)this.defaultBlockState().setValue(DIRECTION,
                facingHorizontal)).setValue(TYPE_UPDOWN, Half.BOTTOM)).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
        Direction facing = context.getClickedFace();
        return facing == Direction.DOWN || facing != Direction.UP && context.getClickLocation().y -
                (double)context.getClickedPos().getY() > 0.5 ? (BlockState)((BlockState)state2.setValue
                (TYPE_UPDOWN, Half.TOP)).setValue(HINGE, this.getHingeSide(facingHorizontal, blockpos, context)) :
                (BlockState)state2.setValue(HINGE, this.getHingeSide(facingHorizontal, blockpos, context));
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        switch (rot) {
            case CLOCKWISE_90:
                switch ((Direction)state.getValue(DIRECTION)) {
                    case EAST:
                    case WEST:
                        return (BlockState)((BlockState)state.cycle(HINGE)).setValue(DIRECTION,
                                rot.rotate((Direction)state.getValue(DIRECTION)));
                    case NORTH:
                    case SOUTH:
                    default:
                        return (BlockState)state.setValue(DIRECTION, rot.rotate((Direction)state.getValue(DIRECTION)));
                }
            case CLOCKWISE_180:
                switch ((Direction)state.getValue(DIRECTION)) {
                    case EAST:
                    case WEST:
                    case NORTH:
                    case SOUTH:
                        return (BlockState)((BlockState)state.cycle(HINGE)).setValue(DIRECTION,
                                rot.rotate((Direction)state.getValue(DIRECTION)));
                    default:
                        return (BlockState)state.setValue(DIRECTION, rot.rotate((Direction)state.getValue(DIRECTION)));
                }
            case COUNTERCLOCKWISE_90:
                switch ((Direction)state.getValue(DIRECTION)) {
                    case EAST:
                    case WEST:
                        return (BlockState)state.setValue(DIRECTION, rot.rotate((Direction)state.getValue(DIRECTION)));
                    case NORTH:
                    case SOUTH:
                        return (BlockState)((BlockState)state.cycle(HINGE)).setValue(DIRECTION,
                                rot.rotate((Direction)state.getValue(DIRECTION)));
                }
            default:
                return state;
        }
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        switch (mirrorIn) {
            case FRONT_BACK:
                switch ((Direction)state.getValue(DIRECTION)) {
                    case EAST:
                    case WEST:
                    default:
                        return super.mirror(state, mirrorIn);
                    case NORTH:
                    case SOUTH:
                        return (BlockState)state.cycle(HINGE);
                }
            case LEFT_RIGHT:
                switch ((Direction)state.getValue(DIRECTION)) {
                    case EAST:
                    case WEST:
                        return (BlockState)state.cycle(HINGE);
                    case NORTH:
                    case SOUTH:
                    default:
                        return super.mirror(state, mirrorIn);
                }
            default:
                return super.mirror(state, mirrorIn);
        }
    }

    private DoorHingeSide getHingeSide(Direction facing, BlockPos pos, BlockPlaceContext context) {
        switch (facing) {
            case EAST:
                return !(context.getClickLocation().z - (double)pos.getZ() > 0.5) ? DoorHingeSide.RIGHT : DoorHingeSide.LEFT;
            case WEST:
            default:
                return !(context.getClickLocation().z - (double)pos.getZ() < 0.5) ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
            case NORTH:
                return !(context.getClickLocation().x - (double)pos.getX() > 0.5) ? DoorHingeSide.RIGHT : DoorHingeSide.LEFT;
            case SOUTH:
                return !(context.getClickLocation().x - (double)pos.getX() < 0.5) ? DoorHingeSide.LEFT : DoorHingeSide.RIGHT;
        }
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> container) {
        container.add(new Property[]{TYPE_UPDOWN}).add(new Property[]{HINGE});
    }

    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TYPE_UPDOWN) == Half.TOP) {
            if (state.getValue(HINGE) == DoorHingeSide.LEFT) {
                switch ((Direction)state.getValue(DIRECTION)) {
                    case EAST:
                        return ARCH_EAST_L_SHAPE;
                    case WEST:
                        return ARCH_WEST_L_SHAPE;
                    case NORTH:
                    default:
                        return ARCH_NORTH_L_SHAPE;
                    case SOUTH:
                        return ARCH_SOUTH_L_SHAPE;
                }
            } else {
                switch ((Direction)state.getValue(DIRECTION)) {
                    case EAST:
                        return ARCH_EAST_R_SHAPE;
                    case WEST:
                        return ARCH_WEST_R_SHAPE;
                    case NORTH:
                    default:
                        return ARCH_NORTH_R_SHAPE;
                    case SOUTH:
                        return ARCH_SOUTH_R_SHAPE;
                }
            }
        } else if (state.getValue(HINGE) == DoorHingeSide.LEFT) {
            switch ((Direction)state.getValue(DIRECTION)) {
                case EAST:
                    return ARCH_EAST_L_BOTTOM_SHAPE;
                case WEST:
                    return ARCH_WEST_L_BOTTOM_SHAPE;
                case NORTH:
                default:
                    return ARCH_NORTH_L_BOTTOM_SHAPE;
                case SOUTH:
                    return ARCH_SOUTH_L_BOTTOM_SHAPE;
            }
        } else {
            switch ((Direction)state.getValue(DIRECTION)) {
                case EAST:
                    return ARCH_EAST_R_BOTTOM_SHAPE;
                case WEST:
                    return ARCH_WEST_R_BOTTOM_SHAPE;
                case NORTH:
                default:
                    return ARCH_NORTH_R_BOTTOM_SHAPE;
                case SOUTH:
                    return ARCH_SOUTH_R_BOTTOM_SHAPE;
            }
        }
    }

    static {
        HINGE = BlockStateProperties.DOOR_HINGE;
        ARCH_NORTH_R_SHAPE = Shapes.or
                (Block.box(0.0, 8.0, 8.0, 16.0, 16.0, 16.0),
                        Block.box(0.0, 0.0, 8.0, 8.0, 8.0, 16.0));
        ARCH_NORTH_L_SHAPE = Shapes.or
                (Block.box(8.0, 0.0, 8.0, 16.0, 16.0, 16.0),
                        Block.box(0.0, 8.0, 8.0, 8.0, 16.0, 16.0));
        ARCH_WEST_L_SHAPE = Shapes.or
                (Block.box(8.0, 8.0, 0.0, 16.0, 16.0, 16.0),
                        Block.box(8.0, 0.0, 8.0, 16.0, 8.0, 16.0));
        ARCH_WEST_R_SHAPE = Shapes.or
                (Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 8.0),
                        Block.box(8.0, 8.0, 8.0, 16.0, 16.0, 16.0));
        ARCH_EAST_R_SHAPE = Shapes.or
                (Block.box(0.0, 8.0, 0.0, 8.0, 16.0, 16.0),
                        Block.box(0.0, 0.0, 0.0, 8.0, 8.0, 8.0));
        ARCH_EAST_L_SHAPE = Shapes.or
                (Block.box(0.0, 0.0, 8.0, 8.0, 16.0, 16.0),
                        Block.box(0.0, 8.0, 0.0, 8.0, 16.0, 8.0));
        ARCH_SOUTH_L_SHAPE = Shapes.or
                (Block.box(0.0, 8.0, 0.0, 16.0, 16.0, 8.0),
                        Block.box(8.0, 0.0, 0.0, 16.0, 8.0, 8.0));
        ARCH_SOUTH_R_SHAPE = Shapes.or
                (Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 8.0),
                        Block.box(8.0, 8.0, 0.0, 16.0, 16.0, 8.0));
        ARCH_NORTH_R_BOTTOM_SHAPE = Shapes.or
                (Block.box(0.0, 0.0, 8.0, 16.0, 8.0, 16.0),
                        Block.box(0.0, 8.0, 8.0, 8.0, 16.0, 16.0));
        ARCH_NORTH_L_BOTTOM_SHAPE = Shapes.or
                (Block.box(8.0, 0.0, 8.0, 16.0, 16.0, 16.0),
                        Block.box(0.0, 0.0, 8.0, 8.0, 8.0, 16.0));
        ARCH_WEST_L_BOTTOM_SHAPE = Shapes.or
                (Block.box(8.0, 0.0, 0.0, 16.0, 8.0, 16.0),
                        Block.box(8.0, 8.0, 8.0, 16.0, 16.0, 16.0));
        ARCH_WEST_R_BOTTOM_SHAPE = Shapes.or
                (Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 8.0),
                        Block.box(8.0, 0.0, 8.0, 16.0, 8.0, 16.0));
        ARCH_EAST_R_BOTTOM_SHAPE = Shapes.or
                (Block.box(0.0, 0.0, 0.0, 8.0, 8.0, 16.0),
                        Block.box(0.0, 8.0, 0.0, 8.0, 16.0, 8.0));
        ARCH_EAST_L_BOTTOM_SHAPE = Shapes.or
                (Block.box(0.0, 0.0, 8.0, 8.0, 16.0, 16.0),
                        Block.box(0.0, 0.0, 0.0, 8.0, 8.0, 8.0));
        ARCH_SOUTH_L_BOTTOM_SHAPE = Shapes.or
                (Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 8.0),
                        Block.box(8.0, 8.0, 0.0, 16.0, 16.0, 8.0));
        ARCH_SOUTH_R_BOTTOM_SHAPE = Shapes.or
                (Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 8.0),
                        Block.box(8.0, 0.0, 0.0, 16.0, 8.0, 8.0));
    }
}

