package com.pts.justsurvive.mechanics;

public class BrokenLeg
{
    private static BrokenLeg myInstance = null;

    private boolean legBroken = false;

    private BrokenLeg()
    {

    }

    public static BrokenLeg getInstance()
    {
        if(myInstance == null)
            myInstance = new BrokenLeg();

        return myInstance;
    }

    public boolean getLegBroken()
    {
        return legBroken;
    }

    public void setLegStateChanged(boolean newState)
    {
        legBroken = newState;
    }


}
