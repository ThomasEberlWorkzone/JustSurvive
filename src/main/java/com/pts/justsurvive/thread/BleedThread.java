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
        //this.setDaemon(true);
        //this.run();
    }

    @Override
    public void run()
    {
        while(true)
        {

        }
    }
}
