package net.aiq9.kaupencourse.datagen;

import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.block.custom.FluoriteLampBlock;
import net.aiq9.kaupencourse.block.custom.StrawberryCropBlock;
import net.aiq9.kaupencourse.fluid.ModFluids;
import net.aiq9.kaupencourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

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

        //fluorite lamp
        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.FLUORITE_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.FLUORITE_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.FLUORITE_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(FluoriteLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

        //crop
        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRY_CROP_BLOCK, StrawberryCropBlock.AGE, 0, 1, 2, 3, 4, 5);

        //dahlia flower
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.DAHLIA, ModBlocks.POTTED_DAHLIA, BlockStateModelGenerator.TintType.NOT_TINTED);

        //colored leaves
        blockStateModelGenerator.registerSingleton(ModBlocks.COLORED_LEAVES, TexturedModel.LEAVES);

        //blackwood things
        blockStateModelGenerator.registerLog(ModBlocks.BLACKWOOD_LOG).log(ModBlocks.BLACKWOOD_LOG).wood(ModBlocks.BLACKWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_BLACKWOOD_LOG).log(ModBlocks.STRIPPED_BLACKWOOD_LOG).wood(ModBlocks.STRIPPED_BLACKWOOD_WOOD);
        blockStateModelGenerator.registerSingleton(ModBlocks.BLACKWOOD_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLACKWOOD_PLANKS);

        blockStateModelGenerator.registerTintableCross(ModBlocks.BLACKWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FLUORITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FLUORITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY, Models.GENERATED);
        //itemModelGenerator.register(ModItems.STRAWBERRY_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAR_BRAWL_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModFluids.FLUORITE_WATER_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.CHAINSAW, Models.HANDHELD);

        itemModelGenerator.register(ModItems.FLUORITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLUORITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLUORITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLUORITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLUORITE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.FLUORITE_PAXEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLUORITE_HAMMER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.HANDHELD);

        itemModelGenerator.register(ModItems.FLUORITE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLUORITE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLUORITE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLUORITE_BOOTS, Models.GENERATED);
    }
}
