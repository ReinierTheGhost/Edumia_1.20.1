package com.legends.edumia.worldgen.tree.foliageplacers;

import com.legends.edumia.worldgen.tree.EdumiaFoliagePlacer;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelSimulatedRW;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Predicate;

public class AspenFoliagePlacer extends FoliagePlacer {
    public static final Codec<AspenFoliagePlacer> CODEC = RecordCodecBuilder.create((instance) -> foliagePlacerParts(instance)
            .and(IntProvider.codec(0, 24 ).fieldOf("trunk_height").forGetter(foliagePlacer ->
            foliagePlacer.trunkHeightSpread)).apply(instance, AspenFoliagePlacer::new));

    protected IntProvider trunkHeightSpread;
    public AspenFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider trunkHeightSpread) {
        super(radius, offset);
        this.trunkHeightSpread = trunkHeightSpread;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return EdumiaFoliagePlacer.ASPEN_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader world, FoliageSetter leaves, RandomSource rand, TreeConfiguration config,
                                 int p_225617_, FoliagePlacer.FoliageAttachment foliage, int foliageHeight, int foliageMaxWidth, int foliageOffset) {
        int leafTop = foliageOffset;
        int leafBottom = foliageOffset - foliageHeight;

        for(int y = foliageOffset; y >= leafBottom; --y){
            int baseLayerWidth = foliageMaxWidth;
            if (y >= leafTop -1){
                baseLayerWidth = foliageMaxWidth - 2;
            } else if (y >= leafTop -3 || y <= leafBottom +1 || rand.nextInt(4) ==0){
                baseLayerWidth = foliageMaxWidth -1;
            }

            int layerWidth = baseLayerWidth + foliage.radiusOffset();
            int branches = 4 + rand.nextInt(5);

            for (int b = 0; b <branches; ++b){
                BlockPos.MutableBlockPos movingPos = (new BlockPos.MutableBlockPos()).setWithOffset(foliage.pos(), 0, y, 0);
                int origX = movingPos.getX();
                int origZ = movingPos.getZ();
                int length = 4 + rand.nextInt(8);

                for (int l = 0; l < length && Math.abs(origX - movingPos.getX()) <= layerWidth && Math.abs(origZ - movingPos.getZ()) <= layerWidth; ++l){
                    this.doPlaceLeafBlock(world, rand, config, movingPos, leaves);
                    Direction randDir = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
                    movingPos.move(randDir);
                }
            }
        }

    }

    private void doPlaceLeafBlock(LevelSimulatedReader level, RandomSource rand, TreeConfiguration config, BlockPos.MutableBlockPos movingPos, FoliageSetter leaves) {

        if (TreeFeature.validTreePos(level, movingPos)){
            LevelSimulatedRW world = new LevelSimulatedRW() {
                @Override
                public boolean isStateAtPosition(BlockPos p_46938_, Predicate<BlockState> p_46939_) {
                    return false;
                }

                @Override
                public boolean isFluidAtPosition(BlockPos p_151584_, Predicate<FluidState> p_151585_) {
                    return false;
                }

                @Override
                public <T extends BlockEntity> Optional<T> getBlockEntity(BlockPos p_151582_, BlockEntityType<T> p_151583_) {
                    return Optional.empty();
                }

                @Override
                public BlockPos getHeightmapPos(Heightmap.Types p_46936_, BlockPos p_46937_) {
                    return null;
                }

                @Override
                public boolean setBlock(BlockPos p_46947_, BlockState p_46948_, int p_46949_, int p_46950_) {
                    return false;
                }

                @Override
                public boolean removeBlock(BlockPos p_46951_, boolean p_46952_) {
                    return false;
                }

                @Override
                public boolean destroyBlock(BlockPos p_46957_, boolean p_46958_, @Nullable Entity p_46959_, int p_46960_) {
                    return false;
                }
            };
            world.setBlock(movingPos, config.foliageProvider.getState(rand, movingPos), 19);
            leaves.isSet(movingPos.immutable());
        }
    }

    @Override
    public int foliageHeight(RandomSource rand, int trunkHeight, TreeConfiguration config) {
        return trunkHeightSpread.sample(rand);
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource rand, int absX, int layerY, int absZ, int layerWidth, boolean bool6) {
        if (absX + absZ >= 7) {
            return true;
        } else {
            return absX * absX + absZ * absZ > layerWidth * layerWidth;
        }
    }
}
