package com.legends.edumia.datagen;

import com.legends.edumia.Edumia;
import com.legends.edumia.core.BlockLoader;
import com.legends.edumia.core.ItemLoader;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> recipeConsumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.BROWN_STONE_STAIRS.get(), 4)
                .define('G', BlockLoader.BROWN_STONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_brown_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.BROWN_STONE.get()).build()))
                .save(recipeConsumer);
        

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.BROWN_STONE_SLAB.get(), 6)
                .define('G', BlockLoader.BROWN_STONE.get())
                .pattern("GGG")
                .unlockedBy("has_brown_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.BROWN_STONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.BROWN_STONE_WALL.get(), 6)
                .define('G', BlockLoader.BROWN_STONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_brown_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.BROWN_STONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_GRAY_STONE_STAIRS.get(), 4)
                .define('G', BlockLoader.LIGHT_GRAY_STONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_light_gray_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_GRAY_STONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_GRAY_STONE_SLAB.get(), 6)
                .define('G', BlockLoader.LIGHT_GRAY_STONE.get())
                .pattern("GGG")
                .unlockedBy("has_light_gray_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_GRAY_STONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_GRAY_STONE_WALL.get(), 6)
                .define('G', BlockLoader.LIGHT_GRAY_STONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_light_gray_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_GRAY_STONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_GRAY_STONE_BRICKS.get(), 4)
                .define('G', BlockLoader.LIGHT_GRAY_STONE.get())
                .pattern("GG")
                .pattern("GG")
                .unlockedBy("has_light_gray_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_GRAY_STONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_GRAY_STONE_BRICKS_STAIRS.get(), 4)
                .define('G', BlockLoader.LIGHT_GRAY_STONE_BRICKS.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_light_gray_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_GRAY_STONE_BRICKS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_GRAY_STONE_BRICKS_SLAB.get(),6)
                .define('G', BlockLoader.LIGHT_GRAY_STONE_BRICKS.get())
                .pattern("GGG")
                .unlockedBy("has_light_gray_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_GRAY_STONE_BRICKS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_GRAY_STONE_BRICKS_WALL.get(),6)
                .define('G', BlockLoader.LIGHT_GRAY_STONE_BRICKS.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_light_gray_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_GRAY_STONE_BRICKS.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.BLUE_STONE_STAIRS.get(), 4)
                .define('G', BlockLoader.BLUE_STONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_blue_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.BLUE_STONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.BLUE_STONE_SLAB.get(),6)
                .define('G', BlockLoader.BLUE_STONE.get())
                .pattern("GGG")
                .unlockedBy("has_blue_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.BLUE_STONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.BLUE_STONE_WALL.get(),6)
                .define('G', BlockLoader.BLUE_STONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_blue_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.BLUE_STONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_STAIRS.get(), 4)
                .define('G', BlockLoader.YELLOW_STONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_yellow_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_SLAB.get(),6)
                .define('G', BlockLoader.YELLOW_STONE.get())
                .pattern("GGG")
                .unlockedBy("has_yellow_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_WALL.get(),6)
                .define('G', BlockLoader.YELLOW_STONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_yellow_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_BRICKS.get(),4)
                .define('G', BlockLoader.YELLOW_STONE.get())
                .pattern("GG")
                .pattern("GG")
                .unlockedBy("has_yellow_stone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_BRICKS_STAIRS.get(), 4)
                .define('G', BlockLoader.YELLOW_STONE_BRICKS.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_yellow_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE_BRICKS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_BRICKS_SLAB.get(),6)
                .define('G', BlockLoader.YELLOW_STONE_BRICKS.get())
                .pattern("GGG")
                .unlockedBy("has_yellow_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE_BRICKS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_BRICKS_WALL.get(),6)
                .define('G', BlockLoader.YELLOW_STONE_BRICKS.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_yellow_stone_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE_BRICKS.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_2_STAIRS.get(), 4)
                .define('G', BlockLoader.YELLOW_STONE_2.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_yellow_stone_2", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE_2.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_2_SLAB.get(),6)
                .define('G', BlockLoader.YELLOW_STONE_2.get())
                .pattern("GGG")
                .unlockedBy("has_yellow_stone_2", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE_2.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_2_WALL.get(),6)
                .define('G', BlockLoader.YELLOW_STONE_2.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_yellow_stone_2", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE_2.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_BRICKS_2.get(),4)
                .define('G', BlockLoader.YELLOW_STONE_2.get())
                .pattern("GG")
                .pattern("GG")
                .unlockedBy("has_yellow_stone_2", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE_2.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_BRICKS_2_STAIRS.get(), 4)
                .define('G', BlockLoader.YELLOW_STONE_BRICKS_2.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_yellow_stone_bricks_2", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE_BRICKS_2.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_BRICKS_2_SLAB.get(),6)
                .define('G', BlockLoader.YELLOW_STONE_BRICKS_2.get())
                .pattern("GGG")
                .unlockedBy("has_yellow_stone_bricks_2", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE_BRICKS_2.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.YELLOW_STONE_BRICKS_2_WALL.get(),6)
                .define('G', BlockLoader.YELLOW_STONE_BRICKS_2.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_yellow_stone_bricks_2", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.YELLOW_STONE_BRICKS_2.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.BASALT_BRICKS.get(),4)
                .define('G', BlockLoader.GREEN_BASALT_COBBLESTONE.get())
                .pattern("GG")
                .pattern("GG")
                .unlockedBy("has_green_basalt_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT_COBBLESTONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.BASALT_BRICKS_STAIRS.get(), 4)
                .define('G', BlockLoader.BASALT_BRICKS.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_basalt_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.BASALT_BRICKS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.BASALT_BRICKS_SLAB.get(),6)
                .define('G', BlockLoader.BASALT_BRICKS.get())
                .pattern("GGG")
                .unlockedBy("has_basalt_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.BASALT_BRICKS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.BASALT_BRICKS_WALL.get(),6)
                .define('G', BlockLoader.BASALT_BRICKS.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_basalt_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.BASALT_BRICKS.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GREEN_BASALT_STAIRS.get(), 4)
                .define('G', BlockLoader.GREEN_BASALT.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_green_basalt", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GREEN_BASALT_SLAB.get(),6)
                .define('G', BlockLoader.GREEN_BASALT.get())
                .pattern("GGG")
                .unlockedBy("has_green_basalt", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GREEN_BASALT_WALL.get(),6)
                .define('G', BlockLoader.GREEN_BASALT.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_green_basalt", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GREEN_BASALT_BRICKS.get(),4)
                .define('G', BlockLoader.GREEN_BASALT.get())
                .pattern("GG")
                .pattern("GG")
                .unlockedBy("has_green_basalt", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GREEN_BASALT_BRICKS_STAIRS.get(), 4)
                .define('G', BlockLoader.GREEN_BASALT_BRICKS.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_green_basalt_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT_BRICKS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GREEN_BASALT_BRICKS_SLAB.get(),6)
                .define('G', BlockLoader.GREEN_BASALT_BRICKS.get())
                .pattern("GGG")
                .unlockedBy("has_green_basalt_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT_BRICKS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GREEN_BASALT_BRICKS_WALL.get(),6)
                .define('G', BlockLoader.GREEN_BASALT_BRICKS.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_green_basalt_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT_BRICKS.get()).build()))
                .save(recipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_BASALT_BRICKS.get())
                        .requires(BlockLoader.BASALT_BRICKS.get()).requires(Blocks.VINE.asItem())
                .unlockedBy("has_basalt_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.BASALT_BRICKS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_BASALT_BRICKS_STAIRS.get(), 4)
                .define('G', BlockLoader.MOSSY_BASALT_BRICKS.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_mossy_basalt_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_BASALT_BRICKS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_BASALT_BRICKS_SLAB.get(),6)
                .define('G', BlockLoader.MOSSY_BASALT_BRICKS.get())
                .pattern("GGG")
                .unlockedBy("has_mossy_basalt_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_BASALT_BRICKS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_BASALT_BRICKS_WALL.get(),6)
                .define('G', BlockLoader.MOSSY_BASALT_BRICKS.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_mossy_basalt_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_BASALT_BRICKS.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.CRACKED_GREEN_BASALT_STAIRS.get(), 4)
                .define('G', BlockLoader.CRACKED_GREEN_BASALT.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_cracked_green_basalt", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.CRACKED_GREEN_BASALT.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.CRACKED_GREEN_BASALT_SLAB.get(),6)
                .define('G', BlockLoader.CRACKED_GREEN_BASALT.get())
                .pattern("GGG")
                .unlockedBy("has_cracked_green_basalt", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.CRACKED_GREEN_BASALT.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.CRACKED_GREEN_BASALT_WALL.get(),6)
                .define('G', BlockLoader.CRACKED_GREEN_BASALT.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_cracked_green_basalt", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.CRACKED_GREEN_BASALT.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.CHISELED_BASALT.get(),6)
                .define('G', BlockLoader.GREEN_BASALT_BRICKS.get())
                .pattern("GG")
                .pattern("GG")
                .unlockedBy("has_green_basalt_bricks", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT_BRICKS.get()).build()))
                .save(recipeConsumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GREEN_BASALT_COBBLESTONE_STAIRS.get(), 4)
                .define('G', BlockLoader.GREEN_BASALT_COBBLESTONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_green_basalt_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT_COBBLESTONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GREEN_BASALT_COBBLESTONE_SLAB.get(),6)
                .define('G', BlockLoader.GREEN_BASALT_COBBLESTONE.get())
                .pattern("GGG")
                .unlockedBy("has_green_basalt_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT_COBBLESTONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GREEN_BASALT_COBBLESTONE_WALL.get(),6)
                .define('G', BlockLoader.GREEN_BASALT_COBBLESTONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_green_basalt_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GREEN_BASALT_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GNEISS_STAIRS.get(), 4)
                .define('G', BlockLoader.GNEISS.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_gneiss", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GNEISS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GNEISS_SLAB.get(),6)
                .define('G', BlockLoader.GNEISS.get())
                .pattern("GGG")
                .unlockedBy("has_gneiss", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GNEISS.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.GNEISS_WALL.get(),6)
                .define('G', BlockLoader.GNEISS.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_gneiss", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.GNEISS.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIMESTONE_STAIRS.get(), 4)
                .define('G', BlockLoader.LIMESTONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_limestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIMESTONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIMESTONE_SLAB.get(),6)
                .define('G', BlockLoader.LIMESTONE.get())
                .pattern("GGG")
                .unlockedBy("has_limestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIMESTONE.get()).build()))
                .save(recipeConsumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIMESTONE_WALL.get(),6)
                .define('G', BlockLoader.LIMESTONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_limestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIMESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockLoader.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ItemLoader.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ItemLoader.ALEXANDRITE.get()).build()))
                .save(recipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemLoader.ALEXANDRITE.get(), 9)
                .requires(BlockLoader.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(BlockLoader.ALEXANDRITE_BLOCK.get()).build()))
                .save(recipeConsumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.HIGH_ELVEN_COBBLESTONE_STAIRS.get(), 4)
                .define('G', BlockLoader.HIGH_ELVEN_COBBLESTONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.HIGH_ELVEN_COBBLESTONE_SLAB.get(), 6)
                .define('G', BlockLoader.HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .unlockedBy("has_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.HIGH_ELVEN_COBBLESTONE_WALL.get(), 6)
                .define('G', BlockLoader.HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get())
                .requires(BlockLoader.HIGH_ELVEN_COBBLESTONE.get()).requires(Blocks.VINE).group("mossy_high_elven_cobblestone")
                .unlockedBy("has_vine", has(Blocks.VINE)).save(recipeConsumer,
                        getConversionRecipeName(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get(), Blocks.VINE));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get())
                .requires(BlockLoader.HIGH_ELVEN_COBBLESTONE.get()).requires(Blocks.MOSS_BLOCK).group("mossy_high_elven_cobblestone")
                .unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK)).save(recipeConsumer,
                        getConversionRecipeName(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get(), Blocks.MOSS_BLOCK));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_STAIRS.get(), 4)
                .define('G', BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_mossy_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_SLAB.get(), 6)
                .define('G', BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .unlockedBy("has_mossy_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_WALL.get(), 6)
                .define('G', BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_mossy_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);


        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockLoader.HIGH_ELVEN_COBBLESTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                        BlockLoader.HIGH_ELVEN_ROCK.get().asItem(), 0.1F, 200)
                .unlockedBy("has_high_elven_cobblestone", has(BlockLoader.HIGH_ELVEN_COBBLESTONE.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.HIGH_ELVEN_ROCK_STAIRS.get(), 4)
                .define('G', BlockLoader.HIGH_ELVEN_ROCK.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_high_elven_rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.HIGH_ELVEN_ROCK.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.HIGH_ELVEN_ROCK_SLAB.get(), 6)
                .define('G', BlockLoader.HIGH_ELVEN_ROCK.get())
                .pattern("GGG")
                .unlockedBy("has_high_elven_rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.HIGH_ELVEN_ROCK.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.HIGH_ELVEN_ROCK_WALL.get(), 6)
                .define('G', BlockLoader.HIGH_ELVEN_ROCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_high_elven_rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.HIGH_ELVEN_ROCK.get()).build()))
                .save(recipeConsumer);



        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_STAIRS.get(), 4)
                .define('G', BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_dark_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_SLAB.get(), 6)
                .define('G', BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .unlockedBy("has_dark_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_WALL.get(), 6)
                .define('G', BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_dark_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get())
                .requires(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get()).requires(Blocks.VINE).group("mossy_dark_high_elven_cobblestone")
                .unlockedBy("has_vine", has(Blocks.VINE)).save(recipeConsumer,
                        getConversionRecipeName(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get(), Blocks.VINE));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get())
                .requires(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get()).requires(Blocks.MOSS_BLOCK).group("mossy_dark_high_elven_cobblestone")
                .unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK)).save(recipeConsumer,
                        getConversionRecipeName(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get(), Blocks.MOSS_BLOCK));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_STAIRS.get(), 4)
                .define('G', BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_mossy_dark_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_SLAB.get(), 6)
                .define('G', BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .unlockedBy("has_mossy_dark_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_WALL.get(), 6)
                .define('G', BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_mossy_dark_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                        BlockLoader.DARK_HIGH_ELVEN_ROCK.get().asItem(), 0.1F, 200)
                .unlockedBy("has_dark_high_elven_cobblestone", has(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get()))
                .save(recipeConsumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.DARK_HIGH_ELVEN_ROCK_STAIRS.get(), 4)
                .define('G', BlockLoader.DARK_HIGH_ELVEN_ROCK.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_dark_high_elven_rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.DARK_HIGH_ELVEN_ROCK.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.DARK_HIGH_ELVEN_ROCK_SLAB.get(), 6)
                .define('G', BlockLoader.DARK_HIGH_ELVEN_ROCK.get())
                .pattern("GGG")
                .unlockedBy("has_dark_high_elven_rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.DARK_HIGH_ELVEN_ROCK.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.DARK_HIGH_ELVEN_ROCK_WALL.get(), 6)
                .define('G', BlockLoader.DARK_HIGH_ELVEN_ROCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_dark_high_elven_rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.DARK_HIGH_ELVEN_ROCK.get()).build()))
                .save(recipeConsumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS.get(), 4)
                .define('G', BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_light_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB.get(), 6)
                .define('G', BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .unlockedBy("has_light_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_WALL.get(), 6)
                .define('G', BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_light_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get())
                .requires(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get()).requires(Blocks.VINE).group("mossy_light_high_elven_cobblestone")
                .unlockedBy("has_vine", has(Blocks.VINE)).save(recipeConsumer,
                        getConversionRecipeName(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get(), Blocks.VINE));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get())
                .requires(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get()).requires(Blocks.MOSS_BLOCK).group("mossy_light_high_elven_cobblestone")
                .unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK)).save(recipeConsumer,
                        getConversionRecipeName(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get(), Blocks.MOSS_BLOCK));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS.get(), 4)
                .define('G', BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_mossy_light_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB.get(), 6)
                .define('G', BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .unlockedBy("has_mossy_light_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_WALL.get(), 6)
                .define('G', BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_mossy_light_high_elven_cobblestone", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get()).build()))
                .save(recipeConsumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get()), RecipeCategory.BUILDING_BLOCKS,
                        BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get().asItem(), 0.1F, 200)
                .unlockedBy("has_light_high_elven_cobblestone", has(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_HIGH_ELVEN_ROCK_STAIRS.get(), 4)
                .define('G', BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get())
                .pattern("G  ")
                .pattern("GG ")
                .pattern("GGG")
                .unlockedBy("has_light_high_elven_rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_HIGH_ELVEN_ROCK_SLAB.get(), 6)
                .define('G', BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get())
                .pattern("GGG")
                .unlockedBy("has_light_high_elven_rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get()).build()))
                .save(recipeConsumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BlockLoader.LIGHT_HIGH_ELVEN_ROCK_WALL.get(), 6)
                .define('G', BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get())
                .pattern("GGG")
                .pattern("GGG")
                .unlockedBy("has_light_high_elven_rock", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get()).build()))
                .save(recipeConsumer);




    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory,
                                      ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme,
                pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory,
                                      ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime,
                pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe>
            pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience,
                                     int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  Edumia.MODID + ":" + getItemName(pResult) + pRecipeName + "_" +
                            getItemName(itemlike));
        }
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory,
                                                    ItemLike input, ItemLike result) {
        stonecutterResultFromBase(pFinishedRecipeConsumer, pCategory, input, result, 1);
    }

    protected static void stonecutterResultFromBase(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pCategory, ItemLike input,
                                                    ItemLike result, int amount) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(result), pCategory, input, amount).unlockedBy(getHasName(result),
                has(result)).save(pFinishedRecipeConsumer, getConversionRecipeName(input, result) + "_stonecutting");
    }

}
