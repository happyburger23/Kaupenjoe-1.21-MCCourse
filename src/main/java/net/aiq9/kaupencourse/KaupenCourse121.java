package net.aiq9.kaupencourse;

import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.component.ModDataComponentTypes;
import net.aiq9.kaupencourse.effect.ModEffects;
import net.aiq9.kaupencourse.events.AttackEntityHandler;
import net.aiq9.kaupencourse.fluid.ModFluids;
import net.aiq9.kaupencourse.item.ModItemGroup;
import net.aiq9.kaupencourse.item.ModItems;
import net.aiq9.kaupencourse.potion.ModPotions;
import net.aiq9.kaupencourse.sound.ModSounds;
import net.aiq9.kaupencourse.util.HammerUsageEvent;
import net.aiq9.kaupencourse.villager.ModVillagers;
import net.aiq9.kaupencourse.world.gen.ModWorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KaupenCourse121 implements ModInitializer {
	public static final String MOD_ID = "kaupencourse";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItemGroup.registerItemGroups();
		ModItems.registerItems();
		ModBlocks.registerBlocks();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModVillagers.registerVillagers();
		ModFluids.registerFluids();

		//fuel item registry
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600); //log 300 ticks, coal 1600 ticks

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		ModDataComponentTypes.registerComponentTypes();

		AttackEntityCallback.EVENT.register(new AttackEntityHandler());

		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.STRAWBERRY, 0.5f);
		ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.STRAWBERRY_SEEDS, 0.25f);

		//Slimey potion Brewing Stand recipe
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});

		registerCustomTrades();

		ModWorldGen.generateModWorldGeneration();

		registerStrippables();
		registerFlammables();
	}

	private static void registerStrippables() {
		StrippableBlockRegistry.register(ModBlocks.BLACKWOOD_LOG, ModBlocks.STRIPPED_BLACKWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.BLACKWOOD_WOOD, ModBlocks.STRIPPED_BLACKWOOD_WOOD);
	}

	private static void registerFlammables() {
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLACKWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLACKWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BLACKWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_BLACKWOOD_WOOD, 5, 5);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLACKWOOD_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.BLACKWOOD_LEAVES, 30, 60);
	}

	private static void registerCustomTrades() {
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 2),
					new ItemStack(ModItems.STRAWBERRY, 6), 6, 2, 0.04f
			));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 9),
					new ItemStack(ModItems.CHAINSAW, 1), 1, 6, 0.09f
			));
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 2, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND, 6),
					new ItemStack(ModItems.FLUORITE, 19), 4, 1, 0.04f
			));
		});

		//CUSTOM VILLAGER
		TradeOfferHelper.registerVillagerOffers(ModVillagers.KAUPENGER, 1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND, 6),
					new ItemStack(ModItems.RAW_FLUORITE, 19), 4, 1, 0.04f
			));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(ModItems.FLUORITE, 6),
					new ItemStack(ModItems.SPECTRE_STAFF, 1), 1, 8, 0.04f
			));
		});
	}
}