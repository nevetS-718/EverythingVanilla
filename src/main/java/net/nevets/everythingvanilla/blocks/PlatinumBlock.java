package net.nevets.everythingvanilla.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class PlatinumBlock extends Block {
    public PlatinumBlock() {
        super(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.METAL).strength(30, 1000f));
    }
}
