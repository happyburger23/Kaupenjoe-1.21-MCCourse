package net.aiq9.kaupencourse.block;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.block.custom.*;
import net.aiq9.kaupencourse.sound.ModSounds;
import net.aiq9.kaupencourse.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block FLUORITE_BLOCK = registerBlock("fluorite_block",
            new Block(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block FLUORITE_ORE = registerBlock("fluorite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 4),
                    AbstractBlock.Settings.create().strength(5f)));

    public static final Block DEEPSLATE_FLUORITE_ORE = registerBlock("deepslate_fluorite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(6f)));

    public static final Block NETHER_FLUORITE_ORE = registerBlock("nether_fluorite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 5),
                    AbstractBlock.Settings.create().strength(3f)));

    public static final Block END_FLUORITE_ORE = registerBlock("end_fluorite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(7f)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).sounds(ModSounds.MAGIC_BLOCK_SOUNDS)));

    //stairs
    public static final Block FLUORITE_STAIRS = registerBlock("fluorite_stairs",
            new StairsBlock(ModBlocks.FLUORITE_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.copy(ModBlocks.FLUORITE_BLOCK)));

    //slabs
    public static final Block FLUORITE_SLAB = registerBlock("fluorite_slab",
            new SlabBlock(AbstractBlock.Settings.copy(ModBlocks.FLUORITE_BLOCK)));

    //button
    public static final Block FLUORITE_BUTTON = registerBlock("fluorite_button",
            new ButtonBlock(BlockSetType.IRON, 10, AbstractBlock.Settings.copy(Blocks.STONE_BUTTON).noCollision()));

    //pressure plate
    public static final Block FLUORITE_PRESSURE_PLATE = registerBlock("fluorite_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE).noCollision()));

    //fence
    public static final Block FLUORITE_FENCE = registerBlock("fluorite_fence",
            new FenceBlock(AbstractBlock.Settings.copy(Blocks.OAK_FENCE)));

    //fence gate
    public static final Block FLUORITE_FENCE_GATE = registerBlock("fluorite_fence_gate",
            new FenceGateBlock(WoodType.OAK, AbstractBlock.Settings.copy(Blocks.OAK_FENCE_GATE)));

    //wall
    public static final Block FLUORITE_WALL = registerBlock("fluorite_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.COBBLESTONE_WALL)));

    //door
    public static final Block FLUORITE_DOOR = registerBlock("fluorite_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.COPPER_DOOR).nonOpaque()));

    //trapdoor
    public static final Block FLUORITE_TRAPDOOR = registerBlock("fluorite_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.COPPER_TRAPDOOR).nonOpaque()));

    //lamp block
    public static final Block FLUORITE_LAMP = registerBlock("fluorite_lamp",
            new FluoriteLampBlock(AbstractBlock.Settings.copy(Blocks.REDSTONE_LAMP).sounds(BlockSoundGroup.AMETHYST_BLOCK).luminance(state -> state.get(FluoriteLampBlock.CLICKED) ? 15 : 0)));

    //strawberry crop block
    public static final Block STRAWBERRY_CROP_BLOCK = registerBlockWithoutBlockItem("strawberry_crop",
            new StrawberryCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    //dahlia flower
    public static final Block DAHLIA = registerBlock("dahlia",
            new FlowerBlock(StatusEffects.FIRE_RESISTANCE, 4, AbstractBlock.Settings.copy(Blocks.ALLIUM)));

    public static final Block POTTED_DAHLIA = registerBlockWithoutBlockItem("potted_dahlia",
            new FlowerPotBlock(ModBlocks.DAHLIA, AbstractBlock.Settings.copy(Blocks.POTTED_ALLIUM)));

    //colored leaves
    public static final Block COLORED_LEAVES = registerBlock("colored_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    //pedestal
    public static final Block PEDESTAL = registerBlock("pedestal",
        new PedestalBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE).nonOpaque()));

    //blackwood tree stuff
    public static final Block BLACKWOOD_LOG = registerBlock("blackwood_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block BLACKWOOD_WOOD = registerBlock("blackwood_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_BLACKWOOD_LOG = registerBlock("stripped_blackwood_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_BLACKWOOD_WOOD = registerBlock("stripped_blackwood_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block BLACKWOOD_PLANKS = registerBlock("blackwood_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));

    public static final Block BLACKWOOD_LEAVES = registerBlock("blackwood_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block BLACKWOOD_SAPLING = registerBlock("blackwood_sapling",
            new SaplingBlock(ModSaplingGenerators.BLACKWOOD, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));
    //can also use SaplingBlock for regular tree things
    /*
    new ModSaplingBlock(... .Blocks.Blocks.END_STONE)
     */

    //HELPER METHODS
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
