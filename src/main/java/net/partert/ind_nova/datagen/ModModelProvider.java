package net.partert.ind_nova.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.basic.MBlocksFuels;
import net.partert.ind_nova.block.basic.MBlocksMetals;
import net.partert.ind_nova.block.basic.MBlocksOres;
import net.partert.ind_nova.block.basic.MBlocksStones;
import net.partert.ind_nova.item.basic.MItemsFuels;
import net.partert.ind_nova.item.basic.MItemsMaterials;
import net.partert.ind_nova.item.basic.MItemsMetals;
import net.partert.ind_nova.item.basic.MItemsOres;
import net.partert.ind_nova.item.tool.MItemsTools;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, IndustriaNova.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModel) {
        //* ITEMS *//
        /* ORES */
        itemModel.generateFlatItem(MItemsOres.RAW_TIN.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItemsOres.RAW_PLATINUM.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItemsOres.RAW_LEAD.get(), ModelTemplates.FLAT_ITEM);

        /* METALS */
        itemModel.generateFlatItem(MItemsMetals.TIN_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItemsMetals.TIN_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        itemModel.generateFlatItem(MItemsMetals.PLATINUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItemsMetals.PLATINUM_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        itemModel.generateFlatItem(MItemsMetals.LEAD_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItemsMetals.LEAD_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        itemModel.generateFlatItem(MItemsMetals.STEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItemsMetals.STEEL_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        /* MATERIALS */
        itemModel.generateFlatItem(MItemsMaterials.RAW_FLUX.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItemsMaterials.FLUX.get(), ModelTemplates.FLAT_ITEM);

        itemModel.generateFlatItem(MItemsMaterials.IRON_BLOOM.get(), ModelTemplates.FLAT_ITEM);

        /* FUELS */
        itemModel.generateFlatItem(MItemsFuels.LIGNITE.get(), ModelTemplates.FLAT_ITEM);

        //* TOOLS *//
        /* HAMMERS */
        itemModel.generateFlatItem(MItemsTools.STONE_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModel.generateFlatItem(MItemsTools.COPPER_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModel.generateFlatItem(MItemsTools.IRON_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModel.generateFlatItem(MItemsTools.STEEL_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModel.generateFlatItem(MItemsTools.DIAMOND_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModel.generateFlatItem(MItemsTools.GOLDEN_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModel.generateFlatItem(MItemsTools.NETHERITE_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        /* SWORDS */
        itemModel.generateFlatItem(MItemsTools.STEEL_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        /* AXES */
        itemModel.generateFlatItem(MItemsTools.STEEL_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        /* PICKAXES */
        itemModel.generateFlatItem(MItemsTools.STEEL_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        /* SHOVELS */
        itemModel.generateFlatItem(MItemsTools.STEEL_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        /* HOES */
        itemModel.generateFlatItem(MItemsTools.STEEL_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        /* SPEARS */
        itemModel.generateSpear(MItemsTools.STEEL_SPEAR.get());


        //* BLOCKS *//
        /* STONES */
        blockModels.family(MBlocksStones.MARBLE.get())
                .stairs(MBlocksStones.MARBLE_STAIRS.get())
                .slab(MBlocksStones.MARBLE_SLAB.get());
        blockModels.family(MBlocksStones.GABBRO.get())
                .stairs(MBlocksStones.GABBRO_STAIRS.get())
                .slab(MBlocksStones.GABBRO_SLAB.get());
        blockModels.family(MBlocksStones.SCHIST.get())
                .stairs(MBlocksStones.SCHIST_STAIRS.get())
                .slab(MBlocksStones.SCHIST_SLAB.get());
        blockModels.family(MBlocksStones.LIMESTONE.get())
                .stairs(MBlocksStones.LIMESTONE_STAIRS.get())
                .slab(MBlocksStones.LIMESTONE_SLAB.get());

        /* ORES */
        blockModels.createTrivialCube(MBlocksOres.TIN_ORE.get());
        blockModels.createTrivialCube(MBlocksOres.DEEPSLATE_TIN_ORE.get());

        blockModels.createTrivialCube(MBlocksOres.PLATINUM_ORE.get());
        blockModels.createTrivialCube(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get());

        blockModels.createTrivialCube(MBlocksOres.LIGNITE_ORE.get());
        blockModels.createTrivialCube(MBlocksOres.DEEPSLATE_LIGNITE_ORE.get());

        blockModels.createTrivialCube(MBlocksOres.LEAD_ORE.get());
        blockModels.createTrivialCube(MBlocksOres.DEEPSLATE_LEAD_ORE.get());

        /* METALS */
        blockModels.createTrivialCube(MBlocksMetals.RAW_TIN_BLOCK.get());
        blockModels.createTrivialCube(MBlocksMetals.TIN_BLOCK.get());

        blockModels.createTrivialCube(MBlocksMetals.RAW_PLATINUM_BLOCK.get());
        blockModels.createTrivialCube(MBlocksMetals.PLATINUM_BLOCK.get());

        blockModels.createTrivialCube(MBlocksMetals.RAW_LEAD_BLOCK.get());
        blockModels.createTrivialCube(MBlocksMetals.LEAD_BLOCK.get());


        /* FUELS */
        blockModels.createTrivialCube(MBlocksFuels.LIGNITE_BLOCK.get());
    }
}
