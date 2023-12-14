package com.legends.edumia.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class EdumiaStoneBlock extends Block {
    public EdumiaStoneBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public EdumiaStoneBlock() {
        this( 1.5F, 6.0F);
    }

    public EdumiaStoneBlock(float hard, float res) {
        this(Properties.of().requiresCorrectToolForDrops().strength(hard, res));
    }

    public EdumiaStoneBlock(int light) {
        this(Properties.of().requiresCorrectToolForDrops().strength(1.5F, 6.0F).lightLevel(EdumiaBlocks.constantLight(light)));
    }

    public EdumiaStoneBlock(Supplier<Block> blockSup) {
        this(Properties.copy((BlockBehaviour) blockSup.get()));
    }
}
