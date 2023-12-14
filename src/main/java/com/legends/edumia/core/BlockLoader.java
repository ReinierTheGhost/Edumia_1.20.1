package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.*;
import com.legends.edumia.block.arches.Arch;
import com.legends.edumia.block.arches.ArchSmall;
import com.legends.edumia.block.arches.ArchTwoMeter;
import com.legends.edumia.block.block.Balustrade;
import com.legends.edumia.block.block.Log;
import com.legends.edumia.block.block.VerticalCorner;
import com.legends.edumia.block.block.Wall;
import com.legends.edumia.block.classical.corinthian.CubeCapitalCorinthian;
import com.legends.edumia.block.classical.corinthian.PillarCapitalCorinthian;
import com.legends.edumia.block.classical.corinthian.WallCapitalCorinthian;
import com.legends.edumia.block.classical.ionian.PillarLargeRotated;
import com.legends.edumia.block.classical.ionian.PillarRotated;
import com.legends.edumia.block.classical.ionian.PillarSmallRotated;
import com.legends.edumia.block.plants.DriedReedsBlock;
import com.legends.edumia.block.plants.ReedsBlock;
import com.legends.edumia.block.wallpaper.WallPaperBlock;
import com.legends.edumia.block.windows.ArrowSlit;
import com.legends.edumia.core.block.builder.Props;
import com.legends.edumia.worldgen.tree.treegrower.*;
import com.pam.pamhc2trees.blocks.BlockPamFruit;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockLoader {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Edumia.MODID);

    public static final RegistryObject<Block> SAND_LAYER = registerBlock("sand_layer",
            () -> new Layer(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND)));
    public static final RegistryObject<Block> RED_SAND_LAYER = registerBlock("red_sand_layer",
            () -> new Layer(BlockBehaviour.Properties.copy(Blocks.RED_SAND).sound(SoundType.SAND)));

    public static final RegistryObject<Block> WHITE_SAND = registerBlock("white_sand",
            () -> new FallingBlock(BlockBehaviour.Properties.of().sound(SoundType.SAND)));
    public static final RegistryObject<Block> WHITE_SAND_LAYER = registerBlock("white_sand_layer",
            () -> new Layer(BlockBehaviour.Properties.copy(BlockLoader.WHITE_SAND.get()).sound(SoundType.SAND)));





    public static final RegistryObject<Block> BRICK_PILLAR = registerBlock("brick_pillar",
            () -> new EdumiaPillarBlock(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> STONE_PILLAR = registerBlock("stone_pillar",
            () -> new EdumiaPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> CLAY_TILING = registerBlock("clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CLAY_TILING_STAIRS = registerBlock("clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CLAY_TILING_SLAB = registerBlock("clay_tiling_slab",
            () -> new AxialSlabBlock(CLAY_TILING));
    public static final RegistryObject<Block> CLAY_TILING_VERTICAL_CORNER = registerBlock("clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> BLACK_CLAY_TILING = registerBlock("black_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLACK_CLAY_TILING_STAIRS = registerBlock("black_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.BLACK_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLACK_CLAY_TILING_SLAB = registerBlock("black_clay_tiling_slab",
            () -> new AxialSlabBlock(BLACK_CLAY_TILING));
    public static final RegistryObject<Block> BLACK_CLAY_TILING_VERTICAL_CORNER = registerBlock("black_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> BLUE_CLAY_TILING = registerBlock("blue_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLUE_CLAY_TILING_STAIRS = registerBlock("blue_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.BLUE_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLUE_CLAY_TILING_SLAB = registerBlock("blue_clay_tiling_slab",
            () -> new AxialSlabBlock(BLUE_CLAY_TILING));
    public static final RegistryObject<Block> BLUE_CLAY_TILING_VERTICAL_CORNER = registerBlock("blue_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> BROWN_CLAY_TILING = registerBlock("brown_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BROWN_CLAY_TILING_STAIRS = registerBlock("brown_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.BROWN_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BROWN_CLAY_TILING_SLAB = registerBlock("brown_clay_tiling_slab",
            () -> new AxialSlabBlock(BROWN_CLAY_TILING));
    public static final RegistryObject<Block> BROWN_CLAY_TILING_VERTICAL_CORNER = registerBlock("brown_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CYAN_CLAY_TILING = registerBlock("cyan_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CYAN_CLAY_TILING_STAIRS = registerBlock("cyan_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.CYAN_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CYAN_CLAY_TILING_SLAB = registerBlock("cyan_clay_tiling_slab",
            () -> new AxialSlabBlock(CYAN_CLAY_TILING));
    public static final RegistryObject<Block> CYAN_CLAY_TILING_VERTICAL_CORNER = registerBlock("cyan_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> GRAY_CLAY_TILING = registerBlock("gray_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GRAY_CLAY_TILING_STAIRS = registerBlock("gray_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.GRAY_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GRAY_CLAY_TILING_SLAB = registerBlock("gray_clay_tiling_slab",
            () -> new AxialSlabBlock(GRAY_CLAY_TILING));
    public static final RegistryObject<Block> GRAY_CLAY_TILING_VERTICAL_CORNER = registerBlock("gray_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> GREEN_CLAY_TILING = registerBlock("green_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_CLAY_TILING_STAIRS = registerBlock("green_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.GREEN_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_CLAY_TILING_SLAB = registerBlock("green_clay_tiling_slab",
            () -> new AxialSlabBlock(GREEN_CLAY_TILING));
    public static final RegistryObject<Block> GREEN_CLAY_TILING_VERTICAL_CORNER = registerBlock("green_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> LIGHT_BLUE_CLAY_TILING = registerBlock("light_blue_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_BLUE_CLAY_TILING_STAIRS = registerBlock("light_blue_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.LIGHT_BLUE_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_BLUE_CLAY_TILING_SLAB = registerBlock("light_blue_clay_tiling_slab",
            () -> new AxialSlabBlock(LIGHT_BLUE_CLAY_TILING));
    public static final RegistryObject<Block> LIGHT_BLUE_CLAY_TILING_VERTICAL_CORNER = registerBlock("light_blue_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> LIGHT_GRAY_CLAY_TILING = registerBlock("light_gray_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_GRAY_CLAY_TILING_STAIRS = registerBlock("liht_gray_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.LIGHT_GRAY_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_GRAY_CLAY_TILING_SLAB = registerBlock("light_gray_clay_tiling_slab",
            () -> new AxialSlabBlock(LIGHT_GRAY_CLAY_TILING));
    public static final RegistryObject<Block> LIGHT_GRAY_CLAY_TILING_VERTICAL_CORNER = registerBlock("light_gray_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> LIME_CLAY_TILING = registerBlock("lime_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIME_CLAY_TILING_STAIRS = registerBlock("lime_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.LIME_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIME_CLAY_TILING_SLAB = registerBlock("lime_clay_tiling_slab",
            () -> new AxialSlabBlock(LIME_CLAY_TILING));
    public static final RegistryObject<Block> LIME_CLAY_TILING_VERTICAL_CORNER = registerBlock("lime_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MAGENTA_CLAY_TILING = registerBlock("magenta_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MAGENTA_CLAY_TILING_STAIRS = registerBlock("magenta_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.MAGENTA_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MAGENTA_CLAY_TILING_SLAB = registerBlock("magenta_clay_tiling_slab",
            () -> new AxialSlabBlock(MAGENTA_CLAY_TILING));
    public static final RegistryObject<Block> MAGENTA_CLAY_TILING_VERTICAL_CORNER = registerBlock("magenta_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> ORANGE_CLAY_TILING = registerBlock("orange_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> ORANGE_CLAY_TILING_STAIRS = registerBlock("orange_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.ORANGE_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> ORANGE_CLAY_TILING_SLAB = registerBlock("orange_clay_tiling_slab",
            () -> new AxialSlabBlock(ORANGE_CLAY_TILING));
    public static final RegistryObject<Block> ORANGE_CLAY_TILING_VERTICAL_CORNER = registerBlock("orange_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> PINK_CLAY_TILING = registerBlock("pink_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> PINK_CLAY_TILING_STAIRS = registerBlock("pink_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.PINK_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> PINK_CLAY_TILING_SLAB = registerBlock("pink_clay_tiling_slab",
            () -> new AxialSlabBlock(PINK_CLAY_TILING));
    public static final RegistryObject<Block> PINK_CLAY_TILING_VERTICAL_CORNER = registerBlock("pink_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> PURPLE_CLAY_TILING = registerBlock("purple_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> PURPLE_CLAY_TILING_STAIRS = registerBlock("purple_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.PURPLE_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> PURPLE_CLAY_TILING_SLAB = registerBlock("purple_clay_tiling_slab",
            () -> new AxialSlabBlock(PURPLE_CLAY_TILING));
    public static final RegistryObject<Block> PURPLE_CLAY_TILING_VERTICAL_CORNER = registerBlock("purple_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> RED_CLAY_TILING = registerBlock("red_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> RED_CLAY_TILING_STAIRS = registerBlock("red_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.RED_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> RED_CLAY_TILING_SLAB = registerBlock("red_clay_tiling_slab",
            () -> new AxialSlabBlock(RED_CLAY_TILING));
    public static final RegistryObject<Block> RED_CLAY_TILING_VERTICAL_CORNER = registerBlock("red_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> WHITE_CLAY_TILING = registerBlock("white_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> WHITE_CLAY_TILING_STAIRS = registerBlock("white_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.WHITE_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> WHITE_CLAY_TILING_SLAB = registerBlock("white_clay_tiling_slab",
            () -> new AxialSlabBlock(WHITE_CLAY_TILING));
    public static final RegistryObject<Block> WHITE_CLAY_TILING_VERTICAL_CORNER = registerBlock("white_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> YELLOW_CLAY_TILING = registerBlock("yellow_clay_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> YELLOW_CLAY_TILING_STAIRS = registerBlock("yellow_clay_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.YELLOW_CLAY_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> YELLOW_CLAY_TILING_SLAB = registerBlock("yellow_clay_tiling_slab",
            () -> new AxialSlabBlock(YELLOW_CLAY_TILING));
    public static final RegistryObject<Block> YELLOW_CLAY_TILING_VERTICAL_CORNER = registerBlock("yellow_clay_vertical_corner",
            () -> new VerticalCorner(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> BROWN_STONE = registerBlock("brown_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BROWN_STONE_STAIRS = registerBlock("brown_stone_stairs",
            () -> new StairBlock(() -> BlockLoader.BROWN_STONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BROWN_STONE_SLAB = registerBlock("brown_stone_slab",
            () -> new AxialSlabBlock(BROWN_STONE));
    public static final RegistryObject<Block> BROWN_STONE_WALL = registerBlock("brown_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> LIGHT_GRAY_STONE = registerBlock("light_gray_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_STAIRS = registerBlock("light_gray_stone_stairs",
            () -> new StairBlock(() -> BlockLoader.LIGHT_GRAY_STONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_SLAB = registerBlock("light_gray_stone_slab",
            () -> new AxialSlabBlock(LIGHT_GRAY_STONE));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_WALL = registerBlock("light_gray_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> LIGHT_GRAY_STONE_BRICKS = registerBlock("light_gray_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_BRICKS_STAIRS = registerBlock("light_gray_stone_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.LIGHT_GRAY_STONE_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_BRICKS_SLAB = registerBlock("light_gray_stone_bricks_slab",
            () -> new AxialSlabBlock(LIGHT_GRAY_STONE_BRICKS));
    public static final RegistryObject<Block> LIGHT_GRAY_STONE_BRICKS_WALL = registerBlock("light_gray_stone_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> BLUE_STONE = registerBlock("blue_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLUE_STONE_STAIRS = registerBlock("blue_stone_stairs",
            () -> new StairBlock(() -> BlockLoader.BLUE_STONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLUE_STONE_SLAB = registerBlock("blue_stone_slab",
            () -> new AxialSlabBlock(BLUE_STONE));
    public static final RegistryObject<Block> BLUE_STONE_WALL = registerBlock("blue_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> BLUE_BRICK = registerBlock("blue_brick",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLUE_BRICK_STAIRS = registerBlock("blue_brick_stairs",
            () -> new StairBlock(() -> BlockLoader.BLUE_BRICK.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLUE_BRICK_SLAB = registerBlock("blue_brick_slab",
            () -> new AxialSlabBlock(BLUE_BRICK));
    public static final RegistryObject<Block> BLUE_BRICK_WALL = registerBlock("blue_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> YELLOW_STONE = registerBlock("yellow_stone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> YELLOW_STONE_STAIRS = registerBlock("yellow_stone_stairs",
            () -> new StairBlock(() -> BlockLoader.YELLOW_STONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> YELLOW_STONE_SLAB = registerBlock("yellow_stone_slab",
            () -> new AxialSlabBlock(YELLOW_STONE));
    public static final RegistryObject<Block> YELLOW_STONE_WALL = registerBlock("yellow_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> YELLOW_STONE_2 = registerBlock("yellow_stone_2",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> YELLOW_STONE_2_STAIRS = registerBlock("yellow_stone_2_stairs",
            () -> new StairBlock(() -> BlockLoader.YELLOW_STONE_2.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> YELLOW_STONE_2_SLAB = registerBlock("yellow_stone_2_slab",
            () -> new AxialSlabBlock(YELLOW_STONE_2));
    public static final RegistryObject<Block> YELLOW_STONE_2_WALL = registerBlock("yellow_stone_2_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> YELLOW_STONE_BRICKS = registerBlock("yellow_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1.5f, 6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> YELLOW_STONE_BRICKS_STAIRS = registerBlock("yellow_stone_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.YELLOW_STONE_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> YELLOW_STONE_BRICKS_SLAB = registerBlock("yellow_stone_bricks_slab",
            () -> new AxialSlabBlock(YELLOW_STONE_BRICKS));
    public static final RegistryObject<Block> YELLOW_STONE_BRICKS_WALL = registerBlock("yellow_stone_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> YELLOW_STONE_BRICKS_2 = registerBlock("yellow_stone_bricks_2",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> YELLOW_STONE_BRICKS_2_STAIRS = registerBlock("yellow_stone_bricks_2_stairs",
            () -> new StairBlock(() -> BlockLoader.YELLOW_STONE_BRICKS_2.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> YELLOW_STONE_BRICKS_2_SLAB = registerBlock("yellow_stone_bricks_2_slab",
            () -> new AxialSlabBlock(YELLOW_STONE_BRICKS_2));
    public static final RegistryObject<Block> YELLOW_STONE_BRICKS_2_WALL = registerBlock("yellow_stone_bricks_2_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> BASALT_BRICKS = registerBlock("basalt_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BASALT_BRICKS_STAIRS = registerBlock("basalt_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.BASALT_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BASALT_BRICKS_SLAB = registerBlock("basalt_bricks_slab",
            () -> new AxialSlabBlock(BASALT_BRICKS));
    public static final RegistryObject<Block> BASALT_BRICKS_WALL = registerBlock("basalt_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> GREEN_BASALT = registerBlock("green_basalt",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_STAIRS = registerBlock("green_basalt_stairs",
            () -> new StairBlock(() -> BlockLoader.GREEN_BASALT.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_SLAB = registerBlock("green_basalt_slab",
            () -> new AxialSlabBlock(GREEN_BASALT));
    public static final RegistryObject<Block> GREEN_BASALT_WALL = registerBlock("green_basalt_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> GREEN_BASALT_ROUND_ARCH = registerBlock("green_basalt_round_arch",
            () -> new Arch(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> GREEN_BASALT_GOTHIC_ARCH = registerBlock("green_basalt_gothic_arch",
            () -> new Arch(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_SEGMENTAL_ARCH = registerBlock("green_basalt_segmental_arch",
            () -> new Arch(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    /* public static final RegistryObject<Block> GREEN_BASALT_SMALL_ARCH = registerBlock("green_basalt_small_arch",
             () -> new ArchSmall(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                     .strength(1.5f, 6f)));
     public static final RegistryObject<Block> GREEN_BASALT_TWO_METER_ARCH = registerBlock("green_basalt_two_meter_arch",
             () -> new ArchTwoMeter(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                     .strength(1.5f, 6f)));
     public static final RegistryObject<Block> GREEN_BASALT_ARROWSLIT = registerBlock("green_basalt_arrowslit",
             () -> new ArrowSlit(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                     .strength(1.5f, 6f)));*/
    public static final RegistryObject<Block> GREEN_BASALT_BALUSTRADE = registerBlock("green_basalt_balustrade",
            () -> new Balustrade(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> GREEN_BASALT_BRICKS = registerBlock("green_basalt_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_STAIRS = registerBlock("green_basalt_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.GREEN_BASALT_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_SLAB = registerBlock("green_basalt_bricks_slab",
            () -> new AxialSlabBlock(GREEN_BASALT_BRICKS));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_WALL = registerBlock("green_basalt_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_GOTHIC_ARCH = registerBlock("green_basalt_bricks_gothic_arch",
            () -> new Arch(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_SEGMENTAL_ARCH = registerBlock("green_basalt_bricks_segmental_arch",
            () -> new Arch(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_ROUND_ARCH = registerBlock("green_basalt_bricks_round_arch",
            () -> new Arch(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_SMALL_ARCH = registerBlock("green_basalt_bricks_small_arch",
            () -> new ArchSmall(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_TWO_METER_ARCH = registerBlock("green_basalt_bricks_two_meter_arch",
            () -> new ArchTwoMeter(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_ARROWSLIT = registerBlock("green_basalt_bricks_arrowslit",
            () -> new ArrowSlit(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_BALUSTRADE = registerBlock("green_basalt_bricks_balustrade",
            () -> new Balustrade(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL = registerBlock
            ("green_basalt_bricks_corinthian_capital",
                    () -> new CubeCapitalCorinthian(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_PILLAR = registerBlock
            ("green_basalt_bricks_corinthian_capital_pillar",
                    () -> new PillarCapitalCorinthian(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_WALL = registerBlock
            ("green_basalt_bricks_corinthian_capital_wall",
                    () -> new WallCapitalCorinthian(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_IONIAN_CAPITAL = registerBlock
            ("green_basalt_bricks_ionian_capital",
                    () -> new Log(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_IONIAN_CAPITAL_LARGE_PILLAR = registerBlock
            ("green_basalt_bricks_ionian_capital_large_pillar",
                    () -> new PillarLargeRotated(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_IONIAN_CAPITAL_PILAR = registerBlock
            ("green_basalt_bricks_ionian_capital_pillar",
                    () -> new PillarRotated(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_IONIAN_CAPITAL_SMALL_PILLAR = registerBlock
            ("green_basalt_bricks_ionian_capital_small_pillar",
                    () -> new PillarSmallRotated(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_BRICKS_IONIAN_CAPITAL_WALL = registerBlock
            ("green_basalt_bricks_ionian_capital_wall",
                    () -> new Wall(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));


    public static final RegistryObject<Block> MOSSY_BASALT_BRICKS = registerBlock("mossy_basalt_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_BASALT_BRICKS_STAIRS = registerBlock("mossy_basalt_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_BASALT_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_BASALT_BRICKS_SLAB = registerBlock("mossy_basalt_bricks_slab",
            () -> new AxialSlabBlock(MOSSY_BASALT_BRICKS));
    public static final RegistryObject<Block> MOSSY_BASALT_BRICKS_WALL = registerBlock("mossy_basalt_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CHISELED_BASALT = registerBlock("chiseled_basalt",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_GREEN_BASALT = registerBlock("cracked_green_basalt",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_GREEN_BASALT_STAIRS = registerBlock("cracked_green_basalt_stairs",
            () -> new StairBlock(() -> BlockLoader.CRACKED_GREEN_BASALT.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_GREEN_BASALT_SLAB = registerBlock("cracked_green_basalt_slab",
            () -> new AxialSlabBlock(CRACKED_GREEN_BASALT));
    public static final RegistryObject<Block> CRACKED_GREEN_BASALT_WALL = registerBlock("cracked_green_basalt_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> GREEN_BASALT_COBBLESTONE = registerBlock("green_basalt_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_COBBLESTONE_STAIRS = registerBlock("green_basalt_cobblestone_stairs",
            () -> new StairBlock(() -> BlockLoader.GREEN_BASALT_COBBLESTONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_BASALT_COBBLESTONE_SLAB = registerBlock("green_basalt_cobblestone_slab",
            () -> new AxialSlabBlock(GREEN_BASALT_COBBLESTONE));
    public static final RegistryObject<Block> GREEN_BASALT_COBBLESTONE_WALL = registerBlock("green_basalt_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> GNEISS = registerBlock("gneiss",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GNEISS_STAIRS = registerBlock("gneiss_stairs",
            () -> new StairBlock(() -> BlockLoader.GNEISS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GNEISS_SLAB = registerBlock("gneiss_slab",
            () -> new AxialSlabBlock(GNEISS));
    public static final RegistryObject<Block> GNEISS_WALL = registerBlock("gneiss_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIMESTONE_STAIRS = registerBlock("limestone_stairs",
            () -> new StairBlock(() -> BlockLoader.LIMESTONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIMESTONE_SLAB = registerBlock("limestone_slab",
            () -> new AxialSlabBlock(LIMESTONE));
    public static final RegistryObject<Block> LIMESTONE_WALL = registerBlock("limestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CYAN_STONE = registerBlock("cyan_stone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CYAN_STONE_STAIRS = registerBlock("cyan_stone_stairs",
            () -> new StairBlock(() -> BlockLoader.CYAN_STONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CYAN_STONE_SLAB = registerBlock("cyan_stone_slab",
            () -> new AxialSlabBlock(CYAN_STONE));
    public static final RegistryObject<Block> CYAN_STONE_WALL = registerBlock("cyan_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> ORANGE_ROCK = registerBlock("orange_rock",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> ORANGE_ROCK_STAIRS = registerBlock("orange_rock_stairs",
            () -> new StairBlock(() -> BlockLoader.ORANGE_ROCK.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> ORANGE_ROCK_SLAB = registerBlock("orange_rock_slab",
            () -> new AxialSlabBlock(ORANGE_ROCK));
    public static final RegistryObject<Block> ORANGE_ROCK_WALL = registerBlock("orange_rock_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> RED_ROCK = registerBlock("red_rock",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> RED_ROCK_STAIRS = registerBlock("red_rock_stairs",
            () -> new StairBlock(() -> BlockLoader.RED_ROCK.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> RED_ROCK_SLAB = registerBlock("red_rock_slab",
            () -> new AxialSlabBlock(RED_ROCK));
    public static final RegistryObject<Block> RED_ROCK_WALL = registerBlock("red_rock_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> YELLOW_COBBLE = registerBlock("yellow_cobble",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> YELLOW_COBBLE_STAIRS = registerBlock("yellow_cobble_stairs",
            () -> new StairBlock(() -> BlockLoader.YELLOW_COBBLE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> YELLOW_COBBLE_SLAB = registerBlock("yellow_cobble_slab",
            () -> new AxialSlabBlock(YELLOW_COBBLE));
    public static final RegistryObject<Block> YELLOW_COBBLE_WALL = registerBlock("yellow_cobble_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CHALK = registerBlock("chalk",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CHALK_STAIRS = registerBlock("chalk_stairs",
            () -> new StairBlock(() -> BlockLoader.CHALK.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CHALK_SLAB = registerBlock("chalk_slab",
            () -> new AxialSlabBlock(CHALK));
    public static final RegistryObject<Block> CHALK_WALL = registerBlock("chalk_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CHALK_BRICKS = registerBlock("chalk_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CHALK_BRICKS_STAIRS = registerBlock("chalk_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CHALK_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CHALK_BRICKS_SLAB = registerBlock("chalk_bricks_slab",
            () -> new AxialSlabBlock(CHALK_BRICKS));
    public static final RegistryObject<Block> CHALK_BRICKS_WALL = registerBlock("chalk_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CHALK_PILLAR = registerBlock("chalk_pillar",
            () -> new EdumiaPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> HIGH_ELVEN_ROCK = registerBlock("high_elven_rock",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_ROCK_STAIRS = registerBlock("high_elven_rock_stairs",
            () -> new StairBlock(() -> BlockLoader.HIGH_ELVEN_ROCK.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_ROCK_SLAB = registerBlock("high_elven_rock_slab",
            () -> new AxialSlabBlock(HIGH_ELVEN_ROCK));
    public static final RegistryObject<Block> HIGH_ELVEN_ROCK_WALL = registerBlock("high_elven_rock_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> DARK_HIGH_ELVEN_ROCK = registerBlock("dark_high_elven_rock",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_ROCK_STAIRS = registerBlock("dark_high_elven_rock_stairs",
            () -> new StairBlock(() -> BlockLoader.DARK_HIGH_ELVEN_ROCK.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_ROCK_SLAB = registerBlock("dark_high_elven_rock_slab",
            () -> new AxialSlabBlock(DARK_HIGH_ELVEN_ROCK));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_ROCK_WALL = registerBlock("dark_high_elven_rock_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_ROCK = registerBlock("light_high_elven_rock",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_ROCK_STAIRS = registerBlock("light_high_elven_rock_stairs",
            () -> new StairBlock(() -> BlockLoader.HIGH_ELVEN_ROCK.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_ROCK_SLAB = registerBlock("light_high_elven_rock_slab",
            () -> new AxialSlabBlock(LIGHT_HIGH_ELVEN_ROCK));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_ROCK_WALL = registerBlock("light_high_elven_rock_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> HIGH_ELVEN_BRICKS = registerBlock("high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICKS_STAIRS = registerBlock("high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICKS_SLAB = registerBlock("high_elven_bricks_slab",
            () -> new AxialSlabBlock(HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICKS_WALL = registerBlock("high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICKS_GOTHIC_ARCH = registerBlock("high_elven_bricks_gothic_arch",
            () -> new Arch(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICKS_SEGMENTAL_ARCH = registerBlock("high_elven_bricks_segmental_arch",
            () -> new Arch(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICKS_ROUND_ARCH = registerBlock("high_elven_bricks_round_arch",
            () -> new Arch(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICKS_SMALL_ARCH = registerBlock("high_elven_bricks_small_arch",
            () -> new ArchSmall(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICKS_TWO_METER_ARCH = registerBlock("high_elven_bricks_two_meter_arch",
            () -> new ArchTwoMeter(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> SMALL_HIGH_ELVEN_BRICKS = registerBlock("small_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> SMALL_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("small_high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.SMALL_HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> SMALL_HIGH_ELVEN_BRICKS_SLAB = registerBlock("small_high_elven_bricks_slab",
            () -> new AxialSlabBlock(SMALL_HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> SMALL_HIGH_ELVEN_BRICKS_WALL = registerBlock("small_high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_PILLAR = registerBlock("high_elven_pillar",
            () -> new EdumiaPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> HIGH_ELVEN_BALUSTRADE = registerBlock("high_elven_balustrade",
            () -> new Balustrade(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICK_ARROWSLIT = registerBlock("high_elven_brick_arrowslit",
            () -> new ArrowSlit(BlockBehaviour.Properties.of()));


    public static final RegistryObject<Block> CHISELED_HIGH_ELVEN_BRICKS = registerBlock("chiseled_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CRACKED_HIGH_ELVEN_BRICKS = registerBlock("cracked_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("cracked_high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CRACKED_HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_HIGH_ELVEN_BRICKS_SLAB = registerBlock("cracked_high_elven_bricks_slab",
            () -> new AxialSlabBlock(CRACKED_HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> CRACKED_HIGH_ELVEN_BRICKS_WALL = registerBlock("cracked_high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_HIGH_ELVEN_BRICKS = registerBlock("mossy_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("mossy_high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_HIGH_ELVEN_BRICKS_SLAB = registerBlock("mossy_high_elven_bricks_slab",
            () -> new AxialSlabBlock(MOSSY_HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> MOSSY_HIGH_ELVEN_BRICKS_WALL = registerBlock("mossy_high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_BRICKS = registerBlock("light_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("light_high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.LIGHT_HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_BRICKS_SLAB = registerBlock("light_high_elven_bricks_slab",
            () -> new AxialSlabBlock(LIGHT_HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_BRICKS_WALL = registerBlock("light_high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_BALUSTRADE = registerBlock("light_high_elven_balustrade",
            () -> new Balustrade(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_PILLAR = registerBlock("light_high_elven_pillar",
            () -> new EdumiaPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> SMALL_LIGHT_HIGH_ELVEN_BRICKS = registerBlock("small_light_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> SMALL_LIGHT_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("small_light_high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> SMALL_LIGHT_HIGH_ELVEN_BRICKS_SLAB = registerBlock("small_light_high_elven_bricks_slab",
            () -> new AxialSlabBlock(SMALL_LIGHT_HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> SMALL_LIGHT_HIGH_ELVEN_BRICKS_WALL = registerBlock("small_light_high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CHISELED_LIGHT_HIGH_ELVEN_BRICKS = registerBlock("chiseled_light_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CRACKED_LIGHT_HIGH_ELVEN_BRICKS = registerBlock("cracked_light_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_LIGHT_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("cracked_light_high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_LIGHT_HIGH_ELVEN_BRICKS_SLAB = registerBlock("cracked_light_high_elven_bricks_slab",
            () -> new AxialSlabBlock(CRACKED_LIGHT_HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> CRACKED_LIGHT_HIGH_ELVEN_BRICKS_WALL = registerBlock("cracked_light_high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_LIGHT_HIGH_ELVEN_BRICKS = registerBlock("mossy_light_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_LIGHT_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("mossy_light_high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_LIGHT_HIGH_ELVEN_BRICKS_SLAB = registerBlock("mossy_light_high_elven_bricks_slab",
            () -> new AxialSlabBlock(MOSSY_LIGHT_HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> MOSSY_LIGHT_HIGH_ELVEN_BRICKS_WALL = registerBlock("mossy_light_high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> DARK_HIGH_ELVEN_BRICKS = registerBlock("dark_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("dark_high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.DARK_HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_BRICKS_SLAB = registerBlock("dark_high_elven_bricks_slab",
            () -> new AxialSlabBlock(DARK_HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_BRICKS_WALL = registerBlock("dark_high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_BALUSTRADE = registerBlock("dark_high_elven_balustrade",
            () -> new Balustrade(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_PILLAR = registerBlock("dark_high_elven_pillar",
            () -> new EdumiaPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> SMALL_DARK_HIGH_ELVEN_BRICKS = registerBlock("small_dark_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> SMALL_DARK_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("small_dark_high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> SMALL_DARK_HIGH_ELVEN_BRICKS_SLAB = registerBlock("small_dark_high_elven_bricks_slab",
            () -> new AxialSlabBlock(SMALL_DARK_HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> SMALL_DARK_HIGH_ELVEN_BRICKS_WALL = registerBlock("small_dark_high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CHISELED_DARK_HIGH_ELVEN_BRICKS = registerBlock("chiseled_dark_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CRACKED_DARK_HIGH_ELVEN_BRICKS = registerBlock("cracked_dark_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_DARK_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("cracked_dark_high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_DARK_HIGH_ELVEN_BRICKS_SLAB = registerBlock("cracked_dark_high_elven_bricks_slab",
            () -> new AxialSlabBlock(CRACKED_DARK_HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> CRACKED_DARK_HIGH_ELVEN_BRICKS_WALL = registerBlock("cracked_dark_high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_DARK_HIGH_ELVEN_BRICKS = registerBlock("mossy_dark_high_elven_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_DARK_HIGH_ELVEN_BRICKS_STAIRS = registerBlock("mossy_dark_high_elven_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_DARK_HIGH_ELVEN_BRICKS_SLAB = registerBlock("mossy_dark_high_elven_bricks_slab",
            () -> new AxialSlabBlock(MOSSY_DARK_HIGH_ELVEN_BRICKS));
    public static final RegistryObject<Block> MOSSY_DARK_HIGH_ELVEN_BRICKS_WALL = registerBlock("mossy_dark_high_elven_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> BROWN_SANDSTONE_BRICKS = registerBlock("brown_sandstone_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BROWN_SANDSTONE_BRICKS_STAIRS = registerBlock("brown_sandstone_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.BROWN_SANDSTONE_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BROWN_SANDSTONE_BRICKS_SLAB = registerBlock("brown_sandstone_bricks_slab",
            () -> new AxialSlabBlock(BROWN_SANDSTONE_BRICKS));
    public static final RegistryObject<Block> BROWN_SANDSTONE_BRICKS_WALL = registerBlock("brown_sandstone_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> CARVED_BROWN_SANDSTONE_BRICKS = registerBlock("carved_brown_sandstone_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CRACKED_BROWN_SANDSTONE_BRICKS = registerBlock("cracked_brown_sandstone_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_BROWN_SANDSTONE_BRICKS_STAIRS = registerBlock("cracked_brown_sandstone_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_BROWN_SANDSTONE_BRICKS_SLAB = registerBlock("cracked_brown_sandstone_bricks_slab",
            () -> new AxialSlabBlock(CRACKED_BROWN_SANDSTONE_BRICKS));
    public static final RegistryObject<Block> CRACKED_BROWN_SANDSTONE_BRICKS_WALL = registerBlock("cracked_brown_sandstone_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_BROWN_SANDSTONE_BRICKS = registerBlock("mossy_brown_sandstone_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_BROWN_SANDSTONE_BRICKS_STAIRS = registerBlock("mossy_brown_sandstone_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_BROWN_SANDSTONE_BRICKS_SLAB = registerBlock("mossy_brown_sandstone_bricks_slab",
            () -> new AxialSlabBlock(MOSSY_BROWN_SANDSTONE_BRICKS));
    public static final RegistryObject<Block> MOSSY_BROWN_SANDSTONE_BRICKS_WALL = registerBlock("mossy_brown_sandstone_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CACHOLONG_BRICKS = registerBlock("cacholong_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CACHOLONG_BRICKS_STAIRS = registerBlock("cacholong_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CACHOLONG_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CACHOLONG_BRICKS_SLAB = registerBlock("cacholong_bricks_slab",
            () -> new AxialSlabBlock(CACHOLONG_BRICKS));
    public static final RegistryObject<Block> CACHOLONG_BRICKS_WALL = registerBlock("cacholong_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CACHOLONG_PILLAR = registerBlock("cacholong_pillar",
            () -> new EdumiaPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> CARVED_CACHOLONG_BRICKS = registerBlock("carved_cacholong_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CRACKED_CACHOLONG_BRICKS = registerBlock("cracked_cacholong_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_CACHOLONG_BRICKS_STAIRS = registerBlock("cracked_cacholong_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CRACKED_CACHOLONG_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_CACHOLONG_BRICKS_SLAB = registerBlock("cracked_cacholong_bricks_slab",
            () -> new AxialSlabBlock(CRACKED_CACHOLONG_BRICKS));
    public static final RegistryObject<Block> CRACKED_CACHOLONG_BRICKS_WALL = registerBlock("cracked_cacholong_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_CACHOLONG_BRICKS = registerBlock("mossy_cacholong_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_CACHOLONG_BRICKS_STAIRS = registerBlock("mossy_cacholong_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_CACHOLONG_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_CACHOLONG_BRICKS_SLAB = registerBlock("mossy_cacholong_bricks_slab",
            () -> new AxialSlabBlock(MOSSY_CACHOLONG_BRICKS));
    public static final RegistryObject<Block> MOSSY_CACHOLONG_BRICKS_WALL = registerBlock("mossy_cacholong_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> BLACK_DEMON_BRICKS = registerBlock("black_demon_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLACK_DEMON_BRICKS_STAIRS = registerBlock("black_demon_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.BLACK_DEMON_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLACK_DEMON_BRICKS_SLAB = registerBlock("black_demon_bricks_slab",
            () -> new AxialSlabBlock(BLACK_DEMON_BRICKS));
    public static final RegistryObject<Block> BLACK_DEMON_BRICKS_WALL = registerBlock("black_demon_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> CARVED_BLACK_DEMON_BRICKS = registerBlock("carved_black_demon_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CRACKED_BLACK_DEMON_BRICKS = registerBlock("cracked_black_demon_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_BLACK_DEMON_BRICKS_STAIRS = registerBlock("cracked_black_demon_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CRACKED_BLACK_DEMON_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_BLACK_DEMON_BRICKS_SLAB = registerBlock("cracked_black_demon_bricks_slab",
            () -> new AxialSlabBlock(CRACKED_BLACK_DEMON_BRICKS));
    public static final RegistryObject<Block> CRACKED_BLACK_DEMON_BRICKS_WALL = registerBlock("cracked_black_demon_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_BLACK_DEMON_BRICKS = registerBlock("mossy_black_demon_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_BLACK_DEMON_BRICKS_STAIRS = registerBlock("mossy_black_demon_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_BLACK_DEMON_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_BLACK_DEMON_BRICKS_SLAB = registerBlock("mossy_black_demon_bricks_slab",
            () -> new AxialSlabBlock(MOSSY_BLACK_DEMON_BRICKS));
    public static final RegistryObject<Block> MOSSY_BLACK_DEMON_BRICKS_WALL = registerBlock("mossy_black_demon_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> BLUE_BRICKS = registerBlock("blue_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLUE_BRICKS_STAIRS = registerBlock("blue_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.BLUE_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLUE_BRICKS_SLAB = registerBlock("blue_bricks_slab",
            () -> new AxialSlabBlock(BLUE_BRICKS));
    public static final RegistryObject<Block> BLUE_BRICKS_WALL = registerBlock("blue_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> CARVED_BLUE_BRICKS = registerBlock("carved_blue_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CRACKED_BLUE_BRICKS = registerBlock("cracked_blue_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_BLUE_BRICKS_STAIRS = registerBlock("cracked_blue_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CRACKED_BLUE_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_BLUE_BRICKS_SLAB = registerBlock("cracked_blue_bricks_slab",
            () -> new AxialSlabBlock(CRACKED_BLUE_BRICKS));
    public static final RegistryObject<Block> CRACKED_BLUE_BRICKS_WALL = registerBlock("cracked_blue_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_BLUE_BRICKS = registerBlock("mossy_blue_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_BLUE_BRICKS_STAIRS = registerBlock("mossy_blue_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_BLUE_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_BLUE_BRICKS_SLAB = registerBlock("mossy_blue_bricks_slab",
            () -> new AxialSlabBlock(MOSSY_BLUE_BRICKS));
    public static final RegistryObject<Block> MOSSY_BLUE_BRICKS_WALL = registerBlock("mossy_blue_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> DEMON_BASALT_BRICKS = registerBlock("demon_basalt_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DEMON_BASALT_BRICKS_STAIRS = registerBlock("demon_basalt_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.DEMON_BASALT_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DEMON_BASALT_BRICKS_SLAB = registerBlock("demon_basalt_bricks_slab",
            () -> new AxialSlabBlock(DEMON_BASALT_BRICKS));
    public static final RegistryObject<Block> DEMON_BASALT_BRICKS_WALL = registerBlock("demon_basalt_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CARVED_DEMON_BASALT_BRICKS = registerBlock("carved_demon_basalt_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> VULCANIC_ROCK = registerBlock("vulcanic_rock",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> VULCANIC_ROCK_STAIRS = registerBlock("vulcanic_rock_stairs",
            () -> new StairBlock(() -> BlockLoader.VULCANIC_ROCK.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> VULCANIC_ROCK_SLAB = registerBlock("vulcanic_rock_slab",
            () -> new AxialSlabBlock(VULCANIC_ROCK));
    public static final RegistryObject<Block> VULCANIC_ROCK_WALL = registerBlock("vulcanic_rock_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> VULCANIC_DEMON_BRICKS = registerBlock("vulcanic_demon_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> VULCANIC_DEMON_BRICKS_STAIRS = registerBlock("vulcanic_demon_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.VULCANIC_DEMON_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> VULCANIC_DEMON_BRICKS_SLAB = registerBlock("vulcanic_demon_bricks_slab",
            () -> new AxialSlabBlock(VULCANIC_DEMON_BRICKS));
    public static final RegistryObject<Block> VULCANIC_DEMON_BRICKS_WALL = registerBlock("vulcanic_demon_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CARVED_VULCANIC_DEMON_BRICKS = registerBlock("carved_vulcanic_demon_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CRACKED_VULCANIC_DEMON_BRICKS = registerBlock("cracked_vulcanic_demon_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_VULCANIC_DEMON_BRICKS_STAIRS = registerBlock("cracked_vulcanic_demon_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_VULCANIC_DEMON_BRICKS_SLAB = registerBlock("cracked_vulcanic_demon_bricks_slab",
            () -> new AxialSlabBlock(CRACKED_VULCANIC_DEMON_BRICKS));
    public static final RegistryObject<Block> CRACKED_VULCANIC_DEMON_BRICKS_WALL = registerBlock("cracked_vulcanic_demon_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_VULCANIC_DEMON_BRICKS = registerBlock("mossy_vulcanic_demon_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_VULCANIC_DEMON_BRICKS_STAIRS = registerBlock("mossy_vulcanic_demon_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_VULCANIC_DEMON_BRICKS_SLAB = registerBlock("mossy_vulcanic_demon_bricks_slab",
            () -> new AxialSlabBlock(MOSSY_VULCANIC_DEMON_BRICKS));
    public static final RegistryObject<Block> MOSSY_VULCANIC_DEMON_BRICKS_WALL = registerBlock("mossy_vulcanic_demon_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> RED_BRICKS = registerBlock("red_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> RED_BRICKS_STAIRS = registerBlock("red_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.RED_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> RED_BRICKS_SLAB = registerBlock("red_bricks_slab",
            () -> new AxialSlabBlock(RED_BRICKS));
    public static final RegistryObject<Block> RED_BRICKS_WALL = registerBlock("red_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> RED_PILLAR = registerBlock("red_pillar",
            () -> new EdumiaPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CARVED_RED_BRICKS = registerBlock("carved_red_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> CRACKED_RED_BRICKS = registerBlock("cracked_red_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_RED_BRICKS_STAIRS = registerBlock("cracked_red_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CRACKED_RED_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_RED_BRICKS_SLAB = registerBlock("cracked_red_bricks_slab",
            () -> new AxialSlabBlock(CRACKED_RED_BRICKS));
    public static final RegistryObject<Block> CRACKED_RED_BRICKS_WALL = registerBlock("cracked_red_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_RED_BRICKS = registerBlock("mossy_red_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_RED_BRICKS_STAIRS = registerBlock("mossy_red_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_RED_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_RED_BRICKS_SLAB = registerBlock("mossy_red_bricks_slab",
            () -> new AxialSlabBlock(MOSSY_RED_BRICKS));
    public static final RegistryObject<Block> MOSSY_RED_BRICKS_WALL = registerBlock("mossy_red_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> DESERT_MUD_BRICKS = registerBlock("desert_mud_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DESERT_MUD_BRICKS_STAIRS = registerBlock("desert_mud_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.DESERT_MUD_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DESERT_MUD_BRICKS_SLAB = registerBlock("desert_mud_bricks_slab",
            () -> new AxialSlabBlock(DESERT_MUD_BRICKS));
    public static final RegistryObject<Block> DESERT_MUD_BRICKS_WALL = registerBlock("desert_mud_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));


    public static final RegistryObject<Block> CRACKED_DESERT_MUD_BRICKS = registerBlock("cracked_desert_mud_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_DESERT_MUD_BRICKS_STAIRS = registerBlock("cracked_desert_mud_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.CRACKED_DESERT_MUD_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CRACKED_DESERT_MUD_BRICKS_SLAB = registerBlock("cracked_desert_mud_bricks_slab",
            () -> new AxialSlabBlock(CRACKED_DESERT_MUD_BRICKS));
    public static final RegistryObject<Block> CRACKED_DESERT_MUD_BRICKS_WALL = registerBlock("cracked_desert_mud_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_DESERT_MUD_BRICKS = registerBlock("mossy_desert_mud_bricks",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_DESERT_MUD_BRICKS_STAIRS = registerBlock("mossy_desert_mud_bricks_stairs",
            () -> new StairBlock(() -> BlockLoader.DESERT_MUD_BRICKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_DESERT_MUD_BRICKS_SLAB = registerBlock("mossy_desert_mud_bricks_slab",
            () -> new AxialSlabBlock(MOSSY_DESERT_MUD_BRICKS));
    public static final RegistryObject<Block> MOSSY_DESERT_MUD_BRICKS_WALL = registerBlock("mossy_desert_mud_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> HIGH_ELVEN_BRICK_TILING = registerBlock("high_elven_brick_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICK_TILING_STAIRS = registerBlock("high_elven_brick_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.HIGH_ELVEN_BRICK_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_BRICK_TILING_SLAB = registerBlock("high_elven_brick_tiling_slab",
            () -> new AxialSlabBlock(HIGH_ELVEN_BRICK_TILING));

    public static final RegistryObject<Block> DARK_HIGH_ELVEN_BRICK_TILING = registerBlock("dark_high_elven_brick_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_BRICK_TILING_STAIRS = registerBlock("dark_high_elven_brick_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_BRICK_TILING_SLAB = registerBlock("dark_high_elven_brick_tiling_slab",
            () -> new AxialSlabBlock(DARK_HIGH_ELVEN_BRICK_TILING));


    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_BRICK_TILING = registerBlock("light_high_elven_brick_tiling",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS = registerBlock("light_high_elven_brick_tiling_stairs",
            () -> new StairBlock(() -> BlockLoader.HIGH_ELVEN_BRICK_TILING.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB = registerBlock("light_high_elven_brick_tiling_slab",
            () -> new AxialSlabBlock(LIGHT_HIGH_ELVEN_BRICK_TILING));


    public static final RegistryObject<Block> HIGH_ELVEN_COBBLESTONE = registerBlock("high_elven_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("high_elven_cobblestone_stairs",
            () -> new StairBlock(() -> BlockLoader.HIGH_ELVEN_COBBLESTONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("high_elven_cobblestone_slab",
            () -> new AxialSlabBlock(HIGH_ELVEN_COBBLESTONE));
    public static final RegistryObject<Block> HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("high_elven_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_HIGH_ELVEN_COBBLESTONE = registerBlock("mossy_high_elven_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("mossy_high_elven_cobblestone_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("mossy_high_elven_cobblestone_slab",
            () -> new AxialSlabBlock(MOSSY_HIGH_ELVEN_COBBLESTONE));
    public static final RegistryObject<Block> MOSSY_HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("mossy_high_elven_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_COBBLESTONE = registerBlock("light_high_elven_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("light_high_elven_cobblestone_stairs",
            () -> new StairBlock(() -> BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("light_high_elven_cobblestone_slab",
            () -> new AxialSlabBlock(LIGHT_HIGH_ELVEN_COBBLESTONE));
    public static final RegistryObject<Block> LIGHT_HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("light_high_elven_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE = registerBlock("mossy_light_high_elven_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("mossy_light_high_elven_cobblestone_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("mossy_light_high_elven_cobblestone_slab",
            () -> new AxialSlabBlock(MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE));
    public static final RegistryObject<Block> MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("mossy_light_high_elven_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> DARK_HIGH_ELVEN_COBBLESTONE = registerBlock("dark_high_elven_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("dark_high_elven_cobblestone_stairs",
            () -> new StairBlock(() -> BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("dark_high_elven_cobblestone_slab",
            () -> new AxialSlabBlock(DARK_HIGH_ELVEN_COBBLESTONE));
    public static final RegistryObject<Block> DARK_HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("dark_high_elven_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));

    public static final RegistryObject<Block> MOSSY_DARK_HIGH_ELVEN_COBBLESTONE = registerBlock("mossy_dark_high_elven_cobblestone",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_STAIRS = registerBlock("mossy_dark_high_elven_cobblestone_stairs",
            () -> new StairBlock(() -> BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_SLAB = registerBlock("mossy_dark_high_elven_cobblestone_slab",
            () -> new AxialSlabBlock(MOSSY_DARK_HIGH_ELVEN_COBBLESTONE));
    public static final RegistryObject<Block> MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_WALL = registerBlock("mossy_dark_high_elven_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));









    public static final RegistryObject<Block> BROWN_SANDSTONE_SLATES = registerBlock("brown_sandstone_slates",
            () -> new EdumiaStoneBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));



    public static final RegistryObject<Block> MARBLE_PINK = registerBlock("marble_pink",
            () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                    .strength(1.5f, 6f)));
    //ores
    public static final RegistryObject<Block> TOPAZ_ORE = registerBlock("topaz_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ORE_VEIL = registerBlock("ore_veil",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registerBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()));


    //wood
    public static final RegistryObject<Block> APPLE_PLANKS = registerBlock("apple_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> APPLE_FENCE = registerBlock("apple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> APPLE_FENCE_GATE = registerBlock("apple_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(APPLE_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> APPLE_PLANKS_STAIRS = registerBlock("apple_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.APPLE_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> APPLE_PLANKS_SLAB = registerBlock("apple_planks_slab",
            () -> new AxialSlabBlock(APPLE_PLANKS));
    public static final RegistryObject<Block> APPLE_LOG = registerBlock("apple_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> APPLE_WOOD = registerBlock("apple_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_APPLE_LOG = registerBlock("stripped_apple_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_APPLE_WOOD = registerBlock("stripped_apple_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> APPLE_LEAVES = registerBlock("apple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> APPLE_SAPLING = registerBlock("apple_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> ASPEN_PLANKS = registerBlock("aspen_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> ASPEN_FENCE = registerBlock("aspen_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> ASPEN_FENCE_GATE = registerBlock("aspen_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(ASPEN_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> ASPEN_PLANKS_STAIRS = registerBlock("aspen_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.ASPEN_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> ASPEN_PLANKS_SLAB = registerBlock("aspen_planks_slab",
            () -> new AxialSlabBlock(ASPEN_PLANKS));
    public static final RegistryObject<Block> ASPEN_LOG = registerBlock("aspen_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> ASPEN_WOOD = registerBlock("aspen_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_ASPEN_LOG = registerBlock("stripped_aspen_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_ASPEN_WOOD = registerBlock("stripped_aspen_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> ASPEN_LEAVES = registerBlock("aspen_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> ASPEN_SAPLING = registerBlock("aspen_sapling",
            () -> new SaplingBlock(new AspenTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> BAOBAB_PLANKS = registerBlock("baobab_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> BAOBAB_FENCE = registerBlock("baobab_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> BAOBAB_FENCE_GATE = registerBlock("baobab_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(BAOBAB_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> BAOBAB_PLANKS_STAIRS = registerBlock("baobab_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.BAOBAB_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BAOBAB_PLANKS_SLAB = registerBlock("baobab_planks_slab",
            () -> new AxialSlabBlock(BAOBAB_PLANKS));
    /*public static final RegistryObject<Block> BAOBAB_LOG = registerBlock("baobab_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> BAOBAB_WOOD = registerBlock("baobab_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_BAOBAB_LOG = registerBlock("stripped_baobab_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_BAOBAB_WOOD = registerBlock("stripped_baobab_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> BAOBAB_LEAVES = registerBlock("baobab_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> BAOBAB_SAPLING = registerBlock("baobab_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));*/


    public static final RegistryObject<Block> BEECH_PLANKS = registerBlock("beech_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> BEECH_FENCE = registerBlock("beech_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> BEECH_FENCE_GATE = registerBlock("beech_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(BEECH_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> BEECH_PLANKS_STAIRS = registerBlock("beech_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.BEECH_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BEECH_PLANKS_SLAB = registerBlock("beech_planks_slab",
            () -> new AxialSlabBlock(BEECH_PLANKS));
    public static final RegistryObject<Block> BEECH_LOG = registerBlock("beech_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> BEECH_WOOD = registerBlock("beech_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_BEECH_LOG = registerBlock("stripped_beech_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_BEECH_WOOD = registerBlock("stripped_beech_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> BEECH_LEAVES = registerBlock("beech_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> BEECH_SAPLING = registerBlock("beech_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> BLACKTHORN_PLANKS = registerBlock("blackthorn_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> BLACKTHORN_FENCE = registerBlock("blackthorn_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> BLACKTHORN_FENCE_GATE = registerBlock("blackthorn_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(BLACKTHORN_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> BLACKTHORN_PLANKS_STAIRS = registerBlock("blackthorn_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.BLACKTHORN_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> BLACKTHORN_PLANKS_SLAB = registerBlock("blackthorn_planks_slab",
            () -> new AxialSlabBlock(BLACKTHORN_PLANKS));
    public static final RegistryObject<Block> BLACKTHORN_LOG = registerBlock("blackthorn_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> BLACKTHORN_WOOD = registerBlock("blackthorn_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_BLACKTHORN_LOG = registerBlock("stripped_blackthorn_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_BLACKTHORN_WOOD = registerBlock("stripped_blackthorn_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> BLACKTHORN_LEAVES = registerBlock("blackthorn_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> BLACKTHORN_SAPLING = registerBlock("blackthorn_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> CEDAR_PLANKS = registerBlock("cedar_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> CEDAR_FENCE = registerBlock("cedar_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> CEDAR_FENCE_GATE = registerBlock("cedar_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(CEDAR_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> CEDAR_PLANKS_STAIRS = registerBlock("cedar_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.CEDAR_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CEDAR_PLANKS_SLAB = registerBlock("cedar_planks_slab",
            () -> new AxialSlabBlock(CEDAR_PLANKS));
    public static final RegistryObject<Block> CEDAR_LOG = registerBlock("cedar_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> CEDAR_WOOD = registerBlock("cedar_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_CEDAR_LOG = registerBlock("stripped_cedar_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_CEDAR_WOOD = registerBlock("stripped_cedar_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> CEDAR_LEAVES = registerBlock("cedar_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CEDAR_SAPLING = registerBlock("cedar_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> CHERRY_PLANKS = registerBlock("cherry_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> CHERRY_FENCE = registerBlock("cherry_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> CHERRY_FENCE_GATE = registerBlock("cherry_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(CHERRY_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> CHERRY_PLANKS_STAIRS = registerBlock("cherry_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.CHERRY_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CHERRY_PLANKS_SLAB = registerBlock("cherry_planks_slab",
            () -> new AxialSlabBlock(CHERRY_PLANKS));
    public static final RegistryObject<Block> CHERRY_LOG = registerBlock("cherry_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> CHERRY_WOOD = registerBlock("cherry_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_CHERRY_LOG = registerBlock("stripped_cherry_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = registerBlock("stripped_cherry_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> CHERRY_LEAVES = registerBlock("cherry_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CHERRY_SAPLING = registerBlock("cherry_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> CYPRESS_PLANKS = registerBlock("cypress_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> CYPRESS_FENCE = registerBlock("cypress_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> CYPRESS_FENCE_GATE = registerBlock("cypress_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(CYPRESS_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> CYPRESS_PLANKS_STAIRS = registerBlock("cypress_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.CYPRESS_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> CYPRESS_PLANKS_SLAB = registerBlock("cypress_planks_slab",
            () -> new AxialSlabBlock(CYPRESS_PLANKS));
    public static final RegistryObject<Block> CYPRESS_LOG = registerBlock("cypress_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> CYPRESS_WOOD = registerBlock("cypress_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_CYPRESS_LOG = registerBlock("stripped_cypress_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_CYPRESS_WOOD = registerBlock("stripped_cypress_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> CYPRESS_LEAVES = registerBlock("cypress_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CYPRESS_SAPLING = registerBlock("cypress_sapling",
            () -> new SaplingBlock(new CypressTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));




    public static final RegistryObject<Block> FIR_PLANKS = registerBlock("fir_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> FIR_FENCE = registerBlock("fir_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> FIR_FENCE_GATE = registerBlock("fir_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(FIR_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> FIR_PLANKS_STAIRS = registerBlock("fir_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.FIR_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> FIR_PLANKS_SLAB = registerBlock("fir_planks_slab",
            () -> new AxialSlabBlock(FIR_PLANKS));
    public static final RegistryObject<Block> FIR_LOG = registerBlock("fir_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> FIR_WOOD = registerBlock("fir_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_FIR_LOG = registerBlock("stripped_fir_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_FIR_WOOD = registerBlock("stripped_fir_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> FIR_LEAVES = registerBlock("fir_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FIR_SAPLING = registerBlock("fir_sapling",
            () -> new SaplingBlock(new FirTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> GHOST_GUM_PLANKS = registerBlock("ghost_gum_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> GHOST_GUM_FENCE = registerBlock("ghost_gum_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> GHOST_GUM_FENCE_GATE = registerBlock("ghost_gum_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(GHOST_GUM_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> GHOST_GUM_PLANKS_STAIRS = registerBlock("ghost_gum_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.GHOST_GUM_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GHOST_GUM_PLANKS_SLAB = registerBlock("ghost_gum_planks_slab",
            () -> new AxialSlabBlock(GHOST_GUM_PLANKS));
    public static final RegistryObject<Block> GHOST_GUM_LOG = registerBlock("ghost_gum_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> GHOST_GUM_WOOD = registerBlock("ghost_gum_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_GHOST_GUM_LOG = registerBlock("stripped_ghost_gum_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_GHOST_GUM_WOOD = registerBlock("stripped_ghost_gum_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> GHOST_GUM_LEAVES = registerBlock("ghost_gum_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GHOST_GUM_SAPLING = registerBlock("ghost_gum_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> GREEN_OAK_PLANKS = registerBlock("green_oak_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> GREEN_OAK_FENCE = registerBlock("green_oak_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> GREEN_OAK_FENCE_GATE = registerBlock("green_oak_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(GREEN_OAK_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> GREEN_OAK_PLANKS_STAIRS = registerBlock("green_oak_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.GREEN_OAK_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> GREEN_OAK_PLANKS_SLAB = registerBlock("green_oak_planks_slab",
            () -> new AxialSlabBlock(GREEN_OAK_PLANKS));
    public static final RegistryObject<Block> GREEN_OAK_LOG = registerBlock("green_oak_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> GREEN_OAK_WOOD = registerBlock("green_oak_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_GREEN_OAK_LOG = registerBlock("stripped_green_oak_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_GREEN_OAK_WOOD = registerBlock("stripped_green_oak_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> GREEN_OAK_LEAVES = registerBlock("green_oak_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GREEN_OAK_SAPLING = registerBlock("green_oak_sapling",
            () -> new SaplingBlock(new GreenOakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> HOLLY_PLANKS = registerBlock("holly_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> HOLLY_FENCE = registerBlock("holly_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> HOLLY_FENCE_GATE = registerBlock("holly_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(HOLLY_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> HOLLY_PLANKS_STAIRS = registerBlock("holly_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.HOLLY_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> HOLLY_PLANKS_SLAB = registerBlock("holly_planks_slab",
            () -> new AxialSlabBlock(HOLLY_PLANKS));
    public static final RegistryObject<Block> HOLLY_LOG = registerBlock("holly_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> HOLLY_WOOD = registerBlock("holly_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_HOLLY_LOG = registerBlock("stripped_holly_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_HOLLY_WOOD = registerBlock("stripped_holly_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> HOLLY_LEAVES = registerBlock("holly_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> HOLLY_SAPLING = registerBlock("holly_sapling",
            () -> new SaplingBlock(new HollyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> LARCH_PLANKS = registerBlock("larch_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> LARCH_FENCE = registerBlock("larch_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> LARCH_FENCE_GATE = registerBlock("larch_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(LARCH_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> LARCH_PLANKS_STAIRS = registerBlock("larch_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.LARCH_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> LARCH_PLANKS_SLAB = registerBlock("larch_planks_slab",
            () -> new AxialSlabBlock(LARCH_PLANKS));
    public static final RegistryObject<Block> LARCH_LOG = registerBlock("larch_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> LARCH_WOOD = registerBlock("larch_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_LARCH_LOG = registerBlock("stripped_larch_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_LARCH_WOOD = registerBlock("stripped_larch_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> LARCH_LEAVES = registerBlock("larch_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> LARCH_SAPLING = registerBlock("larch_sapling",
            () -> new SaplingBlock(new LarchTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> MAPLE_PLANKS = registerBlock("maple_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> MAPLE_FENCE = registerBlock("maple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(MAPLE_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> MAPLE_PLANKS_STAIRS = registerBlock("maple_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.MAPLE_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> MAPLE_PLANKS_SLAB = registerBlock("maple_planks_slab",
            () -> new AxialSlabBlock(MAPLE_PLANKS));
    public static final RegistryObject<Block> MAPLE_LOG = registerBlock("maple_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> MAPLE_WOOD = registerBlock("maple_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> MAPLE_LEAVES = registerBlock("maple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> MAPLE_SAPLING = registerBlock("maple_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> OKOME_PLANKS = registerBlock("okome_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> OKOME_FENCE = registerBlock("okome_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> OKOME_FENCE_GATE = registerBlock("okome_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(OKOME_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> OKOME_PLANKS_STAIRS = registerBlock("okome_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.OKOME_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> OKOME_PLANKS_SLAB = registerBlock("okome_planks_slab",
            () -> new AxialSlabBlock(OKOME_PLANKS));

    //public static final RegistryObject<Block> OKOME_LEAVES = registerBlock("okome_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of().strength(0.5f)));


    public static final RegistryObject<Block> PEAR_PLANKS = registerBlock("pear_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> PEAR_FENCE = registerBlock("pear_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> PEAR_FENCE_GATE = registerBlock("pear_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(PEAR_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> PEAR_PLANKS_STAIRS = registerBlock("pear_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.PEAR_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> PEAR_PLANKS_SLAB = registerBlock("pear_planks_slab",
            () -> new AxialSlabBlock(PEAR_PLANKS));
    public static final RegistryObject<Block> PEAR_LOG = registerBlock("pear_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> PEAR_WOOD = registerBlock("pear_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_PEAR_LOG = registerBlock("stripped_pear_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_PEAR_WOOD = registerBlock("stripped_pear_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> PEAR_LEAVES = registerBlock("pear_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PEAR_SAPLING = registerBlock("pear_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> PINE_PLANKS = registerBlock("pine_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> PINE_FENCE = registerBlock("pine_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> PINE_FENCE_GATE = registerBlock("pine_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(PINE_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> PINE_PLANKS_STAIRS = registerBlock("pine_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.PINE_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> PINE_PLANKS_SLAB = registerBlock("pine_planks_slab",
            () -> new AxialSlabBlock(PINE_PLANKS));
    public static final RegistryObject<Block> PINE_LOG = registerBlock("pine_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> PINE_WOOD = registerBlock("pine_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_PINE_LOG = registerBlock("stripped_pine_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> PINE_LEAVES = registerBlock("pine_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PINE_SAPLING = registerBlock("pine_sapling",
            () -> new SaplingBlock(new PineTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> PLUM_PLANKS = registerBlock("plum_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> PLUM_FENCE = registerBlock("plum_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> PLUM_FENCE_GATE = registerBlock("plum_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(PLUM_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> PLUM_PLANKS_STAIRS = registerBlock("plum_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.PLUM_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> PLUM_PLANKS_SLAB = registerBlock("plum_planks_slab",
            () -> new AxialSlabBlock(PLUM_PLANKS));


    public static final RegistryObject<Block> RED_OAK_PLANKS = registerBlock("red_oak_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> RED_OAK_FENCE = registerBlock("red_oak_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> RED_OAK_FENCE_GATE = registerBlock("red_oak_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(RED_OAK_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> RED_OAK_PLANKS_STAIRS = registerBlock("red_oak_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.RED_OAK_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> RED_OAK_PLANKS_SLAB = registerBlock("red_oak_planks_slab",
            () -> new AxialSlabBlock(RED_OAK_PLANKS));
    public static final RegistryObject<Block> RED_OAK_LOG = registerBlock("red_oak_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> RED_OAK_WOOD = registerBlock("red_oak_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_RED_OAK_LOG = registerBlock("stripped_red_oak_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_RED_OAK_WOOD = registerBlock("stripped_red_oak_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> RED_OAK_LEAVES = registerBlock("red_oak_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> RED_OAK_SAPLING = registerBlock("red_oak_sapling",
            () -> new SaplingBlock(new RedOakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> REDWOOD_PLANKS = registerBlock("redwood_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> REDWOOD_FENCE = registerBlock("redwood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> REDWOOD_FENCE_GATE = registerBlock("redwood_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(REDWOOD_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<StairBlock> REDWOOD_PLANKS_STAIRS = registerBlock("redwood_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.REDWOOD_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> REDWOOD_PLANKS_SLAB = registerBlock("redwood_planks_slab",
            () -> new AxialSlabBlock(REDWOOD_PLANKS));
    public static final RegistryObject<Block> REDWOOD_PRESSURE_PLATE = registerBlock("redwood_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.of(), BlockSetType.ACACIA));
    public static final RegistryObject<Block> REDWOOD_BUTTON = registerBlock("redwood_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.of(), BlockSetType.ACACIA, 10, true));
    public static final RegistryObject<RotatedPillarBlock> REDWOOD_LOG = registerBlock("redwood_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> REDWOOD_WOOD = registerBlock("redwood_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_REDWOOD_LOG = registerBlock("stripped_redwood_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<RotatedPillarBlock> STRIPPED_REDWOOD_WOOD = registerBlock("stripped_redwood_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    //    public static final RegistryObject<Block> APPLE_LEAVES = registerBlock("apple_leaves",
//            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
//                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
//                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<DoorBlock> REDWOOD_DOOR = registerBlock("redwood_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.ACACIA));
    public static final RegistryObject<TrapDoorBlock> REDWOOD_TRAPDOOR = registerBlock("redwood_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.ACACIA));
    public static final RegistryObject<Block> REDWOOD_SAPLING = registerBlock("redwood_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.of()));
    public static final RegistryObject<BanisterBlock> REDWOOD_BANISTER = registerBlock("redwood_banister",
            () -> new BanisterBlock( BlockBehaviour.Properties.of()));
    public static final RegistryObject<Balustrade> REDWOOD_BALUSTRADE = registerBlock("redwood_balustrade",
            () -> new Balustrade(BlockBehaviour.Properties.of()));


    public static final RegistryObject<Block> SILVER_SPRUCE_PLANKS = registerBlock("silver_spruce_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> SILVER_SPRUCE_FENCE = registerBlock("silver_spruce_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> SILVER_SPRUCE_FENCE_GATE = registerBlock("silver_spruce_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(SILVER_SPRUCE_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> SILVER_SPRUCE_PLANKS_STAIRS = registerBlock("silver_spruce_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.SILVER_SPRUCE_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> SILVER_SPRUCE_PLANKS_SLAB = registerBlock("silver_spruce_planks_slab",
            () -> new AxialSlabBlock(SILVER_SPRUCE_PLANKS));
    public static final RegistryObject<Block> SILVER_SPRUCE_LOG = registerBlock("silver_spruce_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> SILVER_SPRUCE_WOOD = registerBlock("silver_spruce_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_SILVER_SPRUCE_LOG = registerBlock("stripped_silver_spruce_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_SILVER_SPRUCE_WOOD = registerBlock("stripped_silver_spruce_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> SILVER_SPRUCE_LEAVES = registerBlock("silver_spruce_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SILVER_SPRUCE_SAPLING = registerBlock("silver_spruce_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    public static final RegistryObject<Block> WHITE_ASH_PLANKS = registerBlock("white_ash_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> WHITE_ASH_FENCE = registerBlock("white_ash_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS )
                    .strength(3f)));
    public static final RegistryObject<Block> WHITE_ASH_FENCE_GATE = registerBlock("white_ash_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(WHITE_ASH_PLANKS.get().defaultMapColor()).forceSolidOn()
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), WoodType.ACACIA));
    public static final RegistryObject<Block> WHITE_ASH_PLANKS_STAIRS = registerBlock("white_ash_planks_stairs",
            () -> new StairBlock(() -> BlockLoader.WHITE_ASH_PLANKS.get().defaultBlockState() ,
                    BlockBehaviour.Properties.of().requiresCorrectToolForDrops()
                            .strength(1.5f, 6f)));
    public static final RegistryObject<Block> WHITE_ASH_PLANKS_SLAB = registerBlock("white_ash_planks_slab",
            () -> new AxialSlabBlock(WHITE_ASH_PLANKS));
    public static final RegistryObject<Block> WHITE_ASH_LOG = registerBlock("white_ash_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> WHITE_ASH_WOOD = registerBlock("white_ash_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_WHITE_ASH_LOG = registerBlock("stripped_white_ash_log",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_WHITE_ASH_WOOD = registerBlock("stripped_white_ash_wood",
            () -> new ModFlamableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> WHITE_ASH_LEAVES = registerBlock("white_ash_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT)
                    .strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WHITE_ASH_SAPLING = registerBlock("white_ash_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    //Plants

    public static final RegistryObject<Block> REEDS = registerBlock("reeds", ()-> {
        return new ReedsBlock();
    });

    public static final RegistryObject<Block> PAPYRUS = registerBlock("papyrus", ()-> {
        return new ReedsBlock();
    });

    public static final RegistryObject<Block> DRIED_REEDS = registerBlock("dried_reeds", ()-> {
        return new DriedReedsBlock();
    });

    //grass
    public static final RegistryObject<Block> ARID_GRASS = registerBlock("arid_grass",
            () -> new TallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> BLACK_GRASS = registerBlock("black_grass",
            () -> new TallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FLAX_GRASS = registerBlock("flax_grass",
            () -> new TallGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable()
                    .noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));

    //flowers
    public static final RegistryObject<Block> ASPHODEL = registerBlock("asphodel",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> BLUE_DELPHINIUM = registerBlock("blue_delphinium",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> BLUEBELL = registerBlock("bluebell",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CALLA_LILY = registerBlock("calla_lily",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CELSEMIUM = registerBlock("celsemium",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CHRYS_BLUE = registerBlock("chrys_blue",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CHRYS_ORANGE = registerBlock("chrys_orange",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CHRYS_PINK = registerBlock("chrys_pink",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CHRYS_WHITE = registerBlock("chrys_white",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CHRYS_YELLOW = registerBlock("chrys_yellow",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CROCUS = registerBlock("crocus",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> DAISY = registerBlock("daisy",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> DELPHINIUM = registerBlock("delphinium",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FLAX_FLOWERS = registerBlock("flax_flowers",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FOXGLOVE_ORANGE = registerBlock("foxglove_orange",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FOXGLOVE_PINK = registerBlock("foxglove_pink",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FOXGLOVE_RED = registerBlock("foxglove_red",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FOXGLOVE_WHITE = registerBlock("foxglove_white",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GERBERA_RED = registerBlock("gerbera_red",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GERBERA_YELLOW = registerBlock("gerbera_yellow",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> HEATHER_BUSH = registerBlock("heather_bush",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> LAVENDER = registerBlock("lavender",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> MARIGOLD = registerBlock("marigold",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PINK_ANEMONE = registerBlock("pink_anemone",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SIMBLELMYNE = registerBlock("simbelmyne",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> TUBEROSE = registerBlock("tuberose",
            () -> new FlowerBlock(MobEffects.SATURATION, 7, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));


    /**
     * fruits
     */

    public static final BlockBehaviour.Properties FRUIT_PROPERTIES = BlockBehaviour.Properties.of()
            .strength(1.0F).randomTicks().noCollission().sound(SoundType.CROP);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemLoader.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
