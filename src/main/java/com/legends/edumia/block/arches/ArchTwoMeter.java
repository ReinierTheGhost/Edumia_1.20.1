package com.legends.edumia.block.arches;

import com.legends.edumia.block.BlockVoxelShapes;
import com.legends.edumia.block.directional.HalfDirectional;
import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(
                name = "%s_two_meter_arch",
                template = "parent_arch_twometer"
        ),
        item = @Model(
                name = "item/%s_two_meter_arch",
                parent = "block/%s_two_meter_arch",
                template = "item/parent_slab_quarter"
        ),
        block = {@Model(
                name = "block/%s_two_meter_arch",
                template = "block/parent_arch_twometer"
        )}
)
public class ArchTwoMeter extends HalfDirectional {
    public ArchTwoMeter(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state) {
        if (state.getValue(TYPE_UPDOWN) == Half.BOTTOM) {
            switch ((Direction)state.getValue(DIRECTION)) {
                case NORTH:
                default:
                    return (VoxelShape) BlockVoxelShapes.stairBottomShapes.get(0);
                case EAST:
                    return (VoxelShape)BlockVoxelShapes.stairBottomShapes.get(1);
                case SOUTH:
                    return (VoxelShape)BlockVoxelShapes.stairBottomShapes.get(2);
                case WEST:
                    return (VoxelShape)BlockVoxelShapes.stairBottomShapes.get(3);
            }
        } else {
            switch ((Direction)state.getValue(DIRECTION)) {
                case NORTH:
                default:
                    return (VoxelShape)BlockVoxelShapes.stairTopShapes.get(0);
                case EAST:
                    return (VoxelShape)BlockVoxelShapes.stairTopShapes.get(1);
                case SOUTH:
                    return (VoxelShape)BlockVoxelShapes.stairTopShapes.get(2);
                case WEST:
                    return (VoxelShape)BlockVoxelShapes.stairTopShapes.get(3);
            }
        }
    }

    public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return Shapes.empty();
    }
}

