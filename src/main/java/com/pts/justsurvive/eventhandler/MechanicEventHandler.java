package com.pts.justsurvive.eventhandler;

/*
    This class is used to handle events of all different mechanics
 */

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MechanicEventHandler
{
    private final String DAMAGE_FALL = "fall";
    private final String DAMAGE_ZOMBIE = "mob";
    private final String DAMAGE_SKELETON = "arrow";

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
    public void onPlayerHurt(LivingHurtEvent event)
    {
        if(event.getEntity() instanceof EntityPlayer)
        {
            String damageType = event.getSource().damageType;
            if(damageType.equals(DAMAGE_FALL))
            {
                //calculate chance of broken leg
            }
            else if(damageType.equals(DAMAGE_ZOMBIE))
            {
                //calculate chance of bleeding and infection
            }
            else if(damageType.equals(DAMAGE_SKELETON))
            {
                //calculate chance of bleeding
            }
        }
    }

}
