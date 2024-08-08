package net.aiq9.kaupencourse.item;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
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
                        entries.add(ModItems.STARLIGHT_ASHES);
                    }).build());

    //block tab
    public static final ItemGroup FLUORITE_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(KaupenCourse121.MOD_ID, "fluorite_blocks"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fluorite_blocks"))
                    .icon(() -> new ItemStack(ModBlocks.FLUORITE_BLOCK)).entries((displayContext, entries) -> {
                        entries.add(Blocks.AMETHYST_BLOCK);
                        entries.add(Blocks.AMETHYST_CLUSTER);

                        entries.add(ModBlocks.FLUORITE_BLOCK);

                        entries.add(ModBlocks.FLUORITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_FLUORITE_ORE);
                        entries.add(ModBlocks.NETHER_FLUORITE_ORE);
                        entries.add(ModBlocks.END_FLUORITE_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);
                    }).build());

    public static void registerItemGroup() {
        KaupenCourse121.LOGGER.info("Registering Item Groups for " + KaupenCourse121.MOD_ID);
    }
}
