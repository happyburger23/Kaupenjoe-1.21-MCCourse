package net.aiq9.kaupencourse.datagen;

import net.aiq9.kaupencourse.fluid.ModFluids;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.FluidTags;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagProvider extends FabricTagProvider.FluidTagProvider {
    public ModFluidTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        this.getOrCreateTagBuilder(FluidTags.WATER)
                .add(ModFluids.STILL_FLUORITE_WATER)
                .add(ModFluids.FLOWING_FLUORITE_WATER);
    }
}
