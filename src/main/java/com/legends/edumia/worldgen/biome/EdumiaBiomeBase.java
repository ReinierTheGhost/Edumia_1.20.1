package com.legends.edumia.worldgen.biome;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public abstract class EdumiaBiomeBase implements EdumiaBiomeWrapper {
    private ResourceLocation biomeName;

    private Biome actualBiome;

    private Biome.BiomeBuilder unbuiltBiome;

    //private BiomeAmbience.Builder unbuiltBiomeAmbience;

   // private final boolean isMajorBiome;

   // protected CustomBiomeColors biomeColors;

    protected static final int STANDARD_FOG_COLOR = 12638463;

    protected static final int STANDARD_WATER_FOG_COLOR = 329011;

    //protected static final PerlinNoiseGenerator SNOW_VARIETY_NOISE = makeSingleLayerPerlinNoise(2490309256000602L);

    private float treeDensityForPodzol;

    private int maxPodzolHeight = Integer.MAX_VALUE;

    //private WeightedRandomFeatureConfig grassBonemealGenerator;

    protected EdumiaBiomeBase(Biome.BiomeBuilder builder, int waterFogColor, boolean major) {
        this.unbuiltBiome = builder;
        //this.unbuiltBiomeAmbience = (new BiomeAmbience.Builder()).func_235246_b_(16777215).func_235248_c_(waterFogColor);
       //this.isMajorBiome = major;
        //this.biomeColors = new CustomBiomeColors(builder);
    }

    protected EdumiaBiomeBase(Biome.BiomeBuilder builder, boolean major) {
        this(builder, 329011, major);
    }

    public EdumiaBiomeBase setBiomeName(ResourceLocation name) {
        if (this.biomeName != null)
            throw new IllegalStateException("Cannot set biomeName for LOTRBiome " + this.biomeName + " - already set!");
        this.biomeName = name;
        return this;
    }

//    public Biome initialiseActualBiome() {
//        if (this.actualBiome != null)
//            throw new IllegalStateException("LOTRBiome object for " + this.biomeName + " is already initialised!");
//        setupBiomeAmbience(this.unbuiltBiomeAmbience);
//        this.unbuiltBiome.func_235097_a_(this.unbuiltBiomeAmbience.func_235238_a_());
//        this.unbuiltBiomeAmbience = null;
//        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder();
//        MiddleEarthSurfaceConfig surfaceBuilderConfig = MiddleEarthSurfaceConfig.createDefault();
//        setupSurface(surfaceBuilderConfig);
//        addFeatures(generationBuilder);
//        surfaceBuilderConfig
//                .setTreeDensityForPodzol(this.treeDensityForPodzol)
//                .setMaxPodzolHeight(this.maxPodzolHeight);
//        generationBuilder.func_242517_a(LOTRBiomes.MIDDLE_EARTH_SURFACE.func_242929_a((ISurfaceBuilderConfig)surfaceBuilderConfig));
//        this.unbuiltBiome.func_242457_a(generationBuilder.func_242508_a());
//        MobSpawnInfo.Builder entitySpawnBuilder = new MobSpawnInfo.Builder();
//        addAnimals(entitySpawnBuilder);
//        this.unbuiltBiome.func_242458_a(entitySpawnBuilder.func_242577_b());
//        this.actualBiome = this.unbuiltBiome.func_242455_a();
//        this.unbuiltBiome = null;
//        return this.actualBiome;
//    }
}
