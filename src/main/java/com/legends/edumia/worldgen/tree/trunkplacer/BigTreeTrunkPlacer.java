package com.legends.edumia.worldgen.tree.trunkplacer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.legends.edumia.core.ModTrunkPlacerType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class BigTreeTrunkPlacer extends TrunkPlacer {
    public static final Codec<BigTreeTrunkPlacer> CODEC = RecordCodecBuilder.create
            (bigTreeTrunkPlacerInstance -> trunkPlacerParts(bigTreeTrunkPlacerInstance).apply
                    (bigTreeTrunkPlacerInstance, BigTreeTrunkPlacer::new));

    public BigTreeTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerType.BIG_TREE_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk
            (LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter,
             RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {

        List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
        // THIS IS WHERE THE BLOCK PLACING LOGIC IS!
        BlockPos blockpos = pPos.below();
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos, pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.north(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.east(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.south(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.west(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.north().east(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.north().west(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.south().east(), pConfig);
        setDirtAt(pLevel, pBlockSetter, pRandom, blockpos.south().west(), pConfig);
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandom);
        int height = pFreeTreeHeight - pRandom.nextInt(4);
        int j = 2 - pRandom.nextInt(3);
        int k = pPos.getX();
        int l = pPos.getY();
        int i1 = pPos.getZ();
        int j1 = k;
        int k1 = i1;
        int l1 = l + pFreeTreeHeight - 1;

        for(int i2 = 0; i2 < pFreeTreeHeight; ++i2) {
            if (i2 >= height && j > 0) {
                j1 += direction.getStepX();
                k1 += direction.getStepZ();
                --j;
            }

            int j2 = l + i2;
            BlockPos blockpos1 = new BlockPos(j1, j2, k1);
            if (TreeFeature.isAirOrLeaves(pLevel, blockpos1)) {
                this.placeLog(pLevel, pBlockSetter, pRandom, blockpos, pConfig);
                this.placeLog(pLevel, pBlockSetter, pRandom, blockpos.north(), pConfig);
                this.placeLog(pLevel, pBlockSetter, pRandom, blockpos.east(), pConfig);
                this.placeLog(pLevel, pBlockSetter, pRandom, blockpos.south(), pConfig);
                this.placeLog(pLevel, pBlockSetter, pRandom, blockpos.west(), pConfig);
                this.placeLog(pLevel, pBlockSetter, pRandom, blockpos.north().east(), pConfig);
                this.placeLog(pLevel, pBlockSetter, pRandom, blockpos.north().west(), pConfig);
                this.placeLog(pLevel, pBlockSetter, pRandom, blockpos.south().east(), pConfig);
                this.placeLog(pLevel, pBlockSetter, pRandom, blockpos.south().west(), pConfig);
            }
        }

        list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(j1, l1, k1), 0, true));


        for(int l2 = -1; l2 <= 2; ++l2) {
            for(int i3 = -1; i3 <= 2; ++i3) {
                if ((l2 < 0 || l2 > 1 || i3 < 0 || i3 > 1) && pRandom.nextInt(3) <= 0) {
                    int j3 = pRandom.nextInt(3) + 2;

                    for(int k2 = 0; k2 < j3; ++k2) {
                        this.placeLog(pLevel, pBlockSetter, pRandom, new BlockPos(k + l2, l1 - k2 - 1, i1 + i3), pConfig);
                    }

                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(j1 + l2, l1, k1 + i3), 0, false));
                }
            }
        }

        return list;
    }
}
