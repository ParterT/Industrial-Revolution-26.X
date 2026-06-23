package net.partert.ind_nova.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.basic.MBlocksMetals;
import net.partert.ind_nova.block.basic.MBlocksOres;
import net.partert.ind_nova.item.basic.MItemsMetals;
import net.partert.ind_nova.item.basic.MItemsOres;
import net.partert.ind_nova.tags.MTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, IndustriaNova.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(MTags.Items.LEAD_CONTAINING)
                .add(MBlocksOres.LEAD_ORE.asItem())
                .add(MBlocksOres.DEEPSLATE_LEAD_ORE.asItem())
                .add(MBlocksMetals.RAW_LEAD_BLOCK.asItem())
                .add(MBlocksMetals.LEAD_BLOCK.asItem())
                .add(MItemsOres.RAW_LEAD.get())
                .add(MItemsMetals.LEAD_INGOT.get())
                .add(MItemsMetals.LEAD_NUGGET.get());
    }
}
