package com.legends.edumia.entity.animals.util;

import com.legends.edumia.entity.AbstractEntityBuilder;
import com.legends.edumia.entity.EntityTypeContainer;
import com.legends.edumia.entity.EntityTypeDefinition;
import com.legends.edumia.entity.util.builder.IEntityTypeDefinition;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.List;
import java.util.function.Supplier;

public class EntityTypeContainerEdumiaTameable<T extends TamableAnimal> extends EntityTypeContainer<T> {
    protected String[] tameItemsStore;
    protected Supplier<List<? extends String>> tameItems;
    protected String[] defaultTameItems;

    private EntityTypeContainerEdumiaTameable(TameableEntityTypeDefinition<T> def) {
        super(def);
        this.defaultTameItems = def.getTameItems();
    }

    protected static class TameableEntityTypeDefinition<T extends TamableAnimal> extends EntityTypeDefinition<T> {
        AbstractEntityBuilderEdumiaTameable<T, ?, ?> builder;

        public TameableEntityTypeDefinition(AbstractEntityBuilderEdumiaTameable<T, ?, ?> builder) {
            super(builder);
            this.builder = builder;
        }

        public String[] getTameItems() {
            return builder.defaultTameItems;
        }

    }

    public static abstract class AbstractEntityBuilderEdumiaTameable<T extends TamableAnimal,
            C extends EntityTypeContainerEdumiaTameable<T>, B extends AbstractEntityBuilderEdumiaTameable
            <T, C, B>> extends AbstractEntityBuilder<T, C, B> {
        protected String[] defaultTameItems;

        protected AbstractEntityBuilderEdumiaTameable(Class<T> EntityClass, EntityType.EntityFactory<T>
                factory, String entityNameIn, Supplier<AttributeSupplier.Builder> attributeMap, String modid) {
            super(EntityClass, factory, entityNameIn, attributeMap, modid);
        }

        public B tameItems(String... items) {
            this.defaultTameItems = items;
            return getImplementation();
        }

    }

}
