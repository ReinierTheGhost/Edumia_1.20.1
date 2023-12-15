package com.legends.edumia.worldgen.mapGen.biomes;


import com.legends.edumia.core.BlockLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Converts PNG pixel color to a BiomeKey reference.
 */
public class EdumiaBiomesData {
    public static HashMap<Integer, EdumiaBiome> biomeMap = new HashMap<>();
    public static List<ResourceKey<Biome>> waterBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> wastePondBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> mirkwoodSwampBiomes = new ArrayList<>();
    public static EdumiaBiome defaultBiome;
    public static EdumiaBiome millPond;
    public static EdumiaBiome wastePond;
    public static EdumiaBiome mirkwoodSwamp;

    /// Only supports height value from -22 to 41
    public static final int MINIMAL_HEIGHT = -22;

    public static void addBiome(Color color, EdumiaBiome biome) {
        biomeMap.put(color.getRGB(), biome);
    }

    public static void loadBiomes(IEventBus eventBus) {
        defaultBiome = new EdumiaBiome(-21, EdumiaBiomeKeys.OCEAN, Blocks.SAND, Blocks.STONE, Blocks.STONE, Blocks.STONE);
        millPond = new EdumiaBiome(-10, EdumiaBiomeKeys.MILLPOND,  Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE);
        mirkwoodSwamp = new EdumiaBiome(-12, EdumiaBiomeKeys.MIRKWOOD_SWAMP, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE);
        wastePond = new EdumiaBiome(-15, EdumiaBiomeKeys.WASTE_POND, BlockLoader.GREEN_BASALT.get(), BlockLoader.GREEN_BASALT.get(), Blocks.STONE, Blocks.STONE);

        addBiome(new Color(55, 90, 195), defaultBiome);
        addBiome(new Color(110, 154, 218), millPond);
        addBiome(new Color(89, 136, 129), mirkwoodSwamp);
        addBiome(new Color(75, 108, 143), wastePond);

        addBiome(new Color(156, 207, 113), new EdumiaBiome(4, EdumiaBiomeKeys.ANDUIN_VALES, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(96, 171, 89), new EdumiaBiome(6, EdumiaBiomeKeys.BARROW_DOWNS, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(200, 209, 255), new EdumiaBiome(39, EdumiaBiomeKeys.BLUE_MOUNTAINS, BlockLoader.BLUE_STONE.get(), BlockLoader.BLUE_STONE.get(), Blocks.STONE, Blocks.STONE));
        addBiome(new Color(178, 183, 210), new EdumiaBiome(22, EdumiaBiomeKeys.BLUE_MOUNTAINS_FOOTHILLS, BlockLoader.BLUE_STONE.get(), BlockLoader.BLUE_STONE.get(), Blocks.STONE, Blocks.STONE));
        addBiome(new Color(193, 188, 131), new EdumiaBiome(6, EdumiaBiomeKeys.CORSAIR_COASTS, Blocks.GRASS_BLOCK, Blocks.SANDSTONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(132, 164, 78), new EdumiaBiome(4, EdumiaBiomeKeys.DALE, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(18, 26, 19), new EdumiaBiome(6, EdumiaBiomeKeys.DARK_MIRKWOOD, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(26, 45, 28), new EdumiaBiome(5, EdumiaBiomeKeys.DARK_MIRKWOOD_EDGE, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(166, 191, 114), new EdumiaBiome(4, EdumiaBiomeKeys.DARK_ANDUIN_VALES, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(44, 39, 51), new EdumiaBiome(4, EdumiaBiomeKeys.DOL_GULDUR, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(93, 113, 92), new EdumiaBiome(31, EdumiaBiomeKeys.DORWINION_HILLS, Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(132, 137, 124), new EdumiaBiome(19, EdumiaBiomeKeys.DUNLAND_FOOTHILLS, Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(140, 150, 84), new EdumiaBiome(4, EdumiaBiomeKeys.EASTERN_RHOVANION, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(117, 164, 109), new EdumiaBiome(4, EdumiaBiomeKeys.ENEDWAITH, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(106, 155, 104), new EdumiaBiome(4, EdumiaBiomeKeys.EREGION, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(171, 193, 128), new EdumiaBiome(4, EdumiaBiomeKeys.ERIADOR, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(54, 75, 12), new EdumiaBiome(6, EdumiaBiomeKeys.FANGORN, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(236, 236, 236), new EdumiaBiome(8, EdumiaBiomeKeys.FORODWAITH, Blocks.SNOW, Blocks.SNOW_BLOCK, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(101, 123, 243), new EdumiaBiome(-18, EdumiaBiomeKeys.FROZEN_OCEAN, Blocks.GRAVEL, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(91, 189, 85), new EdumiaBiome(4, EdumiaBiomeKeys.GONDOR, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.CALCITE, Blocks.STONE));
        addBiome(new Color(92, 147, 92), new EdumiaBiome(6, EdumiaBiomeKeys.GREY_PLAINS, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(204, 196, 113), new EdumiaBiome(4, EdumiaBiomeKeys.HARAD, Blocks.GRASS_BLOCK, Blocks.SANDSTONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(237, 229, 145), new EdumiaBiome(5, EdumiaBiomeKeys.HARAD_DESERT, Blocks.SAND, Blocks.SAND, Blocks.SANDSTONE, Blocks.STONE));
        addBiome(new Color(180, 214, 121), new EdumiaBiome(6, EdumiaBiomeKeys.HARONDOR, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(148, 148, 148), new EdumiaBiome(37, EdumiaBiomeKeys.IRON_HILLS, Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.DEEPSLATE));
        addBiome(new Color(90, 159, 90), new EdumiaBiome(7, EdumiaBiomeKeys.IRON_HILLS_FRONTIER, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(67, 193, 125), new EdumiaBiome(4, EdumiaBiomeKeys.LINDON, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(69, 92, 228), new EdumiaBiome(-17, EdumiaBiomeKeys.LONG_LAKE, Blocks.SAND, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(205, 206, 96), new EdumiaBiome(4, EdumiaBiomeKeys.LORIEN_EDGE, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(221, 216, 28), new EdumiaBiome(4, EdumiaBiomeKeys.LOTHLORIEN, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(10, 54, 15), new EdumiaBiome(6, EdumiaBiomeKeys.MIRKWOOD, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(18, 73, 24), new EdumiaBiome(5, EdumiaBiomeKeys.MIRKWOOD_EDGE, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(74, 107, 78), new EdumiaBiome(15, EdumiaBiomeKeys.MIRKWOOD_FOOTHILLS, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(76, 85, 77), new EdumiaBiome(31, EdumiaBiomeKeys.MIRKWOOD_MOUNTAINS, Blocks.STONE, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(129, 129, 129), new EdumiaBiome(41, EdumiaBiomeKeys.MISTY_MOUNTAINS, Blocks.SNOW_BLOCK, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(60, 42, 42), new EdumiaBiome(5, EdumiaBiomeKeys.MORDOR, BlockLoader.VULCANIC_ROCK.get(), BlockLoader.VULCANIC_ROCK.get(), BlockLoader.VULCANIC_ROCK.get(), BlockLoader.VULCANIC_ROCK.get()));
        addBiome(new Color(36, 31, 31), new EdumiaBiome(37, EdumiaBiomeKeys.MORDOR_MOUNTAINS, BlockLoader.VULCANIC_ROCK.get(), BlockLoader.VULCANIC_ROCK.get(), BlockLoader.VULCANIC_ROCK.get(), BlockLoader.VULCANIC_ROCK.get()));
        addBiome(new Color(88, 82, 71), new EdumiaBiome(3, EdumiaBiomeKeys.MORDOR_WASTES, Blocks.GRASS_BLOCK, BlockLoader.GREEN_BASALT.get(), Blocks.STONE, Blocks.STONE));
        addBiome(new Color(106, 127, 62), new EdumiaBiome(5, EdumiaBiomeKeys.NORTHERN_DUNLAND, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(160, 165, 149), new EdumiaBiome(6, EdumiaBiomeKeys.NORTHERN_WASTELANDS, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(74, 77, 51), new EdumiaBiome(5, EdumiaBiomeKeys.NURN, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(79, 91, 161), new EdumiaBiome(-21, EdumiaBiomeKeys.NURN_RIVER, BlockLoader.GREEN_BASALT.get(), BlockLoader.GREEN_BASALT.get(), Blocks.STONE, Blocks.STONE));
        addBiome(new Color(88, 94, 130), new EdumiaBiome(-17, EdumiaBiomeKeys.NURN_SEA, BlockLoader.GREEN_BASALT.get(), BlockLoader.GREEN_BASALT.get(), Blocks.STONE, Blocks.STONE));
        addBiome(new Color(75, 106, 199), new EdumiaBiome(-12, EdumiaBiomeKeys.OCEAN_COAST, Blocks.SAND, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(73, 82, 53), new EdumiaBiome(6, EdumiaBiomeKeys.OLD_ANGMAR, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(213, 255, 132), new EdumiaBiome(4, EdumiaBiomeKeys.OLD_ARTHEDAIN, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(115, 135, 74), new EdumiaBiome(5, EdumiaBiomeKeys.OLD_RHUDAUR, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(172, 176, 113), new EdumiaBiome(4, EdumiaBiomeKeys.RHUN, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(76, 202, 95), new EdumiaBiome(3, EdumiaBiomeKeys.RIVENDELL, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(137, 171, 142), new EdumiaBiome(5, EdumiaBiomeKeys.RIVENDELL_FOOTHILLS, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(83, 129, 186), new EdumiaBiome(-22, EdumiaBiomeKeys.RIVER, Blocks.SAND, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(183, 229, 102), new EdumiaBiome(4, EdumiaBiomeKeys.ROHAN, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(66, 97, 157), new EdumiaBiome(-19, EdumiaBiomeKeys.SEA_OF_RHUN, Blocks.SAND, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(84, 217, 70), new EdumiaBiome(4, EdumiaBiomeKeys.SHIRE, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(154, 147, 57), new EdumiaBiome(4, EdumiaBiomeKeys.SOUTHEAST_RHOVANION, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(121, 186, 111), new EdumiaBiome(4, EdumiaBiomeKeys.SOUTHERN_DUNLAND, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(206, 179, 156), new EdumiaBiome(4, EdumiaBiomeKeys.SOUTHERN_FOROCHEL, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(126, 149, 79), new EdumiaBiome(4, EdumiaBiomeKeys.THE_ANGLE, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(48, 109, 42), new EdumiaBiome(5, EdumiaBiomeKeys.THE_OLD_FOREST, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(152, 174, 113), new EdumiaBiome(4, EdumiaBiomeKeys.THE_WOLD, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(156, 150, 150), new EdumiaBiome(13, EdumiaBiomeKeys.TOLFALAS, Blocks.GRASS_BLOCK, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(40, 66, 42), new EdumiaBiome(8, EdumiaBiomeKeys.TROLLSHAWS, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(225, 192, 133), new EdumiaBiome(7, EdumiaBiomeKeys.UMBAR, Blocks.GRASS_BLOCK, Blocks.SANDSTONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(219, 245, 215), new EdumiaBiome(36, EdumiaBiomeKeys.WHITE_MOUNTAINS, Blocks.CALCITE, Blocks.CALCITE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(22, 102, 31), new EdumiaBiome(5, EdumiaBiomeKeys.WOODLAND_REALM, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE));

        waterBiomes.add(EdumiaBiomeKeys.FROZEN_OCEAN);
        waterBiomes.add(EdumiaBiomeKeys.LONG_LAKE);
        waterBiomes.add(EdumiaBiomeKeys.NURN_RIVER);
        waterBiomes.add(EdumiaBiomeKeys.NURN_SEA);
        waterBiomes.add(EdumiaBiomeKeys.OCEAN);
        waterBiomes.add(EdumiaBiomeKeys.OCEAN_COAST);
        waterBiomes.add(EdumiaBiomeKeys.RIVER);
        waterBiomes.add(EdumiaBiomeKeys.SEA_OF_RHUN);

        mirkwoodSwampBiomes.add(EdumiaBiomeKeys.DARK_MIRKWOOD);
        mirkwoodSwampBiomes.add(EdumiaBiomeKeys.DARK_MIRKWOOD_EDGE);
        mirkwoodSwampBiomes.add(EdumiaBiomeKeys.DARK_ANDUIN_VALES);
        mirkwoodSwampBiomes.add(EdumiaBiomeKeys.DOL_GULDUR);
        mirkwoodSwampBiomes.add(EdumiaBiomeKeys.MIRKWOOD);
        mirkwoodSwampBiomes.add(EdumiaBiomeKeys.MIRKWOOD_EDGE);

        wastePondBiomes.add(EdumiaBiomeKeys.MORDOR);
        wastePondBiomes.add(EdumiaBiomeKeys.MORDOR_MOUNTAINS);
        wastePondBiomes.add(EdumiaBiomeKeys.MORDOR_WASTES);
        wastePondBiomes.add(EdumiaBiomeKeys.NURN);
    }
}
