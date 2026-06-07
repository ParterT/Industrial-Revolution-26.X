package net.partert.irevolution.datagen;

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
import net.partert.irevolution.IndustrialRevolution;
import net.partert.irevolution.block.MBlocks;
import net.partert.irevolution.item.MItems;

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
            return "IndustrialRevolution Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        modBlockStorageRecipe(RecipeCategory.MISC, MItems.RAW_TIN, RecipeCategory.BUILDING_BLOCKS, MBlocks.RAW_TIN_BLOCK);
        modBlockStorageRecipe(RecipeCategory.MISC, MItems.TIN_INGOT, RecipeCategory.BUILDING_BLOCKS, MBlocks.TIN_BLOCK);
        modBlockStorageRecipe(RecipeCategory.MISC, MItems.TIN_NUGGET, RecipeCategory.MISC, MItems.TIN_INGOT);
        modBlockStorageRecipe(RecipeCategory.MISC, MItems.LIGNITE, RecipeCategory.BUILDING_BLOCKS, MBlocks.LIGNITE_BLOCK);

        oreSmelting(List.of(MItems.RAW_TIN, MBlocks.TIN_ORE, MBlocks.DEEPSLATE_TIN_ORE), RecipeCategory.MISC, CookingBookCategory.MISC, MItems.TIN_INGOT.get(), 0.25f, 200, "azurite_ingot");
        oreBlasting(List.of(MItems.RAW_TIN, MBlocks.TIN_ORE, MBlocks.DEEPSLATE_TIN_ORE), RecipeCategory.MISC, CookingBookCategory.MISC, MItems.TIN_INGOT.get(), 0.25f, 100, "azurite_ingot");
        oreSmelting(List.of(MBlocks.LIGNITE_ORE, MBlocks.DEEPSLATE_LIGNITE_ORE), RecipeCategory.MISC, CookingBookCategory.MISC, MItems.LIGNITE.get(), 0.25f, 200, "lignite");
        oreBlasting(List.of(MBlocks.LIGNITE_ORE, MBlocks.DEEPSLATE_LIGNITE_ORE), RecipeCategory.MISC, CookingBookCategory.MISC, MItems.LIGNITE.get(), 0.25f, 100, "lignite");
    }



    protected void modBlockStorageRecipe(RecipeCategory unpackCategory, ItemLike unpacked, RecipeCategory packCategory, ItemLike packed) {

        this.shapeless(unpackCategory, unpacked, 9).requires(packed).group(BuiltInRegistries.ITEM.getKey(unpacked.asItem()).getPath())
                .unlockedBy(getHasName(packed), this.has(packed))
                .save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse(IndustrialRevolution.MODID+":"+BuiltInRegistries.ITEM.getKey(unpacked.asItem()).getPath()+"_from_"+BuiltInRegistries.BLOCK.getKey(Block.byItem(packed.asItem())).getPath())));
        this.shaped(packCategory, packed).define('#', unpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(BuiltInRegistries.BLOCK.getKey(Block.byItem(packed.asItem())).getPath())
                .unlockedBy(getHasName(unpacked), this.has(unpacked))
                .save(this.output, ResourceKey.create(Registries.RECIPE, Identifier.parse(IndustrialRevolution.MODID+":"+BuiltInRegistries.BLOCK.getKey(Block.byItem(packed.asItem())).getPath()+"_from_"+BuiltInRegistries.ITEM.getKey(unpacked.asItem()).getPath())));

    }
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables,
                                                                RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result,
                                                                float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemlike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(output, IndustrialRevolution.MODID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemlike));
        }
    }

}
