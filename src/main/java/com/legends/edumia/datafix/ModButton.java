package com.legends.edumia.datafix;

import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

public class ModButton extends Button {
    public int x;
    public int y;
    protected static final Button.CreateNarration DEFAULT_NARRATION = (p_253298_) -> {
        return p_253298_.get();
    };
    public ModButton(int x, int y, int width, int height, Component text, OnPress p_260152_) {
        super(x, y, width, height, text, p_260152_, DEFAULT_NARRATION);
        this.x = x;
        this.y = y;
    }
}
