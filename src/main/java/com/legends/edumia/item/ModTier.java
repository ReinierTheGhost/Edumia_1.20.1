package com.legends.edumia.item;

import com.legends.edumia.core.ItemLoader;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTier {
    public static final ForgeTier ORC = new ForgeTier(2, 1700, 1.5f,
            2f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ItemLoader.LEGENDS_COIN.get()));

    public static final ForgeTier MAN = new ForgeTier(2, 1700, 1.5f,
            2f, 22, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ItemLoader.LEGENDS_COIN.get()));
}
