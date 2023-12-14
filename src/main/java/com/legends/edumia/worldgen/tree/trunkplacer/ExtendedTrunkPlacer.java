package com.legends.edumia.worldgen.tree.trunkplacer;

import com.legends.edumia.worldgen.datafix.ModTreeFeature;
import com.mojang.datafixers.Products;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedRW;
import net.minecraft.world.level.LevelWriter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

import java.util.Optional;
import java.util.Random;
import java.util.Set;

public abstract class ExtendedTrunkPlacer extends TrunkPlacer {

    protected final Optional<BlockStateProvider> woodProvider;
    protected final Optional<BlockStateProvider> strippedLogProvider;
    protected final Optional<BlockStateProvider> branchProvider;

    protected static <P extends ExtendedTrunkPlacer> Products.P6<RecordCodecBuilder.Mu<P>, Integer, Integer, Integer, Optional<BlockStateProvider>,
            Optional<BlockStateProvider>, Optional<BlockStateProvider>> baseCodecWithWood(RecordCodecBuilder.Instance<P> instance){
        return trunkPlacerParts(instance).and(instance.group(BlockStateProvider.CODEC.optionalFieldOf("wood_provider").forGetter((trunk) -> {
            return trunk.woodProvider;
        }), BlockStateProvider.CODEC.optionalFieldOf("stripped_log_provider").forGetter((trunk) -> {
            return trunk.strippedLogProvider;
        }), BlockStateProvider.CODEC.optionalFieldOf("branch_provider").forGetter((trunk) -> {
            return trunk.branchProvider;
                })));
    }

    protected ExtendedTrunkPlacer(int baseHeight, int heightRandA, int heightRandB, Optional<BlockStateProvider> woodProvider,
    Optional<BlockStateProvider> strippedLogProvider, Optional<BlockStateProvider> branchProvider) {
        super(baseHeight, heightRandA, heightRandB);
        this.woodProvider = woodProvider;
        this.strippedLogProvider = strippedLogProvider;
        this.branchProvider = branchProvider;
    }

    protected boolean placeLogWithAxis(LevelSimulatedRW world, RandomSource rand, BlockPos pos, Set<BlockPos> trunk, BoundingBox bb,
                                       TreeConfiguration config, Direction.Axis axis){
        if (TreeFeature.validTreePos(world, pos)){
            BlockState logState = config.trunkProvider.getState(rand, pos);
            if (logState.hasProperty(RotatedPillarBlock.AXIS)){
                logState = (BlockState) logState.setValue(RotatedPillarBlock.AXIS, axis);
            }

            setBlock(world, pos, logState, bb);
            trunk.add(pos.immutable());
            return true;
        }else{
            return false;
        }
    }

    protected boolean placeWood(LevelSimulatedRW world, RandomSource rand, BlockPos pos, Set<BlockPos> trunk, BoundingBox bb, TreeConfiguration config,
                                Direction.Axis axis){
        if (TreeFeature.validTreePos(world, pos)){
            BlockState woodState =((BlockStateProvider) this.woodProvider.orElseThrow(() -> {
                return new IllegalStateException("Wood blockstate provider is not set!");
            })).getState(rand, pos);
            if (woodState.hasProperty(RotatedPillarBlock.AXIS)) {
                woodState = (BlockState) woodState.setValue(RotatedPillarBlock.AXIS, axis);
            }

            setBlock(world, pos, woodState, bb);
            trunk.add(pos.immutable());
            return true;
        }else {
            return false;
        }
    }

    protected boolean placeStrippedLog(LevelSimulatedRW world, RandomSource rand, BlockPos pos, Set<BlockPos> trunk, BoundingBox bb,
                                       TreeConfiguration config, Direction.Axis axis){
        if (TreeFeature.validTreePos(world, pos)){
            BlockState strippedLogState =((BlockStateProvider) this.strippedLogProvider.orElseThrow(() -> {
                return new IllegalStateException("Stripped log blockstate provider is not set!");
            })).getState(rand, pos);
            if (strippedLogState.hasProperty(RotatedPillarBlock.AXIS)) {
                strippedLogState = (BlockState) strippedLogState.setValue(RotatedPillarBlock.AXIS, axis);
            }

            setBlock(world, pos, strippedLogState, bb);
            trunk.add(pos.immutable());
            return true;
        }else {
            return false;
        }
    }

    protected static void setBlock(LevelWriter level, BlockPos pos, BlockState state, BoundingBox bb){
        ModTreeFeature.setBlockKnownShape(level, pos, state);
        bb.encapsulate(new BoundingBox(pos));
    }




}
