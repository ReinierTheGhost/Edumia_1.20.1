package com.legends.edumia.datagen;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.arches.Arch;
import com.legends.edumia.block.block.Balustrade;
import com.legends.edumia.block.block.VerticalCorner;
import com.legends.edumia.block.plants.ReedsBlock;
import com.legends.edumia.block.properties.ArchShape;
import com.legends.edumia.core.BlockLoader;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.Direction;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.legends.edumia.Edumia.prefix;
import static com.legends.edumia.Edumia.suffix;


public class ModBlockStateProvider extends BlockStateProvider {
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    public ModBlockStateProvider(PackOutput gen, ExistingFileHelper exFileHelper) {
        super(gen, Edumia.MODID, exFileHelper);

    }

    private String name(Block block) {
        return key(block).getPath();
    }


    public void fenceGateBlock(FenceGateBlock block, ModelFile gate, ModelFile gateOpen,
                               ModelFile gateWall, ModelFile gateWallOpen) {
        getVariantBuilder(block).forAllStatesExcept(state -> {
            ModelFile model = gate;
            if (state.getValue(FenceGateBlock.IN_WALL)) {
                model = gateWall;
            }
            if (state.getValue(FenceGateBlock.OPEN)) {
                model = model == gateWall ? gateWallOpen : gateOpen;
            }
            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY((int) state.getValue(FenceGateBlock.FACING).toYRot())
                    .uvLock(true)
                    .build();
        }, FenceGateBlock.POWERED);
    }

    public void wallPaperBlock(IronBarsBlock block, ResourceLocation pane, ResourceLocation edge) {
        wallPaperBlockInternal(block, key(block).toString(), pane, edge);
    }

    public void wallPaperBlock(IronBarsBlock block, String name, ResourceLocation pane,
                               ResourceLocation edge) {
        wallPaperBlockInternal(block, name + "_pane", pane, edge);
    }

    public void wallPaperBlockWithRenderType(IronBarsBlock block, ResourceLocation pane,
                                             ResourceLocation edge, String renderType) {
        wallPaperBlockInternalWithRenderType(block, key(block).toString(), pane, edge,
                ResourceLocation.tryParse(renderType));
    }

    public void wallPaperBlockWithRenderType
            (IronBarsBlock block, String name, ResourceLocation pane, ResourceLocation edge,
             String renderType) {
        wallPaperBlockInternalWithRenderType(block, name + "_pane", pane, edge,
                ResourceLocation.tryParse(renderType));
    }

    public void wallPaperBlockWithRenderType(IronBarsBlock block, ResourceLocation pane,
                                             ResourceLocation edge, ResourceLocation renderType) {
        wallPaperBlockInternalWithRenderType(block, key(block).toString(), pane, edge, renderType);
    }

    public void wallPaperBlockWithRenderType(IronBarsBlock block, String name, ResourceLocation pane,
                                             ResourceLocation edge, ResourceLocation renderType) {
        wallPaperBlockInternalWithRenderType(block, name + "_pane", pane, edge, renderType);
    }

    private void wallPaperBlockInternal(IronBarsBlock block, String baseName,
                                        ResourceLocation pane, ResourceLocation edge) {
        ModelFile post = models().panePost(baseName + "_post", pane, edge);
        ModelFile side = models().paneSide(baseName + "_side", pane, edge);
        ModelFile sideAlt = models().paneSideAlt(baseName + "_side_alt", pane, edge);
        ModelFile noSide = models().paneNoSide(baseName + "_noside", pane);
        ModelFile noSideAlt = models().paneNoSideAlt(baseName + "_noside_alt", pane);
        paneBlock(block, post, side, sideAlt, noSide, noSideAlt);
    }



    private void wallPaperBlockInternalWithRenderType
            (IronBarsBlock block, String baseName, ResourceLocation pane, ResourceLocation edge,
             ResourceLocation renderType) {
        ModelFile post = models().panePost(baseName + "_post", pane, edge).renderType(renderType);
        ModelFile side = models().paneSide(baseName + "_side", pane, edge).renderType(renderType);
        ModelFile sideAlt = models().paneSideAlt(baseName + "_side_alt", pane, edge).renderType
                (renderType);
        ModelFile noSide = models().paneNoSide(baseName + "_noside", pane).renderType(renderType);
        ModelFile noSideAlt = models().paneNoSideAlt(baseName + "_noside_alt", pane).renderType
                (renderType);
        paneBlock(block, post, side, sideAlt, noSide, noSideAlt);
    }

    public void wallPaperBlock(IronBarsBlock block, ModelFile post, ModelFile side, ModelFile sideAlt,
                               ModelFile noSide, ModelFile noSideAlt) {
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block)
                .part().modelFile(post).addModel().end();
        PipeBlock.PROPERTY_BY_DIRECTION.entrySet().forEach(e -> {
            Direction dir = e.getKey();
            if (dir.getAxis().isHorizontal()) {
                boolean alt = dir == Direction.SOUTH;
                builder.part().modelFile(alt || dir == Direction.WEST ? sideAlt : side)
                        .rotationY(dir.getAxis() == Direction.Axis.X ? 90 : 0).addModel()
                        .condition(e.getValue(), true).end()
                        .part().modelFile(alt || dir == Direction.EAST ? noSideAlt : noSide)
                        .rotationY(dir == Direction.WEST ? 270 : dir == Direction.SOUTH ? 90 : 0)
                        .addModel()
                        .condition(e.getValue(), false);
            }
        });
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(),
                        blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(),
                new ModelFile.UncheckedModelFile("edumia:block/" + ForgeRegistries.BLOCKS.getKey
                        (blockRegistryObject.get()).getPath()));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }



    @Override
    protected void registerStatesAndModels() {


        blockWithItem(BlockLoader.WHITE_SAND);

        blockWithItem(BlockLoader.BASALT_BRICKS);
        stairsBlock((StairBlock) BlockLoader.BASALT_BRICKS_STAIRS.get(), blockTexture(BlockLoader.BASALT_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.BASALT_BRICKS_WALL.get(), blockTexture(BlockLoader.BASALT_BRICKS.get()));



        blockWithItem(BlockLoader.GREEN_BASALT_BRICKS);
        stairsBlock((StairBlock) BlockLoader.GREEN_BASALT_BRICKS_STAIRS.get(), blockTexture(BlockLoader.GREEN_BASALT_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.GREEN_BASALT_BRICKS_WALL.get(), blockTexture(BlockLoader.GREEN_BASALT_BRICKS.get()));


        blockWithItem(BlockLoader.GREEN_BASALT_COBBLESTONE);
        stairsBlock((StairBlock) BlockLoader.GREEN_BASALT_COBBLESTONE_STAIRS.get(), blockTexture(BlockLoader.GREEN_BASALT_COBBLESTONE.get()));
        wallBlock((WallBlock) BlockLoader.GREEN_BASALT_COBBLESTONE_WALL.get(), blockTexture(BlockLoader.GREEN_BASALT_COBBLESTONE.get()));

        blockWithItem(BlockLoader.GREEN_BASALT);
        stairsBlock((StairBlock) BlockLoader.GREEN_BASALT_STAIRS.get(), blockTexture(BlockLoader.GREEN_BASALT.get()));
        wallBlock((WallBlock) BlockLoader.GREEN_BASALT_WALL.get(), blockTexture(BlockLoader.GREEN_BASALT.get()));

        blockWithItem(BlockLoader.LIGHT_GRAY_STONE);
        stairsBlock((StairBlock) BlockLoader.LIGHT_GRAY_STONE_STAIRS.get(), blockTexture(BlockLoader.LIGHT_GRAY_STONE.get()));
        wallBlock((WallBlock) BlockLoader.LIGHT_GRAY_STONE_WALL.get(), blockTexture(BlockLoader.LIGHT_GRAY_STONE.get()));

        blockWithItem(BlockLoader.LIGHT_GRAY_STONE_BRICKS);
        stairsBlock((StairBlock) BlockLoader.LIGHT_GRAY_STONE_BRICKS_STAIRS.get(), blockTexture(BlockLoader.LIGHT_GRAY_STONE_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.LIGHT_GRAY_STONE_BRICKS_WALL.get(), blockTexture(BlockLoader.LIGHT_GRAY_STONE_BRICKS.get()));

        blockWithItem(BlockLoader.BROWN_STONE);
        stairsBlock((StairBlock) BlockLoader.BROWN_STONE_STAIRS.get(), blockTexture(BlockLoader.BROWN_STONE.get()));
        wallBlock((WallBlock) BlockLoader.BROWN_STONE_WALL.get(), blockTexture(BlockLoader.BROWN_STONE.get()));

        blockWithItem(BlockLoader.BLUE_STONE);
        stairsBlock((StairBlock) BlockLoader.BLUE_STONE_STAIRS.get(), blockTexture(BlockLoader.BLUE_STONE.get()));
        wallBlock((WallBlock) BlockLoader.BLUE_STONE_WALL.get(), blockTexture(BlockLoader.BLUE_STONE.get()));

        blockWithItem(BlockLoader.YELLOW_STONE);
        stairsBlock((StairBlock) BlockLoader.YELLOW_STONE_STAIRS.get(), blockTexture(BlockLoader.YELLOW_STONE.get()));
        wallBlock((WallBlock) BlockLoader.YELLOW_STONE_WALL.get(), blockTexture(BlockLoader.YELLOW_STONE.get()));

        blockWithItem(BlockLoader.YELLOW_STONE_BRICKS);
        stairsBlock((StairBlock) BlockLoader.YELLOW_STONE_BRICKS_STAIRS.get(), blockTexture(BlockLoader.YELLOW_STONE_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.YELLOW_STONE_BRICKS_WALL.get(), blockTexture(BlockLoader.YELLOW_STONE_BRICKS.get()));

        blockWithItem(BlockLoader.YELLOW_STONE_2);
        stairsBlock((StairBlock) BlockLoader.YELLOW_STONE_2_STAIRS.get(), blockTexture(BlockLoader.YELLOW_STONE_2.get()));
        wallBlock((WallBlock) BlockLoader.YELLOW_STONE_2_WALL.get(), blockTexture(BlockLoader.YELLOW_STONE_2.get()));

        blockWithItem(BlockLoader.YELLOW_STONE_BRICKS_2);
        stairsBlock((StairBlock) BlockLoader.YELLOW_STONE_BRICKS_2_STAIRS.get(), blockTexture(BlockLoader.YELLOW_STONE_BRICKS_2.get()));
        wallBlock((WallBlock) BlockLoader.YELLOW_STONE_BRICKS_2_WALL.get(), blockTexture(BlockLoader.YELLOW_STONE_BRICKS_2.get()));

        blockWithItem(BlockLoader.CRACKED_GREEN_BASALT);
        stairsBlock((StairBlock) BlockLoader.CRACKED_GREEN_BASALT_STAIRS.get(), blockTexture(BlockLoader.CRACKED_GREEN_BASALT.get()));
        wallBlock((WallBlock) BlockLoader.CRACKED_GREEN_BASALT_WALL.get(), blockTexture(BlockLoader.CRACKED_GREEN_BASALT.get()));

        blockWithItem(BlockLoader.CHISELED_BASALT);

        blockWithItem(BlockLoader.LIMESTONE);
        stairsBlock((StairBlock) BlockLoader.LIMESTONE_STAIRS.get(), blockTexture(BlockLoader.LIMESTONE.get()));
        wallBlock((WallBlock) BlockLoader.LIMESTONE_WALL.get(), blockTexture(BlockLoader.LIMESTONE.get()));

        blockWithItem(BlockLoader.GNEISS);
        stairsBlock((StairBlock) BlockLoader.GNEISS_STAIRS.get(), blockTexture(BlockLoader.GNEISS.get()));
        wallBlock((WallBlock) BlockLoader.GNEISS_WALL.get(), blockTexture(BlockLoader.GNEISS.get()));

        blockWithItem(BlockLoader.MOSSY_BASALT_BRICKS);
        stairsBlock((StairBlock) BlockLoader.MOSSY_BASALT_BRICKS_STAIRS.get(), blockTexture(BlockLoader.MOSSY_BASALT_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_BASALT_BRICKS_WALL.get(), blockTexture(BlockLoader.MOSSY_BASALT_BRICKS.get()));

        blockWithItem(BlockLoader.BLUE_BRICK);
        stairsBlock((StairBlock) BlockLoader.BLUE_BRICK_STAIRS.get(), blockTexture(BlockLoader.BLUE_BRICK.get()));
        wallBlock((WallBlock) BlockLoader.BLUE_BRICK_WALL.get(), blockTexture(BlockLoader.BLUE_BRICK.get()));

        blockWithItem(BlockLoader.CYAN_STONE);
        stairsBlock((StairBlock) BlockLoader.CYAN_STONE_STAIRS.get(), blockTexture(BlockLoader.CYAN_STONE.get()));
        wallBlock((WallBlock) BlockLoader.CYAN_STONE_WALL.get(), blockTexture(BlockLoader.CYAN_STONE.get()));

        blockWithItem(BlockLoader.ORANGE_ROCK);
        stairsBlock((StairBlock) BlockLoader.ORANGE_ROCK_STAIRS.get(), blockTexture(BlockLoader.ORANGE_ROCK.get()));
        wallBlock((WallBlock) BlockLoader.ORANGE_ROCK_WALL.get(), blockTexture(BlockLoader.ORANGE_ROCK.get()));

        blockWithItem(BlockLoader.RED_ROCK);
        stairsBlock((StairBlock) BlockLoader.RED_ROCK_STAIRS.get(), blockTexture(BlockLoader.RED_ROCK.get()));
        wallBlock((WallBlock) BlockLoader.RED_ROCK_WALL.get(), blockTexture(BlockLoader.RED_ROCK.get()));

        blockWithItem(BlockLoader.YELLOW_COBBLE);
        stairsBlock((StairBlock) BlockLoader.YELLOW_COBBLE_STAIRS.get(), blockTexture(BlockLoader.YELLOW_COBBLE.get()));
        wallBlock((WallBlock) BlockLoader.YELLOW_COBBLE_WALL.get(), blockTexture(BlockLoader.YELLOW_COBBLE.get()));

        blockWithItem(BlockLoader.HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.SMALL_HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.SMALL_HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.SMALL_HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.SMALL_HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.SMALL_HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.CHISELED_HIGH_ELVEN_BRICKS);

        blockWithItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.CHISELED_LIGHT_HIGH_ELVEN_BRICKS);

        blockWithItem(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.DARK_HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.DARK_HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.DARK_HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.DARK_HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.DARK_HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.CHISELED_DARK_HIGH_ELVEN_BRICKS);

        blockWithItem(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS);
        stairsBlock((StairBlock) BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_STAIRS.get(), blockTexture(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_WALL.get(), blockTexture(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS.get()));

        blockWithItem(BlockLoader.CHALK);
        stairsBlock((StairBlock) BlockLoader.CHALK_STAIRS.get(), blockTexture(BlockLoader.CHALK.get()));
        wallBlock((WallBlock) BlockLoader.CHALK_WALL.get(), blockTexture(BlockLoader.CHALK.get()));

        blockWithItem(BlockLoader.CHALK_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CHALK_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CHALK_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CHALK_BRICKS_WALL.get(), blockTexture(BlockLoader.CHALK_BRICKS.get()));

        blockWithItem(BlockLoader.BROWN_SANDSTONE_BRICKS);
        stairsBlock((StairBlock) BlockLoader.BROWN_SANDSTONE_BRICKS_STAIRS.get(), blockTexture(BlockLoader.BROWN_SANDSTONE_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.BROWN_SANDSTONE_BRICKS_WALL.get(), blockTexture(BlockLoader.BROWN_SANDSTONE_BRICKS.get()));

        blockWithItem(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_WALL.get(), blockTexture(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS.get()));

        blockWithItem(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS);
        stairsBlock((StairBlock) BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_STAIRS.get(), blockTexture(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_WALL.get(), blockTexture(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS.get()));

        blockWithItem(BlockLoader.CARVED_BROWN_SANDSTONE_BRICKS);

        blockWithItem(BlockLoader.CACHOLONG_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CACHOLONG_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CACHOLONG_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CACHOLONG_BRICKS_WALL.get(), blockTexture(BlockLoader.CACHOLONG_BRICKS.get()));

        blockWithItem(BlockLoader.CRACKED_CACHOLONG_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CRACKED_CACHOLONG_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CRACKED_CACHOLONG_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CRACKED_CACHOLONG_BRICKS_WALL.get(), blockTexture(BlockLoader.CRACKED_CACHOLONG_BRICKS.get()));

        blockWithItem(BlockLoader.MOSSY_CACHOLONG_BRICKS);
        stairsBlock((StairBlock) BlockLoader.MOSSY_CACHOLONG_BRICKS_STAIRS.get(), blockTexture(BlockLoader.MOSSY_CACHOLONG_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_CACHOLONG_BRICKS_WALL.get(), blockTexture(BlockLoader.MOSSY_CACHOLONG_BRICKS.get()));

        blockWithItem(BlockLoader.CARVED_CACHOLONG_BRICKS);

        blockWithItem(BlockLoader.BLACK_DEMON_BRICKS);
        stairsBlock((StairBlock) BlockLoader.BLACK_DEMON_BRICKS_STAIRS.get(), blockTexture(BlockLoader.BLACK_DEMON_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.BLACK_DEMON_BRICKS_WALL.get(), blockTexture(BlockLoader.BLACK_DEMON_BRICKS.get()));

        blockWithItem(BlockLoader.CRACKED_BLACK_DEMON_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CRACKED_BLACK_DEMON_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CRACKED_BLACK_DEMON_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CRACKED_BLACK_DEMON_BRICKS_WALL.get(), blockTexture(BlockLoader.CRACKED_BLACK_DEMON_BRICKS.get()));

        blockWithItem(BlockLoader.MOSSY_BLACK_DEMON_BRICKS);
        stairsBlock((StairBlock) BlockLoader.MOSSY_BLACK_DEMON_BRICKS_STAIRS.get(), blockTexture(BlockLoader.MOSSY_BLACK_DEMON_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_BLACK_DEMON_BRICKS_WALL.get(), blockTexture(BlockLoader.MOSSY_BLACK_DEMON_BRICKS.get()));

        blockWithItem(BlockLoader.CARVED_BLACK_DEMON_BRICKS);

        blockWithItem(BlockLoader.BLUE_BRICKS);
        stairsBlock((StairBlock) BlockLoader.BLUE_BRICKS_STAIRS.get(), blockTexture(BlockLoader.BLUE_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.BLUE_BRICKS_WALL.get(), blockTexture(BlockLoader.BLUE_BRICKS.get()));

        blockWithItem(BlockLoader.CRACKED_BLUE_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CRACKED_BLUE_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CRACKED_BLUE_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CRACKED_BLUE_BRICKS_WALL.get(), blockTexture(BlockLoader.CRACKED_BLUE_BRICKS.get()));

        blockWithItem(BlockLoader.MOSSY_BLUE_BRICKS);
        stairsBlock((StairBlock) BlockLoader.MOSSY_BLUE_BRICKS_STAIRS.get(), blockTexture(BlockLoader.MOSSY_BLUE_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_BLUE_BRICKS_WALL.get(), blockTexture(BlockLoader.MOSSY_BLUE_BRICKS.get()));

        blockWithItem(BlockLoader.CARVED_BLUE_BRICKS);

        blockWithItem(BlockLoader.DEMON_BASALT_BRICKS);
        stairsBlock((StairBlock) BlockLoader.DEMON_BASALT_BRICKS_STAIRS.get(), blockTexture(BlockLoader.DEMON_BASALT_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.DEMON_BASALT_BRICKS_WALL.get(), blockTexture(BlockLoader.DEMON_BASALT_BRICKS.get()));

        blockWithItem(BlockLoader.CARVED_DEMON_BASALT_BRICKS);

        blockWithItem(BlockLoader.VULCANIC_DEMON_BRICKS);
        stairsBlock((StairBlock) BlockLoader.VULCANIC_DEMON_BRICKS_STAIRS.get(), blockTexture(BlockLoader.VULCANIC_DEMON_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.VULCANIC_DEMON_BRICKS_WALL.get(), blockTexture(BlockLoader.VULCANIC_DEMON_BRICKS.get()));

        blockWithItem(BlockLoader.VULCANIC_ROCK);
        stairsBlock((StairBlock) BlockLoader.VULCANIC_ROCK_STAIRS.get(), blockTexture(BlockLoader.VULCANIC_ROCK.get()));
        wallBlock((WallBlock) BlockLoader.VULCANIC_ROCK_WALL.get(), blockTexture(BlockLoader.VULCANIC_ROCK.get()));

        blockWithItem(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_WALL.get(), blockTexture(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS.get()));

        blockWithItem(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS);
        stairsBlock((StairBlock) BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_STAIRS.get(), blockTexture(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_WALL.get(), blockTexture(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS.get()));

        blockWithItem(BlockLoader.CARVED_VULCANIC_DEMON_BRICKS);

        blockWithItem(BlockLoader.RED_BRICKS);
        stairsBlock((StairBlock) BlockLoader.RED_BRICKS_STAIRS.get(), blockTexture(BlockLoader.RED_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.RED_BRICKS_WALL.get(), blockTexture(BlockLoader.RED_BRICKS.get()));

        blockWithItem(BlockLoader.CRACKED_RED_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CRACKED_RED_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CRACKED_RED_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CRACKED_RED_BRICKS_WALL.get(), blockTexture(BlockLoader.CRACKED_RED_BRICKS.get()));

        blockWithItem(BlockLoader.MOSSY_RED_BRICKS);
        stairsBlock((StairBlock) BlockLoader.MOSSY_RED_BRICKS_STAIRS.get(), blockTexture(BlockLoader.MOSSY_RED_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_RED_BRICKS_WALL.get(), blockTexture(BlockLoader.MOSSY_RED_BRICKS.get()));

        blockWithItem(BlockLoader.CARVED_RED_BRICKS);

        blockWithItem(BlockLoader.DESERT_MUD_BRICKS);
        stairsBlock((StairBlock) BlockLoader.DESERT_MUD_BRICKS_STAIRS.get(), blockTexture(BlockLoader.DESERT_MUD_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.DESERT_MUD_BRICKS_WALL.get(), blockTexture(BlockLoader.DESERT_MUD_BRICKS.get()));

        blockWithItem(BlockLoader.CRACKED_DESERT_MUD_BRICKS);
        stairsBlock((StairBlock) BlockLoader.CRACKED_DESERT_MUD_BRICKS_STAIRS.get(), blockTexture(BlockLoader.CRACKED_DESERT_MUD_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.CRACKED_DESERT_MUD_BRICKS_WALL.get(), blockTexture(BlockLoader.CRACKED_DESERT_MUD_BRICKS.get()));

        blockWithItem(BlockLoader.MOSSY_DESERT_MUD_BRICKS);
        stairsBlock((StairBlock) BlockLoader.MOSSY_DESERT_MUD_BRICKS_STAIRS.get(), blockTexture(BlockLoader.MOSSY_DESERT_MUD_BRICKS.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_DESERT_MUD_BRICKS_WALL.get(), blockTexture(BlockLoader.MOSSY_DESERT_MUD_BRICKS.get()));

        blockWithItem(BlockLoader.HIGH_ELVEN_ROCK);
        stairsBlock((StairBlock) BlockLoader.HIGH_ELVEN_ROCK_STAIRS.get(), blockTexture(BlockLoader.HIGH_ELVEN_ROCK.get()));
        wallBlock((WallBlock) BlockLoader.HIGH_ELVEN_ROCK_WALL.get(), blockTexture(BlockLoader.HIGH_ELVEN_ROCK.get()));

        blockWithItem(BlockLoader.DARK_HIGH_ELVEN_ROCK);
        stairsBlock((StairBlock) BlockLoader.DARK_HIGH_ELVEN_ROCK_STAIRS.get(), blockTexture(BlockLoader.DARK_HIGH_ELVEN_ROCK.get()));
        wallBlock((WallBlock) BlockLoader.DARK_HIGH_ELVEN_ROCK_WALL.get(), blockTexture(BlockLoader.DARK_HIGH_ELVEN_ROCK.get()));

        blockWithItem(BlockLoader.LIGHT_HIGH_ELVEN_ROCK);
        stairsBlock((StairBlock) BlockLoader.LIGHT_HIGH_ELVEN_ROCK_STAIRS.get(), blockTexture(BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get()));
        wallBlock((WallBlock) BlockLoader.LIGHT_HIGH_ELVEN_ROCK_WALL.get(), blockTexture(BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get()));

        blockWithItem(BlockLoader.HIGH_ELVEN_COBBLESTONE);
        stairsBlock((StairBlock) BlockLoader.HIGH_ELVEN_COBBLESTONE_STAIRS.get(), blockTexture(BlockLoader.HIGH_ELVEN_COBBLESTONE.get()));
        wallBlock((WallBlock) BlockLoader.HIGH_ELVEN_COBBLESTONE_WALL.get(), blockTexture(BlockLoader.HIGH_ELVEN_COBBLESTONE.get()));

        blockWithItem(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE);
        stairsBlock((StairBlock) BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_STAIRS.get(), blockTexture(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_WALL.get(), blockTexture(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get()));

        blockWithItem(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE);
        stairsBlock((StairBlock) BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS.get(), blockTexture(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get()));
        wallBlock((WallBlock) BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_WALL.get(), blockTexture(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get()));

        blockWithItem(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE);
        stairsBlock((StairBlock) BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS.get(), blockTexture(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_WALL.get(), blockTexture(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get()));

        blockWithItem(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE);
        stairsBlock((StairBlock) BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_STAIRS.get(), blockTexture(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get()));
        wallBlock((WallBlock) BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_WALL.get(), blockTexture(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get()));

        blockWithItem(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE);
        stairsBlock((StairBlock) BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_STAIRS.get(), blockTexture(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get()));
        wallBlock((WallBlock) BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_WALL.get(), blockTexture(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get()));






        blockWithItem(BlockLoader.BROWN_SANDSTONE_SLATES);


        blockWithItem(BlockLoader.MARBLE_PINK);

        blockWithItem(BlockLoader.TOPAZ_ORE);

        blockWithItem(BlockLoader.ORE_VEIL);

        blockWithItem(BlockLoader.ALEXANDRITE_BLOCK);
        blockWithItem(BlockLoader.ALEXANDRITE_ORE);
        blockWithItem(BlockLoader.RAW_ALEXANDRITE_BLOCK);

        blockWithItem(BlockLoader.APPLE_PLANKS);
        stairsBlock((StairBlock) BlockLoader.APPLE_PLANKS_STAIRS.get(), blockTexture(BlockLoader.APPLE_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.APPLE_FENCE.get(), blockTexture(BlockLoader.APPLE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.APPLE_FENCE_GATE.get(), blockTexture(BlockLoader.APPLE_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.APPLE_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.APPLE_WOOD.get()), blockTexture(BlockLoader.APPLE_LOG.get()), blockTexture(BlockLoader.APPLE_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_APPLE_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_apple_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_apple_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_APPLE_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_apple_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_apple_log"));

        leavesBlock(BlockLoader.APPLE_LEAVES);
        saplingBlock(BlockLoader.APPLE_SAPLING);

        blockItem(BlockLoader.APPLE_LOG);
        blockItem(BlockLoader.APPLE_WOOD);
        blockItem(BlockLoader.STRIPPED_APPLE_LOG);
        blockItem(BlockLoader.STRIPPED_APPLE_WOOD);


        blockWithItem(BlockLoader.ASPEN_PLANKS);
        stairsBlock((StairBlock) BlockLoader.ASPEN_PLANKS_STAIRS.get(), blockTexture(BlockLoader.ASPEN_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.ASPEN_FENCE.get(), blockTexture(BlockLoader.ASPEN_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.ASPEN_FENCE_GATE.get(), blockTexture(BlockLoader.ASPEN_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.ASPEN_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.ASPEN_WOOD.get()), blockTexture(BlockLoader.ASPEN_LOG.get()), blockTexture(BlockLoader.ASPEN_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_ASPEN_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_aspen_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_aspen_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_ASPEN_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_aspen_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_aspen_log"));

        leavesBlock(BlockLoader.ASPEN_LEAVES);
        saplingBlock(BlockLoader.ASPEN_SAPLING);

        blockItem(BlockLoader.ASPEN_LOG);
        blockItem(BlockLoader.ASPEN_WOOD);
        blockItem(BlockLoader.STRIPPED_ASPEN_LOG);
        blockItem(BlockLoader.STRIPPED_ASPEN_WOOD);


        blockWithItem(BlockLoader.BAOBAB_PLANKS);
        stairsBlock((StairBlock) BlockLoader.BAOBAB_PLANKS_STAIRS.get(), blockTexture(BlockLoader.BAOBAB_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.BAOBAB_FENCE.get(), blockTexture(BlockLoader.BAOBAB_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.BAOBAB_FENCE_GATE.get(), blockTexture(BlockLoader.BAOBAB_PLANKS.get()));


        blockWithItem(BlockLoader.BEECH_PLANKS);
        stairsBlock((StairBlock) BlockLoader.BEECH_PLANKS_STAIRS.get(), blockTexture(BlockLoader.BEECH_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.BEECH_FENCE.get(), blockTexture(BlockLoader.BEECH_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.BEECH_FENCE_GATE.get(), blockTexture(BlockLoader.BEECH_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.BEECH_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.BEECH_WOOD.get()), blockTexture(BlockLoader.BEECH_LOG.get()), blockTexture(BlockLoader.BEECH_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_BEECH_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_beech_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_beech_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_BEECH_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_beech_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_beech_log"));

        leavesBlock(BlockLoader.BEECH_LEAVES);
        saplingBlock(BlockLoader.BEECH_SAPLING);

        blockItem(BlockLoader.BEECH_LOG);
        blockItem(BlockLoader.BEECH_WOOD);
        blockItem(BlockLoader.STRIPPED_BEECH_LOG);
        blockItem(BlockLoader.STRIPPED_BEECH_WOOD);


        blockWithItem(BlockLoader.CEDAR_PLANKS);
        stairsBlock((StairBlock) BlockLoader.CEDAR_PLANKS_STAIRS.get(), blockTexture(BlockLoader.CEDAR_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.CEDAR_FENCE.get(), blockTexture(BlockLoader.CEDAR_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.CEDAR_FENCE_GATE.get(), blockTexture(BlockLoader.CEDAR_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.CEDAR_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.CEDAR_WOOD.get()), blockTexture(BlockLoader.CEDAR_LOG.get()), blockTexture(BlockLoader.CEDAR_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CEDAR_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_cedar_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_cedar_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CEDAR_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_cedar_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_cedar_log"));

        leavesBlock(BlockLoader.CEDAR_LEAVES);
        saplingBlock(BlockLoader.CEDAR_SAPLING);

        blockItem(BlockLoader.CEDAR_LOG);
        blockItem(BlockLoader.CEDAR_WOOD);
        blockItem(BlockLoader.STRIPPED_CEDAR_LOG);
        blockItem(BlockLoader.STRIPPED_CEDAR_WOOD);


        blockWithItem(BlockLoader.CHERRY_PLANKS);
        stairsBlock((StairBlock) BlockLoader.CHERRY_PLANKS_STAIRS.get(), blockTexture(BlockLoader.CHERRY_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.CHERRY_FENCE.get(), blockTexture(BlockLoader.CHERRY_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.CHERRY_FENCE_GATE.get(), blockTexture(BlockLoader.CHERRY_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.CHERRY_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.CHERRY_WOOD.get()), blockTexture(BlockLoader.CHERRY_LOG.get()), blockTexture(BlockLoader.CHERRY_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CHERRY_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_cherry_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_cherry_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CHERRY_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_cherry_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_cherry_log"));

        leavesBlock(BlockLoader.CHERRY_LEAVES);
        saplingBlock(BlockLoader.CHERRY_SAPLING);

        blockItem(BlockLoader.CHERRY_LOG);
        blockItem(BlockLoader.CHERRY_WOOD);
        blockItem(BlockLoader.STRIPPED_CHERRY_LOG);
        blockItem(BlockLoader.STRIPPED_CHERRY_WOOD);


        blockWithItem(BlockLoader.CYPRESS_PLANKS);
        stairsBlock((StairBlock) BlockLoader.CYPRESS_PLANKS_STAIRS.get(), blockTexture(BlockLoader.CYPRESS_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.CYPRESS_FENCE.get(), blockTexture(BlockLoader.CYPRESS_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.CYPRESS_FENCE_GATE.get(), blockTexture(BlockLoader.CYPRESS_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.CYPRESS_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.CYPRESS_WOOD.get()), blockTexture(BlockLoader.CYPRESS_LOG.get()), blockTexture(BlockLoader.CYPRESS_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CYPRESS_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_cypress_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_cypress_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_CYPRESS_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_cypress_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_cypress_log"));

        leavesBlock(BlockLoader.CYPRESS_LEAVES);
        saplingBlock(BlockLoader.CYPRESS_SAPLING);

        blockItem(BlockLoader.CYPRESS_LOG);
        blockItem(BlockLoader.CYPRESS_WOOD);
        blockItem(BlockLoader.STRIPPED_CYPRESS_LOG);
        blockItem(BlockLoader.STRIPPED_CYPRESS_WOOD);

        blockWithItem(BlockLoader.FIR_PLANKS);
        stairsBlock((StairBlock) BlockLoader.FIR_PLANKS_STAIRS.get(), blockTexture(BlockLoader.FIR_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.FIR_FENCE.get(), blockTexture(BlockLoader.FIR_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.FIR_FENCE_GATE.get(), blockTexture(BlockLoader.FIR_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.FIR_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.FIR_WOOD.get()), blockTexture(BlockLoader.FIR_LOG.get()), blockTexture(BlockLoader.FIR_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_FIR_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_fir_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_fir_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_FIR_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_fir_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_fir_log"));

        leavesBlock(BlockLoader.FIR_LEAVES);
        saplingBlock(BlockLoader.FIR_SAPLING);

        blockItem(BlockLoader.FIR_LOG);
        blockItem(BlockLoader.FIR_WOOD);
        blockItem(BlockLoader.STRIPPED_FIR_LOG);
        blockItem(BlockLoader.STRIPPED_FIR_WOOD);


        blockWithItem(BlockLoader.GREEN_OAK_PLANKS);
        stairsBlock((StairBlock) BlockLoader.GREEN_OAK_PLANKS_STAIRS.get(), blockTexture(BlockLoader.GREEN_OAK_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.GREEN_OAK_FENCE.get(), blockTexture(BlockLoader.GREEN_OAK_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.GREEN_OAK_FENCE_GATE.get(), blockTexture(BlockLoader.GREEN_OAK_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.GREEN_OAK_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.GREEN_OAK_WOOD.get()), blockTexture(BlockLoader.GREEN_OAK_LOG.get()), blockTexture(BlockLoader.GREEN_OAK_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_GREEN_OAK_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_green_oak_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_green_oak_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_GREEN_OAK_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_green_oak_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_green_oak_log"));

        leavesBlock(BlockLoader.GREEN_OAK_LEAVES);
        saplingBlock(BlockLoader.GREEN_OAK_SAPLING);

        blockItem(BlockLoader.GREEN_OAK_LOG);
        blockItem(BlockLoader.GREEN_OAK_WOOD);
        blockItem(BlockLoader.STRIPPED_GREEN_OAK_LOG);
        blockItem(BlockLoader.STRIPPED_GREEN_OAK_WOOD);


        blockWithItem(BlockLoader.HOLLY_PLANKS);
        stairsBlock((StairBlock) BlockLoader.HOLLY_PLANKS_STAIRS.get(), blockTexture(BlockLoader.HOLLY_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.HOLLY_FENCE.get(), blockTexture(BlockLoader.HOLLY_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.HOLLY_FENCE_GATE.get(), blockTexture(BlockLoader.HOLLY_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.HOLLY_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.HOLLY_WOOD.get()), blockTexture(BlockLoader.HOLLY_LOG.get()), blockTexture(BlockLoader.HOLLY_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_HOLLY_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_holly_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_holly_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_HOLLY_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_holly_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_holly_log"));

        leavesBlock(BlockLoader.HOLLY_LEAVES);
        saplingBlock(BlockLoader.HOLLY_SAPLING);

        blockItem(BlockLoader.HOLLY_LOG);
        blockItem(BlockLoader.HOLLY_WOOD);
        blockItem(BlockLoader.STRIPPED_HOLLY_LOG);
        blockItem(BlockLoader.STRIPPED_HOLLY_WOOD);


        blockWithItem(BlockLoader.LARCH_PLANKS);
        stairsBlock((StairBlock) BlockLoader.LARCH_PLANKS_STAIRS.get(), blockTexture(BlockLoader.LARCH_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.LARCH_FENCE.get(), blockTexture(BlockLoader.LARCH_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.LARCH_FENCE_GATE.get(), blockTexture(BlockLoader.LARCH_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.LARCH_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.LARCH_WOOD.get()), blockTexture(BlockLoader.LARCH_LOG.get()), blockTexture(BlockLoader.LARCH_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_LARCH_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_larch_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_larch_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_LARCH_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_larch_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_larch_log"));

        leavesBlock(BlockLoader.LARCH_LEAVES);
        saplingBlock(BlockLoader.LARCH_SAPLING);

        blockItem(BlockLoader.LARCH_LOG);
        blockItem(BlockLoader.LARCH_WOOD);
        blockItem(BlockLoader.STRIPPED_LARCH_LOG);
        blockItem(BlockLoader.STRIPPED_LARCH_WOOD);


        blockWithItem(BlockLoader.MAPLE_PLANKS);
        stairsBlock((StairBlock) BlockLoader.MAPLE_PLANKS_STAIRS.get(), blockTexture(BlockLoader.MAPLE_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.MAPLE_FENCE.get(), blockTexture(BlockLoader.MAPLE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.MAPLE_FENCE_GATE.get(), blockTexture(BlockLoader.MAPLE_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.MAPLE_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.MAPLE_WOOD.get()), blockTexture(BlockLoader.MAPLE_LOG.get()), blockTexture(BlockLoader.MAPLE_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_MAPLE_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_maple_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_maple_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_MAPLE_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_maple_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_maple_log"));

        leavesBlock(BlockLoader.MAPLE_LEAVES);
        saplingBlock(BlockLoader.MAPLE_SAPLING);

        blockItem(BlockLoader.MAPLE_LOG);
        blockItem(BlockLoader.MAPLE_WOOD);
        blockItem(BlockLoader.STRIPPED_MAPLE_LOG);
        blockItem(BlockLoader.STRIPPED_MAPLE_WOOD);

        blockWithItem(BlockLoader.BLACKTHORN_PLANKS);
        stairsBlock((StairBlock) BlockLoader.BLACKTHORN_PLANKS_STAIRS.get(), blockTexture(BlockLoader.BLACKTHORN_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.BLACKTHORN_FENCE.get(), blockTexture(BlockLoader.BLACKTHORN_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.BLACKTHORN_FENCE_GATE.get(), blockTexture(BlockLoader.BLACKTHORN_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.BLACKTHORN_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.BLACKTHORN_WOOD.get()), blockTexture(BlockLoader.BLACKTHORN_LOG.get()), blockTexture(BlockLoader.BLACKTHORN_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_BLACKTHORN_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_blackthorn_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_blackthorn_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_BLACKTHORN_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_blackthorn_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_blackthorn_log"));

        leavesBlock(BlockLoader.BLACKTHORN_LEAVES);
        saplingBlock(BlockLoader.BLACKTHORN_SAPLING);

        blockItem(BlockLoader.BLACKTHORN_LOG);
        blockItem(BlockLoader.BLACKTHORN_WOOD);
        blockItem(BlockLoader.STRIPPED_BLACKTHORN_LOG);
        blockItem(BlockLoader.STRIPPED_BLACKTHORN_WOOD);

        blockWithItem(BlockLoader.GHOST_GUM_PLANKS);
        stairsBlock((StairBlock) BlockLoader.GHOST_GUM_PLANKS_STAIRS.get(), blockTexture(BlockLoader.GHOST_GUM_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.GHOST_GUM_FENCE.get(), blockTexture(BlockLoader.GHOST_GUM_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.GHOST_GUM_FENCE_GATE.get(), blockTexture(BlockLoader.GHOST_GUM_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.GHOST_GUM_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.GHOST_GUM_WOOD.get()), blockTexture(BlockLoader.GHOST_GUM_LOG.get()), blockTexture(BlockLoader.GHOST_GUM_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_GHOST_GUM_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_ghost_gum_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_ghost_gum_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_GHOST_GUM_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_ghost_gum_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_ghost_gum_log"));

        leavesBlock(BlockLoader.GHOST_GUM_LEAVES);
        saplingBlock(BlockLoader.GHOST_GUM_SAPLING);

        blockItem(BlockLoader.GHOST_GUM_LOG);
        blockItem(BlockLoader.GHOST_GUM_WOOD);
        blockItem(BlockLoader.STRIPPED_GHOST_GUM_LOG);
        blockItem(BlockLoader.STRIPPED_GHOST_GUM_WOOD);

        blockWithItem(BlockLoader.WHITE_ASH_PLANKS);
        stairsBlock((StairBlock) BlockLoader.WHITE_ASH_PLANKS_STAIRS.get(), blockTexture(BlockLoader.WHITE_ASH_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.WHITE_ASH_FENCE.get(), blockTexture(BlockLoader.WHITE_ASH_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.WHITE_ASH_FENCE_GATE.get(), blockTexture(BlockLoader.WHITE_ASH_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.WHITE_ASH_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.WHITE_ASH_WOOD.get()), blockTexture(BlockLoader.WHITE_ASH_LOG.get()), blockTexture(BlockLoader.WHITE_ASH_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_WHITE_ASH_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_white_ash_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_white_ash_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_WHITE_ASH_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_white_ash_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_white_ash_log"));

        leavesBlock(BlockLoader.WHITE_ASH_LEAVES);
        saplingBlock(BlockLoader.WHITE_ASH_SAPLING);

        blockItem(BlockLoader.WHITE_ASH_LOG);
        blockItem(BlockLoader.WHITE_ASH_WOOD);
        blockItem(BlockLoader.STRIPPED_WHITE_ASH_LOG);
        blockItem(BlockLoader.STRIPPED_WHITE_ASH_WOOD);


        blockWithItem(BlockLoader.OKOME_PLANKS);
        stairsBlock((StairBlock) BlockLoader.OKOME_PLANKS_STAIRS.get(), blockTexture(BlockLoader.OKOME_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.OKOME_FENCE.get(), blockTexture(BlockLoader.OKOME_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.OKOME_FENCE_GATE.get(), blockTexture(BlockLoader.OKOME_PLANKS.get()));


        blockWithItem(BlockLoader.PEAR_PLANKS);
        stairsBlock((StairBlock) BlockLoader.PEAR_PLANKS_STAIRS.get(), blockTexture(BlockLoader.PEAR_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.PEAR_FENCE.get(), blockTexture(BlockLoader.PEAR_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.PEAR_FENCE_GATE.get(), blockTexture(BlockLoader.PEAR_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.PEAR_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.PEAR_WOOD.get()), blockTexture(BlockLoader.PEAR_LOG.get()), blockTexture(BlockLoader.PEAR_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_PEAR_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_pear_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_pear_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_PEAR_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_pear_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_pear_log"));

        leavesBlock(BlockLoader.PEAR_LEAVES);
        saplingBlock(BlockLoader.PEAR_SAPLING);

        blockItem(BlockLoader.PEAR_LOG);
        blockItem(BlockLoader.PEAR_WOOD);
        blockItem(BlockLoader.STRIPPED_PEAR_LOG);
        blockItem(BlockLoader.STRIPPED_PEAR_WOOD);


        blockWithItem(BlockLoader.PINE_PLANKS);
        stairsBlock((StairBlock) BlockLoader.PINE_PLANKS_STAIRS.get(), blockTexture(BlockLoader.PINE_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.PINE_FENCE.get(), blockTexture(BlockLoader.PINE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.PINE_FENCE_GATE.get(), blockTexture(BlockLoader.PINE_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.PINE_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.PINE_WOOD.get()), blockTexture(BlockLoader.PINE_LOG.get()), blockTexture(BlockLoader.PINE_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_PINE_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_pine_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_pine_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_PINE_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_pine_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_pine_log"));

        leavesBlock(BlockLoader.PINE_LEAVES);
        saplingBlock(BlockLoader.PINE_SAPLING);

        blockItem(BlockLoader.PINE_LOG);
        blockItem(BlockLoader.PINE_WOOD);
        blockItem(BlockLoader.STRIPPED_PINE_LOG);
        blockItem(BlockLoader.STRIPPED_PINE_WOOD);


        blockWithItem(BlockLoader.PLUM_PLANKS);
        stairsBlock((StairBlock) BlockLoader.PLUM_PLANKS_STAIRS.get(), blockTexture(BlockLoader.PLUM_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.PLUM_FENCE.get(), blockTexture(BlockLoader.PLUM_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.PLUM_FENCE_GATE.get(), blockTexture(BlockLoader.PLUM_PLANKS.get()));


        blockWithItem(BlockLoader.RED_OAK_PLANKS);
        stairsBlock((StairBlock) BlockLoader.RED_OAK_PLANKS_STAIRS.get(), blockTexture(BlockLoader.RED_OAK_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.RED_OAK_FENCE.get(), blockTexture(BlockLoader.RED_OAK_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.RED_OAK_FENCE_GATE.get(), blockTexture(BlockLoader.RED_OAK_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.RED_OAK_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.RED_OAK_WOOD.get()), blockTexture(BlockLoader.RED_OAK_LOG.get()), blockTexture(BlockLoader.RED_OAK_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_RED_OAK_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_red_oak_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_red_oak_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_RED_OAK_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_red_oak_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_red_oak_log"));

        leavesBlock(BlockLoader.RED_OAK_LEAVES);
        saplingBlock(BlockLoader.RED_OAK_SAPLING);

        blockItem(BlockLoader.RED_OAK_LOG);
        blockItem(BlockLoader.RED_OAK_WOOD);
        blockItem(BlockLoader.STRIPPED_RED_OAK_LOG);
        blockItem(BlockLoader.STRIPPED_RED_OAK_WOOD);

        simpleBlockWithItem(BlockLoader.ARID_GRASS.get(),
                models().cross(blockTexture(BlockLoader.ARID_GRASS.get()).getPath(),
                        blockTexture(BlockLoader.ARID_GRASS.get())).renderType("cutout"));


        simpleBlockWithItem(BlockLoader.BLACK_GRASS.get(),
                models().cross(blockTexture(BlockLoader.BLACK_GRASS.get()).getPath(),
                        blockTexture(BlockLoader.BLACK_GRASS.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.FLAX_GRASS.get(),
                models().cross(blockTexture(BlockLoader.FLAX_GRASS.get()).getPath(),
                        blockTexture(BlockLoader.FLAX_GRASS.get())).renderType("cutout"));


        //flowers
        simpleBlockWithItem(BlockLoader.ASPHODEL.get(),
                models().cross(blockTexture(BlockLoader.ASPHODEL.get()).getPath(),
                        blockTexture(BlockLoader.ASPHODEL.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.BLUE_DELPHINIUM.get(),
                models().cross(blockTexture(BlockLoader.BLUE_DELPHINIUM.get()).getPath(),
                        blockTexture(BlockLoader.BLUE_DELPHINIUM.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.BLUEBELL.get(),
                models().cross(blockTexture(BlockLoader.BLUEBELL.get()).getPath(),
                        blockTexture(BlockLoader.BLUEBELL.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.CALLA_LILY.get(),
                models().cross(blockTexture(BlockLoader.CALLA_LILY.get()).getPath(),
                        blockTexture(BlockLoader.CALLA_LILY.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.CELSEMIUM.get(),
                models().cross(blockTexture(BlockLoader.CELSEMIUM.get()).getPath(),
                        blockTexture(BlockLoader.CELSEMIUM.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.CHRYS_BLUE.get(),
                models().cross(blockTexture(BlockLoader.CHRYS_BLUE.get()).getPath(),
                        blockTexture(BlockLoader.CHRYS_BLUE.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.CHRYS_ORANGE.get(),
                models().cross(blockTexture(BlockLoader.CHRYS_ORANGE.get()).getPath(),
                        blockTexture(BlockLoader.CHRYS_ORANGE.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.CHRYS_PINK.get(),
                models().cross(blockTexture(BlockLoader.CHRYS_PINK.get()).getPath(),
                        blockTexture(BlockLoader.CHRYS_PINK.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.CHRYS_WHITE.get(),
                models().cross(blockTexture(BlockLoader.CHRYS_WHITE.get()).getPath(),
                        blockTexture(BlockLoader.CHRYS_WHITE.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.CHRYS_YELLOW.get(),
                models().cross(blockTexture(BlockLoader.CHRYS_YELLOW.get()).getPath(),
                        blockTexture(BlockLoader.CHRYS_YELLOW.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.CROCUS.get(),
                models().cross(blockTexture(BlockLoader.CROCUS.get()).getPath(),
                        blockTexture(BlockLoader.CROCUS.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.DAISY.get(),
                models().cross(blockTexture(BlockLoader.DAISY.get()).getPath(),
                        blockTexture(BlockLoader.DAISY.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.DELPHINIUM.get(),
                models().cross(blockTexture(BlockLoader.DELPHINIUM.get()).getPath(),
                        blockTexture(BlockLoader.DELPHINIUM.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.FLAX_FLOWERS.get(),
                models().cross(blockTexture(BlockLoader.FLAX_FLOWERS.get()).getPath(),
                        blockTexture(BlockLoader.FLAX_FLOWERS.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.FOXGLOVE_ORANGE.get(),
                models().cross(blockTexture(BlockLoader.FOXGLOVE_ORANGE.get()).getPath(),
                        blockTexture(BlockLoader.FOXGLOVE_ORANGE.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.FOXGLOVE_PINK.get(),
                models().cross(blockTexture(BlockLoader.FOXGLOVE_PINK.get()).getPath(),
                        blockTexture(BlockLoader.FOXGLOVE_PINK.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.FOXGLOVE_RED.get(),
                models().cross(blockTexture(BlockLoader.FOXGLOVE_RED.get()).getPath(),
                        blockTexture(BlockLoader.FOXGLOVE_RED.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.FOXGLOVE_WHITE.get(),
                models().cross(blockTexture(BlockLoader.FOXGLOVE_WHITE.get()).getPath(),
                        blockTexture(BlockLoader.FOXGLOVE_WHITE.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.GERBERA_RED.get(),
                models().cross(blockTexture(BlockLoader.GERBERA_RED.get()).getPath(),
                        blockTexture(BlockLoader.GERBERA_RED.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.GERBERA_YELLOW.get(),
                models().cross(blockTexture(BlockLoader.GERBERA_YELLOW.get()).getPath(),
                        blockTexture(BlockLoader.GERBERA_YELLOW.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.HEATHER_BUSH.get(),
                models().cross(blockTexture(BlockLoader.HEATHER_BUSH.get()).getPath(),
                        blockTexture(BlockLoader.HEATHER_BUSH.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.LAVENDER.get(),
                models().cross(blockTexture(BlockLoader.LAVENDER.get()).getPath(),
                        blockTexture(BlockLoader.LAVENDER.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.MARIGOLD.get(),
                models().cross(blockTexture(BlockLoader.MARIGOLD.get()).getPath(),
                        blockTexture(BlockLoader.MARIGOLD.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.PINK_ANEMONE.get(),
                models().cross(blockTexture(BlockLoader.PINK_ANEMONE.get()).getPath(),
                        blockTexture(BlockLoader.PINK_ANEMONE.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.SIMBLELMYNE.get(),
                models().cross(blockTexture(BlockLoader.SIMBLELMYNE.get()).getPath(),
                        blockTexture(BlockLoader.SIMBLELMYNE.get())).renderType("cutout"));

        simpleBlockWithItem(BlockLoader.TUBEROSE.get(),
                models().cross(blockTexture(BlockLoader.TUBEROSE.get()).getPath(),
                        blockTexture(BlockLoader.TUBEROSE.get())).renderType("cutout"));

        blockWithItem(BlockLoader.SILVER_SPRUCE_PLANKS);
        stairsBlock((StairBlock) BlockLoader.SILVER_SPRUCE_PLANKS_STAIRS.get(), blockTexture(BlockLoader.SILVER_SPRUCE_PLANKS.get()));
        fenceBlock((FenceBlock) BlockLoader.SILVER_SPRUCE_FENCE.get(), blockTexture(BlockLoader.SILVER_SPRUCE_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) BlockLoader.SILVER_SPRUCE_FENCE_GATE.get(), blockTexture(BlockLoader.SILVER_SPRUCE_PLANKS.get()));

        logBlock(((RotatedPillarBlock) BlockLoader.SILVER_SPRUCE_LOG.get()));
        axisBlock(((RotatedPillarBlock) BlockLoader.SILVER_SPRUCE_WOOD.get()), blockTexture(BlockLoader.SILVER_SPRUCE_LOG.get()), blockTexture(BlockLoader.SILVER_SPRUCE_LOG.get()));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_SILVER_SPRUCE_LOG.get(), new ResourceLocation(Edumia.MODID, "block/stripped_silver_spruce_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_silver_spruce_log_top"));
        axisBlock((RotatedPillarBlock) BlockLoader.STRIPPED_SILVER_SPRUCE_WOOD.get(), new ResourceLocation(Edumia.MODID, "block/stripped_silver_spruce_log"),
                new ResourceLocation(Edumia.MODID, "block/stripped_silver_spruce_log"));

        leavesBlock(BlockLoader.SILVER_SPRUCE_LEAVES);
        saplingBlock(BlockLoader.SILVER_SPRUCE_SAPLING);

        blockItem(BlockLoader.SILVER_SPRUCE_LOG);
        blockItem(BlockLoader.SILVER_SPRUCE_WOOD);
        blockItem(BlockLoader.STRIPPED_SILVER_SPRUCE_LOG);
        blockItem(BlockLoader.STRIPPED_SILVER_SPRUCE_WOOD);

        blockWithItem(BlockLoader.HIGH_ELVEN_BRICK_TILING);
        slabBlock((SlabBlock) BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB.get(), blockTexture(BlockLoader.HIGH_ELVEN_BRICK_TILING.get()),
                blockTexture(BlockLoader.HIGH_ELVEN_BRICK_TILING.get()));
        stairsBlock((StairBlock) BlockLoader.HIGH_ELVEN_BRICK_TILING_STAIRS.get(), blockTexture(BlockLoader.HIGH_ELVEN_BRICK_TILING.get()));
        // wallBlock((WallBlock) BlockLoader.HIGH_ELVEN_BRICK_TILING_WALL.get(), blockTexture(BlockLoader.HIGH_ELVEN_BRICK_TILING.get()));

        blockWithItem(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING);
        slabBlock((SlabBlock) BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB.get(), blockTexture(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING.get()),
                blockTexture(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING.get()));
        stairsBlock((StairBlock) BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_STAIRS.get(), blockTexture(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING.get()));
        //wallBlock((WallBlock) BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_WALL.get(), blockTexture(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING.get()));

        blockWithItem(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING);
        slabBlock((SlabBlock) BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB.get(), blockTexture(BlockLoader.HIGH_ELVEN_BRICK_TILING.get()),
                blockTexture(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING.get()));
        stairsBlock((StairBlock) BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS.get(), blockTexture(BlockLoader.HIGH_ELVEN_BRICK_TILING.get()));
        //wallBlock((WallBlock) BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_WALL.get(), blockTexture(BlockLoader.HIGH_ELVEN_BRICK_TILING.get()));

        blockWithItem(BlockLoader.CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.CLAY_TILING.get()));

        blockWithItem(BlockLoader.BLACK_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.BLACK_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.BLACK_CLAY_TILING.get()));

        blockWithItem(BlockLoader.BLUE_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.BLUE_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.BLUE_CLAY_TILING.get()));

        blockWithItem(BlockLoader.BROWN_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.BROWN_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.BROWN_CLAY_TILING.get()));

        blockWithItem(BlockLoader.CYAN_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.CYAN_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.CYAN_CLAY_TILING.get()));

        blockWithItem(BlockLoader.GRAY_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.GRAY_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.GRAY_CLAY_TILING.get()));

        blockWithItem(BlockLoader.GREEN_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.GREEN_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.GREEN_CLAY_TILING.get()));

        blockWithItem(BlockLoader.LIGHT_BLUE_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.LIGHT_BLUE_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.LIGHT_BLUE_CLAY_TILING.get()));

        blockWithItem(BlockLoader.LIGHT_GRAY_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.LIGHT_GRAY_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.LIGHT_GRAY_CLAY_TILING.get()));

        blockWithItem(BlockLoader.LIME_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.LIME_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.LIME_CLAY_TILING.get()));

        blockWithItem(BlockLoader.MAGENTA_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.MAGENTA_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.MAGENTA_CLAY_TILING.get()));

        blockWithItem(BlockLoader.ORANGE_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.ORANGE_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.ORANGE_CLAY_TILING.get()));

        blockWithItem(BlockLoader.PINK_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.PINK_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.PINK_CLAY_TILING.get()));

        blockWithItem(BlockLoader.PURPLE_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.PURPLE_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.PURPLE_CLAY_TILING.get()));

        blockWithItem(BlockLoader.RED_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.RED_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.RED_CLAY_TILING.get()));

        blockWithItem(BlockLoader.WHITE_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.WHITE_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.WHITE_CLAY_TILING.get()));

        blockWithItem(BlockLoader.YELLOW_CLAY_TILING);
        stairsBlock((StairBlock) BlockLoader.YELLOW_CLAY_TILING_STAIRS.get(), blockTexture(BlockLoader.YELLOW_CLAY_TILING.get()));


    }
}
