package com.legends.edumia.resources;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.metadata.MetadataSectionSerializer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.io.Closeable;
import java.io.InputStream;

public interface IResource extends Closeable {
    @OnlyIn(Dist.CLIENT)
    ResourceLocation getLocation();

    InputStream getInputStream();

    @Nullable
    @OnlyIn(Dist.CLIENT)
    <T> T getMetadata(MetadataSectionSerializer<T> p_199028_1_);

    String getSourceName();
}
