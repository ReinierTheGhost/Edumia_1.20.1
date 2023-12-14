package com.legends.edumia.dynamictrees.api.registry;


import com.legends.edumia.dynamictrees.resources.Resources;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.validation.PathAllowList;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * An extension of {@link //SimpleRegistry} that allows for custom {@link PathAllowList.EntryType}.
 *
 * @param <V> The {@link RegistryEntry} type that will be registered.
 * @author Harley O'Connor
 */
// TODO: Update Javadoc
public class TypedRegistry<V extends RegistryEntry<V>> extends SimpleRegistry<V> {
    /**
     * A {@link Map} of {@link EntryType} objects and their registry names. These handle construction of the {@link
     * RegistryEntry}. This is useful for other mods to register sub-classes of the registry entry that can then be
     * referenced from a Json file via a simple resource location.
     */
    private final Map<ResourceLocation, EntryType<V>> typeRegistry = new HashMap<>();

    /**
     * The default {@link EntryType<V>}, the base {@link TypedRegistry.EntryType} for this registry.
     */
    private final EntryType<V> defaultType;
    /**
     * Constructs a new {@link TypedRegistry} with the name being set to {@link Class#getSimpleName()} of the given
     * {@link RegistryEntry}.
     *
     * @param type        The {@link Class} of the {@link RegistryEntry}.
     * @param nullValue   A null entry. See {@link #nullValue} for more details.
     * @param defaultType The default {@link EntryType<V>}.
     */
    public TypedRegistry(Class<V> type, V nullValue, EntryType<V> defaultType) {
        super(type, nullValue);
        this.defaultType = defaultType.setRegistry(this);
    }

    /**
     * Constructs a new {@link TypedRegistry}.
     *
     * @param name        The {@link #name} for this {@link SimpleRegistry}.
     * @param type        The {@link Class} of the {@link RegistryEntry}.
     * @param nullValue   A null entry. See {@link #nullValue} for more details.
     * @param defaultType The default {@link EntryType<V>}.
     */
    public TypedRegistry(String name, Class<V> type, V nullValue, EntryType<V> defaultType) {
        super(name, type, nullValue);
        this.defaultType = defaultType.setRegistry(this);
    }

    /**
     * Handles creation of the registry entry. Custom types can be registered via {@link #//registerType(ResourceLocation,
     * EntryType)}.
     *
     * @param <V> The {@link RegistryEntry} sub-class.
     */
    public static class EntryType<V extends RegistryEntry<V>> {
        private TypedRegistry<V> registry;
        private final Codec<V> codec;

        public EntryType(Codec<V> codec) {
            this.codec = codec;
        }

        public Codec<V> getCodec() {
            return codec;
        }

        public EntryType<V> setRegistry(TypedRegistry<V> registry) {
            this.registry = registry;
            return this;
        }

    }

    public static <V extends RegistryEntry<V>> Codec<V> createDefaultCodec(final Function<ResourceLocation, V> constructor) {
        return RecordCodecBuilder.create(instance -> instance
                .group(ResourceLocation.CODEC.fieldOf(Resources.RESOURCE_LOCATION.toString()).forGetter(RegistryEntry::getRegistryName))
                .apply(instance, constructor));
    }

    public static <V extends RegistryEntry<V>> EntryType<V> newType(final Codec<V> codec) {
        return new EntryType<>(codec);
    }

    public static <V extends RegistryEntry<V>> EntryType<V> newType(final Function<ResourceLocation, V> constructor) {
        return newType(createDefaultCodec(constructor));
    }
}
