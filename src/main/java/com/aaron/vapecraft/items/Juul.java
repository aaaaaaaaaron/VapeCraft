package com.aaron.vapecraft.items;

import com.aaron.vapecraft.VapeCraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


// This is for my juul with pod item.
public class Juul extends Item {

    public Juul() {
        super(new Item.Properties().
                group(VapeCraft.TAB).
                maxStackSize(1).
                defaultMaxDamage(200)); // 200 rips!
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.getHeldItemMainhand().damageItem(1, playerIn, e -> e.sendBreakAnimation(handIn));
        return ActionResult.resultSuccess(playerIn.getHeldItemMainhand());
    }

}
