package com.legends.edumia.datafix;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.ComposterBlock;

public class ModComposterBlock extends ComposterBlock {
    public static void add(float p_51921_, ItemLike p_51922_) {
        COMPOSTABLES.put(p_51922_.asItem(), p_51921_);
    }
    public ModComposterBlock(Properties p_51919_) {
        super(p_51919_);
    }
}
