package com.legends.edumia.datagen.loot;

import com.legends.edumia.block.AxialSlabBlock;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.core.ItemLoader;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    @Override
    protected void generate() {
        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICKS_ROUND_ARCH.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICKS_SEGMENTAL_ARCH.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICKS_GOTHIC_ARCH.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICKS_SMALL_ARCH.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICKS_TWO_METER_ARCH.get());

        this.dropSelf(BlockLoader.CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.BLACK_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.BLUE_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.BROWN_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.CYAN_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.GRAY_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.GREEN_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.LIGHT_BLUE_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.LIGHT_GRAY_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.LIME_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.MAGENTA_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.ORANGE_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.PINK_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.PURPLE_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.RED_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.WHITE_CLAY_TILING_VERTICAL_CORNER.get());
        this.dropSelf(BlockLoader.YELLOW_CLAY_TILING_VERTICAL_CORNER.get());

        this.dropSelf(BlockLoader.REEDS.get());
        this.dropSelf(BlockLoader.DRIED_REEDS.get());
        this.dropSelf(BlockLoader.PAPYRUS.get());

        this.dropSelf(BlockLoader.VULCANIC_ROCK.get());
        this.dropSelf(BlockLoader.VULCANIC_ROCK_STAIRS.get());
        this.dropSelf(BlockLoader.VULCANIC_ROCK_WALL.get());
        this.dropSelf(BlockLoader.VULCANIC_ROCK_SLAB.get());

        this.dropSelf(BlockLoader.SAND_LAYER.get());
        this.dropSelf(BlockLoader.RED_SAND_LAYER.get());
        this.dropSelf(BlockLoader.WHITE_SAND.get());
        this.dropSelf(BlockLoader.WHITE_SAND_LAYER.get());

        this.dropSelf(BlockLoader.GREEN_BASALT_ROUND_ARCH.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_GOTHIC_ARCH.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_SEGMENTAL_ARCH.get());

        this.dropSelf(BlockLoader.HIGH_ELVEN_COBBLESTONE.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_COBBLESTONE_STAIRS.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_COBBLESTONE_WALL.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_COBBLESTONE_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get());
        this.dropSelf(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_SLAB.get());

        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_WALL.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get());
        this.dropSelf(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB.get());

        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_STAIRS.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_WALL.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get());
        this.dropSelf(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_SLAB.get());

        this.dropSelf(BlockLoader.BASALT_BRICKS.get());
        this.dropSelf(BlockLoader.BASALT_BRICKS_SLAB.get());
        this.dropSelf(BlockLoader.BASALT_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.BASALT_BRICKS_WALL.get());

        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_SLAB.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_GOTHIC_ARCH.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_SEGMENTAL_ARCH.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_ROUND_ARCH.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_SMALL_ARCH.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_TWO_METER_ARCH.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_ARROWSLIT.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_BALUSTRADE.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_WALL.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_SMALL_PILLAR.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_PILAR.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_LARGE_PILLAR.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_PILLAR.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_WALL.get());

        this.dropSelf(BlockLoader.GREEN_BASALT_COBBLESTONE.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_COBBLESTONE_WALL.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_COBBLESTONE_SLAB.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_COBBLESTONE_STAIRS.get());

        this.dropSelf(BlockLoader.GREEN_BASALT.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_STAIRS.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_WALL.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_SLAB.get());
        this.dropSelf(BlockLoader.GREEN_BASALT_BALUSTRADE.get());

        this.dropSelf(BlockLoader.LIGHT_GRAY_STONE_BRICKS.get());
        this.dropSelf(BlockLoader.LIGHT_GRAY_STONE_BRICKS_SLAB.get());
        this.dropSelf(BlockLoader.LIGHT_GRAY_STONE_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.LIGHT_GRAY_STONE_BRICKS_WALL.get());

        this.dropSelf(BlockLoader.LIGHT_GRAY_STONE.get());
        this.dropSelf(BlockLoader.LIGHT_GRAY_STONE_SLAB.get());
        this.dropSelf(BlockLoader.LIGHT_GRAY_STONE_STAIRS.get());
        this.dropSelf(BlockLoader.LIGHT_GRAY_STONE_WALL.get());

        this.dropSelf(BlockLoader.BLUE_STONE.get());
        this.dropSelf(BlockLoader.BLUE_STONE_SLAB.get());
        this.dropSelf(BlockLoader.BLUE_STONE_STAIRS.get());
        this.dropSelf(BlockLoader.BLUE_STONE_WALL.get());

        this.dropSelf(BlockLoader.BLUE_BRICK.get());
        this.dropSelf(BlockLoader.BLUE_BRICK_SLAB.get());
        this.dropSelf(BlockLoader.BLUE_BRICK_STAIRS.get());
        this.dropSelf(BlockLoader.BLUE_BRICK_WALL.get());

        this.dropSelf(BlockLoader.CYAN_STONE.get());
        this.dropSelf(BlockLoader.CYAN_STONE_SLAB.get());
        this.dropSelf(BlockLoader.CYAN_STONE_STAIRS.get());
        this.dropSelf(BlockLoader.CYAN_STONE_WALL.get());

        this.dropSelf(BlockLoader.BROWN_STONE.get());
        this.dropSelf(BlockLoader.BROWN_STONE_SLAB.get());
        this.dropSelf(BlockLoader.BROWN_STONE_STAIRS.get());
        this.dropSelf(BlockLoader.BROWN_STONE_WALL.get());

        this.dropSelf(BlockLoader.YELLOW_STONE_BRICKS_2.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_BRICKS_2_SLAB.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_BRICKS_2_STAIRS.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_BRICKS_2_WALL.get());

        this.dropSelf(BlockLoader.YELLOW_STONE_2.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_2_SLAB.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_2_STAIRS.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_2_WALL.get());

        this.dropSelf(BlockLoader.YELLOW_STONE_BRICKS.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_BRICKS_SLAB.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_BRICKS_WALL.get());

        this.dropSelf(BlockLoader.YELLOW_STONE.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_SLAB.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_STAIRS.get());
        this.dropSelf(BlockLoader.YELLOW_STONE_WALL.get());

        this.dropSelf(BlockLoader.YELLOW_COBBLE.get());
        this.dropSelf(BlockLoader.YELLOW_COBBLE_SLAB.get());
        this.dropSelf(BlockLoader.YELLOW_COBBLE_STAIRS.get());
        this.dropSelf(BlockLoader.YELLOW_COBBLE_WALL.get());

        this.dropSelf(BlockLoader.ORANGE_ROCK.get());
        this.dropSelf(BlockLoader.ORANGE_ROCK_SLAB.get());
        this.dropSelf(BlockLoader.ORANGE_ROCK_STAIRS.get());
        this.dropSelf(BlockLoader.ORANGE_ROCK_WALL.get());

        this.dropSelf(BlockLoader.RED_ROCK.get());
        this.dropSelf(BlockLoader.RED_ROCK_SLAB.get());
        this.dropSelf(BlockLoader.RED_ROCK_STAIRS.get());
        this.dropSelf(BlockLoader.RED_ROCK_WALL.get());

        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CHISELED_HIGH_ELVEN_BRICKS.get());

        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CHISELED_LIGHT_HIGH_ELVEN_BRICKS.get());

        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CHISELED_DARK_HIGH_ELVEN_BRICKS.get());

        this.dropSelf(BlockLoader.BROWN_SANDSTONE_BRICKS.get());
        this.dropSelf(BlockLoader.BROWN_SANDSTONE_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.BROWN_SANDSTONE_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.BROWN_SANDSTONE_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS.get());
        this.dropSelf(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS.get());
        this.dropSelf(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CARVED_BROWN_SANDSTONE_BRICKS.get());

        this.dropSelf(BlockLoader.CACHOLONG_BRICKS.get());
        this.dropSelf(BlockLoader.CACHOLONG_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CACHOLONG_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CACHOLONG_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CRACKED_CACHOLONG_BRICKS.get());
        this.dropSelf(BlockLoader.CRACKED_CACHOLONG_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CRACKED_CACHOLONG_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CRACKED_CACHOLONG_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_CACHOLONG_BRICKS.get());
        this.dropSelf(BlockLoader.MOSSY_CACHOLONG_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_CACHOLONG_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_CACHOLONG_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CARVED_CACHOLONG_BRICKS.get());

        this.dropSelf(BlockLoader.BLACK_DEMON_BRICKS.get());
        this.dropSelf(BlockLoader.BLACK_DEMON_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.BLACK_DEMON_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.BLACK_DEMON_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CRACKED_BLACK_DEMON_BRICKS.get());
        this.dropSelf(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_BLACK_DEMON_BRICKS.get());
        this.dropSelf(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CARVED_BLACK_DEMON_BRICKS.get());

        this.dropSelf(BlockLoader.BLUE_BRICKS.get());
        this.dropSelf(BlockLoader.BLUE_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.BLUE_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.BLUE_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CRACKED_BLUE_BRICKS.get());
        this.dropSelf(BlockLoader.CRACKED_BLUE_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CRACKED_BLUE_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CRACKED_BLUE_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_BLUE_BRICKS.get());
        this.dropSelf(BlockLoader.MOSSY_BLUE_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_BLUE_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_BLUE_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CARVED_BLUE_BRICKS.get());

        this.dropSelf(BlockLoader.DEMON_BASALT_BRICKS.get());
        this.dropSelf(BlockLoader.DEMON_BASALT_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.DEMON_BASALT_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.DEMON_BASALT_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CARVED_DEMON_BASALT_BRICKS.get());

        this.dropSelf(BlockLoader.VULCANIC_DEMON_BRICKS.get());
        this.dropSelf(BlockLoader.VULCANIC_DEMON_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.VULCANIC_DEMON_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.VULCANIC_DEMON_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS.get());
        this.dropSelf(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS.get());
        this.dropSelf(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CARVED_VULCANIC_DEMON_BRICKS.get());

        this.dropSelf(BlockLoader.RED_BRICKS.get());
        this.dropSelf(BlockLoader.RED_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.RED_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.RED_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CRACKED_RED_BRICKS.get());
        this.dropSelf(BlockLoader.CRACKED_RED_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CRACKED_RED_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CRACKED_RED_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_RED_BRICKS.get());
        this.dropSelf(BlockLoader.MOSSY_RED_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_RED_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_RED_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CARVED_RED_BRICKS.get());

        this.dropSelf(BlockLoader.DESERT_MUD_BRICKS.get());
        this.dropSelf(BlockLoader.DESERT_MUD_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.DESERT_MUD_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.DESERT_MUD_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.CRACKED_DESERT_MUD_BRICKS.get());
        this.dropSelf(BlockLoader.CRACKED_DESERT_MUD_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CRACKED_DESERT_MUD_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CRACKED_DESERT_MUD_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.MOSSY_DESERT_MUD_BRICKS.get());
        this.dropSelf(BlockLoader.MOSSY_DESERT_MUD_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_DESERT_MUD_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.MOSSY_DESERT_MUD_BRICKS_SLAB.get());












        this.dropSelf(BlockLoader.CHALK.get());
        this.dropSelf(BlockLoader.CHALK_STAIRS.get());
        this.dropSelf(BlockLoader.CHALK_WALL.get());
        this.dropSelf(BlockLoader.CHALK_SLAB.get());

        this.dropSelf(BlockLoader.CHALK_BRICKS.get());
        this.dropSelf(BlockLoader.CHALK_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.CHALK_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.CHALK_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.SMALL_HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS.get());
        this.dropSelf(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_WALL.get());
        this.dropSelf(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_SLAB.get());

        this.dropSelf(BlockLoader.BROWN_SANDSTONE_SLATES.get());

        this.dropOther(BlockLoader.HIGH_ELVEN_ROCK.get(), BlockLoader.HIGH_ELVEN_COBBLESTONE.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_ROCK_STAIRS.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_ROCK_WALL.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_ROCK_SLAB.get());

        this.dropOther(BlockLoader.DARK_HIGH_ELVEN_ROCK.get(), BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_ROCK_STAIRS.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_ROCK_WALL.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_ROCK_SLAB.get());

        this.dropOther(BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get(), BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_STAIRS.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_WALL.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_SLAB.get());

        this.dropSelf(BlockLoader.APPLE_PLANKS.get());
        this.dropSelf(BlockLoader.APPLE_FENCE.get());
        this.dropSelf(BlockLoader.APPLE_FENCE_GATE.get());
        this.dropSelf(BlockLoader.APPLE_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.APPLE_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.APPLE_LOG.get());
        this.dropSelf(BlockLoader.APPLE_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_APPLE_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_APPLE_WOOD.get());
        this.dropSelf(BlockLoader.APPLE_SAPLING.get());

        this.add(BlockLoader.APPLE_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.APPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.ASPEN_PLANKS.get());
        this.dropSelf(BlockLoader.ASPEN_FENCE.get());
        this.dropSelf(BlockLoader.ASPEN_FENCE_GATE.get());
        this.dropSelf(BlockLoader.ASPEN_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.ASPEN_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.ASPEN_LOG.get());
        this.dropSelf(BlockLoader.ASPEN_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_ASPEN_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_ASPEN_WOOD.get());
        this.dropSelf(BlockLoader.ASPEN_SAPLING.get());

        this.add(BlockLoader.ASPEN_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.ASPEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.BAOBAB_PLANKS.get());
        this.dropSelf(BlockLoader.BAOBAB_FENCE.get());
        this.dropSelf(BlockLoader.BAOBAB_FENCE_GATE.get());
        this.dropSelf(BlockLoader.BAOBAB_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.BAOBAB_PLANKS_SLAB.get());
        //  this.dropSelf(BlockLoader.BAOBAB_LOG.get());
        //this.dropSelf(BlockLoader.BAOBAB_WOOD.get());
        // this.dropSelf(BlockLoader.STRIPPED_BAOBAB_LOG.get());
        //this.dropSelf(BlockLoader.STRIPPED_BAOBAB_WOOD.get());
        //this.dropSelf(BlockLoader.BAOBAB_SAPLING.get());

        //this.add(BlockLoader.BAOBAB_LEAVES.get(), block -> createLeavesDrops(block, BlockLoader.BAOBAB_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.BEECH_PLANKS.get());
        this.dropSelf(BlockLoader.BEECH_FENCE.get());
        this.dropSelf(BlockLoader.BEECH_FENCE_GATE.get());
        this.dropSelf(BlockLoader.BEECH_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.BEECH_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.BEECH_LOG.get());
        this.dropSelf(BlockLoader.BEECH_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_BEECH_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_BEECH_WOOD.get());
        this.dropSelf(BlockLoader.BEECH_SAPLING.get());

        this.add(BlockLoader.BEECH_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.BEECH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.BLACKTHORN_PLANKS.get());
        this.dropSelf(BlockLoader.BLACKTHORN_FENCE.get());
        this.dropSelf(BlockLoader.BLACKTHORN_FENCE_GATE.get());
        this.dropSelf(BlockLoader.BLACKTHORN_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.BLACKTHORN_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.BLACKTHORN_LOG.get());
        this.dropSelf(BlockLoader.BLACKTHORN_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_BLACKTHORN_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_BLACKTHORN_WOOD.get());
        this.dropSelf(BlockLoader.BLACKTHORN_SAPLING.get());

        this.add(BlockLoader.BLACKTHORN_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.BLACKTHORN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.GHOST_GUM_PLANKS.get());
        this.dropSelf(BlockLoader.GHOST_GUM_FENCE.get());
        this.dropSelf(BlockLoader.GHOST_GUM_FENCE_GATE.get());
        this.dropSelf(BlockLoader.GHOST_GUM_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.GHOST_GUM_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.GHOST_GUM_LOG.get());
        this.dropSelf(BlockLoader.GHOST_GUM_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_GHOST_GUM_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_GHOST_GUM_WOOD.get());
        this.dropSelf(BlockLoader.GHOST_GUM_SAPLING.get());

        this.add(BlockLoader.GHOST_GUM_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.GHOST_GUM_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.WHITE_ASH_PLANKS.get());
        this.dropSelf(BlockLoader.WHITE_ASH_FENCE.get());
        this.dropSelf(BlockLoader.WHITE_ASH_FENCE_GATE.get());
        this.dropSelf(BlockLoader.WHITE_ASH_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.WHITE_ASH_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.WHITE_ASH_LOG.get());
        this.dropSelf(BlockLoader.WHITE_ASH_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_WHITE_ASH_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_WHITE_ASH_WOOD.get());
        this.dropSelf(BlockLoader.WHITE_ASH_SAPLING.get());

        this.add(BlockLoader.WHITE_ASH_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.WHITE_ASH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.SILVER_SPRUCE_PLANKS.get());
        this.dropSelf(BlockLoader.SILVER_SPRUCE_FENCE.get());
        this.dropSelf(BlockLoader.SILVER_SPRUCE_FENCE_GATE.get());
        this.dropSelf(BlockLoader.SILVER_SPRUCE_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.SILVER_SPRUCE_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.SILVER_SPRUCE_LOG.get());
        this.dropSelf(BlockLoader.SILVER_SPRUCE_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_SILVER_SPRUCE_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_SILVER_SPRUCE_WOOD.get());
        this.dropSelf(BlockLoader.SILVER_SPRUCE_SAPLING.get());

        this.add(BlockLoader.SILVER_SPRUCE_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.SILVER_SPRUCE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.CEDAR_PLANKS.get());
        this.dropSelf(BlockLoader.CEDAR_FENCE.get());
        this.dropSelf(BlockLoader.CEDAR_FENCE_GATE.get());
        this.dropSelf(BlockLoader.CEDAR_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.CEDAR_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.CEDAR_LOG.get());
        this.dropSelf(BlockLoader.CEDAR_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_CEDAR_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_CEDAR_WOOD.get());
        this.dropSelf(BlockLoader.CEDAR_SAPLING.get());

        this.add(BlockLoader.CEDAR_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.CEDAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.CHERRY_PLANKS.get());
        this.dropSelf(BlockLoader.CHERRY_FENCE.get());
        this.dropSelf(BlockLoader.CHERRY_FENCE_GATE.get());
        this.dropSelf(BlockLoader.CHERRY_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.CHERRY_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.CHERRY_LOG.get());
        this.dropSelf(BlockLoader.CHERRY_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_CHERRY_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_CHERRY_WOOD.get());
        this.dropSelf(BlockLoader.CHERRY_SAPLING.get());

        this.add(BlockLoader.CHERRY_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.CHERRY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.CYPRESS_PLANKS.get());
        this.dropSelf(BlockLoader.CYPRESS_FENCE.get());
        this.dropSelf(BlockLoader.CYPRESS_FENCE_GATE.get());
        this.dropSelf(BlockLoader.CYPRESS_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.CYPRESS_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.CYPRESS_LOG.get());
        this.dropSelf(BlockLoader.CYPRESS_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_CYPRESS_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_CYPRESS_WOOD.get());
        this.dropSelf(BlockLoader.CYPRESS_SAPLING.get());

        this.add(BlockLoader.CYPRESS_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.CYPRESS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.FIR_PLANKS.get());
        this.dropSelf(BlockLoader.FIR_FENCE.get());
        this.dropSelf(BlockLoader.FIR_FENCE_GATE.get());
        this.dropSelf(BlockLoader.FIR_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.FIR_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.FIR_LOG.get());
        this.dropSelf(BlockLoader.FIR_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_FIR_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_FIR_WOOD.get());
        this.dropSelf(BlockLoader.FIR_SAPLING.get());

        this.add(BlockLoader.FIR_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.FIR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.GREEN_OAK_PLANKS.get());
        this.dropSelf(BlockLoader.GREEN_OAK_FENCE.get());
        this.dropSelf(BlockLoader.GREEN_OAK_FENCE_GATE.get());
        this.dropSelf(BlockLoader.GREEN_OAK_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.GREEN_OAK_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.GREEN_OAK_LOG.get());
        this.dropSelf(BlockLoader.GREEN_OAK_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_GREEN_OAK_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_GREEN_OAK_WOOD.get());
        this.dropSelf(BlockLoader.GREEN_OAK_SAPLING.get());

        this.add(BlockLoader.GREEN_OAK_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.GREEN_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.HOLLY_PLANKS.get());
        this.dropSelf(BlockLoader.HOLLY_FENCE.get());
        this.dropSelf(BlockLoader.HOLLY_FENCE_GATE.get());
        this.dropSelf(BlockLoader.HOLLY_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.HOLLY_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.HOLLY_LOG.get());
        this.dropSelf(BlockLoader.HOLLY_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_HOLLY_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_HOLLY_WOOD.get());
        this.dropSelf(BlockLoader.HOLLY_SAPLING.get());

        this.add(BlockLoader.HOLLY_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.HOLLY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.LARCH_PLANKS.get());
        this.dropSelf(BlockLoader.LARCH_FENCE.get());
        this.dropSelf(BlockLoader.LARCH_FENCE_GATE.get());
        this.dropSelf(BlockLoader.LARCH_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.LARCH_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.LARCH_LOG.get());
        this.dropSelf(BlockLoader.LARCH_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_LARCH_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_LARCH_WOOD.get());
        this.dropSelf(BlockLoader.LARCH_SAPLING.get());

        this.add(BlockLoader.LARCH_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.LARCH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.MAPLE_PLANKS.get());
        this.dropSelf(BlockLoader.MAPLE_FENCE.get());
        this.dropSelf(BlockLoader.MAPLE_FENCE_GATE.get());
        this.dropSelf(BlockLoader.MAPLE_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.MAPLE_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.MAPLE_LOG.get());
        this.dropSelf(BlockLoader.MAPLE_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_MAPLE_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_MAPLE_WOOD.get());
        this.dropSelf(BlockLoader.MAPLE_SAPLING.get());

        this.add(BlockLoader.MAPLE_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.OKOME_PLANKS.get());
        this.dropSelf(BlockLoader.OKOME_FENCE.get());
        this.dropSelf(BlockLoader.OKOME_FENCE_GATE.get());
        this.dropSelf(BlockLoader.OKOME_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.OKOME_PLANKS_SLAB.get());

        this.dropSelf(BlockLoader.PEAR_PLANKS.get());
        this.dropSelf(BlockLoader.PEAR_FENCE.get());
        this.dropSelf(BlockLoader.PEAR_FENCE_GATE.get());
        this.dropSelf(BlockLoader.PEAR_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.PEAR_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.PEAR_LOG.get());
        this.dropSelf(BlockLoader.PEAR_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_PEAR_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_PEAR_WOOD.get());
        this.dropSelf(BlockLoader.PEAR_SAPLING.get());

        this.add(BlockLoader.PEAR_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.PEAR_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.PINE_PLANKS.get());
        this.dropSelf(BlockLoader.PINE_FENCE.get());
        this.dropSelf(BlockLoader.PINE_FENCE_GATE.get());
        this.dropSelf(BlockLoader.PINE_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.PINE_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.PINE_LOG.get());
        this.dropSelf(BlockLoader.PINE_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_PINE_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_PINE_WOOD.get());
        this.dropSelf(BlockLoader.PINE_SAPLING.get());

        this.add(BlockLoader.PINE_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.PINE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.PLUM_PLANKS.get());
        this.dropSelf(BlockLoader.PLUM_FENCE.get());
        this.dropSelf(BlockLoader.PLUM_FENCE_GATE.get());
        this.dropSelf(BlockLoader.PLUM_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.PLUM_PLANKS_SLAB.get());

        this.dropSelf(BlockLoader.RED_OAK_PLANKS.get());
        this.dropSelf(BlockLoader.RED_OAK_FENCE.get());
        this.dropSelf(BlockLoader.RED_OAK_FENCE_GATE.get());
        this.dropSelf(BlockLoader.RED_OAK_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.RED_OAK_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.RED_OAK_LOG.get());
        this.dropSelf(BlockLoader.RED_OAK_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_RED_OAK_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_RED_OAK_WOOD.get());
        this.dropSelf(BlockLoader.RED_OAK_SAPLING.get());

        this.add(BlockLoader.RED_OAK_LEAVES.get(), block ->
                createLeavesDrops(block, BlockLoader.RED_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(BlockLoader.REDWOOD_PLANKS.get());
        this.dropSelf(BlockLoader.REDWOOD_FENCE.get());
        this.dropSelf(BlockLoader.REDWOOD_FENCE_GATE.get());
        this.dropSelf(BlockLoader.REDWOOD_PLANKS_STAIRS.get());
        this.dropSelf(BlockLoader.REDWOOD_PLANKS_SLAB.get());
        this.dropSelf(BlockLoader.REDWOOD_LOG.get());
        this.dropSelf(BlockLoader.REDWOOD_WOOD.get());
        this.dropSelf(BlockLoader.STRIPPED_REDWOOD_LOG.get());
        this.dropSelf(BlockLoader.STRIPPED_REDWOOD_WOOD.get());
        this.dropSelf(BlockLoader.REDWOOD_SAPLING.get());
        this.dropSelf(BlockLoader.REDWOOD_DOOR.get());
        this.dropSelf(BlockLoader.REDWOOD_TRAPDOOR.get());
        this.dropSelf(BlockLoader.REDWOOD_BUTTON.get());
        this.dropSelf(BlockLoader.REDWOOD_PRESSURE_PLATE.get());
        this.dropSelf(BlockLoader.REDWOOD_BANISTER.get());
        this.dropSelf(BlockLoader.REDWOOD_BALUSTRADE.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_BALUSTRADE.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_BALUSTRADE.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_BALUSTRADE.get());
        this.dropSelf(BlockLoader.BRICK_PILLAR.get());
        this.dropSelf(BlockLoader.STONE_PILLAR.get());
        this.dropSelf(BlockLoader.CHALK_PILLAR.get());
        this.dropSelf(BlockLoader.RED_PILLAR.get());
        this.dropSelf(BlockLoader.CACHOLONG_PILLAR.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_PILLAR.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_PILLAR.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_PILLAR.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICK_ARROWSLIT.get());
        this.dropSelf(BlockLoader.CLAY_TILING.get());
        this.dropSelf(BlockLoader.CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.BLACK_CLAY_TILING.get());
        this.dropSelf(BlockLoader.BLACK_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.BLACK_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.BLUE_CLAY_TILING.get());
        this.dropSelf(BlockLoader.BLUE_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.BLUE_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.BROWN_CLAY_TILING.get());
        this.dropSelf(BlockLoader.BROWN_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.BROWN_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.CYAN_CLAY_TILING.get());
        this.dropSelf(BlockLoader.CYAN_CLAY_TILING_STAIRS .get());
        this.dropSelf(BlockLoader.CYAN_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.GRAY_CLAY_TILING.get());
        this.dropSelf(BlockLoader.GRAY_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.GRAY_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.GREEN_CLAY_TILING.get());
        this.dropSelf(BlockLoader.GREEN_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.GREEN_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.LIGHT_BLUE_CLAY_TILING.get());
        this.dropSelf(BlockLoader.LIGHT_BLUE_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.LIGHT_BLUE_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.LIGHT_GRAY_CLAY_TILING.get());
        this.dropSelf(BlockLoader.LIGHT_GRAY_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.LIGHT_GRAY_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.LIME_CLAY_TILING.get());
        this.dropSelf(BlockLoader.LIME_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.LIME_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.MAGENTA_CLAY_TILING.get());
        this.dropSelf(BlockLoader.MAGENTA_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.MAGENTA_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.ORANGE_CLAY_TILING.get());
        this.dropSelf(BlockLoader.ORANGE_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.ORANGE_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.PINK_CLAY_TILING.get());
        this.dropSelf(BlockLoader.PINK_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.PINK_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.PURPLE_CLAY_TILING.get());
        this.dropSelf(BlockLoader.PURPLE_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.PURPLE_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.RED_CLAY_TILING.get());
        this.dropSelf(BlockLoader.RED_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.RED_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.WHITE_CLAY_TILING.get());
        this.dropSelf(BlockLoader.WHITE_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.WHITE_CLAY_TILING_SLAB.get());
        this.dropSelf(BlockLoader.YELLOW_CLAY_TILING.get());
        this.dropSelf(BlockLoader.YELLOW_CLAY_TILING_STAIRS.get());
        this.dropSelf(BlockLoader.YELLOW_CLAY_TILING_SLAB.get());


        //grass
        this.dropSelf(BlockLoader.ARID_GRASS.get());
        this.dropSelf(BlockLoader.BLACK_GRASS.get());
        this.dropSelf(BlockLoader.FLAX_GRASS.get());


        //flowers
        this.dropSelf(BlockLoader.ASPHODEL.get());
        this.dropSelf(BlockLoader.BLUE_DELPHINIUM.get());
        this.dropSelf(BlockLoader.BLUEBELL.get());
        this.dropSelf(BlockLoader.CALLA_LILY.get());
        this.dropSelf(BlockLoader.CELSEMIUM.get());
        this.dropSelf(BlockLoader.CHRYS_BLUE.get());
        this.dropSelf(BlockLoader.CHRYS_ORANGE.get());
        this.dropSelf(BlockLoader.CHRYS_PINK.get());
        this.dropSelf(BlockLoader.CHRYS_WHITE.get());
        this.dropSelf(BlockLoader.CHRYS_YELLOW.get());
        this.dropSelf(BlockLoader.CROCUS.get());
        this.dropSelf(BlockLoader.DAISY.get());
        this.dropSelf(BlockLoader.DELPHINIUM.get());
        this.dropSelf(BlockLoader.FLAX_FLOWERS.get());
        this.dropSelf(BlockLoader.FOXGLOVE_ORANGE.get());
        this.dropSelf(BlockLoader.FOXGLOVE_PINK.get());
        this.dropSelf(BlockLoader.FOXGLOVE_RED.get());
        this.dropSelf(BlockLoader.FOXGLOVE_WHITE.get());
        this.dropSelf(BlockLoader.GERBERA_RED.get());
        this.dropSelf(BlockLoader.GERBERA_YELLOW.get());
        this.dropSelf(BlockLoader.HEATHER_BUSH.get());
        this.dropSelf(BlockLoader.LAVENDER.get());
        this.dropSelf(BlockLoader.MARIGOLD.get());
        this.dropSelf(BlockLoader.PINK_ANEMONE.get());
        this.dropSelf(BlockLoader.SIMBLELMYNE.get());
        this.dropSelf(BlockLoader.TUBEROSE.get());

        this.dropSelf(BlockLoader.CRACKED_GREEN_BASALT.get());
        this.dropSelf(BlockLoader.CRACKED_GREEN_BASALT_SLAB.get());
        this.dropSelf(BlockLoader.CRACKED_GREEN_BASALT_STAIRS.get());
        this.dropSelf(BlockLoader.CRACKED_GREEN_BASALT_WALL.get());

        this.dropSelf(BlockLoader.CHISELED_BASALT.get());

        this.dropSelf(BlockLoader.GNEISS.get());
        this.dropSelf(BlockLoader.GNEISS_SLAB.get());
        this.dropSelf(BlockLoader.GNEISS_STAIRS.get());
        this.dropSelf(BlockLoader.GNEISS_WALL.get());

        this.dropSelf(BlockLoader.LIMESTONE.get());
        this.dropSelf(BlockLoader.LIMESTONE_SLAB.get());
        this.dropSelf(BlockLoader.LIMESTONE_WALL.get());
        this.dropSelf(BlockLoader.LIMESTONE_STAIRS.get());

        this.dropSelf(BlockLoader.MOSSY_BASALT_BRICKS.get());
        this.dropSelf(BlockLoader.MOSSY_BASALT_BRICKS_SLAB.get());
        this.dropSelf(BlockLoader.MOSSY_BASALT_BRICKS_STAIRS.get());
        this.dropSelf(BlockLoader.MOSSY_BASALT_BRICKS_WALL.get());

        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICK_TILING.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICK_TILING_STAIRS.get());
        //this.dropSelf(BlockLoader.HIGH_ELVEN_BRICK_TILING_WALL.get());
        this.dropSelf(BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB.get());

        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_STAIRS.get());
        //this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_WALL.get());
        this.dropSelf(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB.get());

        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS.get());
        //this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_WALL.get());
        this.dropSelf(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB.get());


        this.dropSelf((BlockLoader.MARBLE_PINK.get()));
        this.dropSelf((BlockLoader.ORE_VEIL.get()));


        this.add(BlockLoader.TOPAZ_ORE.get(), block -> createOreDrop(BlockLoader.TOPAZ_ORE.get(),
                ItemLoader.TOPAZ_SHARD.get()));

        this.dropSelf(BlockLoader.ALEXANDRITE_BLOCK.get());
        this.dropSelf(BlockLoader.RAW_ALEXANDRITE_BLOCK.get());

        this.add(BlockLoader.ALEXANDRITE_ORE.get(),
                block -> createOreDrop(BlockLoader.ALEXANDRITE_ORE.get(), ItemLoader.RAW_ALEXANDRITE.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockLoader.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
