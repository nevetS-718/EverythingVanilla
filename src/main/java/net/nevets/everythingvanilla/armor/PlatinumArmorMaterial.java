package net.nevets.everythingvanilla.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.nevets.everythingvanilla.Main;

public class PlatinumArmorMaterial implements ArmorMaterial {

    private static final int[] BASE_DURABILITY = new int[] {15, 17, 18, 13};
    private static final int[] PROTECTION_AMOUNTS = new int[] {6, 8, 10, 6};

    public int getDurability(EquipmentSlot arg0) {
        return BASE_DURABILITY[arg0.getEntitySlotId()]*25;
    }

    public int getProtectionAmount(EquipmentSlot arg0) {
        return PROTECTION_AMOUNTS[arg0.getEntitySlotId()];
    }

    public int getEnchantability() {
        return 40;
    }

    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Main.PLATINUMINGOT);
    }

    public String getName() {
        return "platinum";
    }

    public float getToughness() {
        return 1f;
    }

    public float getKnockbackResistance() {
        return 0.5f;
    }
}