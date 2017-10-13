package com.pts.justsurvive.eventhandler;

import com.pts.justsurvive.management.items.ManageItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
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
    public void onBandageIsUsed(PlayerInteractEvent.RightClickItem event)
    {
        EntityPlayer p = event.getEntityPlayer();

        if(p.getHeldItemMainhand().getItem() == ManageItems.ITEM_BANDAGE)
        {
            System.out.println("Banadage used");
            p.getHeldItemMainhand().setCount(p.getHeldItemMainhand().getCount() - 1);
        }
    }
}
