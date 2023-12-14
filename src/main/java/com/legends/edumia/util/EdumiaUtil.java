package com.legends.edumia.util;

public class EdumiaUtil {

    public static String toPaddedHexString(int rgb) {
        return String.format("%1$06X", rgb);
    }
}
