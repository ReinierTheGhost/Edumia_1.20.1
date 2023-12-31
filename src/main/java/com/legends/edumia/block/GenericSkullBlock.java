package com.legends.edumia.block;

import com.legends.edumia.util.HeadType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class GenericSkullBlock extends AnimalSkullBlock implements EntityBlock {

    public final HeadType type;
    public final String id;

    public GenericSkullBlock(HeadType type, String id) {
        this.type = type;
        this.id = id;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return type.createTE(pos, state);
    }
}
