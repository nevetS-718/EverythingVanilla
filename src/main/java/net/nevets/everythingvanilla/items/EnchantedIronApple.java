package net.nevets.everythingvanilla.items;

import net.minecraft.item.Item;

public class EnchantedIronApple extends Item {

    public EnchantedIronApple(Settings settings) {

        super(settings);
    }
    
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
    
}
