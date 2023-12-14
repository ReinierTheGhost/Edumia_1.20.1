package com.legends.edumia.core.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Context {

    private static final Map<ModContainer, Context> contexts = new ConcurrentHashMap();
    private String namespace = "";

    public Context() {
    }

    public static Context getInstance() {
        return getCurrentContext();
    }

    public synchronized String getNamespace() {
        return this.namespace;
    }

    public synchronized ResourceLocation newResourceLocation(String path) {
        return new ResourceLocation(this.namespace, path);
    }
    public synchronized void setNamespace(String namespace) {
        this.namespace = namespace;
    }
    private static Context getCurrentContext() {
        ModContainer current = ModLoadingContext.get().getActiveContainer();
        return (Context)contexts.computeIfAbsent(current, (k) -> {
            Context context = new Context();
            context.setNamespace(k.getNamespace());
            return context;
        });
    }
}
