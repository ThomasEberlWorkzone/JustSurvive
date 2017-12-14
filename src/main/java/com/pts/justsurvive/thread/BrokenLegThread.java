package com.pts.justsurvive.thread;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;

public class BrokenLegThread extends Thread
{
    private EntityPlayer player;
    private final double BROKEN_LEG_MOVEMENT_SPEED = 0.5f;

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
            System.out.println("Broken Leg Thread interrupted");
        }
    }
}
