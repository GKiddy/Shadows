package com.github.chambe41.underground_survival.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Josh on 12/29/2015.
 */
public class ItemCoordinateCache extends Item {
    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
        if (playerIn.isSneaking()) {
            if (itemStackIn.getTagCompound() != null) {
                itemStackIn.getTagCompound().removeTag("coords");
                itemStackIn.clearCustomName();
            }
        }
        return itemStackIn;
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!playerIn.isSneaking()) {
            //Allow data to be set in the item, will create error if not called
            if (stack.getTagCompound() == null) {
                stack.setTagCompound(new NBTTagCompound());
            }
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setInteger("posX", pos.getX());
            nbt.setInteger("posZ", pos.getZ());
            nbt.setInteger("posY", pos.getY());
            stack.getTagCompound().setTag("coords", nbt);
            stack.setStackDisplayName(EnumChatFormatting.AQUA + "Coordinate Cache");
        }
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
        if (stack.getTagCompound() != null) {
            if (stack.getTagCompound().hasKey("coords")) {
                NBTTagCompound nbt = (NBTTagCompound) stack.getTagCompound().getTag("coords");
                tooltip.add(String.format("X: %s, Z: %s, Y: %s", nbt.getInteger("posX"),
                        nbt.getInteger("posZ"), nbt.getInteger("posY")));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        if (stack.getTagCompound() != null) {
            return stack.getTagCompound().hasKey("coords");
        }
        return false;
    }
}
