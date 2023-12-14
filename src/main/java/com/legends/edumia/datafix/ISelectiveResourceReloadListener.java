package com.legends.edumia.datafix;

import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;

public interface ISelectiveResourceReloadListener extends ResourceManagerReloadListener {

    @Override
   default void onResourceManagerReload(ResourceManager resourceManager){
    }
}
