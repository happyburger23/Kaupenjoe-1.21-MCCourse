package net.aiq9.kaupencourse.world.tree;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator BLACKWOOD = new SaplingGenerator(KaupenCourse121.MOD_ID + ":blackwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BLACKWOOD_KEY), Optional.empty());
}
