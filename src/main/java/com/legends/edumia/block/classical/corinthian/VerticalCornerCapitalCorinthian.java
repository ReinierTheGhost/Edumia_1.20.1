package com.legends.edumia.block.classical.corinthian;

import com.legends.edumia.block.block.VerticalCornerLessLayers;
import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.Render;
import com.legends.edumia.core.asset.annotation.State;
import com.legends.edumia.core.block.builder.Props;
import com.legends.edumia.core.util.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

@Assets(
        state = @State(
                name = "%s_vertical_corner",
                template = "parent_doric_capital_vertical_corner"
        ),
        item = @Model(
                name = "item/%s_vertical_corner",
                parent = "block/%s_vertical_corner_4",
                template = "item/parent_vertical_corner"
        ),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {@Model(
                name = "block/%s_vertical_corner_2",
                template = "block/parent_doric_capital_vertical_corner_2"
        ), @Model(
                name = "block/%s_vertical_corner_4",
                template = "block/parent_doric_capital_vertical_corner_4"
        ), @Model(
                name = "block/%s_vertical_corner_6",
                template = "block/parent_doric_capital_vertical_corner_6"
        )}
)
public class VerticalCornerCapitalCorinthian extends VerticalCornerLessLayers {
    public VerticalCornerCapitalCorinthian(Props properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(DIRECTION, Direction.NORTH))
                .setValue(WATERLOGGED, false));
    }
}
