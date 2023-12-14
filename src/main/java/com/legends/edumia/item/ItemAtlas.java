package com.legends.edumia.item;


import net.minecraft.world.item.MapItem;

public class ItemAtlas extends MapItem {
    public ItemAtlas(Properties properties) {
        super(properties);
    }

    @Override
    public int getEnchantmentValue() {
        return 15;
    }

    @Override
    public boolean isComplex() {
        return true;
    }
}
