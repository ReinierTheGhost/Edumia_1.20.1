package com.legends.edumia.core.block.data;

import com.legends.edumia.core.util.cashe.Cache;

public class BlockTemplateCache extends Cache<Class<?>, BlockTemplate> {

    private static final BlockTemplateCache instance = new BlockTemplateCache();
    public static BlockTemplateCache getInstance() {
        return instance;
    }

    @Override
    public BlockTemplate compute(Class<?> type) {
        return new BlockTemplate(type);
    }
}
