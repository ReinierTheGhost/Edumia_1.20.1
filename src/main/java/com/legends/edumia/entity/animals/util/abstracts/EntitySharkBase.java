package com.legends.edumia.entity.animals.util.abstracts;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public abstract class EntitySharkBase extends EntityWaterMobPathingWithSelectiveTypes {
    public EntitySharkBase(EntityType<? extends EntityWaterMobPathingWithSelectiveTypes> type, Level world) {
        super(type, world);
    }
}
