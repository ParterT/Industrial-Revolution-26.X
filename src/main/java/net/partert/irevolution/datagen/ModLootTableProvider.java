package net.partert.irevolution.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.partert.irevolution.block.MBlocks;
import net.partert.irevolution.item.MItems;

import java.util.Set;

public class ModLootTableProvider extends BlockLootSubProvider {
    public ModLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(MBlocks.RAW_TIN_BLOCK.get());
        dropSelf(MBlocks.TIN_BLOCK.get());

        add(MBlocks.TIN_ORE.get(), createOreDrop(MBlocks.TIN_ORE.get(), MItems.RAW_TIN.get()));
        add(MBlocks.DEEPSLATE_TIN_ORE.get(), createOreDrop(MBlocks.DEEPSLATE_TIN_ORE.get(), MItems.RAW_TIN.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
    return MBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
