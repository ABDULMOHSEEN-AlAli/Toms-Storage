package com.tom.storagemod.item;

import java.util.function.BooleanSupplier;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import com.tom.storagemod.inventory.filter.ItemFilter;
import com.tom.storagemod.util.BlockFaceReference;

public interface IItemFilter {
	ItemFilter createFilter(BlockFaceReference from, ItemStack stack);
	void openGui(ItemStack is, Player player, BooleanSupplier isValid, Runnable refresh);
}
