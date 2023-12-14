package com.legends.edumia.core.block.builder;


import com.google.common.base.Preconditions;
import com.legends.edumia.core.block.factory.BlockFactory;
import com.legends.edumia.core.block.factory.InitializationException;
import com.legends.edumia.core.init.Context;
import com.legends.edumia.core.item.family.FamilyFactory;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;


import java.util.Map;
import java.util.function.Consumer;

public class Props extends BlockProps<Props> implements BlockFactory {
    private BlockState parent = null;
    private BlockName name = null;

    private FamilyFactory<Block> familyFactory;
    private ResourceLocation family;

    private Map<String, Object> extradata;

    protected Props(Block block) {
        super(block);
    }

    public Props( MapColor color) {
        super( color);
    }

    @Override
    public Props getProps() {
        return this;
    }

    @Override
    protected <T> void applyNonNull(Integer light, Consumer<T> lightLevel) {
    }

    public <T> T get(String key, Class<T> type) {
        Object o = this.extradata.get(key);
        if (o == null) {
            throw new InitializationException(new NullPointerException(key + ": value is null"));
        } else if (!type.isInstance(o)) {
            throw new InitializationException(new ClassCastException(key + ": expected " + type + " but found " + o.getClass()));
        } else {
            return type.cast(o);
        }
    }

    public Props name(String namespace, String plural, String singular) {
        return this.name(BlockName.of(namespace, plural, singular));
    }

    public Props name(String plural, String singular) {
        return this.name(Context.getInstance().getNamespace(), plural, singular);
    }

    public Props name(String name) {
        return this.name(Context.getInstance().getNamespace(), name, name);
    }

    public Props name(BlockName name) {
        this.name = name;
        return this;
    }

    public static Props create(Block block) {
        Preconditions.checkNotNull(block, "Block must not be null");
        return new Props(block);
    }

    public static Props create(BlockState state) {
        Preconditions.checkNotNull(state, "BlockState must not be null");
        return create(state.getBlock());
    }

    public static Props create(Material material, MapColor color) {

        Preconditions.checkNotNull(color, "MaterialColor must not be null");
        return new Props(color);
    }

    public BlockState getParent() throws InitializationException {
        if (this.parent == null) {
            throw new InitializationException("Parent state is null");
        } else {
            return this.parent;
        }
    }
}
