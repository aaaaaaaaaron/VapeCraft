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

    public static int tickSum = 0;

    private static int secondsToDamage = 20;

    public static void resetAddiction() {
        tickSum = 0;
    }

    @SubscribeEvent
    public static void beAddictedClient(TickEvent.PlayerTickEvent event) {

        tickSum++;

        // From what I have seen there are 80 ticks in a second
        if (tickSum==80*secondsToDamage) {
            VapeCraft.LOGGER.info("applying damage from addiction");
            event.player.attackEntityFrom(DamageSource.STARVE, 1.0F);
        tickSum = 0;
        }
    }

}
