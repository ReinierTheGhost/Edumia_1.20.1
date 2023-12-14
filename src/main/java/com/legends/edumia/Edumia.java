package com.legends.edumia;

import com.legends.edumia.client.EdumiaClientProxy;
import com.legends.edumia.client.models.renderer.RendererAligator;
import com.legends.edumia.client.models.renderer.RendererBadger;
import com.legends.edumia.client.models.renderer.RendererBoar;
import com.legends.edumia.client.models.renderer.RendererRhino;
import com.legends.edumia.common.EdumiaProxy;
import com.legends.edumia.common.EdumiaServerProxy;
import com.legends.edumia.config.EdumiaConfig;
import com.legends.edumia.core.*;

import com.legends.edumia.worldgen.biome.EdumiaBiomes;
import com.legends.edumia.worldgen.biome.EdumiaBiomesData;
import com.legends.edumia.worldgen.dimension.EdumiaDimensions;
import com.legends.edumia.worldgen.gen.map.MapImageLoader;
import com.legends.edumia.worldgen.tree.EdumiaFoliagePlacer;
import com.mojang.logging.LogUtils;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.IoSupplier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.resource.PathPackResources;
import net.minecraftforge.resource.ResourcePackLoader;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.NoSuchElementException;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Edumia.MODID)
public class Edumia
{

    public static final String MINECRAFT = "minecraft";
    // Define mod id in a common place for everything to reference
    public static final String MODID = "edumia";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final int MAP_ITERATION = 3; //3.74f;
    public static final EdumiaProxy PROXY = (EdumiaProxy) DistExecutor.safeRunForDist(() -> {
        return EdumiaClientProxy::new;
    }, () -> {
        return EdumiaServerProxy::new;
    });



    public Edumia()
    {
        EdumiaLog.find();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        ItemLoader.register(eventBus);
        BlockLoader.register(eventBus);
        EntityLoader.register(eventBus);
        CreativeTabLoader.register(eventBus);

        //eventBus.register(PROXY);
        //forgeBus.register(PROXY);
        EdumiaConfig.register(eventBus);

        ModTrunkPlacerType.register(eventBus);
        EdumiaFoliagePlacer.register(eventBus);



//        EdumiaDimensions.register();
//        EdumiaBiomes.registerModBiomes();
//        EdumiaBiomesData.loadBiomes();

//        try {
//            MapImageLoader.loadImage(getClass().getClassLoader());
//        } catch (IOException | URISyntaxException e) {
//            throw new RuntimeException(e);
//        }

        eventBus.addListener(this::setup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation location(String path) {
        return  new ResourceLocation(Edumia.MODID, path);
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            event.enqueueWork(() -> {

                EntityRenderers.register(EntityLoader.RHINO.get(), RendererRhino::new);
                EntityRenderers.register(EntityLoader.BOAR.get(), RendererBoar::new);
                EntityRenderers.register(EntityLoader.ALLIGATOR.get(), RendererAligator::new);
                EntityRenderers.register(EntityLoader.BADGER.get(), RendererBadger::new);
            });
        }
    }


    private void setup(final FMLCommonSetupEvent event)
    {

    }

    public static IoSupplier<InputStream> getModResourceStream(PackType type, ResourceLocation res){
        try{
            PathPackResources edumiaAsPack = ResourcePackLoader.getPackFor(Edumia.MODID).get();
            return edumiaAsPack.getResource(type, res);
        } catch (NoSuchElementException var3) {
            EdumiaLog.error("Error loading mod resource - resource does not exist!");
            var3.printStackTrace();
            return null;
        }
    }

    public static IoSupplier<InputStream> getDefaultDatapackResaurceStream(PackType type, ResourceLocation res){
        try{
            PathPackResources edumiaAsPack = (PathPackResources) ResourcePackLoader.getPackFor(Edumia.MODID).get();
            return edumiaAsPack.getResource(type, res);
        }catch (NoSuchElementException var3){
            EdumiaLog.error("Error loading mod resource - resource does not exist!");
            var3.printStackTrace();
            return null;
        }
    }



    public enum DestroyMode {
        IGNORE,
        SLOPPY,
        SET_RADIUS,
        HARVEST,
        ROT,
        OVERFLOW
    }

    public static enum AxeDamage{
        VANILLA,
        THICKNESS,
        VOLUME;
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
    }

    public static ResourceLocation suffix(String name) {
        return new ResourceLocation("minecraft", name.toLowerCase(Locale.ROOT));
    }

}
