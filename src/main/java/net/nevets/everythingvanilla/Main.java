package net.nevets.everythingvanilla;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.nevets.everythingvanilla.armor.BaseArmor;
import net.nevets.everythingvanilla.armor.EmeraldArmorMaterial;
import net.nevets.everythingvanilla.armor.PlatinumArmorMaterial;
import net.nevets.everythingvanilla.blocks.GoldNetheriteBlock;
import net.nevets.everythingvanilla.blocks.PlatinumOre;
import net.nevets.everythingvanilla.blocks.PlatinumBlock;
import net.nevets.everythingvanilla.items.CookedVillagerMeat;
import net.nevets.everythingvanilla.items.PlatinumIngot;
import net.nevets.everythingvanilla.items.PlatinumNugget;
import net.nevets.everythingvanilla.items.RawVillagerMeat;
import net.nevets.everythingvanilla.items.IronApple;
import net.nevets.everythingvanilla.tools.*;

public class Main implements ModInitializer {

    //Creative Tab
    public static final ItemGroup ALL = FabricItemGroupBuilder.build(
            new Identifier("vanilla", "all"),
            () -> new ItemStack((Items.GRASS_BLOCK)));
    //Combat Tab
    public static final ItemGroup COMBAT = FabricItemGroupBuilder.build(
            new Identifier("vanilla", "combat"),
            () -> new ItemStack((Items.DIAMOND_SWORD)));
    //Tools Tab
    public static final ItemGroup TOOLS = FabricItemGroupBuilder.build(
            new Identifier("vanilla", "tools"),
            () -> new ItemStack((Items.DIAMOND_PICKAXE)));
    //Food Tab
    public static final ItemGroup FOOD = FabricItemGroupBuilder.build(
            new Identifier("vanilla", "food"),
            () -> new ItemStack((Main.COOKEDVILLAGERMEAT)));

    public static final Block GOLDNETHERITEBLOCK = new GoldNetheriteBlock();
    public static final Item RAWVILLAGERMEAT = new RawVillagerMeat(new Item.Settings().group(Main.FOOD).food(new FoodComponent.Builder().hunger(3).saturationModifier(1.8f).meat().statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 20*1000000), 0.1f).build()));
    public static final Item COOKEDVILLAGERMEAT = new CookedVillagerMeat(new Item.Settings().group(Main.FOOD).food(new FoodComponent.Builder().hunger(7).saturationModifier(10f).meat().statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 20*1000000), 0.1f).build()));
    public static final ArmorMaterial EMERALD_ARMOR = new EmeraldArmorMaterial();
    public static final Item PLATINUMINGOT = new PlatinumIngot(new Item.Settings().group(Main.ALL));
    public static final Block PLATINUMORE = new PlatinumOre();
    public static final Item PLATINUMNUGGET = new PlatinumNugget(new Item.Settings().group(Main.ALL));
    public static final Block PLATINUMBLOCK = new PlatinumBlock();
    public static final ArmorMaterial PLATINUM_ARMOR = new PlatinumArmorMaterial();
    public static final IRONAPPLE = new IronApple();

    //Platinum Ore Generation
    private static ConfiguredFeature<?, ?> ORE_PLATINUM_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    Main.PLATINUMORE.getDefaultState(),
                    1)) //vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0, //bottom offset
                    7, //min y level
                    12))) //max y level
            .spreadHorizontally()
            .repeat(1); //number of veins per chunk

    @Override
    public void onInitialize() {
        //Blocks
        Registry.register(Registry.BLOCK, new Identifier("vanilla", "gold_infused_netherite_block"), GOLDNETHERITEBLOCK);
        Registry.register(Registry.BLOCK, new Identifier("vanilla", "platinum_ore"), PLATINUMORE);
        Registry.register(Registry.BLOCK, new Identifier("vanilla", "platinum_block"), PLATINUMBLOCK);
        //Items
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_ingot"), PLATINUMINGOT);
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_ore"), new BlockItem(PLATINUMORE, new Item.Settings().group(Main.ALL)));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "gold_infused_netherite_block"), new BlockItem(GOLDNETHERITEBLOCK, new Item.Settings().group(Main.ALL)));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_nugget"), PLATINUMNUGGET);
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_block"), new BlockItem(PLATINUMBLOCK, new Item.Settings().group(Main.ALL)));
        //Tools
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_pickaxe"), new PickaxeBase(new EmeraldToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_axe"), new AxeBase(new EmeraldToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_shovel"), new ShovelBase(new EmeraldToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_hoe"), new HoeBase(new EmeraldToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_sword"), new SwordBase(new EmeraldToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_pickaxe"), new PickaxeBase(new PlatinumToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_axe"), new AxeBase(new PlatinumToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_shovel"), new ShovelBase(new PlatinumToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_hoe"), new HoeBase(new PlatinumToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_sword"), new SwordBase(new PlatinumToolMaterial()));
        //Armor
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_helmet"), new BaseArmor(EMERALD_ARMOR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_chestplate"), new BaseArmor(EMERALD_ARMOR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_leggings"), new BaseArmor(EMERALD_ARMOR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_boots"), new BaseArmor(EMERALD_ARMOR, EquipmentSlot.FEET));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_helmet"), new BaseArmor(PLATINUM_ARMOR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_chestplate"), new BaseArmor(PLATINUM_ARMOR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_leggings"), new BaseArmor(PLATINUM_ARMOR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_boots"), new BaseArmor(PLATINUM_ARMOR, EquipmentSlot.FEET));
        //Food
        Registry.register(Registry.ITEM, new Identifier("vanilla", "raw_villager_meat"), RAWVILLAGERMEAT);
        Registry.register(Registry.ITEM, new Identifier("vanilla", "cooked_villager_meat"), COOKEDVILLAGERMEAT);
        Registry.register(Registry.ITEM, new Identifier("vanilla", "iron_apple"), IRONAPPLE);
        //Ore Generation
        RegistryKey<ConfiguredFeature<?, ?>> orePlatinumOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("vanilla", "ore_platinum_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, orePlatinumOverworld.getValue(), ORE_PLATINUM_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, orePlatinumOverworld);
    }
}
