package net.partert.ind_nova.attachment;

import com.mojang.serialization.Codec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.partert.ind_nova.IndustriaNova;

import java.util.function.Supplier;

public class MAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS =
            DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, IndustriaNova.MODID);

    public static final Supplier<AttachmentType<Integer>> LEAD_LEVEL =
            ATTACHMENTS.register(
                    "lead_level",
                    () -> AttachmentType.builder(() -> 0)
                            .serialize(Codec.INT.fieldOf("value"))
                            .build()
            );

    public static void register(IEventBus eventBus) {
        ATTACHMENTS.register(eventBus);
    }
}
