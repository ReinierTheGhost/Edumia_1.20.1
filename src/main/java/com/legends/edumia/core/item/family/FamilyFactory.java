package com.legends.edumia.core.item.family;

import com.legends.edumia.core.block.factory.TypeList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.BiFunction;

public interface FamilyFactory<T> {
    Family<T> create(ResourceLocation var1, CreativeModeTab var2, TypeList var3);

    static <T> FamilyFactory<T> of(BiFunction<CreativeModeTab, TypeList, Family<T>> func) {
        return (n, g, t) -> {
            return (Family)func.apply(g, t);
        };
    }
}
