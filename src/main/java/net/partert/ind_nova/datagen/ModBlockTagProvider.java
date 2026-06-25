package net.partert.ind_nova.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.basic.MBlocksFuels;
import net.partert.ind_nova.block.basic.MBlocksMetals;
import net.partert.ind_nova.block.basic.MBlocksOres;
import net.partert.ind_nova.block.basic.MBlocksStones;
import net.partert.ind_nova.tags.MTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, IndustriaNova.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
    tag(BlockTags.MINEABLE_WITH_PICKAXE)
            //* STONES *//
            /* BLOCKS */
            .add(MBlocksStones.MARBLE.get())
            .add(MBlocksStones.GABBRO.get())
            .add(MBlocksStones.SCHIST.get())
            .add(MBlocksStones.LIMESTONE.get())

            /* STAIRS */
            .add(MBlocksStones.MARBLE_STAIRS.get())
            .add(MBlocksStones.GABBRO_STAIRS.get())
            .add(MBlocksStones.SCHIST_STAIRS.get())
            .add(MBlocksStones.LIMESTONE_STAIRS.get())

            /* SLABS */
            .add(MBlocksStones.MARBLE_SLAB.get())
            .add(MBlocksStones.GABBRO_SLAB.get())
            .add(MBlocksStones.SCHIST_SLAB.get())
            .add(MBlocksStones.LIMESTONE_SLAB.get())

            /* WALLS */


            /* ORES */
            .add(MBlocksOres.TIN_ORE.get())
            .add(MBlocksOres.DEEPSLATE_TIN_ORE.get())

            .add(MBlocksOres.LIGNITE_ORE.get())
            .add(MBlocksOres.DEEPSLATE_LIGNITE_ORE.get())

            .add(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get())
            .add(MBlocksOres.PLATINUM_ORE.get())

            .add(MBlocksOres.DEEPSLATE_LEAD_ORE.get())
            .add(MBlocksOres.LEAD_ORE.get())

            /* METALS */
            .add(MBlocksMetals.TIN_BLOCK.get())
            .add(MBlocksMetals.RAW_TIN_BLOCK.get())

            .add(MBlocksMetals.PLATINUM_BLOCK.get())
            .add(MBlocksMetals.RAW_PLATINUM_BLOCK.get())

            .add(MBlocksMetals.LEAD_BLOCK.get())
            .add(MBlocksMetals.RAW_LEAD_BLOCK.get())

            /* FUELS */
            .add(MBlocksFuels.LIGNITE_BLOCK.get());


    tag(BlockTags.NEEDS_STONE_TOOL)
            /* ORES */
            .add(MBlocksOres.TIN_ORE.get())
            .add(MBlocksOres.DEEPSLATE_TIN_ORE.get())

            .add(MBlocksOres.LEAD_ORE.get())
            .add(MBlocksOres.DEEPSLATE_LEAD_ORE.get())

            /* METALS */
            .add(MBlocksMetals.TIN_BLOCK.get())
            .add(MBlocksMetals.RAW_TIN_BLOCK.get())

            .add(MBlocksMetals.LEAD_BLOCK.get())
            .add(MBlocksMetals.RAW_LEAD_BLOCK.get());


    tag(BlockTags.NEEDS_DIAMOND_TOOL);
            /* ORES */

            /* METALS */

    tag(MTags.Blocks.NEEDS_STEEL_TOOL)
            .add(MBlocksOres.PLATINUM_ORE.get())
            .add(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get())
            .add(MBlocksMetals.PLATINUM_BLOCK.get())
            .add(MBlocksMetals.RAW_PLATINUM_BLOCK.get());

    tag(MTags.Blocks.INCORRECT_FOR_STEEL_TOOL)
            .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

    tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
            .add(MBlocksOres.PLATINUM_ORE.get())
            .add(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get())
            .add(MBlocksMetals.RAW_PLATINUM_BLOCK.get())
            .add(MBlocksMetals.PLATINUM_BLOCK.get());

    tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
            .add(MBlocksOres.PLATINUM_ORE.get())
            .add(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get())
            .add(MBlocksMetals.RAW_PLATINUM_BLOCK.get())
            .add(MBlocksMetals.PLATINUM_BLOCK.get());

    tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
            .add(MBlocksOres.PLATINUM_ORE.get())
            .add(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get())
            .add(MBlocksMetals.RAW_PLATINUM_BLOCK.get())
            .add(MBlocksMetals.PLATINUM_BLOCK.get());

    tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
            .add(MBlocksOres.PLATINUM_ORE.get())
            .add(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get())
            .add(MBlocksMetals.RAW_PLATINUM_BLOCK.get())
            .add(MBlocksMetals.PLATINUM_BLOCK.get());

    tag(BlockTags.INCORRECT_FOR_COPPER_TOOL)
            .add(MBlocksOres.PLATINUM_ORE.get())
            .add(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get())
            .add(MBlocksMetals.RAW_PLATINUM_BLOCK.get())
            .add(MBlocksMetals.PLATINUM_BLOCK.get());
    }
}
