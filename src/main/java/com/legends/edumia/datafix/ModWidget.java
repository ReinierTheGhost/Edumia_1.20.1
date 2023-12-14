package com.legends.edumia.datafix;

import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;

public abstract class ModWidget extends AbstractWidget {

    protected int width;
    protected int height;
    public int x;
    public int y;
    public ModWidget(int x, int y, int width, int height, Component text) {
        super(x, y, width, height, text);
        this.x = x;
        this.y = y;

    }
}
