package com.legends.edumia.worldgen.placement;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class ModPlacementUtils extends PlacementUtils {

    public static PlacementModifier countExtras(int data, float weight, int data2, float weight2) {
        float f = 1.0F / weight;
        float v = 1.0F / weight2;
        if (Math.abs(f - (float)((int)f)) > 1.0E-5F || Math.abs(v - (float)((int)v)) > 1.0E-5F) {
            throw new IllegalStateException("Chance data cannot be represented as list weight");
        } else {
            SimpleWeightedRandomList<IntProvider> simpleweightedrandomlist =
                    SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(data),
                            (int)f - 1).add(ConstantInt.of(data + data2), 1).build();
            return CountPlacement.of(new WeightedListInt(simpleweightedrandomlist));
        }
    }
}
