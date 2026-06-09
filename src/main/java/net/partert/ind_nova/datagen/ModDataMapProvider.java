package net.partert.ind_nova.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.partert.ind_nova.block.basic.MBlocksFuels;
import net.partert.ind_nova.item.MItemsFuels;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    public ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(MItemsFuels.LIGNITE.getId(), new FurnaceFuel(1200), false)
                .add(MBlocksFuels.LIGNITE_BLOCK.getId(), new FurnaceFuel(12000), false);
    }
}
