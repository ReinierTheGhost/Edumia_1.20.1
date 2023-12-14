package com.legends.edumia.client.gui;

import net.minecraft.client.gui.Font;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class GuiBiblioTextField {

    private final Font fontRenderer;
    private final int xPos;
    private final int yPos;

    /** The width of this text field. */
    private final int width;
    private final int height;

    /** Have the current text beign edited on the textbox. */
    private String text = "";
    private int maxStringLength = 32;
    private int cursorCounter;
    private boolean enableBackgroundDrawing = true;

    /**
     * if true the textbox can lose focus by clicking elsewhere on the screen
     */
    private boolean canLoseFocus = true;

    /**
     * If this value is true along isEnabled, keyTyped will process the keys.
     */
    private boolean isFocused;

    /**
     * If this value is true along isFocused, keyTyped will process the keys.
     */
    private boolean isEnabled = true;

    /**
     * The current character index that should be used as start of the rendered text.
     */
    private int lineScrollOffset;
    private int cursorPosition;

    /** other selection position, maybe the same as the cursor */
    private int selectionEnd;
    private int enabledColor = 14737632;
    private int disabledColor = 7368816;

    /** True if this textbox is visible */
    private boolean visible = true;

    @OnlyIn(Dist.CLIENT)
    public GuiBiblioTextField(Font par1FontRenderer, int par2, int par3, int par4, int par5)
    {
        this.fontRenderer = par1FontRenderer;
        this.xPos = par2;
        this.yPos = par3;
        this.width = par4;
        this.height = par5;
    }

    /**
     * Returns the text beign edited on the textbox.
     */
    public String getText()
    {
        return this.text;
    }
}
