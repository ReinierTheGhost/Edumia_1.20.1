package com.legends.edumia.block.arches;

import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import com.legends.edumia.core.block.base.WaterloggedBidirectionalShape;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(
                name = "%s_small_arch",
                template = "parent_small_arch"
        ),
        item = @Model(
                name = "item/%s_small_arch",
                parent = "block/%s_small_arch",
                template = "item/parent_segmental_arch"
        ),
        block = {@Model(
                name = "block/%s_small_arch",
                template = "block/parent_small_arch"
        )}
)
public class ArchSmall extends WaterloggedBidirectionalShape {
    private static final VoxelShape SHAPE =
            Block.box(0.0, 8.0, 0.0, 16.0, 16.0, 16.0);

    public ArchSmall(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state) {
        return SHAPE;
    }

    public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return Shapes.empty();
    }
}
