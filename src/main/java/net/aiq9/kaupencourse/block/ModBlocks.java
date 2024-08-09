package net.aiq9.kaupencourse.block;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.block.custom.FluoriteLampBlock;
import net.aiq9.kaupencourse.block.custom.MagicBlock;
import net.aiq9.kaupencourse.block.custom.StrawberryCropBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final Block FLUORITE_BLOCK = registerBlock("fluorite_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .strength(4f).requiresTool()));

    public static final Block FLUORITE_ORE = registerBlock("fluorite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4),
                    AbstractBlock.Settings.create().strength(5f).requiresTool()));

    public static final Block DEEPSLATE_FLUORITE_ORE = registerBlock("deepslate_fluorite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(6f).requiresTool()));

    public static final Block NETHER_FLUORITE_ORE = registerBlock("nether_fluorite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block END_FLUORITE_ORE = registerBlock("end_fluorite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(7f).requiresTool()));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));

    //stairs
    public static final Block FLUORITE_STAIRS = registerBlock("fluorite_stairs",
            new StairsBlock(ModBlocks.FLUORITE_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    //slabs
    public static final Block FLUORITE_SLAB = registerBlock("fluorite_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    //button
    public static final Block FLUORITE_BUTTON = registerBlock("fluorite_button",
            new ButtonBlock(BlockSetType.IRON, 10, AbstractBlock.Settings.create().requiresTool().noCollision()));

    //pressure plate
    public static final Block FLUORITE_PRESSURE_PLATE = registerBlock("fluorite_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool().noCollision()));

    //fence
    public static final Block FLUORITE_FENCE = registerBlock("fluorite_fence",
            new FenceBlock(AbstractBlock.Settings.create().requiresTool()));

    //fence gate
    public static final Block FLUORITE_FENCE_GATE = registerBlock("fluorite_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.create().requiresTool()));

    //wall
    public static final Block FLUORITE_WALL = registerBlock("fluorite_wall",
            new WallBlock(AbstractBlock.Settings.create().requiresTool()));

    //door
    public static final Block FLUORITE_DOOR = registerBlock("fluorite_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool().nonOpaque()));

    //trapdoor
    public static final Block FLUORITE_TRAPDOOR = registerBlock("fluorite_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().requiresTool().nonOpaque()));

    //lamp block
    public static final Block FLUORITE_LAMP = registerBlock("fluorite_lamp",
            new FluoriteLampBlock(AbstractBlock.Settings.create()
                    .strength(1f).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool().luminance(state -> state.get(FluoriteLampBlock.CLICKED) ? 15 : 0)));

    //strawberry crop block
    public static final Block STRAWBERRY_CROP_BLOCK = registerBlockWithoutBlockItem("strawberry_crop",
            new StrawberryCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    //------------ HELPER METHODS
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(KaupenCourse121.MOD_ID, name),block);
    }


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);

        return Registry.register(Registries.BLOCK, Identifier.of(KaupenCourse121.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(KaupenCourse121.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBlocks() {
        KaupenCourse121.LOGGER.info("Registering Blocks for " + KaupenCourse121.MOD_ID);
    }
}
