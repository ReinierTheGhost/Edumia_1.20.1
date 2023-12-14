package com.legends.edumia.core;

import com.legends.edumia.Edumia;
import com.legends.edumia.item.EdumiaBlockItem;
import com.legends.edumia.item.EdumiaMapItem;
import com.legends.edumia.item.ModArmorMaterials;
import com.legends.edumia.item.ModTier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemLoader {


    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Edumia.MODID);

    //rewards
    public static final RegistryObject<Item> LEGENDS_COIN = ITEMS.register("legends_coin",
            () -> new Item(new Item.Properties()));

    //gems
    public static final RegistryObject<Item> TOPAZ_SHARD = ITEMS.register("topaz_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POLISHED_JADE = ITEMS.register("polished_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_AMBER = ITEMS.register("gem_fine_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_AMBER = ITEMS.register("gem_flawed_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_AMBER = ITEMS.register("gem_flawless_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_AMBER = ITEMS.register("gem_perfect_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_AMBER = ITEMS.register("gem_rough_amber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_AMETHYST = ITEMS.register("gem_fine_amethyst",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_AMETHYST = ITEMS.register("gem_flawed_amethyst",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_AMETHYST = ITEMS.register("gem_flawless_amethyst",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_AMETHYST = ITEMS.register("gem_perfect_amethyst",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_AMETHYST = ITEMS.register("gem_rough_amethyst",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_JADE = ITEMS.register("gem_fine_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_JADE = ITEMS.register("gem_flawed_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_JADE = ITEMS.register("gem_flawless_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_JADE = ITEMS.register("gem_perfect_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_JADE = ITEMS.register("gem_rough_jade",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_JASPER = ITEMS.register("gem_fine_jasper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_JASPER = ITEMS.register("gem_flawed_jasper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_JASPER = ITEMS.register("gem_flawless_jasper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_JASPER = ITEMS.register("gem_perfect_jasper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_JASPER = ITEMS.register("gem_rough_jasper",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_RUBY = ITEMS.register("gem_fine_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_RUBY = ITEMS.register("gem_flawed_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_RUBY = ITEMS.register("gem_flawless_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_RUBY = ITEMS.register("gem_perfect_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_RUBY = ITEMS.register("gem_rough_ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_SAPPHIRE = ITEMS.register("gem_fine_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_SAPPHIRE = ITEMS.register("gem_flawed_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_SAPPHIRE = ITEMS.register("gem_flawless_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_SAPPHIRE = ITEMS.register("gem_perfect_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_SAPPHIRE = ITEMS.register("gem_rough_sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FINE_TOPAZ = ITEMS.register("gem_fine_topaz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWED_TOPAZ = ITEMS.register("gem_flawed_topaz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_FLAWLESS_TOPAZ = ITEMS.register("gem_flawless_topaz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_PERFECT_TOPAZ = ITEMS.register("gem_perfect_topaz",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEM_ROUGH_TOPAZ = ITEMS.register("gem_rough_topaz",
            () -> new Item(new Item.Properties()));


    //ingots
    public static final RegistryObject<Item> INGOT_VEIL = ITEMS.register("ingot_veil",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_ICE = ITEMS.register("ingot_ice",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_OCkER = ITEMS.register("ingot_ocker",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_PINK = ITEMS.register("ingot_pink",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_BLACK = ITEMS.register("ingot_black",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_AQUATIA = ITEMS.register("ingot_aquatia",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_CRIMSUN = ITEMS.register("ingot_crimsun",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_DEMONIUM = ITEMS.register("ingot_demonium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_DRACONIAN = ITEMS.register("ingot_draconian",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_GLIMMERING = ITEMS.register("ingot_glimmering",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_HELLIAN = ITEMS.register("ingot_hellian",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_NEPTUNIUM = ITEMS.register("ingot_neptunium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> INGOT_SOLARITE = ITEMS.register("ingot_solarite",
            () -> new Item(new Item.Properties()));

    //thea ingredients
    public static final RegistryObject<Item> TEA_CINNAMON_STICK = ITEMS.register("tea_cinnamon_stick",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_HIBISCUS_PETALS = ITEMS.register("tea_hibiscus_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_JASMINE_PETALS = ITEMS.register("tea_jasmine_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_LILY_PETALS = ITEMS.register("tea_lily_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_MINT_LEAVES = ITEMS.register("tea_mint_leaves",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_SAKURA_PETALS = ITEMS.register("tea_sakura_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_WHITE_DRAGON_PETALS = ITEMS.register("tea_white_dragon_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_WHITE_JADE_PETALS = ITEMS.register("tea_white_jade_petals",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TEA_LEAF = ITEMS.register("tea_leaf",
            () -> new Item(new Item.Properties()));

    //food
    public static final RegistryObject<Item> RICE_BALL = ITEMS.register("rice_ball",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));
    public static final RegistryObject<Item> BROCCOLI = ITEMS.register("broccoli",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));
    public static final RegistryObject<Item> RAMEN = ITEMS.register("ramen",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));
    public static final RegistryObject<Item> RAMEN_PORK = ITEMS.register("ramen_pork",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));
    public static final RegistryObject<Item> RAMEN_BEEF = ITEMS.register("ramen_beef",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));
    public static final RegistryObject<Item> RAMEN_SHRIMPS = ITEMS.register("ramen_shrimps",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));
    public static final RegistryObject<Item> RAMEN_VEGI = ITEMS.register("ramen_vegi",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));
    public static final RegistryObject<Item> RED_GRAPES = ITEMS.register("red_grapes",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));
    public static final RegistryObject<Item> SPINACH = ITEMS.register("spinach",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));
    public static final RegistryObject<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));
    public static final RegistryObject<Item> RICE = ITEMS.register("rice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));
    public static final RegistryObject<Item> PAPRIKA_GREEN = ITEMS.register("paprika_green",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));

    //drinks
    public static final RegistryObject<Item> WINE_BOTTLE = ITEMS.register("wine_bottle",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3)
                    .saturationMod(0.2f).build())));

    //3d items
    public static final RegistryObject<Item> BAMBOO_STAFF = ITEMS.register("bamboo_staff",
            () -> new SwordItem(Tiers.NETHERITE, 15, 7f,
                    new Item.Properties()));
    public static final RegistryObject<Item> WAND_AIRSCEPTRE = ITEMS.register("wand_airsceptre",
            () -> new SwordItem(Tiers.NETHERITE, 15, 7f,
                    new Item.Properties()));
    public static final RegistryObject<Item> GENSAI_NECKLESS = ITEMS.register("gensai_neckless",
            () -> new ArmorItem(ModArmorMaterials.GENSAI_NECKLESS, ArmorItem.Type.HELMET,
                    new Item.Properties()));
    //GEAR
    //orc
    public static final RegistryObject<Item> ORC_SWORD = ITEMS.register("orc_sword",
            () -> new SwordItem(ModTier.ORC, 2, 3f,
                    new Item.Properties()));
    public static final RegistryObject<Item> ORC_AXE = ITEMS.register("orc_axe",
            () -> new AxeItem(ModTier.ORC, 1, 1f,
                    new Item.Properties()));
    public static final RegistryObject<Item> ORC_PICKAXE = ITEMS.register("orc_pickaxe",
            () -> new PickaxeItem(ModTier.ORC, 1, 1f,
                    new Item.Properties()));
    public static final RegistryObject<Item> ORC_HOE = ITEMS.register("orc_hoe",
            () -> new HoeItem(ModTier.ORC, 0, 0f,
                    new Item.Properties()));
    public static final RegistryObject<Item> ORC_SHOVEL = ITEMS.register("orc_shovel",
            () -> new ShovelItem(ModTier.ORC, 1, 1f,
                    new Item.Properties()));

    //man
    public static final RegistryObject<Item> MAN_SWORD = ITEMS.register("man_sword",
            () -> new SwordItem(ModTier.MAN, 2, 3f,
                    new Item.Properties()));
    public static final RegistryObject<Item> MAN_AXE = ITEMS.register("man_axe",
            () -> new AxeItem(ModTier.MAN, 1, 1f,
                    new Item.Properties()));
    public static final RegistryObject<Item> MAN_PICKAXE = ITEMS.register("man_pickaxe",
            () -> new PickaxeItem(ModTier.MAN, 1, 1f,
                    new Item.Properties()));
    public static final RegistryObject<Item> MAN_HOE = ITEMS.register("man_hoe",
            () -> new HoeItem(ModTier.MAN, 0, 0f,
                    new Item.Properties()));
    public static final RegistryObject<Item> MAN_SHOVEL = ITEMS.register("man_shovel",
            () -> new ShovelItem(ModTier.MAN, 1, 1f,
                    new Item.Properties()));

    /*public static final RegistryObject<Item> ONI_SAMURAI_BOSS_SPAWN_EGG = ITEMS.register("oni_samurai_boss_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityLoader.ONI_SAMURAI_BOSS,0x948e8d, 0x3b3635,
                    new Item.Properties()));*/

    public static final RegistryObject<Item> BATTLE_AXE = ITEMS.register("battle_axe",
            () -> new SwordItem(ModTier.MAN, 2, 3f,
                    new Item.Properties()));

    //Biblio craft items

    public static final RegistryObject<Item> ATLAS = ITEMS.register("atlas",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BIGBOOK = ITEMS.register("bigbook",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHASE = ITEMS.register("chase",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FRAMINGBOARD = ITEMS.register("framingboard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLIPBOARDSIMPLE = ITEMS.register("clipboardsimple",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FRAMINGAHEET = ITEMS.register("framingsheet",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HANDDRILL = ITEMS.register("handdrill",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LOCK = ITEMS.register("lock",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAPTOOL = ITEMS.register("maptool",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MONOCLE = ITEMS.register("monocle",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLATE = ITEMS.register("plate",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PLUMBLINE = ITEMS.register("plumbline",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RECIPEBOOK = ITEMS.register("recipebook",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAW = ITEMS.register("saw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STOCKCATALOG = ITEMS.register("stockcatalog",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TAPE = ITEMS.register("tape",
            () -> new Item(new Item.Properties()));

    //spawn eggs
    public static final RegistryObject<Item> RHINO_SPAWN_EGG = ITEMS.register("rhino_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityLoader.RHINO, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));
    /*public static final RegistryObject<Item> ONI_SPAWN_EGG = ITEMS.register("oni_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityLoader.SAMURAI_BOSS, 0x7e9680, 0xc5d1c5,
                    new Item.Properties()));*/
    public static final RegistryObject<Item> BOAR_SPAWN_EGG = ITEMS.register("boar_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityLoader.BOAR, 0x2d2834, 0x625c68,
                    new Item.Properties()));
    public static final RegistryObject<Item> ALLIGATOR_SPAWN_EGG = ITEMS.register("alligator_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityLoader.ALLIGATOR,   0x003900, 0x2D7234,
                    new Item.Properties()));
    public static final RegistryObject<Item> BADGER_SPAWN_EGG = ITEMS.register("badger_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityLoader.BADGER,   0x5B4638, 0x7C5F4C,
                    new Item.Properties()));


    //BlockItems
    // public static final RegistryObject<Item> REEDS = regBlockItem(BlockLoader.REEDS);


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    private static RegistryObject<Item> regBlockItem(RegistryObject<Block> blockSup){
        return regBlockItem(blockSup, (props) -> {

        });
    }

    private static RegistryObject<Item> regBlockItem(RegistryObject<Block> blockSup, Consumer<Item.Properties> extraPropsSetter){
        Item.Properties props = (new Item.Properties());
        extraPropsSetter.accept(props);
        return regArbitraryBlockItem(blockSup, (b) ->{
            return new EdumiaBlockItem(b, props);
        });
    }

    private static RegistryObject<Item> regArbitraryBlockItem(RegistryObject<Block> blockSup, Function<Block, ? extends BlockItem> itemMaker) {
        String name = blockSup.getId().getPath();
        return regItem(name, () -> {
            return (BlockItem) itemMaker.apply(blockSup.get());
        });
    }

    private static RegistryObject<Item> regItem(String name, Supplier<? extends  Item> sup) {
        RegistryObject<Item> item = ITEMS.register(name, sup);
        return item;
    }
}
