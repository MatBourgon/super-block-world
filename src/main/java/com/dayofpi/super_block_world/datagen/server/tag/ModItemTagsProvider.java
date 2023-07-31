package com.dayofpi.super_block_world.datagen.server.tag;

import com.dayofpi.super_block_world.SuperBlockWorld;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture, CompletableFuture<TagsProvider.TagLookup<Block>> tagLookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, tagLookupCompletableFuture, SuperBlockWorld.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.STAR_BITS).add(ModItems.YELLOW_STAR_BIT.get(), ModItems.GREEN_STAR_BIT.get(), ModItems.BLUE_STAR_BIT.get(), ModItems.PURPLE_STAR_BIT.get());
        tag(ItemTags.STONE_TOOL_MATERIALS).add(ModItems.VANILLATE_CRUMBLE.get());
        tag(ItemTags.STONE_CRAFTING_MATERIALS).add(ModItems.VANILLATE_CRUMBLE.get());
        tag(ItemTags.FLOWERS).add(ModItems.WHITE_FLOWERBED.get(), ModItems.YELLOW_FLOWERBED.get());
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}