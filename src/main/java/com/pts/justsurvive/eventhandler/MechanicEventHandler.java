package com.pts.justsurvive.eventhandler;

/*
    This class is used to handle events of all different mechanics
 */

import com.pts.justsurvive.eventhandler.customevents.BleedEvent;
import com.pts.justsurvive.thread.BleedThread;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class MechanicEventHandler
{
    private Random rand = new Random();
    private BleedThread thread = new BleedThread("startBleeding");

    //This function is called, when the player enters a different chunk and determines, which biome the chunk belongs to
    //At this point in time this function in broken
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onTraverseChunk(EntityEvent.EnteringChunk event)
    {
        if(event.getEntity() instanceof EntityPlayer) {
            String currentBiome = event.getEntity().getEntityWorld().getBiome(event.getEntity().
                    getPosition()).getBiomeName();

            System.out.println(currentBiome);
        }
    }

    //this function is used to handle damage caused to the player, implement further types of damage here
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onPlayerStartBleeding(LivingHurtEvent event)
    {
        if(event.getEntity() instanceof EntityPlayer)
        {
            String damageType = event.getSource().damageType;

            //Damage caused by Cactus
            if(damageType.equals("cactus"))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    MinecraftForge.EVENT_BUS.post(new BleedEvent(thread));
            }
            //Damage caused by Falling Block
            else if(damageType.equals("fallingBlock"))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    MinecraftForge.EVENT_BUS.post(new BleedEvent(thread));
            }
            //Damage caused by stucking in wall
            else if(damageType.equals("inWall"))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    MinecraftForge.EVENT_BUS.post(new BleedEvent(thread));
            }
            //Damage caused by Arrow
            else if(damageType.equals("arrow"))
            {
                MinecraftForge.EVENT_BUS.post(new BleedEvent(thread));
            }
            //Damage caused by Thorns
            else if(damageType.equals("thorns"))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    MinecraftForge.EVENT_BUS.post(new BleedEvent(thread));
            }
            //Damage caused by other Player
            else if(damageType.equals("player"))
            {
                MinecraftForge.EVENT_BUS.post(new BleedEvent(thread));
            }
            //Damage caused by Mob
            else if(damageType.equals("mob"))
            {
                int rando = rand.nextInt(3);

                if(rando == 1)
                    MinecraftForge.EVENT_BUS.post(new BleedEvent(thread));
            }
            //Damage caused by explosion
            else if(damageType.equals("explosion"))
            {
                int rando = rand.nextInt(3);

                if(rando == 1)
                    MinecraftForge.EVENT_BUS.post(new BleedEvent(thread));
            }
            //Damage caused by fireball
            else if(damageType.equals("fireball"))
            {
                int rando = rand.nextInt(3);

                if(rando == 1)
                    MinecraftForge.EVENT_BUS.post(new BleedEvent(thread));
            }
            //Damage caused by anvil
            else if(damageType.equals("anvil"))
            {
                int rando = rand.nextInt(3);

                if(rando == 1)
                    MinecraftForge.EVENT_BUS.post(new BleedEvent(thread));
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void startBleeding(BleedEvent event)
    {
        event.onPlayerBleed();
    }
}
