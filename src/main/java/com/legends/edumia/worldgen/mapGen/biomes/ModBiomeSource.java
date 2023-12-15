package com.legends.edumia.worldgen.mapGen.biomes;

import com.legends.edumia.worldgen.mapGen.chunkgen.EdumiaChunkGenerator;
import com.legends.edumia.worldgen.mapGen.chunkgen.map.EdumiaHeightMap;
import com.legends.edumia.worldgen.mapGen.chunkgen.map.MapImageLoader;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.Climate;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ModBiomeSource extends BiomeSource {
    private final ArrayList<Holder<Biome>> biomes;

    public ModBiomeSource(ArrayList<Holder<Biome>> biomes) {
        this.biomes = biomes;
    }

    @Override
    protected Codec<? extends BiomeSource> codec() {
        return CODEC;
    }

    @Override
    protected Stream<Holder<Biome>> collectPossibleBiomes() {
        return biomes.stream();
    }

    @Override
    public Holder<Biome> getNoiseBiome(int x, int y, int z, Climate.Sampler noise) {
        int i = QuartPos.toBlock(x);
        int k = QuartPos.toBlock(z);

        if(!EdumiaHeightMap.isCoordinateInBounds(i, k)) return biomes.get(0);
        EdumiaBiome meBiome = EdumiaBiomesData.biomeMap.get(MapImageLoader.getBiomeColor(i, k));
        if(meBiome == null) {
            return biomes.get(0);
        }

        ResourceKey<Biome> biome = meBiome.biome;
        ResourceKey<Biome> processedBiome;

        if(!EdumiaBiomesData.waterBiomes.contains(biome)) {
            float height = EdumiaChunkGenerator.DIRT_HEIGHT + EdumiaHeightMap.getHeight(i, k);
            if(height <= EdumiaChunkGenerator.WATER_HEIGHT + 1.25f) {
                if(EdumiaBiomesData.wastePondBiomes.contains(biome)) {
                    processedBiome = EdumiaBiomesData.wastePond.biome;
                } else if(EdumiaBiomesData.mirkwoodSwampBiomes.contains(biome)) {
                    processedBiome = EdumiaBiomesData.mirkwoodSwamp.biome;
                } else {
                    processedBiome = EdumiaBiomesData.millPond.biome;
                }
            } else processedBiome = biome;
        } else processedBiome = biome;

        return biomes.stream().filter(
                        b -> b.unwrapKey().get().toString().equalsIgnoreCase(processedBiome.toString()))
                .findFirst().get();
    }
}
