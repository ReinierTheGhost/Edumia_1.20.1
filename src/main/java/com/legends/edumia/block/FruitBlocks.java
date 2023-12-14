package com.legends.edumia.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class FruitBlocks extends Block implements BonemealableBlock {
    private String name;
    public static final IntegerProperty AGE;
    public static boolean canSurvive;

    public FruitBlocks(BlockBehaviour.Properties properties, String name) {
        super(properties);
        this.name = name;
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.getStateDefinition().any()).setValue(this.getAgeProperty(), 0)).setValue(BlockStateProperties.WATERLOGGED, false));
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 7;
    }

    protected int getAge(BlockState state) {
        return (Integer)state.getValue(this.getAgeProperty());
    }

    public BlockState withAge(int age) {
        return (BlockState)this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }

    public boolean isMaxAge(BlockState state) {
        return (Integer)state.getValue(this.getAgeProperty()) >= this.getMaxAge();
    }

    public boolean isRandomlyTicking(BlockState pState) {
        return super.isRandomlyTicking(pState) || (Integer)pState.getValue(AGE) != 7;
    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pState.canSurvive(pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        }

        super.tick(pState, pLevel, pPos, pRandom);
        int i = (Integer)pState.getValue(AGE);
        if (i < 7 && pRandom.nextInt(5) == 0 && pLevel.getRawBrightness(pPos.above(), 0) >= 9) {
            pLevel.setBlock(pPos, (BlockState)pState.setValue(AGE, i + 1), 2);
        }

    }

    public boolean canSurvive(BlockState state, LevelReader pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos.above());
        return blockstate.getBlock() instanceof LeavesBlock;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AGE, BlockStateProperties.WATERLOGGED});
    }

    public boolean isValidBonemealTarget(LevelReader pLevel, BlockPos pPos, BlockState pState, boolean pIsClient) {
        return (Integer)pState.getValue(AGE) < 7;
    }

    public boolean isBonemealSuccess(Level pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        return true;
    }

    public void performBonemeal(ServerLevel pLevel, RandomSource pRandom, BlockPos pPos, BlockState pState) {
        int i = this.getAge(pState) + this.getBonemealAgeIncrease(pLevel);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        pLevel.setBlock(pPos, this.withAge(i), 2);
    }

    protected int getBonemealAgeIncrease(Level worldIn) {
        return Mth.nextInt(worldIn.random, 2, 5);
    }

    static {
        AGE = BlockStateProperties.AGE_7;
        canSurvive = true;
    }
}
