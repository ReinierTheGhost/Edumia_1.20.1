package com.legends.edumia.datafix;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;

import java.io.IOException;

public interface ModPackResources extends net.minecraft.server.packs.PackResources {

    boolean hasResource(PackType type, ResourceLocation resourceLocation);
}
