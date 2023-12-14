package com.legends.edumia.datafix;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Set;

public class ModBlockLootSubProvider extends BlockLootSubProvider {
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    public ModBlockLootSubProvider(Set<Item> p_249153_, FeatureFlagSet p_251215_) {
        super(p_249153_, p_251215_);
    }

    public static LootTable.Builder createSilkTouchOrShearsDispatchTable(Block p_250539_, LootPoolEntryContainer.Builder<?> p_251459_) {
        return createSelfDropDispatchTable(p_250539_, HAS_SHEARS_OR_SILK_TOUCH, p_251459_);
    }
    @Override
    protected void generate() {

    }
}
