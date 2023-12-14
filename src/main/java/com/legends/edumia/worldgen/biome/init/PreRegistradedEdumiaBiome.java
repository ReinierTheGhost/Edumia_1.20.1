package com.legends.edumia.worldgen.biome.init;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.biome.EdumiaBiomeBase;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullSupplier;

import java.util.function.Supplier;

public class PreRegistradedEdumiaBiome {
    private final String name;
    private final ResourceLocation fullRegistryName;
    private final LazyOptional<EdumiaBiomeBase> biomeWrapper;

    private boolean initialisedWrapper;

    public  PreRegistradedEdumiaBiome(String name, NonNullSupplier<EdumiaBiomeBase> biomeWrapperSupplier){
        this.name = name;
        this.fullRegistryName = new ResourceLocation(Edumia.MODID, name);
        this.biomeWrapper = LazyOptional.of(biomeWrapperSupplier);
        this.initialisedWrapper = false;
    }

    public String getName() {
        return this.name;
    }

    public ResourceLocation getRegistryName(){
        return this.fullRegistryName;
    }

    private EdumiaBiomeBase getOrCreateBiomeWrapper(){
        this.initialisedWrapper = true;
        return this.biomeWrapper.orElseThrow(() -> {
            return new IllegalStateException("Could not supply Edumia biome " + this.name);
        });
    }

    public EdumiaBiomeBase initialiseAndReturnBiomeWrapper(ResourceLocation biomeName) {
        if (this.initialisedWrapper)
            throw new IllegalStateException("LOTR biome " + this.name + " is already initialised!");
        return getOrCreateBiomeWrapper().setBiomeName(biomeName);
    }

    public EdumiaBiomeBase getInitialisedBiomeWrapper() {
        if (!this.initialisedWrapper)
            throw new IllegalStateException("LOTR biome " + this.name + " is not yet initialised!");
        return getOrCreateBiomeWrapper();
    }

//    public Supplier<Biome> supplyBiomeInitialiser() {
//        return () -> getInitialisedBiomeWrapper().initialiseActualBiome();
//    }

    public Biome getInitialisedBiome() {
        return getInitialisedBiomeWrapper().getActualBiome();
    }

    public Supplier<Biome> supplyInitialisedBiome() {
        return () -> getInitialisedBiome();
    }
}
