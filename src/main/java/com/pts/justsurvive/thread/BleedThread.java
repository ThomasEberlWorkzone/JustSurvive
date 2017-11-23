package com.pts.justsurvive.thread;

import com.pts.justsurvive.mechanics.Bleed;

public class BleedThread extends Thread
{
    public BleedThread(String name)
    {
        super(name);
    }

    @Override
    public void start()
    {
        System.out.println("Thread wurde gestartet!");
        this.setDaemon(false);
        super.start();
    }

    @Override
    public void run()
    {
        System.out.println("run() head: " + this.isAlive());

        try
        {
            while(!currentThread().isInterrupted())
            {
                this.sleep(5000);

                System.out.println("Blood before: " + Bleed.getInstance().getBloodAmount());
                Bleed.getInstance().setBloodAmount(Bleed.getInstance().getBloodAmount() - 1f);
                System.out.println("Blood afterwards: " + Bleed.getInstance().getBloodAmount());
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Error in BleedThread:run(), Message:  " + e.getMessage().toString());
        }
    }
}
