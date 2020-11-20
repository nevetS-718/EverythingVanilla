package net.nevets.everythingvanilla.tools;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.nevets.everythingvanilla.Main;

public class PlatinumToolMaterial implements ToolMaterial {

    public int getDurability() {
        return 3000;
    }

    public float getMiningSpeedMultiplier() {
        return 10.0f;
    }

    public float getAttackDamage() {
        return 6f;
    }

    public int getMiningLevel() {
        return 4;
    }

    public int getEnchantability() {
        return 40;
    }

    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Main.PLATINUMINGOT);
    }
}

