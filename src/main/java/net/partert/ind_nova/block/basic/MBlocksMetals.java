package net.partert.ind_nova.block.basic;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.item.MItemsFuels;

import java.util.function.Function;

public class MBlocksMetals {
    public static final DeferredRegister.Blocks BLOCKS_METALS = DeferredRegister.createBlocks(IndustriaNova.MODID);

    public static final DeferredBlock<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(4f, 3f)));
    public static final DeferredBlock<Block> TIN_BLOCK = registerBlock("tin_block",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(4f, 3f)));

    public static final DeferredBlock<Block> RAW_PLATINUM_BLOCK = registerBlock("raw_platinum_block",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(7f, 6f)));
    public static final DeferredBlock<Block> PLATINUM_BLOCK = registerBlock("platinum_block",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(15f, 8f)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS_METALS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        MItemsFuels.ITEMS_FUELS.registerItem(name, (properties ->
                new BlockItem(block.get(), properties.useBlockDescriptionPrefix())));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS_METALS.register(eventBus);
    }
}
