package com.pts.justsurvive.thread;

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
        float speed = player.getAIMoveSpeed();
        try
        {
            while(!currentThread().isInterrupted())
            {
                //ToDo: https://stackoverflow.com/questions/19254433/best-method-to-pause-a-thread
                player.setAIMoveSpeed(speed * 1.5f);
                this.sleep(10000);
                player.setAIMoveSpeed(speed);
                Thread.currentThread().interrupt();
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Error in AdrenalinSpeedThread:run(), Message:  " + e.getMessage().toString());
        }
    }
}
