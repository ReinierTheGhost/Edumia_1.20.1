package com.legends.edumia.core.block.builder;

public class BlockName {
    private final String namespace;
    private final String plural;
    private final String singular;

    private BlockName(String namespace, String plural, String singular) {
        this.namespace = namespace;
        this.plural = plural;
        this.singular = singular;
    }

    public String getNamespace() {
        return this.namespace;
    }
    public String format(String format, boolean plural) {
        return String.format(format, plural ? this.plural : this.singular);
    }


    public static BlockName of(String namespace, String plural, String singular) {
        return new BlockName(namespace, plural, singular);
    }
}
