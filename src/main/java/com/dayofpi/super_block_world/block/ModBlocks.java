package com.dayofpi.super_block_world.block;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.block.custom.*;
import com.dayofpi.super_block_world.sound.ModSoundTypes;
import com.dayofpi.super_block_world.util.ModWoodTypes;
import com.dayofpi.super_block_world.worldgen.tree.AmanitaTreeGrower;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SuperBlockWorld.MOD_ID);

    public static final MapColor VANILLATE_COLOR = MapColor.COLOR_LIGHT_GRAY;
    public static final MapColor AMANITA_PLANKS_COLOR = MapColor.TERRACOTTA_YELLOW;
    public static final MapColor AMANITA_WOOD_COLOR = MapColor.PODZOL;

    public static final RegistryObject<Block> POWER_STAR = BLOCKS.register("power_star", () -> new PowerStarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel(value -> 5).instabreak().noCollission().noOcclusion()));

    public static final RegistryObject<Block> WHITE_BRONZE = BLOCKS.register("white_bronze", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.SNOW)));
    public static final RegistryObject<Block> LIGHT_GRAY_BRONZE = BLOCKS.register("light_gray_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> GRAY_BRONZE = BLOCKS.register("gray_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> BLACK_BRONZE = BLOCKS.register("black_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BROWN_BRONZE = BLOCKS.register("brown_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> RED_BRONZE = BLOCKS.register("red_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> ORANGE_BRONZE = BLOCKS.register("orange_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> YELLOW_BRONZE = BLOCKS.register("yellow_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> LIME_BRONZE = BLOCKS.register("lime_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> GREEN_BRONZE = BLOCKS.register("green_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> CYAN_BRONZE = BLOCKS.register("cyan_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> LIGHT_BLUE_BRONZE = BLOCKS.register("light_blue_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> BLUE_BRONZE = BLOCKS.register("blue_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> PURPLE_BRONZE = BLOCKS.register("purple_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> MAGENTA_BRONZE = BLOCKS.register("magenta_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> PINK_BRONZE = BLOCKS.register("pink_bronze", () -> new Block(BlockBehaviour.Properties.copy(WHITE_BRONZE.get()).mapColor(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> FLAGPOLE = BLOCKS.register("flagpole", () -> new FlagpoleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> WHITE_FLAG = BLOCKS.register("white_flag", () -> new FlagBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.SNOW)));
    public static final RegistryObject<Block> LIGHT_GRAY_FLAG = BLOCKS.register("light_gray_flag", () -> new FlagBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> GRAY_FLAG = BLOCKS.register("gray_flag", () -> new FlagBlock(DyeColor.GRAY, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> BLACK_FLAG = BLOCKS.register("black_flag", () -> new FlagBlock(DyeColor.BLACK, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BROWN_FLAG = BLOCKS.register("brown_flag", () -> new FlagBlock(DyeColor.BROWN, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> RED_FLAG = BLOCKS.register("red_flag", () -> new FlagBlock(DyeColor.RED, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> ORANGE_FLAG = BLOCKS.register("orange_flag", () -> new FlagBlock(DyeColor.ORANGE, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> YELLOW_FLAG = BLOCKS.register("yellow_flag", () -> new FlagBlock(DyeColor.YELLOW, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> LIME_FLAG = BLOCKS.register("lime_flag", () -> new FlagBlock(DyeColor.LIME, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> GREEN_FLAG = BLOCKS.register("green_flag", () -> new FlagBlock(DyeColor.GREEN, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> CYAN_FLAG = BLOCKS.register("cyan_flag", () -> new FlagBlock(DyeColor.CYAN, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> LIGHT_BLUE_FLAG = BLOCKS.register("light_blue_flag", () -> new FlagBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> BLUE_FLAG = BLOCKS.register("blue_flag", () -> new FlagBlock(DyeColor.BLUE, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> PURPLE_FLAG = BLOCKS.register("purple_flag", () -> new FlagBlock(DyeColor.PURPLE, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> MAGENTA_FLAG = BLOCKS.register("magenta_flag", () -> new FlagBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> PINK_FLAG = BLOCKS.register("pink_flag", () -> new FlagBlock(DyeColor.PINK, BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> RAINBOW_FLAG = BLOCKS.register("rainbow_flag", () -> new FlagBlock(BlockBehaviour.Properties.copy(FLAGPOLE.get()).mapColor(MapColor.SNOW)));
    public static final RegistryObject<Block> WHITE_WARP_PIPE = BLOCKS.register("white_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.COPPER).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LIGHT_GRAY_WARP_PIPE = BLOCKS.register("light_gray_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> GRAY_WARP_PIPE = BLOCKS.register("gray_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> BLACK_WARP_PIPE = BLOCKS.register("black_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BROWN_WARP_PIPE = BLOCKS.register("brown_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> RED_WARP_PIPE = BLOCKS.register("red_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> ORANGE_WARP_PIPE = BLOCKS.register("orange_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> YELLOW_WARP_PIPE = BLOCKS.register("yellow_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> LIME_WARP_PIPE = BLOCKS.register("lime_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> GREEN_WARP_PIPE = BLOCKS.register("green_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> CYAN_WARP_PIPE = BLOCKS.register("cyan_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> LIGHT_BLUE_WARP_PIPE = BLOCKS.register("light_blue_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> BLUE_WARP_PIPE = BLOCKS.register("blue_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> PURPLE_WARP_PIPE = BLOCKS.register("purple_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> MAGENTA_WARP_PIPE = BLOCKS.register("magenta_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> PINK_WARP_PIPE = BLOCKS.register("pink_warp_pipe", () -> new WarpPipeBlock(BlockBehaviour.Properties.copy(WHITE_WARP_PIPE.get()).mapColor(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> WHITE_PIPE_BODY = BLOCKS.register("white_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.COPPER).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LIGHT_GRAY_PIPE_BODY = BLOCKS.register("light_gray_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_LIGHT_GRAY)));
    public static final RegistryObject<Block> GRAY_PIPE_BODY = BLOCKS.register("gray_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> BLACK_PIPE_BODY = BLOCKS.register("black_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> BROWN_PIPE_BODY = BLOCKS.register("brown_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> RED_PIPE_BODY = BLOCKS.register("red_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> ORANGE_PIPE_BODY = BLOCKS.register("orange_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> YELLOW_PIPE_BODY = BLOCKS.register("yellow_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> LIME_PIPE_BODY = BLOCKS.register("lime_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_LIGHT_GREEN)));
    public static final RegistryObject<Block> GREEN_PIPE_BODY = BLOCKS.register("green_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_GREEN)));
    public static final RegistryObject<Block> CYAN_PIPE_BODY = BLOCKS.register("cyan_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_CYAN)));
    public static final RegistryObject<Block> LIGHT_BLUE_PIPE_BODY = BLOCKS.register("light_blue_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final RegistryObject<Block> BLUE_PIPE_BODY = BLOCKS.register("blue_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_BLUE)));
    public static final RegistryObject<Block> PURPLE_PIPE_BODY = BLOCKS.register("purple_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_PURPLE)));
    public static final RegistryObject<Block> MAGENTA_PIPE_BODY = BLOCKS.register("magenta_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_MAGENTA)));
    public static final RegistryObject<Block> PINK_PIPE_BODY = BLOCKS.register("pink_pipe_body", () -> new PipeBodyBlock(BlockBehaviour.Properties.copy(WHITE_PIPE_BODY.get()).mapColor(MapColor.COLOR_PINK)));
    public static final RegistryObject<Block> TOADSTOOL_GRASS = BLOCKS.register("toadstool_grass", () -> new ToadstoolGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK)));
    public static final RegistryObject<Block> TOADSTOOL_SOIL = BLOCKS.register("toadstool_soil", () -> new ToadstoolSoilBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).mapColor(MapColor.TERRACOTTA_YELLOW)));
    public static final RegistryObject<Block> COARSE_TOADSTOOL_SOIL = BLOCKS.register("coarse_toadstool_soil", () -> new ToadstoolSoilBlock(BlockBehaviour.Properties.copy(TOADSTOOL_SOIL.get())));
    public static final RegistryObject<Block> TOADSTOOL_PATH = BLOCKS.register("toadstool_path", () -> new ToadstoolPathBlock(BlockBehaviour.Properties.copy(Blocks.DIRT_PATH)));
    public static final RegistryObject<Block> BRONZE_ORE = BLOCKS.register("bronze_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).mapColor(VANILLATE_COLOR)));
    public static final RegistryObject<Block> RAW_BRONZE_BLOCK = BLOCKS.register("raw_bronze_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> BRONZE_BLOCK = BLOCKS.register("bronze_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.TERRACOTTA_ORANGE)));
    public static final RegistryObject<Block> BRONZE_STAIRS = BLOCKS.register("bronze_stairs", () -> new ModStairBlock(BRONZE_BLOCK));
    public static final RegistryObject<Block> BRONZE_SLAB = BLOCKS.register("bronze_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(BRONZE_BLOCK.get())));
    public static final RegistryObject<Block> VANILLATE = BLOCKS.register("vanillate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(VANILLATE_COLOR)));
    public static final RegistryObject<Block> VANILLATE_STAIRS = BLOCKS.register("vanillate_stairs", () -> new ModStairBlock(VANILLATE));
    public static final RegistryObject<Block> VANILLATE_SLAB = BLOCKS.register("vanillate_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(VANILLATE.get())));
    public static final RegistryObject<Block> VANILLATE_WALL = BLOCKS.register("vanillate_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(VANILLATE.get())));
    public static final RegistryObject<Block> TOPPED_VANILLATE = BLOCKS.register("topped_vanillate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.CLAY)));
    public static final RegistryObject<Block> VANILLATE_CRUMBLE = BLOCKS.register("vanillate_crumble", () -> new SandBlock(12176828, BlockBehaviour.Properties.copy(VANILLATE.get()).strength(1.0F)));
    public static final RegistryObject<Block> VANILLATE_BRICKS = BLOCKS.register("vanillate_bricks", () -> new Block(BlockBehaviour.Properties.copy(VANILLATE.get())));
    public static final RegistryObject<Block> VANILLATE_BRICK_STAIRS = BLOCKS.register("vanillate_brick_stairs", () -> new ModStairBlock(VANILLATE_BRICKS));
    public static final RegistryObject<Block> VANILLATE_BRICK_SLAB = BLOCKS.register("vanillate_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(VANILLATE_BRICKS.get())));
    public static final RegistryObject<Block> VANILLATE_BRICK_WALL = BLOCKS.register("vanillate_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(VANILLATE_BRICKS.get())));
    public static final RegistryObject<Block> VANILLATE_TILES = BLOCKS.register("vanillate_tiles", () -> new Block(BlockBehaviour.Properties.copy(VANILLATE.get())));
    public static final RegistryObject<Block> VANILLATE_TILE_STAIRS = BLOCKS.register("vanillate_tile_stairs", () -> new ModStairBlock(VANILLATE_TILES));
    public static final RegistryObject<Block> VANILLATE_TILE_SLAB = BLOCKS.register("vanillate_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(VANILLATE_TILES.get())));
    public static final RegistryObject<Block> VANILLATE_TILE_WALL = BLOCKS.register("vanillate_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(VANILLATE_TILES.get())));
    public static final RegistryObject<Block> TOADSTONE = BLOCKS.register("toadstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(ModSoundTypes.TOADSTONE).mapColor(MapColor.TERRACOTTA_BROWN)));
    public static final RegistryObject<Block> TOADSTONE_STAIRS = BLOCKS.register("toadstone_stairs", () -> new ModStairBlock(TOADSTONE));
    public static final RegistryObject<Block> TOADSTONE_SLAB = BLOCKS.register("toadstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(TOADSTONE.get())));
    public static final RegistryObject<Block> TOADSTONE_WALL = BLOCKS.register("toadstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(TOADSTONE.get())));
    public static final RegistryObject<Block> TOADSTONE_BRICKS = BLOCKS.register("toadstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(TOADSTONE.get())));
    public static final RegistryObject<Block> TOADSTONE_BRICK_STAIRS = BLOCKS.register("toadstone_brick_stairs", () -> new ModStairBlock(TOADSTONE_BRICKS));
    public static final RegistryObject<Block> TOADSTONE_BRICK_SLAB = BLOCKS.register("toadstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(TOADSTONE_BRICKS.get())));
    public static final RegistryObject<Block> TOADSTONE_BRICK_WALL = BLOCKS.register("toadstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(TOADSTONE_BRICKS.get())));
    public static final RegistryObject<Block> SMOOTH_TOADSTONE = BLOCKS.register("smooth_toadstone", () -> new Block(BlockBehaviour.Properties.copy(TOADSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_TOADSTONE_STAIRS = BLOCKS.register("smooth_toadstone_stairs", () -> new ModStairBlock(SMOOTH_TOADSTONE));
    public static final RegistryObject<Block> SMOOTH_TOADSTONE_SLAB = BLOCKS.register("smooth_toadstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_TOADSTONE.get())));
    public static final RegistryObject<Block> HARDSTONE = BLOCKS.register("hardstone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(ModSoundTypes.TOADSTONE).mapColor(MapColor.COLOR_LIGHT_GRAY).strength(6.0F, 200.0F)));
    public static final RegistryObject<Block> HARDSTONE_STAIRS = BLOCKS.register("hardstone_stairs", () -> new ModStairBlock(HARDSTONE));
    public static final RegistryObject<Block> HARDSTONE_SLAB = BLOCKS.register("hardstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HARDSTONE.get())));
    public static final RegistryObject<Block> HARDSTONE_WALL = BLOCKS.register("hardstone_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(HARDSTONE.get())));
    public static final RegistryObject<Block> CHISELED_HARDSTONE = BLOCKS.register("chiseled_hardstone", () -> new Block(BlockBehaviour.Properties.copy(HARDSTONE.get())));
    public static final RegistryObject<Block> HARDSTONE_BRICKS = BLOCKS.register("hardstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(HARDSTONE.get())));
    public static final RegistryObject<Block> CRACKED_HARDSTONE_BRICKS = BLOCKS.register("cracked_hardstone_bricks", () -> new Block(BlockBehaviour.Properties.copy(HARDSTONE_BRICKS.get())));
    public static final RegistryObject<Block> HARDSTONE_BRICK_STAIRS = BLOCKS.register("hardstone_brick_stairs", () -> new ModStairBlock(HARDSTONE_BRICKS));
    public static final RegistryObject<Block> HARDSTONE_BRICK_SLAB = BLOCKS.register("hardstone_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(HARDSTONE_BRICKS.get())));
    public static final RegistryObject<Block> HARDSTONE_BRICK_WALL = BLOCKS.register("hardstone_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(HARDSTONE_BRICKS.get())));
    public static final RegistryObject<Block> SMOOTH_HARDSTONE = BLOCKS.register("smooth_hardstone", () -> new Block(BlockBehaviour.Properties.copy(HARDSTONE.get())));
    public static final RegistryObject<Block> SMOOTH_HARDSTONE_STAIRS = BLOCKS.register("smooth_hardstone_stairs", () -> new ModStairBlock(SMOOTH_HARDSTONE));
    public static final RegistryObject<Block> SMOOTH_HARDSTONE_SLAB = BLOCKS.register("smooth_hardstone_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(SMOOTH_HARDSTONE.get())));
    public static final RegistryObject<Block> PACKED_CLOUD = BLOCKS.register("packed_cloud", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).strength(0.25F).sound(SoundType.POWDER_SNOW)));
    public static final RegistryObject<Block> CLOUD_STAIRS = BLOCKS.register("cloud_stairs", () -> new ModStairBlock(PACKED_CLOUD));
    public static final RegistryObject<Block> CLOUD_SLAB = BLOCKS.register("cloud_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(PACKED_CLOUD.get())));
    public static final RegistryObject<Block> MOON_ROCK = BLOCKS.register("moon_rock", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.METAL).instrument(NoteBlockInstrument.CHIME).requiresCorrectToolForDrops().strength(50.0F, 1200.0F).pushReaction(PushReaction.BLOCK)));
    public static final RegistryObject<Block> RAINBOW_TILES = BLOCKS.register("rainbow_tiles", () -> new Block(BlockBehaviour.Properties.of().lightLevel(value -> 8).mapColor(MapColor.SNOW).strength(1.5F).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAINBOW_TILE_STAIRS = BLOCKS.register("rainbow_tile_stairs", () -> new ModStairBlock(RAINBOW_TILES));
    public static final RegistryObject<Block> RAINBOW_TILE_SLAB = BLOCKS.register("rainbow_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(RAINBOW_TILES.get())));
    public static final RegistryObject<Block> RAINBOW_TILE_WALL = BLOCKS.register("rainbow_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(RAINBOW_TILES.get())));
    public static final RegistryObject<Block> STAR_CLUSTER = BLOCKS.register("star_cluster", () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).forceSolidOn().noOcclusion().randomTicks().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel(value -> 10).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> AMANITA_LOG = BLOCKS.register("amanita_log", () -> log(AMANITA_PLANKS_COLOR, AMANITA_WOOD_COLOR));
    public static final RegistryObject<Block> AMANITA_WOOD = BLOCKS.register("amanita_wood", () -> log(AMANITA_WOOD_COLOR, AMANITA_WOOD_COLOR));
    public static final RegistryObject<Block> STRIPPED_AMANITA_LOG = BLOCKS.register("stripped_amanita_log", () -> log(AMANITA_PLANKS_COLOR, AMANITA_PLANKS_COLOR));
    public static final RegistryObject<Block> STRIPPED_AMANITA_WOOD = BLOCKS.register("stripped_amanita_wood", () -> log(AMANITA_PLANKS_COLOR, AMANITA_PLANKS_COLOR));
    public static final RegistryObject<Block> AMANITA_PLANKS = BLOCKS.register("amanita_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(AMANITA_PLANKS_COLOR)));
    public static final RegistryObject<Block> AMANITA_STAIRS = BLOCKS.register("amanita_stairs", () -> new ModStairBlock(AMANITA_PLANKS));
    public static final RegistryObject<Block> AMANITA_SLAB = BLOCKS.register("amanita_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(AMANITA_PLANKS.get())));
    public static final RegistryObject<Block> AMANITA_FENCE = BLOCKS.register("amanita_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).mapColor(AMANITA_PLANKS_COLOR)));
    public static final RegistryObject<Block> AMANITA_FENCE_GATE = BLOCKS.register("amanita_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).mapColor(AMANITA_PLANKS_COLOR), WoodType.OAK));
    public static final RegistryObject<Block> AMANITA_DOOR = BLOCKS.register("amanita_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).mapColor(AMANITA_PLANKS_COLOR), BlockSetType.OAK));
    public static final RegistryObject<Block> AMANITA_TRAPDOOR = BLOCKS.register("amanita_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).mapColor(AMANITA_PLANKS_COLOR), BlockSetType.OAK));
    public static final RegistryObject<Block> AMANITA_PRESSURE_PLATE = BLOCKS.register("amanita_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).mapColor(AMANITA_PLANKS_COLOR), BlockSetType.OAK));
    public static final RegistryObject<Block> AMANITA_BUTTON = BLOCKS.register("amanita_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON), BlockSetType.OAK, 30, true));
    public static final RegistryObject<Block> AMANITA_SIGN = BLOCKS.register("amanita_sign", () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(AMANITA_PLANKS_COLOR), ModWoodTypes.AMANITA));
    public static final RegistryObject<Block> AMANITA_WALL_SIGN = BLOCKS.register("amanita_wall_sign", () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN).mapColor(AMANITA_PLANKS_COLOR).lootFrom(AMANITA_SIGN), ModWoodTypes.AMANITA));
    public static final RegistryObject<Block> AMANITA_HANGING_SIGN = BLOCKS.register("amanita_hanging_sign", () -> new ModHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN).mapColor(AMANITA_PLANKS_COLOR), ModWoodTypes.AMANITA));
    public static final RegistryObject<Block> AMANITA_WALL_HANGING_SIGN = BLOCKS.register("amanita_wall_hanging_sign", () -> new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN).mapColor(AMANITA_PLANKS_COLOR).lootFrom(AMANITA_HANGING_SIGN), ModWoodTypes.AMANITA));
    public static final RegistryObject<Block> AMANITA_LEAVES = BLOCKS.register("amanita_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> FRUITING_AMANITA_LEAVES = BLOCKS.register("fruiting_amanita_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> AMANITA_SAPLING = BLOCKS.register("amanita_sapling", () -> new SaplingBlock(new AmanitaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> WHITE_FLOWERBED = BLOCKS.register("white_flowerbed", () -> new FlowerbedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> YELLOW_FLOWERBED = BLOCKS.register("yellow_flowerbed", () -> new FlowerbedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_AMANITA_SAPLING = registerFlowerPot("potted_amanita_sapling", AMANITA_SAPLING);

    private static RotatedPillarBlock log(MapColor planksColor, MapColor woodColor) {
        return new LogBlock(BlockBehaviour.Properties.of().mapColor((blockState) -> {
            MapColor mapColor = blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? planksColor : woodColor;
            return planksColor == woodColor ? planksColor : mapColor;
        }).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava());
    }

    private static <T extends Block> RegistryObject<Block> registerFlowerPot(String name, Supplier<T> flower) {
        return BLOCKS.register(name, () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, flower, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    }
}
