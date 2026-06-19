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
                        output.accept(MBlocksStones.GABBRO);
                        output.accept(MBlocksStones.SCHIST);
                        output.accept(MBlocksStones.LIMESTONE);
                    })).build());

    public static void register(IEventBus eventBus) {
        WORLD_TAB.register(eventBus);
    }
}
