package net.partert.ind_nova.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.basic.MBlocksMetals;
import net.partert.ind_nova.block.basic.MBlocksOres;
import net.partert.ind_nova.item.basic.MItemsMetals;
import net.partert.ind_nova.item.basic.MItemsOres;
import net.partert.ind_nova.item.tool.MItemsTools;
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

        tag(MTags.Items.HAMMER_LIKE)
                .add(MItemsTools.STONE_HAMMER.get())
                .add(MItemsTools.COPPER_HAMMER.get())
                .add(MItemsTools.IRON_HAMMER.get())
                .add(MItemsTools.STEEL_HAMMER.get())
                .add(MItemsTools.DIAMOND_HAMMER.get())
                .add(MItemsTools.GOLDEN_HAMMER.get())
                .add(MItemsTools.NETHERITE_HAMMER.get());

        tag(MTags.Items.STEEL_REPAIRABLE)
                .add(MItemsMetals.STEEL_INGOT.get());

        tag(ItemTags.SWORDS).add(MItemsTools.STEEL_SWORD.get());
        tag(ItemTags.AXES).add(MItemsTools.STEEL_AXE.get());
        tag(ItemTags.PICKAXES).add(MItemsTools.STEEL_PICKAXE.get());
        tag(ItemTags.SHOVELS).add(MItemsTools.STEEL_SHOVEL.get());
        tag(ItemTags.HOES).add(MItemsTools.STEEL_HOE.get());
        tag(ItemTags.SPEARS).add(MItemsTools.STEEL_SPEAR.get());
    }
}
