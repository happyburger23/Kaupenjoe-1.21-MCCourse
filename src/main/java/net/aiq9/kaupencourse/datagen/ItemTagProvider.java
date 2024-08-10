package net.aiq9.kaupencourse.datagen;

import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.item.ModItems;
import net.aiq9.kaupencourse.util.CustomTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(CustomTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.FLUORITE)
                .add(ModItems.RAW_FLUORITE)
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.APPLE)
        ;

        getOrCreateTagBuilder(ItemTags.LOGS)
                .add(ModBlocks.BLACKWOOD_LOG.asItem())
                .add(ModBlocks.BLACKWOOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_BLACKWOOD_LOG.asItem())
                .add(ModBlocks.STRIPPED_BLACKWOOD_WOOD.asItem())
        ;

        getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.BLACKWOOD_PLANKS.asItem());
    }
}
