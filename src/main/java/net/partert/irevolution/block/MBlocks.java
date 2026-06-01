package net.partert.irevolution.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.irevolution.IndustrialRevolution;
import net.partert.irevolution.item.MItems;

import java.util.function.Function;

public class MBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(IndustrialRevolution.MODID);

    public static final DeferredBlock<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(4f, 3f)));

    public static final DeferredBlock<Block> TIN_BLOCK = registerBlock("tin_block",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(4f, 3f)));
    public static final DeferredBlock<Block> TIN_ORE = registerBlock("tin_ore",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(3f, 3f)));
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            properties ->  new Block(properties.requiresCorrectToolForDrops()
                    .strength(4.5f, 3f)
                    .sound(SoundType.DEEPSLATE)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        MItems.ITEMS.registerItem(name, (properties ->
                new BlockItem(block.get(), properties.useBlockDescriptionPrefix())));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
