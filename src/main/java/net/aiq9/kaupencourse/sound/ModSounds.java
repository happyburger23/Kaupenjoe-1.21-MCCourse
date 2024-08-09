package net.aiq9.kaupencourse.sound;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    //item sounds
    public static final SoundEvent CHAINSAW_CUT = registerSoundEvent("chainsaw_cut");
    public static final SoundEvent CHAINSAW_PULL = registerSoundEvent("chainsaw_pull");

    //block sounds
    public static final SoundEvent MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
    public static final SoundEvent MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");
    public static final SoundEvent MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
    public static final SoundEvent MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
    public static final SoundEvent MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");

    public static final BlockSoundGroup MAGIC_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
            MAGIC_BLOCK_BREAK, MAGIC_BLOCK_STEP, MAGIC_BLOCK_PLACE, MAGIC_BLOCK_HIT, MAGIC_BLOCK_FALL);

    //HELPER METHODS
    private static SoundEvent registerSoundEvent(String name) {
        return Registry.register(Registries.SOUND_EVENT, Identifier.of(KaupenCourse121.MOD_ID, name),
                SoundEvent.of(Identifier.of(KaupenCourse121.MOD_ID, name)));
    }

    public static void registerSounds() {
        KaupenCourse121.LOGGER.info("Registering Sounds for " + KaupenCourse121.MOD_ID);
    }
}
