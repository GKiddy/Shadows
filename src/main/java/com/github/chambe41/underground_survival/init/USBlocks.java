package com.github.chambe41.underground_survival.init;

import com.github.chambe41.underground_survival.Reference;
import com.github.chambe41.underground_survival.UndergroundSurvival;
import com.github.chambe41.underground_survival.blocks.BlockTest;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Josh on 12/29/2015.
 */
public class USBlocks {
    public static Block test_block;

    public static void init() {
        //This name is the name of the file associated with textures and models
        test_block = new BlockTest(Material.cloth).setUnlocalizedName("test_block")
                .setCreativeTab(UndergroundSurvival.usTab);
    }

    public static void register() {
        GameRegistry.registerBlock(test_block, test_block.getUnlocalizedName().substring(5));
    }

    public static void registerRenders() {
        registerRender(test_block);
    }

    public static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(Reference.MOD_ID + ":" +
                        item.getUnlocalizedName().substring(5), "inventory"));
    }
}
