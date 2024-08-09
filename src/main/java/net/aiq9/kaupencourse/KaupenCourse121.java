package net.aiq9.kaupencourse;

import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.component.ModDataComponentTypes;
import net.aiq9.kaupencourse.events.AttackEntityHandler;
import net.aiq9.kaupencourse.item.ModItemGroup;
import net.aiq9.kaupencourse.item.ModItems;
import net.aiq9.kaupencourse.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.ComposterBlock;
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

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		ModDataComponentTypes.registerComponentTypes();

		AttackEntityCallback.EVENT.register(new AttackEntityHandler());

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.STRAWBERRY, 0.5f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.STRAWBERRY_SEEDS, 0.25f);
	}
}