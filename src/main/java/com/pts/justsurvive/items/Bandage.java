package com.pts.justsurvive.items;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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

    //Event is called if Player uses Item
    @SubscribeEvent
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        itemStackIn.setCount(itemStackIn.getCount()-1); //updating the Stack Count
        System.out.println("Bandage used"); //temporary logging

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS,itemStackIn);
    }
}


