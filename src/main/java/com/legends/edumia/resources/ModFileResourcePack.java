package com.legends.edumia.resources;

import com.google.common.base.Joiner;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraftforge.fml.loading.moddiscovery.ModFile;
import net.minecraftforge.resource.PathPackResources;
import org.checkerframework.checker.units.qual.C;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ModFileResourcePack extends PathPackResources {

    private final ModFile modFile;
    private final ModLocator modLocator;

    /**
     * Constructs a java.nio.Path-based resource pack.
     *
     * @param packId    the identifier of the pack.
     *                  This identifier should be unique within the pack finder, preferably the name of the file or folder containing the resources.
     * @param isBuiltin whether this pack resources should be considered builtin
     * @param source    the root path of the pack. This needs to point to the folder that contains "assets" and/or "data", not the asset folder itself!
     * @param modFile
     */
    public ModFileResourcePack(String packId, boolean isBuiltin, Path source, ModFile modFile, ModLocator locator) {
        super(packId, isBuiltin, source);
        this.modFile = modFile;
        this.modLocator = locator;
    }


    public ModFile getModFile(){
        return this.modFile;
    }

    public Collection<ResourceLocation> listResources(PackType packType, String namespace, String pathIn, int maxDepth, Predicate<String> filter) {
        try {
            Path root = modLocator.findPath(modFile, packType.getDirectory(), namespace).toAbsolutePath();
            Path inputPath = root.getFileSystem().getPath(pathIn);
            return Files.walk(root).map(path -> root.relativize(path.toAbsolutePath())).
                    filter(path -> path.getNameCount() <= maxDepth).
                    filter(path -> !path.toString().endsWith(".mcmeta"))
                    .filter(path -> path.startsWith(inputPath))
                    .filter(path -> filter.test(path.getFileName().toString()))
                    .map(path -> new ResourceLocation(namespace, Joiner.on('/').join(path)))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
