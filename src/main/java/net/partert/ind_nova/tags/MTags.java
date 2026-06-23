package net.partert.ind_nova.tags;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.partert.ind_nova.IndustriaNova;

public class MTags {

    public static class Items {
        public static final TagKey<Item> LEAD_CONTAINING = createTag("lead_containing");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(IndustriaNova.MODID, name));
        }
    }
}
