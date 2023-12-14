package com.legends.edumia.client.gui;

import com.legends.edumia.client.EdumiaKeyHandler;
import com.legends.edumia.datafix.ModButton;
import net.minecraft.network.chat.Component;

public abstract class EdumiaDimManuScreen extends BasicIngameScreen {
    public int xSize = 200;
    public int ySize = 256;
    public int guiLeft;
    public int guiTop;
    protected ModButton buttonManuReturn;

    public EdumiaDimManuScreen(Component titleIn) {
        super(titleIn);
    }

    @Override
    public void init() {
        super.init();
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        int buttonW = 100;
        int buttonH = 20;
        int buttonGap = 40;
//        this.buttonManuReturn = (ModButton) this.addRenderableWidget(new LeftRightButton(0, this.guiTop + ( this.ySize + buttonH) / 4, buttonW,
//                buttonH, true, Component.translatable("gui.edumia.menu.return"), (b) ->{
//            this.minecraft.setScreen(new EdumiaDimMasterMenuScreen());
//        }));
        this.buttonManuReturn.x = Math.max(0, this.guiLeft - buttonGap - buttonW);
    }

    @Override
    public boolean keyPressed(int key, int scan, int param3) {
        if (EdumiaKeyHandler.MENU_KEY.matches(key, scan)){
            this.minecraft.setScreen(new EdumiaDimMasterMenuScreen());
            return true;
        }else{
            return super.keyPressed(key, scan, param3);
        }
    }


}