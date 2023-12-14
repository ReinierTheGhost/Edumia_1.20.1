package com.legends.edumia.client.gui.widget.button;

import com.legends.edumia.EdumiaLog;
import com.legends.edumia.client.gui.EdumiaDimManuScreen;
import com.legends.edumia.client.gui.EdumiaDimMasterMenuScreen;
import com.legends.edumia.init.EdumiaWorldTypes;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;


public class EdumiaDimMenuButton extends Button {
   public static final Button.CreateNarration DEFAULT_NARRATION = (p_253298_) -> {
       return p_253298_.get();
    };

   private final Class<? extends EdumiaDimManuScreen> menuScreenClass;
    private final int verticalIconNumber;
   public final int menuKeyCode;
    public EdumiaDimMenuButton(int xIn, int yIn, Class<? extends EdumiaDimManuScreen> cls, Component text, int vertNumber, int key,
                               Button.CreateNarration narration) {
        super(xIn, yIn, 32, 32, text, (button) ->{
            ((EdumiaDimMenuButton) button).openMenuScreen();
        }, narration);
        this.menuScreenClass = cls;
        this.verticalIconNumber = vertNumber;
        this.menuKeyCode = key;
    }


    public void openMenuScreen(){
        if (this.menuScreenClass != null && this.canDisplayMenu()){
            try {
                EdumiaDimManuScreen screen = (EdumiaDimManuScreen) this.menuScreenClass.newInstance();
                Minecraft.getInstance().setScreen(screen);
                EdumiaDimMasterMenuScreen.lastMenuScreen = screen.getClass();
            }catch (Exception var2){
                EdumiaLog.error("Error opening menu button screen");
                var2.printStackTrace();
            }
        }

    }

    public boolean canDisplayMenu() {
        return false;
        //return this.menuScreenClass == EdumiaMapScreen.class ? EdumiaWorldTypes.hasMapFeaturesClientside() : true;
    }

    @Override
    public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float f) {
        Minecraft minecraft = Minecraft.getInstance();
        Font fr = minecraft.font;
        RenderSystem.clearColor(1.0f, 1.0f, 1.0f, this.alpha);
        guiGraphics.blit(EdumiaDimMasterMenuScreen.MENU_ICONS, this.x, this.y,
                (this.active ? 0 : this.width * 2) + (this.isHovered() ? this.width : 0),
                this.verticalIconNumber * this.height, this.width, this.height);
    }


}
