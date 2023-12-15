package com.legends.edumia.worldgen.mapGen.biomes;


import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class EdumiaBiome {
    public float height;
    public ResourceKey<Biome> biome;
    public Block surfaceBlock;
    public Block underSurfaceBlock;
    public Block stoneBlock;
    public Block deepStoneBlock;

    public EdumiaBiome(float height, ResourceKey<Biome> biome, Block surfaceBlock, Block underSurfaceBlock, Block stoneBlock, Block deepStoneBlock) {
        this.height = height;
        this.biome = biome;
        this.surfaceBlock = surfaceBlock;
        this.underSurfaceBlock = underSurfaceBlock;
        this.stoneBlock = stoneBlock;
        this.deepStoneBlock = deepStoneBlock;
    }
}
