package net.partert.ind_nova.tabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.MBlocks;
import net.partert.ind_nova.item.MItems;

import java.util.function.Supplier;

public class MTabs {
    public static final DeferredRegister<CreativeModeTab> MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndustriaNova.MODID);

    public static final Supplier<CreativeModeTab> RESOURCES = MOD_TABS.register("resources_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(MItems.TIN_INGOT.get()))
                    .title(Component.translatable("creativetab.ind_nova.resources"))

                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(MBlocks.TIN_ORE);
                        output.accept(MBlocks.DEEPSLATE_TIN_ORE);
                        output.accept(MItems.RAW_TIN);
                        output.accept(MBlocks.RAW_TIN_BLOCK);
                        output.accept(MItems.TIN_NUGGET);
                        output.accept(MItems.TIN_INGOT);
                        output.accept(MBlocks.TIN_BLOCK);

                        output.accept(MBlocks.LIGNITE_ORE);
                        output.accept(MBlocks.DEEPSLATE_LIGNITE_ORE);
                        output.accept(MItems.LIGNITE);
                        output.accept(MBlocks.LIGNITE_BLOCK);

                    }).build());

    public static final Supplier<CreativeModeTab> MACHINES = MOD_TABS.register("machines_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Blocks.REDSTONE_BLOCK))
                    .title(Component.translatable("creativetab.ind_nova.machines"))

                    .build());

    public static void register(IEventBus eventBus) {
        MOD_TABS.register(eventBus);
    }
}
