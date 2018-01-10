package com.pts.justsurvive.mechanics;

public class Bleed
{
    private static Bleed myInstance = null;

    private float bloodAmount = 20f;

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

    public void setBloodAmount(float bloodAmount)
    {
        if(bloodAmount > 0)
            this.bloodAmount = bloodAmount;
    }

    public void addBloodAmount(float bloodAmount)
    {
        if(this.bloodAmount <= 17.5f)
            this.bloodAmount += bloodAmount;
        else
            this.bloodAmount = 20f;
    }
}
