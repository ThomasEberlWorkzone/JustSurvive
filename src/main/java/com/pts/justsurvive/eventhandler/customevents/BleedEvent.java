package com.pts.justsurvive.eventhandler.customevents;

import com.pts.justsurvive.thread.BleedThread;
import net.minecraftforge.fml.common.eventhandler.Event;

public class BleedEvent extends Event
{
    public BleedEvent()
    {
        System.out.println("Constructor of BleedEvent called!");
    }

    public void onPlayerBleed()
    {
        try
        {
            BleedThread thread = new BleedThread("startBleeding");
            thread.start();
        }
        catch (Exception e)
        {
            System.out.println("Error in Class BleedEvent: " + e.getMessage().toString());
        }
    }
}
