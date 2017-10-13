package com.pts.justsurvive.eventhandler;

/*
    This class is used to handle events of all different mechanics
 */

import net.minecraft.advancements.critereon.EntityHurtPlayerTrigger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MechanicEventHandler
{
    private final String DAMAGE_FALL = "fall";
    private final String DAMAGE_ZOMBIE = "mob";
    private final String DAMAGE_SKELETON = "arrow";

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onEntryToColdBiome(LivingEvent.LivingUpdateEvent event)
    {

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
