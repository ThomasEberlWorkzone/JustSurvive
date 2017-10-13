package com.pts.justsurvive.crafting.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRecipes
{
    public void addRecipeForBandage(Item itemToBeCrafted)
    {
        GameRegistry.addShapedRecipe(new ResourceLocation("JustSurvive"), null, new ItemStack(itemToBeCrafted),
                "X X",
                        " X ",
                        "X X",
                        'X', Blocks.WOOL);
    }

    public void addRecipeForAdrenalin(Item itemToBeCrafted)
    {

    }

    public void addRecipeForAntibiotics(Item itemToBeCrafted)
    {

    }

    public void addRecipeForSplint(Item itemToBeCrafted)
    {

    }
}
