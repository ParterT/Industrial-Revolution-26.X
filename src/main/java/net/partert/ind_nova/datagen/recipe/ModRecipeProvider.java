package net.partert.ind_nova.datagen.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.basic.MBlocksFuels;
import net.partert.ind_nova.block.basic.MBlocksMetals;
import net.partert.ind_nova.block.basic.MBlocksOres;
import net.partert.ind_nova.block.basic.MBlocksStones;
import net.partert.ind_nova.item.basic.MItemsFuels;
import net.partert.ind_nova.item.basic.MItemsMaterials;
import net.partert.ind_nova.item.basic.MItemsMetals;
import net.partert.ind_nova.item.basic.MItemsOres;
import net.partert.ind_nova.item.tool.MItemsTools;
import net.partert.ind_nova.tags.MTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "IndustriaNova Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        modBlockStorageRecipe(RecipeCategory.MISC, MItemsOres.RAW_TIN, RecipeCategory.BUILDING_BLOCKS, MBlocksMetals.RAW_TIN_BLOCK);
        modBlockStorageRecipe(RecipeCategory.MISC, MItemsMetals.TIN_INGOT, RecipeCategory.BUILDING_BLOCKS, MBlocksMetals.TIN_BLOCK);
        modBlockStorageRecipe(RecipeCategory.MISC, MItemsMetals.TIN_NUGGET, RecipeCategory.MISC, MItemsMetals.TIN_INGOT);

        modBlockStorageRecipe(RecipeCategory.MISC, MItemsFuels.LIGNITE, RecipeCategory.BUILDING_BLOCKS, MBlocksFuels.LIGNITE_BLOCK);

        modBlockStorageRecipe(RecipeCategory.MISC, MItemsOres.RAW_PLATINUM, RecipeCategory.BUILDING_BLOCKS, MBlocksMetals.RAW_PLATINUM_BLOCK);
        modBlockStorageRecipe(RecipeCategory.MISC, MItemsMetals.PLATINUM_INGOT, RecipeCategory.BUILDING_BLOCKS, MBlocksMetals.PLATINUM_BLOCK);
        modBlockStorageRecipe(RecipeCategory.MISC, MItemsMetals.PLATINUM_NUGGET, RecipeCategory.MISC, MItemsMetals.PLATINUM_INGOT);

        modBlockStorageRecipe(RecipeCategory.MISC, MItemsOres.RAW_LEAD, RecipeCategory.BUILDING_BLOCKS, MBlocksMetals.RAW_LEAD_BLOCK);
        modBlockStorageRecipe(RecipeCategory.MISC, MItemsMetals.LEAD_INGOT, RecipeCategory.BUILDING_BLOCKS, MBlocksMetals.LEAD_BLOCK);
        modBlockStorageRecipe(RecipeCategory.MISC, MItemsMetals.LEAD_NUGGET, RecipeCategory.MISC, MItemsMetals.LEAD_INGOT);

        modBlockStorageRecipe(RecipeCategory.MISC, MItemsMetals.STEEL_NUGGET, RecipeCategory.MISC, MItemsMetals.STEEL_INGOT);


        oreSmelting(List.of(MItemsOres.RAW_TIN, MBlocksOres.TIN_ORE, MBlocksOres.DEEPSLATE_TIN_ORE),
                RecipeCategory.MISC, CookingBookCategory.MISC, MItemsMetals.TIN_INGOT.get(),
                0.25f, 200, "tin_ingot");
        oreBlasting(List.of(MItemsOres.RAW_TIN, MBlocksOres.TIN_ORE, MBlocksOres.DEEPSLATE_TIN_ORE),
                RecipeCategory.MISC, CookingBookCategory.MISC, MItemsMetals.TIN_INGOT.get(),
                0.25f, 100, "tin_ingot");

        oreSmelting(List.of(MBlocksOres.LIGNITE_ORE, MBlocksOres.DEEPSLATE_LIGNITE_ORE),
                RecipeCategory.MISC, CookingBookCategory.MISC, MItemsFuels.LIGNITE.get(),
                0.25f, 200, "lignite");
        oreBlasting(List.of(MBlocksOres.LIGNITE_ORE, MBlocksOres.DEEPSLATE_LIGNITE_ORE),
                RecipeCategory.MISC, CookingBookCategory.MISC, MItemsFuels.LIGNITE.get(),
                0.25f, 100, "lignite");

        oreSmelting(List.of(MItemsOres.RAW_LEAD, MBlocksOres.LEAD_ORE, MBlocksOres.DEEPSLATE_LEAD_ORE),
                RecipeCategory.MISC, CookingBookCategory.MISC, MItemsMetals.LEAD_INGOT.get(),
                0.25f, 200, "lead_ingot");
        oreBlasting(List.of(MItemsOres.RAW_LEAD, MBlocksOres.LEAD_ORE, MBlocksOres.DEEPSLATE_LEAD_ORE),
                RecipeCategory.MISC, CookingBookCategory.MISC, MItemsMetals.LEAD_INGOT.get(),
                0.25f, 100, "lead_ingot");

        oreBlasting(List.of(Items.IRON_INGOT),
                RecipeCategory.MISC, CookingBookCategory.MISC, MItemsMetals.STEEL_INGOT.get(),
                0.25f, 200, "steel_ingot");


        stairBuilder(MBlocksStones.MARBLE_STAIRS.get(), Ingredient.of(MBlocksStones.MARBLE))
                .unlockedBy(getHasName(MBlocksStones.MARBLE.get()), has(MBlocksStones.MARBLE))
                .group("marble").save(output);
        stairBuilder(MBlocksStones.GABBRO_STAIRS.get(), Ingredient.of(MBlocksStones.GABBRO))
                .unlockedBy(getHasName(MBlocksStones.GABBRO.get()), has(MBlocksStones.GABBRO))
                .group("gabbro").save(output);
        stairBuilder(MBlocksStones.SCHIST_STAIRS.get(), Ingredient.of(MBlocksStones.SCHIST))
                .unlockedBy(getHasName(MBlocksStones.SCHIST.get()), has(MBlocksStones.SCHIST))
                .group("micaceous_schist").save(output);
        stairBuilder(MBlocksStones.LIMESTONE_STAIRS.get(), Ingredient.of(MBlocksStones.LIMESTONE))
                .unlockedBy(getHasName(MBlocksStones.LIMESTONE.get()), has(MBlocksStones.LIMESTONE))
                .group("limestone").save(output);

        slab(RecipeCategory.BUILDING_BLOCKS, MBlocksStones.MARBLE_SLAB.get(), MBlocksStones.MARBLE.get());
        slab(RecipeCategory.BUILDING_BLOCKS, MBlocksStones.GABBRO_SLAB.get(), MBlocksStones.GABBRO.get());
        slab(RecipeCategory.BUILDING_BLOCKS, MBlocksStones.SCHIST_SLAB.get(), MBlocksStones.SCHIST.get());
        slab(RecipeCategory.BUILDING_BLOCKS, MBlocksStones.LIMESTONE_SLAB.get(), MBlocksStones.LIMESTONE.get());

        shaped(RecipeCategory.TOOLS, MItemsTools.STONE_HAMMER.get())
                .pattern("III")
                .pattern("III")
                .pattern(" S ")
                .define('I', Items.COBBLESTONE).define('S', Items.STICK)
                .group("stone_hammer")
                .unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
                .save(output);
        shaped(RecipeCategory.TOOLS, MItemsTools.COPPER_HAMMER.get())
                .pattern("III")
                .pattern("III")
                .pattern(" S ")
                .define('I', Items.COPPER_INGOT).define('S', Items.STICK)
                .group("copper_hammer")
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(output);
        shaped(RecipeCategory.TOOLS, MItemsTools.IRON_HAMMER.get())
                .pattern("III")
                .pattern("III")
                .pattern(" S ")
                .define('I', Items.IRON_INGOT).define('S', Items.STICK)
                .group("iron_hammer")
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(output);
        shaped(RecipeCategory.TOOLS, MItemsTools.STEEL_HAMMER.get())
                .pattern("III")
                .pattern("III")
                .pattern(" S ")
                .define('I', MItemsMetals.STEEL_INGOT.get()).define('S', Items.STICK)
                .group("steel_hammer")
                .unlockedBy(getHasName(MItemsMetals.STEEL_INGOT.get()), has(MItemsMetals.STEEL_INGOT))
                .save(output);
        shaped(RecipeCategory.TOOLS, MItemsTools.DIAMOND_HAMMER.get())
                .pattern("DDD")
                .pattern("DDD")
                .pattern(" S ")
                .define('D', Items.DIAMOND).define('S', Items.STICK)
                .group("diamond_hammer")
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(output);
        shaped(RecipeCategory.TOOLS, MItemsTools.GOLDEN_HAMMER.get())
                .pattern("III")
                .pattern("III")
                .pattern(" S ")
                .define('I', Items.GOLD_INGOT).define('S', Items.STICK)
                .group("golden_hammer")
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(output);

        netheriteSmithing(MItemsTools.DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, MItemsTools.NETHERITE_HAMMER.get());


        shaped(RecipeCategory.TOOLS, MItemsTools.STEEL_SWORD.get())
                .pattern("I")
                .pattern("I")
                .pattern("S")
                .define('I', MItemsMetals.STEEL_INGOT).define('S', Items.STICK)
                .group("steel_sword")
                .unlockedBy(getHasName(MItemsMetals.STEEL_INGOT.get()), has(MItemsMetals.STEEL_INGOT))
                .save(output);
        shaped(RecipeCategory.TOOLS, MItemsTools.STEEL_AXE.get())
                .pattern("II")
                .pattern("IS")
                .pattern(" S")
                .define('I', MItemsMetals.STEEL_INGOT).define('S', Items.STICK)
                .group("steel_axe")
                .unlockedBy(getHasName(MItemsMetals.STEEL_INGOT.get()), has(MItemsMetals.STEEL_INGOT))
                .save(output);
        shaped(RecipeCategory.TOOLS, MItemsTools.STEEL_PICKAXE.get())
                .pattern("III")
                .pattern(" S ")
                .pattern(" S ")
                .define('I', MItemsMetals.STEEL_INGOT).define('S', Items.STICK)
                .group("steel_pickaxe")
                .unlockedBy(getHasName(MItemsMetals.STEEL_INGOT.get()), has(MItemsMetals.STEEL_INGOT))
                .save(output);
        shaped(RecipeCategory.TOOLS, MItemsTools.STEEL_SHOVEL.get())
                .pattern("I")
                .pattern("S")
                .pattern("S")
                .define('I', MItemsMetals.STEEL_INGOT).define('S', Items.STICK)
                .group("steel_shovel")
                .unlockedBy(getHasName(MItemsMetals.STEEL_INGOT.get()), has(MItemsMetals.STEEL_INGOT))
                .save(output);
        shaped(RecipeCategory.TOOLS, MItemsTools.STEEL_HOE.get())
                .pattern("II")
                .pattern(" S")
                .pattern(" S")
                .define('I', MItemsMetals.STEEL_INGOT).define('S', Items.STICK)
                .group("steel_hoe")
                .unlockedBy(getHasName(MItemsMetals.STEEL_INGOT.get()), has(MItemsMetals.STEEL_INGOT))
                .save(output);
        shaped(RecipeCategory.TOOLS, MItemsTools.STEEL_SPEAR.get())
                .pattern("  I")
                .pattern(" S ")
                .pattern("S  ")
                .define('I', MItemsMetals.STEEL_INGOT).define('S', Items.STICK)
                .group("steel_spear")
                .unlockedBy(getHasName(MItemsMetals.STEEL_INGOT.get()), has(MItemsMetals.STEEL_INGOT))
                .save(output);
    }



    protected void modBlockStorageRecipe(RecipeCategory unpackCategory, ItemLike unpacked, RecipeCategory packCategory, ItemLike packed) {
        String packedName = getPackedName(packed);
        String unpackedName = BuiltInRegistries.ITEM.getKey(unpacked.asItem()).getPath();

        this.shapeless(unpackCategory, unpacked, 9).requires(packed).group(unpackedName)
                .unlockedBy(getHasName(packed), this.has(packed))
                .save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse(IndustriaNova.MODID+":"+unpackedName+"_from_"+packedName)));
        this.shaped(packCategory, packed).define('#', unpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(packedName)
                .unlockedBy(getHasName(unpacked), this.has(unpacked))
                .save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse(IndustriaNova.MODID+":"+packedName+"_from_"+unpackedName)));

    }

    private String getPackedName(ItemLike packed) {
        Block block = Block.byItem(packed.asItem());
        if (block != Blocks.AIR) {
            return BuiltInRegistries.BLOCK.getKey(block).getPath();
        } else {
            return BuiltInRegistries.ITEM.getKey(packed.asItem()).getPath();
        }
    }
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, IndustriaNova.MODID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }

}
