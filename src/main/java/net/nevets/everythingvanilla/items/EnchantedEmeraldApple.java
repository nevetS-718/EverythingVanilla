package net.nevets.everythingvanilla.items;

import net.minecraft.item.Item;

public class EnchantedEmeraldApple extends Item {

    public EnchantedEmeraldApple(Settings settings) {

        super(settings);

    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
        
}
