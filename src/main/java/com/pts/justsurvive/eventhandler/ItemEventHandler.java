package com.pts.justsurvive.eventhandler;

import com.pts.justsurvive.management.items.ManageItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/*
    This class is used to handle all Events for Items
 */

public class ItemEventHandler
{
    //This Method is called when a Player Rightclicks with an Item in Hand
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onHealthItemIsUsed(PlayerInteractEvent.RightClickItem event)
    {
        EntityPlayer p = event.getEntityPlayer();

        if(p.getHeldItemMainhand().getItem() == ManageItems.ITEM_BANDAGE)
        {
            System.out.println("Banadage used");
            p.getHeldItemMainhand().setCount(p.getHeldItemMainhand().getCount() - 1);
        }
        else if(p.getHeldItemMainhand().getItem() == ManageItems.ITEM_ADRENALIN)
        {
            System.out.println("Adrenalin used");
            p.getHeldItemMainhand().setCount(p.getHeldItemMainhand().getCount() - 1);
        }
        else if(p.getHeldItemMainhand().getItem() == ManageItems.ITEM_ANTIBIOTICS)
        {
            System.out.println("Antibiotics used");
            p.getHeldItemMainhand().setCount(p.getHeldItemMainhand().getCount() - 1);
        }
        else if(p.getHeldItemMainhand().getItem() == ManageItems.ITEM_SPLINT)
        {
            System.out.println("Splint used");
            p.getHeldItemMainhand().setCount(p.getHeldItemMainhand().getCount() - 1);
        }
    }
}
