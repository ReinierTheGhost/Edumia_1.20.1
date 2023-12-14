package com.legends.edumia.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class OceanBiome extends EdumiaBiomeBase {
    public OceanBiome(boolean major){
        this((new Biome.BiomeBuilder()).hasPrecipitation(true).temperature(0.7f).downfall(0.9F), major );
    }
    public OceanBiome(Biome.BiomeBuilder builder, boolean major) {
        super(builder, major);
    }

    @Override
    public ResourceLocation getBiomeRegistryName() {
        return null;
    }

    @Override
    public Biome getActualBiome() {
        return null;
    }
}
