package com.dayofpi.super_block_world.worldgen.structure;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.util.ModTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;

import java.util.Map;

public class ModStructures {
    public static final ResourceKey<Structure> MOON_MONOLITH = register("moon_monolith");
    public static final ResourceKey<Structure> BRICK_FORTRESS_OVERWORLD = register("brick_fortress_overworld");
    public static final ResourceKey<Structure> BRICK_FORTRESS_MUSHROOM_KINGDOM = register("brick_fortress_mushroom_kingdom");

    public static void bootstrap(BootstapContext<Structure> context) {
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        HolderGetter<StructureTemplatePool> templatePools = context.lookup(Registries.TEMPLATE_POOL);
        context.register(MOON_MONOLITH, new JigsawStructure(new Structure.StructureSettings(biomes.getOrThrow(ModTags.Biomes.IS_MUSHROOM_KINGDOM), Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_THIN), templatePools.getOrThrow(ModTemplatePools.MOON_MONOLITH), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
        context.register(BRICK_FORTRESS_OVERWORLD, new JigsawStructure(new Structure.StructureSettings(biomes.getOrThrow(BiomeTags.HAS_MINESHAFT), Map.of(MobCategory.MONSTER, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE, MobSpawnSettings.EMPTY_MOB_LIST)), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_BOX), templatePools.getOrThrow(ModTemplatePools.BRICK_FORTRESS), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
        context.register(BRICK_FORTRESS_MUSHROOM_KINGDOM, new JigsawStructure(new Structure.StructureSettings(biomes.getOrThrow(ModTags.Biomes.IS_MUSHROOM_KINGDOM), Map.of(MobCategory.MONSTER, new StructureSpawnOverride(StructureSpawnOverride.BoundingBoxType.STRUCTURE, MobSpawnSettings.EMPTY_MOB_LIST)), GenerationStep.Decoration.SURFACE_STRUCTURES, TerrainAdjustment.BEARD_BOX), templatePools.getOrThrow(ModTemplatePools.BRICK_FORTRESS), 7, ConstantHeight.of(VerticalAnchor.absolute(0)), false, Heightmap.Types.WORLD_SURFACE_WG));
    }

    private static ResourceKey<Structure> register(String name) {
        return ResourceKey.create(Registries.STRUCTURE, new ResourceLocation(SuperBlockWorld.MOD_ID, name));
    }
}
