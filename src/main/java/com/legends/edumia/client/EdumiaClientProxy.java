package com.legends.edumia.client;

import com.legends.edumia.client.event.EdumiaGuiHandler;
import com.legends.edumia.common.EdumiaServerProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.List;
import java.util.stream.Collectors;

public class EdumiaClientProxy extends EdumiaServerProxy {
    private static final Minecraft MC = Minecraft.getInstance();
    public static final int MAX_LIGHTMAP = LightTexture.pack(15, 15);
    private EdumiaGuiHandler guiHandler;

    public EdumiaClientProxy(){

    }


    /**
     * to make the tooltip lines fit on the screen
     * @param lines
     * @param font
     * @param stringWidth
     * @return
     */
    public static List<? extends FormattedCharSequence> trimEachLineToWidth(List<FormattedText> lines, Font font, int stringWidth) {
        return lines.stream().flatMap((line) -> {
            return font.split(line, stringWidth).stream();
        }).collect(Collectors.toList());
    }

    @SubscribeEvent
    public void onClientSetup(FMLClientSetupEvent event){
        this.guiHandler = new EdumiaGuiHandler(MC);
    }

    public void mapHandleIsOp(boolean isOp){
        Screen screen = MC.screen;
//        if (screen instanceof EdumiaMapScreen){
//            ((EdumiaMapScreen) screen).receiveIsOp(isOp);
//        }
    }
}
