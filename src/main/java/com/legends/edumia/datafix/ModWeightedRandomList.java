package com.legends.edumia.datafix;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import java.util.List;
import java.util.Optional;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandom;

public class ModWeightedRandomList<E extends WeightedEntry> {
    private final int totalWeight;
    private final ImmutableList<E> items;

    ModWeightedRandomList(List<? extends E> p_146327_) {
        this.items = ImmutableList.copyOf(p_146327_);
        this.totalWeight = WeightedRandom.getTotalWeight(p_146327_);
    }

    public static <E extends WeightedEntry> ModWeightedRandomList<E> create() {
        return new ModWeightedRandomList<>(ImmutableList.of());
    }

    @SafeVarargs
    public static <E extends WeightedEntry> ModWeightedRandomList<E> create(E... p_146331_) {
        return new ModWeightedRandomList<>(ImmutableList.copyOf(p_146331_));
    }

    public static <E extends WeightedEntry> ModWeightedRandomList<E> create(List<E> p_146329_) {
        return new ModWeightedRandomList<>(p_146329_);
    }

    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public Optional<E> getRandom(RandomSource p_216830_) {
        if (this.totalWeight == 0) {
            return Optional.empty();
        } else {
            int i = p_216830_.nextInt(this.totalWeight);
            return WeightedRandom.getWeightedItem(this.items, i);
        }
    }

    public List<E> unwrap() {
        return this.items;
    }

    public static <E extends WeightedEntry> Codec<ModWeightedRandomList<E>> codec(Codec<E> p_146334_) {
        return p_146334_.listOf().xmap(ModWeightedRandomList::create, ModWeightedRandomList::unwrap);
    }
}