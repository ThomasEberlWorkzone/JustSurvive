package com.pts.justsurvive.eventhandler;

import com.pts.justsurvive.management.items.ManageItems;
import com.pts.justsurvive.mechanics.Bleed;
import com.pts.justsurvive.thread.AdrenalinSpeedThread;
import com.pts.justsurvive.thread.BleedThread;
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
    private AdrenalinSpeedThread thread;

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

            thread = new AdrenalinSpeedThread("startAdrenalineRush");

            double speed = p.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue();

            if(thread.isAlive() == false)
            {
                thread.setPlayer(p);
                thread.start();
            }
//            else
//                p.onDeath(DamageSource.GENERIC);
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
