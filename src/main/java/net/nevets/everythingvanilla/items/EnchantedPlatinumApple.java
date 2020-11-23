package net.nevets.everythingvanilla.items;

import net.minecraft.item.Item;

public class EnchantedPlatinumApple extends Item {

    public EnchantedPlatinumApple(Settings settings) {
        super(settings);
    }
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
    
}
