package com.legends.edumia.dynamictrees.block.rooty;

import com.legends.edumia.dynamictrees.api.network.MapSignal;
import com.legends.edumia.dynamictrees.api.treedata.TreePart;
import com.legends.edumia.dynamictrees.block.BlockWithDynamicHardness;
import com.legends.edumia.dynamictrees.block.branch.BranchBlock;
import com.legends.edumia.dynamictrees.block.entity.SpeciesBlockEntity;
import com.legends.edumia.dynamictrees.tree.family.Family;
import com.legends.edumia.dynamictrees.tree.species.Species;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class RootyBlock extends BlockWithDynamicHardness implements TreePart, EntityBlock {
    public RootyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public int probabilityForBlock(BlockState state, BlockGetter level, BlockPos pos, BranchBlock from) {
        return 0;
    }

    @Override
    public int getRadiusForConnection(BlockState state, BlockGetter level, BlockPos pos, BranchBlock from, Direction side, int fromRadius) {
        return 0;
    }

    @Override
    public int getRadius(BlockState state) {
        return 0;
    }

    @Override
    public boolean shouldAnalyse(BlockState state, BlockGetter level, BlockPos pos) {
        return false;
    }

    @Override
    public MapSignal analyse(BlockState state, LevelAccessor level, BlockPos pos, @Nullable Direction fromDir, MapSignal signal) {
        return null;
    }

    @Override
    public Family getFamily(BlockState state, BlockGetter level, BlockPos pos) {
        return null;
    }

    @Override
    public int branchSupport(BlockState state, BlockGetter level, BranchBlock branch, BlockPos pos, Direction dir, int radius) {
        return 0;
    }

    @Override
    public TreePartType getTreePartType() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return null;
    }

    /**
     * Rooty Dirt can report whatever {@link Family} species it wants to be. We'll use a stored value to determine the
     * species for the {@link BlockEntity} version. Otherwise we'll just make it report whatever { DynamicTrees} the
     * above {@link BranchBlock} says it is.
     */
    public Species getSpecies(BlockState state, LevelAccessor level, BlockPos rootPos) {

        Family tree = getFamily(state, level, rootPos);

        SpeciesBlockEntity rootyDirtTE = getTileEntitySpecies(level, rootPos);

        if (rootyDirtTE != null) {
            Species species = rootyDirtTE.getSpecies();
            if (species.getFamily() == tree) {//As a sanity check we should see if the tree and the stored species are a match
                return rootyDirtTE.getSpecies();
            }
        }

        return tree.getSpeciesForLocation(level, rootPos.relative(getTrunkDirection(level, rootPos)));
    }

    public Direction getTrunkDirection(BlockGetter access, BlockPos rootPos) {
        return Direction.UP;
    }
    @Nullable
    private SpeciesBlockEntity getTileEntitySpecies(LevelAccessor level, BlockPos pos) {
        final BlockEntity blockEntity = level.getBlockEntity(pos);
        if(blockEntity == null)
            return null;
        return blockEntity instanceof SpeciesBlockEntity ? (SpeciesBlockEntity) blockEntity : null;
    }

}
