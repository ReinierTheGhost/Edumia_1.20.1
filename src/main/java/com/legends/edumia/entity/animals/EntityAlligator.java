package com.legends.edumia.entity.animals;

import com.legends.edumia.core.EntityLoader;
import com.legends.edumia.entity.animals.ai.HybridMoveController;
import com.legends.edumia.entity.animals.ai.PeacefulNearestAttackableTargetGoal;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.gen.Accessor;


public class EntityAlligator extends Animal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public EntityAlligator(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(BlockPathTypes.WALKABLE, 1.5F);
        this.setPathfindingMalus(BlockPathTypes.WATER, 1.5F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 1F);
        this.moveControl = new HybridMoveController(this);
        this.setMaxUpStep(1F);
    }

    //adds the AI/behavior for the Entity
    @Override
    protected void registerGoals() {
        super.registerGoals();
        // number is priority and this goal prevents sinking in water
        this.goalSelector.addGoal(0, new BreathAirGoal(this));

        //child follows parent 1.1 times faster than normal
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        //entity wanders around but avoids water
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
        //looks at player when within radius of 4 blocks
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 1.0D, 10));
        //looks around random
        this.targetSelector.addGoal(4, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return !EntityAlligator.this.isPeaceful() && super.canUse();
            }
        });
        this.targetSelector.addGoal(5, new PeacefulNearestAttackableTargetGoal<>(this, Player.class, 15, false, false, e -> !e.isPassenger()));
    }

    public boolean isPeaceful() {
        return this.level().getDifficulty() == Difficulty.PEACEFUL;
    }

    //adds the attributes of entity
    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes().add(Attributes.MAX_HEALTH, 35D)
                .add(Attributes.MOVEMENT_SPEED, 0.15D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.ARMOR_TOUGHNESS, 0.1f)
                .add(Attributes.ATTACK_DAMAGE, 2f);
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel pLevel, @NotNull AgeableMob pOtherParent) {
        return EntityLoader.ALLIGATOR.get().create(pLevel);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    protected void updateWalkAnimation(float v) {
        float f;
        if (this.getPose() == Pose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.walkAnimation.update(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }
}
