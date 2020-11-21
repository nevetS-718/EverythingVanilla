package net.nevets.everythingvanilla.tools;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.nevets.everythingvanilla.Main;

public class ShovelBase extends ShovelItem {
    public ShovelBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 1, -3f, new Settings().group(Main.TOOLS));
    }
}
