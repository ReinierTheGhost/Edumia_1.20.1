package com.legends.edumia.event;

import com.legends.edumia.client.EdumiaKeyBindings;
import com.legends.edumia.Edumia;
import com.legends.edumia.client.EdumiaKeyHandler;
import com.legends.edumia.client.gui.EdumiaDimMasterMenuScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModClientEvent {
    @Mod.EventBusSubscriber(modid = Edumia.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            int key = event.getKey();
            int scancode = event.getScanCode();
            int action = event.getAction();
            Minecraft mc = Minecraft.getInstance();
            if(EdumiaKeyHandler.MAP_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Open Map!!"));
            }
            if (EdumiaKeyHandler.MENU_KEY.matches(key, scancode) && mc.screen == null && mc.player != null){
                Screen menuScreen = EdumiaDimMasterMenuScreen.openMenu(mc.player);
                if (menuScreen != null){
                    mc.setScreen(menuScreen);
                }
            }
        }
    }
    @Mod.EventBusSubscriber(modid = Edumia.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(EdumiaKeyHandler.MAP_KEY);
            event.register(EdumiaKeyHandler.MENU_KEY);
        }
    }
}
