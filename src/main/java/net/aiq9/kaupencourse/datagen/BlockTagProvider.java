package net.aiq9.kaupencourse.datagen;

import net.aiq9.kaupencourse.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.FLUORITE_BLOCK,
                        ModBlocks.FLUORITE_ORE,
                        ModBlocks.DEEPSLATE_FLUORITE_ORE,
                        ModBlocks.NETHER_FLUORITE_ORE,
                        ModBlocks.END_FLUORITE_ORE,
                        ModBlocks.MAGIC_BLOCK,
                        ModBlocks.FLUORITE_SLAB,
                        ModBlocks.FLUORITE_STAIRS
                );

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.END_FLUORITE_ORE,
                        ModBlocks.NETHER_FLUORITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.DEEPSLATE_FLUORITE_ORE);
    }
}
