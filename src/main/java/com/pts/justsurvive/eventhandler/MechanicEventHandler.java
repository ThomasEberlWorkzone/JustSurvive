package com.pts.justsurvive.eventhandler;

/*
    This class is used to handle events of all different mechanics
 */

import com.pts.justsurvive.mechanics.Bleed;
import com.pts.justsurvive.thread.AdrenalinSpeedThread;
import com.pts.justsurvive.thread.BleedThread;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class MechanicEventHandler
{
    private Random rand = new Random();
    public static BleedThread thread = new BleedThread("startBleeding");

    private GuiScreen pauseMenu = null;
    private boolean gameIsPaused = false;

    //This function is called, when the player enters a different chunk and determines, which biome the chunk belongs to
    //At this point in time this function in broken
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onTraverseChunk(EntityEvent.EnteringChunk event)
{
    if(event.getEntity() instanceof EntityPlayer) {
        String currentBiome = event.getEntity().getEntityWorld().getBiome(event.getEntity().
                getPosition()).getBiomeName();

        System.out.println(currentBiome);
    }
}

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void OnGamePaused(GuiOpenEvent event)
    {
        if(event.getGui() instanceof GuiIngameMenu)
        {
            System.out.println("Game paused");
            pauseMenu = event.getGui();
            gameIsPaused = true;
            //todo: thread pauseieren
        }
    }

    @SubscribeEvent(priority = EventPriority.LOW)
    public void OnGameContinued(GuiOpenEvent event)
    {
        if(gameIsPaused && !(event.getGui() instanceof  GuiIngameMenu))
        {
            if(Minecraft.getMinecraft().currentScreen != pauseMenu) {
                gameIsPaused = false;
                System.out.println("Game continued");
                //todo: thread weiterlaufen lassen
            }
        }
    }

    //this function is used to handle damage caused to the player, implement further types of damage here
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onPlayerStartBleeding(LivingHurtEvent event)
    {
        if(event.getEntity() instanceof EntityPlayer)
        {
            String damageType = event.getSource().damageType;

            //Damage caused by Cactus
            if(damageType.equals("cactus"))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    startBleeding((EntityPlayer) event.getEntity());
            }
            //Damage caused by Falling Block
            else if(damageType.equals("fallingBlock"))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    startBleeding((EntityPlayer) event.getEntity());
            }
            //Damage caused by stucking in wall
            else if(damageType.equals("inWall"))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    startBleeding((EntityPlayer) event.getEntity());
            }
            //Damage caused by Arrow
            else if(damageType.equals("arrow"))
            {
                startBleeding((EntityPlayer) event.getEntity());
            }
            //Damage caused by Thorns
            else if(damageType.equals("thorns"))
            {
                int rando = rand.nextInt(4);

                if(rando == 1)
                    startBleeding((EntityPlayer) event.getEntity());
            }
            //Damage caused by other Player
            else if(damageType.equals("player"))
            {
                startBleeding((EntityPlayer) event.getEntity());
            }
            //Damage caused by Mob
            else if(damageType.equals("mob"))
            {
                int rando = rand.nextInt(3);

                if(rando == 1)
                    startBleeding((EntityPlayer) event.getEntity());
            }
            //Damage caused by explosion
            else if(damageType.equals("explosion"))
            {
                int rando = rand.nextInt(3);

                if(rando == 1)
                    startBleeding((EntityPlayer) event.getEntity());
            }
            //Damage caused by fireball
            else if(damageType.equals("fireball"))
            {
                int rando = rand.nextInt(3);

                if(rando == 1)
                    startBleeding((EntityPlayer) event.getEntity());
            }
            //Damage caused by anvil
            else if(damageType.equals("anvil"))
            {
                int rando = rand.nextInt(3);

                if(rando == 1)
                    startBleeding((EntityPlayer) event.getEntity());
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onPlayerDie(LivingDeathEvent event)
    {
        System.out.println("living death");
        if(event.getEntity() instanceof EntityPlayer)
        {
            if(thread.isAlive())
            {
                System.out.println("dead");
                thread.interrupt();
                thread = new BleedThread("bleedThread");
                Bleed.getInstance().setBloodAmount(20f);
            }

            if(ItemEventHandler.adrenalinThread.isAlive())
            {
                System.out.println("dead");
                ItemEventHandler.adrenalinThread.interrupt();
                ItemEventHandler.adrenalinThread = new AdrenalinSpeedThread("startAdrenalinRush");
            }
        }
    }

    private void startBleeding(EntityPlayer player)
    {
        if(thread.isAlive() == false)
        {
            thread.setLivingEntityBase(player);
            thread.start();
        }
    }
}
