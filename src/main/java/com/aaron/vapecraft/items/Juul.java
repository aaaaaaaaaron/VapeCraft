package com.aaron.vapecraft.items;

import com.aaron.vapecraft.VapeCraft;
import net.minecraft.item.Item;


// This is for my juul with pod item.
public class Juul extends Item {

    public Juul() {
        super(new Item.Properties().
                group(VapeCraft.TAB).
                maxStackSize(1).
                defaultMaxDamage(5));
    }

    @Override
    public static void onItemRightClick() {
        this.damageItem();
    }

}
