package net.partert.ind_nova.item.basic;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;

public class MItemsMetals {
    public static final DeferredRegister.Items ITEMS_METALS = DeferredRegister.createItems(IndustriaNova.MODID);


    public static final  DeferredItem<Item> TIN_INGOT = ITEMS_METALS.registerSimpleItem("tin_ingot");
    public static final  DeferredItem<Item> TIN_NUGGET = ITEMS_METALS.registerSimpleItem("tin_nugget");

    public static final  DeferredItem<Item> PLATINUM_INGOT = ITEMS_METALS.registerSimpleItem("platinum_ingot");
    public static final  DeferredItem<Item> PLATINUM_NUGGET = ITEMS_METALS.registerSimpleItem("platinum_nugget");

    public static final  DeferredItem<Item> LEAD_INGOT = ITEMS_METALS.registerSimpleItem("lead_ingot");
    public static final  DeferredItem<Item> LEAD_NUGGET = ITEMS_METALS.registerSimpleItem("lead_nugget");


    public static void register(IEventBus eventBus) {
        ITEMS_METALS.register(eventBus);
    }


}
