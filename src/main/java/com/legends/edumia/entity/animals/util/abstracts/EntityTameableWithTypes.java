package com.legends.edumia.entity.animals.util.abstracts;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

public abstract class EntityTameableWithTypes extends EntityTameableEdumia{
    protected EntityTameableWithTypes(EntityType<? extends TamableAnimal> p_21803_, Level p_21804_) {
        super(p_21803_, p_21804_);
    }
}
