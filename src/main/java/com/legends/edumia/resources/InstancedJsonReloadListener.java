package com.legends.edumia.resources;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.legends.edumia.Edumia;
import com.legends.edumia.EdumiaLog;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.resources.IoSupplier;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.resource.ResourcePackLoader;
import org.apache.commons.lang3.tuple.Pair;


public abstract class InstancedJsonReloadListener extends SimpleJsonResourceReloadListener {
    protected static final Gson GSON = (new GsonBuilder()).setPrettyPrinting()
            .disableHtmlEscaping().create();
    protected static final String JSON_EXTENSION = ".json";
    private final String rootFolder;
    protected final String loaderNameForLogging;
    protected final LogicalSide side;

    public InstancedJsonReloadListener(String folder, String name, LogicalSide side) {
        super(GSON, folder);
        this.rootFolder = folder;
        this.loaderNameForLogging = name;
        this.side = side;
    }


    public final LogicalSide getSide() {
        return this.side;
    }

    protected JsonObject loadDataJsonIfExists(Map<ResourceLocation, JsonElement> jsons, ResourceLocation targetPath) {
        Optional<Map.Entry<ResourceLocation, JsonElement>> optEntry = jsons.entrySet().stream().filter(entry -> {
            ResourceLocation shortenedPath = (ResourceLocation)entry.getKey();
            return getPreparedPath(shortenedPath).equals(targetPath);
        }).findFirst();
        if (optEntry.isPresent())
            return ((JsonElement)((Map.Entry)optEntry.get()).getValue()).getAsJsonObject();
        EdumiaLog.error("%s datapack load missing %s", new Object[] { this.loaderNameForLogging, targetPath });
        return null;
    }


    protected Map<ResourceLocation, JsonObject> filterDataJsonsBySubFolder(Map<ResourceLocation,
            JsonElement> jsons, String subFolder) {
        Map<ResourceLocation, JsonObject> rootJsons = jsons.entrySet().stream().filter(e -> {
            ResourceLocation res = (ResourceLocation)e.getKey();
            String resPath = res.getPath();
            return (resPath.startsWith(subFolder) && !resPath.substring(subFolder.length()).contains("/"));
        }).collect(jsonElemToObjMapCollector());
        extractAndApplyDataDirectorySettings(rootJsons, subFolder);
        return rootJsons;
    }
    protected Map<ResourceLocation, JsonObject> filterDataJsonsByRootFolderOnly(Map<ResourceLocation, JsonElement> jsons) {
        Map<ResourceLocation, JsonObject> subJsons = jsons.entrySet().stream().filter(e -> {
            ResourceLocation res = (ResourceLocation)e.getKey();
            return !res.getPath().contains("/");
        }).collect(jsonElemToObjMapCollector());
        extractAndApplyDataDirectorySettings(subJsons, (String)null);
        return subJsons;
    }

    private void extractAndApplyDataDirectorySettings(Map<ResourceLocation, JsonObject>
                                                              jsons, String subFolder) {
        Map.Entry<ResourceLocation, JsonObject> settingsEntry =
                this.extractDataDirectorySettingsJson(jsons, subFolder);
        if (settingsEntry != null) {
            ResourceLocation settingsRes = (ResourceLocation)settingsEntry.getKey();
            JsonObject settingsJson = (JsonObject)settingsEntry.getValue();
            DataDirectorySettings settings = DataDirectorySettings.read(settingsRes, settingsJson);
            this.removeResourcesExcludedInSettings(jsons, subFolder, settings);
        }

    }

    private Map.Entry<ResourceLocation, JsonObject> extractDataDirectorySettingsJson
            (Map<ResourceLocation, JsonObject> jsons, String subFolder) {
        Optional<ResourceLocation> settingsResOpt = jsons.keySet().stream().filter((res) -> {
            return this.getPreparedPath(res).getPath().endsWith("/_settings.json");
        }).findFirst();
        if (settingsResOpt.isPresent()) {
            ResourceLocation settingsRes = (ResourceLocation)settingsResOpt.get();
            JsonObject settingsJson = (JsonObject)jsons.remove(settingsRes);
            return Pair.of(settingsRes, settingsJson);
        } else {
            return null;
        }
    }

    private void removeResourcesExcludedInSettings(Map<ResourceLocation,
            JsonObject> jsons, String subFolder, DataDirectorySettings settings) {
        int sizeBefore = jsons.size();
        Set<ResourceLocation> toRemove = new HashSet<>();
        for (ResourceLocation res : jsons.keySet()) {
            if (settings.shouldExclude(trimSubFolderResource(res, subFolder)))
                toRemove.add(res);
        }
        toRemove.forEach(jsons::remove);
        int numRemoved = sizeBefore - jsons.size();
        EdumiaLog.info("Excluded %d resources in folder '%s' based on the %s", new Object[] { Integer.valueOf(numRemoved),
                getFullFolderName(subFolder), "_settings.json" });
    }

    protected static ResourceLocation trimSubFolderResource(ResourceLocation res,
                                                            String subFolder) {
        return subFolder == null ? res : new ResourceLocation(res.getNamespace(),
                res.getPath().substring(subFolder.length()));
    }

   /* protected Map<ResourceLocation, List<JsonObject>> loadJsonResourceVersionsFromAllDatapacks
            (Set<ResourceLocation> jsonPaths, ResourceManager resMgr) {
        return (Map)jsonPaths.stream().collect(Collectors.toMap((res) -> {
            return res;
        }, (res) -> {
            ResourceLocation fullRes = this.getPreparedPath(res);

            try {
                return (List)resMgr.getResourceStack(fullRes).stream().map(Resource::getInputStream)
                        .map((is) -> {
                    Reader reader = new BufferedReader(new InputStreamReader
                            (is, StandardCharsets.UTF_8));
                    JsonElement json = (JsonElement)GsonHelper.fromJson(GSON, reader,
                            JsonElement.class);
                    return json.getAsJsonObject();
                }).collect(Collectors.toList());
            } catch (Exception var5) {
                EdumiaLog.error("Couldn't parse datapack variant file %s from %s",
                        new Object[]{res, fullRes});
                var5.printStackTrace();
                return ImmutableList.of();
            }
        }));
    }

    protected Map<ResourceLocation, List<JsonObject>> asMapOfSingletonLists(Map<ResourceLocation, JsonObject> map) {
        return (Map)map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, (e) -> {
            return ImmutableList.of(e.getValue());
        }));
    }*/

    private String getFullFolderName(String subFolder) {
        return this.rootFolder + (subFolder == null ? "" : "/" + subFolder);
    }

    protected static <K, V> Collector<Map.Entry<K, V>, ?, Map<K, V>> toMapCollector() {
        return Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue);
    }

    protected static Collector<Map.Entry<ResourceLocation, JsonElement>, ?, Map<ResourceLocation,
            JsonObject>> jsonElemToObjMapCollector() {
        return Collectors.toMap(Map.Entry::getKey, (e) -> {
            return ((JsonElement)e.getValue()).getAsJsonObject();
        });
    }

    protected JsonObject loadDefaultJson(ResourceLocation res) {
        try (Reader reader = new BufferedReader(new InputStreamReader((InputStream) getDefaultDatapackResourceStream(res), StandardCharsets.UTF_8))) {
            return (JsonObject)GsonHelper.fromJson(GSON, reader, JsonObject.class);
        } catch (Exception e) {
            EdumiaLog.warn("Failed to parse %s json resource: %s", new Object[] { this.loaderNameForLogging, res });
            e.printStackTrace();
            return null;
        }
    }

    private static IoSupplier<InputStream> getDefaultDatapackResourceStream(ResourceLocation res){
        return Edumia.getDefaultDatapackResaurceStream(PackType.SERVER_DATA, res);
    }


    protected Map<ResourceLocation, JsonObject> loadDefaultJsonsInSubFolder(String subFolder, int maxDepth) {
        String fullFolder = String.format("%s/%s", this.rootFolder, subFolder);
        Collection<ResourceLocation> resources = getDefaultDatapackResourcesInFolder(fullFolder, maxDepth, (s) -> {
            return s.endsWith(".json");
        });
        Map<ResourceLocation, JsonObject> jsons = (Map) resources.stream().collect(Collectors.toMap((res) -> {
            String resPath = res.getPath();
            return new ResourceLocation(res.getNamespace(), resPath.substring((this.rootFolder + "/").length(), resPath.indexOf(".json")));
        }, this::loadDefaultJson));
        this.extractDataDirectorySettingsJson(jsons, subFolder);
        return jsons;
    }

    private static Collection<ResourceLocation> getDefaultDatapackResourcesInFolder(String path, int maxDepth, Predicate<String> filter) {
        String namespace = Edumia.MODID;
        ModFileResourcePack edumiaAsPack = (ModFileResourcePack) ResourcePackLoader.getPackFor(namespace).get();
        return edumiaAsPack.listResources(PackType.SERVER_DATA, namespace, path, maxDepth, filter);
    }


    protected Map<ResourceLocation, JsonObject> loadDefaultJsonsInSubFolder(Map<ResourceLocation, JsonElement> jsons, String subFolder) {
        Map<ResourceLocation, JsonObject> rootJson = (Map) jsons.entrySet().stream().filter((e) -> {
            ResourceLocation res = (ResourceLocation) e.getKey();
            String resPath = res.getPath();
            return resPath.startsWith(subFolder) && !resPath.substring(subFolder.length()).contains("/");
        }).collect(jsonElemToObjMapCollector());
        this.extractAndApplyDataDirectorySettings(rootJson, subFolder);
        return rootJson;
    }
}
