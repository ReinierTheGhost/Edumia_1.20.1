package com.legends.edumia.client.gui;

import com.legends.edumia.Edumia;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class EdumiaDimScreen extends Screen {

    public static final ResourceLocation MENU_ICONS = new ResourceLocation(Edumia.MODID,"textures/gui/menu_icons.png");
    protected EdumiaDimScreen(Component p_96550_) {
        super(p_96550_);
    }
}
