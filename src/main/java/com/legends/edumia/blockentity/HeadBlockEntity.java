package com.legends.edumia.blockentity;

import com.legends.edumia.entity.util.variant.IVariant;
import com.legends.edumia.util.HeadType;
import net.minecraft.core.BlockPos;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class HeadBlockEntity extends BlockEntity {
    public static final LazyLoadedValue<BlockEntityType<HeadBlockEntity>> HEAD_TYPE
            = new LazyLoadedValue(() -> BlockEntityType.Builder.of(HeadBlockEntity::new,
            HeadType.getAllBlocks()).build(null));
    private HeadType cachedType = null;
    private IVariant cachedVariant = null;

    public HeadBlockEntity(HeadType type, BlockPos pos, BlockState state) {
        super(HEAD_TYPE.get(), pos, state);
        this.cachedType = type;
    }

    public HeadBlockEntity(BlockPos pos, BlockState state) {
        super(HEAD_TYPE.get(), pos, state);
    }
}
