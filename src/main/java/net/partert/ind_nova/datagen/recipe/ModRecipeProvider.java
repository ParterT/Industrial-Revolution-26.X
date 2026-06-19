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
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.partert.ind_nova.IndustriaNova;
import net.partert.ind_nova.block.basic.MBlocksFuels;
import net.partert.ind_nova.block.basic.MBlocksMetals;
import net.partert.ind_nova.block.basic.MBlocksOres;
import net.partert.ind_nova.item.basic.MItemsFuels;
import net.partert.ind_nova.item.basic.MItemsMetals;
import net.partert.ind_nova.item.basic.MItemsOres;

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

        oreSmelting(List.of(MItemsOres.RAW_TIN, MBlocksOres.TIN_ORE, MBlocksOres.DEEPSLATE_TIN_ORE),
                RecipeCategory.MISC, CookingBookCategory.MISC, MItemsMetals.TIN_INGOT.get(),
                0.25f, 200, "azurite_ingot");
        oreBlasting(List.of(MItemsOres.RAW_TIN, MBlocksOres.TIN_ORE, MBlocksOres.DEEPSLATE_TIN_ORE),
                RecipeCategory.MISC, CookingBookCategory.MISC, MItemsMetals.TIN_INGOT.get(),
                0.25f, 100, "azurite_ingot");
        oreSmelting(List.of(MBlocksOres.LIGNITE_ORE, MBlocksOres.DEEPSLATE_LIGNITE_ORE),
                RecipeCategory.MISC, CookingBookCategory.MISC, MItemsFuels.LIGNITE.get(),
                0.25f, 200, "lignite");
        oreBlasting(List.of(MBlocksOres.LIGNITE_ORE, MBlocksOres.DEEPSLATE_LIGNITE_ORE),
                RecipeCategory.MISC, CookingBookCategory.MISC, MItemsFuels.LIGNITE.get(),
                0.25f, 100, "lignite");
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
