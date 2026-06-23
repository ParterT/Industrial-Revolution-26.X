package net.partert.ind_nova.attachment;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.tags.MTags;

@EventBusSubscriber(modid = IndustriaNova.MODID)
public class LeadPoisoning {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post tickEvent) {
        Player player = tickEvent.getEntity();

        if (player.level().isClientSide()) { return; }

        if (player.tickCount % 20 != 0) { return; }

    int leadLVL = player.getData(MAttachments.LEAD_LEVEL);
    int leadItems = 0;
    Inventory inventory = player.getInventory();

    for (int i = 0; i<inventory.getContainerSize(); i++) {
        ItemStack itemStack = inventory.getItem(i);

        if (itemStack.is(MTags.Items.LEAD_CONTAINING)) {
            leadItems += itemStack.getCount();
        }
    }
    if (leadItems > 0) { leadLVL+=Math.max(1, leadItems/2); }
    else if (leadLVL > 0) {
        leadLVL--;
    }

    player.setData(MAttachments.LEAD_LEVEL, leadLVL);

    LeadEffect(player, leadLVL);
    }

    private static void LeadEffect(Player player, int leadLVL) {
        if (leadLVL > 1000) {
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 100, 1, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 100, 0, true, false));

            if (player.tickCount % 100 == 0) {
                player.hurt(player.damageSources().magic(), 2f);
            }
        }
        else if (leadLVL > 500) {
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 1, true, false));
            player.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 100, 0, true, false));
        }

        else if (leadLVL > 100) {
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 0, true, false));
        }
    }
}