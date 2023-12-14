package com.legends.edumia.core.asset.pack;

import net.minecraft.server.packs.PackType;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PackFinder {

    private static final Map<PackType, PackFinder> finders = new ConcurrentHashMap();

    private final PackType type;
    private final List<VirtualResourcepack> resourcePacks = new LinkedList();

    public PackFinder(PackType type) {
        this.type = type;
    }

    public void register(VirtualResourcepack pack) {
        this.resourcePacks.add(pack);
    }
    public static PackFinder getInstance(PackType type) {
        return (PackFinder)finders.computeIfAbsent(type, PackFinder::new);
    }
}
