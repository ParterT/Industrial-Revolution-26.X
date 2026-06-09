package net.partert.ind_nova.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;

public class MItemsFuels {
    public static final DeferredRegister.Items ITEMS_FUELS = DeferredRegister.createItems(IndustriaNova.MODID);


    public static final  DeferredItem<Item> LIGNITE = ITEMS_FUELS.registerSimpleItem("lignite");


    public static void register(IEventBus eventBus) {
        ITEMS_FUELS.register(eventBus);
    }
}
