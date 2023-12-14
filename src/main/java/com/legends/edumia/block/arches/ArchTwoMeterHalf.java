package com.legends.edumia.block.arches;

import com.legends.edumia.block.block.VerticalSlabCorner;
import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@Assets(
        state = @State(
                name = "%s_two_meter_arch_half",
                template = "parent_arch_twometer_half"
        ),
        item = @Model(
                name = "item/%s_two_meter_arch_half",
                parent = "block/%s_two_meter_arch_half_right",
                template = "item/parent_slab_quarter"
        ),
        block = {@Model(
                name = "block/%s_two_meter_arch_half_right",
                template = "block/parent_arch_twometer_half_right"
        ), @Model(
                name = "block/%s_two_meter_arch_half_left",
                template = "block/parent_arch_twometer_half_left"
        )}
)
public class ArchTwoMeterHalf extends VerticalSlabCorner {
    public ArchTwoMeterHalf(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public VoxelShape getOcclusionShape(BlockState state, BlockGetter world, BlockPos pos) {
        return Shapes.empty();
    }
}
