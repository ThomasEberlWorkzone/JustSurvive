package com.pts.justsurvive.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Bandage extends Item
{
    private final int MAX_STACK_SIZE=10;
    /*
        This item stops the bleeding, if a wound is inflicted on the player
     */

    public Bandage(String name)
    {
        setUnlocalizedName(name); // the unlocalized name
        setRegistryName(name); // the registered name of the item
        setCreativeTab(CreativeTabs.MISC);

        super.setNoRepair();
        super.maxStackSize = MAX_STACK_SIZE;
        //todo: set use time to a higher amount
    }
}


