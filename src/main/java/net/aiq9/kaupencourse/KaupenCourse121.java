package net.aiq9.kaupencourse;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KaupenCourse121 implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("kaupencourse");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}