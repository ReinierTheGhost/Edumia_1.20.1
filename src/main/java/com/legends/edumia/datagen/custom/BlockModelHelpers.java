package com.legends.edumia.datagen.custom;

import com.legends.edumia.Edumia;
import com.legends.edumia.block.BanisterBlock;
import com.legends.edumia.block.arches.Arch;
import com.legends.edumia.block.arches.ArchSmall;
import com.legends.edumia.block.arches.ArchTwoMeter;
import com.legends.edumia.block.block.Balustrade;
import com.legends.edumia.block.block.VerticalCorner;
import com.legends.edumia.block.plants.ReedsBlock;
import com.legends.edumia.block.properties.ArchShape;
import com.legends.edumia.core.block.properties.BidirectionalShape;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.Direction;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static com.legends.edumia.Edumia.prefix;
import static com.legends.edumia.Edumia.suffix;


public abstract class BlockModelHelpers extends BlockStateProvider {

    protected static final ResourceLocation SOLID = new ResourceLocation("solid");
    protected static final ResourceLocation CUTOUT = new ResourceLocation("cutout");
    protected static final ResourceLocation CUTOUT_MIPPED = new ResourceLocation("cutout_mipped");
    protected static final ResourceLocation TRANSLUCENT = new ResourceLocation("translucent");

    public BlockModelHelpers(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Edumia.MODID, exFileHelper);
    }

    protected void builtinEntity(Block b, String particle) {
        simpleBlock(b, models().getBuilder(name(b))
                .parent(new ModelFile.UncheckedModelFile("builtin/entity"))
                .texture("particle", particle));
    }

    protected void simpleBlockExisting(Block b) {
        simpleBlock(b, new ConfiguredModel(models().getExistingFile(prefix(name(b)))));
    }

    public void simpleBlockWithRenderType(Block block, ResourceLocation type) {
        simpleBlock(block, models().cubeAll(name(block), blockTexture(block)).renderType(type));
    }

    /**
     * Generates a blockstate json pointing to one single generated model with the same name as the block
     * The single generated model has the given parent and can be customized.
     */

    protected void logWoodSapling(RotatedPillarBlock log, RotatedPillarBlock slog, RotatedPillarBlock wood, RotatedPillarBlock swood, Block sapling) {
        logBlock(log);
        logBlock(slog);
        ResourceLocation sideTex = blockTexture(log);
        axisBlock(wood, sideTex, sideTex);
        ResourceLocation sSideTex = blockTexture(slog);
        axisBlock(swood, sSideTex, sSideTex);

        ResourceLocation saplingTex = prefix("block/" + name(sapling));
        simpleBlock(sapling, models().cross(name(sapling), saplingTex).renderType(CUTOUT));
    }

    protected void plankBlocks(String variant, Block plank, Block slab, StairBlock stair, Block button, Block fence, Block gate,
                               Block plate, DoorBlock door, TrapDoorBlock trapdoor, BanisterBlock banister) {
        this.plankBlocks(variant, plank, slab, stair, button, fence, gate, plate, door, trapdoor, false, banister);
    }

    protected void plankBlocks(String variant, Block plank, Block slab, StairBlock stair, Block button, Block fence, Block gate,
                               Block plate, DoorBlock door, TrapDoorBlock trapdoor, boolean cutoutDoors, BanisterBlock banister) {
        String plankTexName =variant + "_planks" ;
        String plankDir = "block/";
        ResourceLocation tex = prefix("block/" + plankTexName);

        ConfiguredModel[] plankModels = ConfiguredModel.builder()
                .modelFile(models().cubeAll(plankDir + name(plank), tex)).build();
        simpleBlock(plank, plankModels);

        axialSlabBlock(slab, plankTexName);

        woodStairs(stair, plankTexName, variant);
        woodButton(button, plankTexName, variant);
        woodFence(fence, plankTexName, variant);
        woodGate(gate, plankTexName, variant);
        woodPlate(plate, plankTexName, variant);
        String doorDir = "block/";
        String trapdoorDir = "block/";

        if(cutoutDoors) {
            doorBlockWithRenderType(door, doorDir + name(door), prefix("block/" + variant + "_door_lower"), prefix("block/" + variant + "_door_upper"), CUTOUT);
            trapdoorBlockWithRenderType(trapdoor, trapdoorDir + variant, prefix("block/" + variant + "_trapdoor"), true, CUTOUT);
        } else {
            doorBlock(door, doorDir + name(door), prefix("block/" + variant + "_door_lower"), prefix("block/" + variant + "_door_upper"));
            trapdoorBlock(trapdoor, trapdoorDir + variant, prefix("block/" + variant + "_trapdoor"), true);

        }

        banister(banister, plankTexName, variant);


    }

    public void archBlocks(String texture, Block round, Block segmental, Block gothic, Block small, Block twoMeter){
        roundArch(round, texture);
        segmentalArch(segmental, texture);
        gothicArch(gothic, texture);
        smallArch(small, texture);
        twoMeterArch(twoMeter, texture);
    }



    protected void woodGate(Block gate, String texName, String variant) {
        String gateDir = "block/";

        ResourceLocation tex0 = prefix("block/" + texName);


        ModelFile gate0 = models().fenceGate(gateDir + name(gate), tex0);
        ModelFile open0 = models().fenceGateOpen(gateDir + name(gate) + "_open", tex0);
        ModelFile wall0 = models().fenceGateWall(gateDir + name(gate) + "_wall", tex0);
        ModelFile wallOpen0 = models().fenceGateWallOpen(gateDir + name(gate) + "_wall_open", tex0);

        // [VanillaCopy] super.fenceGateBlock except with more models
        getVariantBuilder(gate).forAllStatesExcept(state -> {
            ModelFile model0 = gate0;
            if (state.getValue(FenceGateBlock.IN_WALL)) {
                model0 = wall0;
            }
            if (state.getValue(FenceGateBlock.OPEN)) {
                model0 = model0 == wall0 ? wallOpen0 : open0;
            }
            return ConfiguredModel.builder()
                    .modelFile(model0)
                    .rotationY((int) state.getValue(HorizontalDirectionalBlock.FACING).toYRot())
                    .uvLock(true).build();
        }, FenceGateBlock.POWERED);
    }

    protected void woodFence(Block fence, String texName, String variant) {
        String fenceDir = "block/";

        ResourceLocation tex0 = prefix("block/" + texName);


        ModelFile post0 = models().fencePost(fenceDir + name(fence) + "_post", tex0);
        ModelFile side0 = models().fenceSide(fenceDir + name(fence) + "_side", tex0);

        // [VanillaCopy] super.fourWayBlock, but with more models
        MultiPartBlockStateBuilder builder = getMultipartBuilder(fence).part()
                .modelFile(post0).addModel().end();
        PipeBlock.PROPERTY_BY_DIRECTION.forEach((dir, value) -> {
            if (dir.getAxis().isHorizontal()) {
                builder.part()
                        .modelFile(side0).rotationY((((int) dir.toYRot()) + 180) % 360).uvLock(true)
                        .addModel()
                        .condition(value, true);
            }
        });
    }

    protected void woodPlate(Block plate, String texName, String variant) {
        String plateDir = "block/";

        ResourceLocation tex0 = prefix("block/" + texName);
        ConfiguredModel[] unpressed = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(plateDir + name(plate), "pressure_plate_up")
                        .texture("texture", tex0)).build();
        ConfiguredModel[] pressed = ConfiguredModel.builder()
                .modelFile(models().withExistingParent(plateDir + name(plate) + "_down", "pressure_plate_down")
                        .texture("texture", tex0)).build();

        getVariantBuilder(plate).partialState().with(PressurePlateBlock.POWERED, false).setModels(unpressed);
        getVariantBuilder(plate).partialState().with(PressurePlateBlock.POWERED, true).setModels(pressed);
    }

    protected void woodButton(Block button, String texName, String variant) {
        String buttonDir = "block/";

        ResourceLocation tex0 = prefix("block/" + texName);
        ModelFile unpressed0 = models().withExistingParent(buttonDir + name(button), "button")
                .texture("texture", tex0);
        ModelFile pressed0 = models().withExistingParent(buttonDir + name(button) + "_pressed", "button_pressed")
                .texture("texture", tex0);
        getVariantBuilder(button).forAllStates(state -> {
            ModelFile model0 = state.getValue(ButtonBlock.POWERED) ? pressed0 : unpressed0;
            int rotX = switch (state.getValue(FaceAttachedHorizontalDirectionalBlock.FACE)) {
                case WALL -> 90;
                case FLOOR -> 0;
                case CEILING -> 180;
            };
            int rotY = 0;
            if (state.getValue(FaceAttachedHorizontalDirectionalBlock.FACE) == AttachFace.CEILING)  {
                switch (state.getValue(HorizontalDirectionalBlock.FACING)) {
                    case NORTH -> rotY = 180;
                    case WEST -> rotY = 90;
                    case EAST -> rotY = 270;
                }
            } else {
                switch (state.getValue(HorizontalDirectionalBlock.FACING)) {
                    case SOUTH -> rotY = 180;
                    case WEST -> rotY = 270;
                    case EAST -> rotY = 90;
                }
            }
            boolean uvlock = state.getValue(FaceAttachedHorizontalDirectionalBlock.FACE) == AttachFace.WALL;

            return ConfiguredModel.builder()
                    .uvLock(uvlock).rotationX(rotX).rotationY(rotY).modelFile(model0)
                    .build();
        });
    }

    protected void woodStairs(StairBlock block, String texName, String variant) {
        String stairsDir = "block/";

        ResourceLocation tex0 = prefix("block/" + texName);
        ModelFile main0 = models().stairs(stairsDir + name(block), tex0, tex0, tex0);
        ModelFile inner0 = models().stairsInner(stairsDir + name(block) + "_inner", tex0, tex0, tex0);
        ModelFile outer0 = models().stairsOuter(stairsDir + name(block) + "_outer", tex0, tex0, tex0);
        // [VanillaCopy] super.stairsBlock, but multiple files returned each time
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    Direction facing = state.getValue(StairBlock.FACING);
                    Half half = state.getValue(StairBlock.HALF);
                    StairsShape shape = state.getValue(StairBlock.SHAPE);
                    int yRot = (int) facing.getClockWise().toYRot(); // Stairs model is rotated 90 degrees clockwise for some reason
                    if (shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT) {
                        yRot += 270; // Left facing stairs are rotated 90 degrees clockwise
                    }
                    if (shape != StairsShape.STRAIGHT && half == Half.TOP) {
                        yRot += 90; // Top stairs are rotated 90 degrees clockwise
                    }
                    yRot %= 360;
                    boolean uvlock = yRot != 0 || half == Half.TOP; // Don't set uvlock for states that have no rotation
                    return ConfiguredModel.builder()
                            .modelFile(shape == StairsShape.STRAIGHT ? main0 : shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT ? inner0 : outer0)
                            .rotationX(half == Half.BOTTOM ? 0 : 180).rotationY(yRot).uvLock(uvlock)

                            .build();
                }, StairBlock.WATERLOGGED);
    }

    protected void banister(BanisterBlock banister, String texName, String woodVariant) {
        String banisterDir = "block/";

        ResourceLocation tex0 = prefix("block/" + texName);

        getVariantBuilder(banister).forAllStatesExcept(state -> {
                    Direction facing = state.getValue(BanisterBlock.FACING);
                    int yRot = (int) facing.toYRot();
                    String extended = state.getValue(BanisterBlock.EXTENDED) ? "_extended" : "";
                    String variant = state.getValue(BanisterBlock.SHAPE).getSerializedName() + extended;
                    String newModelName = banisterDir + name(banister) + "_" + variant;

                    return ConfiguredModel.builder()
                            .modelFile(models().withExistingParent(newModelName, prefix("banister_" + variant))
                                    .texture("texture", tex0)).rotationY(yRot).build();
                },
                BanisterBlock.WATERLOGGED);
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

    public void roundArch(Block b, String texture) {
        ResourceLocation particle = prefix("block/" + texture);
        ResourceLocation keystones = prefix("block/" + texture);
        ResourceLocation keystones1 = prefix("block/" + texture);
        ResourceLocation keystones2 = prefix("block/" + texture);
        ResourceLocation underside1 = prefix("block/" + texture);
        ResourceLocation underside2 = prefix("block/" + texture);
        ResourceLocation underside3 = prefix("block/" + texture);

        ConfiguredModel roundArch1South = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_round_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch1West = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_round_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).rotationY(180).buildLast();
        ConfiguredModel roundArch1North = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_round_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch1East = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_round_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).buildLast();

        ConfiguredModel roundArch2South = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_round_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
                .ao(true)
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch2West = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_round_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).buildLast();
        ConfiguredModel roundArch2North = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_round_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch2East = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_round_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(180).buildLast();

        ConfiguredModel roundArch3South = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_round_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch3West = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_round_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).buildLast();
        ConfiguredModel roundArch3North = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_round_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch3East = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_round_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(180).buildLast();

        ConfiguredModel roundArch3MiddleSouth = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_round_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch3MiddleWest = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_round_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).buildLast();
        ConfiguredModel roundArch3MiddleNorth = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_round_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch3MiddleEast = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_round_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(180).buildLast();

        getVariantBuilder(b)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.SOUTH).setModels(roundArch1South)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.WEST).setModels(roundArch1West)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.NORTH).setModels(roundArch1North)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.EAST).setModels(roundArch1East)

                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.SOUTH).setModels(roundArch2South)
                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.WEST).setModels(roundArch2West)
                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.NORTH).setModels(roundArch2North)
                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.EAST).setModels(roundArch2East)

                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.SOUTH).setModels(roundArch3South)
                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.WEST).setModels(roundArch3West)
                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.NORTH).setModels(roundArch3North)
                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.EAST).setModels(roundArch3East)

                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.SOUTH).setModels(roundArch3MiddleSouth)
                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.WEST).setModels(roundArch3MiddleWest)
                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.NORTH).setModels(roundArch3MiddleNorth)
                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.EAST).setModels(roundArch3MiddleEast);

    }

    public void segmentalArch(Block b, String texture) {
        ResourceLocation particle = prefix("block/" + texture);
        ResourceLocation keystones = prefix("block/" + texture);
        ResourceLocation keystones1 = prefix("block/" + texture);
        ResourceLocation keystones2 = prefix("block/" + texture);
        ResourceLocation underside1 = prefix("block/" + texture);
        ResourceLocation underside2 = prefix("block/" + texture);
        ResourceLocation underside3 = prefix("block/" + texture);

        ConfiguredModel roundArch1South = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_segmental_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch1West = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_segmental_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).rotationY(180).buildLast();
        ConfiguredModel roundArch1North = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_segmental_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch1East = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_segmental_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).buildLast();

        ConfiguredModel roundArch2South = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_segmental_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
                .ao(true)
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch2West = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_segmental_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).buildLast();
        ConfiguredModel roundArch2North = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_segmental_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch2East = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_segmental_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(180).buildLast();

        ConfiguredModel roundArch3South = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_segmental_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch3West = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_segmental_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).buildLast();
        ConfiguredModel roundArch3North = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_segmental_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch3East = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_segmental_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(180).buildLast();

        ConfiguredModel roundArch3MiddleSouth = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_segmental_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch3MiddleWest = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_segmental_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).buildLast();
        ConfiguredModel roundArch3MiddleNorth = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_segmental_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch3MiddleEast = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_segmental_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(180).buildLast();

        getVariantBuilder(b)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.SOUTH).setModels(roundArch1South)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.WEST).setModels(roundArch1West)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.NORTH).setModels(roundArch1North)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.EAST).setModels(roundArch1East)

                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.SOUTH).setModels(roundArch2South)
                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.WEST).setModels(roundArch2West)
                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.NORTH).setModels(roundArch2North)
                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.EAST).setModels(roundArch2East)

                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.SOUTH).setModels(roundArch3South)
                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.WEST).setModels(roundArch3West)
                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.NORTH).setModels(roundArch3North)
                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.EAST).setModels(roundArch3East)

                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.SOUTH).setModels(roundArch3MiddleSouth)
                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.WEST).setModels(roundArch3MiddleWest)
                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.NORTH).setModels(roundArch3MiddleNorth)
                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.EAST).setModels(roundArch3MiddleEast);

    }

    public void gothicArch(Block b, String texture) {
        ResourceLocation particle = prefix("block/" + texture);
        ResourceLocation keystones = prefix("block/" + texture);
        ResourceLocation keystones1 = prefix("block/" + texture);
        ResourceLocation keystones2 = prefix("block/" + texture);
        ResourceLocation underside1 = prefix("block/" + texture);
        ResourceLocation underside2 = prefix("block/" + texture);
        ResourceLocation underside3 = prefix("block/" + texture);

        ConfiguredModel roundArch1South = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_gothic_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch1West = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_gothic_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).rotationY(180).buildLast();
        ConfiguredModel roundArch1North = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_gothic_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch1East = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/smooth_gothic_arch_1"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .guiLight(BlockModel.GuiLight.SIDE).transforms()
                .transform(ItemDisplayContext.GUI).rotation(30f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.4f, 0.4f, 0.4f).end()
                .transform(ItemDisplayContext.GROUND).rotation(0f, 0f, 0f ).translation(0f, 3f, 0f)
                .scale(0.25f, 0.25f, 0.25f).end()
                .transform(ItemDisplayContext.FIXED).rotation(0f, 0f, 0f ).translation(0f, 0f, 0f)
                .scale(0.5f, 0.5f, 0.5f).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75f, 45f, 0f ).translation(0f, 2.5f, 0f)
                .scale(0.375f, 0.375f, 0.375f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0f, 45f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0f, 225f, 0f ).translation(0f, 0f, 0f)
                .scale(0.40f, 0.40f, 0.40f).end().end()
        ).buildLast();

        ConfiguredModel roundArch2South = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_gothic_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
                .ao(true)
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch2West = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_gothic_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).buildLast();
        ConfiguredModel roundArch2North = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_gothic_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch2East = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/smooth_gothic_arch_2"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(180).buildLast();

        ConfiguredModel roundArch3South = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_gothic_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch3West = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_gothic_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).buildLast();
        ConfiguredModel roundArch3North = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_gothic_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch3East = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3",
                        prefix("block/template/smooth_gothic_arch_3"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(180).buildLast();

        ConfiguredModel roundArch3MiddleSouth = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_gothic_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(270).buildLast();
        ConfiguredModel roundArch3MiddleWest = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_gothic_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).buildLast();
        ConfiguredModel roundArch3MiddleNorth = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_gothic_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(90).buildLast();
        ConfiguredModel roundArch3MiddleEast = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        prefix("block/template/smooth_gothic_arch_3_middle"))
                .texture("particle", particle)
                .texture("keystones", keystones)
                .texture("keystones1", keystones1)
                .texture("keystones2", keystones2)
                .texture("underside1", underside1)
                .texture("underside2", underside2)
                .texture("underside3", underside3)
        ).rotationY(180).buildLast();

        getVariantBuilder(b)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.SOUTH).setModels(roundArch1South)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.WEST).setModels(roundArch1West)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.NORTH).setModels(roundArch1North)
                .partialState().with(Arch.FORM, ArchShape.ONE).with(Arch.FACING, Direction.EAST).setModels(roundArch1East)

                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.SOUTH).setModels(roundArch2South)
                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.WEST).setModels(roundArch2West)
                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.NORTH).setModels(roundArch2North)
                .partialState().with(Arch.FORM, ArchShape.TWO).with(Arch.FACING, Direction.EAST).setModels(roundArch2East)

                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.SOUTH).setModels(roundArch3South)
                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.WEST).setModels(roundArch3West)
                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.NORTH).setModels(roundArch3North)
                .partialState().with(Arch.FORM, ArchShape.THREE).with(Arch.FACING, Direction.EAST).setModels(roundArch3East)

                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.SOUTH).setModels(roundArch3MiddleSouth)
                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.WEST).setModels(roundArch3MiddleWest)
                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.NORTH).setModels(roundArch3MiddleNorth)
                .partialState().with(Arch.FORM, ArchShape.THREE_MIDDLE).with(Arch.FACING, Direction.EAST).setModels(roundArch3MiddleEast);

    }

    public void smallArch(Block b, String texture){
        ResourceLocation particle = prefix("block/" + texture);
        ResourceLocation tex = prefix("block/" + texture);
        ResourceLocation top = prefix("block/" + texture);

        ConfiguredModel eastWest = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b), "block/arch_small_parent")
                .texture("particle", particle)
                .texture("texture", tex)
                .texture("top", top)
        ).rotationY(90).buildLast();

        ConfiguredModel northSouth = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b), "block/arch_small_parent")
                .texture("particle", particle)
                .texture("texture", tex)
                .texture("top", top)
        ).buildLast();

        getVariantBuilder(b)
                .partialState().with(ArchSmall.DIRECTION, BidirectionalShape.EAST_WEST).setModels(eastWest)
                .partialState().with(ArchSmall.DIRECTION, BidirectionalShape.NORTH_SOUTH).setModels(northSouth);
    }

    public void twoMeterArch(Block b, String texture){
        ResourceLocation side = prefix("block/" + texture);

        ConfiguredModel bottomSouth = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b), "block/arch_twometer_shape")
                .texture("side", side)
        ).rotationY(180).rotationX(180).uvLock(true).buildLast();

        ConfiguredModel bottomWest = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b), "block/arch_twometer_shape")
                .texture("side", side)
        ).rotationY(270).rotationX(180).uvLock(true).buildLast();

        ConfiguredModel bottomNorth = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b), "block/arch_twometer_shape")
                .texture("side", side)
        ).rotationX(180).uvLock(true).buildLast();

        ConfiguredModel bottomEast = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b), "block/arch_twometer_shape")
                .texture("side", side)
        ).rotationY(90).rotationX(180).uvLock(true).buildLast();

        ConfiguredModel topSouth = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b), "block/arch_twometer_shape")
                .texture("side", side)
        ).uvLock(true).buildLast();

        ConfiguredModel topWest = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b), "block/arch_twometer_shape")
                .texture("side", side)
        ).rotationY(90).uvLock(true).buildLast();

        ConfiguredModel topNorth = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b), "block/arch_twometer_shape")
                .texture("side", side)
        ).rotationY(180).uvLock(true).buildLast();

        ConfiguredModel topEast = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b), "block/arch_twometer_shape")
                .texture("side", side)
        ).rotationY(270).uvLock(true).buildLast();

        getVariantBuilder(b)
                .partialState().with(ArchTwoMeter.TYPE_UPDOWN, Half.BOTTOM).with(ArchTwoMeter.DIRECTION, Direction.SOUTH).setModels(bottomSouth)
                .partialState().with(ArchTwoMeter.TYPE_UPDOWN, Half.BOTTOM).with(ArchTwoMeter.DIRECTION, Direction.WEST).setModels(bottomWest)
                .partialState().with(ArchTwoMeter.TYPE_UPDOWN, Half.BOTTOM).with(ArchTwoMeter.DIRECTION, Direction.NORTH).setModels(bottomNorth)
                .partialState().with(ArchTwoMeter.TYPE_UPDOWN, Half.BOTTOM).with(ArchTwoMeter.DIRECTION, Direction.EAST).setModels(bottomEast)

                .partialState().with(ArchTwoMeter.TYPE_UPDOWN, Half.TOP).with(ArchTwoMeter.DIRECTION, Direction.SOUTH).setModels(topSouth)
                .partialState().with(ArchTwoMeter.TYPE_UPDOWN, Half.TOP).with(ArchTwoMeter.DIRECTION, Direction.WEST).setModels(topWest)
                .partialState().with(ArchTwoMeter.TYPE_UPDOWN, Half.TOP).with(ArchTwoMeter.DIRECTION, Direction.NORTH).setModels(topNorth)
                .partialState().with(ArchTwoMeter.TYPE_UPDOWN, Half.TOP).with(ArchTwoMeter.DIRECTION, Direction.EAST).setModels(topEast);
    }

    public void reeds(Block b) {
        ResourceLocation one = prefix("block/" + name(b) + "_1");
        ResourceLocation two_top = prefix("block/" + name(b) + "_2_top");
        ResourceLocation two_top_water = prefix("block/" + name(b) + "_2_top_waterlogged");
        ResourceLocation two_bottom = prefix("block/" + name(b) + "_2_bottom");
        ResourceLocation three_top = prefix("block/" + name(b) + "_3_top");
        ResourceLocation three_middle = prefix("block/" + name(b) + "_3_middle");
        ResourceLocation three_bottom = prefix("block/" + name(b) + "_3_bottom");

        ConfiguredModel reeds_1 = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        suffix("block/cross"))
                .texture("cross", one).renderType("cutout")).buildLast();

        ConfiguredModel reeds_2_top = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2_top",
                        suffix("block/cross"))
                .texture("cross", two_top).renderType("cutout")).buildLast();

        ConfiguredModel reeds_2_top_waterlogged = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2_top_waterlogged",
                        suffix("block/cross"))
                .texture("cross", two_top_water).renderType("cutout")).buildLast();

        ConfiguredModel reeds_2_bottom = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2_bottom",
                        suffix("block/cross"))
                .texture("cross", two_bottom).renderType("cutout")).buildLast();

        ConfiguredModel reeds_3_top = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_top",
                        suffix("block/cross"))
                .texture("cross", three_top).renderType("cutout")).buildLast();

        ConfiguredModel reeds_3_middle = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_middle",
                        suffix("block/cross"))
                .texture("cross", three_middle).renderType("cutout")).buildLast();

        ConfiguredModel reeds_3_bottom = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_3_bottom",
                        suffix("block/cross"))
                .texture("cross", three_bottom).renderType("cutout")).buildLast();

        getVariantBuilder(b)
                .partialState().with(ReedsBlock.REEDS_TYPE, ReedsBlock.Type.ONE).setModels(reeds_1)
                .partialState().with(ReedsBlock.REEDS_TYPE, ReedsBlock.Type.TWO_TOP).with(ReedsBlock.WATERLOGGED, false).setModels(reeds_2_top)
                .partialState().with(ReedsBlock.REEDS_TYPE, ReedsBlock.Type.TWO_TOP).with(ReedsBlock.WATERLOGGED, true).setModels(reeds_2_top_waterlogged)
                .partialState().with(ReedsBlock.REEDS_TYPE, ReedsBlock.Type.TWO_BOTTOM).setModels(reeds_2_bottom)
                .partialState().with(ReedsBlock.REEDS_TYPE, ReedsBlock.Type.THREE_TOP).setModels(reeds_3_top)
                .partialState().with(ReedsBlock.REEDS_TYPE, ReedsBlock.Type.THREE_MIDDLE).setModels(reeds_3_middle)
                .partialState().with(ReedsBlock.REEDS_TYPE, ReedsBlock.Type.THREE_BOTTOM).setModels(reeds_3_bottom);
    }

    public void verticalCorner(Block b, String texture) {
        ResourceLocation tex = prefix("block/" + texture);

        ConfiguredModel corner_1_south = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/template_vertical_corner_1"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(180).uvLock(true).buildLast();
        ConfiguredModel corner_1_west = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/template_vertical_corner_1"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(270).uvLock(true).buildLast();
        ConfiguredModel corner_1_north = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/template_vertical_corner_1"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).uvLock(true).buildLast();
        ConfiguredModel corner_1_east = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_1",
                        prefix("block/template/template_vertical_corner_1"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(90).uvLock(true).buildLast();

        ConfiguredModel corner_2_south = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/template_vertical_corner_2"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(180).uvLock(true).buildLast();
        ConfiguredModel corner_2_west = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/template_vertical_corner_2"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(270).uvLock(true).buildLast();
        ConfiguredModel corner_2_north = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/template_vertical_corner_2"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).uvLock(true).buildLast();
        ConfiguredModel corner_2_east = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_2",
                        prefix("block/template/template_vertical_corner_2"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(90).uvLock(true).buildLast();

        ConfiguredModel corner_4_south = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_4",
                        prefix("block/template/template_vertical_corner_4"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(180).uvLock(true).buildLast();
        ConfiguredModel corner_4_west = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_4",
                        prefix("block/template/template_vertical_corner_4"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(270).uvLock(true).buildLast();
        ConfiguredModel corner_4_north = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_4",
                        prefix("block/template/template_vertical_corner_4"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).uvLock(true).buildLast();
        ConfiguredModel corner_4_east = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_4",
                        prefix("block/template/template_vertical_corner_4"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(90).uvLock(true).buildLast();

        ConfiguredModel corner_6_south = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_6",
                        prefix("block/template/template_vertical_corner_6"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(180).uvLock(true).buildLast();
        ConfiguredModel corner_6_west = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_6",
                        prefix("block/template/template_vertical_corner_6"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(270).uvLock(true).buildLast();
        ConfiguredModel corner_6_north = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_6",
                        prefix("block/template/template_vertical_corner_6"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).uvLock(true).buildLast();
        ConfiguredModel corner_6_east = ConfiguredModel.builder().modelFile(models().withExistingParent(name(b)+ "_6",
                        prefix("block/template/template_vertical_corner_6"))
                .texture("north", tex)
                .texture("south", tex)
                .texture("east", tex)
                .texture("west", tex)
                .texture("top", tex)
                .texture("bottom", tex)
                .texture("particle", tex)
        ).rotationY(90).uvLock(true).buildLast();

        getVariantBuilder(b)
                .partialState().with(VerticalCorner.LAYERS, 1).with(VerticalCorner.DIRECTION, Direction.SOUTH).setModels(corner_1_south)
                .partialState().with(VerticalCorner.LAYERS, 1).with(VerticalCorner.DIRECTION, Direction.WEST).setModels(corner_1_west)
                .partialState().with(VerticalCorner.LAYERS, 1).with(VerticalCorner.DIRECTION, Direction.NORTH).setModels(corner_1_north)
                .partialState().with(VerticalCorner.LAYERS, 1).with(VerticalCorner.DIRECTION, Direction.EAST).setModels(corner_1_east)

                .partialState().with(VerticalCorner.LAYERS, 2).with(VerticalCorner.DIRECTION, Direction.SOUTH).setModels(corner_2_south)
                .partialState().with(VerticalCorner.LAYERS, 2).with(VerticalCorner.DIRECTION, Direction.WEST).setModels(corner_2_west)
                .partialState().with(VerticalCorner.LAYERS, 2).with(VerticalCorner.DIRECTION, Direction.NORTH).setModels(corner_2_north)
                .partialState().with(VerticalCorner.LAYERS, 2).with(VerticalCorner.DIRECTION, Direction.EAST).setModels(corner_2_east)

                .partialState().with(VerticalCorner.LAYERS, 3).with(VerticalCorner.DIRECTION, Direction.SOUTH).setModels(corner_4_south)
                .partialState().with(VerticalCorner.LAYERS, 3).with(VerticalCorner.DIRECTION, Direction.WEST).setModels(corner_4_west)
                .partialState().with(VerticalCorner.LAYERS, 3).with(VerticalCorner.DIRECTION, Direction.NORTH).setModels(corner_4_north)
                .partialState().with(VerticalCorner.LAYERS, 3).with(VerticalCorner.DIRECTION, Direction.EAST).setModels(corner_4_east)

                .partialState().with(VerticalCorner.LAYERS, 4).with(VerticalCorner.DIRECTION, Direction.SOUTH).setModels(corner_6_south)
                .partialState().with(VerticalCorner.LAYERS, 4).with(VerticalCorner.DIRECTION, Direction.WEST).setModels(corner_6_west)
                .partialState().with(VerticalCorner.LAYERS, 4).with(VerticalCorner.DIRECTION, Direction.NORTH).setModels(corner_6_north)
                .partialState().with(VerticalCorner.LAYERS, 4).with(VerticalCorner.DIRECTION, Direction.EAST).setModels(corner_6_east)
        ;

    }
    protected ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    protected String name(Block block) {
        return key(block).getPath();
    }
}
