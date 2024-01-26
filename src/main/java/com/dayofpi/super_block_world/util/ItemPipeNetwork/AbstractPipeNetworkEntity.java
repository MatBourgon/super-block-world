package com.dayofpi.super_block_world.util.ItemPipeNetwork;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public abstract class AbstractPipeNetworkEntity extends BlockEntity {
    public AbstractPipeNetworkEntity(BlockEntityType entityType, BlockPos pos, BlockState blockState) {
        super(entityType, pos, blockState);
    }

    protected DyeColor getColor() {
        return ((BeaconBeamBlock)getBlockState()).getColor();
    }


}
