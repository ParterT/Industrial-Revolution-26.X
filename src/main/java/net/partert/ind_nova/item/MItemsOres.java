package net.partert.ind_nova.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;

public class MItemsOres {
    public static final DeferredRegister.Items ITEMS_ORES = DeferredRegister.createItems(IndustriaNova.MODID);


    public static  final DeferredItem<Item> RAW_TIN = ITEMS_ORES.registerSimpleItem("raw_tin");
    public static  final DeferredItem<Item> RAW_PLATINUM = ITEMS_ORES.registerSimpleItem("raw_platinum");


    public static void register(IEventBus eventBus) {
        ITEMS_ORES.register(eventBus);
    }
}
