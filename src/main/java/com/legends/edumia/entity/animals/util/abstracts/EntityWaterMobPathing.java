package com.legends.edumia.entity.animals.util.abstracts;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;

public abstract class EntityWaterMobPathing extends WaterAnimal {
    protected EntityWaterMobPathing(EntityType<? extends WaterAnimal> p_30341_, Level p_30342_) {
        super(p_30341_, p_30342_);
    }
}
