package com.legends.edumia.core.util.cashe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public abstract class Cache<K, V> implements Disposable {
    private static final List<com.legends.edumia.core.util.cashe.Cache<?, ?>> cacheList = new LinkedList();
    private Map<K, V> cache = Collections.emptyMap();

    protected Cache() {
        cacheList.add(this);
    }

    public final V get(K k) {
        if (this.cache.isEmpty()) {
            this.cache = new HashMap();
        }

        return this.cache.computeIfAbsent(k, this::compute);
    }

    public final void put(K k, V v) {
        if (this.cache.isEmpty()) {
            this.cache = new HashMap();
        }

        this.cache.put(k, v);
    }

    public final void forEach(BiConsumer<K, V> consumer) {
        this.cache.forEach(consumer);
    }

    public void dispose() {
        this.cache.clear();
        this.cache = Collections.emptyMap();
    }

    public abstract V compute(K var1);

    public static void clearAll() {
        Iterator<com.legends.edumia.core.util.cashe.Cache<?, ?>> iterator = cacheList.iterator();

        while(iterator.hasNext()) {
            ((com.legends.edumia.core.util.cashe.Cache)iterator.next()).dispose();
            iterator.remove();
        }

    }
}
