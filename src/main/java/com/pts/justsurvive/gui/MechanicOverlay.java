package com.pts.justsurvive.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//This class is used to display certain GUI elements, when needed
public class MechanicOverlay extends Gui
{
    private int screenWidth, screenHeight;
    public MechanicOverlay(Minecraft mc)
    {
        ScaledResolution scaled = new ScaledResolution(mc);
        screenWidth = scaled.getScaledWidth();
        screenHeight = scaled.getScaledHeight();


        drawCenteredString
                (mc.fontRenderer, "Hello World", screenWidth / 2, (screenHeight / 2) - 4, Integer.parseInt("FFAA00", 16));

    }

    private int bloodBarLength = 200;

    public static void displayBrokenLeg()
    {

    }

    /*
    @SubscribeEvent
    public static void renderBloodBar(RenderGameOverlayEvent event)
    {

    }
    */
}
