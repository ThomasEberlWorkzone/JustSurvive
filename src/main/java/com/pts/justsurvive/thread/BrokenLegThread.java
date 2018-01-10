package com.pts.justsurvive.thread;

import com.pts.justsurvive.mechanics.BrokenLeg;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;

public class BrokenLegThread extends Thread
{
    private EntityPlayer player;
    private final double BROKEN_LEG_MOVEMENT_SPEED = 0.05f;

    public BrokenLegThread(String name)
    {
        super(name);
    }

    public void start()
    {
        setDaemon(false);
        super.start();
    }

    public void setPlayer(EntityPlayer player)
    {
        this.player = player;
    }

    public void run()
    {
        BrokenLeg.getInstance().setLegStateChanged(true);
        System.out.println("Player leg broken");
        try
        {
            while(!currentThread().isInterrupted())
            {
               player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(BROKEN_LEG_MOVEMENT_SPEED);
               Thread.sleep(10);
            }
        }
        catch (InterruptedException e)
        {
            BrokenLeg.getInstance().setLegStateChanged(false);
            System.out.println("Broken Leg Thread interrupted");
        }
    }
}
