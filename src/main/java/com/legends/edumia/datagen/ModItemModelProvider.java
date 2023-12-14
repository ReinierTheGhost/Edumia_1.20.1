package com.legends.edumia.datagen;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.core.ItemLoader;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.legends.edumia.Edumia.prefix;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, Edumia.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        verticalCornerBlock(BlockLoader.BLACK_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.BLUE_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.BROWN_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.CYAN_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.GRAY_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.GREEN_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.LIGHT_BLUE_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.LIGHT_GRAY_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.LIME_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.MAGENTA_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.ORANGE_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.PINK_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.PURPLE_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.RED_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.WHITE_CLAY_TILING_VERTICAL_CORNER.get());
        verticalCornerBlock(BlockLoader.YELLOW_CLAY_TILING_VERTICAL_CORNER.get());

        archBlock(BlockLoader.GREEN_BASALT_ROUND_ARCH.get());
        archBlock(BlockLoader.GREEN_BASALT_GOTHIC_ARCH.get());
        archBlock(BlockLoader.GREEN_BASALT_SEGMENTAL_ARCH.get());

        archBlock(BlockLoader.HIGH_ELVEN_BRICKS_ROUND_ARCH.get());
        archBlock(BlockLoader.HIGH_ELVEN_BRICKS_SEGMENTAL_ARCH.get());
        archBlock(BlockLoader.HIGH_ELVEN_BRICKS_GOTHIC_ARCH.get());
        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BRICKS_SMALL_ARCH);
        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BRICKS_TWO_METER_ARCH);

        layerBlock(BlockLoader.SAND_LAYER.get());
        layerBlock(BlockLoader.RED_SAND_LAYER.get());
        layerBlock(BlockLoader.WHITE_SAND_LAYER.get());

        simpleItem(ItemLoader.TEA_CINNAMON_STICK);
        simpleItem(ItemLoader.TEA_WHITE_DRAGON_PETALS);
        simpleItem(ItemLoader.TEA_LEAF);
        simpleItem(ItemLoader.TEA_HIBISCUS_PETALS);
        simpleItem(ItemLoader.TEA_JASMINE_PETALS);
        simpleItem(ItemLoader.TEA_LILY_PETALS);
        simpleItem(ItemLoader.TEA_MINT_LEAVES);
        simpleItem(ItemLoader.TEA_SAKURA_PETALS);
        simpleItem(ItemLoader.TEA_WHITE_JADE_PETALS);
        simpleItem(ItemLoader.RICE_BALL);

        reedItem(BlockLoader.REEDS);
        reedItem(BlockLoader.DRIED_REEDS);
        reedItem(BlockLoader.PAPYRUS);

        simpleItem(ItemLoader.ALEXANDRITE);
        simpleItem(ItemLoader.RAW_ALEXANDRITE);
        simpleItem(ItemLoader.GEM_FINE_AMBER);
        simpleItem(ItemLoader.GEM_FLAWED_AMBER);
        simpleItem(ItemLoader.GEM_FLAWLESS_AMBER);
        simpleItem(ItemLoader.GEM_PERFECT_AMBER);
        simpleItem(ItemLoader.GEM_ROUGH_AMBER);
        simpleItem(ItemLoader.GEM_FINE_AMETHYST);
        simpleItem(ItemLoader.GEM_FLAWED_AMETHYST);
        simpleItem(ItemLoader.GEM_FLAWLESS_AMETHYST);
        simpleItem(ItemLoader.GEM_PERFECT_AMETHYST);
        simpleItem(ItemLoader.GEM_ROUGH_AMETHYST);
        simpleItem(ItemLoader.GEM_FINE_JADE);
        simpleItem(ItemLoader.GEM_FLAWED_JADE);
        simpleItem(ItemLoader.GEM_FLAWLESS_JADE);
        simpleItem(ItemLoader.GEM_PERFECT_JADE);
        simpleItem(ItemLoader.GEM_ROUGH_JADE);
        simpleItem(ItemLoader.GEM_FINE_JASPER);
        simpleItem(ItemLoader.GEM_FLAWED_JASPER);
        simpleItem(ItemLoader.GEM_FLAWLESS_JASPER);
        simpleItem(ItemLoader.GEM_PERFECT_JASPER);
        simpleItem(ItemLoader.GEM_ROUGH_JASPER);
        simpleItem(ItemLoader.GEM_FINE_RUBY);
        simpleItem(ItemLoader.GEM_FLAWED_RUBY);
        simpleItem(ItemLoader.GEM_FLAWLESS_RUBY);
        simpleItem(ItemLoader.GEM_PERFECT_RUBY);
        simpleItem(ItemLoader.GEM_ROUGH_RUBY);
        simpleItem(ItemLoader.GEM_FINE_SAPPHIRE);
        simpleItem(ItemLoader.GEM_FLAWED_SAPPHIRE);
        simpleItem(ItemLoader.GEM_FLAWLESS_SAPPHIRE);
        simpleItem(ItemLoader.GEM_PERFECT_SAPPHIRE);
        simpleItem(ItemLoader.GEM_ROUGH_SAPPHIRE);
        simpleItem(ItemLoader.GEM_FINE_TOPAZ);
        simpleItem(ItemLoader.GEM_FLAWED_TOPAZ);
        simpleItem(ItemLoader.GEM_FLAWLESS_TOPAZ);
        simpleItem(ItemLoader.GEM_PERFECT_TOPAZ);
        simpleItem(ItemLoader.GEM_ROUGH_TOPAZ);

        evenSimplerBlockItem(BlockLoader.BRICK_PILLAR);
        evenSimplerBlockItem(BlockLoader.STONE_PILLAR);
        evenSimplerBlockItem(BlockLoader.CHALK_PILLAR);
        evenSimplerBlockItem(BlockLoader.RED_PILLAR);
        evenSimplerBlockItem(BlockLoader.CACHOLONG_PILLAR);
        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_PILLAR);
        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_PILLAR);
        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_PILLAR);

        evenSimplerBlockItem(BlockLoader.BASALT_BRICKS_SLAB);
        evenSimplerBlockItem(BlockLoader.BASALT_BRICKS_STAIRS);
        wallItem(BlockLoader.BASALT_BRICKS_WALL, BlockLoader.BASALT_BRICKS);

        evenSimplerBlockItem(BlockLoader.GREEN_BASALT_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.GREEN_BASALT_BRICKS_STAIRS);
        wallItem(BlockLoader.GREEN_BASALT_BRICKS_WALL, BlockLoader.GREEN_BASALT_BRICKS);

        evenSimplerBlockItem(BlockLoader.GREEN_BASALT_COBBLESTONE_SLAB);
        evenSimplerBlockItem( BlockLoader.GREEN_BASALT_COBBLESTONE_STAIRS);
        wallItem(BlockLoader.GREEN_BASALT_COBBLESTONE_WALL, BlockLoader.GREEN_BASALT_COBBLESTONE);

        evenSimplerBlockItem(BlockLoader.GREEN_BASALT_SLAB);
        evenSimplerBlockItem( BlockLoader.GREEN_BASALT_STAIRS);
        wallItem(BlockLoader.GREEN_BASALT_WALL, BlockLoader.GREEN_BASALT);

        evenSimplerBlockItem(BlockLoader.LIGHT_GRAY_STONE_SLAB);
        evenSimplerBlockItem( BlockLoader.LIGHT_GRAY_STONE_STAIRS);
        wallItem(BlockLoader.LIGHT_GRAY_STONE_WALL, BlockLoader.LIGHT_GRAY_STONE);

        evenSimplerBlockItem(BlockLoader.LIGHT_GRAY_STONE_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.LIGHT_GRAY_STONE_BRICKS_STAIRS);
        wallItem(BlockLoader.LIGHT_GRAY_STONE_BRICKS_WALL, BlockLoader.LIGHT_GRAY_STONE_BRICKS);

        evenSimplerBlockItem(BlockLoader.BROWN_STONE_SLAB);
        evenSimplerBlockItem( BlockLoader.BROWN_STONE_STAIRS);
        wallItem(BlockLoader.BROWN_STONE_WALL, BlockLoader.BROWN_STONE);

        evenSimplerBlockItem(BlockLoader.BLUE_STONE_SLAB);
        evenSimplerBlockItem( BlockLoader.BLUE_STONE_STAIRS);
        wallItem(BlockLoader.BLUE_STONE_WALL, BlockLoader.BLUE_STONE);

        evenSimplerBlockItem(BlockLoader.YELLOW_STONE_SLAB);
        evenSimplerBlockItem( BlockLoader.YELLOW_STONE_STAIRS);
        wallItem(BlockLoader.YELLOW_STONE_WALL, BlockLoader.YELLOW_STONE);

        evenSimplerBlockItem(BlockLoader.YELLOW_STONE_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.YELLOW_STONE_BRICKS_STAIRS);
        wallItem(BlockLoader.YELLOW_STONE_BRICKS_WALL, BlockLoader.YELLOW_STONE_BRICKS);

        evenSimplerBlockItem(BlockLoader.YELLOW_STONE_2_SLAB);
        evenSimplerBlockItem( BlockLoader.YELLOW_STONE_2_STAIRS);
        wallItem(BlockLoader.YELLOW_STONE_2_WALL, BlockLoader.YELLOW_STONE_2);

        evenSimplerBlockItem(BlockLoader.YELLOW_STONE_BRICKS_2_SLAB);
        evenSimplerBlockItem( BlockLoader.YELLOW_STONE_BRICKS_2_STAIRS);
        wallItem(BlockLoader.YELLOW_STONE_BRICKS_2_WALL, BlockLoader.YELLOW_STONE_BRICKS_2);

        evenSimplerBlockItem(BlockLoader.CRACKED_GREEN_BASALT_SLAB);
        evenSimplerBlockItem( BlockLoader.CRACKED_GREEN_BASALT_STAIRS);
        wallItem(BlockLoader.CRACKED_GREEN_BASALT_WALL, BlockLoader.CRACKED_GREEN_BASALT);

        evenSimplerBlockItem(BlockLoader.LIMESTONE_SLAB);
        evenSimplerBlockItem( BlockLoader.LIMESTONE_STAIRS);
        wallItem(BlockLoader.LIMESTONE_WALL, BlockLoader.LIMESTONE);

        evenSimplerBlockItem(BlockLoader.GNEISS_SLAB);
        evenSimplerBlockItem( BlockLoader.GNEISS_STAIRS);
        wallItem(BlockLoader.GNEISS_WALL, BlockLoader.GNEISS);

        evenSimplerBlockItem(BlockLoader.MOSSY_BASALT_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_BASALT_BRICKS_STAIRS);
        wallItem(BlockLoader.MOSSY_BASALT_BRICKS_WALL, BlockLoader.MOSSY_BASALT_BRICKS);

        evenSimplerBlockItem(BlockLoader.BLUE_BRICK_SLAB);
        evenSimplerBlockItem( BlockLoader.BLUE_BRICK_STAIRS);
        wallItem(BlockLoader.BLUE_BRICK_WALL, BlockLoader.BLUE_BRICK);

        evenSimplerBlockItem(BlockLoader.CYAN_STONE_SLAB);
        evenSimplerBlockItem( BlockLoader.CYAN_STONE_STAIRS);
        wallItem(BlockLoader.CYAN_STONE_WALL, BlockLoader.CYAN_STONE);

        evenSimplerBlockItem(BlockLoader.ORANGE_ROCK_SLAB);
        evenSimplerBlockItem( BlockLoader.ORANGE_ROCK_STAIRS);
        wallItem(BlockLoader.ORANGE_ROCK_WALL, BlockLoader.ORANGE_ROCK);

        evenSimplerBlockItem(BlockLoader.RED_ROCK_SLAB);
        evenSimplerBlockItem( BlockLoader.RED_ROCK_STAIRS);
        wallItem(BlockLoader.RED_ROCK_WALL, BlockLoader.RED_ROCK);


        evenSimplerBlockItem(BlockLoader.YELLOW_COBBLE_SLAB);
        evenSimplerBlockItem( BlockLoader.YELLOW_COBBLE_STAIRS);
        wallItem(BlockLoader.YELLOW_COBBLE_WALL, BlockLoader.YELLOW_COBBLE);

        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.HIGH_ELVEN_BRICKS_WALL, BlockLoader.HIGH_ELVEN_BRICKS);
        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BRICK_ARROWSLIT);
        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BALUSTRADE);

        evenSimplerBlockItem(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_WALL, BlockLoader.CRACKED_HIGH_ELVEN_BRICKS);

        evenSimplerBlockItem(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_WALL, BlockLoader.MOSSY_HIGH_ELVEN_BRICKS);

        evenSimplerBlockItem(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.SMALL_HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_WALL, BlockLoader.SMALL_HIGH_ELVEN_BRICKS);

        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_WALL, BlockLoader.LIGHT_HIGH_ELVEN_BRICKS);
        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_BALUSTRADE);

        evenSimplerBlockItem(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_WALL, BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS);

        evenSimplerBlockItem(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_WALL, BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS);

        evenSimplerBlockItem(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_WALL, BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS);

        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.DARK_HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.DARK_HIGH_ELVEN_BRICKS_WALL, BlockLoader.DARK_HIGH_ELVEN_BRICKS);
        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_BALUSTRADE);

        evenSimplerBlockItem(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_WALL, BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS);

        evenSimplerBlockItem(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_WALL, BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS);

        evenSimplerBlockItem(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_STAIRS);
        wallItem(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_WALL, BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS);

        evenSimplerBlockItem(BlockLoader.RED_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.RED_BRICKS_STAIRS);
        wallItem(BlockLoader.RED_BRICKS_WALL, BlockLoader.RED_BRICKS);

        evenSimplerBlockItem(BlockLoader.CRACKED_RED_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CRACKED_RED_BRICKS_STAIRS);
        wallItem(BlockLoader.CRACKED_RED_BRICKS_WALL, BlockLoader.CRACKED_RED_BRICKS);

        evenSimplerBlockItem(BlockLoader.MOSSY_RED_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_RED_BRICKS_STAIRS);
        wallItem(BlockLoader.MOSSY_RED_BRICKS_WALL, BlockLoader.MOSSY_RED_BRICKS);

        evenSimplerBlockItem(BlockLoader.BLUE_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.BLUE_BRICKS_STAIRS);
        wallItem(BlockLoader.BLUE_BRICKS_WALL, BlockLoader.BLUE_BRICKS);

        evenSimplerBlockItem(BlockLoader.CRACKED_BLUE_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CRACKED_BLUE_BRICKS_STAIRS);
        wallItem(BlockLoader.CRACKED_BLUE_BRICKS_WALL, BlockLoader.CRACKED_BLUE_BRICKS);

        evenSimplerBlockItem(BlockLoader.MOSSY_BLUE_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_BLUE_BRICKS_STAIRS);
        wallItem(BlockLoader.MOSSY_BLUE_BRICKS_WALL, BlockLoader.MOSSY_BLUE_BRICKS);

        evenSimplerBlockItem(BlockLoader.DEMON_BASALT_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.DEMON_BASALT_BRICKS_STAIRS);
        wallItem(BlockLoader.DEMON_BASALT_BRICKS_WALL, BlockLoader.DEMON_BASALT_BRICKS);

        evenSimplerBlockItem(BlockLoader.VULCANIC_DEMON_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.VULCANIC_DEMON_BRICKS_STAIRS);
        wallItem(BlockLoader.VULCANIC_DEMON_BRICKS_WALL, BlockLoader.VULCANIC_DEMON_BRICKS);

        evenSimplerBlockItem(BlockLoader.VULCANIC_ROCK_SLAB);
        evenSimplerBlockItem( BlockLoader.VULCANIC_ROCK_STAIRS);
        wallItem(BlockLoader.VULCANIC_ROCK_WALL, BlockLoader.VULCANIC_ROCK);

        evenSimplerBlockItem(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_STAIRS);
        wallItem(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_WALL, BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS);

        evenSimplerBlockItem(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_STAIRS);
        wallItem(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_WALL, BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS);

        evenSimplerBlockItem(BlockLoader.CACHOLONG_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CACHOLONG_BRICKS_STAIRS);
        wallItem(BlockLoader.CACHOLONG_BRICKS_WALL, BlockLoader.CACHOLONG_BRICKS);

        evenSimplerBlockItem(BlockLoader.CRACKED_CACHOLONG_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CRACKED_CACHOLONG_BRICKS_STAIRS);
        wallItem(BlockLoader.CRACKED_CACHOLONG_BRICKS_WALL, BlockLoader.CRACKED_CACHOLONG_BRICKS);

        evenSimplerBlockItem(BlockLoader.MOSSY_CACHOLONG_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_CACHOLONG_BRICKS_STAIRS);
        wallItem(BlockLoader.MOSSY_CACHOLONG_BRICKS_WALL, BlockLoader.MOSSY_CACHOLONG_BRICKS);

        evenSimplerBlockItem(BlockLoader.BLACK_DEMON_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.BLACK_DEMON_BRICKS_STAIRS);
        wallItem(BlockLoader.BLACK_DEMON_BRICKS_WALL, BlockLoader.BLACK_DEMON_BRICKS);

        evenSimplerBlockItem(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CRACKED_BLACK_DEMON_BRICKS_STAIRS);
        wallItem(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_WALL, BlockLoader.CRACKED_BLACK_DEMON_BRICKS);

        evenSimplerBlockItem(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_BLACK_DEMON_BRICKS_STAIRS);
        wallItem(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_WALL, BlockLoader.MOSSY_BLACK_DEMON_BRICKS);

        evenSimplerBlockItem(BlockLoader.BROWN_SANDSTONE_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.BROWN_SANDSTONE_BRICKS_STAIRS);
        wallItem(BlockLoader.BROWN_SANDSTONE_BRICKS_WALL, BlockLoader.BROWN_SANDSTONE_BRICKS);

        evenSimplerBlockItem(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_STAIRS);
        wallItem(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_WALL, BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS);

        evenSimplerBlockItem(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_STAIRS);
        wallItem(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_WALL, BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS);

        evenSimplerBlockItem(BlockLoader.DESERT_MUD_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.DESERT_MUD_BRICKS_STAIRS);
        wallItem(BlockLoader.DESERT_MUD_BRICKS_WALL, BlockLoader.DESERT_MUD_BRICKS);

        evenSimplerBlockItem(BlockLoader.CRACKED_DESERT_MUD_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CRACKED_DESERT_MUD_BRICKS_STAIRS);
        wallItem(BlockLoader.CRACKED_DESERT_MUD_BRICKS_WALL, BlockLoader.CRACKED_DESERT_MUD_BRICKS);

        evenSimplerBlockItem(BlockLoader.MOSSY_DESERT_MUD_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_DESERT_MUD_BRICKS_STAIRS);
        wallItem(BlockLoader.MOSSY_DESERT_MUD_BRICKS_WALL, BlockLoader.MOSSY_DESERT_MUD_BRICKS);

        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_COBBLESTONE_SLAB);
        evenSimplerBlockItem( BlockLoader.HIGH_ELVEN_COBBLESTONE_STAIRS);
        wallItem(BlockLoader.HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.HIGH_ELVEN_COBBLESTONE);

        evenSimplerBlockItem(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_STAIRS);
        wallItem(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE);

        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB);
        evenSimplerBlockItem( BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS);
        wallItem(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE);

        evenSimplerBlockItem(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS);
        wallItem(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE);

        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_SLAB);
        evenSimplerBlockItem( BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_STAIRS);
        wallItem(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE);

        evenSimplerBlockItem(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_SLAB);
        evenSimplerBlockItem( BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_STAIRS);
        wallItem(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_WALL, BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE);


        evenSimplerBlockItem(BlockLoader.CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.BLACK_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.BLUE_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.BROWN_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.CYAN_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.GRAY_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.GREEN_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.LIGHT_BLUE_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.LIGHT_GRAY_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.LIME_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.MAGENTA_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.ORANGE_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.PINK_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.PURPLE_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.RED_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.WHITE_CLAY_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.YELLOW_CLAY_TILING_SLAB);

        evenSimplerBlockItem(BlockLoader.BLACK_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.BLUE_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.BROWN_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.CYAN_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.GRAY_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.GREEN_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.LIGHT_BLUE_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.LIGHT_GRAY_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.LIME_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.MAGENTA_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.ORANGE_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.PINK_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.PURPLE_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.RED_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.WHITE_CLAY_TILING_STAIRS);
        evenSimplerBlockItem(BlockLoader.YELLOW_CLAY_TILING_STAIRS);



        evenSimplerBlockItem(BlockLoader.CHALK_SLAB);
        evenSimplerBlockItem( BlockLoader.CHALK_STAIRS);
        wallItem(BlockLoader.CHALK_WALL, BlockLoader.CHALK);

        evenSimplerBlockItem(BlockLoader.CHALK_BRICKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CHALK_BRICKS_STAIRS);
        wallItem(BlockLoader.CHALK_BRICKS_WALL, BlockLoader.CHALK_BRICKS);


        evenSimplerBlockItem(BlockLoader.APPLE_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.APPLE_PLANKS_STAIRS);
        fenceItem(BlockLoader.APPLE_FENCE, BlockLoader.APPLE_PLANKS);
        evenSimplerBlockItem(BlockLoader.APPLE_FENCE_GATE);

        saplingItem(BlockLoader.APPLE_SAPLING);

        evenSimplerBlockItem(BlockLoader.ASPEN_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.ASPEN_PLANKS_STAIRS);
        fenceItem(BlockLoader.ASPEN_FENCE, BlockLoader.ASPEN_PLANKS);
        evenSimplerBlockItem(BlockLoader.ASPEN_FENCE_GATE);

        saplingItem(BlockLoader.ASPEN_SAPLING);

        evenSimplerBlockItem(BlockLoader.BAOBAB_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.BAOBAB_PLANKS_STAIRS);
        fenceItem(BlockLoader.BAOBAB_FENCE, BlockLoader.BAOBAB_PLANKS);
        evenSimplerBlockItem(BlockLoader.BAOBAB_FENCE_GATE);

        evenSimplerBlockItem(BlockLoader.BEECH_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.BEECH_PLANKS_STAIRS);
        fenceItem(BlockLoader.BEECH_FENCE, BlockLoader.BEECH_PLANKS);
        evenSimplerBlockItem(BlockLoader.BEECH_FENCE_GATE);

        saplingItem(BlockLoader.BEECH_SAPLING);

        evenSimplerBlockItem(BlockLoader.CEDAR_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CEDAR_PLANKS_STAIRS);
        fenceItem(BlockLoader.CEDAR_FENCE, BlockLoader.CEDAR_PLANKS);
        evenSimplerBlockItem(BlockLoader.CEDAR_FENCE_GATE);

        saplingItem(BlockLoader.CEDAR_SAPLING);

        evenSimplerBlockItem(BlockLoader.CHERRY_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CHERRY_PLANKS_STAIRS);
        fenceItem(BlockLoader.CHERRY_FENCE, BlockLoader.CHERRY_PLANKS);
        evenSimplerBlockItem(BlockLoader.CHERRY_FENCE_GATE);

        saplingItem(BlockLoader.CHERRY_SAPLING);
        evenSimplerBlockItem(BlockLoader.CYPRESS_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.CYPRESS_PLANKS_STAIRS);
        fenceItem(BlockLoader.CYPRESS_FENCE, BlockLoader.CYPRESS_PLANKS);
        evenSimplerBlockItem(BlockLoader.CYPRESS_FENCE_GATE);

        saplingItem(BlockLoader.CYPRESS_SAPLING);

        evenSimplerBlockItem(BlockLoader.FIR_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.FIR_PLANKS_STAIRS);
        fenceItem(BlockLoader.FIR_FENCE, BlockLoader.FIR_PLANKS);
        evenSimplerBlockItem(BlockLoader.FIR_FENCE_GATE);

        saplingItem(BlockLoader.FIR_SAPLING);

        evenSimplerBlockItem(BlockLoader.GREEN_OAK_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.GREEN_OAK_PLANKS_STAIRS);
        fenceItem(BlockLoader.GREEN_OAK_FENCE, BlockLoader.GREEN_OAK_PLANKS);
        evenSimplerBlockItem(BlockLoader.GREEN_OAK_FENCE_GATE);

        saplingItem(BlockLoader.GREEN_OAK_SAPLING);

        evenSimplerBlockItem(BlockLoader.HOLLY_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.HOLLY_PLANKS_STAIRS);
        fenceItem(BlockLoader.HOLLY_FENCE, BlockLoader.HOLLY_PLANKS);
        evenSimplerBlockItem(BlockLoader.HOLLY_FENCE_GATE);

        saplingItem(BlockLoader.HOLLY_SAPLING);

        evenSimplerBlockItem(BlockLoader.LARCH_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.LARCH_PLANKS_STAIRS);
        fenceItem(BlockLoader.LARCH_FENCE, BlockLoader.LARCH_PLANKS);
        evenSimplerBlockItem(BlockLoader.LARCH_FENCE_GATE);

        saplingItem(BlockLoader.LARCH_SAPLING);

        evenSimplerBlockItem(BlockLoader.MAPLE_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.MAPLE_PLANKS_STAIRS);
        fenceItem(BlockLoader.MAPLE_FENCE, BlockLoader.MAPLE_PLANKS);
        evenSimplerBlockItem(BlockLoader.MAPLE_FENCE_GATE);

        saplingItem(BlockLoader.MAPLE_SAPLING);

        evenSimplerBlockItem(BlockLoader.BLACKTHORN_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.BLACKTHORN_PLANKS_STAIRS);
        fenceItem(BlockLoader.BLACKTHORN_FENCE, BlockLoader.BLACKTHORN_PLANKS);
        evenSimplerBlockItem(BlockLoader.BLACKTHORN_FENCE_GATE);

        saplingItem(BlockLoader.BLACKTHORN_SAPLING);

        evenSimplerBlockItem(BlockLoader.GHOST_GUM_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.GHOST_GUM_PLANKS_STAIRS);
        fenceItem(BlockLoader.GHOST_GUM_FENCE, BlockLoader.GHOST_GUM_PLANKS);
        evenSimplerBlockItem(BlockLoader.GHOST_GUM_FENCE_GATE);

        saplingItem(BlockLoader.GHOST_GUM_SAPLING);

        evenSimplerBlockItem(BlockLoader.WHITE_ASH_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.WHITE_ASH_PLANKS_STAIRS);
        fenceItem(BlockLoader.WHITE_ASH_FENCE, BlockLoader.WHITE_ASH_PLANKS);
        evenSimplerBlockItem(BlockLoader.WHITE_ASH_FENCE_GATE);

        saplingItem(BlockLoader.WHITE_ASH_SAPLING);



        evenSimplerBlockItem(BlockLoader.SILVER_SPRUCE_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.SILVER_SPRUCE_PLANKS_STAIRS);
        fenceItem(BlockLoader.SILVER_SPRUCE_FENCE, BlockLoader.SILVER_SPRUCE_PLANKS);
        evenSimplerBlockItem(BlockLoader.SILVER_SPRUCE_FENCE_GATE);

        saplingItem(BlockLoader.SILVER_SPRUCE_SAPLING);

        evenSimplerBlockItem(BlockLoader.OKOME_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.OKOME_PLANKS_STAIRS);
        fenceItem(BlockLoader.OKOME_FENCE, BlockLoader.OKOME_PLANKS);
        evenSimplerBlockItem(BlockLoader.OKOME_FENCE_GATE);

        evenSimplerBlockItem(BlockLoader.PEAR_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.PEAR_PLANKS_STAIRS);
        fenceItem(BlockLoader.PEAR_FENCE, BlockLoader.PEAR_PLANKS);
        evenSimplerBlockItem(BlockLoader.PEAR_FENCE_GATE);

        saplingItem(BlockLoader.PEAR_SAPLING);

        evenSimplerBlockItem(BlockLoader.PINE_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.PINE_PLANKS_STAIRS);
        fenceItem(BlockLoader.PINE_FENCE, BlockLoader.PINE_PLANKS);
        evenSimplerBlockItem(BlockLoader.PINE_FENCE_GATE);

        saplingItem(BlockLoader.PINE_SAPLING);

        evenSimplerBlockItem(BlockLoader.PLUM_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.PLUM_PLANKS_STAIRS);
        fenceItem(BlockLoader.PLUM_FENCE, BlockLoader.PLUM_PLANKS);
        evenSimplerBlockItem(BlockLoader.PLUM_FENCE_GATE);

        evenSimplerBlockItem(BlockLoader.RED_OAK_PLANKS_SLAB);
        evenSimplerBlockItem( BlockLoader.RED_OAK_PLANKS_STAIRS);
        fenceItem(BlockLoader.RED_OAK_FENCE, BlockLoader.RED_OAK_PLANKS);
        evenSimplerBlockItem(BlockLoader.RED_OAK_FENCE_GATE);

        saplingItem(BlockLoader.RED_OAK_SAPLING);
        toBlock(BlockLoader.REDWOOD_LOG.get());
        toBlock(BlockLoader.STRIPPED_REDWOOD_LOG.get());
        toBlock(BlockLoader.REDWOOD_WOOD.get());
        toBlock(BlockLoader.STRIPPED_REDWOOD_WOOD.get());
        saplingItem(BlockLoader.REDWOOD_SAPLING);
        woodBlock(BlockLoader.REDWOOD_PLANKS.get());
        woodBlock(BlockLoader.REDWOOD_PLANKS_STAIRS.get());
        woodBlock(BlockLoader.REDWOOD_PLANKS_SLAB.get());
        woodenButton(BlockLoader.REDWOOD_BUTTON.get(), "redwood");
        woodenFence(BlockLoader.REDWOOD_FENCE.get(), "redwood");
        woodBlock(BlockLoader.REDWOOD_FENCE_GATE.get());
        woodBlock(BlockLoader.REDWOOD_PRESSURE_PLATE.get());
        woodBlockModel(BlockLoader.REDWOOD_TRAPDOOR.get(), "redwood_trapdoor_bottom");
        withExistingParent(BlockLoader.REDWOOD_BANISTER.getId().toString(), prefix("item/banister_item"))
                .texture("texture", "block/redwood_planks");
        withExistingParent(BlockLoader.REDWOOD_BALUSTRADE.getId().toString(), prefix("block/redwood_balustrade"));
        simpleDoorItem(BlockLoader.REDWOOD_DOOR);


        handheldItem(ItemLoader.ORC_AXE);
        handheldItem(ItemLoader.ORC_HOE);
        handheldItem(ItemLoader.ORC_PICKAXE);
        handheldItem(ItemLoader.ORC_SHOVEL);
        handheldItem(ItemLoader.ORC_SWORD);

        handheldItem(ItemLoader.MAN_AXE);
        handheldItem(ItemLoader.MAN_HOE);
        handheldItem(ItemLoader.MAN_PICKAXE);
        handheldItem(ItemLoader.MAN_SHOVEL);
        handheldItem(ItemLoader.MAN_SWORD);

        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_ROCK_SLAB);
        evenSimplerBlockItem( BlockLoader.HIGH_ELVEN_ROCK_STAIRS);
        wallItem(BlockLoader.HIGH_ELVEN_ROCK_WALL, BlockLoader.HIGH_ELVEN_ROCK);

        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_ROCK_SLAB);
        evenSimplerBlockItem( BlockLoader.DARK_HIGH_ELVEN_ROCK_STAIRS);
        wallItem(BlockLoader.DARK_HIGH_ELVEN_ROCK_WALL, BlockLoader.DARK_HIGH_ELVEN_ROCK);

        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_SLAB);
        evenSimplerBlockItem( BlockLoader.LIGHT_HIGH_ELVEN_ROCK_STAIRS);
        wallItem(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_WALL, BlockLoader.HIGH_ELVEN_ROCK);

        evenSimplerBlockItem(BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB);
        evenSimplerBlockItem( BlockLoader.HIGH_ELVEN_BRICK_TILING_STAIRS);
        //wallItem(BlockLoader.HIGH_ELVEN_BRICK_TILING_WALL, BlockLoader.HIGH_ELVEN_BRICK_TILING);

        evenSimplerBlockItem(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB);
        evenSimplerBlockItem( BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_STAIRS);
        //wallItem(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_WALL, BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING);

        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB);
        evenSimplerBlockItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS);
        //wallItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_WALL, BlockLoader.HIGH_ELVEN_BRICK_TILING);

        withExistingParent(ItemLoader.RHINO_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ItemLoader.BOAR_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ItemLoader.ALLIGATOR_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ItemLoader.BADGER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Edumia.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Edumia.MODID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Edumia.MODID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc
                        ("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Edumia.MODID, "block/" +
                        ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc
                        ("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Edumia.MODID, "block/" +
                        ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc
                        ("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Edumia.MODID, "block/" +
                        ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Edumia.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleDoorItem(RegistryObject<DoorBlock> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Edumia.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Edumia.MODID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder reedItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Edumia.MODID,"item/" + item.getId().getPath()));
    }

    private void toBlock(Block b) {
        toBlockModel(b, ForgeRegistries.BLOCKS.getKey(b).getPath());
    }

    private void woodBlock(Block b) {
        woodBlockModel(b, ForgeRegistries.BLOCKS.getKey(b).getPath());
    }

    private void toBlockModel(Block b, String model) {
        toBlockModel(b, prefix("block/" + model));
    }

    private void woodBlockModel(Block b, String model) {
        toBlockModel(b, prefix("block/" + model));
    }

    private void layerBlock(Block layer) {
        toBlockModel(layer, prefix("block/" + name(layer) + "_height2"));
    }

    private void archBlock(Block arch) {
        toBlockModel(arch, prefix("block/" + name(arch) + "_1"));
    }

    private void verticalCornerBlock(Block block) {
        toBlockModel(block, prefix("block/" + name(block) + "_4"));
    }

    private void toBlockModel(Block b, ResourceLocation model) {
        withExistingParent(ForgeRegistries.BLOCKS.getKey(b).getPath(), model);
    }

    private void woodenButton(Block button, String variant) {
        getBuilder(ForgeRegistries.BLOCKS.getKey(button).getPath())
                .parent(getExistingFile(mcLoc("block/button_inventory")))
                .texture("texture", "block/" + variant + "_planks");
    }

    private void woodenFence(Block fence, String variant) {
        getBuilder(ForgeRegistries.BLOCKS.getKey(fence).getPath())
                .parent(getExistingFile(mcLoc("block/fence_inventory")))
                .texture("texture", "block/" + variant + "_planks");
    }

    protected String name(Block block) {
        return key(block).getPath();
    }

    protected ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

}
