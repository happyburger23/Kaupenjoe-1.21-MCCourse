package net.aiq9.kaupencourse.potion;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> SLIMEY_POTION = registerPotion("slimey_potion",
            new Potion(new StatusEffectInstance(ModEffects.SLIMEY, 200, 0))); //200 ticks is 10 seconds

    //HELPER METHODS
    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(KaupenCourse121.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        KaupenCourse121.LOGGER.info("Registering Potions for " + KaupenCourse121.MOD_ID);
    }
}
