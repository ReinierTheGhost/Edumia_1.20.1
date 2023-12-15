package com.legends.edumia.worldgen.mapGen.chunkgen.map;


import com.legends.edumia.util.noise.BlendedNoise;
import com.legends.edumia.worldgen.mapGen.biomes.EdumiaBiomesData;
import com.legends.edumia.worldgen.mapGen.biomes.EdumiaBiome;

import java.awt.image.BufferedImage;

public class EdumiaHeightMap {
    public static final int SMOOTH_BRUSH_SIZE = 2;
    public static final int PERLIN_STRETCH_X = 210;
    public static final int PERLIN_STRETCH_Y = 180;
    public static final int PERLIN_STRETCH_X2 = 37;
    public static final int PERLIN_STRETCH_Y2 = 37;
    public static final int PERLIN_HEIGHT_RANGE = 33;
    public static final float MOUNTAIN_HEIGHT_RANGE = 8.6f;
    public static final float MOUNTAIN_HEIGHT_MULTIPLIER = 2.4f;
    public static final int MOUNTAIN_START_HEIGHT = 16; // Height depending on the Biome Data.
    public static final int PERLIN_HEIGHT_OFFSET = 8;
    public static final int STONE_HEIGHT = 50;
    public static final int HEIGHT = 8 + STONE_HEIGHT;
    public static final int DIRT_HEIGHT = 3 + HEIGHT;

    private static BufferedImage heightMapImage;

    public static int latitude; // Horizontal
    public static int longitude; // Vertical


    public static void applyHeightMapImage(BufferedImage newHeightMapImage) {
        heightMapImage = newHeightMapImage;
        latitude = heightMapImage.getHeight();
        longitude = heightMapImage.getWidth();
    }

    private static float getImageHeight(int x, int z) {
        if(!isCoordinateInBounds(x, z)) return EdumiaBiomesData.defaultBiome.height + getPerlinMapHeight(x, z);
        return ((float) ((heightMapImage.getRGB(x, z)>>16)&0xFF) / 4) + EdumiaBiomesData.MINIMAL_HEIGHT;
    }

    private static double getPerlinHeight(int x, int z) {
        double perlin = 1 * BlendedNoise.noise((double) x / PERLIN_STRETCH_X,(double) z / PERLIN_STRETCH_Y);
        perlin += 0.5f * BlendedNoise.noise((double) x * 2 / PERLIN_STRETCH_X,(double) z * 2 / PERLIN_STRETCH_Y);
        perlin += 0.25f * BlendedNoise.noise((double) x * 4 / PERLIN_STRETCH_X,(double) z * 4 / PERLIN_STRETCH_Y);
        perlin += 0.125f * BlendedNoise.noise((double) x * 8 / PERLIN_STRETCH_X,(double) z * 8 / PERLIN_STRETCH_Y);

        perlin = perlin / (1 + 0.5f + 0.25f + 0.125f);
        perlin *= PERLIN_HEIGHT_RANGE;
        perlin += PERLIN_HEIGHT_OFFSET;

        return perlin;
    }

    private static float getPerlinMapHeight(int x, int z) {
        double additionalHeight;
        EdumiaBiome meBiome;
        double perlin = getPerlinHeight(x, z);

        if(EdumiaHeightMap.isCoordinateInBounds(x, z)) {
            float biomeHeight = EdumiaHeightMap.getImageHeight(x, z);
            if(biomeHeight >= MOUNTAIN_START_HEIGHT) {
                float multiplier = (biomeHeight / MOUNTAIN_START_HEIGHT) - 1;
                multiplier = MOUNTAIN_HEIGHT_MULTIPLIER * multiplier;
                perlin += multiplier * MOUNTAIN_HEIGHT_RANGE * BlendedNoise.noise((double) x / PERLIN_STRETCH_X2,  (double) z / PERLIN_STRETCH_Y2);
            }
            additionalHeight = biomeHeight + perlin;
        } else {
            meBiome = EdumiaBiomesData.defaultBiome;
            additionalHeight = meBiome.height + perlin;
        }
        return (float) additionalHeight;
    }

    private static float getSmoothHeight(int x, int z) {
        float total = 0;
        for(int i = -SMOOTH_BRUSH_SIZE; i <= SMOOTH_BRUSH_SIZE; i++) {
            for(int j = -SMOOTH_BRUSH_SIZE; j <= SMOOTH_BRUSH_SIZE; j++) {
                if(!isCoordinateInBounds(x + i, z + j)) total += EdumiaBiomesData.defaultBiome.height;
                else total += ((float)((heightMapImage.getRGB(x + i, z + j)>>16)&0xFF) / 4) + EdumiaBiomesData.MINIMAL_HEIGHT;
            }
        }

        return total / ((SMOOTH_BRUSH_SIZE * 2 + 1) * (SMOOTH_BRUSH_SIZE * 2 + 1));
    }

    public static float getHeight(int x, int z) {
        return getSmoothHeight(x, z) + getPerlinMapHeight(x, z);
    }

    public static boolean isCoordinateInBounds(int x, int z) {
        if(x < 0 || z < 0) return false;
        return (x < longitude && z < latitude);
    }

    // Going to be useful for making roads with curves.
    static float getPointOnBezierCurve(float h0, float h1, float h2, float t)
    {
        float a = lerp(h0, h1, t);
        float b = lerp(h1, h2, t);
        float d = lerp(a, b, t);

        return d;
    }

    public static float lerp(float a, float b, float interpolation) {
        return a + interpolation * (b - a);
    }
}
