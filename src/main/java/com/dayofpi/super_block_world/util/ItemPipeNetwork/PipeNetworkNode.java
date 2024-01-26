package com.dayofpi.super_block_world.util.ItemPipeNetwork;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntArrayTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

import java.io.BufferedWriter;
import java.io.DataOutput;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class PipeNetworkNode {
    public enum NodeType {
        END_POINT(1),
        CONNECTION(6);

        // Num of connections the node can have
        public final byte value;
        NodeType(int value) {
            this.value = (byte)value;
        }
    }

    public final NodeType nodeType;

    private final int[] nodes;
    public BlockPos blockPos;
    public int NodeId;
    PipeNetworkNetwork network;

    public PipeNetworkNode(NodeType nodeType, BlockPos pos, PipeNetworkNetwork parent, int nodeId) {
        this.nodeType = nodeType;
        nodes = new int[nodeType.value];
        this.blockPos = pos;
        this.NodeId = nodeId;
        findNeighbouringNodes();
    }

    private void findNeighbouringNodes() {
        BlockPos[] positions = PipeNetworkSystem.expandBlockPos(blockPos);
        for (BlockPos pos : positions) {
            getParent().getNodeAtPos(pos).ifPresent(this::addNode);
        }
    }

    void addNode(int nodeId) {
        for(int i = 0; i < nodes.length; ++i) {
            if (nodes[i] == -1) {
                nodes[i] = nodeId;
                getParent().getNode(nodeId).ifPresent(node -> node.addNode(NodeId));
                return;
            }
        }
        throw new IndexOutOfBoundsException("Ran out of space when adding a node!");
    }

    void clearNodes() {
        for (int node : nodes) {
            removeNode(node);
        }
    }

    void removeNode(int nodeId) {
        for (int i = 0; i < nodes.length; ++i) {
            if (nodes[i] == nodeId) {
                nodes[i] = -1;
                getParent().getNode(nodeId).ifPresent(node -> node.removeNode(NodeId));
                return;
            }
        }
    }

    protected CompoundTag save() {
        CompoundTag tag = new CompoundTag();

        tag.putInt("id", NodeId);
        tag.put("pos", createBlockPosTag(blockPos));
        tag.put("nodes", new IntArrayTag(nodes));

        return tag;
    }

    PipeNetworkNetwork getParent() { return network; }

    Optional<PipeNetworkNode> getNode(int nodeId) {
        return getParent().getNode(nodeId);
    }

    private CompoundTag createBlockPosTag(BlockPos pos) {
        CompoundTag tag = new CompoundTag();
        tag.putInt("x", pos.getX());
        tag.putInt("y", pos.getY());
        tag.putInt("z", pos.getZ());
        return tag;
    }

    private BlockPos loadBlockPosTag(CompoundTag tag) {
        if (tag.contains("x") && tag.contains("y") && tag.contains("z")) {
            return new BlockPos(tag.getInt("x"), tag.getInt("y"), tag.getInt("z"));
        }
        return null;
    }
}