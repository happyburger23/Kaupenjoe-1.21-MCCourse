package net.aiq9.kaupencourse.util;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.component.ModDataComponentTypes;
import net.aiq9.kaupencourse.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, Identifier.of(KaupenCourse121.MOD_ID, "on"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.FOUND_BLOCK) != null ? 1f : 0f);

        registerCustomBow(ModItems.KAUPEN_BOW);
    }

    private static void registerCustomBow(Item item) {
        ModelPredicateProviderRegistry.register(item, Identifier.ofVanilla("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getActiveItem() != stack ? 0.0F : (float)(stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0F;
            }
        });

        ModelPredicateProviderRegistry.register(
                item,
                Identifier.ofVanilla("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
        );
    }
}
