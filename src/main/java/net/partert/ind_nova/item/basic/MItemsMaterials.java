package net.partert.ind_nova.item.basic;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;

public class MItemsMaterials {
    public static final DeferredRegister.Items ITEMS_MATERIALS = DeferredRegister.createItems(IndustriaNova.MODID);


    public static final DeferredItem<Item> RAW_FLUX = ITEMS_MATERIALS.registerSimpleItem("raw_flux");
    public static final DeferredItem<Item> FLUX = ITEMS_MATERIALS.registerSimpleItem("flux");

    public static final DeferredItem<Item> IRON_BLOOM = ITEMS_MATERIALS.registerSimpleItem("iron_bloom");


    public static void register(IEventBus eventBus) {
        ITEMS_MATERIALS.register(eventBus);
    }
}
