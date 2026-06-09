package net.partert.ind_nova.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.basic.MBlocksFuels;
import net.partert.ind_nova.block.basic.MBlocksMetals;
import net.partert.ind_nova.block.basic.MBlocksOres;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, IndustriaNova.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    tag(BlockTags.MINEABLE_WITH_PICKAXE)
            /* STONES */

            /* ORES */
            .add(MBlocksOres.TIN_ORE.get())
            .add(MBlocksOres.DEEPSLATE_TIN_ORE.get())

            .add(MBlocksOres.LIGNITE_ORE.get())
            .add(MBlocksOres.DEEPSLATE_LIGNITE_ORE.get())

            .add(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get())
            .add(MBlocksOres.PLATINUM_ORE.get())

            /* METALS */
            .add(MBlocksMetals.TIN_BLOCK.get())
            .add(MBlocksMetals.RAW_TIN_BLOCK.get())

            .add(MBlocksMetals.PLATINUM_BLOCK.get())
            .add(MBlocksMetals.RAW_PLATINUM_BLOCK.get())

            /* FUELS */
            .add(MBlocksFuels.LIGNITE_BLOCK.get());


    tag(BlockTags.NEEDS_STONE_TOOL)
            /* ORES */
            .add(MBlocksOres.TIN_ORE.get())
            .add(MBlocksOres.DEEPSLATE_TIN_ORE.get())

            /* METALS */
            .add(MBlocksMetals.TIN_BLOCK.get())
            .add(MBlocksMetals.RAW_TIN_BLOCK.get());


    tag(BlockTags.NEEDS_DIAMOND_TOOL)
            /* ORES */
            .add(MBlocksOres.PLATINUM_ORE.get())
            .add(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get())

            /* METALS */
            .add(MBlocksMetals.PLATINUM_BLOCK.get())
            .add(MBlocksMetals.RAW_PLATINUM_BLOCK.get());
    }


}
