package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.config.EdumiaConfig;
import com.legends.edumia.entity.animals.EntityAlligator;
import com.legends.edumia.entity.animals.EntityBadger;
import com.legends.edumia.entity.animals.EntityBoar;
import com.legends.edumia.entity.animals.EntityRhino;
import com.legends.edumia.entity.bosses.OniSamuraiBoss;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityLoader {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Edumia.MODID);


    public static final RegistryObject<EntityType<EntityRhino>> RHINO =
            ENTITY_TYPES.register("rhino", () -> EntityType.Builder.of
                            (EntityRhino::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("rhino"));

    public static final RegistryObject<EntityType<EntityBoar>> BOAR =
            ENTITY_TYPES.register("boar", () -> EntityType.Builder.of
                            (EntityBoar::new, MobCategory.CREATURE)
                    .sized(1.0f, 1.0f).build("boar"));
    public static final RegistryObject<EntityType<EntityAlligator>> ALLIGATOR =
            ENTITY_TYPES.register("alligator", () -> EntityType.Builder.of
                            (EntityAlligator::new, MobCategory.CREATURE)
                    .sized(1.8f, 0.8f).build("alligator"));
    public static final RegistryObject<EntityType<EntityBadger>> BADGER =
            ENTITY_TYPES.register("badger", () -> EntityType.Builder.of
                            (EntityBadger::new, MobCategory.CREATURE)
                    .sized(1.8f, 0.8f).build("badger"));



    //public static final RegistryObject<EntityType<OniSamuraiBoss>> SAMURAI_BOSS = ENTITY_TYPES.register("samurai_boss", () -> EntityType.Builder.of(OniSamuraiBoss::new, MobCategory.MONSTER).sized(1.0f, 4.0f).build("samurai_boss"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
