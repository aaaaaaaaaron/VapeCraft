package com.aaron.vapecraft.events;

import com.aaron.vapecraft.VapeCraft;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = VapeCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class NicotineAddiction {

    private static int tickSum;

    private static int secondsToDamage = 20;

//    @SubscribeEvent
//    public static void beAddicted(TickEvent.ServerTickEvent event) {
//
//        tickSum++;
//
//        if (tickSum==20*secondsToDamage) {
//            VapeCraft.LOGGER.info("It has been 20 seconds");
//            event.
//        }
//
//    }

    @SubscribeEvent
    public static void beAddictedClient(TickEvent.PlayerTickEvent event) {

        tickSum++;

        if (tickSum==20*secondsToDamage) {
            VapeCraft.LOGGER.info("applying damage from addiction")
            event.player.attackEntityFrom(DamageSource.DROWN, 1.0F)
        tickSum = 0;
        }
    }

}
