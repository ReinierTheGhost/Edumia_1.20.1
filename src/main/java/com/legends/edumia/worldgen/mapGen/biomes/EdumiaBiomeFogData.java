package com.legends.edumia.worldgen.mapGen.biomes;


import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.HashMap;
import java.util.Map;

public class EdumiaBiomeFogData {
    public static Map<ResourceKey<Biome>, EdumiaBiomeFogData> DATA;
    static {
        DATA = new HashMap<>();
        DATA.put(EdumiaBiomeKeys.ERIADOR, new EdumiaBiomeFogData(0.75f, 0.95f));
        DATA.put(EdumiaBiomeKeys.BARROW_DOWNS, new EdumiaBiomeFogData(-0.15f, 0.3f));
        DATA.put(EdumiaBiomeKeys.DARK_MIRKWOOD, new EdumiaBiomeFogData(-0.1f, 0.3f));
        DATA.put(EdumiaBiomeKeys.DARK_MIRKWOOD_EDGE, new EdumiaBiomeFogData(0.0f, 0.5f));
        DATA.put(EdumiaBiomeKeys.DOL_GULDUR, new EdumiaBiomeFogData(-0.2f, 0.2f));
        DATA.put(EdumiaBiomeKeys.DUNLAND_FOOTHILLS, new EdumiaBiomeFogData(0.0f, 0.6f));
        DATA.put(EdumiaBiomeKeys.FANGORN, new EdumiaBiomeFogData(0.4f, 0.6f));
        DATA.put(EdumiaBiomeKeys.FORODWAITH, new EdumiaBiomeFogData(0.3f, 0.5f));
        DATA.put(EdumiaBiomeKeys.MIRKWOOD, new EdumiaBiomeFogData(0.0f, 0.7f));
        DATA.put(EdumiaBiomeKeys.MIRKWOOD_EDGE, new EdumiaBiomeFogData(0.2f, 0.8f));
        DATA.put(EdumiaBiomeKeys.MIRKWOOD_FOOTHILLS, new EdumiaBiomeFogData(0.1f, 0.75f));
        DATA.put(EdumiaBiomeKeys.MIRKWOOD_MOUNTAINS, new EdumiaBiomeFogData(0.05f, 0.6f));
        DATA.put(EdumiaBiomeKeys.MIRKWOOD_SWAMP, new EdumiaBiomeFogData(0.35f, 0.7f));
        DATA.put(EdumiaBiomeKeys.MISTY_MOUNTAINS, new EdumiaBiomeFogData(-2.0f, 0.2f));
        DATA.put(EdumiaBiomeKeys.NORTHERN_DUNLAND, new EdumiaBiomeFogData(0.3f, 0.95f));
        DATA.put(EdumiaBiomeKeys.THE_OLD_FOREST, new EdumiaBiomeFogData(0.4f, 0.6f));
    };

    public float fogStart;
    public float fogEnd;

    public EdumiaBiomeFogData(float fogStart, float fogEnd) {
        this.fogStart = fogStart;
        this.fogEnd = fogEnd;
    }
}
