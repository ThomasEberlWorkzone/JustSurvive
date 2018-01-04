package com.pts.justsurvive.gui;

import com.pts.justsurvive.JustSurviveProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

//This class is used to display certain GUI elements, when needed
public class MechanicOverlay extends Gui
{
    private static final ResourceLocation broken_leg_loc =
            new ResourceLocation(JustSurviveProxy.MODID,"textures/gui/broken_leg.png");

    public static void displayBrokenLeg()
    {
        Minecraft mc = Minecraft.getMinecraft();
        mc.renderEngine.bindTexture(broken_leg_loc);
        drawModalRectWithCustomSizedTexture(0,0,0,0,50,50,50,50);
    }
}
