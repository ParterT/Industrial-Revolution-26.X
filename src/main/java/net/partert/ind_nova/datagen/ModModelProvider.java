package net.partert.ind_nova.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.MBlocks;
import net.partert.ind_nova.item.MItems;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, IndustriaNova.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModel) {
        itemModel.generateFlatItem(MItems.RAW_TIN.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItems.TIN_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItems.TIN_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModel.generateFlatItem(MItems.LIGNITE.get(), ModelTemplates.FLAT_ITEM);

        /* BLOCKS */
        blockModels.createTrivialCube(MBlocks.RAW_TIN_BLOCK.get());
        blockModels.createTrivialCube(MBlocks.TIN_BLOCK.get());
        blockModels.createTrivialCube(MBlocks.LIGNITE_BLOCK.get());

        blockModels.createTrivialCube(MBlocks.TIN_ORE.get());
        blockModels.createTrivialCube(MBlocks.DEEPSLATE_TIN_ORE.get());

        blockModels.createTrivialCube(MBlocks.LIGNITE_ORE.get());
        blockModels.createTrivialCube(MBlocks.DEEPSLATE_LIGNITE_ORE.get());
    }
}
