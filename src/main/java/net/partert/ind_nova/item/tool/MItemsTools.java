package net.partert.ind_nova.item.tool;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.partert.ind_nova.IndustriaNova;

public class MItemsTools {
    public static final DeferredRegister.Items TOOL_ITEMS = DeferredRegister.createItems(IndustriaNova.MODID);

    /* HAMMERS */
    public static final DeferredItem<MHammerLikeItem> STONE_HAMMER = registerHammer("stone_hammer", HammerMaterialsList.STONE);
    public static final DeferredItem<MHammerLikeItem> COPPER_HAMMER = registerHammer("copper_hammer", HammerMaterialsList.STONE);
    public static final DeferredItem<MHammerLikeItem> IRON_HAMMER = registerHammer("iron_hammer", HammerMaterialsList.IRON);
    public static final DeferredItem<MHammerLikeItem> STEEL_HAMMER = registerHammer("steel_hammer", HammerMaterialsList.STEEL);
    public static final DeferredItem<MHammerLikeItem> DIAMOND_HAMMER = registerHammer("diamond_hammer", HammerMaterialsList.DIAMOND);
    public static final DeferredItem<MHammerLikeItem> GOLDEN_HAMMER = registerHammer("golden_hammer", HammerMaterialsList.GOLD);
    public static final DeferredItem<MHammerLikeItem> NETHERITE_HAMMER = registerHammer("netherite_hammer", HammerMaterialsList.NETHERITE);

    /* SWORDS */
    public static final DeferredItem<Item> STEEL_SWORD = TOOL_ITEMS.registerItem("steel_sword",
            properties -> new Item(properties.sword(MToolTiers.STEEL, 3f, -2.4f)));
    /* AXES */
    public static final DeferredItem<Item> STEEL_AXE = TOOL_ITEMS.registerItem("steel_axe",
            properties -> new AxeItem(MToolTiers.STEEL, 6f, -3.2f, properties));
    /* PICKAXES */
    public static final DeferredItem<Item> STEEL_PICKAXE = TOOL_ITEMS.registerItem("steel_pickaxe",
            properties -> new Item(properties.pickaxe(MToolTiers.STEEL, 1f, -2.8f)));
    /* SHOVELS */
    public static final DeferredItem<Item> STEEL_SHOVEL = TOOL_ITEMS.registerItem("steel_shovel",
            properties -> new ShovelItem(MToolTiers.STEEL, 1.5f, -3f, properties));
    /* HOES */
    public static final DeferredItem<Item> STEEL_HOE = TOOL_ITEMS.registerItem("steel_hoe",
            properties -> new HoeItem(MToolTiers.STEEL, 0f, -3f, properties));
    /* SPEARS */
    public static final DeferredItem<Item> STEEL_SPEAR = TOOL_ITEMS.registerItem("steel_spear",
            properties -> new Item(properties.spear(MToolTiers.STEEL, 1f, 1.05f, 0.55f, 3.25f, 10f, 7f, 5.1f, 10.5f, 4.6f)));


    public record HammerMaterial(int durability, float attackDamage, float attackSpeed, boolean fireResist) {}
    public class HammerMaterialsList {

        public static final HammerMaterial STONE =
                new HammerMaterial(131, 6f, -3.5f, false);
        public static final HammerMaterial COPPER =
                new HammerMaterial(190, 7f, -3.5f, false);
        public static final HammerMaterial IRON =
                new HammerMaterial(250, 8f, -3.5f, false);
        public static final HammerMaterial STEEL =
                new HammerMaterial(890, 9f, -3.5f, false);
        public static final HammerMaterial DIAMOND =
                new HammerMaterial(1561, 10f, -3.5f, false);
        public static final HammerMaterial GOLD =
                new HammerMaterial(32, 7f, -3.5f, false);
        public static final HammerMaterial NETHERITE =
                new HammerMaterial(2031, 11f, -3.5f, true);
    }

    private static DeferredItem<MHammerLikeItem> registerHammer(
            String name,
            HammerMaterial material
    ) {
        return TOOL_ITEMS.registerItem(name, properties -> {
            properties.stacksTo(1)
                    .durability(material.durability)
                    .component(
                            DataComponents.ATTRIBUTE_MODIFIERS,
                            MHammerLikeItem.hammerAttributes(
                                    material.attackDamage,
                                    material.attackSpeed
                            )
                    );

            if (material.fireResist) {
                properties.fireResistant();
            }

            return new MHammerLikeItem(properties);
        });
    }
    public static void register(IEventBus eventBus) {
        TOOL_ITEMS.register(eventBus);
    }
}
