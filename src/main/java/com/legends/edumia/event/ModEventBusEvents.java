package com.legends.edumia.event;

import com.legends.edumia.Edumia;
import com.legends.edumia.client.models.entity.ModelAlligator;
import com.legends.edumia.client.models.entity.ModelBadger;
import com.legends.edumia.client.models.entity.ModelBoar;
import com.legends.edumia.client.models.entity.ModelRhino;
import com.legends.edumia.core.EntityLoader;
import com.legends.edumia.entity.animals.EntityAlligator;
import com.legends.edumia.entity.animals.EntityBadger;
import com.legends.edumia.entity.animals.EntityBoar;
import com.legends.edumia.entity.animals.EntityRhino;
import com.legends.edumia.entity.bosses.OniSamuraiBoss;
import com.legends.edumia.entity.layers.ModModelLayers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Edumia.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.RHINO_LAYER, ModelRhino::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BOAR_LAYER, ModelBoar::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ALLIGATOR_LAYER, ModelAlligator::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.BADGER_LAYER, ModelBadger::createBodyLayer);
    }
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        //event.put(EntityLoader.SAMURAI_BOSS.get(), OniSamuraiBoss.createAttributes().build());
        event.put(EntityLoader.RHINO.get(), EntityRhino.createAttributes().build());
        event.put(EntityLoader.BOAR.get(), EntityBoar.createAttributes().build());
        event.put(EntityLoader.ALLIGATOR.get(), EntityAlligator.createAttributes().build());
        event.put(EntityLoader.BADGER.get(), EntityBadger.createAttributes().build());
    }
}
