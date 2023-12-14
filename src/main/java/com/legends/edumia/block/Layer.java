package com.legends.edumia.block;

import com.legends.edumia.block.block.util.PlacementHelper;
import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import com.legends.edumia.core.block.base.WaterloggedShape;
import com.legends.edumia.core.block.builder.Props;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(
                name = "%s_layer",
                template = "parent_layer"
        ),
        item = @Model(
                name = "item/%s_layer",
                parent = "block/%s_layer_height2",
                template = "item/snow"
        ),
        block = {@Model(
                name = "block/%s_layer_height2",
                template = "block/snow_height2"
        ), @Model(
                name = "block/%s_layer_height4",
                template = "block/snow_height4"
        ), @Model(
                name = "block/%s_layer_height6",
                template = "block/snow_height6"
        ), @Model(
                name = "block/%s_layer_height8",
                template = "block/snow_height8"
        ), @Model(
                name = "block/%s_layer_height10",
                template = "block/snow_height10"
        ), @Model(
                name = "block/%s_layer_height12",
                template = "block/snow_height12"
        ), @Model(
                name = "block/%s_layer_height14",
                template = "block/snow_height14"
        ), @Model(
                name = "block/%s_layer_height16",
                template = "block/parent_cube"
        )}
)
public class Layer extends WaterloggedShape {
    public static final IntegerProperty LAYERS;
    private static final VoxelShape[] BOTTOM_SHAPE;
    public static final VoxelShape SPECIAL_FULL_SHAPE_COLLISION;

    public Layer(Properties props) {
        super(props);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(LAYERS, 1)).setValue(WATERLOGGED, false));
    }

    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    public VoxelShape getShape(BlockState state) {
        return BOTTOM_SHAPE[(Integer)state.getValue(LAYERS) - 1];
    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return (Integer)state.getValue(LAYERS) == 8 ? SPECIAL_FULL_SHAPE_COLLISION : BOTTOM_SHAPE[(Integer)state.getValue(LAYERS) - 1];
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        if (!PlacementHelper.replacingClickedOnBlock(context)) {
            return false;
        } else {
            ItemStack item = context.getItemInHand();
            if (item.getItem() == this.asItem() && (Integer)state.getValue(LAYERS) != 8) {
                return context.getClickedFace() == Direction.UP;
            } else {
                return false;
            }
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        if (state.getBlock() == this) {
            int i = (Integer)state.getValue(LAYERS);
            return (BlockState)state.setValue(LAYERS, Math.min(8, i + 1));
        } else {
            FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
            BlockState state2 = (BlockState)this.defaultBlockState().setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
            return state2;
        }
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> container) {
        container.add(new Property[]{LAYERS});
    }

    static {
        LAYERS = BlockStateProperties.LAYERS;
        BOTTOM_SHAPE = new VoxelShape[]{
                Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
                Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
                Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
                Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
                Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
                Block.box(0.0, 0.0, 0.0, 16.0, 12.0, 16.0),
                Block.box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
                Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)};
        SPECIAL_FULL_SHAPE_COLLISION = Block.box(0.0, 2.0, 0.0, 16.0, 16.0, 16.0);
    }
}