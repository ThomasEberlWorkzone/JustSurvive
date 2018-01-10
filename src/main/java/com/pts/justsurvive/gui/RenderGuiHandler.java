package com.pts.justsurvive.gui;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import scala.collection.parallel.ParIterableLike;

//This class handles the initial Render Events as well as later adjustments
public class RenderGuiHandler
{

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Post event)
    {
        if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE){ return;}

        new MechanicOverlay(Minecraft.getMinecraft());
    }

}
