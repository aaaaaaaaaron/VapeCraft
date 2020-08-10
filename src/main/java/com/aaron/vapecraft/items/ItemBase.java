package com.aaron.vapecraft.items;

import com.aaron.vapecraft.VapeCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase() {
        super(new Item.Properties().group(VapeCraft.TAB));
    }
}
