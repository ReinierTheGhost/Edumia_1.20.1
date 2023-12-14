package com.legends.edumia.core.asset.pack;

import com.legends.edumia.core.asset.VirtualResource;
import com.legends.edumia.core.asset.meta.VirtualMeta;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.ResourceManager;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VirtualResourcepack {

    private final ResourceManager resourceManager;
    private final Map<String, VirtualResource> resources;

    private VirtualResourcepack(PackType type, ResourceManager resourceManager, String name, Map<String, VirtualResource> resources) {
        super();
        this.resources = resources;
        this.resourceManager = resourceManager;
        PackFinder.getInstance(type).register(this);
    }

    public static class Builder {
        private final String namespace;
        private final List<VirtualResource> resources = new LinkedList();
        private PackType type;

        private Builder(String namespace) {
            this.type = PackType.CLIENT_RESOURCES;
            this.namespace = namespace;
        }

        public Builder type(PackType type) {
            this.type = type;
            return this;
        }

        public Builder add(VirtualResource resource) {
            this.resources.add(resource);
            return this;
        }

        public VirtualResourcepack build(ResourceManager resourceManager) {
            Map<String, VirtualResource> map = new HashMap();
            map.put("pack.mcmeta", new VirtualMeta(this.namespace, this.namespace));
            this.resources.forEach((r) -> {
                map.put(r.getPath(), r);
            });
            String suffix = this.type == PackType.CLIENT_RESOURCES ? "_resources" : "_data";
            return new VirtualResourcepack(this.type, resourceManager, this.namespace + suffix, map);
        }
    }
}
