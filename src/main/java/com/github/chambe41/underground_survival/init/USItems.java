package com.github.chambe41.underground_survival.init;

import com.github.chambe41.underground_survival.Reference;
import com.github.chambe41.underground_survival.UndergroundSurvival;
import com.github.chambe41.underground_survival.UndergroundSurvivalTab;
import com.github.chambe41.underground_survival.items.BookOfAtonement;
import com.github.chambe41.underground_survival.items.ItemCoordinateCache;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Josh on 12/24/2015.
 */
public final class USItems {

    public static Item key;
    public static Item book_of_atonement;
    public static Item coord_cache;

    public static void init() {
        key = new Item().setUnlocalizedName("key").setCreativeTab(UndergroundSurvival.usTab);
        book_of_atonement = new BookOfAtonement().setUnlocalizedName("book_of_atonement")
                .setCreativeTab(UndergroundSurvival.usTab);
        coord_cache = new ItemCoordinateCache().setUnlocalizedName("coord_cache").setCreativeTab(UndergroundSurvival.usTab);
    }

    public static void register() {
        GameRegistry.registerItem(key, key.getUnlocalizedName().substring(5)); //"tile.key" using substring(5) removes tile.
        GameRegistry.registerItem(book_of_atonement, book_of_atonement.getUnlocalizedName().substring(5));
        GameRegistry.registerItem(coord_cache, coord_cache.getUnlocalizedName().substring(5));
    }

    public static void registerRenders() {
        registerRender(key);
        registerRender(book_of_atonement);
        registerRender(coord_cache);
    }

    public static void registerRender(Item item) {
        //This is client side, will return error on server
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
                new ModelResourceLocation(Reference.MOD_ID + ":" +
                        item.getUnlocalizedName().substring(5), "inventory"));

    }

}

