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
import net.partert.ind_nova.item.MItemsFuels;
import net.partert.ind_nova.item.MItemsMetals;
import net.partert.ind_nova.item.MItemsOres;

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

        /* METALS */
        itemModel.generateFlatItem(MItemsMetals.TIN_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItemsMetals.TIN_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        itemModel.generateFlatItem(MItemsMetals.PLATINUM_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItemsMetals.PLATINUM_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        /* FUELS */
        itemModel.generateFlatItem(MItemsFuels.LIGNITE.get(), ModelTemplates.FLAT_ITEM);


        //* BLOCKS *//
        /* STONES */

        /* ORES */
        blockModels.createTrivialCube(MBlocksOres.TIN_ORE.get());
        blockModels.createTrivialCube(MBlocksOres.DEEPSLATE_TIN_ORE.get());

        blockModels.createTrivialCube(MBlocksOres.PLATINUM_ORE.get());
        blockModels.createTrivialCube(MBlocksOres.DEEPSLATE_PLATINUM_ORE.get());

        blockModels.createTrivialCube(MBlocksOres.LIGNITE_ORE.get());
        blockModels.createTrivialCube(MBlocksOres.DEEPSLATE_LIGNITE_ORE.get());

        /* METALS */
        blockModels.createTrivialCube(MBlocksMetals.RAW_TIN_BLOCK.get());
        blockModels.createTrivialCube(MBlocksMetals.TIN_BLOCK.get());

        blockModels.createTrivialCube(MBlocksMetals.RAW_PLATINUM_BLOCK.get());
        blockModels.createTrivialCube(MBlocksMetals.PLATINUM_BLOCK.get());

        /* FUELS */
        blockModels.createTrivialCube(MBlocksFuels.LIGNITE_BLOCK.get());
    }
}
