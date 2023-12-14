package com.legends.edumia.util;

import com.legends.edumia.Edumia;
import com.legends.edumia.entity.EntityTypeContainer;
import com.legends.edumia.entity.animals.util.EntityTypeContainerEdumiaTameable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.function.Function;
import java.util.function.Supplier;

public class EntityRegistrarHandlerEdumia extends EntityRegistrarHandler{
    public EntityRegistrarHandlerEdumia() {
        super(Edumia.MODID);
    }
}
