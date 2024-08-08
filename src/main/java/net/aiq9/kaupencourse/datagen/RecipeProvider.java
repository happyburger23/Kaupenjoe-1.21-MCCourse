package net.aiq9.kaupencourse.datagen;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> FLUORITE_SMELTABLES = List.of(ModItems.RAW_FLUORITE, ModBlocks.FLUORITE_ORE,
                ModBlocks.DEEPSLATE_FLUORITE_ORE, ModBlocks.NETHER_FLUORITE_ORE, ModBlocks.END_FLUORITE_ORE);

        offerSmelting(exporter, FLUORITE_SMELTABLES, RecipeCategory.MISC, ModItems.FLUORITE, 0.2f, 200, "fluorite");
        offerBlasting(exporter, FLUORITE_SMELTABLES, RecipeCategory.MISC, ModItems.FLUORITE, 0.2f, 100, "fluorite");

        //fluorite block
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.FLUORITE, RecipeCategory.DECORATIONS, ModBlocks.FLUORITE_BLOCK);

        //raw fluorite item crafting recipe
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_FLUORITE)
                .pattern("SSS")
                .pattern("SFS")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('F', ModItems.FLUORITE)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .offerTo(exporter);


        //raw fluorite item crafting recipe 2
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_FLUORITE)
                .pattern("SSS")
                .pattern("FFF")
                .pattern("SSS")
                .input('S', Items.STONE)
                .input('F', ModItems.FLUORITE)
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .offerTo(exporter, Identifier.of(KaupenCourse121.MOD_ID, "raw_fluorite_2"));

        //stairs
        createStairsRecipe(ModBlocks.FLUORITE_STAIRS, Ingredient.ofItems(ModBlocks.FLUORITE_BLOCK))
                .criterion(hasItem(ModBlocks.FLUORITE_STAIRS), conditionsFromItem(ModBlocks.FLUORITE_STAIRS))
                .offerTo(exporter, getRecipeName(ModBlocks.FLUORITE_STAIRS));

        //slabs
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLUORITE_SLAB, ModBlocks.FLUORITE_BLOCK);
    }
}
