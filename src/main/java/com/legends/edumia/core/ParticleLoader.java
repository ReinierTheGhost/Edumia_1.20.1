package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ParticleLoader {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Edumia.MODID);

    public static final RegistryObject<SimpleParticleType> MAGIC_PARTICLES =
            PARTICLE_TYPES.register("magic_particles", () -> new SimpleParticleType(true));


    public static final RegistryObject<SimpleParticleType> SNOW_MAGIC_PARTICLES =
            PARTICLE_TYPES.register("snow_magic_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
