package com.legends.edumia.block.classical;


import com.legends.edumia.block.block.WallOld;
import com.legends.edumia.core.asset.annotation.Assets;
import com.legends.edumia.core.asset.annotation.Model;
import com.legends.edumia.core.asset.annotation.State;
import net.minecraft.world.level.block.state.BlockBehaviour;

@Assets(
        state = @State(
                name = "%s_wall",
                template = "parent_doric_base_wall"
        ),
        item = @Model(
                name = "item/%s_wall",
                parent = "block/%s_wall_inventory",
                template = "item/cobblestone_wall"
        ),
        block = {@Model(
                name = "block/%s_wall_post",
                template = "block/parent_doric_base_wall_post"
        ), @Model(
                name = "block/%s_wall_n",
                template = "block/parent_doric_base_wall_n"
        ), @Model(
                name = "block/%s_wall_ne",
                template = "block/parent_doric_base_wall_ne"
        ), @Model(
                name = "block/%s_wall_ns",
                template = "block/parent_doric_base_wall_ns"
        ), @Model(
                name = "block/%s_wall_nse",
                template = "block/parent_doric_base_wall_nse"
        ), @Model(
                name = "block/%s_wall_nsew",
                template = "block/parent_doric_base_wall_nsew"
        ), @Model(
                name = "block/%s_wall_inventory",
                template = "block/parent_wall_inventory"
        )}
)
public class WallBase extends WallOld {
    public WallBase(BlockBehaviour.Properties properties) {
        super(properties);
    }
}

