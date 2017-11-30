package com.pts.justsurvive.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Adrenalin extends Item
{
    private final int MAX_STACK_SIZE = 1;

    public Adrenalin(String name)
    {
        setUnlocalizedName(name); // the unlocalized name
        setRegistryName(name); // the registered name of the item
        setCreativeTab(CreativeTabs.MISC);

        super.maxStackSize = MAX_STACK_SIZE;
    }
}
