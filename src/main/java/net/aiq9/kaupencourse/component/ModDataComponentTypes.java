package net.aiq9.kaupencourse.component;

import net.aiq9.kaupencourse.KaupenCourse121;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", builder -> builder.codec(BlockPos.CODEC));
    public static final ComponentType<FoundBlockData> FOUND_BLOCK = register("found_block", builder -> builder.codec(FoundBlockData.CODEC));

    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(KaupenCourse121.MOD_ID, name),
                (builderOperator.apply(ComponentType.builder())).build());
    }

    public static void registerComponentTypes() {
        KaupenCourse121.LOGGER.info("Registering Component Types for " + KaupenCourse121.MOD_ID);
    }
}
