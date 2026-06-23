package net.partert.ind_nova;

import net.partert.ind_nova.attachment.MAttachments;
import net.partert.ind_nova.block.basic.MBlocksFuels;
import net.partert.ind_nova.block.basic.MBlocksMetals;
import net.partert.ind_nova.block.basic.MBlocksOres;
import net.partert.ind_nova.block.basic.MBlocksStones;
import net.partert.ind_nova.item.basic.MItemsFuels;
import net.partert.ind_nova.item.basic.MItemsMaterials;
import net.partert.ind_nova.item.basic.MItemsMetals;
import net.partert.ind_nova.item.basic.MItemsOres;
import net.partert.ind_nova.tabs.MTabsMachines;
import net.partert.ind_nova.tabs.MTabsMaterials;
import net.partert.ind_nova.tabs.MTabsOres;
import net.partert.ind_nova.tabs.MTabsWorld;
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

        /* ITEMS REGISTER */
        MItemsFuels.register(modEventBus);
        MItemsMetals.register(modEventBus);
        MItemsOres.register(modEventBus);
        MItemsMaterials.register(modEventBus);

        /* BLOCKS REGISTER */
        MBlocksStones.register(modEventBus);
        MBlocksOres.register(modEventBus);
        MBlocksMetals.register(modEventBus);
        MBlocksFuels.register(modEventBus);

        /* CREATIVE TABS REGISTER */
        MTabsOres.register(modEventBus);
        MTabsMaterials.register(modEventBus);
        MTabsMachines.register(modEventBus);
        MTabsWorld.register(modEventBus);

        /* ATTACHMENTS */
        MAttachments.register(modEventBus);

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
