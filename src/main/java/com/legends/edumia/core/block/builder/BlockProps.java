package com.legends.edumia.core.block.builder;

import com.legends.edumia.core.block.factory.InitializationException;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;


import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public abstract class BlockProps<T extends BlockProps<T>> {
    private final Block block;
    private final MapColor color;
    private DyeColor dyeColor = null;
    private SoundType sound = null;
    private CreativeModeTab group;
    private ToIntFunction<BlockState> light;
    private Float resistance;
    private Float hardness;
    private Float slipperiness;
    private Boolean randomTick;
    private Boolean variableOpacity;
    private Boolean blocksMovement;
    private Boolean solid;

    protected BlockProps(Block block) {
        this.light = null;
        this.resistance = null;
        this.hardness = null;
        this.slipperiness = null;
        this.randomTick = null;
        this.variableOpacity = null;
        this.blocksMovement = null;
        this.solid = null;
        this.block = block;
        this.color = null;
    }

    protected BlockProps() {
        this.light = null;
        this.resistance = null;
        this.hardness = null;
        this.slipperiness = null;
        this.randomTick = null;
        this.variableOpacity = null;
        this.blocksMovement = null;
        this.solid = null;
        this.block = null;
        this.color = null;
    }

    protected BlockProps(MapColor color) {
        this.light = null;
        this.resistance = null;
        this.hardness = null;
        this.slipperiness = null;
        this.randomTick = null;
        this.variableOpacity = null;
        this.blocksMovement = null;
        this.solid = null;
        this.block = null;
        this.color = color;
    }

    protected BlockProps(BlockProps<T> props) {
        this.light = null;
        this.resistance = null;
        this.hardness = null;
        this.slipperiness = null;
        this.randomTick = null;
        this.variableOpacity = null;
        this.blocksMovement = null;
        this.solid = null;
        this.block = props.block;
        this.color = props.color;
        this.dyeColor = props.dyeColor;
        this.sound = props.sound;
        this.group = props.group;
        this.light = props.light;
        this.resistance = props.resistance;
        this.hardness = props.hardness;
        this.slipperiness = props.slipperiness;
        this.randomTick = props.randomTick;
        this.variableOpacity = props.variableOpacity;
        this.blocksMovement = props.blocksMovement;
        this.solid = props.solid;
    }



    public abstract T getProps();

    public T dye(DyeColor color) {
        this.dyeColor = color;
        return this.getProps();
    }

    public T sound(SoundType sound) {
        this.sound = sound;
        return this.getProps();
    }

    public T light(ToIntFunction<BlockState> light) {
        this.light = light;
        return (T) this;
    }

    public T strength(double hardness, double resistance) {
        this.hardness = (float)hardness;
        this.resistance = (float)resistance;
        return this.getProps();
    }

    public T slipperiness(double slipperiness) {
        this.slipperiness = (float)slipperiness;
        return this.getProps();
    }

    public T randomTick(boolean randomTick) {
        this.randomTick = randomTick;
        return this.getProps();
    }

    public T opacity(boolean variableOpacity) {
        this.variableOpacity = variableOpacity;
        return this.getProps();
    }

    public T blocking(boolean blocksMovement) {
        this.blocksMovement = blocksMovement;
        return this.getProps();
    }

    public T solid(boolean solid) {
        this.solid = solid;
        return this.getProps();
    }

    public T group(CreativeModeTab group) {
        this.group = group;
        return this.getProps();
    }

    public CreativeModeTab group() {
        return this.group;
    }

    public DyeColor dye() {
        return this.dyeColor == null ? DyeColor.BLACK : this.dyeColor;
    }

    public MapColor color() {
        return this.color == null ? MapColor.COLOR_BLACK : this.color;
    }

    public BlockBehaviour.Properties toProperties() throws InitializationException {
        BlockBehaviour.Properties builder = this.createBuilder();
        Boolean var4 = this.solid;
        Objects.requireNonNull(builder);
        applyNonNull(var4, false, builder::noOcclusion);
        var4 = this.randomTick;
        Objects.requireNonNull(builder);
        applyNonNull(var4, true, builder::randomTicks);
        var4 = this.variableOpacity;
        Objects.requireNonNull(builder);
        applyNonNull(var4, true, builder::dynamicShape);
        var4 = this.blocksMovement;
        Objects.requireNonNull(builder);
        applyNonNull(var4, false, builder::noCollission);
        if (this.hardness != null && this.resistance != null) {
            builder.strength(this.hardness, this.resistance);
        }

        return builder;
    }

    private BlockBehaviour.Properties createBuilder() throws InitializationException {
        BlockBehaviour.Properties props;
        if (this.block != null) {
            props = BlockBehaviour.Properties.copy(this.block);
        } else if (this.color != null) {
            props = BlockBehaviour.Properties.of();
        } else {

            props = BlockBehaviour.Properties.of();
        }

        return props;
    }

    private static <T> void applyNonNull(Boolean value, boolean condition, Runnable runnable) {
        if (value != null && value == condition) {
            runnable.run();
        }

    }

    private static <T> void applyNonNull(T value, Consumer<T> consumer) {
        if (value != null) {
            consumer.accept(value);
        }

    }

    protected abstract <T> void applyNonNull(Integer var1, Consumer<T> var2);
}
