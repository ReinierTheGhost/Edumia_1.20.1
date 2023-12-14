package com.legends.edumia.dynamictrees.api;

import com.legends.edumia.Edumia;
import com.legends.edumia.dynamictrees.tree.species.Species;
import net.minecraft.resources.ResourceLocation;

/**
 * Contains various utility functions relating to {@link Object}s with a {@link //SimpleRegistry}.
 *
 * @author ferreusveritas
 */
public final class TreeRegistry {
    private TreeRegistry() {
    }


    //////////////////////////////
    // SPECIES REGISTRY
    //////////////////////////////

    public static Species findSpecies(final String name) {
        return findSpecies(getResLoc(name));
    }

    public static Species findSpecies(final ResourceLocation name) {
        return Species.REGISTRY.get(name);
    }

    public static ResourceLocation getResLoc(final String resLocStr) {
        return processResLoc(new ResourceLocation(resLocStr));
    }

    /**
     * Changes namespace of resource location to "dynamictrees" as a default if it is set to Minecraft. This is safe
     * since Minecraft won't (or shouldn't) have used any of our registries.
     *
     * @param resourceLocation The {@link ResourceLocation} to parse.
     * @return The {@link ResourceLocation} object.
     */
    public static ResourceLocation processResLoc(final ResourceLocation resourceLocation) {
        return Edumia.MINECRAFT.equals(resourceLocation.getNamespace()) ?
                Edumia.location(resourceLocation.getPath()) : resourceLocation;
    }
}
