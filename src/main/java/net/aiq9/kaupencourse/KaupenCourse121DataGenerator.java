package net.aiq9.kaupencourse;

import net.aiq9.kaupencourse.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class KaupenCourse121DataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BlockStateModelProvider::new);
		pack.addProvider(BlockTagProvider::new);
		pack.addProvider(ItemTagProvider::new);
		pack.addProvider(LoottableProvider::new);
		pack.addProvider(RecipeProvider::new);
		pack.addProvider(ModPOITagProvider::new);
		pack.addProvider(ModFluidTagProvider::new);
	}
}
