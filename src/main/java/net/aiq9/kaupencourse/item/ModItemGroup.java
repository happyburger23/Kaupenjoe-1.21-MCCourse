package net.aiq9.kaupencourse.item;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.fluid.ModFluids;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    //item tab
    public static final ItemGroup FLUORITE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(KaupenCourse121.MOD_ID, "fluorite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluorite"))
                    .icon(() -> new ItemStack(ModItems.FLUORITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_FLUORITE);
                        entries.add(ModItems.FLUORITE);
                        entries.add(ModItems.CHAINSAW);
                        entries.add(ModItems.STRAWBERRY);
                        entries.add(ModItems.STRAWBERRY_SEEDS);
                        entries.add(ModItems.STARLIGHT_ASHES);

                        entries.add(ModItems.FLUORITE_SWORD);
                        entries.add(ModItems.FLUORITE_PICKAXE);
                        entries.add(ModItems.FLUORITE_SHOVEL);
                        entries.add(ModItems.FLUORITE_AXE);
                        entries.add(ModItems.FLUORITE_HOE);

                        entries.add(ModItems.FLUORITE_PAXEL);
                        entries.add(ModItems.FLUORITE_HAMMER);

                        entries.add(ModItems.KAUPEN_BOW);

                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.DATA_TABLET);
                        entries.add(ModItems.BAR_BRAWL_MUSIC_DISC);
                        entries.add(ModItems.SPECTRE_STAFF);
                        entries.add(ModFluids.FLUORITE_WATER_BUCKET);

                        entries.add(ModItems.DODO_SPAWN_EGG);

                        entries.add(ModItems.FLUORITE_HELMET);
                        entries.add(ModItems.FLUORITE_CHESTPLATE);
                        entries.add(ModItems.FLUORITE_LEGGINGS);
                        entries.add(ModItems.FLUORITE_BOOTS);
                    }).build());

    //block tab
    public static final ItemGroup FLUORITE_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(KaupenCourse121.MOD_ID, "fluorite_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluorite_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.FLUORITE_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FLUORITE_BLOCK);
                        entries.add(ModBlocks.FLUORITE_STAIRS);
                        entries.add(ModBlocks.FLUORITE_SLAB );
                        entries.add(ModBlocks.FLUORITE_BUTTON);
                        entries.add(ModBlocks.FLUORITE_PRESSURE_PLATE);

                        entries.add(ModBlocks.FLUORITE_FENCE);
                        entries.add(ModBlocks.FLUORITE_FENCE_GATE);
                        entries.add(ModBlocks.FLUORITE_WALL);
                        entries.add(ModBlocks.FLUORITE_DOOR);
                        entries.add(ModBlocks.FLUORITE_TRAPDOOR);

                        entries.add(ModBlocks.FLUORITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_FLUORITE_ORE);
                        entries.add(ModBlocks.NETHER_FLUORITE_ORE);
                        entries.add(ModBlocks.END_FLUORITE_ORE);

                        entries.add(ModBlocks.BLACKWOOD_LOG);
                        entries.add(ModBlocks.BLACKWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_BLACKWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_BLACKWOOD_WOOD);
                        entries.add(ModBlocks.BLACKWOOD_PLANKS);
                        entries.add(ModBlocks.BLACKWOOD_LEAVES);
                        entries.add(ModBlocks.BLACKWOOD_SAPLING);

                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModBlocks.FLUORITE_LAMP);
                        entries.add(ModBlocks.COLORED_LEAVES);
                        entries.add(ModBlocks.PEDESTAL);
                        entries.add(ModBlocks.DAHLIA);
                    }).build());

    public static void registerItemGroups() {
        KaupenCourse121.LOGGER.info("Registering Item Groups for " + KaupenCourse121.MOD_ID);
    }
}
