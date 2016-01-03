package com.github.chambe41.underground_survival;

import com.github.chambe41.underground_survival.init.USItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Josh on 12/29/2015.
 */
public class UndergroundSurvivalTab extends CreativeTabs {

    public UndergroundSurvivalTab(String label) {
        super(label);
        this.setBackgroundImageName("underground.png");
        //Note that 'underground.png' refers to file tab_underground.png
    }

    @Override
    public Item getTabIconItem() {
        return USItems.coord_cache;
    }
}
