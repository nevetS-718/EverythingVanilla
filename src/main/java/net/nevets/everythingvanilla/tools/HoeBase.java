package net.nevets.everythingvanilla.tools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;
import net.nevets.everythingvanilla.Main;

public class HoeBase extends HoeItem {
    public HoeBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, -3, 0f, new Settings().group(Main.ALL));
    }
}
