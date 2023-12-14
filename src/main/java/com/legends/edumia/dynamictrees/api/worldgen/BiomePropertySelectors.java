package com.legends.edumia.dynamictrees.api.worldgen;

import com.google.common.collect.Sets;
import com.legends.edumia.dynamictrees.api.TreeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Provides the forest density for a given biome. Mods should implement this interface and register it via the {@link
 * TreeRegistry} to control how densely populated a {@link net.minecraft.world.level.biome.Biome} is.
 *
 * @author ferreusveritas
 */
public class BiomePropertySelectors {

    @FunctionalInterface
    public interface SpeciesSelector {
        SpeciesSelection getSpecies(BlockPos pos, BlockState dirt, RandomSource random);
    }

    /**
     * This is the data that represents a species selection. This class was necessary to have an unhandled state.
     */
    public static class SpeciesSelection {

    }

    public static class RandomSpeciesSelector implements SpeciesSelector {
        private class Entry {
            public Entry(SpeciesSelection d, int w) {
                decision = d;
                weight = w;
            }

            public SpeciesSelection decision;
            public int weight;
        }

        ArrayList<Entry> decisionTable = new ArrayList<Entry>();
        int totalWeight;

        @Override
        public SpeciesSelection getSpecies(BlockPos pos, BlockState dirt, RandomSource random) {
            int chance = random.nextInt(totalWeight);

            for (Entry entry : decisionTable) {
                if (chance < entry.weight) {
                    return entry.decision;
                }
                chance -= entry.weight;
            }

            return decisionTable.get(decisionTable.size() - 1).decision;
        }
    }
}
