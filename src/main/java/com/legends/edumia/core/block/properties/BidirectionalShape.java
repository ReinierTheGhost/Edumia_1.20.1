package com.legends.edumia.core.block.properties;

import net.minecraft.util.StringRepresentable;

public enum BidirectionalShape implements StringRepresentable {
    NORTH_SOUTH("northsouth"),
    EAST_WEST("eastwest");

    private final String name;

    private BidirectionalShape(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}
