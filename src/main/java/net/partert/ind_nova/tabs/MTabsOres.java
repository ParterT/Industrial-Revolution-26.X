package net.partert.ind_nova.tabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.basic.MBlocksFuels;
import net.partert.ind_nova.block.basic.MBlocksMetals;
import net.partert.ind_nova.block.basic.MBlocksOres;
import net.partert.ind_nova.item.basic.MItemsFuels;
import net.partert.ind_nova.item.basic.MItemsMetals;
import net.partert.ind_nova.item.basic.MItemsOres;

import java.util.function.Supplier;

public class MTabsOres {
    public static final DeferredRegister<CreativeModeTab> TAB_ORES =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndustriaNova.MODID);


    public static final Supplier<CreativeModeTab> ORES = TAB_ORES.register("ores_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(MItemsOres.RAW_TIN.get()))
                    .title(Component.translatable("creativetab.ind_nova.ores_tab"))

                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(MBlocksOres.TIN_ORE);
                        output.accept(MBlocksOres.DEEPSLATE_TIN_ORE);
                        output.accept(MItemsOres.RAW_TIN);
                        output.accept(MBlocksMetals.RAW_TIN_BLOCK);
                        output.accept(MItemsMetals.TIN_NUGGET);
                        output.accept(MItemsMetals.TIN_INGOT);
                        output.accept(MBlocksMetals.TIN_BLOCK);

                        output.accept(MBlocksOres.LIGNITE_ORE);
                        output.accept(MBlocksOres.DEEPSLATE_LIGNITE_ORE);
                        output.accept(MItemsFuels.LIGNITE);
                        output.accept(MBlocksFuels.LIGNITE_BLOCK);

                        output.accept(MBlocksOres.PLATINUM_ORE);
                        output.accept(MBlocksOres.DEEPSLATE_PLATINUM_ORE);
                        output.accept(MItemsOres.RAW_PLATINUM);
                        output.accept(MBlocksMetals.RAW_PLATINUM_BLOCK);
                        output.accept(MItemsMetals.PLATINUM_NUGGET);
                        output.accept(MItemsMetals.PLATINUM_INGOT);
                        output.accept(MBlocksMetals.PLATINUM_BLOCK);

                        output.accept(MBlocksOres.LEAD_ORE);
                        output.accept(MBlocksOres.DEEPSLATE_LEAD_ORE);
                        output.accept(MItemsOres.RAW_LEAD);
                        output.accept(MBlocksMetals.RAW_LEAD_BLOCK);
                        output.accept(MItemsMetals.LEAD_NUGGET);
                        output.accept(MItemsMetals.LEAD_INGOT);
                        output.accept(MBlocksMetals.LEAD_BLOCK);

                    }).build());
    public static void register(IEventBus eventBus) {
        TAB_ORES.register(eventBus);
    }
}
