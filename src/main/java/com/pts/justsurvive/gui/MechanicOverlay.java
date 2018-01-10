package com.pts.justsurvive.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

//This class is used to display certain GUI elements, when needed
public class MechanicOverlay extends Gui
{
    private int screenWidth, screenHeight, bloodAmount;
    private Minecraft mcInstance;

    public MechanicOverlay(Minecraft mc, float bloodAmount)
    {
        mcInstance = mc;
        this.bloodAmount = (int)bloodAmount;

        ScaledResolution scaled = new ScaledResolution(mc);
        screenWidth = scaled.getScaledWidth();
        screenHeight = scaled.getScaledHeight();


        drawCenteredString(mc.fontRenderer, "Blood: " + bloodAmount, 25, 10, Color.RED.getRGB());


    }

    private int bloodBarLength = 200;

    public  void displayBrokenLeg()
    {

    }

    public void adjustBloodAmount(float newAmount)
    {
        drawCenteredString(mcInstance.fontRenderer, "Blood:" + newAmount, 25, 10, Color.RED.getRGB());
    }
}
