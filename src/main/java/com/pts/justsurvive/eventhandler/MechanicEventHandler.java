package com.pts.justsurvive.eventhandler;

/*
    This class is used to handle events of all different mechanics
 */

import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MechanicEventHandler
{
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onEntryToColdBiome(LivingEvent.LivingUpdateEvent event)
    {

    }
}
