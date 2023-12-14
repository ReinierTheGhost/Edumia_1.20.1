package com.legends.edumia.block.directional;

import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import com.legends.edumia.core.block.base.HorizontalDirectionalShape;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(
                name = "%s_slab_directional",
                template = "parent_slab"
        ),
        item = @Model(
                name = "item/%s_slab_directional",
                parent = "block/%s_slab",
                template = "item/acacia_slab"
        ),
        block = {@Model(
                name = "block/%s_slab_directional",
                template = "block/orientable"
        )}
)
public class HalfDirectional extends HorizontalDirectionalShape {
    public static final EnumProperty<Half> TYPE_UPDOWN = EnumProperty.create("type", Half.class);
    private static final VoxelShape BOTTOM_SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0);
    private static final VoxelShape TOP_SHAPE = Block.box(0.0, 8.0, 0.0, 16.0, 16.0, 16.0);

    public HalfDirectional(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(DIRECTION, Direction.NORTH)).setValue(TYPE_UPDOWN, Half.BOTTOM));
    }

    public VoxelShape getInteractionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return this.getShape(state);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facingHorizontal = context.getHorizontalDirection().getOpposite();
        BlockState state2 = (BlockState)((BlockState)this.defaultBlockState().setValue(DIRECTION, facingHorizontal)).setValue(TYPE_UPDOWN, Half.BOTTOM);
        Direction facing = context.getClickedFace();
        return facing == Direction.DOWN || facing != Direction.UP && context.getClickLocation().y - (double)context.getClickedPos().getY() > 0.5 ? (BlockState)state2.setValue(TYPE_UPDOWN, Half.TOP) : state2;
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> container) {
        container.add(new Property[]{TYPE_UPDOWN});
    }

    public VoxelShape getShape(BlockState state) {
        return state.getValue(TYPE_UPDOWN) == Half.BOTTOM ? BOTTOM_SHAPE : TOP_SHAPE;
    }
}
