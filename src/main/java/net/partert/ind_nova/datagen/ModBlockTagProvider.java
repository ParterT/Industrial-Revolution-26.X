package net.partert.ind_nova.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.MBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, IndustriaNova.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(MBlocks.TIN_BLOCK.get())
            .add(MBlocks.RAW_TIN_BLOCK.get())
            .add(MBlocks.LIGNITE_BLOCK.get())

            .add(MBlocks.TIN_ORE.get())
            .add(MBlocks.DEEPSLATE_TIN_ORE.get())
            .add(MBlocks.LIGNITE_ORE.get())
            .add(MBlocks.DEEPSLATE_LIGNITE_ORE.get());

    tag(BlockTags.NEEDS_STONE_TOOL)
            .add(MBlocks.TIN_BLOCK.get())
            .add(MBlocks.RAW_TIN_BLOCK.get())
            .add(MBlocks.TIN_ORE.get())
            .add(MBlocks.DEEPSLATE_TIN_ORE.get());
    }
}
