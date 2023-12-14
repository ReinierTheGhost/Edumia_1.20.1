package com.legends.edumia.dynamictrees.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.core.Vec3i;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.PathNavigationRegion;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.EmptyLevelChunk;

import javax.annotation.Nullable;

public final  class CoordUtils {

    public enum Surround implements StringRepresentable {
        N("n", Direction.NORTH),
        NW("nw", Direction.NORTH, Direction.WEST),
        W("w", Direction.WEST),
        SW("sw", Direction.SOUTH, Direction.WEST),
        S("s", Direction.SOUTH),
        SE("se", Direction.SOUTH, Direction.EAST),
        E("e", Direction.EAST),
        NE("ne", Direction.NORTH, Direction.EAST);

        final private String name;
        final private Vec3i offset;

        Surround(String name, Direction... dirs) {
            this.name = name;
            BlockPos pos = BlockPos.ZERO;
            for (Direction d : dirs) {
                pos = pos.offset(d.getNormal());
            }
            this.offset = pos;
        }

        public String getSerializedName() {
            return name;
        }

        public Vec3i getOffset() {
            return offset;
        }

        public BlockPos getOffsetPos() {
            return new BlockPos(offset);
        }

        public Surround getOpposite() {
            return values()[(ordinal() + 4) & 7];
        }
    }

    @SuppressWarnings("deprecation")
    public static boolean canAccessStateSafely(BlockGetter level, BlockPos pos) {
        if (level instanceof LevelReader) { // Handles most cases.
            return ((LevelReader) level).hasChunk(SectionPos.blockToSectionCoord(pos.getX()), SectionPos.blockToSectionCoord(pos.getZ()));
        } else if (level instanceof PathNavigationRegion) { // Handles Region.
            return !(((PathNavigationRegion) level).getChunk(pos) instanceof EmptyLevelChunk);
        }
        // Otherwise assume we can access state safely. In most cases this is true, and if not we know it is a
        // mod compatibility issue and a crash or logging will be more helpful in solving the problem.
        return true;
    }

    /**
     * Gets the {@link BlockState} object at the given position, or null if the block wasn't loaded. This is safer
     * because calling getBlockState on an unloaded block can cause a crash.
     *
     * @param level The {@link BlockGetter} object.
     * @return The {@link BlockState} object, or null if it's not loaded.
     */
    @Nullable
    public static BlockState getStateSafe(BlockGetter level, BlockPos blockPos) {
        return canAccessStateSafely(level, blockPos) ? level.getBlockState(blockPos) : null;
    }
}
