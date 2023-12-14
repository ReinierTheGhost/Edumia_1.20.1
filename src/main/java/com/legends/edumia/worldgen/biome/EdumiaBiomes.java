package com.legends.edumia.worldgen.biome;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.EntityLoader;
import com.legends.edumia.core.item.family.Family;
import com.legends.edumia.worldgen.ModCarvers;
import com.legends.edumia.worldgen.ModPlacedFeatures;
import com.legends.edumia.worldgen.biome.init.PreRegistradedEdumiaBiome;
import com.legends.edumia.worldgen.placement.*;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.data.ForgeRecipeProvider;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EdumiaBiomes {

    /**
     * MAP_BIOME_COLORS will be used later for my dimension generation
     */
    public static final Map<Integer, Biome> MAP_BIOME_COLORS = new HashMap<>();


    /**
     * Registers the biomes and make a Reference for adding them to the dimension
     */
    public static final ResourceKey<Biome> HIGH_ELF_VALLEY = register("high_elf_valley");
    public static final ResourceKey<Biome> HIGH_ELF_PLATEAU = register("high_elf_plateau");
    public static final ResourceKey<Biome> HIGH_ELVEN_RIVER = register("high_elven_river");

    public static final ResourceKey<Biome> TAIGA_FOREST = register("taiga_forest");
    public static final ResourceKey<Biome> TAIGA_CLIFFS = register("taiga_cliffs");
    public static final ResourceKey<Biome> TAIGA_LOWLANDS = register("taiga_lowlands");
    public static final ResourceKey<Biome> TAIGA_MOUNTAIN_HILLS = register("taiga_mountain_hills");

    public static final ResourceKey<Biome> SNOW_PLAINS = register("snow_plains");

    public static final ResourceKey<Biome> GENSAI_REEF = register("gensai_reef");

    public static final ResourceKey<Biome> OGRE_FOREST_VALLEY = register("ogre_forest_valley");
    public static final ResourceKey<Biome> OGRE_FOREST_GROVE = register("ogre_forest_grove");

    public static final ResourceKey<Biome> HAZE_MOUNTAIN = register("haze_mountain");
    public static final ResourceKey<Biome> HIGHLANDS = register("highlands");


    public static final ResourceKey<Biome> ORC_VALLEY = register("orc_valley");
    public static final ResourceKey<Biome> HOLY_ORC_DESERT = register("holy_orc_desert");
    public static final ResourceKey<Biome> ORC_MESA = register("orc_mesa");


    public static final ResourceKey<Biome> FROZEN_OCEAN = register("frozen_ocean");
    public static final ResourceKey<Biome> COLD_OCEAN = register("cold_ocean");
    public static final ResourceKey<Biome> DEEP_FROZEN_OCEAN = register("deep_frozen_ocean");
    public static final ResourceKey<Biome> DEEP_COLD_OCEAN = register("deep_cold_ocean");
    public static final ResourceKey<Biome> OCEAN = register("ocean");
    public static final ResourceKey<Biome> DEEP_OCEAN = register("deep_ocean");
    public static final ResourceKey<Biome> LUKEWARM_OCEAN = register("lukewarm_ocean");
    public static final ResourceKey<Biome> DEEP_LUKEWARM_OCEAN = register("deep_lukewarm_ocean");



    //waterBiomes
    public static final ResourceKey<Biome> POND = register("pond");
    public static final ResourceKey<Biome> FAIRY_SWAMP = register("fairy_swamp");
    public static final ResourceKey<Biome> DEMON_POND = register("demon_pond");


    /**
     * connects the ResourceKey form above with the biome generation below
     * @param context
     */
    public static void boodstrap(BootstapContext<Biome> context){
        context.register(HIGH_ELF_VALLEY, highElfValley(context));
        context.register(HIGH_ELF_PLATEAU, highElfPlateau(context));
        context.register(TAIGA_CLIFFS, taigaCliffs(context));
        context.register(TAIGA_LOWLANDS, taigaLowlands(context));
        context.register(GENSAI_REEF, gensaiReef(context));
        context.register(HIGH_ELVEN_RIVER, highElvenRiver(context));
        context.register(TAIGA_FOREST, taigaForest(context));
        context.register(HAZE_MOUNTAIN, hazeMountain(context));
        context.register(ORC_VALLEY, orcValley(context));
        context.register(TAIGA_MOUNTAIN_HILLS, taigaMountainHills(context));
        context.register(FROZEN_OCEAN, frozenOcean(context));
        context.register(DEEP_FROZEN_OCEAN, deepFrozenOcean(context));
        context.register(COLD_OCEAN, coldOcean(context));
        context.register(DEEP_COLD_OCEAN, deepColdOcean(context));
        context.register(OCEAN, ocean(context));
        context.register(DEEP_OCEAN, deepOcean(context));
        context.register(LUKEWARM_OCEAN, lukewarmOcean(context));
        context.register(DEEP_LUKEWARM_OCEAN, deepLukewarmOcean(context));
        context.register(OGRE_FOREST_VALLEY, ogreForestValley(context));
        context.register(OGRE_FOREST_GROVE, ogreForestGrove(context));
        context.register(SNOW_PLAINS, snowPlains(context));
        context.register(HIGHLANDS, highLands(context));
        context.register(HOLY_ORC_DESERT, holyOrcDesert(context));
        context.register(ORC_MESA, orcMesa(context));
        context.register(POND, pond(context));
        context.register(DEMON_POND, demonPond(context));
        context.register(FAIRY_SWAMP, fairySwamp(context));
    }



    /**
     * this methode adds the features I want in almost all biomes
      * @param builder
     */

    public static void globalEdumiaGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static Biome demonPond(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(1f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                        // .grassColorOverride(7982981)
                        //.foliageColorOverride(16764123)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome fairySwamp(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(1f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                        // .grassColorOverride(7982981)
                        //.foliageColorOverride(16764123)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome pond(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);



        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(1f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                        // .grassColorOverride(7982981)
                        //.foliageColorOverride(16764123)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static Biome orcMesa(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, SavannaPlacement.TERRACOTTA);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0f)
                .temperature(1f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(5076668)
                        .waterFogColor(329011)
                        .skyColor(11653631)
                        // .grassColorOverride(7982981)
                        //.foliageColorOverride(16764123)
                        .fogColor(13494015)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static Biome holyOrcDesert(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0f)
                .temperature(2f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(7856375)
                        .waterFogColor(329011)
                        .skyColor(8746857)
                        // .grassColorOverride(7982981)
                        //.foliageColorOverride(16764123)
                        .fogColor(12295069)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static Biome highLands(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, HighlandPlaced.PILLAR);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, HighlandPlaced.LAKE);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, CanyonPlaced.CLIFF_2_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, CanyonPlaced.SLAB_STONE);

        //biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HighlandPlaced.DISK_GRAVEL);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.4f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(7907327)
                        // .grassColorOverride(7982981)
                        //.foliageColorOverride(16764123)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome snowPlains(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.POLAR_BEAR, 1, 1, 2));

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, SnowPlaced.LAYER_FIRST);
        biomeBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, SnowPlaced.LAYER_SECOND);
        biomeBuilder.addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, SnowPlaced.LAYER_THIRD);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(3750089)
                        .waterFogColor(329011)
                        .skyColor(10858685)
                       // .grassColorOverride(7982981)
                        //.foliageColorOverride(16764123)
                        .fogColor(14145761)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static Biome ogreForestGrove(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, SakuraPlaced.CLAY_BEACHES);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, SakuraPlaced.PATCH_PODZOL);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4962255)
                        .waterFogColor(329011)
                        .skyColor(10864127)
                        .grassColorOverride(7982981)
                        .foliageColorOverride(16764123)
                        .fogColor(13822975)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome ogreForestValley(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, CanyonPlaced.CLIFF_2_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, SakuraPlaced.CLAY_BEACHES);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, SakuraPlaced.PATCH_PODZOL);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4962255)
                        .waterFogColor(329011)
                        .skyColor(10864127)
                        .grassColorOverride(7982981)
                        .foliageColorOverride(16764123)
                        .fogColor(13822975)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static Biome deepLukewarmOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4566514)
                        .waterFogColor(267827)
                        .skyColor(8103167)
                        //.grassColorOverride(7382395)
                        //.foliageColorOverride(15971383)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome lukewarmOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4566514)
                        .waterFogColor(267827)
                        .skyColor(8103167)
                        //.grassColorOverride(7382395)
                        //.foliageColorOverride(15971383)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome deepOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4020182)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                        //.grassColorOverride(7382395)
                        //.foliageColorOverride(15971383)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome ocean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4020182)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                        //.grassColorOverride(7382395)
                        //.foliageColorOverride(15971383)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome deepColdOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4020182)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                        //.grassColorOverride(7382395)
                        //.foliageColorOverride(15971383)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome coldOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4020182)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                        //.grassColorOverride(7382395)
                        //.foliageColorOverride(15971383)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static Biome deepFrozenOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MiscOverworldPlacements.ICEBERG_PACKED);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MiscOverworldPlacements.ICEBERG_BLUE);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, MiscOverworldPlacements.BLUE_ICE);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.0f)
                .temperatureAdjustment(Biome.TemperatureModifier.FROZEN)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4020182)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                        //.grassColorOverride(7382395)
                        //.foliageColorOverride(15971383)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static Biome frozenOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MiscOverworldPlacements.ICEBERG_PACKED);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MiscOverworldPlacements.ICEBERG_BLUE);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, MiscOverworldPlacements.BLUE_ICE);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.0f)
                .temperatureAdjustment(Biome.TemperatureModifier.FROZEN)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4020182)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                        //.grassColorOverride(7382395)
                        //.foliageColorOverride(15971383)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome taigaMountainHills(BootstapContext<Biome> context){
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);


        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.6f)
                .temperature(0.3f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(6388624)
                        .waterFogColor(2302743)
                        .skyColor(10858685)
                        .grassColorOverride(7382395)
                        .foliageColorOverride(15971383)
                        .fogColor(14145761)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    /**
     * the info for generating the Orc Valley biome
     * @param context
     * @return
     */
    public static Biome orcValley(BootstapContext<Biome> context){
        /**
         * this must be in all the biome generation methods for spawn settings
         */
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        /**
         * the creatures you want to spawn should be below like the fox
         */
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 5, 4, 4));

        /**
         * this must be in all the biome generation methods for the placed features and Carvers
         */

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        /**
         *bellow all the carvers and Placed features I want to add
         */
        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, CanyonPlaced.SANDSTONE_CLIFF_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, CanyonPlaced.SANDSTONE_SANDSTONE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, CanyonPlaced.SANDSTONE_SLAB_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, CanyonPlaced.SANDSTONE_SLAB_SMOOTH_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.LAKES, CanyonPlaced.SANDSTONE_LAKES_PLACED_KEY);

/**
 * this is always required for a biome
 */
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0f)
                .temperature(2f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4570768)
                        .waterFogColor(329011)
                        .skyColor(11653631)
                        .grassColorOverride(7844664)  //Optional
                        .foliageColorOverride(5157688) //Optional
                        .fogColor(13494015)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT))
                        .build())
                .build();
    }

    public static Biome hazeMountain(BootstapContext<Biome> context){
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, CanyonPlaced.CLIFF_2_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.6f)
                .temperature(0.3f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159136)
                        .waterFogColor(329011)
                        .skyColor(14145761)
                        .grassColorOverride(10463365)
                        .foliageColorOverride(10792816)
                        .fogColor(10858685)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static Biome taigaForest(BootstapContext<Biome> context){

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TaigaPlaced.SIBERIAN_NEW_TREES_ORANGE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TaigaPlaced.SIBERIAN_NEW_TREES);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(7972607)
                        //.grassColorOverride(0x7f03fc)
                        //.foliageColorOverride(0xd203fc)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome highElvenRiver(BootstapContext<Biome> context){

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_WATER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.WARM_OCEAN_VEGETATION);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEA_PICKLE);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(1.2f)
                .temperature(0.2f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(6388624)
                        .waterFogColor(2302743)
                        .skyColor(10858685)
                        .grassColorOverride(6463095)
                        .foliageColorOverride(15435072)
                        .fogColor(14145761)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static Biome gensaiReef(BootstapContext<Biome> context){

        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_WATER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.WARM_OCEAN_VEGETATION);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEA_PICKLE);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4445678)
                        .waterFogColor(4445678)
                        .skyColor(8103167)
                       // .grassColorOverride(5866311)
                        //.foliageColorOverride(5276209)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public static Biome taigaLowlands(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.BEE, 2, 3, 5));

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, CanyonPlaced.CLIFF_2_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YosemitePlaced.DISK_STONE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YosemitePlaced.PATCH_DIRT_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, YosemitePlaced.WATERFALL_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, YosemitePlaced.OAKS_PLACED_KEY);



        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CAVE_GENERIC_MEGA_GEODE_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.25f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(3557290)
                        .waterFogColor(329011)
                        .skyColor(8233983)
                        .grassColorOverride(5866311)
                        //.foliageColorOverride(5276209)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
    public static Biome taigaCliffs(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.BEE, 2, 3, 5));

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CAVE_GENERIC_MEGA_GEODE_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.STRONGHOLDS, YosemitePlaced.GRASS_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.STRONGHOLDS, YosemitePlaced.CALCITE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.STRONGHOLDS, YosemitePlaced.DIORITE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.STRONGHOLDS, YosemitePlaced.WATERFALL_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.375f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(8233983)
                        .grassColorOverride(5866311)
                        //.foliageColorOverride(0xd203fc)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    /*public static Biome deepOcean(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DOLPHIN, 2, 5, 10));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.COD, 2, 10, 15));


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        globalEdumiaGeneration(biomeBuilder);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CAVE_GENERIC_MEGA_GEODE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_WATER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_DEEP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_NORMAL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.KELP_COLD);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                        //.grassColorOverride(0x7f03fc)
                        //.foliageColorOverride(0xd203fc)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }*/
    public static Biome highElfValley(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityLoader.RHINO.get(), 2, 3, 5));

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, HighElvenPlaced.CLIFF_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, ModPlacedFeatures.JUNGLE_MOUNTAINS_SLAB_STONE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CAVE_GENERIC_MEGA_GEODE_PLACED_KEY);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MountainPlaced.MISTY_TREES_MID);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MountainPlaced.MISTY_TREES_TOP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MountainPlaced.MISTY_TREES_BIRCH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MountainPlaced.MISTY_TREES_BASE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CanyonPlaced.FLOWERS_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CanyonPlaced.FLOWERS_WHITE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_MEADOW);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_TALL_GRASS_2);
        biomeBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(937679)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                        //.grassColorOverride(0x7f03fc)
                        //.foliageColorOverride(0xd203fc)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_MEADOW))
                        .build())
                .build();
    }

    public static Biome highElfPlateau(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityLoader.RHINO.get(), 2, 3, 5));

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalEdumiaGeneration(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, HighElvenPlaced.CLIFF_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.RAW_GENERATION, ModPlacedFeatures.JUNGLE_MOUNTAINS_SLAB_STONE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.CAVE_GENERIC_MEGA_GEODE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CanyonPlaced.FLOWERS_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, CanyonPlaced.FLOWERS_WHITE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_MEADOW);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_TALL_GRASS_2);
        biomeBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, MiscOverworldPlacements.SPRING_WATER);

        biomeBuilder.addCarver(GenerationStep.Carving.AIR, ModCarvers.DEEP_RAVINE);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(937679)
                        .waterFogColor(329011)
                        .skyColor(8103167)
                       // .grassColorOverride(0x7f03fc)
                        //.foliageColorOverride(0xd203fc)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_MEADOW))
                        .build())
                .build();
    }

    /**
     * register methode for the Biome data folder
     * @param name
     * @return
     */
    public static ResourceKey<Biome> register(String name){
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(Edumia.MODID, name));
    }

    public static void registerModBiomes(){
        Edumia.LOGGER.debug("Registering ModBiomes for " + Edumia.MODID);
    }

}

