package com.pts.justsurvive.thread;

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
        while(true)
        {
            
        }
    }
}
