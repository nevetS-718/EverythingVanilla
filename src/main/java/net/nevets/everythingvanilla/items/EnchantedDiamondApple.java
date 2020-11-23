package net.nevets.everythingvanilla.items;

import net.minecraft.item.Item;

public class EnchantedDiamondApple extends Item {

    public EnchantedDiamondApple(Settings settings) {

        super(settings);

    }

    public boolean hasGlint(ItemStack item) {
        return true;
    }
    
}
