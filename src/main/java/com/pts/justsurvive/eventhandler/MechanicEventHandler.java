package com.pts.justsurvive.eventhandler;

/*
    This class is used to handle events of all different mechanics
 */

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class MechanicEventHandler
{
    private boolean bleed = false;

    //This function is called, when the player enters a different chunk and determines, which biome the chunk belongs to
    //At this point in time this function in broken
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onTraverseChunk(PlayerEvent.EnteringChunk event)
    {
            String currentBiome = event.getEntity().getEntityWorld().getBiome(event.getEntity().
                    getPosition()).getBiomeName();

            System.out.println(currentBiome);
    }

    //this function is used to handle damage caused to the player, implement further types of damage here
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onPlayerStartBleeding(LivingHurtEvent event)
    {
        Random rand = new Random();

        if(event.getEntity() instanceof EntityPlayer)
        {
            String damageType = event.getSource().damageType;
            if(damageType.equals(DamageSource.CACTUS.toString()))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    bleed = true;

            }
            else if(damageType.equals(DamageSource.FALLING_BLOCK.toString()))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    bleed = true;
            }
            else if(damageType.equals(DamageSource.IN_WALL.toString()))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    bleed = true;
            }
            else if(damageType.equals("arrow"))
            {
                bleed = true;
            }
            else if(damageType.equals(DamageSource.causeThornsDamage(event.getEntity())))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    bleed = true;
            }
            else if(damageType.equals(DamageSource.causePlayerDamage((EntityPlayer) event.getEntity())))
            {
                bleed = true;
            }
            else if(damageType.equals(DamageSource.causeMobDamage(event.getEntityLiving())))
            {
                int rando = rand.nextInt(3);

                if(rando == 1)
                    bleed = true;
            }
        }
    }
}
