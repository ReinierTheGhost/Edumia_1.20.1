package com.legends.edumia.entity.animals.util.abstracts;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;

public abstract class EntityWaterMobPathingWithSelectiveTypes extends EntityWaterMobPathingWithTypes {
    public EntityWaterMobPathingWithSelectiveTypes(EntityType<? extends EntityWaterMobPathingWithSelectiveTypes> type, Level world) {
        super(type, world);
    }
}
