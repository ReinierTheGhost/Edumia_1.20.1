package com.legends.edumia.dynamictrees.block;

import com.legends.edumia.dynamictrees.api.network.MapSignal;
import com.legends.edumia.dynamictrees.api.treedata.TreePart;
import com.legends.edumia.dynamictrees.block.branch.BranchBlock;
import com.legends.edumia.dynamictrees.tree.family.Family;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class NullTreePart implements TreePart {
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
}
