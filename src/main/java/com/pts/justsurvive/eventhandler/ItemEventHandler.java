package com.pts.justsurvive.eventhandler;

import com.pts.justsurvive.management.items.ManageItems;
import com.pts.justsurvive.mechanics.Bleed;
import com.pts.justsurvive.thread.AdrenalinSpeedThread;
import com.pts.justsurvive.thread.BleedThread;
import com.pts.justsurvive.thread.BrokenLegThread;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/*
    This class is used to handle all Events for Items
 */

public class ItemEventHandler
{
    public static AdrenalinSpeedThread adrenalinThread = new AdrenalinSpeedThread("startAdrenalinRush");

    //This Method is called when a Player Rightclicks with an Item in Hand
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onHealthItemIsUsed(PlayerInteractEvent.RightClickItem event)
    {
        EntityPlayer p = event.getEntityPlayer();

        if(p.getHeldItemMainhand().getItem() == ManageItems.ITEM_BANDAGE)
        {
            System.out.println("Banadage used");
            p.getHeldItemMainhand().setCount(p.getHeldItemMainhand().getCount() - 1);

            if(MechanicEventHandler.thread.isAlive())
            {
                MechanicEventHandler.thread.interrupt();
                MechanicEventHandler.thread = new BleedThread("bleedThread");
            }
        }
        else if(p.getHeldItemMainhand().getItem() == ManageItems.ITEM_ADRENALIN)
        {
            System.out.println("Adrenalin used");
            p.getHeldItemMainhand().setCount(p.getHeldItemMainhand().getCount() - 1);

            adrenalinThread = new AdrenalinSpeedThread("startAdrenalineRush");

            if(adrenalinThread.isAlive() == false)
            {
                adrenalinThread.setPlayer(p);
                adrenalinThread.start();
            }
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

            if(MechanicEventHandler.brokenLegThread.isAlive()) {
                MechanicEventHandler.brokenLegThread.interrupt();
                MechanicEventHandler.brokenLegThread = new BrokenLegThread("BrokenLeg");
            }

        }
    }
}
