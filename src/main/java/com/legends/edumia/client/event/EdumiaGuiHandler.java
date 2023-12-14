package com.legends.edumia.client.event;

import com.legends.edumia.config.EdumiaConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.gui.screens.inventory.ShulkerBoxScreen;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EdumiaGuiHandler {

    private final Minecraft MC;
    public EdumiaGuiHandler(Minecraft mc){
        this.MC = mc;
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onGuiOpen(ScreenEvent.Opening event){
//        EdumiaMenuScreen menuScreen;
//        Screen gui = event.getScreen();
//        if (((Boolean)EdumiaConfig.CLIENT.modMainMenu.get()).booleanValue()){
//            if (gui != null && gui.getClass() == TitleScreen.class){
//                menuScreen = new EdumiaMenuScreen();
//                event.setNewScreen((Screen) menuScreen);
//            }
//        }
    }
}
