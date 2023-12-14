package com.legends.edumia.datafix;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class ModResourceLocation extends ResourceLocation {
    protected ModResourceLocation(String p_248791_, String p_249394_, @Nullable ResourceLocation.Dummy p_249089_) {
        super(p_248791_, p_249394_, p_249089_);
    }

    public static String[] decompose(String p_135833_, char p_135834_) {
        String[] astring = new String[]{"minecraft", p_135833_};
        int i = p_135833_.indexOf(p_135834_);
        if (i >= 0) {
            astring[1] = p_135833_.substring(i + 1);
            if (i >= 1) {
                astring[0] = p_135833_.substring(0, i);
            }
        }

        return astring;
    }
}
