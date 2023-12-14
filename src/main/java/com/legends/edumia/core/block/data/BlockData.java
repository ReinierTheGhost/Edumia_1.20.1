package com.legends.edumia.core.block.data;

import com.legends.edumia.core.block.builder.BlockName;
import com.legends.edumia.core.block.builder.Props;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class BlockData {

    private final Block block;
    private final Props props;
    private final BlockName blockName;
    private final BlockTemplate template;
    private final ResourceLocation registryName;
    private Item item = null;
    public BlockData(Block block, BlockTemplate template, BlockName blockName, Props props) {
        this.template = template;
        this.registryName = template.getRegistryName(blockName);
        this.blockName = blockName;
        this.block = block;
        this.props = props;
        //block.setRegistryName(this.registryName);
    }

    public Block getBlock() {
        return this.block;
    }
}
