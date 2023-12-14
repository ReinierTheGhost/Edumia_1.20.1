package com.legends.edumia.dynamictrees.systems.nodemapper;

import com.legends.edumia.dynamictrees.api.TreeHelper;
import com.legends.edumia.dynamictrees.api.network.NodeInspector;
import com.legends.edumia.dynamictrees.block.branch.BranchBlock;
import com.legends.edumia.dynamictrees.util.BranchConnectionData;
import com.legends.edumia.dynamictrees.util.Connections;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

/**
 * Makes a BlockPos -> BlockState map for all of the branches
 *
 * @author ferreusveritas
 */
public class StateNode implements NodeInspector {

    private final Map<BlockPos, BranchConnectionData> map = new HashMap<>();
    private final BlockPos origin;

    public StateNode(BlockPos origin) {
        this.origin = origin;
    }

    public Map<BlockPos, BranchConnectionData> getBranchConnectionMap() {
        return map;
    }

    @Override
    public boolean run(BlockState state, LevelAccessor level, BlockPos pos, Direction fromDir) {
        BranchBlock branch = TreeHelper.getBranch(state);

        if (branch != null) {
            Connections connData = branch.getConnectionData(level, pos, state);
            map.put(pos.subtract(origin), new BranchConnectionData(state, connData));
        }

        return true;
    }

    @Override
    public boolean returnRun(BlockState state, LevelAccessor level, BlockPos pos, Direction fromDir) {
        return false;
    }
}
