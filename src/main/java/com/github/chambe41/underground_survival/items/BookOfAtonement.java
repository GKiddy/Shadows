package com.github.chambe41.underground_survival.items;

import com.github.chambe41.underground_survival.UndergroundSurvival;
import com.github.chambe41.underground_survival.UndergroundSurvivalTab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Josh on 12/24/2015.
 */
public class BookOfAtonement extends Item {

    public BookOfAtonement() {
        super();
        this.setCreativeTab(UndergroundSurvival.usTab);
    }

    @Override
    public boolean hasEffect(ItemStack itemStack) {
        return true;
    }
}
