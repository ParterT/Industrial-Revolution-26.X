package net.partert.ind_nova.tags;

import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.partert.ind_nova.IndustriaNova;

public class MTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_STEEL_TOOL = createTag("needs_steel_tool");
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = createTag("incorrect_for_steel_tool");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(IndustriaNova.MODID, name));
        }
    }
    public static class Items {

        public static final TagKey<Item> LEAD_CONTAINING = createTag("lead_containing");
        public static final TagKey<Item> STEEL_REPAIRABLE = createTag("steel_repairable");
        public static final TagKey<Item> HAMMER_LIKE = createTag("hammers");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(IndustriaNova.MODID, name));
        }
    }
}
