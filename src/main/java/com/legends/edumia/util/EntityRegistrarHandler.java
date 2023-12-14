package com.legends.edumia.util;

import com.legends.edumia.entity.EntityTypeContainer;
import com.legends.edumia.entity.util.builder.IEntityBuilder;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.function.Supplier;

public class EntityRegistrarHandler {
    public final String modid;
    public final LinkedHashMap<String, EntityTypeContainer<? extends Mob>> ENTITIES = new LinkedHashMap<>();

    public EntityRegistrarHandler(String modid) {
        this.modid = modid;
    }

    public <T extends Mob> EntityTypeContainer<T> add(Class<T> entityClass, EntityType.EntityFactory<T>
            factory, String name, Supplier<AttributeSupplier.Builder>
            attributeMap, Function<EntityTypeContainer.Builder<T>, EntityTypeContainer.Builder<T>> transformer) {
        return add(transformer.apply(EntityTypeContainer.Builder.create(entityClass, factory, name, attributeMap, modid)));
    }

    public <T extends Mob, C extends EntityTypeContainer<T>> C add(IEntityBuilder<T, C, ?> builder) {
        C c = builder.build();
        c.entityType = new LazyLoadedValue(() -> this.createEntityType(c));
        c.onTypeAdded();
        ENTITIES.put(c.getEntityName(), c);
        return c;
    }

    public <T extends Mob> EntityType<T> createEntityType(EntityTypeContainer<T> container) {
        return createEntityType(container.getDefinition().getEntityFactory(), container.getEntityName(),
                container.getDefinition().getSpawnClassification(), 64, 1,
                true, container.getWidth(), container.getHeight());
    }

    public <T extends Entity> EntityType<T> createEntityType
            (EntityType.EntityFactory<T> factory, String entityNameIn, MobCategory classification,
             int trackingRange, int updateInterval, boolean velUpdates, float width, float height) {
        return EntityType.Builder.of(factory, classification).clientTrackingRange(trackingRange)
                .updateInterval(updateInterval).sized(width, height).build(modid + ":" +
                        entityNameIn.toLowerCase());
    }
}
