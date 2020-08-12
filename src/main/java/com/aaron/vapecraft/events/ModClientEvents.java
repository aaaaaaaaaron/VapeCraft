package com.aaron.vapecraft.events;

import com.aaron.vapecraft.VapeCraft;
import com.aaron.vapecraft.util.RegistryHandler;
import com.google.common.eventbus.Subscribe;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;

import java.util.Random;

// I might want to change Dist.CLIENT to Dist.Server when making vaping a social hobby. (ie making it online)
@Mod.EventBusSubscriber(modid = VapeCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void juulRip(PlayerInteractEvent.RightClickItem event) {
        Random rand = new Random();
        LivingEntity player = event.getEntityLiving();
        if (player.getHeldItemMainhand().getItem() == RegistryHandler.JUUL_WITH_POD.get()) {
            // VapeCraft.LOGGER.info("juul rip!");
            World worldIn = event.getWorld();

            double p0 = player.getPosX();
            double p1 = player.getPosY() + player.getEyeHeight() - .1D;
            double p2 = player.getPosZ();
            Vector3d lookVec = player.getLookVec();
            for (int i = 0; i < 9; i++) {
                double r0 = rand.nextDouble()/3 - 1d/6d;
                double r1 = rand.nextDouble()/3 - 1d/6d;
                double r2 = rand.nextDouble()/3 - 1d/6d;
                worldIn.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, p0, p1, p2, (lookVec.x + r0)/6, (lookVec.y + r1)/6, (lookVec.z + r2)/6);
            }
        }
    }

}
