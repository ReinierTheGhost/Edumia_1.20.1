package com.legends.edumia.worldgen.biome;


import com.legends.edumia.core.BlockLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EdumiaBiomesData {
    public static HashMap<Integer, EdumiaBiome> biomeMap = new HashMap<>();
    public static List<ResourceKey<Biome>> waterBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> wastePondBiomes = new ArrayList<>();
    public static List<ResourceKey<Biome>> fairySwampBiomes = new ArrayList<>();
    public static EdumiaBiome defaultBiome;
    public static EdumiaBiome pond;
    public static EdumiaBiome demonPond;
    public static EdumiaBiome fairySwamp;
    // Only supports height value from -22 to 41
    public static final int MINIMAL_HEIGHT = -22;

    public static void addBiome(Color color, EdumiaBiome biome){
        biomeMap.put(color.getRGB(), biome);
    }

    public static void loadBiomes(){
        defaultBiome = new EdumiaBiome(-21, EdumiaBiomes.DEEP_OCEAN, Blocks.SAND, Blocks.STONE, Blocks.STONE, Blocks.STONE);
        pond = new EdumiaBiome(-10, EdumiaBiomes.POND, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE);
        fairySwamp = new EdumiaBiome(-12, EdumiaBiomes.FAIRY_SWAMP, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE);
        demonPond = new EdumiaBiome(-15, EdumiaBiomes.DEMON_POND, Blocks.GRASS_BLOCK, Blocks.DIRT, Blocks.STONE, Blocks.STONE);

        addBiome(new Color(47, 87, 167), defaultBiome);
        addBiome(new Color(110, 154, 218), pond);
        addBiome(new Color(89, 136, 129), fairySwamp);
        addBiome(new Color(75, 108, 143), demonPond);

        addBiome(new Color(0, 148, 255), new EdumiaBiome(-21, EdumiaBiomes.HIGH_ELVEN_RIVER, Blocks.SAND, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(120, 93, 73), new EdumiaBiome(39, EdumiaBiomes.HAZE_MOUNTAIN, Blocks.BASALT, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(178, 0, 255), new EdumiaBiome(20, EdumiaBiomes.HIGH_ELF_PLATEAU, Blocks.GRASS_BLOCK, BlockLoader.HIGH_ELVEN_ROCK.get(), BlockLoader.HIGH_ELVEN_ROCK.get(), BlockLoader.HIGH_ELVEN_ROCK.get()));
        addBiome(new Color(245, 255, 255), new EdumiaBiome(10, EdumiaBiomes.SNOW_PLAINS, Blocks.SNOW_BLOCK, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(90, 90, 26), new EdumiaBiome(12, EdumiaBiomes.TAIGA_FOREST, Blocks.GRASS_BLOCK, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(134, 130, 63), new EdumiaBiome(12, EdumiaBiomes.OGRE_FOREST_VALLEY, Blocks.GRASS_BLOCK, Blocks.STONE, Blocks.STONE, Blocks.STONE));
        addBiome(new Color(232, 219, 173), new EdumiaBiome(12, EdumiaBiomes.HOLY_ORC_DESERT, Blocks.SAND, Blocks.SANDSTONE, Blocks.SANDSTONE, Blocks.STONE));
        addBiome(new Color(134, 173, 63), new EdumiaBiome(12, EdumiaBiomes.TAIGA_MOUNTAIN_HILLS, Blocks.SAND, Blocks.SANDSTONE, Blocks.SANDSTONE, Blocks.STONE));


    }





}
