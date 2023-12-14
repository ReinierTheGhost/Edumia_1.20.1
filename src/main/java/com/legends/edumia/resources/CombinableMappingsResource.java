package com.legends.edumia.resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class CombinableMappingsResource<K, V> {
    protected final Map<K, V> mappings;
    private final int loadOrder;
    private final int numCombinedFrom;

    public CombinableMappingsResource(Map<K, V> mappings, int loadOrder, int numCombinedFrom) {
        this.mappings = mappings;
        this.loadOrder = loadOrder;
        this.numCombinedFrom = numCombinedFrom;
    }

    private int getLoadOrder() {
        return this.loadOrder;
    }

    public final int getNumCombinedFrom() {
        return this.numCombinedFrom;
    }

    public final int size() {
        return this.mappings.size();
    }

    public static <K, V, T extends CombinableMappingsResource<K, V>> T combine(List<T> resources, CombinableMappingsResourceFactory<K, V, T> factory) {
        List<T> sorted = new ArrayList(resources);
        Collections.sort(sorted, Comparator.comparingInt(CombinableMappingsResource::getLoadOrder));
        Map<K, V> mappings = new HashMap();
        Iterator var4 = sorted.iterator();

        while(var4.hasNext()) {
            CombinableMappingsResource table = (CombinableMappingsResource)var4.next();
            mappings.putAll(table.mappings);
        }

        return factory.create(mappings, 0, sorted.size());
    }

    @FunctionalInterface
    public interface CombinableMappingsResourceFactory<K, V, T extends CombinableMappingsResource<K, V>> {
        T create(Map<K, V> var1, int var2, int var3);
    }
}
