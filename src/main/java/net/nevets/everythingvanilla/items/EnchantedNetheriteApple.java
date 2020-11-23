package net.nevets.everythingvanilla.items;

import net.minecraft.item.Item;

public class EnchantedNetheriteApple extends Item {

  public EnchantedNetheriteApple(Settings settings) {
    super(settings);
  }
  
  public boolean hasGlint(ItemStack stack) {
    return true;
  }
  
}
