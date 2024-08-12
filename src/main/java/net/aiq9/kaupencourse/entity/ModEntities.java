package net.aiq9.kaupencourse.entity;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.aiq9.kaupencourse.entity.custom.DodoEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<DodoEntity> DODO = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(KaupenCourse121.MOD_ID, "dodo"),
            EntityType.Builder.create(DodoEntity::new, SpawnGroup.CREATURE).dimensions(1f, 2.5f).build());

    public static void registerEntities() {
        KaupenCourse121.LOGGER.info("Registering Entities for " + KaupenCourse121.MOD_ID);
    }
}
