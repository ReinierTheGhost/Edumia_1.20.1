package com.legends.edumia.core.block.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.legends.edumia.core.util.OptimizedList;
import com.legends.edumia.core.util.cashe.Cache;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;

public class TypeList implements Iterable<Class<? extends Block>>, Comparator<Block> {
    public static final com.legends.edumia.core.block.factory.TypeList EMPTY = new com.legends.edumia.core.block.factory.TypeList(Collections.emptyList());
    private static final Cache<TypeKey, TypeList> cache = new com.legends.edumia.core.block.factory.TypeList.TypeListCache();
    private final List<Class<? extends Block>> types;

    private TypeList(List<Class<? extends Block>> types) {
        this.types = types;
    }

    public boolean isEmpty() {
        return this.types.isEmpty();
    }

    public Class<? extends Block> first() {
        return this.types.size() > 0 ? (Class)this.types.get(0) : AirBlock.class;
    }

    public static com.legends.edumia.core.block.factory.TypeList of(Collection<Class<? extends Block>> types) {
        return new com.legends.edumia.core.block.factory.TypeList(new ArrayList(types));
    }

    @SafeVarargs
    public static com.legends.edumia.core.block.factory.TypeList of(Class<? extends Block>... types) {
        if (types.length == 0) {
            throw new RuntimeException("No Types provided!");
        } else {
            return (com.legends.edumia.core.block.factory.TypeList)cache.get(new com.legends.edumia.core.block.factory.TypeList.TypeKey(types));
        }
    }

    public Iterator<Class<? extends Block>> iterator() {
        return this.types.iterator();
    }

    public int compare(Block b1, Block b2) {
        return this.getIndex(b1) - this.getIndex(b2);
    }

    private int getIndex(Object o) {
        int max = -1;

        for(int i = 0; i < this.types.size(); ++i) {
            Class<?> type = (Class)this.types.get(i);
            if (type.isInstance(o)) {
                max = Math.max(max, i);
            }
        }

        return max == -1 ? this.types.size() : max;
    }

    private static class TypeKey {
        private final Class<? extends Block>[] types;

        private TypeKey(Class<? extends Block>[] types) {
            this.types = types;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            } else if (o != null && this.getClass() == o.getClass()) {
                com.legends.edumia.core.block.factory.TypeList.TypeKey typeKey = (com.legends.edumia.core.block.factory.TypeList.TypeKey)o;
                return Arrays.equals(this.types, typeKey.types);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return Arrays.hashCode(this.types);
        }
    }

    private static class TypeListCache extends Cache<com.legends.edumia.core.block.factory.TypeList.TypeKey, com.legends.edumia.core.block.factory.TypeList> {
        private TypeListCache() {
        }

        public com.legends.edumia.core.block.factory.TypeList compute(com.legends.edumia.core.block.factory.TypeList.TypeKey typeKey) {
            OptimizedList<Class<? extends Block>> list = OptimizedList.of(typeKey.types);
            list.trim();
            return new com.legends.edumia.core.block.factory.TypeList(list);
        }
    }
}
