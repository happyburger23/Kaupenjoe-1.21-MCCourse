package net.aiq9.kaupencourse.world.gen;

import net.aiq9.kaupencourse.world.tree.ModTreeGeneration;

public class ModWorldGen {
    public static void generateModWorldGeneration() {
        ModGeodeGen.generateGeodes();
        ModOreGen.generateOres();
        ModTreeGeneration.generateTrees();
        ModFlowerGen.generateFlowers();
    }
}
