package com.legends.edumia.block.wallpaper;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WallPaperBlock extends IronBarsBlock implements BeaconBeamBlock {
    private final DyeColor color;

    public WallPaperBlock(DyeColor p_56838_, BlockBehaviour.Properties p_56839_) {
        super(p_56839_);
        this.color = p_56838_;
        this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, Boolean.valueOf
                (false)).setValue(EAST, Boolean.valueOf(false)).setValue(SOUTH,
                Boolean.valueOf(false)).setValue(WEST, Boolean.valueOf(false))
                .setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public DyeColor getColor() {
        return this.color;
    }
}
