package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


public class CreativeTabLoader {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Edumia.MODID);

    public static final RegistryObject<CreativeModeTab> EDUMIA_REWARDS = CREATIVE_MODE_TABS.register("edumia_rewards",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemLoader.LEGENDS_COIN.get()))
                    .title(Component.translatable("creativetab.edumia_rewards"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemLoader.LEGENDS_COIN.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> EDUMIA_PLANTS = CREATIVE_MODE_TABS.register("edumia_plants",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockLoader.CALLA_LILY.get()))
                    .title(Component.translatable("creativetab.edumia_plants"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(BlockLoader.PAPYRUS.get());
                        pOutput.accept(BlockLoader.REEDS.get());
                        pOutput.accept(BlockLoader.DRIED_REEDS.get());

                        pOutput.accept(BlockLoader.ARID_GRASS.get());
                        pOutput.accept(BlockLoader.BLACK_GRASS.get());
                        pOutput.accept(BlockLoader.FLAX_GRASS.get());
                        //flowers
                        pOutput.accept(BlockLoader.ASPHODEL.get());
                        pOutput.accept(BlockLoader.BLUE_DELPHINIUM.get());
                        pOutput.accept(BlockLoader.BLUEBELL.get());
                        pOutput.accept(BlockLoader.CALLA_LILY.get());
                        pOutput.accept(BlockLoader.CELSEMIUM.get());
                        pOutput.accept(BlockLoader.CHRYS_BLUE.get());
                        pOutput.accept(BlockLoader.CHRYS_ORANGE.get());
                        pOutput.accept(BlockLoader.CHRYS_PINK.get());
                        pOutput.accept(BlockLoader.CHRYS_WHITE.get());
                        pOutput.accept(BlockLoader.CHRYS_YELLOW.get());
                        pOutput.accept(BlockLoader.CROCUS.get());
                        pOutput.accept(BlockLoader.DAISY.get());
                        pOutput.accept(BlockLoader.DELPHINIUM.get());
                        pOutput.accept(BlockLoader.FLAX_FLOWERS.get());
                        pOutput.accept(BlockLoader.FOXGLOVE_ORANGE.get());
                        pOutput.accept(BlockLoader.FOXGLOVE_PINK.get());
                        pOutput.accept(BlockLoader.FOXGLOVE_RED.get());
                        pOutput.accept(BlockLoader.FOXGLOVE_WHITE.get());
                        pOutput.accept(BlockLoader.GERBERA_RED.get());
                        pOutput.accept(BlockLoader.GERBERA_YELLOW.get());
                        pOutput.accept(BlockLoader.HEATHER_BUSH.get());
                        pOutput.accept(BlockLoader.LAVENDER.get());
                        pOutput.accept(BlockLoader.MARIGOLD.get());
                        pOutput.accept(BlockLoader.PINK_ANEMONE.get());
                        pOutput.accept(BlockLoader.SIMBLELMYNE.get());
                        pOutput.accept(BlockLoader.TUBEROSE.get());

                        pOutput.accept(BlockLoader.APPLE_SAPLING.get());
                        pOutput.accept(BlockLoader.APPLE_LEAVES.get());
                        pOutput.accept(BlockLoader.ASPEN_SAPLING.get());
                        pOutput.accept(BlockLoader.ASPEN_LEAVES.get());
                        pOutput.accept(BlockLoader.BEECH_SAPLING.get());
                        pOutput.accept(BlockLoader.BEECH_LEAVES.get());
                        pOutput.accept(BlockLoader.BLACKTHORN_SAPLING.get());
                        pOutput.accept(BlockLoader.BLACKTHORN_LEAVES.get());
                        pOutput.accept(BlockLoader.CEDAR_SAPLING.get());
                        pOutput.accept(BlockLoader.CEDAR_LEAVES.get());
                        pOutput.accept(BlockLoader.CHERRY_SAPLING.get());
                        pOutput.accept(BlockLoader.CHERRY_LEAVES.get());
                        pOutput.accept(BlockLoader.CYPRESS_SAPLING.get());
                        pOutput.accept(BlockLoader.CYPRESS_LEAVES.get());
                        pOutput.accept(BlockLoader.FIR_SAPLING.get());
                        pOutput.accept(BlockLoader.FIR_LEAVES.get());
                        pOutput.accept(BlockLoader.GHOST_GUM_SAPLING.get());
                        pOutput.accept(BlockLoader.GHOST_GUM_LEAVES.get());
                        pOutput.accept(BlockLoader.GREEN_OAK_SAPLING.get());
                        pOutput.accept(BlockLoader.GREEN_OAK_LEAVES.get());
                        pOutput.accept(BlockLoader.HOLLY_SAPLING.get());
                        pOutput.accept(BlockLoader.HOLLY_LEAVES.get());
                        pOutput.accept(BlockLoader.LARCH_SAPLING.get());
                        pOutput.accept(BlockLoader.LARCH_LEAVES.get());
                        pOutput.accept(BlockLoader.MAPLE_SAPLING.get());
                        pOutput.accept(BlockLoader.MAPLE_LEAVES.get());
                        pOutput.accept(BlockLoader.PEAR_SAPLING.get());
                        pOutput.accept(BlockLoader.PEAR_LEAVES.get());
                        pOutput.accept(BlockLoader.PINE_SAPLING.get());
                        pOutput.accept(BlockLoader.PINE_LEAVES.get());
                        pOutput.accept(BlockLoader.RED_OAK_SAPLING.get());
                        pOutput.accept(BlockLoader.RED_OAK_LEAVES.get());
                        pOutput.accept(BlockLoader.REDWOOD_SAPLING.get());
                        pOutput.accept(BlockLoader.SILVER_SPRUCE_SAPLING.get());
                        pOutput.accept(BlockLoader.SILVER_SPRUCE_LEAVES.get());
                        pOutput.accept(BlockLoader.WHITE_ASH_SAPLING.get());
                        pOutput.accept(BlockLoader.WHITE_ASH_LEAVES.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> EDUMIA_GEMS = CREATIVE_MODE_TABS.register("edumia_gems",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemLoader.GEM_PERFECT_AMBER.get()))
                    .title(Component.translatable("creativetab.edumia_gems"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemLoader.GEM_FINE_AMBER.get());
                        pOutput.accept(ItemLoader.GEM_FLAWED_AMBER.get());
                        pOutput.accept(ItemLoader.GEM_FLAWLESS_AMBER.get());
                        pOutput.accept(ItemLoader.GEM_PERFECT_AMBER.get());
                        pOutput.accept(ItemLoader.GEM_ROUGH_AMBER.get());
                        pOutput.accept(ItemLoader.GEM_FINE_AMETHYST.get());
                        pOutput.accept(ItemLoader.GEM_FLAWED_AMETHYST.get());
                        pOutput.accept(ItemLoader.GEM_FLAWLESS_AMETHYST.get());
                        pOutput.accept(ItemLoader.GEM_PERFECT_AMETHYST.get());
                        pOutput.accept(ItemLoader.GEM_ROUGH_AMETHYST.get());
                        pOutput.accept(ItemLoader.GEM_FINE_JADE.get());
                        pOutput.accept(ItemLoader.GEM_FLAWED_JADE.get());
                        pOutput.accept(ItemLoader.GEM_FLAWLESS_JADE.get());
                        pOutput.accept(ItemLoader.GEM_PERFECT_JADE.get());
                        pOutput.accept(ItemLoader.GEM_ROUGH_JADE.get());
                        pOutput.accept(ItemLoader.GEM_FINE_JASPER.get());
                        pOutput.accept(ItemLoader.GEM_FLAWED_JASPER.get());
                        pOutput.accept(ItemLoader.GEM_FLAWLESS_JASPER.get());
                        pOutput.accept(ItemLoader.GEM_PERFECT_JASPER.get());
                        pOutput.accept(ItemLoader.GEM_ROUGH_JASPER.get());
                        pOutput.accept(ItemLoader.GEM_FINE_RUBY.get());
                        pOutput.accept(ItemLoader.GEM_FLAWED_RUBY.get());
                        pOutput.accept(ItemLoader.GEM_FLAWLESS_RUBY.get());
                        pOutput.accept(ItemLoader.GEM_PERFECT_RUBY.get());
                        pOutput.accept(ItemLoader.GEM_ROUGH_RUBY.get());
                        pOutput.accept(ItemLoader.GEM_FINE_SAPPHIRE.get());
                        pOutput.accept(ItemLoader.GEM_FLAWED_SAPPHIRE.get());
                        pOutput.accept(ItemLoader.GEM_FLAWLESS_SAPPHIRE.get());
                        pOutput.accept(ItemLoader.GEM_PERFECT_SAPPHIRE.get());
                        pOutput.accept(ItemLoader.GEM_ROUGH_SAPPHIRE.get());
                        pOutput.accept(ItemLoader.GEM_FINE_TOPAZ.get());
                        pOutput.accept(ItemLoader.GEM_FLAWED_TOPAZ.get());
                        pOutput.accept(ItemLoader.GEM_FLAWLESS_TOPAZ.get());
                        pOutput.accept(ItemLoader.GEM_PERFECT_TOPAZ.get());
                        pOutput.accept(ItemLoader.GEM_ROUGH_TOPAZ.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> EDUMIA_ITEMS = CREATIVE_MODE_TABS.register("edumia_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemLoader.TEA_SAKURA_PETALS.get()))
                    .title(Component.translatable("creativetab.edumia_items"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ItemLoader.TEA_SAKURA_PETALS.get());
                        pOutput.accept(ItemLoader.TEA_MINT_LEAVES.get());
                        pOutput.accept(ItemLoader.TEA_LEAF.get());
                        pOutput.accept(ItemLoader.TEA_LILY_PETALS.get());
                        pOutput.accept(ItemLoader.TEA_WHITE_JADE_PETALS.get());
                        pOutput.accept(ItemLoader.TEA_HIBISCUS_PETALS.get());
                        pOutput.accept(ItemLoader.TEA_JASMINE_PETALS.get());
                        pOutput.accept(ItemLoader.TEA_CINNAMON_STICK.get());
                        pOutput.accept(ItemLoader.TEA_WHITE_DRAGON_PETALS.get());

                        pOutput.accept(ItemLoader.BROCCOLI.get());
                        pOutput.accept(ItemLoader.PAPRIKA_GREEN.get());
                        pOutput.accept(ItemLoader.RAMEN.get());
                        pOutput.accept(ItemLoader.RAMEN_BEEF.get());
                        pOutput.accept(ItemLoader.RAMEN_PORK.get());
                        pOutput.accept(ItemLoader.RAMEN_SHRIMPS.get());
                        pOutput.accept(ItemLoader.RAMEN_VEGI.get());
                        pOutput.accept(ItemLoader.RED_GRAPES.get());
                        pOutput.accept(ItemLoader.RICE.get());
                        pOutput.accept(ItemLoader.RICE_BALL.get());
                        pOutput.accept(ItemLoader.SPINACH.get());
                        pOutput.accept(ItemLoader.TOMATO.get());
                        pOutput.accept(ItemLoader.WINE_BOTTLE.get());

                        pOutput.accept(ItemLoader.POLISHED_JADE.get());
                        pOutput.accept(ItemLoader.TOPAZ_SHARD.get());

                        pOutput.accept(ItemLoader.INGOT_OCkER.get());
                        pOutput.accept(ItemLoader.INGOT_BLACK.get());
                        pOutput.accept(ItemLoader.INGOT_ICE.get());
                        pOutput.accept(ItemLoader.INGOT_PINK.get());
                        pOutput.accept(ItemLoader.INGOT_VEIL.get());
                        pOutput.accept(ItemLoader.INGOT_AQUATIA.get());
                        pOutput.accept(ItemLoader.INGOT_CRIMSUN.get());
                        pOutput.accept(ItemLoader.INGOT_DEMONIUM.get());
                        pOutput.accept(ItemLoader.INGOT_DRACONIAN.get());
                        pOutput.accept(ItemLoader.INGOT_HELLIAN.get());
                        pOutput.accept(ItemLoader.INGOT_GLIMMERING.get());
                        pOutput.accept(ItemLoader.INGOT_NEPTUNIUM.get());
                        pOutput.accept(ItemLoader.INGOT_SOLARITE.get());

                        pOutput.accept(ItemLoader.BAMBOO_STAFF.get());
                        pOutput.accept(ItemLoader.WAND_AIRSCEPTRE.get());
                        pOutput.accept(ItemLoader.GENSAI_NECKLESS.get());

                        pOutput.accept(ItemLoader.MAN_HOE.get());
                        pOutput.accept(ItemLoader.MAN_AXE.get());
                        pOutput.accept(ItemLoader.MAN_SHOVEL.get());
                        pOutput.accept(ItemLoader.MAN_PICKAXE.get());
                        pOutput.accept(ItemLoader.MAN_SWORD.get());

                        pOutput.accept(ItemLoader.ORC_HOE.get());
                        pOutput.accept(ItemLoader.ORC_AXE.get());
                        pOutput.accept(ItemLoader.ORC_SHOVEL.get());
                        pOutput.accept(ItemLoader.ORC_PICKAXE.get());
                        pOutput.accept(ItemLoader.ORC_SWORD.get());

                        pOutput.accept(ItemLoader.BATTLE_AXE.get());

                        pOutput.accept(ItemLoader.ATLAS.get());
                        pOutput.accept(ItemLoader.BIGBOOK.get());
                        pOutput.accept(ItemLoader.CHASE.get());
                        pOutput.accept(ItemLoader.CLIPBOARDSIMPLE.get());
                        pOutput.accept(ItemLoader.FRAMINGBOARD.get());
                        pOutput.accept(ItemLoader.FRAMINGAHEET.get());
                        pOutput.accept(ItemLoader.HANDDRILL.get());
                        pOutput.accept(ItemLoader.LOCK.get());
                        pOutput.accept(ItemLoader.MAPTOOL.get());
                        pOutput.accept(ItemLoader.MONOCLE.get());
                        pOutput.accept(ItemLoader.PLATE.get());
                        pOutput.accept(ItemLoader.PLUMBLINE.get());
                        pOutput.accept(ItemLoader.RECIPEBOOK.get());
                        pOutput.accept(ItemLoader.SAW.get());
                        pOutput.accept(ItemLoader.STOCKCATALOG.get());
                        pOutput.accept(ItemLoader.TAPE.get());

                        pOutput.accept(ItemLoader.ALEXANDRITE.get());
                        pOutput.accept(ItemLoader.RAW_ALEXANDRITE.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> EDUMIA_SPAWNS = CREATIVE_MODE_TABS.register("edumia_spawns",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemLoader.RHINO_SPAWN_EGG.get()))
                    .title(Component.translatable("creativetab.edumia_spawns"))
                    .displayItems((pParameters, pOutput) ->{
                        pOutput.accept(ItemLoader.RHINO_SPAWN_EGG.get());
                        pOutput.accept((ItemLoader.BOAR_SPAWN_EGG.get()));
                        pOutput.accept(ItemLoader.ALLIGATOR_SPAWN_EGG.get());
                        pOutput.accept(ItemLoader.BADGER_SPAWN_EGG.get());
                    })
                    .build());
    public static final RegistryObject<CreativeModeTab> EDUMIA_BUILDING_BLOCKS = CREATIVE_MODE_TABS.register("edumia_building_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockLoader.GREEN_BASALT_BRICKS.get()))
                    .title(Component.translatable("creativetab.edumia_building_blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(BlockLoader.BRICK_PILLAR.get());
                        pOutput.accept(BlockLoader.STONE_PILLAR.get());

                        pOutput.accept(BlockLoader.BASALT_BRICKS.get());
                        pOutput.accept(BlockLoader.BASALT_BRICKS_SLAB.get());
                        pOutput.accept(BlockLoader.BASALT_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.BASALT_BRICKS_WALL.get());

                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_SLAB.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_GOTHIC_ARCH.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_SEGMENTAL_ARCH.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_ROUND_ARCH.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_SMALL_ARCH.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_TWO_METER_ARCH.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_ARROWSLIT.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_BALUSTRADE.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_PILLAR.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_CORINTHIAN_CAPITAL_WALL.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_LARGE_PILLAR.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_PILAR.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_SMALL_PILLAR.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BRICKS_IONIAN_CAPITAL_WALL.get());

                        pOutput.accept(BlockLoader.GREEN_BASALT_COBBLESTONE.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_COBBLESTONE_WALL.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_COBBLESTONE_SLAB.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_COBBLESTONE_STAIRS.get());

                        pOutput.accept(BlockLoader.LIGHT_GRAY_STONE_BRICKS.get());
                        pOutput.accept(BlockLoader.LIGHT_GRAY_STONE_BRICKS_SLAB.get());
                        pOutput.accept(BlockLoader.LIGHT_GRAY_STONE_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.LIGHT_GRAY_STONE_BRICKS_WALL.get());

                        pOutput.accept(BlockLoader.BLUE_BRICK.get());
                        pOutput.accept(BlockLoader.BLUE_BRICK_SLAB.get());
                        pOutput.accept(BlockLoader.BLUE_BRICK_STAIRS.get());
                        pOutput.accept(BlockLoader.BLUE_BRICK_WALL.get());

                        pOutput.accept(BlockLoader.BROWN_STONE.get());
                        pOutput.accept(BlockLoader.BROWN_STONE_SLAB.get());
                        pOutput.accept(BlockLoader.BROWN_STONE_STAIRS.get());
                        pOutput.accept(BlockLoader.BROWN_STONE_WALL.get());

                        pOutput.accept(BlockLoader.YELLOW_STONE_BRICKS_2.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_BRICKS_2_SLAB.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_BRICKS_2_STAIRS.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_BRICKS_2_WALL.get());

                        pOutput.accept(BlockLoader.YELLOW_STONE_BRICKS.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_BRICKS_SLAB.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_BRICKS_WALL.get());

                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICKS_ROUND_ARCH.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICKS_SEGMENTAL_ARCH.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICKS_GOTHIC_ARCH.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICKS_SMALL_ARCH.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICKS_TWO_METER_ARCH.get());

                        pOutput.accept(BlockLoader.HIGH_ELVEN_PILLAR.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_BALUSTRADE.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICK_ARROWSLIT.get());

                        pOutput.accept(BlockLoader.SMALL_HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.SMALL_HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CRACKED_HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CHISELED_HIGH_ELVEN_BRICKS.get());

                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICK_TILING.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICK_TILING_STAIRS.get());
                        //pOutput.accept(BlockLoader.HIGH_ELVEN_BRICK_TILING_WALL.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_BRICK_TILING_SLAB.get());

                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_PILLAR.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_BALUSTRADE.get());

                        pOutput.accept(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.SMALL_LIGHT_HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CRACKED_LIGHT_HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CHISELED_LIGHT_HIGH_ELVEN_BRICKS.get());

                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_SLAB.get());
                        // pOutput.accept(BlockLoader.HIGH_ELVEN_BRICK_TILING_WALL.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_BRICK_TILING_STAIRS.get());

                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_PILLAR.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_BALUSTRADE.get());

                        pOutput.accept(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.SMALL_DARK_HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CRACKED_DARK_HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS.get());
                        pOutput.accept(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_DARK_HIGH_ELVEN_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CHISELED_DARK_HIGH_ELVEN_BRICKS.get());

                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_STAIRS.get());
                        //pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_WALL.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_BRICK_TILING_SLAB.get());

                        pOutput.accept(BlockLoader.CRACKED_GREEN_BASALT.get());
                        pOutput.accept(BlockLoader.CRACKED_GREEN_BASALT_SLAB.get());
                        pOutput.accept(BlockLoader.CRACKED_GREEN_BASALT_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_GREEN_BASALT_WALL.get());

                        pOutput.accept(BlockLoader.CHISELED_BASALT.get());

                        pOutput.accept(BlockLoader.MOSSY_BASALT_BRICKS.get());
                        pOutput.accept(BlockLoader.MOSSY_BASALT_BRICKS_SLAB.get());
                        pOutput.accept(BlockLoader.MOSSY_BASALT_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_BASALT_BRICKS_WALL.get());

                        pOutput.accept(BlockLoader.CHALK_BRICKS.get());
                        pOutput.accept(BlockLoader.CHALK_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CHALK_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CHALK_BRICKS_SLAB.get());
                        pOutput.accept(BlockLoader.CHALK_PILLAR.get());

                        pOutput.accept(BlockLoader.BROWN_SANDSTONE_BRICKS.get());
                        pOutput.accept(BlockLoader.BROWN_SANDSTONE_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.BROWN_SANDSTONE_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.BROWN_SANDSTONE_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS.get());
                        pOutput.accept(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CRACKED_BROWN_SANDSTONE_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS.get());
                        pOutput.accept(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_BROWN_SANDSTONE_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CARVED_BROWN_SANDSTONE_BRICKS.get());

                        pOutput.accept(BlockLoader.CACHOLONG_BRICKS.get());
                        pOutput.accept(BlockLoader.CACHOLONG_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CACHOLONG_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CACHOLONG_BRICKS_SLAB.get());
                        pOutput.accept(BlockLoader.CACHOLONG_PILLAR.get());

                        pOutput.accept(BlockLoader.CRACKED_CACHOLONG_BRICKS.get());
                        pOutput.accept(BlockLoader.CRACKED_CACHOLONG_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_CACHOLONG_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CRACKED_CACHOLONG_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_CACHOLONG_BRICKS.get());
                        pOutput.accept(BlockLoader.MOSSY_CACHOLONG_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_CACHOLONG_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_CACHOLONG_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CARVED_CACHOLONG_BRICKS.get());

                        pOutput.accept(BlockLoader.BLACK_DEMON_BRICKS.get());
                        pOutput.accept(BlockLoader.BLACK_DEMON_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.BLACK_DEMON_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.BLACK_DEMON_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CRACKED_BLACK_DEMON_BRICKS.get());
                        pOutput.accept(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CRACKED_BLACK_DEMON_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_BLACK_DEMON_BRICKS.get());
                        pOutput.accept(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_BLACK_DEMON_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CARVED_BLACK_DEMON_BRICKS.get());

                        pOutput.accept(BlockLoader.BLUE_BRICKS.get());
                        pOutput.accept(BlockLoader.BLUE_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.BLUE_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.BLUE_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CRACKED_BLUE_BRICKS.get());
                        pOutput.accept(BlockLoader.CRACKED_BLUE_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_BLUE_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CRACKED_BLUE_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_BLUE_BRICKS.get());
                        pOutput.accept(BlockLoader.MOSSY_BLUE_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_BLUE_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_BLUE_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CARVED_BLUE_BRICKS.get());

                        pOutput.accept(BlockLoader.DEMON_BASALT_BRICKS.get());
                        pOutput.accept(BlockLoader.DEMON_BASALT_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.DEMON_BASALT_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.DEMON_BASALT_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CARVED_DEMON_BASALT_BRICKS.get());

                        pOutput.accept(BlockLoader.VULCANIC_DEMON_BRICKS.get());
                        pOutput.accept(BlockLoader.VULCANIC_DEMON_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.VULCANIC_DEMON_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.VULCANIC_DEMON_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS.get());
                        pOutput.accept(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CRACKED_VULCANIC_DEMON_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS.get());
                        pOutput.accept(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_VULCANIC_DEMON_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CARVED_VULCANIC_DEMON_BRICKS.get());

                        pOutput.accept(BlockLoader.RED_BRICKS.get());
                        pOutput.accept(BlockLoader.RED_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.RED_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.RED_BRICKS_SLAB.get());
                        pOutput.accept(BlockLoader.RED_PILLAR.get());

                        pOutput.accept(BlockLoader.CRACKED_RED_BRICKS.get());
                        pOutput.accept(BlockLoader.CRACKED_RED_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_RED_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CRACKED_RED_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_RED_BRICKS.get());
                        pOutput.accept(BlockLoader.MOSSY_RED_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_RED_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_RED_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CARVED_RED_BRICKS.get());

                        pOutput.accept(BlockLoader.DESERT_MUD_BRICKS.get());
                        pOutput.accept(BlockLoader.DESERT_MUD_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.DESERT_MUD_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.DESERT_MUD_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CRACKED_DESERT_MUD_BRICKS.get());
                        pOutput.accept(BlockLoader.CRACKED_DESERT_MUD_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_DESERT_MUD_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.CRACKED_DESERT_MUD_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_DESERT_MUD_BRICKS.get());
                        pOutput.accept(BlockLoader.MOSSY_DESERT_MUD_BRICKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_DESERT_MUD_BRICKS_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_DESERT_MUD_BRICKS_SLAB.get());

                        pOutput.accept(BlockLoader.CLAY_TILING.get());
                        pOutput.accept(BlockLoader.CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.BLACK_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.BLACK_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.BLACK_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.BLACK_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.BLUE_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.BLUE_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.BLUE_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.BLUE_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.BROWN_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.BROWN_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.BROWN_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.BROWN_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.CYAN_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.CYAN_CLAY_TILING_STAIRS .get());
                        pOutput.accept(BlockLoader.CYAN_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.CYAN_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.GRAY_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.GRAY_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.GRAY_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.GRAY_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.GREEN_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.GREEN_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.GREEN_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.GREEN_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.LIGHT_BLUE_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.LIGHT_BLUE_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.LIGHT_BLUE_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.LIGHT_BLUE_CLAY_TILING_VERTICAL_CORNER.get());
                        pOutput.accept(BlockLoader.LIGHT_GRAY_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.LIGHT_GRAY_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.LIGHT_GRAY_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.LIGHT_GRAY_CLAY_TILING_SLAB.get());

                        pOutput.accept(BlockLoader.LIME_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.LIME_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.LIME_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.LIME_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.MAGENTA_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.MAGENTA_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.MAGENTA_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.MAGENTA_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.ORANGE_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.ORANGE_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.ORANGE_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.ORANGE_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.PINK_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.PINK_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.PINK_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.PINK_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.PURPLE_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.PURPLE_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.PURPLE_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.PURPLE_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.RED_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.RED_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.RED_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.RED_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.WHITE_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.WHITE_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.WHITE_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.WHITE_CLAY_TILING_VERTICAL_CORNER.get());

                        pOutput.accept(BlockLoader.YELLOW_CLAY_TILING.get());
                        pOutput.accept(BlockLoader.YELLOW_CLAY_TILING_STAIRS.get());
                        pOutput.accept(BlockLoader.YELLOW_CLAY_TILING_SLAB.get());
                        pOutput.accept(BlockLoader.YELLOW_CLAY_TILING_VERTICAL_CORNER.get());






                    }).build());
    public static final RegistryObject<CreativeModeTab> EDUMIA_WOOD_BLOCKS = CREATIVE_MODE_TABS.register("edumia_wood_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockLoader.PEAR_PLANKS.get()))
                    .title(Component.translatable("creativetab.edumia_wood_blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(BlockLoader.APPLE_PLANKS.get());
                        pOutput.accept(BlockLoader.APPLE_FENCE.get());
                        pOutput.accept(BlockLoader.APPLE_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.APPLE_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.APPLE_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.APPLE_LOG.get());
                        pOutput.accept(BlockLoader.APPLE_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_APPLE_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_APPLE_WOOD.get());

                        pOutput.accept(BlockLoader.ASPEN_PLANKS.get());
                        pOutput.accept(BlockLoader.ASPEN_FENCE.get());
                        pOutput.accept(BlockLoader.ASPEN_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.ASPEN_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.ASPEN_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.ASPEN_LOG.get());
                        pOutput.accept(BlockLoader.ASPEN_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_ASPEN_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_ASPEN_WOOD.get());



                        pOutput.accept(BlockLoader.BAOBAB_PLANKS.get());
                        pOutput.accept(BlockLoader.BAOBAB_FENCE.get());
                        pOutput.accept(BlockLoader.BAOBAB_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.BAOBAB_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.BAOBAB_PLANKS_SLAB.get());
                        //  pOutput.accept(BlockLoader.BAOBAB_LOG.get());
                        //pOutput.accept(BlockLoader.BAOBAB_WOOD.get());
                        // pOutput.accept(BlockLoader.STRIPPED_BAOBAB_LOG.get());
                        //pOutput.accept(BlockLoader.STRIPPED_BAOBAB_WOOD.get());
                        //pOutput.accept(BlockLoader.BAOBAB_SAPLING.get());


                        pOutput.accept(BlockLoader.BEECH_PLANKS.get());
                        pOutput.accept(BlockLoader.BEECH_FENCE.get());
                        pOutput.accept(BlockLoader.BEECH_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.BEECH_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.BEECH_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.BEECH_LOG.get());
                        pOutput.accept(BlockLoader.BEECH_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_BEECH_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_BEECH_WOOD.get());

                        pOutput.accept(BlockLoader.BLACKTHORN_PLANKS.get());
                        pOutput.accept(BlockLoader.BLACKTHORN_FENCE.get());
                        pOutput.accept(BlockLoader.BLACKTHORN_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.BLACKTHORN_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.BLACKTHORN_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.BLACKTHORN_LOG.get());
                        pOutput.accept(BlockLoader.BLACKTHORN_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_BLACKTHORN_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_BLACKTHORN_WOOD.get());

                        pOutput.accept(BlockLoader.CEDAR_PLANKS.get());
                        pOutput.accept(BlockLoader.CEDAR_FENCE.get());
                        pOutput.accept(BlockLoader.CEDAR_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.CEDAR_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CEDAR_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.CEDAR_LOG.get());
                        pOutput.accept(BlockLoader.CEDAR_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_CEDAR_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_CEDAR_WOOD.get());

                        pOutput.accept(BlockLoader.CHERRY_PLANKS.get());
                        pOutput.accept(BlockLoader.CHERRY_FENCE.get());
                        pOutput.accept(BlockLoader.CHERRY_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.CHERRY_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CHERRY_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.CHERRY_LOG.get());
                        pOutput.accept(BlockLoader.CHERRY_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_CHERRY_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_CHERRY_WOOD.get());

                        pOutput.accept(BlockLoader.CYPRESS_PLANKS.get());
                        pOutput.accept(BlockLoader.CYPRESS_FENCE.get());
                        pOutput.accept(BlockLoader.CYPRESS_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.CYPRESS_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.CYPRESS_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.CYPRESS_LOG.get());
                        pOutput.accept(BlockLoader.CYPRESS_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_CYPRESS_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_CYPRESS_WOOD.get());

                        pOutput.accept(BlockLoader.FIR_PLANKS.get());
                        pOutput.accept(BlockLoader.FIR_FENCE.get());
                        pOutput.accept(BlockLoader.FIR_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.FIR_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.FIR_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.FIR_LOG.get());
                        pOutput.accept(BlockLoader.FIR_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_FIR_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_FIR_WOOD.get());

                        pOutput.accept(BlockLoader.GHOST_GUM_PLANKS.get());
                        pOutput.accept(BlockLoader.GHOST_GUM_FENCE.get());
                        pOutput.accept(BlockLoader.GHOST_GUM_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.GHOST_GUM_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.GHOST_GUM_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.GHOST_GUM_LOG.get());
                        pOutput.accept(BlockLoader.GHOST_GUM_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_GHOST_GUM_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_GHOST_GUM_WOOD.get());

                        pOutput.accept(BlockLoader.GREEN_OAK_PLANKS.get());
                        pOutput.accept(BlockLoader.GREEN_OAK_FENCE.get());
                        pOutput.accept(BlockLoader.GREEN_OAK_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.GREEN_OAK_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.GREEN_OAK_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.GREEN_OAK_LOG.get());
                        pOutput.accept(BlockLoader.GREEN_OAK_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_GREEN_OAK_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_GREEN_OAK_WOOD.get());

                        pOutput.accept(BlockLoader.HOLLY_PLANKS.get());
                        pOutput.accept(BlockLoader.HOLLY_FENCE.get());
                        pOutput.accept(BlockLoader.HOLLY_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.HOLLY_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.HOLLY_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.HOLLY_LOG.get());
                        pOutput.accept(BlockLoader.HOLLY_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_HOLLY_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_HOLLY_WOOD.get());

                        pOutput.accept(BlockLoader.LARCH_PLANKS.get());
                        pOutput.accept(BlockLoader.LARCH_FENCE.get());
                        pOutput.accept(BlockLoader.LARCH_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.LARCH_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.LARCH_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.LARCH_LOG.get());
                        pOutput.accept(BlockLoader.LARCH_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_LARCH_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_LARCH_WOOD.get());

                        pOutput.accept(BlockLoader.MAPLE_PLANKS.get());
                        pOutput.accept(BlockLoader.MAPLE_FENCE.get());
                        pOutput.accept(BlockLoader.MAPLE_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.MAPLE_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.MAPLE_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.MAPLE_LOG.get());
                        pOutput.accept(BlockLoader.MAPLE_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_MAPLE_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_MAPLE_WOOD.get());

                        pOutput.accept(BlockLoader.OKOME_PLANKS.get());
                        pOutput.accept(BlockLoader.OKOME_FENCE.get());
                        pOutput.accept(BlockLoader.OKOME_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.OKOME_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.OKOME_PLANKS_SLAB.get());

                        pOutput.accept(BlockLoader.PEAR_PLANKS.get());
                        pOutput.accept(BlockLoader.PEAR_FENCE.get());
                        pOutput.accept(BlockLoader.PEAR_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.PEAR_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.PEAR_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.PEAR_LOG.get());
                        pOutput.accept(BlockLoader.PEAR_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_PEAR_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_PEAR_WOOD.get());


                        pOutput.accept(BlockLoader.PINE_PLANKS.get());
                        pOutput.accept(BlockLoader.PINE_FENCE.get());
                        pOutput.accept(BlockLoader.PINE_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.PINE_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.PINE_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.PINE_LOG.get());
                        pOutput.accept(BlockLoader.PINE_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_PINE_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_PINE_WOOD.get());

                        pOutput.accept(BlockLoader.PLUM_PLANKS.get());
                        pOutput.accept(BlockLoader.PLUM_FENCE.get());
                        pOutput.accept(BlockLoader.PLUM_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.PLUM_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.PLUM_PLANKS_SLAB.get());

                        pOutput.accept(BlockLoader.RED_OAK_PLANKS.get());
                        pOutput.accept(BlockLoader.RED_OAK_FENCE.get());
                        pOutput.accept(BlockLoader.RED_OAK_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.RED_OAK_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.RED_OAK_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.RED_OAK_LOG.get());
                        pOutput.accept(BlockLoader.RED_OAK_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_RED_OAK_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_RED_OAK_WOOD.get());

                        pOutput.accept(BlockLoader.REDWOOD_PLANKS.get());
                        pOutput.accept(BlockLoader.REDWOOD_FENCE.get());
                        pOutput.accept(BlockLoader.REDWOOD_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.REDWOOD_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.REDWOOD_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.REDWOOD_LOG.get());
                        pOutput.accept(BlockLoader.REDWOOD_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_REDWOOD_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_REDWOOD_WOOD.get());
                        pOutput.accept(BlockLoader.REDWOOD_DOOR.get());
                        pOutput.accept(BlockLoader.REDWOOD_TRAPDOOR.get());
                        pOutput.accept(BlockLoader.REDWOOD_BUTTON.get());
                        pOutput.accept(BlockLoader.REDWOOD_PRESSURE_PLATE.get());
                        pOutput.accept(BlockLoader.REDWOOD_BANISTER.get());
                        pOutput.accept(BlockLoader.REDWOOD_BALUSTRADE.get());


                        pOutput.accept(BlockLoader.SILVER_SPRUCE_PLANKS.get());
                        pOutput.accept(BlockLoader.SILVER_SPRUCE_FENCE.get());
                        pOutput.accept(BlockLoader.SILVER_SPRUCE_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.SILVER_SPRUCE_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.SILVER_SPRUCE_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.SILVER_SPRUCE_LOG.get());
                        pOutput.accept(BlockLoader.SILVER_SPRUCE_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_SILVER_SPRUCE_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_SILVER_SPRUCE_WOOD.get());

                        pOutput.accept(BlockLoader.WHITE_ASH_PLANKS.get());
                        pOutput.accept(BlockLoader.WHITE_ASH_FENCE.get());
                        pOutput.accept(BlockLoader.WHITE_ASH_FENCE_GATE.get());
                        pOutput.accept(BlockLoader.WHITE_ASH_PLANKS_STAIRS.get());
                        pOutput.accept(BlockLoader.WHITE_ASH_PLANKS_SLAB.get());
                        pOutput.accept(BlockLoader.WHITE_ASH_LOG.get());
                        pOutput.accept(BlockLoader.WHITE_ASH_WOOD.get());
                        pOutput.accept(BlockLoader.STRIPPED_WHITE_ASH_LOG.get());
                        pOutput.accept(BlockLoader.STRIPPED_WHITE_ASH_WOOD.get());

                    }).build());
    public static final RegistryObject<CreativeModeTab> EDUMIA_NATURAL_STONE_BLOCKS = CREATIVE_MODE_TABS.register("edumia_natural_stone_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(BlockLoader.TOPAZ_ORE.get()))
                    .title(Component.translatable("creativetab.edumia_natural_stone_blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(BlockLoader.TOPAZ_ORE.get());
                        pOutput.accept(BlockLoader.ORE_VEIL.get());

                        pOutput.accept(BlockLoader.ALEXANDRITE_BLOCK.get());
                        pOutput.accept(BlockLoader.ALEXANDRITE_ORE.get());
                        pOutput.accept(BlockLoader.RAW_ALEXANDRITE_BLOCK.get());

                        pOutput.accept(BlockLoader.GREEN_BASALT_COBBLESTONE.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_COBBLESTONE_WALL.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_COBBLESTONE_SLAB.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_COBBLESTONE_STAIRS.get());

                        pOutput.accept(BlockLoader.GREEN_BASALT.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_STAIRS.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_WALL.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_SLAB.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_BALUSTRADE.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_ROUND_ARCH.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_GOTHIC_ARCH.get());
                        pOutput.accept(BlockLoader.GREEN_BASALT_SEGMENTAL_ARCH.get());

                        pOutput.accept(BlockLoader.LIGHT_GRAY_STONE.get());
                        pOutput.accept(BlockLoader.LIGHT_GRAY_STONE_SLAB.get());
                        pOutput.accept(BlockLoader.LIGHT_GRAY_STONE_STAIRS.get());
                        pOutput.accept(BlockLoader.LIGHT_GRAY_STONE_WALL.get());

                        pOutput.accept(BlockLoader.BLUE_STONE.get());
                        pOutput.accept(BlockLoader.BLUE_STONE_SLAB.get());
                        pOutput.accept(BlockLoader.BLUE_STONE_STAIRS.get());
                        pOutput.accept(BlockLoader.BLUE_STONE_WALL.get());

                        pOutput.accept(BlockLoader.CYAN_STONE.get());
                        pOutput.accept(BlockLoader.CYAN_STONE_SLAB.get());
                        pOutput.accept(BlockLoader.CYAN_STONE_STAIRS.get());
                        pOutput.accept(BlockLoader.CYAN_STONE_WALL.get());

                        pOutput.accept(BlockLoader.BROWN_STONE.get());
                        pOutput.accept(BlockLoader.BROWN_STONE_SLAB.get());
                        pOutput.accept(BlockLoader.BROWN_STONE_STAIRS.get());
                        pOutput.accept(BlockLoader.BROWN_STONE_WALL.get());

                        pOutput.accept(BlockLoader.YELLOW_STONE_2.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_2_SLAB.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_2_STAIRS.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_2_WALL.get());

                        pOutput.accept(BlockLoader.YELLOW_STONE.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_SLAB.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_STAIRS.get());
                        pOutput.accept(BlockLoader.YELLOW_STONE_WALL.get());

                        pOutput.accept(BlockLoader.YELLOW_COBBLE.get());
                        pOutput.accept(BlockLoader.YELLOW_COBBLE_SLAB.get());
                        pOutput.accept(BlockLoader.YELLOW_COBBLE_STAIRS.get());
                        pOutput.accept(BlockLoader.YELLOW_COBBLE_WALL.get());

                        pOutput.accept(BlockLoader.ORANGE_ROCK.get());
                        pOutput.accept(BlockLoader.ORANGE_ROCK_SLAB.get());
                        pOutput.accept(BlockLoader.ORANGE_ROCK_STAIRS.get());
                        pOutput.accept(BlockLoader.ORANGE_ROCK_WALL.get());

                        pOutput.accept(BlockLoader.RED_ROCK.get());
                        pOutput.accept(BlockLoader.RED_ROCK_SLAB.get());
                        pOutput.accept(BlockLoader.RED_ROCK_STAIRS.get());
                        pOutput.accept(BlockLoader.RED_ROCK_WALL.get());

                        pOutput.accept(BlockLoader.CRACKED_GREEN_BASALT.get());
                        pOutput.accept(BlockLoader.CRACKED_GREEN_BASALT_SLAB.get());
                        pOutput.accept(BlockLoader.CRACKED_GREEN_BASALT_STAIRS.get());
                        pOutput.accept(BlockLoader.CRACKED_GREEN_BASALT_WALL.get());

                        pOutput.accept(BlockLoader.CHISELED_BASALT.get());

                        pOutput.accept(BlockLoader.GNEISS.get());
                        pOutput.accept(BlockLoader.GNEISS_SLAB.get());
                        pOutput.accept(BlockLoader.GNEISS_STAIRS.get());
                        pOutput.accept(BlockLoader.GNEISS_WALL.get());

                        pOutput.accept(BlockLoader.LIMESTONE.get());
                        pOutput.accept(BlockLoader.LIMESTONE_SLAB.get());
                        pOutput.accept(BlockLoader.LIMESTONE_WALL.get());
                        pOutput.accept(BlockLoader.LIMESTONE_STAIRS.get());

                        pOutput.accept((BlockLoader.MARBLE_PINK.get()));

                        pOutput.accept(BlockLoader.CHALK.get());
                        pOutput.accept(BlockLoader.CHALK_SLAB.get());
                        pOutput.accept(BlockLoader.CHALK_WALL.get());
                        pOutput.accept(BlockLoader.CHALK_STAIRS.get());

                        pOutput.accept(BlockLoader.BROWN_SANDSTONE_SLATES.get());

                        pOutput.accept(BlockLoader.HIGH_ELVEN_ROCK.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_ROCK_STAIRS.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_ROCK_WALL.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_ROCK_SLAB.get());

                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_ROCK.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_ROCK_STAIRS.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_ROCK_WALL.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_ROCK_SLAB.get());

                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_ROCK.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_STAIRS.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_WALL.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_ROCK_SLAB.get());

                        pOutput.accept(BlockLoader.HIGH_ELVEN_COBBLESTONE.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_COBBLESTONE_STAIRS.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_COBBLESTONE_WALL.get());
                        pOutput.accept(BlockLoader.HIGH_ELVEN_COBBLESTONE_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE.get());
                        pOutput.accept(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_HIGH_ELVEN_COBBLESTONE_SLAB.get());

                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_WALL.get());
                        pOutput.accept(BlockLoader.LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE.get());
                        pOutput.accept(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_LIGHT_HIGH_ELVEN_COBBLESTONE_SLAB.get());

                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_STAIRS.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_WALL.get());
                        pOutput.accept(BlockLoader.DARK_HIGH_ELVEN_COBBLESTONE_SLAB.get());

                        pOutput.accept(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE.get());
                        pOutput.accept(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_STAIRS.get());
                        pOutput.accept(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_WALL.get());
                        pOutput.accept(BlockLoader.MOSSY_DARK_HIGH_ELVEN_COBBLESTONE_SLAB.get());

                        pOutput.accept(BlockLoader.VULCANIC_ROCK.get());
                        pOutput.accept(BlockLoader.VULCANIC_ROCK_STAIRS.get());
                        pOutput.accept(BlockLoader.VULCANIC_ROCK_WALL.get());
                        pOutput.accept(BlockLoader.VULCANIC_ROCK_SLAB.get());

                        pOutput.accept(BlockLoader.SAND_LAYER.get());
                        pOutput.accept(BlockLoader.RED_SAND_LAYER.get());
                        pOutput.accept(BlockLoader.WHITE_SAND.get());
                        pOutput.accept(BlockLoader.WHITE_SAND_LAYER.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
