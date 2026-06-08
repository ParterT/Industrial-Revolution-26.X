package net.partert.ind_nova;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.partert.ind_nova.datagen.*;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = IndustriaNova.MODID)
public class IndustriaNovaDatagen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {

        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        gen.addProvider(true, new ModModelProvider(packOutput));
        gen.addProvider(true, new ModBlockTagProvider(packOutput, lookupProvider));
        gen.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
        gen.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));
        gen.addProvider(true, new ModDataMapProvider(packOutput, lookupProvider));
    }
}
