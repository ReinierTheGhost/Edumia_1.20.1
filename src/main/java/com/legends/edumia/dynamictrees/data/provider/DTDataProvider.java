package com.legends.edumia.dynamictrees.data.provider;

import net.minecraft.resources.ResourceLocation;

import static com.legends.edumia.dynamictrees.util.ResourceLocationUtils.prefix;

public interface DTDataProvider {

    default ResourceLocation block(ResourceLocation blockLocation) {
        return prefix(blockLocation, "block/");
    }

    default ResourceLocation item(ResourceLocation resourceLocation) {
        return prefix(resourceLocation, "item/");
    }
}
