package net.partert.ind_nova;

import net.partert.ind_nova.block.MBlocks;
import net.partert.ind_nova.item.MItems;
import net.partert.ind_nova.tabs.MTabs;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(IndustriaNova.MODID)
public class IndustriaNova {
    public static final String MODID = "ind_nova";
    public static final Logger LOGGER = LogUtils.getLogger();

    public IndustriaNova(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        MItems.register(modEventBus);
        MBlocks.register(modEventBus);
        MTabs.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        LOGGER.info("Content created! Welcome to INDUSTRIALIZATION!");
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
