package net.aiq9.kaupencourse.util;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.component.ModDataComponentTypes;
import net.aiq9.kaupencourse.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates() {
        ModelPredicateProviderRegistry.register(ModItems.DATA_TABLET, Identifier.of(KaupenCourse121.MOD_ID, "on"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.FOUND_BLOCK) != null ? 1f : 0f);
    }
}
