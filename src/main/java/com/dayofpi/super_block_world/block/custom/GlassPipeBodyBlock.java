package com.dayofpi.super_block_world.block.custom;

import com.dayofpi.super_block_world.block.block_entities.GlassPipeBlockEntity;
import com.dayofpi.super_block_world.block.block_entities.GlassPipeBodyEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BeaconBeamBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GlassPipeBodyBlock extends PipeBodyBlock implements EntityBlock, BeaconBeamBlock {

    protected Optional<DyeColor> color;

    @Override
    public DyeColor getColor() {
        return color.orElse(null);
    }

    public GlassPipeBodyBlock(Properties properties) {
        super(properties);
        this.color = Optional.empty();
    }

    public GlassPipeBodyBlock(DyeColor color, Properties properties) {
        super(properties);
        this.color = Optional.of(color);
    }

    private boolean isBlockItemPipe(BlockState blockState) {
        Block block = blockState.getBlock();
        if (block instanceof GlassPipeBodyBlock || block instanceof GlassPipeBlock) {
            if (this.color.orElse(null) == null) {
                return true;
            }

            DyeColor color = ((BeaconBeamBlock)block).getColor();
            if (color == null) {
                return true;
            }

            return color == this.color.get();
        }

        return false;
    }

    @Override
    protected BlockState northSouthPredicates(BlockState state, Direction direction, BlockState neighbor) {
        boolean isPipe = isBlockItemPipe(neighbor);
        boolean upDown = neighbor.is(this) && (neighbor.getValue(FACING) == Direction.UP || neighbor.getValue(FACING) == Direction.DOWN);
        boolean eastWest = isPipe && (neighbor.getValue(FACING) == Direction.EAST || neighbor.getValue(FACING) == Direction.WEST);

        if (upDown && direction == Direction.UP) {
            return state.setValue(UP, true);
        } else if (!upDown && direction == Direction.UP) {
            return state.setValue(UP, false);
        }
        if (upDown && direction == Direction.DOWN) {
            return state.setValue(DOWN, true);
        } else if (!upDown && direction == Direction.DOWN) {
            return state.setValue(DOWN, false);
        }

        if (eastWest && direction == Direction.EAST) {
            return state.setValue(EAST, true);
        } else if (!eastWest && direction == Direction.EAST) {
            return state.setValue(EAST, false);
        }
        if (eastWest && direction == Direction.WEST) {
            return state.setValue(WEST, true);
        } else if (!eastWest && direction == Direction.WEST) {
            return state.setValue(WEST, false);
        } else return state;
    }

    @Override
    protected BlockState upDownPredicates(BlockState state, Direction direction, BlockState neighbor) {
        boolean isPipe = isBlockItemPipe(neighbor);
        boolean northSouth = isPipe && (neighbor.getValue(FACING) == Direction.NORTH || neighbor.getValue(FACING) == Direction.SOUTH);
        boolean eastWest = isPipe && (neighbor.getValue(FACING) == Direction.EAST || neighbor.getValue(FACING) == Direction.WEST);

        if (northSouth && direction == Direction.NORTH) {
            return state.setValue(NORTH, true);
        } else if (!northSouth && direction == Direction.NORTH) {
            return state.setValue(NORTH, false);
        }
        if (northSouth && direction == Direction.SOUTH) {
            return state.setValue(SOUTH, true);
        } else if (!northSouth && direction == Direction.SOUTH) {
            return state.setValue(SOUTH, false);
        }

        if (eastWest && direction == Direction.EAST) {
            return state.setValue(EAST, true);
        } else if (!eastWest && direction == Direction.EAST) {
            return state.setValue(EAST, false);
        }
        if (eastWest && direction == Direction.WEST) {
            return state.setValue(WEST, true);
        } else if (!eastWest && direction == Direction.WEST) {
            return state.setValue(WEST, false);
        } else return state;
    }

    @Override
    protected BlockState eastWestPredicates(BlockState state, Direction direction, BlockState neighbor) {
        boolean isPipe = isBlockItemPipe(neighbor);
        boolean northSouth = isPipe && (neighbor.getValue(FACING) == Direction.NORTH || neighbor.getValue(FACING) == Direction.SOUTH);
        boolean upDown = neighbor.is(this) && (neighbor.getValue(FACING) == Direction.UP || neighbor.getValue(FACING) == Direction.DOWN);

        if (upDown && direction == Direction.UP) {
            return state.setValue(UP, true);
        } else if (!upDown && direction == Direction.UP) {
            return state.setValue(UP, false);
        }
        if (upDown && direction == Direction.DOWN) {
            return state.setValue(DOWN, true);
        } else if (!upDown && direction == Direction.DOWN) {
            return state.setValue(DOWN, false);
        }

        if (northSouth && direction == Direction.NORTH) {
            return state.setValue(NORTH, true);
        } else if (!northSouth && direction == Direction.NORTH) {
            return state.setValue(NORTH, false);
        }
        if (northSouth && direction == Direction.SOUTH) {
            return state.setValue(SOUTH, true);
        } else if (!northSouth && direction == Direction.SOUTH) {
            return state.setValue(SOUTH, false);
        } else return state;

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new GlassPipeBodyEntity(blockPos, blockState);
    }
}
