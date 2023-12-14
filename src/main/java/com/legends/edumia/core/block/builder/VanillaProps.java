package com.legends.edumia.core.block.builder;

import net.minecraft.world.level.block.Blocks;

public class VanillaProps {

    public VanillaProps() {
    }

    public static Props stone() {
        return (Props) Props.create(Blocks.STONE);
    }
}
