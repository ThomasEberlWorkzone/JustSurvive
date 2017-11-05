package com.pts.justsurvive.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Bandage extends Item
{
    private final int MAX_STACK_SIZE=10, USE_DURATION=5;
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
    }


    /*
        This method sets the duration to use a Bandage
        You can change this return value if you want
     */
    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return USE_DURATION;
    }
}


