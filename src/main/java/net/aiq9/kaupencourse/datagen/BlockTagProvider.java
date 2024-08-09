package net.aiq9.kaupencourse.datagen;

import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.util.CustomTags;
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
                        ModBlocks.FLUORITE_STAIRS,
                        ModBlocks.FLUORITE_BUTTON,
                        ModBlocks.FLUORITE_PRESSURE_PLATE,
                        ModBlocks.FLUORITE_FENCE,
                        ModBlocks.FLUORITE_FENCE_GATE,
                        ModBlocks.FLUORITE_WALL,
                        ModBlocks.FLUORITE_DOOR,
                        ModBlocks.FLUORITE_TRAPDOOR,
                        ModBlocks.FLUORITE_LAMP
                );

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.END_FLUORITE_ORE,
                        ModBlocks.NETHER_FLUORITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.DEEPSLATE_FLUORITE_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.FLUORITE_FENCE); //connects to nether brick fence
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.FLUORITE_FENCE); //connects to wooden fence
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.FLUORITE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.FLUORITE_WALL);
        getOrCreateTagBuilder(BlockTags.DOORS).add(ModBlocks.FLUORITE_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS).add(ModBlocks.FLUORITE_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(ModBlocks.DAHLIA);

        getOrCreateTagBuilder(CustomTags.Blocks.PAXEL_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE)
        ;

    }
}
