package net.partert.ind_nova.block.basic;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.item.basic.MItemsFuels;

import java.util.function.Function;

public class MBlocksStones {
    public static final DeferredRegister.Blocks BLOCKS_STONES = DeferredRegister.createBlocks(IndustriaNova.MODID);

    //* STANDARD *//
    /* BLOCKS */
    public static final DeferredBlock<Block> MARBLE = registerBlock("marble",
            properties -> new Block(properties.requiresCorrectToolForDrops()
                    .strength(1.5f, 6.0f)));
    public static final DeferredBlock<Block> GABBRO = registerBlock("gabbro",
            properties -> new Block(properties.requiresCorrectToolForDrops()
                    .strength(1.5f, 6.0f)));
    public static final DeferredBlock<Block> SCHIST = registerBlock("micaceous_schist",
            properties -> new Block(properties.requiresCorrectToolForDrops()
                    .strength(1.5f, 6.0f)));
    public static final DeferredBlock<Block> LIMESTONE = registerBlock("limestone",
            properties -> new Block(properties.requiresCorrectToolForDrops()
                    .strength(1.5f, 6.0f)));

    /* STAIRS */
    public static final DeferredBlock<Block> MARBLE_STAIRS = registerBlock("marble_stairs",
            properties -> new StairBlock(MBlocksStones.MARBLE.get().defaultBlockState(),
                    properties.requiresCorrectToolForDrops()
                    .strength(1.5f, 6.0f)));
    public static final DeferredBlock<Block> GABBRO_STAIRS = registerBlock("gabbro_stairs",
            properties -> new StairBlock(MBlocksStones.MARBLE.get().defaultBlockState(),
                    properties.requiresCorrectToolForDrops()
                            .strength(1.5f, 6.0f)));
    public static final DeferredBlock<Block> SCHIST_STAIRS = registerBlock("micaceous_schist_stairs",
            properties -> new StairBlock(MBlocksStones.MARBLE.get().defaultBlockState(),
                    properties.requiresCorrectToolForDrops()
                            .strength(1.5f, 6.0f)));
    public static final DeferredBlock<Block> LIMESTONE_STAIRS = registerBlock("limestone_stairs",
            properties -> new StairBlock(MBlocksStones.MARBLE.get().defaultBlockState(),
                    properties.requiresCorrectToolForDrops()
                            .strength(1.5f, 6.0f)));
    /* SLABS */
    public static final DeferredBlock<Block> MARBLE_SLAB = registerBlock("marble_slab",
            properties -> new SlabBlock(properties.requiresCorrectToolForDrops()
                    .strength(1.5f, 6.0f)));
    public static final DeferredBlock<Block> GABBRO_SLAB = registerBlock("gabbro_slab",
            properties -> new SlabBlock(properties.requiresCorrectToolForDrops()
                    .strength(1.5f, 6.0f)));
    public static final DeferredBlock<Block> SCHIST_SLAB = registerBlock("micaceous_schist_slab",
            properties -> new SlabBlock(properties.requiresCorrectToolForDrops()
                    .strength(1.5f, 6.0f)));
    public static final DeferredBlock<Block> LIMESTONE_SLAB = registerBlock("limestone_slab",
            properties -> new SlabBlock(properties.requiresCorrectToolForDrops()
                    .strength(1.5f, 6.0f)));
    /* WALLS */

    //* POLISHED *//
    /* BLOCKS */
    /* STAIRS */
    /* SLABS */
    /* WALLS */

    //* BRICKS *//
    /* BLOCKS */
    /* STAIRS */
    /* SLABS */
    /* WALLS */

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS_STONES.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        MItemsFuels.ITEMS_FUELS.registerItem(name, (properties ->
                new BlockItem(block.get(), properties.useBlockDescriptionPrefix())));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS_STONES.register(eventBus);
    }
}
