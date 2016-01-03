package com.github.chambe41.underground_survival;

import com.github.chambe41.underground_survival.init.USBlocks;
import com.github.chambe41.underground_survival.init.USItems;
import com.github.chambe41.underground_survival.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Josh on 12/24/2015.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class UndergroundSurvival {

    @Mod.Instance
    public static UndergroundSurvival instance = new UndergroundSurvival();

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public static final UndergroundSurvivalTab usTab = new UndergroundSurvivalTab("underground_survival_creative_tab");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        USBlocks.init();
        USBlocks.register();
        USItems.init();
        USItems.register();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenders();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
