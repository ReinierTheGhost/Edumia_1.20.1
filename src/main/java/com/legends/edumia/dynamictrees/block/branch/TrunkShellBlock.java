package com.legends.edumia.dynamictrees.block.branch;

import com.legends.edumia.dynamictrees.block.BlockWithDynamicHardness;
import com.legends.edumia.dynamictrees.util.CoordUtils;
import com.legends.edumia.dynamictrees.util.CoordUtils.Surround;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.ticks.ScheduledTick;
import net.minecraft.world.ticks.TickPriority;

import javax.annotation.Nullable;

@SuppressWarnings("deprecation")
public class TrunkShellBlock extends BlockWithDynamicHardness implements SimpleWaterloggedBlock {

    public static final EnumProperty<Surround> CORE_DIR = EnumProperty.create("coredir", Surround.class);

    public static class ShellMuse {
        public final BlockState state;
        public final BlockPos pos;
        public final BlockPos museOffset;
        public final Surround dir;

        public ShellMuse(BlockState state, BlockPos pos, Surround dir, BlockPos museOffset) {
            this.state = state;
            this.pos = pos;
            this.dir = dir;
            this.museOffset = museOffset;
        }

        public int getRadius() {
            final Block block = this.state.getBlock();
            return block instanceof BranchBlock ? ((BranchBlock) block).getRadius(state) : 0;
        }
    }
    public TrunkShellBlock(Properties properties) {
        super(properties);
    }

    public Surround getMuseDir(BlockState state, BlockPos pos) {
        return state.getValue(CORE_DIR);
    }

    @Nullable
    public ShellMuse getMuseUnchecked(BlockGetter level, BlockState state, BlockPos pos) {
        return this.getMuseUnchecked(level, state, pos, pos);
    }
    @Nullable
    public ShellMuse getMuseUnchecked(BlockGetter level, BlockState state, BlockPos pos, BlockPos originalPos) {
        final Surround museDir = getMuseDir(state, pos);
        final BlockPos musePos = pos.offset(museDir.getOffset());
        final BlockState museState = CoordUtils.getStateSafe(level, musePos);

        if (museState == null) {
            return null;
        }

        final Block block = museState.getBlock();
        if (block instanceof Musable && ((Musable) block).isMusable(level, museState, musePos)) {
            return new ShellMuse(museState, musePos, museDir, musePos.subtract(originalPos));
        } else if (block instanceof TrunkShellBlock) { // If its another trunkshell, then this trunkshell is on another layer. IF they share a common direction, we return that shell's muse.
            final Vec3i offset = ((TrunkShellBlock) block).getMuseDir(museState, musePos).getOffset();
            if (new Vec3(offset.getX(), offset.getY(), offset.getZ()).add(new Vec3(museDir.getOffset().getX(), museDir.getOffset().getY(), museDir.getOffset().getZ())).lengthSqr() > 2.25) {
                return (((TrunkShellBlock) block).getMuseUnchecked(level, museState, musePos, originalPos));
            }
        }
        return null;
    }

    @Nullable
    public ShellMuse getMuse(BlockGetter level, BlockPos pos) {
        return this.getMuse(level, level.getBlockState(pos), pos);
    }

    @Nullable
    public ShellMuse getMuse(BlockGetter level, BlockState state, BlockPos pos) {
        final ShellMuse muse = this.getMuseUnchecked(level, state, pos);

        // Check the muse for validity.
        if (!isValid(muse)) {
            this.scheduleUpdateTick(level, pos);
        }

        return muse;
    }

    protected boolean isValid(@Nullable ShellMuse muse) {
        return muse != null && muse.getRadius() > 8;
    }

    public void scheduleUpdateTick(BlockGetter level, BlockPos pos) {
        if (!(level instanceof LevelAccessor)) {
            return;
        }

        ((LevelAccessor) level).getBlockTicks().schedule(new ScheduledTick<Block>(this,pos.immutable(), 0, TickPriority.HIGH,0));
    }
}
