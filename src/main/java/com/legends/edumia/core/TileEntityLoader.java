package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;



public class TileEntityLoader {
    public static final DeferredRegister<EntityType<?>> DEFERRED_REGISTER =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Edumia.MODID);

}
