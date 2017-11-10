package com.pts.justsurvive.eventhandler.customevents;

import net.minecraftforge.fml.common.eventhandler.Event;

public class BleedEvent extends Event
{
    public BleedEvent()
    {
        System.out.println("Constructor of BleedEvent called!");
    }

    public String test()
    {
        return "test";
    }
}
