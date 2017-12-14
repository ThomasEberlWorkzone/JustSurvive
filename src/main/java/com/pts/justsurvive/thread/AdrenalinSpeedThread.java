package com.pts.justsurvive.thread;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;

import java.util.concurrent.atomic.AtomicBoolean;

public class AdrenalinSpeedThread extends Thread
{
    private EntityPlayer player;
    private final AtomicBoolean pauseFlag = new AtomicBoolean(false);
    private boolean isPaused = false;

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
                if(pauseFlag.get())
                {
                    synchronized (pauseFlag)
                    {
                        while(pauseFlag.get())
                        {
                            pauseFlag.wait();
                        }
                    }
                }
                else
                {
                    player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.8D);
                    counter++;
                    currentThread().sleep(10);
                }
            }
            System.out.println("10 sek vorbei");
            Thread.currentThread().interrupt();
        }
        catch (InterruptedException e)
        {
            System.out.println("Error in AdrenalinSpeedThread:run(), Message:  " + e.getMessage().toString());
        }
    }

    public void pauseThread()
    {
        pauseFlag.set(true);
        isPaused = true;
    }

    public void resumeThread()
    {
        pauseFlag.set(false);
        synchronized (pauseFlag)
        {
            pauseFlag.notify();
        }

        isPaused = false;
    }

    public boolean isThreadPaused()
    {
        return isPaused;
    }
}
