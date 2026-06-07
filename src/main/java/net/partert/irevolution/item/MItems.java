package net.partert.irevolution.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.irevolution.IndustrialRevolution;

public class MItems{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(IndustrialRevolution.MODID);

    public static  final DeferredItem<Item> RAW_TIN = ITEMS.registerSimpleItem("raw_tin");
    public static final  DeferredItem<Item> TIN_INGOT = ITEMS.registerSimpleItem("tin_ingot");
    public static final  DeferredItem<Item> TIN_NUGGET = ITEMS.registerSimpleItem("tin_nugget");

    public static final  DeferredItem<Item> LIGNITE = ITEMS.registerSimpleItem("lignite");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
