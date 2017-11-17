package com.pts.justsurvive.eventhandler.customevents;

import com.pts.justsurvive.thread.BleedThread;
import net.minecraftforge.fml.common.eventhandler.Event;

public class BleedEvent extends Event
{
    private final BleedThread thread;

    public BleedEvent(BleedThread thread)
    {
        System.out.println("Constructor of BleedEvent called!");
        this.thread = thread;
    }

    public void onPlayerBleed()
    {
        try
        {
            if(thread.isAlive() == false)
                thread.start();
        }
        catch (Exception e)
        {
            System.out.println("Error in Class BleedEvent: " + e.getMessage().toString());
        }
    }
}
