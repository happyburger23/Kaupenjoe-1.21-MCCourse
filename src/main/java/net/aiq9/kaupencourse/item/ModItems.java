package net.aiq9.kaupencourse.item;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.item.custom.ChainsawItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item FLUORITE = registerItems("fluorite", new Item(new Item.Settings()));
    public static final Item RAW_FLUORITE = registerItems("raw_fluorite", new Item(new Item.Settings()));

    public static final Item CHAINSAW = registerItems("chainsaw", new ChainsawItem(new Item.Settings().maxCount(1).maxDamage(32)));
    public static final Item STRAWBERRY = registerItems("strawberry", new Item(new Item.Settings().food(ModFoodComponent.STRAWBERRY)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.kaupencourse.strawberry.tooltip.1"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STARLIGHT_ASHES = registerItems("starlight_ashes", new Item(new Item.Settings()));

    //tools
    public static final Item FLUORITE_SWORD = registerItems("fluorite_sword",
            new SwordItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 3, -2.4f))));

    public static final Item FLUORITE_PICKAXE = registerItems("fluorite_pickaxe",
            new PickaxeItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 1, -2.9f))));

    public static final Item FLUORITE_SHOVEL = registerItems("fluorite_shovel",
            new ShovelItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 1.5f, -3f))));

    public static final Item FLUORITE_AXE = registerItems("fluorite_axe",
            new AxeItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 6, -3.2f))));

    public static final Item FLUORITE_HOE = registerItems("fluorite_hoe",
            new HoeItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 0, -3f))));


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
        KaupenCourse121.LOGGER.info("Registering Items for " + KaupenCourse121.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::customIngredients);
    }
}
