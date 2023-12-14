package com.legends.edumia.block.block;

import com.legends.edumia.block.block.util.PlacementHelper;
import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import com.legends.edumia.core.block.base.WaterloggedShape;
import com.legends.edumia.core.block.builder.Props;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(
                name = "%s_pillar",
                template = "parent_pillar"
        ),
        item = @Model(
                name = "item/%s_pillar",
                parent = "block/%s_pillar_4",
                template = "item/dragon_egg"
        ),
        block = {@Model(
                name = "block/%s_pillar_2",
                template = "block/parent_pillar_2"
        ), @Model(
                name = "block/%s_pillar_4",
                template = "block/parent_pillar_4"
        ), @Model(
                name = "block/%s_pillar_6",
                template = "block/parent_pillar_6"
        )}
)
public class Pillar extends WaterloggedShape {
    public static final IntegerProperty LAYERS = IntegerProperty.create("layer", 1, 3);
    protected static final VoxelShape[] SHAPE = new VoxelShape[]{
            Block.box(6.0, 0.0, 6.0, 10.0, 16.0, 10.0),
            Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0),
            Block.box(2.0, 0.0, 2.0, 14.0, 16.0, 14.0)
    };
    private Block fullBlock;

    public Pillar(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(WATERLOGGED, false));
        this.fullBlock = defaultBlockState().getBlock();
    }

    public VoxelShape getShape(BlockState state) {
        return SHAPE[(Integer)state.getValue(LAYERS) - 1];
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        int i = (Integer)state.getValue(LAYERS);
        Direction facing = context.getClickedFace();
        if (context.getItemInHand().getItem() == this.asItem() && i <= 3) {
            if (!PlacementHelper.replacingClickedOnBlock(context)) {
                return true;
            } else {
                return facing != Direction.UP && facing != Direction.DOWN;
            }
        } else {
            return false;
        }
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.getBlock() == this) {
            int i = (Integer)blockstate.getValue(LAYERS);
            return i == 3 ? this.fullBlock.defaultBlockState() : (BlockState)blockstate.setValue(LAYERS, Math.min(3, i + 1));
        } else {
            return super.getStateForPlacement(context);
        }
    }

    protected void addProperties(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LAYERS});
    }
}
