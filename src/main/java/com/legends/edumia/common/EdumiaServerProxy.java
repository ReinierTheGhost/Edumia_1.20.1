package com.legends.edumia.common;

public class EdumiaServerProxy implements EdumiaProxy{
    @Override
    public boolean isClient() {
        return false;
    }
}
