package com.legends.edumia.resources;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.FilePackResources;
import net.minecraft.server.packs.PackType;

import java.io.File;
import java.util.Locale;

public abstract class ModResourcePack extends FilePackResources {

    public final File file;
    public ModResourcePack(String p_256076_, File p_255707_, boolean p_256556_, File file) {
        super(p_256076_, p_255707_, p_256556_);
        this.file = file;
    }

    private static String getPathFromLocation(PackType p_250585_, ResourceLocation p_251470_) {
        return String.format(Locale.ROOT, "%s/%s/%s", p_250585_.getDirectory(), p_251470_.getNamespace(), p_251470_.getPath());
    }

    public boolean hasResource(PackType type, ResourceLocation location){
        return this.hasResource(getPathFromLocation(type, location));
    }

    protected abstract boolean hasResource(String string);
}
