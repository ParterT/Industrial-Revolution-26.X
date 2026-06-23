package net.partert.ind_nova.tabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.basic.MBlocksStones;

import java.util.function.Supplier;

public class MTabsWorld {
    public static final DeferredRegister<CreativeModeTab> WORLD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndustriaNova.MODID);

    public static final Supplier<CreativeModeTab> WORLD = WORLD_TAB.register("world_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(MBlocksStones.GABBRO.get()))
                    .title(Component.translatable("creativetab.ind_nova.world_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(MBlocksStones.MARBLE);
                        output.accept(MBlocksStones.MARBLE_STAIRS);
                        output.accept(MBlocksStones.MARBLE_SLAB);
                        output.accept(MBlocksStones.GABBRO);
                        output.accept(MBlocksStones.GABBRO_STAIRS);
                        output.accept(MBlocksStones.GABBRO_SLAB);
                        output.accept(MBlocksStones.SCHIST);
                        output.accept(MBlocksStones.SCHIST_STAIRS);
                        output.accept(MBlocksStones.SCHIST_SLAB);
                        output.accept(MBlocksStones.LIMESTONE);
                        output.accept(MBlocksStones.LIMESTONE_STAIRS);
                        output.accept(MBlocksStones.LIMESTONE_SLAB);
                    })).build());

    public static void register(IEventBus eventBus) {
        WORLD_TAB.register(eventBus);
    }
}
