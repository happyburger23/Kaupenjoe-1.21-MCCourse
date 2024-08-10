package net.aiq9.kaupencourse.block.entity;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.block.ModBlocks;
import net.aiq9.kaupencourse.block.entity.custom.PedestalBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(KaupenCourse121.MOD_ID, "pedestal_be"),
            BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build(null));

    public static void registerBlockEntities() {
        KaupenCourse121.LOGGER.info("Registering Block Entities for " + KaupenCourse121.MOD_ID);
    }
}
