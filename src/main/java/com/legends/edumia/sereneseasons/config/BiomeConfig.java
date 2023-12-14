package com.legends.edumia.sereneseasons.config;

import com.legends.edumia.sereneseasons.EdumiaServerConfig;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;

import java.util.List;

public class BiomeConfig {

    public BiomeConfig(){

    }


    public static boolean enablesSeasonalEffects(Holder<Biome> biomeHolder) {
        return !biomeHolder.is((key) -> {
            return ((List) EdumiaServerConfig.blackListedBiomes.get()).contains(key.location().toString());
        });
    }

    public static boolean usesTropicalSeasons(Holder<Biome> biome) {
        return biome.is((key) -> {
            return ((List)EdumiaServerConfig.tropicalBiomes.get()).contains(key.location().toString());
        }) || ((Biome)biome.value()).getBaseTemperature() > 0.8F;
    }
}
