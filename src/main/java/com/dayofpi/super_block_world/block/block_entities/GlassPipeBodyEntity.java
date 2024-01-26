package com.dayofpi.super_block_world.block.block_entities;

import com.dayofpi.super_block_world.block.ModBlockEntityTypes;
import com.dayofpi.super_block_world.util.ItemPipeNetwork.AbstractPipeNetworkEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class GlassPipeBodyEntity extends AbstractPipeNetworkEntity {

    public GlassPipeBodyEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.GLASS_PIPE_BODY.get(), blockPos, blockState);
    }

}
