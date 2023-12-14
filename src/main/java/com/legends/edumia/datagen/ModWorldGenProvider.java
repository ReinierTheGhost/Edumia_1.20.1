package com.legends.edumia.datagen;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.ModBiomeModifiers;
import com.legends.edumia.worldgen.ModCarvers;
import com.legends.edumia.worldgen.ModConfiguredFeatures;
import com.legends.edumia.worldgen.ModPlacedFeatures;
import com.legends.edumia.worldgen.biome.EdumiaBiomes;
import com.legends.edumia.worldgen.dimension.EdumiaDimensions;
import com.legends.edumia.worldgen.features.ForestFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(Registries.BIOME, EdumiaBiomes::boodstrap)
            .add(Registries.CONFIGURED_CARVER, ModCarvers::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            .add(Registries.LEVEL_STEM, EdumiaDimensions::bootstrapStem)
            .add(Registries.DIMENSION_TYPE, EdumiaDimensions::bootstrapType);
    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Edumia.MODID));
    }

}
