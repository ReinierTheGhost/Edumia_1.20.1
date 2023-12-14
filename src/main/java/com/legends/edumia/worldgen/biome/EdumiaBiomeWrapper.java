package com.legends.edumia.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public interface EdumiaBiomeWrapper {
    ResourceLocation getBiomeRegistryName();

    Biome getActualBiome();

    default double getHorizontalNoiseScale(){
        return 400.0;
    }

    default float getStrengthOfAddedDepthNoise(){
        return  1.0F;
    }
    default float getBiomeScaleSignificanceForChunkGen(){
        return 0.9F;
    }


}
