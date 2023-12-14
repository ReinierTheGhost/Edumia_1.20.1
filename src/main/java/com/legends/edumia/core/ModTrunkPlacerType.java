package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.tree.trunkplacer.BigTreeTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTrunkPlacerType {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, Edumia.MODID);

    public static final RegistryObject<TrunkPlacerType<BigTreeTrunkPlacer>> BIG_TREE_PLACER =
            TRUNK_PLACERS.register("big_tree_placer", () ->
                    new TrunkPlacerType<>(BigTreeTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus){
        TRUNK_PLACERS.register(eventBus);
    }
}
