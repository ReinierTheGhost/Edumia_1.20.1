package com.legends.edumia.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class EdumiaKeyBindings {

    public static final String KEY_CATEGORY_EDUMIA ="key.categories.mod.%s";
    public static final String KEY_MAP = "key.edumia.key_map";

    public static final KeyMapping MAP_KEY = new KeyMapping(KEY_MAP, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_M, KEY_CATEGORY_EDUMIA);
}
