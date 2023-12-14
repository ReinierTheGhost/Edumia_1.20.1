package com.legends.edumia.core.util;

public enum RenderLayer {
    UNDEFINED,
    SOLID,
    CUTOUT,
    CUTOUT_MIPPED,
    TRANSLUCENT;

    private RenderLayer() {
    }

    public boolean isDefault() {
        return this == UNDEFINED || this == SOLID;
    }

    public boolean isCutout() {
        return this == CUTOUT || this == CUTOUT_MIPPED;
    }
}
