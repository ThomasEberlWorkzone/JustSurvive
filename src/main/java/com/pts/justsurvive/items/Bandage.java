package com.pts.justsurvive.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Bandage extends Item
{
    /*
        This item stops the bleeding, if a wound is inflicted on the player
     */

    //Constructor
    public Bandage(String name)
    {
        setUnlocalizedName(name); // the unlocalized name
        setRegistryName(name); // the registered name of the item
        setCreativeTab(CreativeTabs.MISC);
    }
}


