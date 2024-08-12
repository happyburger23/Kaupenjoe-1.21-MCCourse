package net.aiq9.kaupencourse.item;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.entity.ModEntities;
import net.aiq9.kaupencourse.item.custom.*;
import net.aiq9.kaupencourse.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item FLUORITE = registerItem("fluorite", new Item(new Item.Settings()));
    public static final Item RAW_FLUORITE = registerItem("raw_fluorite", new Item(new Item.Settings()));

    public static final Item CHAINSAW = registerItem("chainsaw", new ChainsawItem(new Item.Settings().maxCount(1).maxDamage(32)));
    public static final Item STRAWBERRY = registerItem("strawberry", new Item(new Item.Settings().food(ModFoodComponent.STRAWBERRY)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.kaupencourse.strawberry.tooltip.1"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STRAWBERRY_SEEDS = registerItem("strawberry_seeds", new AliasedBlockItem(ModBlocks.STRAWBERRY_CROP_BLOCK, new Item.Settings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new Item.Settings().maxCount(1).maxDamage(200)));
    public static final Item DATA_TABLET = registerItem("data_tablet", new DataTabletItem(new Item.Settings().maxCount(1)));

    public static final Item KAUPEN_BOW = registerItem("kaupen_bow",
            new BowItem(new Item.Settings().maxDamage(200)));

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));
    public static final Item BAR_BRAWL_MUSIC_DISC = registerItem("bar_brawl_music_disc", new Item(new Item.Settings().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).maxCount(1)));
    public static final Item SPECTRE_STAFF = registerItem("spectre_staff", new Item(new Item.Settings().maxCount(1)));

    public static final Item DODO_SPAWN_EGG = registerItem("dodo_spawn_egg", new SpawnEggItem(ModEntities.DODO, 0x465ae0, 0x545978, new Item.Settings()));

    //tools
    public static final Item FLUORITE_SWORD = registerItem("fluorite_sword",
            new ModEffectSwordItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 3, -2.4f)), StatusEffects.LEVITATION));

    public static final Item FLUORITE_PICKAXE = registerItem("fluorite_pickaxe",
            new PickaxeItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 1, -2.9f))));

    public static final Item FLUORITE_SHOVEL = registerItem("fluorite_shovel",
            new ShovelItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 1.5f, -3f))));

    public static final Item FLUORITE_AXE = registerItem("fluorite_axe",
            new AxeItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 6, -3.2f))));

    public static final Item FLUORITE_HOE = registerItem("fluorite_hoe",
            new HoeItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 0, -3f))));

    //paxel
    public static final Item FLUORITE_PAXEL = registerItem("fluorite_paxel",
            new PaxelItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 4, -2.5f))));

    //hammer
    public static final Item FLUORITE_HAMMER = registerItem("fluorite_hammer",
            new HammerItem(ModToolMaterials.FLUORITE,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FLUORITE, 8, -3.5f))));

    //armor items
    public static final Item FLUORITE_HELMET = registerItem("fluorite_helmet",
            new ModArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item FLUORITE_CHESTPLATE = registerItem("fluorite_chestplate",
            new ModArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));

    public static final Item FLUORITE_LEGGINGS = registerItem("fluorite_leggings",
            new ModArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));

    public static final Item FLUORITE_BOOTS = registerItem("fluorite_boots",
            new ModArmorItem(ModArmorMaterials.FLUORITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));


    //ITEM REGISTRY HELPER METHODS
    private static Item registerItem(String name, Item item) {
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
