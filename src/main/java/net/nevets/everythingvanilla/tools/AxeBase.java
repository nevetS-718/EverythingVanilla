package net.nevets.everythingvanilla.tools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;
import net.nevets.everythingvanilla.Main;

public class AxeBase extends AxeItem {
    public AxeBase(ToolMaterial toolMaterial_1) {
        super(toolMaterial_1, 5, -3.0f, new Settings().group(Main.TOOLS));
    }
}
