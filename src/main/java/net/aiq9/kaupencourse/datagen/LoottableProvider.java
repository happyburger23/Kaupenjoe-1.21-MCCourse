package net.aiq9.kaupencourse.datagen;

import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.block.custom.StrawberryCropBlock;
import net.aiq9.kaupencourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LoottableProvider extends FabricBlockLootTableProvider {
    public LoottableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MAGIC_BLOCK);
        addDrop(ModBlocks.FLUORITE_LAMP);
        addDrop(ModBlocks.FLUORITE_BLOCK);

        addDrop(ModBlocks.FLUORITE_STAIRS);
        addDrop(ModBlocks.FLUORITE_SLAB, slabDrops(ModBlocks.FLUORITE_SLAB));
        addDrop(ModBlocks.FLUORITE_PRESSURE_PLATE);
        addDrop(ModBlocks.FLUORITE_BUTTON);
        addDrop(ModBlocks.FLUORITE_FENCE);
        addDrop(ModBlocks.FLUORITE_FENCE_GATE);
        addDrop(ModBlocks.FLUORITE_WALL);
        addDrop(ModBlocks.FLUORITE_DOOR, doorDrops(ModBlocks.FLUORITE_DOOR));
        addDrop(ModBlocks.FLUORITE_TRAPDOOR);

        //fluorite ores
        addDrop(ModBlocks.FLUORITE_ORE, oreDrops(ModBlocks.FLUORITE_ORE, ModItems.RAW_FLUORITE));
        addDrop(ModBlocks.DEEPSLATE_FLUORITE_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_FLUORITE_ORE, ModItems.RAW_FLUORITE, 2, 5));
        addDrop(ModBlocks.NETHER_FLUORITE_ORE, multipleOreDrops(ModBlocks.NETHER_FLUORITE_ORE, ModItems.RAW_FLUORITE, 1, 7));
        addDrop(ModBlocks.END_FLUORITE_ORE, multipleOreDrops(ModBlocks.END_FLUORITE_ORE, ModItems.RAW_FLUORITE, 4, 8));

        //crop
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.STRAWBERRY_CROP_BLOCK)
                .properties(StatePredicate.Builder.create().exactMatch(StrawberryCropBlock.AGE, 5));
        this.addDrop(ModBlocks.STRAWBERRY_CROP_BLOCK, this.cropDrops(ModBlocks.STRAWBERRY_CROP_BLOCK, ModItems.STRAWBERRY, ModItems.STRAWBERRY_SEEDS, builder));

        //flower
        addDrop(ModBlocks.DAHLIA);
        addDrop(ModBlocks.POTTED_DAHLIA, pottedPlantDrops(ModBlocks.DAHLIA));

        //blackwood stuff
        addDrop(ModBlocks.BLACKWOOD_LOG);
        addDrop(ModBlocks.BLACKWOOD_WOOD);
        addDrop(ModBlocks.STRIPPED_BLACKWOOD_LOG);
        addDrop(ModBlocks.STRIPPED_BLACKWOOD_WOOD);
        addDrop(ModBlocks.BLACKWOOD_PLANKS);
        addDrop(ModBlocks.BLACKWOOD_SAPLING);

        addDrop(ModBlocks.BLACKWOOD_LEAVES, leavesDrops(ModBlocks.BLACKWOOD_LEAVES, ModBlocks.BLACKWOOD_SAPLING, 0.0625f));
    }

    //HELPER METHOD
    //deepslate/nether/end ore drops - multiple items
    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(
                drop, ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                        .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
