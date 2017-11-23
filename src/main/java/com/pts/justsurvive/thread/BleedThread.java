package com.pts.justsurvive.thread;

import com.pts.justsurvive.mechanics.Bleed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class BleedThread extends Thread
{
    private EntityPlayer player;

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

                if(Bleed.getInstance().getBloodAmount() <= 10)
                    player.attackEntityFrom(DamageSource.MAGIC, 1f);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Error in BleedThread:run(), Message:  " + e.getMessage().toString());
        }
    }

    public void setLivingEntityBase(EntityPlayer player)
    {
        this.player = player;
    }
}
