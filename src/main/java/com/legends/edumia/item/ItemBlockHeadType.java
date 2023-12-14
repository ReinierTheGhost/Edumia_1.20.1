package com.legends.edumia.item;

import com.legends.edumia.entity.util.variant.IVariant;
import com.legends.edumia.util.HeadType;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;

public class ItemBlockHeadType extends ItemBlockSkull {
    private final HeadType type;

    public ItemBlockHeadType(Block block, Block block1, Properties properties, Direction direction, HeadType.PlacementType placement, String id, IVariant variant, HeadType type) {
        super(block, block1, properties, direction, placement, id, variant);
        this.type = type;
    }

    @Override
    public String getDescriptionId() {
        return "block" + "." + type.getMod() + "." + this.type.getName();
    }

}
