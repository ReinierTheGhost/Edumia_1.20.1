package com.legends.edumia.common.data;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class DataUtil {


    private static <T> void fillCollectionFromBuffer(FriendlyByteBuf buf, Collection<T> collection, Supplier<T> bufferToElement) {
        collection.clear();
        int collectionSize = buf.readVarInt();

        for (int i = 0; i < collectionSize; ++i){
            T element = bufferToElement.get();
            if (element != null){
                collection.add(element);
            }
        }
    }
    public static <T, C extends Collection<T>> C readNewCollectionFromBuffer(FriendlyByteBuf buf, Supplier<C> collectionSupplier,
                                                                             Supplier<T> bufferToElement) {
        Collection<T> collection = collectionSupplier.get();
        fillCollectionFromBuffer(buf, collection, bufferToElement);
        return (C) collection;
    }


    public static <T> void writeCollectionToBuffer(FriendlyByteBuf buf, Collection<T> collection, Consumer<T> elementToBuffer) {
        buf.writeVarInt(collection.size());
        collection.forEach(elementToBuffer);
    }
}
