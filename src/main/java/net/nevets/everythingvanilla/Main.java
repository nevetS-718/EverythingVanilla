package net.nevets.everythingvanilla;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nevets.everythingvanilla.armor.BaseArmor;
import net.nevets.everythingvanilla.armor.EmeraldArmorMaterial;
import net.nevets.everythingvanilla.blocks.GoldNetheriteBlock;
import net.nevets.everythingvanilla.blocks.PlatinumOre;
import net.nevets.everythingvanilla.items.CookedVillagerMeat;
import net.nevets.everythingvanilla.items.PlatinumIngot;
import net.nevets.everythingvanilla.items.RawVillagerMeat;
import net.nevets.everythingvanilla.tools.*;

public class Main implements ModInitializer {

    //Creative Tab
    public static final ItemGroup ALL = FabricItemGroupBuilder.build(
            new Identifier("vanilla", "all"),
            () -> new ItemStack((Items.GRASS_BLOCK)));

    public static final Block GOLDNETHERITEBLOCK = new GoldNetheriteBlock();
    public static final Item RAWVILLAGERMEAT = new RawVillagerMeat(new Item.Settings().group(Main.ALL).food(new FoodComponent.Builder().hunger(3).saturationModifier(1.8f).meat().statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 20*1000000), 0.1f).build()));
    public static final Item COOKEDVILLAGERMEAT = new CookedVillagerMeat(new Item.Settings().group(Main.ALL).food(new FoodComponent.Builder().hunger(7).saturationModifier(10f).meat().statusEffect(new StatusEffectInstance(StatusEffects.BAD_OMEN, 20*1000000), 0.1f).build()));
    public static final ArmorMaterial EMERALD_ARMOR = new EmeraldArmorMaterial();
    public static final Item PLATINUMINGOT = new PlatinumIngot(new Item.Settings().group(Main.ALL));
    public static final Block PLATINUMORE = new PlatinumOre();

    public void onInitialize() {
        //Blocks
        Registry.register(Registry.BLOCK, new Identifier("vanilla", "gold_infused_netherite_block"), GOLDNETHERITEBLOCK);
        Registry.register(Registry.BLOCK, new Identifier("vanilla", "platinum_ore"), PLATINUMORE);
        //Items
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_ingot"), PLATINUMINGOT);
        Registry.register(Registry.ITEM, new Identifier("vanilla", "platinum_ore"), new BlockItem(PLATINUMORE, new Item.Settings().group(Main.ALL)));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "gold_infused_netherite_block"), new BlockItem(GOLDNETHERITEBLOCK, new Item.Settings().group(Main.ALL)));
        //Tools
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_pickaxe"), new PickaxeBase(new EmeraldToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_axe"), new AxeBase(new EmeraldToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_shovel"), new ShovelBase(new EmeraldToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_hoe"), new HoeBase(new EmeraldToolMaterial()));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_sword"), new SwordBase(new EmeraldToolMaterial()));
        //Armor
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_helmet"), new BaseArmor(EMERALD_ARMOR, EquipmentSlot.HEAD));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_chestplate"), new BaseArmor(EMERALD_ARMOR, EquipmentSlot.CHEST));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_leggings"), new BaseArmor(EMERALD_ARMOR, EquipmentSlot.LEGS));
        Registry.register(Registry.ITEM, new Identifier("vanilla", "emerald_boots"), new BaseArmor(EMERALD_ARMOR, EquipmentSlot.FEET));
        //Food
        Registry.register(Registry.ITEM, new Identifier("vanilla", "raw_villager_meat"), RAWVILLAGERMEAT);
        Registry.register(Registry.ITEM, new Identifier("vanilla", "cooked_villager_meat"), COOKEDVILLAGERMEAT);
    }
}
