package com.pts.justsurvive.proxy;

import com.pts.justsurvive.JustSurviveProxy;
import com.pts.justsurvive.eventhandler.ItemEventHandler;
import com.pts.justsurvive.management.items.ManageItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = JustSurviveProxy.MODID)
public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        ItemEventHandler handler = new ItemEventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        FMLCommonHandler.instance().bus().register(handler);
    }
    public void init(FMLInitializationEvent event) {}
    public void postInit(FMLPostInitializationEvent event) {}

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(ManageItems.ITEM_BANDAGE, ManageItems.ITEM_ADRENALIN, ManageItems.ITEM_ANTIBIOTICS, ManageItems.ITEM_SPLINT);
    }

    //Please register here all Items, Blocks and other Components
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event)
    {
        registerRender(ManageItems.ITEM_BANDAGE);
        registerRender(ManageItems.ITEM_ADRENALIN);
        registerRender(ManageItems.ITEM_ANTIBIOTICS);
        registerRender(ManageItems.ITEM_SPLINT);
    }

    public static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
