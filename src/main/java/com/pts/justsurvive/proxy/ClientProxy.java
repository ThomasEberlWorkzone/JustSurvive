package com.pts.justsurvive.proxy;

import com.pts.justsurvive.crafting.recipes.ItemRecipes;
import com.pts.justsurvive.management.items.ManageItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    private final ItemRecipes recipes = new ItemRecipes();

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);

        recipes.addRecipeForAdrenalin(ManageItems.ITEM_ADRENALIN);
        recipes.addRecipeForAntibiotics(ManageItems.ITEM_ANTIBIOTICS);
        recipes.addRecipeForBandage(ManageItems.ITEM_BANDAGE);
        recipes.addRecipeForSplint(ManageItems.ITEM_SPLINT);
    }
}
