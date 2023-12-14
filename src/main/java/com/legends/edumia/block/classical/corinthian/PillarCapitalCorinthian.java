package com.legends.edumia.block.classical.corinthian;


import com.legends.edumia.block.block.Pillar;
import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.Render;
import com.legends.edumia.core.asset.annotation.State;
import com.legends.edumia.core.block.builder.Props;
import com.legends.edumia.core.util.RenderLayer;
import net.minecraft.world.level.block.state.BlockBehaviour;

@Assets(
        state = @State(
                name = "%s_pillar",
                template = "parent_doric_capital_pillar"
        ),
        item = @Model(
                name = "item/%s_pillar",
                parent = "block/%s_wall_post",
                template = "item/acacia_fence"
        ),
        render = @Render(RenderLayer.CUTOUT_MIPPED),
        block = {@Model(
                name = "block/%s_wall_post",
                template = "block/parent_doric_capital_wall_post"
        ), @Model(
                name = "block/%s_pillar_2",
                template = "block/parent_doric_capital_pillar_2"
        ), @Model(
                name = "block/%s_pillar_6",
                template = "block/parent_doric_capital_pillar_6"
        )}
)
public class PillarCapitalCorinthian extends Pillar {
    public PillarCapitalCorinthian(Properties properties) {
        super(properties);
    }

}