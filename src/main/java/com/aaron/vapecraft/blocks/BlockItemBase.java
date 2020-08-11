package com.aaron.vapecraft.blocks;

import com.aaron.vapecraft.VapeCraft;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

// This is actually about the item for the block.

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(VapeCraft.TAB));
    }
}
