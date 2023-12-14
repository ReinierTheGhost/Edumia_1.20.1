package com.legends.edumia.datafix;

import com.google.common.base.Suppliers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.PathNavigationRegion;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.chunk.EmptyLevelChunk;

import java.util.function.Supplier;

public class ModPathNavigationRegion extends PathNavigationRegion {
    protected final int centerX;
    protected final int centerZ;
    protected final ChunkAccess[][] chunks;
    protected boolean allEmpty;
    protected final Level level;
    private final Supplier<Holder<Biome>> plains;
    public ModPathNavigationRegion(Level level, BlockPos pos, BlockPos pos1) {
        super(level, pos, pos);
        this.level = level;
        this.plains = Suppliers.memoize(() -> {
            return level.registryAccess().registryOrThrow(Registries.BIOME).getHolderOrThrow(Biomes.PLAINS);
        });
        this.centerX = SectionPos.blockToSectionCoord(pos.getX());
        this.centerZ = SectionPos.blockToSectionCoord(pos.getZ());
        int i = SectionPos.blockToSectionCoord(pos1.getX());
        int j = SectionPos.blockToSectionCoord(pos1.getZ());
        this.chunks = new ChunkAccess[i - this.centerX + 1][j - this.centerZ + 1];
        ChunkSource chunksource = level.getChunkSource();
        this.allEmpty = true;

        for(int k = this.centerX; k <= i; ++k) {
            for(int l = this.centerZ; l <= j; ++l) {
                this.chunks[k - this.centerX][l - this.centerZ] = chunksource.getChunkNow(k, l);
            }
        }

        for(int i1 = SectionPos.blockToSectionCoord(pos.getX()); i1 <= SectionPos.blockToSectionCoord(pos1.getX()); ++i1) {
            for(int j1 = SectionPos.blockToSectionCoord(pos.getZ()); j1 <= SectionPos.blockToSectionCoord(pos1.getZ()); ++j1) {
                ChunkAccess chunkaccess = this.chunks[i1 - this.centerX][j1 - this.centerZ];
                if (chunkaccess != null && !chunkaccess.isYSpaceEmpty(pos.getY(), pos1.getY())) {
                    this.allEmpty = false;
                    return;
                }
            }
        }

    }

    public ChunkAccess getChunk(BlockPos p_47186_) {
        return this.getChunk(SectionPos.blockToSectionCoord(p_47186_.getX()), SectionPos.blockToSectionCoord(p_47186_.getZ()));
    }

    private ChunkAccess getChunk(int p_47168_, int p_47169_) {
        int i = p_47168_ - this.centerX;
        int j = p_47169_ - this.centerZ;
        if (i >= 0 && i < this.chunks.length && j >= 0 && j < this.chunks[i].length) {
            ChunkAccess chunkaccess = this.chunks[i][j];
            return (ChunkAccess)(chunkaccess != null ? chunkaccess : new EmptyLevelChunk(this.level, new ChunkPos(p_47168_, p_47169_), this.plains.get()));
        } else {
            return new EmptyLevelChunk(this.level, new ChunkPos(p_47168_, p_47169_), this.plains.get());
        }
    }

}
