package com.legends.edumia.datafix;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;

import static net.minecraft.world.level.storage.loot.LootTable.createStackSplitter;

public class ModLootTable {

    public LootTable lootTable;

    public ObjectArrayList<ItemStack> getRandomItems(LootContext p_230923_) {
        ObjectArrayList<ItemStack> objectarraylist = new ObjectArrayList<>();
        lootTable.getRandomItemsRaw(p_230923_, createStackSplitter(p_230923_.getLevel(), objectarraylist::add));
        objectarraylist = net.minecraftforge.common.ForgeHooks.modifyLoot(lootTable.getLootTableId(), objectarraylist, p_230923_);
        return objectarraylist;
    }
}
