package net.partert.ind_nova.tabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;

import java.util.function.Supplier;

public class MTabsMachines {
    public static final DeferredRegister<CreativeModeTab> TAB_MACHINES =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndustriaNova.MODID);

    public static final Supplier<CreativeModeTab> MACHINES = TAB_MACHINES.register("machines_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Blocks.REDSTONE_BLOCK))
                    .title(Component.translatable("creativetab.ind_nova.machines_tab"))

                    .build());


    public static void register(IEventBus eventBus) {
        TAB_MACHINES.register(eventBus);
    }
}
