package com.pts.justsurvive.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Splint extends Item
{
    private final int MAX_STACK_SIZE = 1;
    public Splint(String name)
    {
        setUnlocalizedName(name); // the unlocalized name
        setRegistryName(name); // the registered name of the item
        setCreativeTab(CreativeTabs.MISC);
        super.setMaxStackSize(MAX_STACK_SIZE);
    }
}
