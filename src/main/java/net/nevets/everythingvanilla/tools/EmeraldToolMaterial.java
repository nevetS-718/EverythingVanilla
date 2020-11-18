package net.nevets.everythingvanilla.tools;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EmeraldToolMaterial implements ToolMaterial {

    public int getDurability() {
        return 750;
    }

    public float getMiningSpeedMultiplier() {
        return 7.0f;
    }

    public float getAttackDamage() {
        return 4f;
    }

    public int getMiningLevel() {
        return 3;
    }

    public int getEnchantability() {
        return 30;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.EMERALD);
    }
}
