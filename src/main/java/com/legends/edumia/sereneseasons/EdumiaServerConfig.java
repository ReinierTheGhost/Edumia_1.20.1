package com.legends.edumia.sereneseasons;

import com.google.common.collect.Lists;
import com.legends.edumia.config.EdumiaConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeConfigSpec;
import sereneseasons.config.ServerConfig;

import java.util.List;
import java.util.function.Predicate;

public class EdumiaServerConfig extends ServerConfig {
    private static final Predicate<Object> RESOURCE_LOCATION_VALIDATOR = (obj) -> {
        if (!(obj instanceof String)) {
            return false;
        } else {
            try {
                new ResourceLocation((String)obj);
                return true;
            } catch (Exception var2) {
                return false;
            }
        }
    };
    private static List<String> defaultTropicalSeasons = Lists.newArrayList(new String[]{});
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> tropicalBiomes = BUILDER.comment("Biomes which use tropical seasons.")
            .defineList("tropical_biomes", defaultTropicalSeasons, RESOURCE_LOCATION_VALIDATOR);
    private static List<String> defaultBlackListedBiomes = Lists.newArrayList(new String[]{Level.OVERWORLD.location().toString()});



    public static ForgeConfigSpec.ConfigValue<List<? extends String>> blackListedBiomes = BUILDER.comment("Biomes in which seasons will not apply.")
            .defineList("blacklisted_biomes", defaultBlackListedBiomes, RESOURCE_LOCATION_VALIDATOR);
}
