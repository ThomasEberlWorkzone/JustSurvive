package com.pts.justsurvive.thread;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;

public class AdrenalinSpeedThread extends Thread
{
    private EntityPlayer player;

    public AdrenalinSpeedThread(String name)
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
        int counter = 0;
        try
        {
            while(counter < 1000)
            {
                player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.7D);
                this.sleep(10);
                counter++;
                System.out.println(counter);
            }
            System.out.println("10 sek vorbei");
            Thread.currentThread().interrupt();
        }
        catch (InterruptedException e)
        {
            System.out.println("Error in AdrenalinSpeedThread:run(), Message:  " + e.getMessage().toString());
        }
    }
}
