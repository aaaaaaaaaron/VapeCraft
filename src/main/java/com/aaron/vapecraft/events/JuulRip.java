package com.aaron.vapecraft.events;

import com.aaron.vapecraft.VapeCraft;
import com.aaron.vapecraft.util.RegistryHandler;
import com.google.common.eventbus.Subscribe;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
public class JuulRip {

    @SubscribeEvent
    public static void juulRip(PlayerInteractEvent.RightClickItem event) {
        Random rand = new Random();
        LivingEntity player = event.getEntityLiving();
        Item mainHand = player.getHeldItemMainhand().getItem();
        if (mainHand == RegistryHandler.JUUL_WITH_POD.get()) {
            NicotineAddiction.resetAddiction(); // resets the addiction timer to zero

//            mainHand.setDamage(new ItemStack(0,0), 1);

            World worldIn = event.getWorld();

            double p0 = player.getPosX();
            double p1 = player.getPosY() + player.getEyeHeight() - .1D;
            double p2 = player.getPosZ();
            Vector3d lookVec = player.getLookVec(); // gets where the player is looking
            Vector3d fwrd = player.getMotion(); // gets how fast the player is going
            for (int i = 0; i < 9; i++) {
                double r0 = rand.nextDouble()/3 - 1d/6d;
                double r1 = rand.nextDouble()/3 - 1d/6d;
                double r2 = rand.nextDouble()/3 - 1d/6d;
                worldIn.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, p0, p1, p2,
                        (lookVec.x + r0)/6 + fwrd.x/8, (lookVec.y + r1)/6 + fwrd.y/8, (lookVec.z + r2)/6 + fwrd.z/8);
            }
        }
    }

}
