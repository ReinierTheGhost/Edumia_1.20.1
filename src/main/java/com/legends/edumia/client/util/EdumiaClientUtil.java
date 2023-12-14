package com.legends.edumia.client.util;

import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.util.FormattedCharSequence;

import java.util.List;
import java.util.stream.Collectors;

public class EdumiaClientUtil {

    public EdumiaClientUtil(){

    }

    public static List<? extends FormattedCharSequence> trimEachLineToWidth(List<FormattedText> lines, Font fr, int stringWidth){
        return (List)lines.stream().flatMap((line) -> {
            return fr.split(line, stringWidth).stream();
        }).collect(Collectors.toList());
    }

}
