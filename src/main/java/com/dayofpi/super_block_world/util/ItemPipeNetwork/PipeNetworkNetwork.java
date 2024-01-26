package com.dayofpi.super_block_world.util.ItemPipeNetwork;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// Maybe add a "range" member variable that is the max area in world-space that
// contains each of its nodes, as a quick way to tell if a node is in the network.
// i.e., if the block pos is outside the box, then the position cannot possibly
// be in the network anywhere.
public class PipeNetworkNetwork {
    private Integer NODE_ID_OFFSET = 0;
    public final long NetworkId;
    private final Map<Integer, PipeNetworkNode> nodes;

    public PipeNetworkNetwork(long id) {
        NetworkId = id;
        nodes = new HashMap<>();
    }

    public boolean containsNodeAtAny(BlockPos[] blockPositions) {
        for (BlockPos pos : blockPositions) {
            if (containsNodeAt(pos)) {
                return true;
            }
        }

        return false;
    }

    protected boolean containsNodeAt(BlockPos blockPos) {
        for (PipeNetworkNode node : nodes.values()) {
            if (node.blockPos == blockPos) {
                return true;
            }
        }

        return false;
    }

    public Optional<Integer> getNodeAtPos(BlockPos pos) {
        for (PipeNetworkNode node : nodes.values()) {
            if (node.blockPos == pos) {
                return Optional.of(node.NodeId);
            }
        }
        return Optional.empty();
    }
    public Pair<Long, Integer> createNode(PipeNetworkNode.NodeType type, BlockPos pos) {
        PipeNetworkNode node = new PipeNetworkNode(type, pos, this, NODE_ID_OFFSET);
        NODE_ID_OFFSET++;
        nodes.put(node.NodeId, node);
        return new Pair<>(NetworkId, node.NodeId);
    }

    public Optional<PipeNetworkNode> getNode(int nodeId) {
        if (nodes.containsKey(nodeId)) {
            return Optional.of(nodes.get(nodeId));
        }
        return Optional.empty();
    }

    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    public Optional<Pair<Long, Integer>> combineNetworks(List<PipeNetworkNetwork> networks, PipeNetworkNode.NodeType nodeType, BlockPos pos) {
        for (PipeNetworkNetwork network : networks) {
            for (PipeNetworkNode node : network.nodes.values()) {
                node.network = this;
                node.NodeId = NODE_ID_OFFSET;
                ++NODE_ID_OFFSET;
                nodes.put(node.NodeId, node);
            }
            network.nodes.clear();
        }
        return Optional.of(createNode(nodeType, pos));
    }

    protected CompoundTag save() {
        CompoundTag tag = new CompoundTag();

        tag.putInt("nidoffset", NODE_ID_OFFSET);

        ListTag list = new ListTag();

        for(PipeNetworkNode node : nodes.values()) {
            list.add(node.save());
        }

        tag.put("nodes", list);

        return tag;
    }
}
