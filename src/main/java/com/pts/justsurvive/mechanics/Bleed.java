package com.pts.justsurvive.mechanics;

public class Bleed
{
    private static Bleed myInstance = null;

    private float bloodAmount = 10f;

    private Bleed()
    {

    }

    public static Bleed getInstance()
    {
        if(myInstance == null)
            myInstance = new Bleed();

        return myInstance;
    }

    public float getBloodAmount()
    {
        return bloodAmount;
    }
}
