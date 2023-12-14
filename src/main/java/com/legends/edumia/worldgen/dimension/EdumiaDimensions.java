package com.legends.edumia.worldgen.dimension;

import com.legends.edumia.Edumia;
import com.legends.edumia.worldgen.biome.EdumiaBiomes;
import com.legends.edumia.worldgen.gen.EdumiaDimChunkGenerator;
import com.legends.edumia.worldgen.gen.EdumiaHeightMap;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import org.joml.Vector3i;

import java.util.List;
import java.util.OptionalLong;

public class EdumiaDimensions {

    public static final Vector3i EDUMIA_SPAWN_LOCATION = new Vector3i(0, 90, 0);
    public static final String PATH = "edumiadim";
    public static final ResourceKey<LevelStem> EDUMIA_KEY = ResourceKey.create(Registries.LEVEL_STEM,
            new ResourceLocation(Edumia.MODID, PATH));
    public static ResourceKey<Level> EDUMIA_LEVEL_KEY = ResourceKey.create(Registries.DIMENSION,
            EDUMIA_KEY.location());
    public static final ResourceKey<DimensionType> EDUMIA_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            new ResourceLocation(Edumia.MODID, "edumia_type"));

    public static void register(){
        Registry.register(BuiltInRegistries.CHUNK_GENERATOR, new ResourceLocation(Edumia.MODID, PATH),
                EdumiaDimChunkGenerator.CODEC);
        EDUMIA_LEVEL_KEY =ResourceKey.create(Registries.DIMENSION, new ResourceLocation(Edumia.MODID, PATH));

        Edumia.LOGGER.debug("Registering ModDimensions for " + Edumia.MODID);

    }
    public static void bootstrapType(BootstapContext<DimensionType> context){
        context.register(EDUMIA_TYPE, new DimensionType(
                OptionalLong.empty(), //fixed time
                false, //has skylight
                false, //has ceiling
                false, //ultra warm
                true, //natural
                1.0, //cordinate scale
                true, //bed works
                false, //respawn anchor works
                -64, //minY
                512, //height
                512, //logical height
                BlockTags.INFINIBURN_OVERWORLD, //infinitiburn
                BuiltinDimensionTypes.OVERWORLD_EFFECTS, //effectsLocation
                1.0f, //ambientlight
                new DimensionType.MonsterSettings(false, false,
                        ConstantInt.of(0), 0)));
    }

    public static void bootstrapStem(BootstapContext<LevelStem> context) {
        HolderGetter<Biome> biomeRegistry = context.lookup(Registries.BIOME);
        HolderGetter<DimensionType> dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        HolderGetter<NoiseGeneratorSettings> noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS);

        NoiseBasedChunkGenerator wrappedChunkGenerator = new NoiseBasedChunkGenerator(
                new FixedBiomeSource(biomeRegistry.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN)),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.AMPLIFIED));


        /**
         * this will generate the dimension file, with all the biome parameters
         * with span you can add 2 parameters and the biome will be able to generate between
         * with point you will have 1 parameter and that is where the biome will spawn
         * in both cases it is that the biome with the lowest and the biome with the highest value will be maxed the the max to fill all spaces
         */
        NoiseBasedChunkGenerator noiseBasedChunkGenerator = new NoiseBasedChunkGenerator(
                MultiNoiseBiomeSource.createFromList(
                        new Climate.ParameterList<>(List.of(
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.1F,0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELF_PLATEAU)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.155F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.35F,0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELF_PLATEAU)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.1F,0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.26666668F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELF_PLATEAU)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.155F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.35F,0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.26666668F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELF_PLATEAU)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -1F,-0.35F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.26666668F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.TAIGA_CLIFFS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -1F,-0.35F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.TAIGA_CLIFFS)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -1F,-0.35F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.26666668F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.TAIGA_LOWLANDS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -1F,-0.35F), //humidity
                                        Climate.Parameter.span( 0.62F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.05F, 0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.TAIGA_LOWLANDS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -1F,-0.35F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.05F, 0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.TAIGA_LOWLANDS)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -1F, -0.35F), //humidity
                                        Climate.Parameter.span( -0.11F, 0.3F), //continentalness
                                        Climate.Parameter.span( -0.78F,  -0.375F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.7666667F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.TAIGA_FOREST)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -1F, -0.35F), //humidity
                                        Climate.Parameter.span( -0.11F, 0.3F), //continentalness
                                        Climate.Parameter.span( -0.2225F,  0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.7666667F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.TAIGA_MOUNTAIN_HILLS)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.1F,0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.26666668F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELF_VALLEY)),
                               Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.155F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.26666668F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELF_VALLEY)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.62F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.05F, 0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELF_VALLEY)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.115F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.62F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.05F, 0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELF_VALLEY)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.05F, 0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELF_VALLEY)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(-0.115F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.05F, 0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELF_VALLEY)),

//                                Pair.of(Climate.parameters(
//                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
//                                        Climate.Parameter.span( -0.1F,0.1F), //humidity
//                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
//                                        Climate.Parameter.span( -1F,  0.5650000000000001F), //erosion
//                                        Climate.Parameter.span( -0.005F, 0F), //depth
//                                        Climate.Parameter.span(0.05F, 0.26666668F), //weirdness
//                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELVEN_RIVER)),
//                                Pair.of(Climate.parameters(
//                                        Climate.Parameter.span(-0.155F, 0.2F), //temperature
//                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
//                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
//                                        Climate.Parameter.span( -1F,  0.5650000000000001F), //erosion
//                                        Climate.Parameter.span( -0.005F, 0F), //depth
//                                        Climate.Parameter.span(0.05F, 0.26666668F), //weirdness
//                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELVEN_RIVER)),
//                                Pair.of(Climate.parameters(
//                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
//                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
//                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
//                                        Climate.Parameter.span( -1F,  0.5650000000000001F), //erosion
//                                        Climate.Parameter.span( -0.005F, 0F), //depth
//                                        Climate.Parameter.span(0.05F, 0.26666668F), //weirdness
//                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELVEN_RIVER)),
//                                Pair.of(Climate.parameters(
//                                        Climate.Parameter.span(-0.115F, 0.2F), //temperature
//                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
//                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
//                                        Climate.Parameter.span( -1F,  0.5650000000000001F), //erosion
//                                        Climate.Parameter.span( -0.005F, 0F), //depth
//                                        Climate.Parameter.span(0.05F, 0.26666668F), //weirdness
//                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELVEN_RIVER)),
//                                Pair.of(Climate.parameters(
//                                        Climate.Parameter.span(-0.45F, 0.2F), //temperature
//                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
//                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
//                                        Climate.Parameter.span( -1F,  0.5650000000000001F), //erosion
//                                        Climate.Parameter.span( -0.005F, 0F), //depth
//                                        Climate.Parameter.span(0.05F, 0.26666668F), //weirdness
//                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELVEN_RIVER)),
//                                Pair.of(Climate.parameters(
//                                        Climate.Parameter.span(-0.115F, 0.2F), //temperature
//                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
//                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
//                                        Climate.Parameter.span( -1F,  0.5650000000000001F), //erosion
//                                        Climate.Parameter.span( -0.005F, 0F), //depth
//                                        Climate.Parameter.span(0.05F, 0.26666668F), //weirdness
//                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGH_ELVEN_RIVER)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(0.55F, 1F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -1.2F, -0.2F), //continentalness
                                        Climate.Parameter.span( -1F,  -0.78F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.GENSAI_REEF)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(0.55F, 1F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -1.2F, -0.2F), //continentalness
                                        Climate.Parameter.span( -0.2225F,  0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.GENSAI_REEF)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(0.55F, 1F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -1.2F, -0.2F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.GENSAI_REEF)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span(0.55F, 1F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -1.05F, -0.2F), //continentalness
                                        Climate.Parameter.span( -0.78F,  1F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.GENSAI_REEF)),




                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.155F, 0.2F), //temperature
                                        Climate.Parameter.span( 0.1F, 0.5650000000000001F), //humidity
                                        Climate.Parameter.span( 0.3F, 1F), //continentalness
                                        Climate.Parameter.span( 0.5650000000000001F,  1F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HAZE_MOUNTAIN)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.3F, 1F), //continentalness
                                        Climate.Parameter.span( 0.5650000000000001F,  1F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HAZE_MOUNTAIN)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.55F, 1F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( 0.3F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,  0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_VALLEY)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.55F, 1F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( 0.3F, 1F), //continentalness
                                        Climate.Parameter.span( 0.5650000000000001F,  1F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_VALLEY)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -0.455F, -0.2F), //continentalness
                                        Climate.Parameter.span( -1F,  1F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.FROZEN_OCEAN)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -1.2F, -0.455F), //continentalness
                                        Climate.Parameter.span( -1F,  -0.78F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.DEEP_FROZEN_OCEAN)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -1.2F, -0.455F), //continentalness
                                        Climate.Parameter.span( -0.2225F,   0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.DEEP_FROZEN_OCEAN)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -1.2F, -0.455F), //continentalness
                                        Climate.Parameter.span( 0.4F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.DEEP_FROZEN_OCEAN)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -1.05F, -0.455F), //continentalness
                                        Climate.Parameter.span( -0.78F,   1F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.DEEP_FROZEN_OCEAN)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -0.455F, -0.2F), //continentalness
                                        Climate.Parameter.span( -1F,   1F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.DEEP_FROZEN_OCEAN)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.45F, -0.155F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -0.455F, -0.2F), //continentalness
                                        Climate.Parameter.span( -1F,   1F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.COLD_OCEAN)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.45F, -0.155F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -1.2F, -0.455F), //continentalness
                                        Climate.Parameter.span( -1F,   -0.78F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.DEEP_COLD_OCEAN)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -0.455F, -0.2F), //continentalness
                                        Climate.Parameter.span( -1F,   1F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.LUKEWARM_OCEAN)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -1F, 1F), //humidity
                                        Climate.Parameter.span( -1.2F, -0.455F), //continentalness
                                        Climate.Parameter.span( -1F,   -0.78F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.DEEP_LUKEWARM_OCEAN)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.155F, 0.2F), //temperature
                                        Climate.Parameter.span( 0.5650000000000001F, 1F), //humidity
                                        Climate.Parameter.span( 0.3F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.OGRE_FOREST_VALLEY)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( 0.5650000000000001F, 1F), //humidity
                                        Climate.Parameter.span( 0.3F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.OGRE_FOREST_VALLEY)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.155F, 0.2F), //temperature
                                        Climate.Parameter.span( 0.3F, 1F), //humidity
                                        Climate.Parameter.span( 0.3F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.05F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.OGRE_FOREST_VALLEY)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( 0.5650000000000001F, 1F), //humidity
                                        Climate.Parameter.span( 0.62F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.05F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.OGRE_FOREST_VALLEY)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( 0.5650000000000001F, 1F), //humidity
                                        Climate.Parameter.span( 0.3F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.05F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.OGRE_FOREST_VALLEY)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.155F, 0.2F), //temperature
                                        Climate.Parameter.span( 0.5650000000000001F, 1F), //humidity
                                        Climate.Parameter.span( -0.2F, 0.62F), //continentalness
                                        Climate.Parameter.span( -0.2225F,   0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.OGRE_FOREST_GROVE)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.155F, 0.2F), //temperature
                                        Climate.Parameter.span( 0.5650000000000001F, 1F), //humidity
                                        Climate.Parameter.span( -0.2F, 0.62F), //continentalness
                                        Climate.Parameter.span( -0.2225F,   0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.OGRE_FOREST_GROVE)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( -0.2F, 0.03F), //continentalness
                                        Climate.Parameter.span( -0.2225F,   0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.26666668F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( -0.11F, 0.03F), //continentalness
                                        Climate.Parameter.span( -0.375F,   0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
                                        Climate.Parameter.span( -0.11F, 0.03F), //continentalness
                                        Climate.Parameter.span( 0.05F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.7273929370966008F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, -0.35F), //humidity
                                        Climate.Parameter.span( -0.11F, 0.03F), //continentalness
                                        Climate.Parameter.span( 0.05F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 0.62F), //continentalness
                                        Climate.Parameter.span( -0.375F,   0.4F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.7273929370966008F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, -0.35F), //humidity
                                        Climate.Parameter.span( 0.03F, 0.62F), //continentalness
                                        Climate.Parameter.span( -0.375F,   0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.7273929370966008F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( -0.375F,   -0.2225F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.56666666F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.62F, 1F), //continentalness
                                        Climate.Parameter.span( -0.375F,   -0.2225F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.7273929370966008F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.62F, 1F), //continentalness
                                        Climate.Parameter.span( -0.375F,   -0.2225F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.62F, 1F), //continentalness
                                        Climate.Parameter.span( 0.05F,   0.4F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( -0.2F, 0.03F), //continentalness
                                        Climate.Parameter.span( -0.375F,   0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.93333334F, -0.4F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
                                        Climate.Parameter.span( -0.2F, 0.03F), //continentalness
                                        Climate.Parameter.span( 0.05F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.93333334F, -0.4F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.7273929370966008F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, -0.35F), //humidity
                                        Climate.Parameter.span( -0.2F, 0.03F), //continentalness
                                        Climate.Parameter.span( 0.05F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.93333334F, -0.4F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.7273929370966008F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.3F, 0.62F), //continentalness
                                        Climate.Parameter.span( -0.2225F,   0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.93333334F, -0.4F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.7273929370966008F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.3F, 0.62F), //continentalness
                                        Climate.Parameter.span( -0.375F,   0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.56666666F, -0.4F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.7273929370966008F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.3F, 1F), //continentalness
                                        Climate.Parameter.span( -0.375F,   0.2225F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.4F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
                                        Climate.Parameter.span( -0.11F, 0.03F), //continentalness
                                        Climate.Parameter.span( -1F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.26666668F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.7273929370966008F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, -0.35F), //humidity
                                        Climate.Parameter.span( -0.11F, 0.03F), //continentalness
                                        Climate.Parameter.span( -1F,   -0.375F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.26666668F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.35F, -0.35F), //humidity
                                        Climate.Parameter.span( -0.11F, 0.03F), //continentalness
                                        Climate.Parameter.span( -0.375F,   0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.05F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -1F, -0.35F), //humidity
                                        Climate.Parameter.span( 0.3F, 1F), //continentalness
                                        Climate.Parameter.span( -0.375F,   -0.2225F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.05F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1.0047858741932016F, -0.45F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( -0.2F, 0.03F), //continentalness
                                        Climate.Parameter.span( -0.2225F,   0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.26666668F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.SNOW_PLAINS)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.155F, 0.2F), //temperature
                                        Climate.Parameter.span( 0.1F, 0.3F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.05F,   0.4F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGHLANDS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.155F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.62F, 1F), //continentalness
                                        Climate.Parameter.span( 0.05F,   0.4F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.05F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGHLANDS)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -0.155F, 0.2F), //temperature
                                        Climate.Parameter.span( -0.35F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.05F,   0.4F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.05F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HIGHLANDS)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.55F, 1F), //temperature
                                        Climate.Parameter.span( -1F, -0.35F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.05F,   0.4F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HOLY_ORC_DESERT)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.55F, 1F), //temperature
                                        Climate.Parameter.span( -1F, -0.35F), //humidity
                                        Climate.Parameter.span( 0.62F, 1F), //continentalness
                                        Climate.Parameter.span( 0.05F,   0.4F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.05F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HOLY_ORC_DESERT)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.55F, 1F), //temperature
                                        Climate.Parameter.span( -1F, -0.35F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.05F,   0.4F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(0.05F, 1F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.HOLY_ORC_DESERT)),

                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -1F, 0.1F), //humidity
                                        Climate.Parameter.span( -0.11F, 0.03F), //continentalness
                                        Climate.Parameter.span( 0.4F,   0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_MESA)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -1F, -0.585F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( -0.375F,   -0.2225F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.56666666F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_MESA)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 1F), //continentalness
                                        Climate.Parameter.span( 0.4F, 0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_MESA)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( -1F, -0.35F), //temperature
                                        Climate.Parameter.span( -0.1F, 0.1F), //humidity
                                        Climate.Parameter.span( 0.03F, 0.3F), //continentalness
                                        Climate.Parameter.span( 0.5650000000000001F, 1F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-1F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_MESA)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -1F, 0.1F), //humidity
                                        Climate.Parameter.span( -0.2F, 0.03F), //continentalness
                                        Climate.Parameter.span( 0.4F, 0.5650000000000001F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.93333334F, -0.4F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_MESA)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -1F, -0.585F), //humidity
                                        Climate.Parameter.span( 0.3F, 0.62F), //continentalness
                                        Climate.Parameter.span( -0.2225F, 0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.93333334F, -0.4F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_MESA)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -1F, -0.585F), //humidity
                                        Climate.Parameter.span( -0.11F, 0.03F), //continentalness
                                        Climate.Parameter.span( -1F, -0.78F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.56666666F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_MESA)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -1F, -0.585F), //humidity
                                        Climate.Parameter.span( 0.03F, 0.3F), //continentalness
                                        Climate.Parameter.span( -0.78F, -0.375F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.56666666F, -0.4F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_MESA)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -1F, -0.585F), //humidity
                                        Climate.Parameter.span( 0.3F, 0.62F), //continentalness
                                        Climate.Parameter.span( -0.375F, 0.05F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.56666666F, -0.4F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_MESA)),
                                Pair.of(Climate.parameters(
                                        Climate.Parameter.span( 0.2F, 0.55F), //temperature
                                        Climate.Parameter.span( -1F, -0.585F), //humidity
                                        Climate.Parameter.span( 0.62F, 1F), //continentalness
                                        Climate.Parameter.span( -0.375F, -0.2225F), //erosion
                                        Climate.Parameter.span( -0.005F, 0F), //depth
                                        Climate.Parameter.span(-0.56666666F, -0.05F), //weirdness
                                        0.0F), biomeRegistry.getOrThrow(EdumiaBiomes.ORC_MESA))

                                //
                                //            "weirdness": [
                                //              -0.4,
                                //              0.4
                                //            ],
                                //            "continentalness": [
                                //              0.03,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              -1,
                                //              -0.78
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              -0.4,
                                //              -0.05
                                //            ],
                                //            "continentalness": [
                                //              0.3,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              -0.78,
                                //              -0.2225
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              -0.26666668,
                                //              -0.05
                                //            ],
                                //            "continentalness": [
                                //              -0.11,
                                //              0.03
                                //            ],
                                //            "erosion": [
                                //              -0.78,
                                //              -0.375
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              -0.26666668,
                                //              -0.05
                                //            ],
                                //            "continentalness": [
                                //              -0.11,
                                //              0.03
                                //            ],
                                //            "erosion": [
                                //              -0.78,
                                //              -0.375
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              -0.26666668,
                                //              -0.05
                                //            ],
                                //            "continentalness": [
                                //              0.03,
                                //              0.3
                                //            ],
                                //            "erosion": [
                                //              0.4,
                                //              1
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.35
                                //            "weirdness": [
                                //              -0.26666668,
                                //              -0.05
                                //            ],
                                //            "continentalness": [
                                //              0.03,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              0.4,
                                //              0.5650000000000001
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -0.35,
                                //              0.1
                                //            "weirdness": [
                                //              -0.26666668,
                                //              -0.05
                                //            ],
                                //            "continentalness": [
                                //              0.3,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              0.4,
                                //              0.5650000000000001
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              0.1
                                //            "weirdness": [
                                //              -0.05,
                                //              0.05
                                //            ],
                                //            "continentalness": [
                                //              0.03,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              -0.78,
                                //              -0.375
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              -0.05,
                                //              0.26666668
                                //            ],
                                //            "continentalness": [
                                //              0.62,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              0.4,
                                //              0.5650000000000001
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              0.1
                                //            "weirdness": [
                                //              0.05,
                                //              1
                                //            ],
                                //            "continentalness": [
                                //              -0.2,
                                //              0.03
                                //            ],
                                //            "erosion": [
                                //              0.4,
                                //              0.5650000000000001
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              0.1
                                //            "weirdness": [
                                //              0.05,
                                //              0.26666668
                                //            ],
                                //            "continentalness": [
                                //              -0.11,
                                //              0.03
                                //            ],
                                //            "erosion": [
                                //              -1,
                                //              -0.375
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //           "weirdness": [
                                //              0.05,
                                //              0.26666668
                                //            ],
                                //            "continentalness": [
                                //              0.03,
                                //              0.3
                                //            ],
                                //            "erosion": [
                                //              0.4,
                                //              1
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.35
                                //            "weirdness": [
                                //              0.05,
                                //              1
                                //            ],
                                //            "continentalness": [
                                //              0.03,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              0.4,
                                //              0.5650000000000001
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -0.35,
                                //              0.1
                                //            "weirdness": [
                                //              0.05,
                                //              0.4
                                //            ],
                                //            "continentalness": [
                                //              0.3,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              -0.78,
                                //              -0.2225
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              0.05,
                                //              0.26666668
                                //            ],
                                //            "continentalness": [
                                //              0.3,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              0.4,
                                //              0.5650000000000001
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              0.1
                                //            "weirdness": [
                                //              0.26666668,
                                //              0.56666666
                                //            ],
                                //            "continentalness": [
                                //              -0.11,
                                //              0.03
                                //            ],
                                //            "erosion": [
                                //              -1,
                                //              -0.78
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              0.26666668,
                                //              1
                                //            ],
                                //            "continentalness": [
                                //              0.03,
                                //              0.3
                                //            ],
                                //            "erosion": [
                                //              0.5650000000000001,
                                //              1
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.35
                                //            "weirdness": [
                                //              0.4,
                                //              0.56666666
                                //            ],
                                //            "continentalness": [
                                //              0.03,
                                //              0.3
                                //            ],
                                //            "erosion": [
                                //              -0.78,
                                //              -0.375
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              0.4,
                                //              0.93333334
                                //            ],
                                //            "continentalness": [
                                //              0.3,
                                //              0.62
                                //            ],
                                //            "erosion": [
                                //              -0.375,
                                //              0.05
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              0.4,
                                //              1
                                //            ],
                                //            "continentalness": [
                                //              0.62,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              -0.375,
                                //              -0.2225
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              0.56666666,
                                //              1
                                //            ],
                                //            "continentalness": [
                                //              0.03,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              -0.375,
                                //              -0.2225
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              0.7666667,
                                //              1
                                //            ],
                                //            "continentalness": [
                                //              -0.11,
                                //              0.03
                                //            ],
                                //            "erosion": [
                                //              -1,
                                //              -0.78
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              0.7666667,
                                //              0.93333334
                                //            ],
                                //            "continentalness": [
                                //              0.03,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              -0.78,
                                //              -0.2225
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              0.93333334,
                                //              1
                                //            ],
                                //            "continentalness": [
                                //              0.03,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              -1,
                                //              -0.78
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            "weirdness": [
                                //              0.93333334,
                                //              1
                                //            ],
                                //            "continentalness": [
                                //              0.3,
                                //              1
                                //            ],
                                //            "erosion": [
                                //              -0.78,
                                //              -0.2225
                                //            ],
                                //            "temperature": [
                                //              0.2,
                                //              0.55
                                //            ],
                                //            "humidity": [
                                //              -1,
                                //              -0.585
                                //            ],
                        ))),
                noiseGenSettings.getOrThrow(NoiseGeneratorSettings.OVERWORLD));

        LevelStem stem = new LevelStem(dimTypes.getOrThrow(EdumiaDimensions.EDUMIA_TYPE), noiseBasedChunkGenerator);

        context.register(EDUMIA_KEY, stem);
    }


    public static Component getDisplayName(ResourceKey<Level> dimensionWorldKey) {
        ResourceLocation dimensionName = dimensionWorldKey.location();
        String key = String.format("dimension.%s.%s", dimensionName.getNamespace(), dimensionName.getPath());
        return Component.translatable(key);
    }

    public static ResourceKey<Level> getCurrentEdumiaDimensionOfFallback(Level level) {
        Level dimension = level;
        return dimension instanceof EdumiaDimensionType ? level.dimension() : EDUMIA_LEVEL_KEY;
    }

    public static int getHighestYAtXZ(int x, int z) {
        return (int) EdumiaHeightMap.getHeight(x, z);
    }
}
