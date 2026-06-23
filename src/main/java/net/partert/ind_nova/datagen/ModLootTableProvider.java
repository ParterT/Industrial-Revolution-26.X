package net.partert.ind_nova.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.partert.ind_nova.block.basic.MBlocksFuels;
import net.partert.ind_nova.block.basic.MBlocksMetals;
import net.partert.ind_nova.block.basic.MBlocksOres;
import net.partert.ind_nova.block.basic.MBlocksStones;
import net.partert.ind_nova.item.basic.MItemsFuels;
import net.partert.ind_nova.item.basic.MItemsOres;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Stream;

public class ModLootTableProvider extends BlockLootSubProvider {
    public ModLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        //* STONES *//
        /* BLOCKS */
        dropSelf(MBlocksStones.MARBLE.get());
        dropSelf(MBlocksStones.GABBRO.get());
        dropSelf(MBlocksStones.SCHIST.get());
        dropSelf(MBlocksStones.LIMESTONE.get());

        /* STAIRS */
        dropSelf(MBlocksStones.MARBLE_STAIRS.get());
        dropSelf(MBlocksStones.GABBRO_STAIRS.get());
        dropSelf(MBlocksStones.SCHIST_STAIRS.get());
        dropSelf(MBlocksStones.LIMESTONE_STAIRS.get());

        /* SLABS */
        add(MBlocksStones.MARBLE_SLAB.get(), this::createSlabItemTable);
        add(MBlocksStones.GABBRO_SLAB.get(), this::createSlabItemTable);
        add(MBlocksStones.SCHIST_SLAB.get(), this::createSlabItemTable);
        add(MBlocksStones.LIMESTONE_SLAB.get(), this::createSlabItemTable);

        /* WALLS */


        /* ORES */
        add(MBlocksOres.TIN_ORE.get(), createOreDrop(MBlocksOres.TIN_ORE.get(), MItemsOres.RAW_TIN.get()));
        add(MBlocksOres.DEEPSLATE_TIN_ORE.get(), createOreDrop(MBlocksOres.DEEPSLATE_TIN_ORE.get(), MItemsOres.RAW_TIN.get()));

        add(MBlocksOres.LIGNITE_ORE.get(), createOreDrop(MBlocksOres.LIGNITE_ORE.get(), MItemsFuels.LIGNITE.get()));
        add(MBlocksOres.DEEPSLATE_LIGNITE_ORE.get(), createOreDrop(MBlocksOres.DEEPSLATE_LIGNITE_ORE.get(), MItemsFuels.LIGNITE.get()));

        add(MBlocksOres.PLATINUM_ORE.get(), createOreDrop(MBlocksOres.PLATINUM_ORE.get(), MItemsOres.RAW_PLATINUM.get()));
        add(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get(), createOreDrop(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get(), MItemsOres.RAW_PLATINUM.get()));

        add(MBlocksOres.LEAD_ORE.get(), createOreDrop(MBlocksOres.LEAD_ORE.get(), MItemsOres.RAW_LEAD.get()));
        add(MBlocksOres.DEEPSLATE_LEAD_ORE.get(), createOreDrop(MBlocksOres.DEEPSLATE_LEAD_ORE.get(), MItemsOres.RAW_LEAD.get()));

        /* METALS */
        dropSelf(MBlocksMetals.RAW_TIN_BLOCK.get());
        dropSelf(MBlocksMetals.TIN_BLOCK.get());

        dropSelf(MBlocksMetals.RAW_PLATINUM_BLOCK.get());
        dropSelf(MBlocksMetals.PLATINUM_BLOCK.get());

        dropSelf(MBlocksMetals.RAW_LEAD_BLOCK.get());
        dropSelf(MBlocksMetals.LEAD_BLOCK.get());

        /* FUELS */
        dropSelf(MBlocksFuels.LIGNITE_BLOCK.get());



    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
    return Stream.of(MBlocksStones.BLOCKS_STONES.getEntries(),
            MBlocksOres.BLOCKS_ORES.getEntries(),
            MBlocksMetals.BLOCKS_METALS.getEntries(),
            MBlocksFuels.BLOCKS_FUELS.getEntries())
            .flatMap(Collection::stream)
            .map(Holder::value)
            .toList()::iterator;
    }
}
