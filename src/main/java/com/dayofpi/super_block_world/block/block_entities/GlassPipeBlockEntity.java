package com.dayofpi.super_block_world.block.block_entities;

import com.dayofpi.super_block_world.block.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GlassPipeBlockEntity extends BlockEntity {
    public GlassPipeBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.GLASS_PIPE.get(), blockPos, blockState);
    }
}
