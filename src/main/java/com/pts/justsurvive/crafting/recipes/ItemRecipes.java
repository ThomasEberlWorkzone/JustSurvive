package com.pts.justsurvive.crafting.recipes;

import com.pts.justsurvive.management.items.ManageItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRecipes
{
    public void addRecipeForBandage(Item itemToBeCrafted)
    {
        GameRegistry.addShapedRecipe(new ResourceLocation("JustSurvive"), null, new ItemStack(itemToBeCrafted),
                " X ",
                        "XXX",
                        " X ",
                        'X', Blocks.WOOL);
    }

    public void addRecipeForAdrenalin(Item itemToBeCrafted)
    {
        GameRegistry.addShapedRecipe(new ResourceLocation("JustSurvive"), null, new ItemStack(itemToBeCrafted),
                "  Z",
                        "XYZ",
                        "  z",
                        'X', Blocks.GLASS,
                        'Y', new ItemStack(Items.DYE,1,2),
                        'Z', Items.IRON_INGOT);
    }

    public void addRecipeForAntibiotics(Item itemToBeCrafted)
    {
        GameRegistry.addShapedRecipe(new ResourceLocation("JustSurvive"), null, new ItemStack(itemToBeCrafted),
                "   ",
                        "   ",
                        "XXX",
                        'X', ManageItems.ITEM_BANDAGE);
    }

    public void addRecipeForSplint(Item itemToBeCrafted)
    {
        GameRegistry.addShapedRecipe(new ResourceLocation("JustSurvive"), null, new ItemStack(itemToBeCrafted),
                "XXX",
                        "X  ",
                        "XXX",
                        'X', Items.STICK);
    }
}
