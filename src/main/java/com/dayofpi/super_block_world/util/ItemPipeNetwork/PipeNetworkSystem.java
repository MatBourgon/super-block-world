package com.dayofpi.super_block_world.util.ItemPipeNetwork;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber(modid = SuperBlockWorld.MOD_ID)
public class PipeNetworkSystem {
    private int NETWORK_ID_OFFSET = 0;
    private final Map<Long, PipeNetworkNetwork> NETWORKS;
    private final String DIMENSION_ID;

    private final PipeNetworkSavedData savedData;

    private static Map<String, PipeNetworkSystem> PipeNetworkSystems;

    public static void initSystems() {
        if (PipeNetworkSystems == null) {
            PipeNetworkSystems = new HashMap<>();
        }
    }

    public static void unInitSystems() {
        if (PipeNetworkSystems != null) {
            PipeNetworkSystems.clear();
            PipeNetworkSystems = null;
        }
    }

    public static void registerSystem(String dimId, PipeNetworkSystem system) {
        if (!PipeNetworkSystems.containsKey(dimId)) {
            PipeNetworkSystems.put(dimId, system);
        }
    }

    public static Optional<PipeNetworkSystem> getSystemForDimension(String dimId) {
        if (PipeNetworkSystems.containsKey(dimId)) {
            return Optional.of(PipeNetworkSystems.get(dimId));
        }
        return Optional.empty();
    }

    public static boolean areSystemsInitialized() {
        return PipeNetworkSystems != null;
    }

    public PipeNetworkSystem(String dimId, PipeNetworkSavedData sd) {
        NETWORKS = new HashMap<>();
        DIMENSION_ID = dimId;
        savedData = sd;
    }

    private long generateNetworkId() {
        long new_id = System.currentTimeMillis() + NETWORK_ID_OFFSET;
        ++NETWORK_ID_OFFSET;
        return new_id;
    }

    public long createNetwork() {
        long id = generateNetworkId();
        NETWORKS.put(id, new PipeNetworkNetwork(id));
        return id;
    }

    public Optional<PipeNetworkNetwork> getNetwork(long id) {
        if (NETWORKS.containsKey(id)) {
            return Optional.of(NETWORKS.get(id));
        }
        return Optional.empty();
    }

    public List<Long> getNetworksAround(BlockPos blockPos) {
        ArrayList<Long> list = new ArrayList<>();
        BlockPos[] positions = expandBlockPos(blockPos);
        for (PipeNetworkNetwork network : NETWORKS.values()) {
            if (network.containsNodeAtAny(positions)) {
                list.add(network.NetworkId);
            }
        }
        return list;
    }

    public static BlockPos[] expandBlockPos(BlockPos pos) {
        BlockPos[] positions = new BlockPos[6];

        positions[0] = pos.above();
        positions[1] = pos.below();
        positions[2] = pos.east();
        positions[3] = pos.west();
        positions[4] = pos.north();
        positions[5] = pos.south();

        return positions;
    }

    private Optional<Pair<Long, Integer>> createNetworkAndAddNode(PipeNetworkNode.NodeType nodeType, BlockPos pos) {
        long network_id = createNetwork();
        Optional<PipeNetworkNetwork> network = getNetwork(network_id);
        if (network.isPresent()) {
            return Optional.of(network.get().createNode(nodeType, pos));
        }
        throw new NullPointerException("Network should exist since it was just created, but it's missing?!");
    }

    private Optional<Pair<Long, Integer>> addNodeToExistingNetwork(Optional<PipeNetworkNetwork> network, PipeNetworkNode.NodeType nodeType, BlockPos pos) {
        return network.map(pipeNetworkNetwork -> pipeNetworkNetwork.createNode(nodeType, pos));
    }

    private Optional<Pair<Long, Integer>> combineNetworksAndAddNode(List<Long> networks, PipeNetworkNode.NodeType nodeType, BlockPos pos) {
        List<PipeNetworkNetwork> validNetworks = new ArrayList<>();
        Optional<PipeNetworkNetwork> mainNetwork = Optional.empty();
        for (long networkId : networks) {
            Optional<PipeNetworkNetwork> network = getNetwork(networkId);
            if (network.isEmpty() || network.get().isEmpty()){
                // remove network from list if it is indexed but doesn't exist or is empty
                NETWORKS.remove(networkId);
                continue;
            }

            if (mainNetwork.isEmpty()) {
                mainNetwork = network;
            } else {
                validNetworks.add(network.get());
            }
        }

        if (mainNetwork.isEmpty()) {
            return createNetworkAndAddNode(nodeType, pos);
        }

        if (validNetworks.isEmpty()) {
            return addNodeToExistingNetwork(mainNetwork, nodeType, pos);
        }

        return mainNetwork.get().combineNetworks(validNetworks, nodeType, pos);
    }

    public Optional<Pair<Long, Integer>> createNode(PipeNetworkNode.NodeType nodeType, BlockPos pos) {
        List<Long> networks = getNetworksAround(pos);

        if (networks.size() == 0) {
            return createNetworkAndAddNode(nodeType, pos);
        }

        if (networks.size() == 1) {
            return addNodeToExistingNetwork(getNetwork(networks.get(0)), nodeType, pos);
        }

        return combineNetworksAndAddNode(networks, nodeType, pos);
    }

    public void destroyNode(BlockPos pos) {
        for (PipeNetworkNetwork network : NETWORKS.values()) {
            if (network.containsNodeAt(pos)) {
                // Remove the node and split the network if needed
            }
        }
    }

    public CompoundTag save(CompoundTag tag) {

        tag.putString("dimid", DIMENSION_ID.toString());
        tag.putLong("nidoffset", NETWORK_ID_OFFSET);

        ListTag list = new ListTag();
        for(PipeNetworkNetwork network : NETWORKS.values()) {
            list.add(network.save());
        }
        tag.put("networks", list);

        return tag;
    }
}
