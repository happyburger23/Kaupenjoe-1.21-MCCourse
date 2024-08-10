package net.aiq9.kaupencourse.fluid;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid STILL_FLUORITE_WATER = Registry.register(Registries.FLUID,
            Identifier.of(KaupenCourse121.MOD_ID, "fluorite_water"), new FluoriteWaterFluid.Still());

    //flowing
    public static final FlowableFluid FLOWING_FLUORITE_WATER = Registry.register(Registries.FLUID,
            Identifier.of(KaupenCourse121.MOD_ID, "flowing_fluorite_water"), new FluoriteWaterFluid.Flowing());

    //water block (NOT THE ACTUAL FLUID. SEE FLUORITEWATERFLUID CLASS)
    public static final Block FLUORITE_WATER_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(KaupenCourse121.MOD_ID,
            "fluorite_water_block"), new FluidBlock(ModFluids.STILL_FLUORITE_WATER, Block.Settings.copy(Blocks.WATER)
            .replaceable().liquid()));

    //bucket item
    public static final Item FLUORITE_WATER_BUCKET = Registry.register(Registries.ITEM, Identifier.of(KaupenCourse121.MOD_ID,
            "fluorite_water_bucket"), new BucketItem(ModFluids.STILL_FLUORITE_WATER,
            new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

    //HELPER METHODS
    public static void registerFluids() {
        KaupenCourse121.LOGGER.info("Registering Fluids for " + KaupenCourse121.MOD_ID);
    }
}
