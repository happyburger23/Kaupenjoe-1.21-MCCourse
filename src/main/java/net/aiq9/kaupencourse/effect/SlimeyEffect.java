package net.aiq9.kaupencourse.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

public class SlimeyEffect extends StatusEffect {
    public SlimeyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.horizontalCollision) {
            Vec3d initialVelocity = entity.getVelocity();
            Vec3d climbVelocity = new Vec3d(initialVelocity.x, 0.2D, initialVelocity.z);

            entity.setVelocity(climbVelocity.multiply(0.97D));

            return true;
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
