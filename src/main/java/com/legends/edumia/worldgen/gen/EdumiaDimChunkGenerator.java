package com.legends.edumia.worldgen.gen;

import com.legends.edumia.worldgen.biome.EdumiaBiomes;
import com.legends.edumia.worldgen.biome.ModBiomeSource;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryOps;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.blending.Blender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class EdumiaDimChunkGenerator extends ChunkGenerator {

    public static final int STONE_HEIGHT = 32;
    public static final int WATER_HEIGHT = 64;
    public static final int HEIGHT = 24 + STONE_HEIGHT;
    public static final int DIRT_HEIGHT = 3 + HEIGHT;

    HolderGetter<Biome> biomeRegistry;
    public static final Codec<EdumiaDimChunkGenerator> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(RegistryOps.retrieveGetter(Registries.BIOME))
                    .apply(instance, instance.stable(EdumiaDimChunkGenerator::new)));

    public EdumiaDimChunkGenerator(HolderGetter<Biome> biomeRegistry) {
        super(new ModBiomeSource(
                new ArrayList<>(Arrays.asList(
                        biomeRegistry.getOrThrow(EdumiaBiomes.DEEP_OCEAN),
                        biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELVEN_RIVER),
                        biomeRegistry.getOrThrow(EdumiaBiomes.HAZE_MOUNTAIN),
                        biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELF_PLATEAU),
                        biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS),
                        biomeRegistry.getOrThrow(EdumiaBiomes.TAIGA_FOREST),
                        biomeRegistry.getOrThrow(EdumiaBiomes.OGRE_FOREST_VALLEY),
                        biomeRegistry.getOrThrow(EdumiaBiomes.HOLY_ORC_DESERT),
                        biomeRegistry.getOrThrow(EdumiaBiomes.TAIGA_MOUNTAIN_HILLS)
                    ))
                )
        );
        this.biomeRegistry = biomeRegistry;
    }


    @Override
    protected Codec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public void applyCarvers(WorldGenRegion chunkRegion, long seed, RandomState noiseConfig, BiomeManager biomeAccess,
                             StructureManager structureAccessor, ChunkAccess chunk2, GenerationStep.Carving carverStep) {

    }

    @Override
    public void buildSurface(WorldGenRegion region, StructureManager structures, RandomState noiseConfig, ChunkAccess chunk) {

    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion region) {
        ChunkPos chunkPos = region.getCenter();
        Holder<Biome> registryEntry = region.getBiome(chunkPos.getWorldPosition().atY(region.getHeight() - 1));
        WorldgenRandom chunkRandom = new WorldgenRandom(new LegacyRandomSource(RandomSupport.generateUniqueSeed()));
        chunkRandom.setDecorationSeed(region.getSeed(), chunkPos.getMinBlockX(), chunkPos.getMinBlockZ());
        NaturalSpawner.spawnMobsForChunkGeneration(region, registryEntry, chunkPos, chunkRandom);
    }

    @Override
    public int getGenDepth() {
        return 512;
    }

    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Executor executor, Blender blender, RandomState noiseConfig,
                                                        StructureManager structureAccessor, ChunkAccess chunk) {
        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public int getSeaLevel() {
        return WATER_HEIGHT;
    }

    @Override
    public int getMinY() {
        return -64;
    }

    @Override
    public int getBaseHeight(int x, int z, Heightmap.Types heightmap, LevelHeightAccessor world, RandomState noiseConfig) {
        float worldHeight = 1 + DIRT_HEIGHT + EdumiaHeightMap.getHeight(x, z);
        return (int) worldHeight;
    }

    @Override
    public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor world, RandomState noiseConfig) {
        return new NoiseColumn(0, new BlockState[0]);
    }

    @Override
    public void addDebugScreenInfo(List<String> text, RandomState noiseConfig, BlockPos pos) {

    }
}
