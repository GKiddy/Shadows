package com.github.chambe41.underground_survival.proxy;

import com.github.chambe41.underground_survival.init.USBlocks;
import com.github.chambe41.underground_survival.init.USItems;

/**
 * Created by Josh on 12/24/2015.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenders() {
        USBlocks.registerRenders();
        USItems.registerRenders();
    }
}
