package com.legends.edumia.datagen.custom;

import com.legends.edumia.block.EdumiaPillarBlock;
import com.legends.edumia.block.Layer;
import com.legends.edumia.block.arches.Arch;
import com.legends.edumia.block.properties.ArchShape;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.core.block.base.WaterloggedHorizontalDirectionalShape;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

import static com.legends.edumia.Edumia.prefix;
import static com.legends.edumia.Edumia.suffix;

//TODO clean this class up for god's sake
//make better helper methods and move them to BlockModelBuilders
//finish datagenning blocks that arent done yet
public class BlockStateGenerator extends BlockModelBuilders {
    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        registerWoodBlocks();
        registerStoneBlocks();
        registerLayerBlocks();
        registerArchBlocks();
        registerPlantBlocks();
    }

    private void registerPlantBlocks(){
        reeds(BlockLoader.REEDS.get());
        reeds(BlockLoader.DRIED_REEDS.get());
        reeds(BlockLoader.PAPYRUS.get());
    }

    private void registerArchBlocks(){
        roundArch(BlockLoader.GREEN_BASALT_ROUND_ARCH.get(), "green_basalt");
        roundArch(BlockLoader.GREEN_BASALT_SEGMENTAL_ARCH.get(), "green_basalt");

        gothicArch(BlockLoader.GREEN_BASALT_GOTHIC_ARCH.get(), "green_basalt");
        archBlocks("high_elven_bricks", BlockLoader.HIGH_ELVEN_BRICKS_ROUND_ARCH.get(), BlockLoader.HIGH_ELVEN_BRICKS_SEGMENTAL_ARCH.get(),
                BlockLoader.HIGH_ELVEN_BRICKS_GOTHIC_ARCH.get(), BlockLoader.HIGH_ELVEN_BRICKS_SMALL_ARCH.get(),
                BlockLoader.HIGH_ELVEN_BRICKS_TWO_METER_ARCH.get());
    }

    private void registerLayerBlocks(){
        layerBlock(BlockLoader.SAND_LAYER.get(), "sand");
        layerBlock(BlockLoader.RED_SAND_LAYER.get(), "red_sand");
        layerBlock(BlockLoader.WHITE_SAND_LAYER.get(), "white_sand");
    }

    private void registerWoodBlocks() {
        logWoodSapling(BlockLoader.REDWOOD_LOG.get(), BlockLoader.STRIPPED_REDWOOD_LOG.get(), BlockLoader.REDWOOD_WOOD.get(),
                BlockLoader.STRIPPED_REDWOOD_WOOD.get(), BlockLoader.REDWOOD_SAPLING.get());
        plankBlocks("redwood", BlockLoader.REDWOOD_PLANKS.get(), BlockLoader.REDWOOD_PLANKS_SLAB.get(),
                BlockLoader.REDWOOD_PLANKS_STAIRS.get(), BlockLoader.REDWOOD_BUTTON.get(), BlockLoader.REDWOOD_FENCE.get(),
                BlockLoader.REDWOOD_FENCE_GATE.get(), BlockLoader.REDWOOD_PRESSURE_PLATE.get(), BlockLoader.REDWOOD_DOOR.get(),
                BlockLoader.REDWOOD_TRAPDOOR.get(), BlockLoader.REDWOOD_BANISTER.get());
        balustradeBlock(BlockLoader.REDWOOD_BALUSTRADE.get(), "redwood_planks");

    }

    private void registerStoneBlocks(){
        verticalCorner(BlockLoader.BLACK_CLAY_TILING_VERTICAL_CORNER.get(), "black_clay_tiling");
        verticalCorner(BlockLoader.CLAY_TILING_VERTICAL_CORNER.get(), "clay_tiling");
        verticalCorner(BlockLoader.BLUE_CLAY_TILING_VERTICAL_CORNER.get(), "blue_clay_tiling");
        verticalCorner(BlockLoader.BROWN_CLAY_TILING_VERTICAL_CORNER.get(), "brown_clay_tiling");
        verticalCorner(BlockLoader.CYAN_CLAY_TILING_VERTICAL_CORNER.get(), "cyan_clay_tiling");
        verticalCorner(BlockLoader.GRAY_CLAY_TILING_VERTICAL_CORNER.get(), "gray_clay_tiling");
        verticalCorner(BlockLoader.GREEN_CLAY_TILING_VERTICAL_CORNER.get(), "green_clay_tiling");
        verticalCorner(BlockLoader.LIGHT_BLUE_CLAY_TILING_VERTICAL_CORNER.get(), "light_blue_clay_tiling");
        verticalCorner(BlockLoader.LIGHT_GRAY_CLAY_TILING_VERTICAL_CORNER.get(), "light_gray_clay_tiling");
        verticalCorner(BlockLoader.LIME_CLAY_TILING_VERTICAL_CORNER.get(), "lime_clay_tiling");
        verticalCorner(BlockLoader.MAGENTA_CLAY_TILING_VERTICAL_CORNER.get(), "magenta_clay_tiling");
        verticalCorner(BlockLoader.ORANGE_CLAY_TILING_VERTICAL_CORNER.get(), "orange_clay_tiling");
        verticalCorner(BlockLoader.PINK_CLAY_TILING_VERTICAL_CORNER.get(), "pink_clay_tiling");
        verticalCorner(BlockLoader.PURPLE_CLAY_TILING_VERTICAL_CORNER.get(), "purple_clay_tiling");
        verticalCorner(BlockLoader.RED_CLAY_TILING_VERTICAL_CORNER.get(), "red_clay_tiling");
        verticalCorner(BlockLoader.WHITE_CLAY_TILING_VERTICAL_CORNER.get(), "white_clay_tiling");
        verticalCorner(BlockLoader.YELLOW_CLAY_TILING_VERTICAL_CORNER.get(), "yellow_clay_tiling");

        balustradeBlock(BlockLoader.HIGH_ELVEN_BALUSTRADE.get(), "high_elven_bricks");
        balustradeBlock(BlockLoader.LIGHT_HIGH_ELVEN_BALUSTRADE.get(), "light_high_elven_bricks");
        balustradeBlock(BlockLoader.DARK_HIGH_ELVEN_BALUSTRADE.get(), "dark_high_elven_bricks");
        stonePillar(BlockLoader.BRICK_PILLAR.get());
        stonePillar(BlockLoader.STONE_PILLAR.get());
        stonePillar(BlockLoader.CHALK_PILLAR.get());
        stonePillar(BlockLoader.RED_PILLAR.get());
        stonePillar(BlockLoader.CACHOLONG_PILLAR.get());
        stonePillar(BlockLoader.HIGH_ELVEN_PILLAR.get());
        stonePillar(BlockLoader.LIGHT_HIGH_ELVEN_PILLAR.get());
        stonePillar(BlockLoader.DARK_HIGH_ELVEN_PILLAR.get());
        arrowSlit(BlockLoader.HIGH_ELVEN_BRICK_ARROWSLIT.get(), "high_elven_bricks");

        axialSlabBlock(BlockLoader.CLAY_TILING_SLAB.get(), "clay_tiling");
        axialSlabBlock(BlockLoader.BLACK_CLAY_TILING_SLAB.get(), "black_clay_tiling");
        axialSlabBlock(BlockLoader.BLUE_CLAY_TILING_SLAB.get(), "blue_clay_tiling");
        axialSlabBlock(BlockLoader.BROWN_CLAY_TILING_SLAB.get(), "brown_clay_tiling");
        axialSlabBlock(BlockLoader.CYAN_CLAY_TILING_SLAB.get(), "cyan_clay_tiling");
        axialSlabBlock(BlockLoader.GRAY_CLAY_TILING_SLAB.get(), "gray_clay_tiling");
        axialSlabBlock(BlockLoader.GREEN_CLAY_TILING_SLAB.get(), "green_clay_tiling");
        axialSlabBlock(BlockLoader.LIGHT_BLUE_CLAY_TILING_SLAB.get(), "light_blue_clay_tiling");
        axialSlabBlock(BlockLoader.LIGHT_GRAY_CLAY_TILING_SLAB.get(), "light_gray_clay_tiling");
        axialSlabBlock(BlockLoader.LIME_CLAY_TILING_SLAB.get(), "lime_clay_tiling");
        axialSlabBlock(BlockLoader.MAGENTA_CLAY_TILING_SLAB.get(), "magenta_clay_tiling");
        axialSlabBlock(BlockLoader.ORANGE_CLAY_TILING_SLAB.get(), "orange_clay_tiling");
        axialSlabBlock(BlockLoader.PINK_CLAY_TILING_SLAB.get(), "pink_clay_tiling");
        axialSlabBlock(BlockLoader.PURPLE_CLAY_TILING_SLAB.get(), "purple_clay_tiling");
        axialSlabBlock(BlockLoader.RED_CLAY_TILING_SLAB.get(), "red_clay_tiling");
        axialSlabBlock(BlockLoader.WHITE_CLAY_TILING_SLAB.get(), "white_clay_tiling");
        axialSlabBlock(BlockLoader.YELLOW_CLAY_TILING_SLAB.get(), "yellow_clay_tiling");

        axialSlabBlock(BlockLoader.BROWN_STONE_SLAB.get(), "brown_stone");
        axialSlabBlock(BlockLoader.LIGHT_GRAY_STONE_SLAB.get(), "light_gray_stone");
        axialSlabBlock(BlockLoader.LIGHT_GRAY_STONE_BRICKS_SLAB.get(), "light_gray_stone_bricks");
        axialSlabBlock(BlockLoader.BLUE_STONE_SLAB.get(), "blue_stone");
        axialSlabBlock(BlockLoader.BLUE_BRICK_SLAB.get(), "blue_brick");
        axialSlabBlock(BlockLoader.YELLOW_STONE_SLAB.get(), "yellow_stone");
        axialSlabBlock(BlockLoader.YELLOW_STONE_2_SLAB.get(), "yellow_stone_2");
        axialSlabBlock(BlockLoader.YELLOW_STONE_BRICKS_SLAB.get(), "yellow_stone_bricks");
        axialSlabBlock(BlockLoader.YELLOW_STONE_BRICKS_2_SLAB.get(), "yellow_stone_bricks_2");
        axialSlabBlock(BlockLoader.BASALT_BRICKS_SLAB.get(), "basalt_bricks");
        axialSlabBlock(BlockLoader.GREEN_BASALT_SLAB.get(), "green_basalt");
        axialSlabBlock(BlockLoader.GREEN_BASALT_BRICKS_SLAB.get(), "green_basalt_bricks");
        axialSlabBlock(BlockLoader.MOSSY_BASALT_BRICKS_SLAB.get(), "mossy_basalt_bricks");
        axialSlabBlock(BlockLoader.CRACKED_GREEN_BASALT_SLAB.get(), "cracked_green_basalt");
        axialSlabBlock(BlockLoader.GREEN_BASALT_COBBLESTONE_SLAB.get(), "green_basalt_cobblestone");
        axialSlabBlock(BlockLoader.GNEISS_SLAB.get(), "gneiss");
        axialSlabBlock(BlockLoader.LIMESTONE_SLAB.get(), "limestone");
        axialSlabBlock(BlockLoader.CYAN_STONE_SLAB.get(), "cyan_stone");
        axialSlabBlock(BlockLoader.ORANGE_ROCK_SLAB.get(), "orange_rock");
        axialSlabBlock(BlockLoader.RED_ROCK_SLAB.get(), "red_rock");
        axialSlabBlock(BlockLoader.YELLOW_COBBLE_SLAB.get(), "yellow_cobble");
        axialSlabBlock(BlockLoader.CHALK_SLAB.get(), "chalk");
        axialSlabBlock(BlockLoader.CHALK_BRICKS_SLAB.get(), "chalk_bricks");
        axialSlabBlock(BlockLoader.HIGH_ELVEN_ROCK_SLAB.get(), "high_elven_rock");
        axialSlabBlock(BlockLoader.DARK_HIGH_ELVEN_ROCK_SLAB.get(), "dark_high_elven_rock");
        axialSlabBlock(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_SLAB.get(), "light_high_elven_rock");
        axialSlabBlock(BlockLoader.HIGH_ELVEN_BRICKS_SLAB.get(), "high_elven_bricks");
        axialSlabBlock(BlockLoader.DARK_HIGH_ELVEN_BRICKS_SLAB.get(), "dark_high_elven_bricks");
        axialSlabBlock(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_SLAB.get(), "light_high_elven_bricks");
        axialSlabBlock(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_SLAB.get(), "small_high_elven_bricks");
        axialSlabBlock(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_SLAB.get(), "small_dark_high_elven_bricks");
        axialSlabBlock(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_SLAB.get(), "small_light_high_elven_bricks");
        axialSlabBlock(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_SLAB.get(), "cracked_high_elven_bricks");
        axialSlabBlock(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_SLAB.get(), "cracked_dark_high_elven_bricks");
        axialSlabBlock(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_SLAB.get(), "cracked_light_high_elven_bricks");
        axialSlabBlock(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_SLAB.get(), "mossy_high_elven_bricks");
        axialSlabBlock(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_SLAB.get(), "mossy_dark_high_elven_bricks");
        axialSlabBlock(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_SLAB.get(), "mossy_light_high_elven_bricks");
        axialSlabBlock(BlockLoader.BROWN_SANDSTONE_BRICKS_SLAB.get(), "brown_sandstone_bricks");
        axialSlabBlock(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_SLAB.get(), "cracked_brown_sandstone_bricks");
        axialSlabBlock(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_SLAB.get(), "mossy_brown_sandstone_bricks");
        axialSlabBlock(BlockLoader.CACHOLONG_BRICKS_SLAB.get(), "cacholong_bricks");
        axialSlabBlock(BlockLoader.CRACKED_CACHOLONG_BRICKS_SLAB.get(), "cracked_cacholong_bricks");
        axialSlabBlock(BlockLoader.MOSSY_CACHOLONG_BRICKS_SLAB.get(), "mossy_cacholong_bricks");
        axialSlabBlock(BlockLoader.BLACK_DEMON_BRICKS_SLAB.get(), "black_demon_bricks");
        axialSlabBlock(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_SLAB.get(), "cracked_black_demon_bricks");
        axialSlabBlock(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_SLAB.get(), "mossy_black_demon_bricks");
        axialSlabBlock(BlockLoader.BLUE_BRICKS_SLAB.get(), "blue_bricks");
        axialSlabBlock(BlockLoader.CRACKED_BLUE_BRICKS_SLAB.get(), "cracked_blue_bricks");
        axialSlabBlock(BlockLoader.MOSSY_BLUE_BRICKS_SLAB.get(), "mossy_blue_bricks");
        axialSlabBlock(BlockLoader.DEMON_BASALT_BRICKS_SLAB.get(), "demon_basalt_bricks");
        axialSlabBlock(BlockLoader.VULCANIC_DEMON_BRICKS_SLAB.get(), "vulcanic_demon_bricks");
        axialSlabBlock(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_SLAB.get(), "cracked_vulcanic_demon_bricks");
        axialSlabBlock(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_SLAB.get(), "mossy_vulcanic_demon_bricks");
        axialSlabBlock(BlockLoader.RED_BRICKS_SLAB.get(), "red_bricks");
        axialSlabBlock(BlockLoader.CRACKED_RED_BRICKS_SLAB.get(), "cracked_red_bricks");
        axialSlabBlock(BlockLoader.MOSSY_RED_BRICKS_SLAB.get(), "mossy_red_bricks");
        axialSlabBlock(BlockLoader.DESERT_MUD_BRICKS_SLAB.get(), "desert_mud_bricks");
        axialSlabBlock(BlockLoader.CRACKED_DESERT_MUD_BRICKS_SLAB.get(), "cracked_desert_mud_bricks");
        axialSlabBlock(BlockLoader.MOSSY_DESERT_MUD_BRICKS_SLAB.get(), "mossy_desert_mud_bricks");
        axialSlabBlock(BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB.get(), "high_elven_brick_tiling");
        axialSlabBlock(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB.get(), "light_high_elven_brick_tiling");
        axialSlabBlock(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB.get(), "dark_high_elven_brick_tiling");

        axialSlabBlock(BlockLoader.HIGH_ELVEN_COBBLESTONE_SLAB.get(), "high_elven_cobblestone");
        axialSlabBlock(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_SLAB.get(), "dark_high_elven_cobblestone");
        axialSlabBlock(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB.get(), "light_high_elven_cobblestone");

        axialSlabBlock(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_SLAB.get(), "mossy_high_elven_cobblestone");
        axialSlabBlock(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_SLAB.get(), "mossy_dark_high_elven_cobblestone");
        axialSlabBlock(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB.get(), "mossy_light_high_elven_cobblestone");

        axialSlabBlock(BlockLoader.VULCANIC_ROCK_SLAB.get(), "vulcanic_rock");

        axialSlabBlock(BlockLoader.APPLE_PLANKS_SLAB.get(), "apple_planks");
        axialSlabBlock(BlockLoader.ASPEN_PLANKS_SLAB.get(), "aspen_planks");
        axialSlabBlock(BlockLoader.BAOBAB_PLANKS_SLAB.get(), "baobab_planks");
        axialSlabBlock(BlockLoader.BEECH_PLANKS_SLAB.get(), "beech_planks");
        axialSlabBlock(BlockLoader.BLACKTHORN_PLANKS_SLAB.get(), "blackthorn_planks");
        axialSlabBlock(BlockLoader.CEDAR_PLANKS_SLAB.get(), "cedar_planks");
        axialSlabBlock(BlockLoader.CHERRY_PLANKS_SLAB.get(), "cherry_planks");
        axialSlabBlock(BlockLoader.CYPRESS_PLANKS_SLAB.get(), "cypress_planks");
        axialSlabBlock(BlockLoader.FIR_PLANKS_SLAB.get(), "fir_planks");
        axialSlabBlock(BlockLoader.GHOST_GUM_PLANKS_SLAB.get(), "ghost_gum_planks");
        axialSlabBlock(BlockLoader.GREEN_OAK_PLANKS_SLAB.get(), "green_oak_planks");
        axialSlabBlock(BlockLoader.HOLLY_PLANKS_SLAB.get(), "holly_planks");
        axialSlabBlock(BlockLoader.LARCH_PLANKS_SLAB.get(), "larch_planks");
        axialSlabBlock(BlockLoader.MAPLE_PLANKS_SLAB.get(), "maple_planks");
        axialSlabBlock(BlockLoader.OKOME_PLANKS_SLAB.get(), "okome_planks");
        axialSlabBlock(BlockLoader.PEAR_PLANKS_SLAB.get(), "pear_planks");
        axialSlabBlock(BlockLoader.PINE_PLANKS_SLAB.get(), "pine_planks");
        axialSlabBlock(BlockLoader.PLUM_PLANKS_SLAB.get(), "plum_planks");
        axialSlabBlock(BlockLoader.RED_OAK_PLANKS_SLAB.get(), "red_oak_planks");
        axialSlabBlock(BlockLoader.SILVER_SPRUCE_PLANKS_SLAB.get(), "silver_spruce_planks");
        axialSlabBlock(BlockLoader.WHITE_ASH_PLANKS_SLAB.get(), "white_ash_planks");


    }

    public void axialSlabBlock(Block b, String texture){
        ResourceLocation bottom = prefix("block/" + texture);
        ResourceLocation top = prefix("block/" + texture);
        ResourceLocation side = prefix("block/" + texture);
        ConfiguredModel bottomModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), "block/slab")
                        .texture("bottom", bottom)
                        .texture("top", top)
                        .texture("side", side))
                .buildLast();
        ConfiguredModel topModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_top", "block/slab_top")
                        .texture("bottom", bottom)
                        .texture("top", top)
                        .texture("side", side))
                .buildLast();
        ConfiguredModel doubleModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_double", "block/cube_all")
                        .texture("all", side))
                .buildLast();
        ConfiguredModel bottomModelZ = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), "block/slab")
                        .texture("bottom", bottom)
                        .texture("top", top)
                        .texture("side", side))
                .uvLock(true).rotationX(270)
                .buildLast();
        ConfiguredModel topModelZ = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_top", "block/slab_top")
                        .texture("bottom", bottom)
                        .texture("top", top)
                        .texture("side", side))
                .uvLock(true).rotationX(270)
                .buildLast();
        ConfiguredModel doubleModelZ = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_double", "block/cube_all")
                        .texture("all", side))
                .uvLock(true).rotationX(270)
                .buildLast();
        ConfiguredModel bottomModelX = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), "block/slab")
                        .texture("bottom", bottom)
                        .texture("top", top)
                        .texture("side", side))
                .uvLock(true).rotationX(90).rotationY(90)
                .buildLast();
        ConfiguredModel topModelX = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_top", "block/slab_top")
                        .texture("bottom", bottom)
                        .texture("top", top)
                        .texture("side", side))
                .uvLock(true).rotationX(90).rotationY(90)
                .buildLast();
        ConfiguredModel doubleModelX = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_double", "block/cube_all")
                        .texture("all", side))
                .uvLock(true).rotationX(90).rotationY(90)
                .buildLast();
        getVariantBuilder(b)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y).with(SlabBlock.TYPE, SlabType.BOTTOM).setModels(bottomModel)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y).with(SlabBlock.TYPE, SlabType.TOP).setModels(topModel)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y).with(SlabBlock.TYPE, SlabType.DOUBLE).setModels(doubleModel)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z).with(SlabBlock.TYPE, SlabType.BOTTOM).setModels(bottomModelZ)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z).with(SlabBlock.TYPE, SlabType.TOP).setModels(topModelZ)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z).with(SlabBlock.TYPE, SlabType.DOUBLE).setModels(doubleModelZ)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X).with(SlabBlock.TYPE, SlabType.BOTTOM).setModels(bottomModelX)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X).with(SlabBlock.TYPE, SlabType.TOP).setModels(topModelX)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X).with(SlabBlock.TYPE, SlabType.DOUBLE).setModels(doubleModelX);
    }

    private void rotationallyCorrectColumn(Block b) {
        ResourceLocation side = prefix("block/" + name(b) + "_side");
        ResourceLocation end = prefix("block/" + name(b) + "_end");
        ConfiguredModel yModel = new ConfiguredModel(models().cubeColumn(name(b), side, end));
        ConfiguredModel xModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_x", prefix("block/util/cube_column_rotationally_correct_x"))
                        .texture("side", side).texture("end", end))
                .rotationX(90).rotationY(90)
                .buildLast();
        ConfiguredModel zModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_z", prefix("block/util/cube_column_rotationally_correct_z"))
                        .texture("side", side).texture("end", end))
                .rotationX(90)
                .buildLast();
        getVariantBuilder(b)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y).setModels(yModel)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X).setModels(xModel)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z).setModels(zModel);
    }

    private void arrowSlit(Block b, String textures){
        ResourceLocation particle = prefix("block/" + textures);
        ResourceLocation texture = prefix("block/" + textures);
        ResourceLocation top = prefix("block/" + textures);
        ResourceLocation bottom = prefix("block/" + textures);
        ConfiguredModel southModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), prefix("block/template_arrowslit"))
                        .texture("particle", particle)
                        .texture("texture", texture)
                        .texture("top", top)
                        .texture("bottom", bottom))
                .uvLock(true).rotationY(180)
                .buildLast();
        ConfiguredModel westModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), prefix("block/template_arrowslit"))
                        .texture("particle", particle)
                        .texture("texture", texture)
                        .texture("top", top)
                        .texture("bottom", bottom))
                .uvLock(true).rotationY(270)
                .buildLast();
        ConfiguredModel northModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), prefix("block/template_arrowslit"))
                        .texture("particle", particle)
                        .texture("texture", texture)
                        .texture("top", top)
                        .texture("bottom", bottom))
                .uvLock(true)
                .buildLast();
        ConfiguredModel eastModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), prefix("block/template_arrowslit"))
                        .texture("particle", particle)
                        .texture("texture", texture)
                        .texture("top", top)
                        .texture("bottom", bottom))
                .uvLock(true).rotationY(90)
                .buildLast();
        getVariantBuilder(b)
                .partialState().with(WaterloggedHorizontalDirectionalShape.DIRECTION, Direction.SOUTH).setModels(southModel)
                .partialState().with(WaterloggedHorizontalDirectionalShape.DIRECTION, Direction.WEST).setModels(westModel)
                .partialState().with(WaterloggedHorizontalDirectionalShape.DIRECTION, Direction.NORTH).setModels(northModel)
                .partialState().with(WaterloggedHorizontalDirectionalShape.DIRECTION, Direction.EAST).setModels(eastModel);

    }

    private void balustradeBlock(Block b, String texture) {
        ResourceLocation particle = prefix("block/" + texture);
        ResourceLocation body = prefix("block/" + texture);
        ResourceLocation top = prefix("block/" + texture);
        ResourceLocation bottom = prefix("block/" + texture);
        ConfiguredModel yModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_base", prefix("block/template_cornice_balustrade_base"))
                        .texture("particle", particle)
                        .texture("body", body)
                        .texture("top", top)
                        .texture("bottom", bottom))
                .uvLock(true)
                .buildLast();
        ConfiguredModel xModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), prefix("block/template_cornice_balustrade"))
                        .texture("particle", particle)
                        .texture("body", body)
                        .texture("top", top)
                        .texture("bottom", bottom))
                .uvLock(true).rotationY(90)
                .buildLast();
        ConfiguredModel zModel = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), prefix("block/template_cornice_balustrade"))
                        .texture("particle", particle)
                        .texture("body", body)
                        .texture("top", top)
                        .texture("bottom", bottom))
                .uvLock(true)
                .buildLast();
        getVariantBuilder(b)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y).setModels(yModel)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X).setModels(xModel)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z).setModels(zModel);
    }


    private void allRotations(Block b, ModelFile model) {
        ConfiguredModel.Builder<?> builder = ConfiguredModel.builder();
        int[] rots = {0, 90, 180, 270};
        for (int x : rots) {
            for (int y : rots) {
                builder = builder.modelFile(model).rotationX(x).rotationY(y);
                if (x != rots[rots.length - 1] && y != rots[rots.length - 1]) {
                    builder = builder.nextModel();
                }
            }
        }
        simpleBlock(b, builder.build());
    }

    private void stonePillar(Block b) {
        ResourceLocation single = prefix("block/" + name(b));
        ResourceLocation end = prefix("block/" + name(b) + "_face");
        ResourceLocation topTex = prefix("block/" + name(b) + "_top");
        ResourceLocation bottomTex = prefix("block/" + name(b) + "_bottom");
        ResourceLocation middleTex = prefix("block/" + name(b) + "_middle");

        ConfiguredModel base = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", single))
                .buildLast();

        ConfiguredModel top = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_top", suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", topTex))
                .buildLast();

        ConfiguredModel bottom = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_bottom", suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", bottomTex))
                .buildLast();

        ConfiguredModel middle = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_middle", suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", middleTex))
                .buildLast();

        ConfiguredModel baseZ = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", single)).rotationX(270)
                .buildLast();

        ConfiguredModel topZ = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_top", suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", topTex)).rotationX(270)
                .buildLast();

        ConfiguredModel bottomZ  = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_bottom", suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", bottomTex)).rotationX(270)
                .buildLast();

        ConfiguredModel middleZ  = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_middle", suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", middleTex)).rotationX(270)
                .buildLast();

        ConfiguredModel baseX = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b), suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", single)).rotationX(90).rotationY(90)
                .buildLast();

        ConfiguredModel topX = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_top", suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", topTex)).rotationX(90).rotationY(90)
                .buildLast();

        ConfiguredModel bottomX  = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_bottom", suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", bottomTex)).rotationX(90).rotationY(90)
                .buildLast();

        ConfiguredModel middleX  = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_middle", suffix("block/cube_column"))
                        .texture("end", end)
                        .texture("side", middleTex)).rotationX(90).rotationY(90)
                .buildLast();

        getVariantBuilder(b)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y).with(EdumiaPillarBlock.ABOVE, false).with(EdumiaPillarBlock.BELOW, false).setModels(base)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y).with(EdumiaPillarBlock.ABOVE, false).with(EdumiaPillarBlock.BELOW, true).setModels(top)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y).with(EdumiaPillarBlock.ABOVE, true).with(EdumiaPillarBlock.BELOW, false).setModels(bottom)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y).with(EdumiaPillarBlock.ABOVE, true).with(EdumiaPillarBlock.BELOW, true).setModels(middle)

                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z).with(EdumiaPillarBlock.ABOVE, false).with(EdumiaPillarBlock.BELOW, false).setModels(baseZ)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z).with(EdumiaPillarBlock.ABOVE, false).with(EdumiaPillarBlock.BELOW, true).setModels(topZ)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z).with(EdumiaPillarBlock.ABOVE, true).with(EdumiaPillarBlock.BELOW, false).setModels(bottomZ)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z).with(EdumiaPillarBlock.ABOVE, true).with(EdumiaPillarBlock.BELOW, true).setModels(middleZ)

                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X).with(EdumiaPillarBlock.ABOVE, false).with(EdumiaPillarBlock.BELOW, false).setModels(baseX)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X).with(EdumiaPillarBlock.ABOVE, false).with(EdumiaPillarBlock.BELOW, true).setModels(topX)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X).with(EdumiaPillarBlock.ABOVE, true).with(EdumiaPillarBlock.BELOW, false).setModels(bottomX)
                .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X).with(EdumiaPillarBlock.ABOVE, true).with(EdumiaPillarBlock.BELOW, true).setModels(middleX);









//        ModelFile base1 = models().getExistingFile(suffix("block/cube_column"));
//        ModelFile top2 = models().getExistingFile(suffix("block/cube_column"));
//        ModelFile bottom2 = models().getExistingFile(suffix("block/cube_column"));
//        ModelFile middle2 = models().getExistingFile(suffix("block/cube_column"));



//        getMultipartBuilder(b)
//                .part().modelFile(base).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.Y).condition(EdumiaPillarBlock.ABOVE, false).condition(EdumiaPillarBlock.BELOW, false).end()
//                .part().modelFile(top).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.Y).condition(EdumiaPillarBlock.ABOVE, false).condition(EdumiaPillarBlock.BELOW, true).end()
//                .part().modelFile(bottom).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.Y).condition(EdumiaPillarBlock.ABOVE, true).condition(EdumiaPillarBlock.BELOW, false).end()
//                .part().modelFile(middle).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.Y).condition(EdumiaPillarBlock.ABOVE, true).condition(EdumiaPillarBlock.BELOW, true).end()
//
//                .part().modelFile(base).rotationX(270).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.Z).condition(EdumiaPillarBlock.ABOVE, false).condition(EdumiaPillarBlock.BELOW, false).end()
//                .part().modelFile(top).rotationX(270).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.Z).condition(EdumiaPillarBlock.ABOVE, false).condition(EdumiaPillarBlock.BELOW, true).end()
//                .part().modelFile(bottom).rotationX(270).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.Z).condition(EdumiaPillarBlock.ABOVE, true).condition(EdumiaPillarBlock.BELOW, false).end()
//                .part().modelFile(middle).rotationX(270).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.Z).condition(EdumiaPillarBlock.ABOVE, true).condition(EdumiaPillarBlock.BELOW, true).end()
//
//                .part().modelFile(base).rotationX(90).rotationY(90).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.X).condition(EdumiaPillarBlock.ABOVE, false).condition(EdumiaPillarBlock.BELOW, false).end()
//                .part().modelFile(top).rotationX(90).rotationY(90).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.X).condition(EdumiaPillarBlock.ABOVE, false).condition(EdumiaPillarBlock.BELOW, true).end()
//                .part().modelFile(bottom).rotationX(90).rotationY(90).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.X).condition(EdumiaPillarBlock.ABOVE, true).condition(EdumiaPillarBlock.BELOW, false).end()
//                .part().modelFile(middle).rotationX(90).rotationY(90).addModel().condition(RotatedPillarBlock.AXIS, Direction.Axis.X).condition(EdumiaPillarBlock.ABOVE, true).condition(EdumiaPillarBlock.BELOW, true).end();

    }

//    private void stonePillar(Block b) {
//        ResourceLocation end = prefix("block/" + name(b));
//        ResourceLocation side = prefix("block/" + name(b));
//
//        ModelFile base = models().getExistingFile(prefix("block/cube_column"));
//        ModelFile up = models().getExistingFile(prefix("block/cube_column"));
//        ModelFile down = models().getExistingFile(prefix("block/cube_column"));
//        ModelFile top = models().getExistingFile(prefix("block/cube_column"));
//        ModelFile bottom = models().getExistingFile(prefix("block/cube_column"));
//
//        getMultipartBuilder(TFBlocks.TWISTED_STONE_PILLAR.get())
//                .part().modelFile(base).rotationX(90).rotationY(90).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.X).end()
//                .part().modelFile(top).rotationX(90).rotationY(90).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.X).condition(PipeBlock.EAST, false).end()
//                .part().modelFile(bottom).rotationX(90).rotationY(90).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.X).condition(PipeBlock.WEST, false).end()
//                .part().modelFile(up).rotationX(90).rotationY(90).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.Y, Direction.Axis.Z).condition(PipeBlock.EAST, true).end()
//                .part().modelFile(down).rotationX(90).rotationY(90).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.Y, Direction.Axis.Z).condition(PipeBlock.WEST, true).end()
//
//                .part().modelFile(base).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.Y).end()
//                .part().modelFile(top).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.Y).condition(PipeBlock.UP, false).end()
//                .part().modelFile(bottom).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.Y).condition(PipeBlock.DOWN, false).end()
//                .part().modelFile(up).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.X, Direction.Axis.Z).condition(PipeBlock.UP, true).end()
//                .part().modelFile(down).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.X, Direction.Axis.Z).condition(PipeBlock.DOWN, true).end()
//
//                .part().modelFile(base).rotationX(90).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.Z).end()
//                .part().modelFile(top).rotationX(90).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.Z).condition(PipeBlock.NORTH, false).end()
//                .part().modelFile(bottom).rotationX(90).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.Z).condition(PipeBlock.SOUTH, false).end()
//                .part().modelFile(up).rotationX(90).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.X, Direction.Axis.Y).condition(PipeBlock.NORTH, true).end()
//                .part().modelFile(down).rotationX(90).addModel().condition(WallPillarBlock.AXIS, Direction.Axis.X, Direction.Axis.Y).condition(PipeBlock.SOUTH, true).end();
//
//    }


    private void layerBlock(Block b, String texture) {
        ResourceLocation particle = prefix("block/" + texture);
        ResourceLocation textures = prefix("block/" + texture);
        ConfiguredModel height2 = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_height2", suffix("block/thin_block"))
                        .texture("particle", particle)
                        .texture("texture", textures)
                        .element().from(0.0F, 0.0F, 0.0F).to(16.0F, 2.0F, 16.0F)
                        .face(Direction.DOWN).texture("#texture").cullface(Direction.DOWN).uvs(0,0,16,16).end()
                        .face(Direction.UP).texture("#texture").uvs(0,0,16,16).end()
                        .face(Direction.NORTH).texture("#texture").cullface(Direction.NORTH).uvs(0,14,16,16).end()
                        .face(Direction.SOUTH).texture("#texture").cullface(Direction.SOUTH).uvs(0,14,16,16).end()
                        .face(Direction.WEST).texture("#texture").cullface(Direction.WEST).uvs(0,14,16,16).end()
                        .face(Direction.EAST).texture("#texture").cullface(Direction.EAST).uvs(0,14,16,16).end()
                        .end()
                )
                .buildLast();

        ConfiguredModel height4 = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_height4", suffix("block/thin_block"))
                        .texture("particle", particle)
                        .texture("texture", textures)
                        .element().from(0.0F, 0.0F, 0.0F).to(16.0F, 4.0F, 16.0F)
                        .face(Direction.DOWN).texture("#texture").cullface(Direction.DOWN).uvs(0,0,16,16).end()
                        .face(Direction.UP).texture("#texture").uvs(0,0,16,16).end()
                        .face(Direction.NORTH).texture("#texture").cullface(Direction.NORTH).uvs(0,12,16,16).end()
                        .face(Direction.SOUTH).texture("#texture").cullface(Direction.SOUTH).uvs(0,12,16,16).end()
                        .face(Direction.WEST).texture("#texture").cullface(Direction.WEST).uvs(0,12,16,16).end()
                        .face(Direction.EAST).texture("#texture").cullface(Direction.EAST).uvs(0,12,16,16).end()
                        .end()
                )
                .buildLast();
        ConfiguredModel height6 = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_height6", suffix("block/thin_block"))
                        .texture("particle", particle)
                        .texture("texture", textures)
                        .element().from(0.0F, 0.0F, 0.0F).to(16.0F, 6.0F, 16.0F)
                        .face(Direction.DOWN).texture("#texture").cullface(Direction.DOWN).uvs(0,0,16,16).end()
                        .face(Direction.UP).texture("#texture").uvs(0,0,16,16).end()
                        .face(Direction.NORTH).texture("#texture").cullface(Direction.NORTH).uvs(0,10,16,16).end()
                        .face(Direction.SOUTH).texture("#texture").cullface(Direction.SOUTH).uvs(0,10,16,16).end()
                        .face(Direction.WEST).texture("#texture").cullface(Direction.WEST).uvs(0,10,16,16).end()
                        .face(Direction.EAST).texture("#texture").cullface(Direction.EAST).uvs(0,10,16,16).end()
                        .end()
                )
                .buildLast();
        ConfiguredModel height8 = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_height8", suffix("block/thin_block"))
                        .texture("particle", particle)
                        .texture("texture", textures)
                        .element().from(0.0F, 0.0F, 0.0F).to(16.0F, 8.0F, 16.0F)
                        .face(Direction.DOWN).texture("#texture").cullface(Direction.DOWN).uvs(0,0,16,16).end()
                        .face(Direction.UP).texture("#texture").uvs(0,0,16,16).end()
                        .face(Direction.NORTH).texture("#texture").cullface(Direction.NORTH).uvs(0,8,16,16).end()
                        .face(Direction.SOUTH).texture("#texture").cullface(Direction.SOUTH).uvs(0,8,16,16).end()
                        .face(Direction.WEST).texture("#texture").cullface(Direction.WEST).uvs(0,8,16,16).end()
                        .face(Direction.EAST).texture("#texture").cullface(Direction.EAST).uvs(0,8,16,16).end()
                        .end()
                )
                .buildLast();
        ConfiguredModel height10 = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_height10", suffix("block/thin_block"))
                        .texture("particle", particle)
                        .texture("texture", textures)
                        .element().from(0.0F, 0.0F, 0.0F).to(16.0F, 10.0F, 16.0F)
                        .face(Direction.DOWN).texture("#texture").cullface(Direction.DOWN).uvs(0,0,16,16).end()
                        .face(Direction.UP).texture("#texture").uvs(0,0,16,16).end()
                        .face(Direction.NORTH).texture("#texture").cullface(Direction.NORTH).uvs(0,6,16,16).end()
                        .face(Direction.SOUTH).texture("#texture").cullface(Direction.SOUTH).uvs(0,6,16,16).end()
                        .face(Direction.WEST).texture("#texture").cullface(Direction.WEST).uvs(0,6,16,16).end()
                        .face(Direction.EAST).texture("#texture").cullface(Direction.EAST).uvs(0,6,16,16).end()
                        .end()
                )
                .buildLast();
        ConfiguredModel height12 = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_height12", suffix("block/thin_block"))
                        .texture("particle", particle)
                        .texture("texture", textures)
                        .element().from(0.0F, 0.0F, 0.0F).to(16.0F, 12.0F, 16.0F)
                        .face(Direction.DOWN).texture("#texture").cullface(Direction.DOWN).uvs(0,0,4,16).end()
                        .face(Direction.UP).texture("#texture").uvs(0,0,16,16).end()
                        .face(Direction.NORTH).texture("#texture").cullface(Direction.NORTH).uvs(0,4,16,16).end()
                        .face(Direction.SOUTH).texture("#texture").cullface(Direction.SOUTH).uvs(0,4,16,16).end()
                        .face(Direction.WEST).texture("#texture").cullface(Direction.WEST).uvs(0,4,16,16).end()
                        .face(Direction.EAST).texture("#texture").cullface(Direction.EAST).uvs(0,4,16,16).end()
                        .end()
                )
                .buildLast();
        ConfiguredModel height14 = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_height14", suffix("block/thin_block"))
                        .texture("particle", particle)
                        .texture("texture", textures)
                        .element().from(0.0F, 0.0F, 0.0F).to(16.0F, 14.0F, 16.0F)
                        .face(Direction.DOWN).texture("#texture").cullface(Direction.DOWN).uvs(0,0,16,16).end()
                        .face(Direction.UP).texture("#texture").uvs(0,0,16,16).end()
                        .face(Direction.NORTH).texture("#texture").cullface(Direction.NORTH).uvs(0,2,16,16).end()
                        .face(Direction.SOUTH).texture("#texture").cullface(Direction.SOUTH).uvs(0,2,16,16).end()
                        .face(Direction.WEST).texture("#texture").cullface(Direction.WEST).uvs(0,2,16,16).end()
                        .face(Direction.EAST).texture("#texture").cullface(Direction.EAST).uvs(0,2,16,16).end()
                        .end()
                )
                .buildLast();
        ConfiguredModel height16 = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(name(b) + "_height16", suffix("block/block"))
                        .texture("particle", particle)
                        .texture("texture", textures)
                        .element().from(0.0F, 0.0F, 0.0F).to(16.0F, 16.0F, 16.0F)
                        .face(Direction.DOWN).texture("#texture").cullface(Direction.DOWN).end()
                        .face(Direction.UP).texture("#texture").end()
                        .face(Direction.NORTH).texture("#texture").cullface(Direction.NORTH).end()
                        .face(Direction.SOUTH).texture("#texture").cullface(Direction.SOUTH).end()
                        .face(Direction.WEST).texture("#texture").cullface(Direction.WEST).end()
                        .face(Direction.EAST).texture("#texture").cullface(Direction.EAST).end()
                        .end()
                )
                .buildLast();

        getVariantBuilder(b)
                .partialState().with(Layer.LAYERS, 1).setModels(height2)
                .partialState().with(Layer.LAYERS, 2).setModels(height4)
                .partialState().with(Layer.LAYERS, 3).setModels(height6)
                .partialState().with(Layer.LAYERS, 4).setModels(height8)
                .partialState().with(Layer.LAYERS, 5).setModels(height10)
                .partialState().with(Layer.LAYERS, 6).setModels(height12)
                .partialState().with(Layer.LAYERS, 7).setModels(height14)
                .partialState().with(Layer.LAYERS, 8).setModels(height16);
    }




    @Nonnull
    @Override
    public String getName() {
        return "Edumia blockstates and block models";
    }
}