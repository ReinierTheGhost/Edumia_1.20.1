package com.legends.edumia.dynamictrees.api;

import com.google.common.io.Files;
import com.legends.edumia.dynamictrees.api.network.MapSignal;
import com.legends.edumia.dynamictrees.api.treedata.TreePart;
import com.legends.edumia.dynamictrees.block.NullTreePart;
import com.legends.edumia.dynamictrees.block.branch.BranchBlock;
import com.legends.edumia.dynamictrees.block.branch.TrunkShellBlock;
import com.legends.edumia.dynamictrees.block.leaves.DynamicLeavesBlock;
import com.legends.edumia.dynamictrees.block.rooty.RootyBlock;
import com.legends.edumia.dynamictrees.tree.species.Species;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.Optional;

public class TreeHelper {

    public static final TreePart NULL_TREE_PART = new NullTreePart();

    ///////////////////////////////////////////
    //CONVENIENCE METHODS
    ///////////////////////////////////////////

    public static BlockPos dereferenceTrunkShell(Level level, BlockPos pos) {

        BlockState blockState = level.getBlockState(pos);

        if (blockState.getBlock() instanceof TrunkShellBlock) {
            TrunkShellBlock.ShellMuse muse = ((TrunkShellBlock) blockState.getBlock()).getMuse(level, blockState, pos);
            if (muse != null) {
                return muse.pos;
            }
        }

        return pos;
    }

    /**
     * This is resource intensive.  Use only for interaction code. Only the root node can determine the exact species
     * and it has to be found by mapping the branch network.
     *
     * @param level The {@link Level} instance.
     * @param pos   The {@link BlockPos} to find the {@link Species} at.
     * @return The {@link Species}, or {@link Species#NULL_SPECIES} if one couldn't be found.
     */
    public static Species getExactSpecies(Level level, BlockPos pos) {
        BlockPos rootPos = findRootNode(level, pos);

        if (rootPos != BlockPos.ZERO) {
            BlockState rootyState = level.getBlockState(rootPos);
            return TreeHelper.getRooty(rootyState).getSpecies(rootyState, level, rootPos);
        }
        return Species.NULL_SPECIES;
    }

    //Treeparts

    public static boolean isTreePart(Block block) {
        return block instanceof TreePart;
    }

    public static boolean isTreePart(BlockState state) {
        return isTreePart(state.getBlock());
    }

    public static boolean isTreePart(LevelAccessor level, BlockPos pos) {
        return isTreePart(level.getBlockState(pos).getBlock());
    }

    public static TreePart getTreePart(Block block) {
        return isTreePart(block) ? (TreePart) block : NULL_TREE_PART;
    }

    public static TreePart getTreePart(BlockState state) {
        return getTreePart(state.getBlock());
    }


    //Branches
    public static boolean isBranch(Block block) {
        return block instanceof BranchBlock;//Oh shuddap you java purists.. this is minecraft!
    }

    public static boolean isBranch(@Nullable final BlockState state) {
        return state != null && isBranch(state.getBlock());
    }

    @Nullable
    public static BranchBlock getBranch(Block block) {
        return isBranch(block) ? (BranchBlock) block : null;
    }

    @Nullable
    public static BranchBlock getBranch(TreePart treePart) {
        return treePart instanceof BranchBlock ? (BranchBlock) treePart : null;
    }

    @Nullable
    public static BranchBlock getBranch(BlockState state) {
        return getBranch(state.getBlock());
    }

    public static int getRadius(BlockGetter level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        return getTreePart(state).getRadius(state);
    }

    public static Optional<BranchBlock> getBranchOpt(Block block) {
        return isBranch(block) ? Optional.of((BranchBlock) block) : Optional.empty();
    }

    public static Optional<BranchBlock> getBranchOpt(BlockState state) {
        final Block block = state.getBlock();
        return isBranch(block) ? Optional.of((BranchBlock) block) : Optional.empty();
    }

    public static Optional<BranchBlock> getBranchOpt(TreePart treePart) {
        return treePart instanceof BranchBlock ? Optional.of((BranchBlock) treePart) : Optional.empty();
    }

//    public static Optional<RootyBlock> getRootyOpt(BlockState state) {
//        Block block = state.getBlock();
//        return isRooty(block) ? Optional.of((RootyBlock) block) : Optional.empty();
//    }


    /**
     * Find the root node of a tree.
     *
     * @param level The level
     * @param pos   The position being analyzed
     * @return The position of the root node of the tree or BlockPos.ZERO if nothing was found.
     */
    public static BlockPos findRootNode(Level level, BlockPos pos) {

        pos = dereferenceTrunkShell(level, pos);
        BlockState state = level.getBlockState(pos);
        TreePart treePart = TreeHelper.getTreePart(level.getBlockState(pos));

        switch (treePart.getTreePartType()) {
            case BRANCH:
                MapSignal signal = treePart.analyse(state, level, pos, null, new MapSignal());// Analyze entire tree network to find root node
                if (signal.foundRoot) {
                    return signal.root;
                }
                break;
            case ROOT:
                return pos;
            default:
                return BlockPos.ZERO;
        }

        return BlockPos.ZERO;
    }

    //Rooty

    public static boolean isRooty(Block block) {
        return block instanceof RootyBlock;
    }

    public static boolean isRooty(BlockState state) {
        return isRooty(state.getBlock());
    }

    @Nullable
    public static RootyBlock getRooty(Block block) {
        return isRooty(block) ? (RootyBlock) block : null;
    }

    @Nullable
    public static RootyBlock getRooty(TreePart treePart) {
        return treePart instanceof RootyBlock ? (RootyBlock) treePart : null;
    }

    @Nullable
    public static RootyBlock getRooty(BlockState state) {
        return getRooty(state.getBlock());
    }


    public static boolean isLeaves(Block block) {
        return block instanceof DynamicLeavesBlock;
    }
    @Nullable
    public static DynamicLeavesBlock getLeaves(Block block) {
        return isLeaves(block) ? (DynamicLeavesBlock) block : null;
    }

    @Nullable
    public static DynamicLeavesBlock getLeaves(TreePart treePart) {
        return treePart instanceof DynamicLeavesBlock ? (DynamicLeavesBlock) treePart : null;
    }

    @Nullable
    public static DynamicLeavesBlock getLeaves(BlockState state) {
        return getLeaves(state.getBlock());
    }

}
