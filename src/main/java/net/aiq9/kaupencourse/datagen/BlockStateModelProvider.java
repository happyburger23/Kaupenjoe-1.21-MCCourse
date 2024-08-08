package net.aiq9.kaupencourse.datagen;

import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class BlockStateModelProvider extends FabricModelProvider {
    public BlockStateModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool fluoriteBlockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.FLUORITE_BLOCK);
        fluoriteBlockPool.stairs(ModBlocks.FLUORITE_STAIRS);
        fluoriteBlockPool.slab(ModBlocks.FLUORITE_SLAB);
        fluoriteBlockPool.button(ModBlocks.FLUORITE_BUTTON);
        fluoriteBlockPool.pressurePlate(ModBlocks.FLUORITE_PRESSURE_PLATE);
        fluoriteBlockPool.fence(ModBlocks.FLUORITE_FENCE);
        fluoriteBlockPool.fenceGate(ModBlocks.FLUORITE_FENCE_GATE);
        fluoriteBlockPool.wall(ModBlocks.FLUORITE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.FLUORITE_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.FLUORITE_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FLUORITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_FLUORITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_FLUORITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_FLUORITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FLUORITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FLUORITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHAINSAW, Models.HANDHELD);
    }
}
