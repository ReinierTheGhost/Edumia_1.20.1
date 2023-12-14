package com.legends.edumia.resources;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DataDirectorySettings {

    public static final String SETTINGS_FILENAME = "_settings.json";
    private final Set<String> removeNamespaces;
    private final Set<ResourceLocation> removeResources;

    private DataDirectorySettings(Set<String> removeNamespaces, Set<ResourceLocation> removeResources) {
        this.removeNamespaces = removeNamespaces;
        this.removeResources = removeResources;
        this.validate();
    }

    private void validate() {
        this.removeNamespaces.forEach((namespace) -> {
            if (ResourceLocation.tryParse(namespace + ":test_resource_path") == null) {
                throw new IllegalArgumentException("Invalid namespace declaration: " + namespace);
            }
        });
    }

    public static DataDirectorySettings read(ResourceLocation resourceName, JsonObject json) {
        Set<String> removeNamespaces = new HashSet();
        JsonArray removeNamespacesArray = json.get("remove_namespaces").getAsJsonArray();
        Iterator var4 = removeNamespacesArray.iterator();

        while(var4.hasNext()) {
            JsonElement namespace = (JsonElement)var4.next();
            removeNamespaces.add(namespace.getAsString());
        }

        Set<ResourceLocation> removeResources = new HashSet();
        JsonArray removeResourcesArray = json.get("remove_singles").getAsJsonArray();
        Iterator var6 = removeResourcesArray.iterator();

        while(var6.hasNext()) {
            JsonElement resource = (JsonElement)var6.next();
            removeResources.add(new ResourceLocation(resource.getAsString()));
        }

        return new DataDirectorySettings(removeNamespaces, removeResources);
    }

    public boolean shouldExclude(ResourceLocation resource) {
        return this.removeNamespaces.contains(resource.getNamespace()) || this.removeResources
                .contains(resource);
    }
}
