package net.partert.ind_nova.block.basic;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.item.basic.MItemsFuels;

import java.util.function.Function;

public class MBlocksOres {
    public static final DeferredRegister.Blocks BLOCKS_ORES = DeferredRegister.createBlocks(IndustriaNova.MODID);


    public static final DeferredBlock<Block> TIN_ORE = registerBlock("tin_ore",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(3f, 3f)));
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(4.5f, 3f)
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> LIGNITE_ORE = registerBlock("lignite_ore",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(3f, 3f)));
    public static final DeferredBlock<Block> DEEPSLATE_LIGNITE_ORE = registerBlock("deepslate_lignite_ore",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(4.5f, 3f)
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> PLATINUM_ORE = registerBlock("platinum_ore",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(6f, 6f)));

    public static final DeferredBlock<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(9f, 6f)
                    .sound(SoundType.DEEPSLATE)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS_ORES.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        MItemsFuels.ITEMS_FUELS.registerItem(name, (properties ->
                new BlockItem(block.get(), properties.useBlockDescriptionPrefix())));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS_ORES.register(eventBus);
    }
}
