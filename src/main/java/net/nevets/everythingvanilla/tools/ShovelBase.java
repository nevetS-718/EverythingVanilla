package net.nevets.everythingvanilla.tools;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.nevets.everythingvanilla.Main;

public class SwordBase extends SwordItem {
    public SwordBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 3, -2.4f, new Settings().group(Main.COMBAT));
    }
}
