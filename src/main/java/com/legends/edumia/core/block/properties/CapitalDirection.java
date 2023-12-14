package com.legends.edumia.core.block.properties;

import net.minecraft.util.StringRepresentable;

public enum CapitalDirection implements StringRepresentable {
    FLAT("flat"),
    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west");

    private final String name;

    private CapitalDirection(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}
