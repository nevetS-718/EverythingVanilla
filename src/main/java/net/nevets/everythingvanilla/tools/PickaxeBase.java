package net.nevets.everythingvanilla.tools;

import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.nevets.everythingvanilla.Main;

public class PickaxeBase extends PickaxeItem {
    public PickaxeBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1, -2.8f, new Item.Settings().group(Main.ALL));
    }
}
