package com.legends.edumia.datafix;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModExplosion extends Explosion {
    public final float radius;
    public ModExplosion(Level p_46024_, @Nullable Entity p_46025_, double p_46026_, double p_46027_, double p_46028_, float radius, List<BlockPos> p_46030_) {
        super(p_46024_, p_46025_, p_46026_, p_46027_, p_46028_, radius, p_46030_);
        this.radius = radius;
    }
}
