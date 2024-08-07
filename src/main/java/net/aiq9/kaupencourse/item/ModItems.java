package net.aiq9.kaupencourse.item;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.item.custom.ChainsawItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item FLUORITE = registerItems("fluorite", new Item(new Item.Settings()));
    public static final Item RAW_FLUORITE = registerItems("raw_fluorite", new Item(new Item.Settings()));

    public static final Item CHAINSAW = registerItems("chainsaw", new ChainsawItem(new Item.Settings().maxCount(1).maxDamage(32)));

    //ITEM REGISTRY CODE
    private static Item registerItems(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(KaupenCourse121.MOD_ID, name), item);
    }

    //ADDING TO A VANILLA ITEM GROUP
    private static void customIngredients(FabricItemGroupEntries entries) {
        entries.add(FLUORITE);
        entries.add(RAW_FLUORITE);
    }

    public static void registerItems() {
        KaupenCourse121.LOGGER.info("Registering Items for" + KaupenCourse121.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
    }
}
