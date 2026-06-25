package net.partert.ind_nova.tabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.item.basic.MItemsMaterials;
import net.partert.ind_nova.item.basic.MItemsMetals;

import java.util.function.Supplier;

public class MTabsMaterials {
    public static final DeferredRegister<CreativeModeTab> TAB_MATERIALS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndustriaNova.MODID);

    public static final Supplier<CreativeModeTab> MATERIALS = TAB_MATERIALS.register("materials_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(MItemsMaterials.FLUX.get()))
                    .title(Component.translatable("creativetab.ind_nova.materials_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(MItemsMaterials.RAW_FLUX);
                        output.accept(MItemsMaterials.FLUX);
                        output.accept(MItemsMaterials.IRON_BLOOM);
                        output.accept(MItemsMetals.STEEL_INGOT);
                        output.accept(MItemsMetals.STEEL_NUGGET);
                    }).build());

    public static void register(IEventBus eventBus) {
        TAB_MATERIALS.register(eventBus);
    }
}
