package com.legends.edumia.datagen;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;


import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator  extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Edumia.MODID, existingFileHelper);
    }
    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockLoader.BROWN_STONE.get())
                .add(BlockLoader.BROWN_STONE_STAIRS.get())
                .add(BlockLoader.BROWN_STONE_SLAB.get())
                .add(BlockLoader.BROWN_STONE_WALL.get())

                .add(BlockLoader.LIGHT_GRAY_STONE.get())
                .add(BlockLoader.LIGHT_GRAY_STONE_STAIRS.get())
                .add(BlockLoader.LIGHT_GRAY_STONE_SLAB.get())
                .add(BlockLoader.LIGHT_GRAY_STONE_WALL.get())

                .add(BlockLoader.LIGHT_GRAY_STONE_BRICKS.get())
                .add(BlockLoader.LIGHT_GRAY_STONE_BRICKS_STAIRS.get())
                .add(BlockLoader.LIGHT_GRAY_STONE_BRICKS_SLAB.get())
                .add(BlockLoader.LIGHT_GRAY_STONE_BRICKS_WALL.get())

                .add(BlockLoader.BLUE_STONE.get())
                .add(BlockLoader.BLUE_STONE_STAIRS.get())
                .add(BlockLoader.BLUE_STONE_SLAB.get())
                .add(BlockLoader.BLUE_STONE_WALL.get())

                .add(BlockLoader.BLUE_BRICK.get())
                .add(BlockLoader.BLUE_BRICK_STAIRS.get())
                .add(BlockLoader.BLUE_BRICK_SLAB.get())
                .add(BlockLoader.BLUE_BRICK_WALL.get())

                .add(BlockLoader.YELLOW_STONE.get())
                .add(BlockLoader.YELLOW_STONE_STAIRS.get())
                .add(BlockLoader.YELLOW_STONE_SLAB.get())
                .add(BlockLoader.YELLOW_STONE_WALL.get())

                .add(BlockLoader.YELLOW_STONE_2.get())
                .add(BlockLoader.YELLOW_STONE_2_STAIRS.get())
                .add(BlockLoader.YELLOW_STONE_2_SLAB.get())
                .add(BlockLoader.YELLOW_STONE_2_WALL.get())

                .add(BlockLoader.YELLOW_STONE_BRICKS.get())
                .add(BlockLoader.YELLOW_STONE_BRICKS_STAIRS.get())
                .add(BlockLoader.YELLOW_STONE_BRICKS_SLAB.get())
                .add(BlockLoader.YELLOW_STONE_BRICKS_WALL.get())

                .add(BlockLoader.YELLOW_STONE_BRICKS_2.get())
                .add(BlockLoader.YELLOW_STONE_BRICKS_2_STAIRS.get())
                .add(BlockLoader.YELLOW_STONE_BRICKS_2_SLAB.get())
                .add(BlockLoader.YELLOW_STONE_BRICKS_2_WALL.get())

                .add(BlockLoader.BASALT_BRICKS.get())
                .add(BlockLoader.BASALT_BRICKS_STAIRS.get())
                .add(BlockLoader.BASALT_BRICKS_SLAB.get())
                .add(BlockLoader.BASALT_BRICKS_WALL.get())

                .add(BlockLoader.GREEN_BASALT.get())
                .add(BlockLoader.GREEN_BASALT_STAIRS.get())
                .add(BlockLoader.GREEN_BASALT_SLAB.get())
                .add(BlockLoader.GREEN_BASALT_WALL.get())

                .add(BlockLoader.GREEN_BASALT_BRICKS.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_STAIRS.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_SLAB.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_WALL.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_SMALL_ARCH.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_TWO_METER_ARCH.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_GOTHIC_ARCH.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_ROUND_ARCH.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_SEGMENTAL_ARCH.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_BALUSTRADE.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_ARROWSLIT.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_WALL.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_SMALL_PILLAR.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_PILAR.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_LARGE_PILLAR.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_PILLAR.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_WALL.get())

                .add(BlockLoader.MOSSY_BASALT_BRICKS.get())
                .add(BlockLoader.MOSSY_BASALT_BRICKS_STAIRS.get())
                .add(BlockLoader.MOSSY_BASALT_BRICKS_SLAB.get())
                .add(BlockLoader.MOSSY_BASALT_BRICKS_WALL.get())

                .add(BlockLoader.CHISELED_BASALT.get())

                .add(BlockLoader.CRACKED_GREEN_BASALT.get())
                .add(BlockLoader.CRACKED_GREEN_BASALT_STAIRS.get())
                .add(BlockLoader.CRACKED_GREEN_BASALT_SLAB.get())
                .add(BlockLoader.CRACKED_GREEN_BASALT_WALL.get())

                .add(BlockLoader.GREEN_BASALT_COBBLESTONE.get())
                .add(BlockLoader.GREEN_BASALT_COBBLESTONE_STAIRS.get())
                .add(BlockLoader.GREEN_BASALT_COBBLESTONE_SLAB.get())
                .add(BlockLoader.GREEN_BASALT_COBBLESTONE_WALL.get())

                .add(BlockLoader.GNEISS.get())
                .add(BlockLoader.GNEISS_STAIRS.get())
                .add(BlockLoader.GNEISS_SLAB.get())
                .add(BlockLoader.GNEISS_WALL.get())

                .add(BlockLoader.LIMESTONE.get())
                .add(BlockLoader.LIMESTONE_STAIRS.get())
                .add(BlockLoader.LIMESTONE_SLAB.get())
                .add(BlockLoader.LIMESTONE_WALL.get())

                .add(BlockLoader.CYAN_STONE.get())
                .add(BlockLoader.CYAN_STONE_STAIRS.get())
                .add(BlockLoader.CYAN_STONE_SLAB.get())
                .add(BlockLoader.CYAN_STONE_WALL.get())

                .add(BlockLoader.ORANGE_ROCK.get())
                .add(BlockLoader.ORANGE_ROCK_STAIRS.get())
                .add(BlockLoader.ORANGE_ROCK_SLAB.get())
                .add(BlockLoader.ORANGE_ROCK_WALL.get())

                .add(BlockLoader.RED_ROCK.get())
                .add(BlockLoader.RED_ROCK_STAIRS.get())
                .add(BlockLoader.RED_ROCK_SLAB.get())
                .add(BlockLoader.RED_ROCK_WALL.get())

                .add(BlockLoader.YELLOW_COBBLE.get())
                .add(BlockLoader.YELLOW_COBBLE_STAIRS.get())
                .add(BlockLoader.YELLOW_COBBLE_SLAB.get())
                .add(BlockLoader.YELLOW_COBBLE_WALL.get())

                .add(BlockLoader.HIGH_ELVEN_BRICKS.get())
                .add(BlockLoader.HIGH_ELVEN_BRICKS_STAIRS.get())
                .add(BlockLoader.HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.HIGH_ELVEN_BRICKS_SLAB.get())

                .add(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS.get())
                .add(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_STAIRS.get())
                .add(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_SLAB.get())

                .add(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS.get())
                .add(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_STAIRS.get())
                .add(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_SLAB.get())

                .add(BlockLoader.CHISELED_HIGH_ELVEN_BRICKS.get())

                .add(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS.get())
                .add(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get())
                .add(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_SLAB.get())

                .add(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS.get())
                .add(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get())
                .add(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_SLAB.get())

                .add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS.get())
                .add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get())
                .add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_SLAB.get())

                .add(BlockLoader.CHISELED_LIGHT_HIGH_ELVEN_BRICKS.get())

                .add(BlockLoader.DARK_HIGH_ELVEN_BRICKS.get())
                .add(BlockLoader.DARK_HIGH_ELVEN_BRICKS_STAIRS.get())
                .add(BlockLoader.DARK_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.DARK_HIGH_ELVEN_BRICKS_SLAB.get())

                .add(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS.get())
                .add(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_STAIRS.get())
                .add(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_SLAB.get())

                .add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS.get())
                .add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_STAIRS.get())
                .add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_SLAB.get())

                .add(BlockLoader.CHISELED_DARK_HIGH_ELVEN_BRICKS.get())

                .add(BlockLoader.MARBLE_PINK.get())

                .add(BlockLoader.TOPAZ_ORE.get())
                .add(BlockLoader.ORE_VEIL.get())

                .add(BlockLoader.ALEXANDRITE_BLOCK.get())
                .add(BlockLoader.ALEXANDRITE_ORE.get())
                .add(BlockLoader.RAW_ALEXANDRITE_BLOCK.get())
                .add(BlockLoader.CHALK.get())
                .add(BlockLoader.HIGH_ELVEN_ROCK.get())
                .add(BlockLoader.DARK_HIGH_ELVEN_ROCK.get())
                .add(BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get());


        this.tag(BlockTags.MINEABLE_WITH_AXE)
                /*.add(BlockLoader.APPLE_PLANKS.get())
                .add(BlockLoader.APPLE_PLANKS_SLAB.get())
                .add(BlockLoader.APPLE_PLANKS_STAIRS.get())
                .add(BlockLoader.APPLE_FENCE.get())
                .add(BlockLoader.APPLE_FENCE_GATE.get())

                .add(BlockLoader.BAOBAB_PLANKS.get())
                .add(BlockLoader.BAOBAB_PLANKS_SLAB.get())
                .add(BlockLoader.BAOBAB_PLANKS_STAIRS.get())
                .add(BlockLoader.BAOBAB_FENCE.get())
                .add(BlockLoader.BAOBAB_FENCE_GATE.get())

                .add(BlockLoader.CYPRESS_PLANKS.get())
                .add(BlockLoader.CYPRESS_PLANKS_SLAB.get())
                .add(BlockLoader.CYPRESS_PLANKS_STAIRS.get())
                .add(BlockLoader.CYPRESS_FENCE.get())
                .add(BlockLoader.CYPRESS_FENCE_GATE.get())

                .add(BlockLoader.HOLLY_PLANKS.get())
                .add(BlockLoader.HOLLY_PLANKS_SLAB.get())
                .add(BlockLoader.HOLLY_PLANKS_STAIRS.get())
                .add(BlockLoader.HOLLY_FENCE.get())
                .add(BlockLoader.HOLLY_FENCE_GATE.get())

                .add(BlockLoader.OKOME_PLANKS.get())
                .add(BlockLoader.OKOME_PLANKS_SLAB.get())
                .add(BlockLoader.OKOME_PLANKS_STAIRS.get())
                .add(BlockLoader.OKOME_FENCE.get())
                .add(BlockLoader.OKOME_FENCE_GATE.get())

                .add(BlockLoader.PEAR_PLANKS.get())
                .add(BlockLoader.PEAR_PLANKS_SLAB.get())
                .add(BlockLoader.PEAR_PLANKS_STAIRS.get())
                .add(BlockLoader.PEAR_FENCE.get())
                .add(BlockLoader.PEAR_FENCE_GATE.get())

                .add(BlockLoader.PINE_PLANKS.get())
                .add(BlockLoader.PINE_PLANKS_SLAB.get())
                .add(BlockLoader.PINE_PLANKS_STAIRS.get())
                .add(BlockLoader.PINE_FENCE.get())
                .add(BlockLoader.PINE_FENCE_GATE.get())

                .add(BlockLoader.PLUM_PLANKS.get())
                .add(BlockLoader.PLUM_PLANKS_SLAB.get())
                .add(BlockLoader.PLUM_PLANKS_STAIRS.get())
                .add(BlockLoader.PLUM_FENCE.get())
                .add(BlockLoader.PLUM_FENCE_GATE.get())*/;


        this.tag(BlockTags.NEEDS_STONE_TOOL)
        ;

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockLoader.TOPAZ_ORE.get())

                .add(BlockLoader.ALEXANDRITE_BLOCK.get())
                .add(BlockLoader.ALEXANDRITE_ORE.get())
                .add(BlockLoader.RAW_ALEXANDRITE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockLoader.ORE_VEIL.get());

        this.tag(BlockTags.WALLS)
                .add(BlockLoader.BROWN_STONE_WALL.get())
                .add(BlockLoader.LIGHT_GRAY_STONE_WALL.get())
                .add(BlockLoader.LIGHT_GRAY_STONE_BRICKS_WALL.get())
                .add(BlockLoader.BLUE_STONE_WALL.get())
                .add(BlockLoader.BLUE_BRICK_WALL.get())
                .add(BlockLoader.YELLOW_STONE_WALL.get())
                .add(BlockLoader.YELLOW_STONE_2_WALL.get())
                .add(BlockLoader.YELLOW_STONE_BRICKS_WALL.get())
                .add(BlockLoader.YELLOW_STONE_BRICKS_2_WALL.get())
                .add(BlockLoader.BASALT_BRICKS_WALL.get())
                .add(BlockLoader.GREEN_BASALT_WALL.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_WALL.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_WALL.get())
                .add(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_WALL.get())
                .add(BlockLoader.MOSSY_BASALT_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_GREEN_BASALT_WALL.get())
                .add(BlockLoader.GREEN_BASALT_COBBLESTONE_WALL.get())
                .add(BlockLoader.GNEISS_WALL.get())
                .add(BlockLoader.LIMESTONE_WALL.get())
                .add(BlockLoader.CYAN_STONE_WALL.get())
                .add(BlockLoader.ORANGE_ROCK_WALL.get())
                .add(BlockLoader.RED_ROCK_WALL.get())
                .add(BlockLoader.YELLOW_COBBLE_WALL.get())
                .add(BlockLoader.HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.DARK_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_WALL.get())
                .add(BlockLoader.CHALK_BRICKS_WALL.get())
                .add(BlockLoader.BROWN_SANDSTONE_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_CACHOLONG_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_CACHOLONG_BRICKS_WALL.get())
                .add(BlockLoader.CACHOLONG_BRICKS_WALL.get())
                .add(BlockLoader.BLACK_DEMON_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_WALL.get())
                .add(BlockLoader.BLUE_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_BLUE_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_BLUE_BRICKS_WALL.get())
                .add(BlockLoader.DEMON_BASALT_BRICKS_WALL.get())
                .add(BlockLoader.VULCANIC_DEMON_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_WALL.get())
                .add(BlockLoader.RED_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_RED_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_RED_BRICKS_WALL.get())
                .add(BlockLoader.DESERT_MUD_BRICKS_WALL.get())
                .add(BlockLoader.CRACKED_DESERT_MUD_BRICKS_WALL.get())
                .add(BlockLoader.MOSSY_DESERT_MUD_BRICKS_WALL.get())
                .add(BlockLoader.CHALK_WALL.get())
                .add(BlockLoader.HIGH_ELVEN_ROCK_WALL.get())
                .add(BlockLoader.DARK_HIGH_ELVEN_ROCK_WALL.get())
                .add(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_WALL.get())
                .add(BlockLoader.HIGH_ELVEN_COBBLESTONE_WALL.get())
                .add(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_WALL.get())
                .add(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_WALL.get())
                .add(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_WALL.get())
                .add(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_WALL.get())
                .add(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_WALL.get())
        ;

        this.tag(BlockTags.FENCES)
                .add(BlockLoader.APPLE_FENCE.get())
                .add(BlockLoader.BAOBAB_FENCE.get())
                .add(BlockLoader.CYPRESS_FENCE.get())
                .add(BlockLoader.HOLLY_FENCE.get())
                .add(BlockLoader.OKOME_FENCE.get())
                .add(BlockLoader.PEAR_FENCE.get())
                .add(BlockLoader.PINE_FENCE.get())
                .add(BlockLoader.PLUM_FENCE.get());

        this.tag(BlockTags.LEAVES)
                .add(BlockLoader.APPLE_LEAVES.get())
                .add(BlockLoader.ASPEN_LEAVES.get())
                .add(BlockLoader.BEECH_LEAVES.get())
                .add(BlockLoader.CEDAR_LEAVES.get())
                .add(BlockLoader.CHERRY_LEAVES.get())
                .add(BlockLoader.CYPRESS_LEAVES.get())
                .add(BlockLoader.FIR_LEAVES.get())
                .add(BlockLoader.GREEN_OAK_LEAVES.get())
                .add(BlockLoader.HOLLY_LEAVES.get())
                .add(BlockLoader.LARCH_LEAVES.get())
                .add(BlockLoader.MAPLE_LEAVES.get())
                .add(BlockLoader.PEAR_LEAVES.get())
                .add(BlockLoader.PINE_LEAVES.get())
                .add(BlockLoader.RED_OAK_LEAVES.get())
                .add(BlockLoader.BLACKTHORN_LEAVES.get())
                .add(BlockLoader.GHOST_GUM_LEAVES.get())
                .add(BlockLoader.WHITE_ASH_LEAVES.get())
                .add(BlockLoader.SILVER_SPRUCE_LEAVES.get())
        ;

        this.tag(BlockTags.LOGS)
                .add(BlockLoader.APPLE_LOG.get())
                .add(BlockLoader.APPLE_WOOD.get())
                .add(BlockLoader.ASPEN_LOG.get())
                .add(BlockLoader.ASPEN_WOOD.get())
                .add(BlockLoader.BEECH_LOG.get())
                .add(BlockLoader.BEECH_WOOD.get())
                .add(BlockLoader.CEDAR_LOG.get())
                .add(BlockLoader.CEDAR_WOOD.get())
                .add(BlockLoader.CHERRY_LOG.get())
                .add(BlockLoader.CHERRY_WOOD.get())
                .add(BlockLoader.CYPRESS_LOG.get())
                .add(BlockLoader.CYPRESS_WOOD.get())
                .add(BlockLoader.FIR_LOG.get())
                .add(BlockLoader.FIR_WOOD.get())
                .add(BlockLoader.GREEN_OAK_LOG.get())
                .add(BlockLoader.GREEN_OAK_WOOD.get())
                .add(BlockLoader.HOLLY_LOG.get())
                .add(BlockLoader.HOLLY_WOOD.get())
                .add(BlockLoader.LARCH_LOG.get())
                .add(BlockLoader.LARCH_WOOD.get())
                .add(BlockLoader.MAPLE_LOG.get())
                .add(BlockLoader.MAPLE_WOOD.get())
                .add(BlockLoader.PEAR_LOG.get())
                .add(BlockLoader.PEAR_WOOD.get())
                .add(BlockLoader.PINE_LOG.get())
                .add(BlockLoader.PINE_WOOD.get())
                .add(BlockLoader.RED_OAK_LOG.get())
                .add(BlockLoader.RED_OAK_WOOD.get())
                .add(BlockLoader.BLACKTHORN_LOG.get())
                .add(BlockLoader.BLACKTHORN_WOOD.get())
                .add(BlockLoader.GHOST_GUM_LOG.get())
                .add(BlockLoader.GHOST_GUM_WOOD.get())
                .add(BlockLoader.WHITE_ASH_LOG.get())
                .add(BlockLoader.WHITE_ASH_WOOD.get())
                .add(BlockLoader.SILVER_SPRUCE_LOG.get())
                .add(BlockLoader.SILVER_SPRUCE_WOOD.get())
        ;

        this.tag(ModTags.Blocks.SOIL_AND_GRAVEL)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.DIRT)
                .add(Blocks.COARSE_DIRT)
                .add(Blocks.GRAVEL);

        this.tag(ModTags.Blocks.STONE_DIORITE)
                .add(Blocks.STONE)
                .add(Blocks.DIORITE);

        this.tag(ModTags.Blocks.STONE_ONLY)
                .add(Blocks.STONE);

        this.tag(ModTags.Blocks.CALCITE)
                .add(Blocks.CALCITE);

        this.tag(ModTags.Blocks.SOIL_STONE)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.DIRT)
                .add(Blocks.COARSE_DIRT)
                .addTags(BlockTags.BASE_STONE_OVERWORLD);

        this.tag(ModTags.Blocks.BANISTERS)
                .add(BlockLoader.REDWOOD_BANISTER.get());

        this.tag(ModTags.Blocks.PILLARS)
                .add(BlockLoader.BRICK_PILLAR.get())
                .add(BlockLoader.STONE_PILLAR.get())
                .add(BlockLoader.CHALK_PILLAR.get())
                .add(BlockLoader.RED_PILLAR.get())
                .add(BlockLoader.CACHOLONG_PILLAR.get())
                .add(BlockLoader.HIGH_ELVEN_PILLAR.get())
                .add(BlockLoader.LIGHT_HIGH_ELVEN_PILLAR.get())
                .add(BlockLoader.DARK_HIGH_ELVEN_PILLAR.get());


        this.tag(ModTags.Blocks.REEDS_PLACEABLE_ON)
                .add(Blocks.GRASS)
                .addTags(BlockTags.DIRT)
                .addTags(BlockTags.SAND);

    }
}
