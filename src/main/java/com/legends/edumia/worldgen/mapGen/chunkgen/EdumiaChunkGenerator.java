package com.legends.edumia.worldgen.mapGen.chunkgen;

import com.legends.edumia.worldgen.mapGen.biomes.EdumiaBiome;
import com.legends.edumia.worldgen.mapGen.biomes.EdumiaBiomeKeys;
import com.legends.edumia.worldgen.mapGen.biomes.EdumiaBiomesData;
import com.legends.edumia.worldgen.mapGen.biomes.ModBiomeSource;
import com.legends.edumia.worldgen.mapGen.chunkgen.map.EdumiaHeightMap;
import com.legends.edumia.worldgen.mapGen.chunkgen.map.MapImageLoader;
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
import net.minecraft.world.level.block.Blocks;
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

public class EdumiaChunkGenerator extends ChunkGenerator {
    public static final int STONE_HEIGHT = 32;
    public static final int WATER_HEIGHT = 64;
    public static final int HEIGHT = 24 + STONE_HEIGHT;
    public static final int DIRT_HEIGHT = 3 + HEIGHT;

    HolderGetter<Biome> biomeRegistry;
    public static final Codec<EdumiaChunkGenerator> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(RegistryOps.retrieveGetter(Registries.BIOME))
                    .apply(instance, instance.stable(EdumiaChunkGenerator::new)));

    public EdumiaChunkGenerator(HolderGetter<Biome> biomeRegistry) {
        super(new ModBiomeSource(
                new ArrayList<>(Arrays.asList(
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.OCEAN),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.ANDUIN_VALES),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.BARROW_DOWNS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.BLUE_MOUNTAINS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.BLUE_MOUNTAINS_FOOTHILLS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.CORSAIR_COASTS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DALE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DARK_MIRKWOOD),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DARK_MIRKWOOD_EDGE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DARK_ANDUIN_VALES),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DOL_GULDUR ),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DORWINION_HILLS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.DUNLAND_FOOTHILLS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.EASTERN_RHOVANION),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.ENEDWAITH),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.EREGION),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.ERIADOR),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.FANGORN),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.FORODWAITH),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.FROZEN_OCEAN),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.GONDOR),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.GREY_PLAINS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.HARAD),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.HARAD_DESERT),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.HARONDOR),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.IRON_HILLS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.IRON_HILLS_FRONTIER),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.LINDON),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.LONG_LAKE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.LORIEN_EDGE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.LOTHLORIEN),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MILLPOND),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MIRKWOOD),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MIRKWOOD_EDGE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MIRKWOOD_FOOTHILLS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MIRKWOOD_MOUNTAINS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MIRKWOOD_SWAMP),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MISTY_MOUNTAINS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MORDOR),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MORDOR_MOUNTAINS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.MORDOR_WASTES),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.NORTHERN_DUNLAND),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.NORTHERN_WASTELANDS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.NURN),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.NURN_RIVER),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.NURN_SEA),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.OCEAN_COAST),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.OLD_ANGMAR),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.OLD_ARTHEDAIN),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.OLD_RHUDAUR),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.RHUN),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.RIVENDELL),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.RIVENDELL_FOOTHILLS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.RIVER),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.ROHAN),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.SEA_OF_RHUN),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.SHIRE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.SOUTHEAST_RHOVANION),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.SOUTHERN_DUNLAND),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.SOUTHERN_FOROCHEL),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.THE_ANGLE),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.THE_OLD_FOREST),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.THE_WOLD),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.TOLFALAS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.TROLLSHAWS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.UMBAR),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.WASTE_POND),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.WHITE_MOUNTAINS),
                    biomeRegistry.getOrThrow(EdumiaBiomeKeys.WOODLAND_REALM)
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
    public void applyCarvers(WorldGenRegion chunkRegion, long seed, RandomState noiseConfig,
                             BiomeManager biomeAccess, StructureManager structureAccessor,
                             ChunkAccess chunk2, GenerationStep.Carving carverStep) {

    }

    @Override
    public void buildSurface(WorldGenRegion region, StructureManager structures, RandomState noiseConfig, ChunkAccess chunk) {
        int bottomY = chunk.getMinBuildHeight();
        for(int x = 0; x < 16; x++) {
            for(int z = 0; z < 16; z++) {
                int posX = (chunk.getPos().x * 16) + x;
                int posZ = (chunk.getPos().z * 16) + z;
                EdumiaBiome edumiaBiome;

                if(EdumiaHeightMap.isCoordinateInBounds(posX, posZ)) {
                    edumiaBiome = EdumiaBiomesData.biomeMap.get(MapImageLoader.getBiomeColor(posX, posZ));
                } else {
                    edumiaBiome = EdumiaBiomesData.defaultBiome;
                }

                if(edumiaBiome == null) {
                    int c = MapImageLoader.getBiomeColor(posX, posZ);
                    edumiaBiome = EdumiaBiomesData.defaultBiome;
                }

                float height = EdumiaHeightMap.getHeight(posX, posZ);

                for(int y = bottomY + 1; y <= WATER_HEIGHT; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockAt(x, y, z), Blocks.WATER.defaultBlockState(), false);
                }
                chunk.setBlockState(chunk.getPos().getBlockAt(x, bottomY, z), Blocks.BEDROCK.defaultBlockState(), false);
                for(int y = bottomY + 1; y < STONE_HEIGHT + height; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockAt(x, y, z), edumiaBiome.deepStoneBlock.defaultBlockState(), false);
                }
                if(Math.random() < 0.5f) chunk.setBlockState(chunk.getPos().getBlockAt(x, chunk.getMinBuildHeight() + 1, z), Blocks.BEDROCK.defaultBlockState(), false);
                for(int y = (int) (STONE_HEIGHT + height); y < HEIGHT + height; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockAt(x, y, z), edumiaBiome.stoneBlock.defaultBlockState(), false);
                }
                for(int y = (int) (HEIGHT + height); y < DIRT_HEIGHT + height; y++) {
                    chunk.setBlockState(chunk.getPos().getBlockAt(x, y, z), edumiaBiome.underSurfaceBlock.defaultBlockState(), false);
                }

                BlockState surfaceBlock = edumiaBiome.surfaceBlock.defaultBlockState();
                if(DIRT_HEIGHT + height < WATER_HEIGHT && edumiaBiome.surfaceBlock == Blocks.GRASS_BLOCK) {
                    surfaceBlock = Blocks.DIRT.defaultBlockState();
                }
                chunk.setBlockState(chunk.getPos().getBlockAt(x, (int) (DIRT_HEIGHT + height), z), surfaceBlock, false);
            }
        }

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
        return 256;
    }


    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Executor executor, Blender blender, RandomState noiseConfig, StructureManager structureAccessor, ChunkAccess chunk) {

        return CompletableFuture.completedFuture(chunk);
    }

    @Override
    public int getSeaLevel() {
        return WATER_HEIGHT;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public int getBaseHeight(int x, int z, Heightmap.Types heightmap, LevelHeightAccessor world, RandomState noiseConfig) {
        float worldHeight = 1 + DIRT_HEIGHT + EdumiaHeightMap.getHeight(x, z);
        return (int)worldHeight;
    }

    @Override
    public NoiseColumn getBaseColumn(int x, int z, LevelHeightAccessor world, RandomState noiseConfig) {
        return new NoiseColumn(0, new BlockState[0]);
    }

    @Override
    public void addDebugScreenInfo(List<String> text, RandomState noiseConfig, BlockPos pos) {

    }
}
