package com.dayofpi.super_block_world.util.ItemPipeNetwork;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.custom.GlassPipeBlock;
import com.dayofpi.super_block_world.block.custom.GlassPipeBodyBlock;
import com.dayofpi.super_block_world.block.custom.PipeBodyBlock;
import com.mojang.logging.LogUtils;
import net.minecraft.client.telemetry.events.WorldLoadEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Optional;

@Mod.EventBusSubscriber(modid = SuperBlockWorld.MOD_ID)
public class PipeNetworkSavedData extends SavedData {

    private String dimId;

    public static PipeNetworkSavedData load(CompoundTag tag) {
        PipeNetworkSavedData data = new PipeNetworkSavedData();

        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        if (PipeNetworkSystem.areSystemsInitialized()) {
            Optional<PipeNetworkSystem> op = PipeNetworkSystem.getSystemForDimension(dimId);
            if (op.isPresent()) {
                return op.get().save(tag);
            }
        }
        return tag;
    }

    public static PipeNetworkSavedData load(ServerLevel level)
    {
        PipeNetworkSavedData sd = level.getDataStorage().computeIfAbsent(PipeNetworkSavedData::load, PipeNetworkSavedData::new, "sbwpn");
        sd.dimId = level.dimension().location().toString();
        return sd;
    }

    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        MinecraftServer server = event.getLevel().getServer();

        if (server == null || PipeNetworkSystem.areSystemsInitialized()) {
            return;
        }

        PipeNetworkSystem.initSystems();

        for (ServerLevel level : server.getAllLevels())
        {
            PipeNetworkSystem.registerSystem(level.dimension().location().toString(),
                    new PipeNetworkSystem(level.dimension().location().toString(), PipeNetworkSavedData.load(level)));
        }
    }

    @SubscribeEvent
    public static void onWorldUnload(LevelEvent.Unload event) {
        if (event.getLevel().getServer() != null && PipeNetworkSystem.areSystemsInitialized()) {
            PipeNetworkSystem.unInitSystems();
        }
    }

    @SubscribeEvent
    public static void onBlockPlaced(BlockEvent.EntityPlaceEvent e) {
        if (e.getLevel().getServer() != null && PipeNetworkSystem.areSystemsInitialized()) {
            Block block = e.getPlacedBlock().getBlock();
            if (block instanceof GlassPipeBlock || block instanceof GlassPipeBodyBlock) {
                Entity ent = e.getEntity();
                if (ent instanceof Player ply) {
                    Optional<PipeNetworkSystem> sys = PipeNetworkSystem.getSystemForDimension(ply.level().dimension().toString());
                    if (sys.isPresent()) {
                        if (block instanceof GlassPipeBlock) {
                            sys.get().createNode(PipeNetworkNode.NodeType.END_POINT, e.getPos());
                        } else {
                            sys.get().createNode(PipeNetworkNode.NodeType.CONNECTION, e.getPos());
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onBlockRemoved(BlockEvent.BreakEvent e) {
        if (e.getLevel().getServer() != null && PipeNetworkSystem.areSystemsInitialized()) {
            Block block = e.getState().getBlock();
            if (block instanceof GlassPipeBlock || block instanceof GlassPipeBodyBlock) {
                Entity ent = e.getPlayer();
                if (ent instanceof Player ply) {
                    Optional<PipeNetworkSystem> sys = PipeNetworkSystem.getSystemForDimension(ply.level().dimension().toString());
                    sys.ifPresent(pipeNetworkSystem -> pipeNetworkSystem.destroyNode(e.getPos()));
                }
            }
        }
    }

    private PipeNetworkSavedData() { }


    //@SubscribeEvent
    //public static void onServerStartingEvent(ServerStartingEvent e)
    //{
    //    Iterable<ServerLevel> it = e.getServer().getAllLevels();
    //    for(ServerLevel level : it)
    //    {
    //        level.getDataStorage().computeIfAbsent(PipeNetworkSavedData::load, PipeNetworkSavedData::create, "sbwpn");
    //    }
    //}

}
