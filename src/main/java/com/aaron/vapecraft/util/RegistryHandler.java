package com.aaron.vapecraft.util;

// I am writing all of this code by the way!

import com.aaron.vapecraft.VapeCraft;
import com.aaron.vapecraft.blocks.BlockItemBase;
import com.aaron.vapecraft.blocks.NicotineOre;
import com.aaron.vapecraft.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VapeCraft.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, VapeCraft.MOD_ID);


    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> JUUL = ITEMS.register("juul", ItemBase::new);
    public static final RegistryObject<Item> NICOTINE_SALT = ITEMS.register("nicotine_salt", ItemBase::new);

    // Blocks
    public static final RegistryObject<Block> NICOTINE_ORE = BLOCKS.register("nicotine_ore", NicotineOre::new);

    // Block Items
    public static final RegistryObject<Item> NICOTINE_ORE_ITEM = ITEMS.register("nicotine_ore", () -> new BlockItemBase(NICOTINE_ORE.get()));


}
