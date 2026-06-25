package net.partert.ind_nova.tabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.item.tool.MItemsTools;

import java.util.function.Supplier;

public class MTabsTools {
    public static final DeferredRegister<CreativeModeTab> TAB_TOOLS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndustriaNova.MODID);

    public static final Supplier<CreativeModeTab> MACHINES = TAB_TOOLS.register("tools_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(MItemsTools.NETHERITE_HAMMER.get()))
                    .title(Component.translatable("creativetab.ind_nova.tools_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept((MItemsTools.STONE_HAMMER));
                        output.accept((MItemsTools.COPPER_HAMMER));
                        output.accept((MItemsTools.IRON_HAMMER));
                        output.accept((MItemsTools.STEEL_HAMMER));
                        output.accept((MItemsTools.GOLDEN_HAMMER));
                        output.accept((MItemsTools.DIAMOND_HAMMER));
                        output.accept((MItemsTools.NETHERITE_HAMMER));
                        output.accept((MItemsTools.STEEL_SWORD));
                        output.accept((MItemsTools.STEEL_PICKAXE));
                        output.accept((MItemsTools.STEEL_AXE));
                        output.accept((MItemsTools.STEEL_SHOVEL));
                        output.accept((MItemsTools.STEEL_HOE));
                        output.accept((MItemsTools.STEEL_SPEAR));
                    })

                    .build());


    public static void register(IEventBus eventBus) {
        TAB_TOOLS.register(eventBus);
    }
}
