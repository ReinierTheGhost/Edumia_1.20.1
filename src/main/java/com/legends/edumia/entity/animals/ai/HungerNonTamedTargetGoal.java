package com.legends.edumia.entity.animals.ai;

import com.legends.edumia.entity.animals.util.IHaveHunger;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;

import java.util.function.Predicate;

public class HungerNonTamedTargetGoal<T extends LivingEntity, O extends TamableAnimal & IHaveHunger> extends NonTameRandomTargetGoal<T> {

    private final O hunger;

    public HungerNonTamedTargetGoal(O goalOwnerIn, Class<T> targetClassIn, boolean checkSight, Predicate<LivingEntity> targetPredicate) {
        super(goalOwnerIn, targetClassIn, checkSight, targetPredicate);
        this.hunger = goalOwnerIn;
    }

    @Override
    public boolean canUse() {
        return super.canUse() && this.hunger.getEffectiveHunger() > 0 && (this.hunger.getEffectiveHunger() >= 100 || this.mob.getRandom().nextInt(100 - this.hunger.getEffectiveHunger()) == 0);
    }

}
