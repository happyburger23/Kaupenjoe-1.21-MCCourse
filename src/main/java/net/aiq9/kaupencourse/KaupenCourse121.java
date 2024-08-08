package net.aiq9.kaupencourse;

import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.item.ModItemGroup;
import net.aiq9.kaupencourse.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KaupenCourse121 implements ModInitializer {
	public static final String MOD_ID = "kaupencourse";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItemGroup.registerItemGroup();

		ModItems.registerItems();
		ModBlocks.registerBlocks();

		//fuel item registry
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600); //log 300 ticks, coal 1600 ticks
	}
}