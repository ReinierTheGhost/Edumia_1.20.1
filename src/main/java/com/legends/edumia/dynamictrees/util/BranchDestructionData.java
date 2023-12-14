package com.legends.edumia.dynamictrees.util;

import com.legends.edumia.dynamictrees.block.branch.BranchBlock;
import com.legends.edumia.dynamictrees.systems.nodemapper.NetVolumeNode;
import com.legends.edumia.dynamictrees.tree.species.Species;
import com.google.common.collect.AbstractIterator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import java.util.Map;

public class BranchDestructionData {
    public final Species species; // The species of the tree that was harvested
    public final int[] destroyedBranchesRadiusPosition; // Encoded branch radius and relative positions
    public final int[] destroyedBranchesConnections; // Encoded branch shapes
    public final int[] destroyedBranchesBlockIndex; // Encoded valid branch block index for family
    public final int[] destroyedLeaves; // Encoded leaves relative positions
    public final int[] destroyedLeavesBlockIndex; // Encoded valid leaves block index for species
    public final List<BranchBlock.ItemStackPos> leavesDrops; // A list of itemstacks and their spawn positions.  Not used on the client.
    public final int[] endPoints; // Encoded endpoint relative positions
    public final NetVolumeNode.Volume woodVolume; // A summation of all of the wood voxels that was harvested
    public final Direction cutDir; // The face that was connected to the remaining body of the tree or the rooty block
    public final Direction toolDir; // The face that was pounded on when breaking the block at cutPos
    public final BlockPos cutPos; // The absolute(world) position of the block that was cut
    public final int trunkHeight;
    public static final BlockBounds bounds = new BlockBounds(new BlockPos(-64, -64, -64),
            new BlockPos(64, 64, 64));

    public BranchDestructionData() {
        this.species = Species.NULL_SPECIES;
        this.destroyedBranchesConnections = new int[0];
        this.destroyedBranchesRadiusPosition = new int[0];
        this.destroyedBranchesBlockIndex = new int[0];
        this.destroyedLeaves = new int[0];
        this.destroyedLeavesBlockIndex = new int[0];
        this.leavesDrops = new ArrayList<>(0);
        this.endPoints = new int[0];
        this.woodVolume = new NetVolumeNode.Volume();
        this.cutDir = Direction.DOWN;
        this.toolDir = Direction.DOWN;
        this.cutPos = BlockPos.ZERO;
        this.trunkHeight = 0;
    }

    public BranchDestructionData(Species species, Map<BlockPos, BranchConnectionData> branches, Map<BlockPos, BlockState> leaves,
                                 List<BranchBlock.ItemStackPos> leavesDrops, List<BlockPos> ends, NetVolumeNode.Volume volume,
                                 BlockPos cutPos, Direction cutDir, Direction toolDir, int trunkHeight) {
        this.species = species;
        int[][] encodedBranchData = convertBranchesToIntArrays(branches);
        this.destroyedBranchesRadiusPosition = encodedBranchData[0];
        this.destroyedBranchesConnections = encodedBranchData[1];
        this.destroyedBranchesBlockIndex = encodedBranchData[2];
        int[][] encodedLeavesData = convertLeavesToIntArray(leaves, species);
        this.destroyedLeaves = encodedLeavesData[0];
        this.destroyedLeavesBlockIndex = encodedLeavesData[1];
        this.leavesDrops = leavesDrops;
        this.endPoints = convertEndPointsToIntArray(ends);
        this.woodVolume = volume;
        this.cutPos = cutPos;
        this.cutDir = cutDir;
        this.toolDir = toolDir;
        this.trunkHeight = trunkHeight;
    }



    ///////////////////////////////////////////////////////////
    // Branches
    ///////////////////////////////////////////////////////////

    private int[][] convertBranchesToIntArrays(Map<BlockPos, BranchConnectionData> branchList) {
        int[] radPosData = new int[branchList.size()];
        int[] connectionData = new int[branchList.size()];
        int[] blockIndexData = new int[branchList.size()];
        int index = 0;

        //Ensure the origin block is at the first index
        BranchConnectionData origConnData = branchList.get(BlockPos.ZERO);
        if (origConnData != null) {
            BlockState origState = origConnData.getBlockState();
            radPosData[index] = encodeBranchesRadiusPos(BlockPos.ZERO, (BranchBlock) origState.getBlock(), origState);
            connectionData[index] = encodeBranchesConnections(origConnData.getConnections());
            blockIndexData[index++] = encodeBranchBlocks((BranchBlock) origState.getBlock());
            branchList.remove(BlockPos.ZERO);
        }

        //Encode the remaining blocks
        for (Entry<BlockPos, BranchConnectionData> set : branchList.entrySet()) {
            BlockPos relPos = set.getKey();
            BranchConnectionData connData = set.getValue();
            BlockState state = connData.getBlockState();
            Block block = state.getBlock();

            if (block instanceof BranchBlock && bounds.inBounds(relPos)) { //Place comfortable limits on the system
                radPosData[index] = encodeBranchesRadiusPos(relPos, (BranchBlock) block, state);
                connectionData[index] = encodeBranchesConnections(connData.getConnections());
                blockIndexData[index++] = encodeBranchBlocks((BranchBlock) block);
            }
        }

        //Shrink down the arrays
        radPosData = Arrays.copyOf(radPosData, index);
        connectionData = Arrays.copyOf(connectionData, index);
        blockIndexData = Arrays.copyOf(blockIndexData, index);

        return new int[][]{radPosData, connectionData, blockIndexData};
    }

    private int encodeBranchesRadiusPos(BlockPos relPos, BranchBlock branchBlock, BlockState state) {
        return ((branchBlock.getRadius(state) & 0x1F) << 24) | //Radius 0 - 31
                encodeRelBlockPos(relPos);
    }

    private int encodeBranchesConnections(Connections exState) {
        int result = 0;
        int[] radii = exState.getAllRadii();
        for (Direction face : Direction.values()) {
            int faceIndex = face.get3DDataValue();
            int rad = radii[faceIndex];
            result |= (rad & 0x1F) << (faceIndex * 5);//5 bits per face * 6 faces = 30bits
        }
        return result;
    }

    private int encodeBranchBlocks(BranchBlock branch) {
        return branch.getFamily().getBranchBlockIndex(branch);
    }

    ///////////////////////////////////////////////////////////
    // Leaves
    ///////////////////////////////////////////////////////////

    private int[][] convertLeavesToIntArray(Map<BlockPos, BlockState> leavesList, Species species) {
        int[] posData = new int[leavesList.size()];
        int[] blockIndexData = new int[leavesList.size()];
        int index = 0;

        //Encode the remaining blocks
        for (Entry<BlockPos, BlockState> set : leavesList.entrySet()) {
            BlockPos relPos = set.getKey();
            BlockState state = set.getValue();
            Block block = state.getBlock();

            if (species.canEncodeLeavesBlocks(relPos, state, block, this) && bounds.inBounds(relPos)) { //Place comfortable limits on the system
                posData[index] = species.encodeLeavesPos(relPos, state, block, this);
                blockIndexData[index++] = species.encodeLeavesBlocks(relPos, state, block, this);
            }
        }
        posData = Arrays.copyOf(posData, index); //Shrink down the array
        blockIndexData = Arrays.copyOf(blockIndexData, index);

        return new int[][]{posData, blockIndexData};
    }

    ///////////////////////////////////////////////////////////
    // End Points
    ///////////////////////////////////////////////////////////

    private int[] convertEndPointsToIntArray(List<BlockPos> endPoints) {
        int[] data = new int[endPoints.size()];
        int index = 0;

        for (BlockPos relPos : endPoints) {
            if (bounds.inBounds(relPos)) { //Place comfortable limits on the system
                data[index++] = encodeRelBlockPos(relPos);
            }
        }

        return Arrays.copyOf(data, index);//Shrink down the array
    }



    ///////////////////////////////////////////////////////////
    // Generic
    ///////////////////////////////////////////////////////////

    public static int encodeRelBlockPos(BlockPos relPos) {
        return (((relPos.getX() + 64) & 0xFF) << 16) |
                (((relPos.getY() + 64) & 0xFF) << 8) |
                (((relPos.getZ() + 64) & 0xFF));
    }

    public static BlockPos decodeRelPos(int encoded) {
        return new BlockPos(
                (((encoded >> 16) & 0xFF) - 64),
                (((encoded >> 8) & 0xFF) - 64),
                (((encoded) & 0xFF) - 64)
        );
    }


}
