package com.pts.justsurvive.proxy;

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
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);

        addRecipeForBandage(ManageItems.ITEM_BANDAGE);
    }

    private void addRecipeForBandage(Item itemToBeCrafted)
    {
        GameRegistry.addShapedRecipe(new ResourceLocation("JustSurvive"), null, new ItemStack(itemToBeCrafted),
                                     "X X",
                                             " X ",
                                             "X X",
                                             'X', Blocks.WOOL);
    }
}
