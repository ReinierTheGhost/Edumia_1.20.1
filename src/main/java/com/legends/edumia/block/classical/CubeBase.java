package com.legends.edumia.block.classical;

import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import net.minecraft.world.level.block.state.BlockBehaviour;

@Assets(
        state = @State(
                name = "%s",
                template = "parent_doric_base",
                plural = true
        ),
        item = @Model(
                name = "item/%s",
                parent = "block/%s",
                template = "item/parent_cube",
                plural = true
        ),
        block = {@Model(
                name = "block/%s",
                template = "block/parent_doric_base_full",
                plural = true
        ), @Model(
                name = "block/%s_n",
                template = "block/parent_doric_base_n",
                plural = true
        ), @Model(
                name = "block/%s_ne",
                template = "block/parent_doric_base_ne",
                plural = true
        ), @Model(
                name = "block/%s_nse",
                template = "block/parent_doric_base_nse",
                plural = true
        ), @Model(
                name = "block/%s_fullplain",
                template = "block/parent_doric_base_fullplain",
                plural = true
        ), @Model(
                name = "block/%s_ns",
                template = "block/parent_doric_base_ns",
                plural = true
        ), @Model(
                name = "block/%s_ns_1",
                template = "block/parent_doric_base_ns_1",
                plural = true
        )}
)
public class CubeBase extends CubeCapital {
    public CubeBase(BlockBehaviour.Properties properties) {
        super(properties);
    }
}
