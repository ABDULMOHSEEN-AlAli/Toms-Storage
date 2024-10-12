package com.tom.storagemod.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import com.tom.storagemod.util.BlockFace;

public interface IInventoryCable {
	default boolean canConnectFrom(BlockState state, Direction dir) {
		return true;
	}

	/**
	 * Return next blocks for scanning
	 * */
	default List<BlockFace> nextScan(Level world, BlockState state, BlockPos pos) {
		List<BlockFace> next = new ArrayList<>();
		for (Direction d : Direction.values()) {
			next.add(new BlockFace(pos.relative(d), d.getOpposite()));
		}
		return next;
	}

	default boolean isFunctionalNode() {
		return true;
	}

	static boolean canConnect(BlockState block, Direction dir) {
		return block.getBlock() instanceof IInventoryCable && ((IInventoryCable)block.getBlock()).canConnectFrom(block, dir.getOpposite());
	}
}
