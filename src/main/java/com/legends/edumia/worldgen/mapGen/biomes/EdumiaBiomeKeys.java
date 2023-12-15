package com.legends.edumia.worldgen.mapGen.biomes;


import com.legends.edumia.Edumia;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.eventbus.api.IEventBus;

public class EdumiaBiomeKeys extends Biomes {
    public static final ResourceKey<Biome> ANDUIN_VALES = EdumiaBiomeKeys.register("anduin");
    public static final ResourceKey<Biome> BARROW_DOWNS = EdumiaBiomeKeys.register("barrow_downs");
    public static final ResourceKey<Biome> BLUE_MOUNTAINS = EdumiaBiomeKeys.register("blue_mountains");
    public static final ResourceKey<Biome> BLUE_MOUNTAINS_FOOTHILLS = EdumiaBiomeKeys.register("blue_mountains_foothills");
    public static final ResourceKey<Biome> CORSAIR_COASTS = EdumiaBiomeKeys.register("corsair_coasts");
    public static final ResourceKey<Biome> DALE = EdumiaBiomeKeys.register("dale");
    public static final ResourceKey<Biome> DARK_MIRKWOOD = EdumiaBiomeKeys.register("dark_mirkwood");
    public static final ResourceKey<Biome> DARK_MIRKWOOD_EDGE = EdumiaBiomeKeys.register("dark_mirkwood_edge");
    public static final ResourceKey<Biome> DARK_ANDUIN_VALES = EdumiaBiomeKeys.register("dark_anduin_vales");
    public static final ResourceKey<Biome> DOL_GULDUR = EdumiaBiomeKeys.register("dol_guldur");
    public static final ResourceKey<Biome> DORWINION_HILLS = EdumiaBiomeKeys.register("dorwinion_hills");
    public static final ResourceKey<Biome> DUNLAND_FOOTHILLS = EdumiaBiomeKeys.register("dunland_foothills");
    public static final ResourceKey<Biome> EASTERN_RHOVANION = EdumiaBiomeKeys.register("eastern_rhovanion");
    public static final ResourceKey<Biome> ENEDWAITH = EdumiaBiomeKeys.register("enedwaith");
    public static final ResourceKey<Biome> EREGION = EdumiaBiomeKeys.register("eregion");
    public static final ResourceKey<Biome> ERIADOR = EdumiaBiomeKeys.register("eriador");
    public static final ResourceKey<Biome> FANGORN = EdumiaBiomeKeys.register("fangorn");
    public static final ResourceKey<Biome> FORODWAITH = EdumiaBiomeKeys.register("forodwaith");
    public static final ResourceKey<Biome> FROZEN_OCEAN = EdumiaBiomeKeys.register("frozen_ocean");
    public static final ResourceKey<Biome> GONDOR = EdumiaBiomeKeys.register("gondor");
    public static final ResourceKey<Biome> GREY_PLAINS = EdumiaBiomeKeys.register("grey_plains");
    public static final ResourceKey<Biome> HARAD = EdumiaBiomeKeys.register("harad");
    public static final ResourceKey<Biome> HARAD_DESERT = EdumiaBiomeKeys.register("harad_desert");
    public static final ResourceKey<Biome> HARONDOR = EdumiaBiomeKeys.register("harondor");
    public static final ResourceKey<Biome> IRON_HILLS = EdumiaBiomeKeys.register("iron_hills");
    public static final ResourceKey<Biome> IRON_HILLS_FRONTIER = EdumiaBiomeKeys.register("iron_hills_frontier");
    public static final ResourceKey<Biome> LINDON = EdumiaBiomeKeys.register("lindon");
    public static final ResourceKey<Biome> LONG_LAKE = EdumiaBiomeKeys.register("long_lake");
    public static final ResourceKey<Biome> LORIEN_EDGE = EdumiaBiomeKeys.register("lorien_edge");
    public static final ResourceKey<Biome> LOTHLORIEN = EdumiaBiomeKeys.register("lothlorien");
    public static final ResourceKey<Biome> MILLPOND = EdumiaBiomeKeys.register("millpond");
    public static final ResourceKey<Biome> MIRKWOOD = EdumiaBiomeKeys.register("mirkwood");
    public static final ResourceKey<Biome> MIRKWOOD_EDGE = EdumiaBiomeKeys.register("mirkwood_edge");
    public static final ResourceKey<Biome> MIRKWOOD_FOOTHILLS = EdumiaBiomeKeys.register("mirkwood_foothills");
    public static final ResourceKey<Biome> MIRKWOOD_MOUNTAINS = EdumiaBiomeKeys.register("mirkwood_mountains");
    public static final ResourceKey<Biome> MIRKWOOD_SWAMP = EdumiaBiomeKeys.register("mirkwood_swamp");
    public static final ResourceKey<Biome> MISTY_MOUNTAINS = EdumiaBiomeKeys.register("misty_mountains");
    public static final ResourceKey<Biome> MORDOR = EdumiaBiomeKeys.register("mordor");
    public static final ResourceKey<Biome> MORDOR_MOUNTAINS = EdumiaBiomeKeys.register("mordor_mountains");
    public static final ResourceKey<Biome> MORDOR_WASTES = EdumiaBiomeKeys.register("mordor_wastes");
    public static final ResourceKey<Biome> NORTHERN_DUNLAND = EdumiaBiomeKeys.register("northern_dunland");
    public static final ResourceKey<Biome> NORTHERN_WASTELANDS = EdumiaBiomeKeys.register("northern_wastelands");
    public static final ResourceKey<Biome> NURN = EdumiaBiomeKeys.register("nurn");
    public static final ResourceKey<Biome> NURN_RIVER = EdumiaBiomeKeys.register("nurn_river");
    public static final ResourceKey<Biome> NURN_SEA = EdumiaBiomeKeys.register("nurn_sea");
    public static final ResourceKey<Biome> OCEAN = EdumiaBiomeKeys.register("ocean");
    public static final ResourceKey<Biome> OCEAN_COAST = EdumiaBiomeKeys.register("ocean_coast");
    public static final ResourceKey<Biome> OLD_ANGMAR = EdumiaBiomeKeys.register("old_angmar");
    public static final ResourceKey<Biome> OLD_ARTHEDAIN = EdumiaBiomeKeys.register("old_arthedain");
    public static final ResourceKey<Biome> OLD_RHUDAUR = EdumiaBiomeKeys.register("old_rhudaur");
    public static final ResourceKey<Biome> RHUN = EdumiaBiomeKeys.register("rhun");
    public static final ResourceKey<Biome> RIVENDELL = EdumiaBiomeKeys.register("rivendell");
    public static final ResourceKey<Biome> RIVENDELL_FOOTHILLS = EdumiaBiomeKeys.register("rivendell_foothills");
    public static final ResourceKey<Biome> SEA_OF_RHUN = EdumiaBiomeKeys.register("sea_of_rhun");
    public static final ResourceKey<Biome> RIVER = EdumiaBiomeKeys.register("river");
    public static final ResourceKey<Biome> ROHAN = EdumiaBiomeKeys.register("rohan");
    public static final ResourceKey<Biome> SHIRE = EdumiaBiomeKeys.register("shire");
    public static final ResourceKey<Biome> SOUTHEAST_RHOVANION = EdumiaBiomeKeys.register("southeast_rhovanion");
    public static final ResourceKey<Biome> SOUTHERN_DUNLAND = EdumiaBiomeKeys.register("southern_dunland");
    public static final ResourceKey<Biome> SOUTHERN_FOROCHEL = EdumiaBiomeKeys.register("southern_forochel");
    public static final ResourceKey<Biome> THE_ANGLE = EdumiaBiomeKeys.register("the_angle");
    public static final ResourceKey<Biome> THE_OLD_FOREST = EdumiaBiomeKeys.register("the_old_forest");
    public static final ResourceKey<Biome> THE_WOLD = EdumiaBiomeKeys.register("the_wold");
    public static final ResourceKey<Biome> TOLFALAS = EdumiaBiomeKeys.register("tolfalas");
    public static final ResourceKey<Biome> TROLLSHAWS = EdumiaBiomeKeys.register("trollshaws");
    public static final ResourceKey<Biome> UMBAR = EdumiaBiomeKeys.register("umbar");
    public static final ResourceKey<Biome> WASTE_POND = EdumiaBiomeKeys.register("waste_pond");
    public static final ResourceKey<Biome> WHITE_MOUNTAINS = EdumiaBiomeKeys.register("white_mountains");
    public static final ResourceKey<Biome> WOODLAND_REALM = EdumiaBiomeKeys.register("woodland_realm");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(Edumia.MODID, name));
    }

    public static void registerModBiomes(IEventBus eventBus) {
        Edumia.LOGGER.debug("Registering ModBiomes for " + Edumia.MODID);
    }
}
