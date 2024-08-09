package net.aiq9.kaupencourse.sound;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent CHAINSAW_CUT = registerSoundEvent("chainsaw_cut");
    public static final SoundEvent CHAINSAW_PULL = registerSoundEvent("chainsaw_pull");

    //HELPER METHODS
    private static SoundEvent registerSoundEvent(String name) {
        return Registry.register(Registries.SOUND_EVENT, Identifier.of(KaupenCourse121.MOD_ID, name),
                SoundEvent.of(Identifier.of(KaupenCourse121.MOD_ID, name)));
    }

    public static void registerSounds() {
        KaupenCourse121.LOGGER.info("Registering Sounds for " + KaupenCourse121.MOD_ID);
    }
}
