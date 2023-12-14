package com.legends.edumia.entity.animals;

import com.legends.edumia.core.EntityLoader;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class EntityRhino extends Animal {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public EntityRhino(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    //adds the AI/behavior for the Entity
    @Override
    protected void registerGoals() {
        // number is priority and this goal prevents sinking in water
        this.goalSelector.addGoal(0, new FloatGoal(this));

        //child follows parent 1.1 times faster than normal
        this.goalSelector.addGoal(1, new FollowParentGoal(this, 1.1d));
        //entity wanders around but avoids water
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        //looks at player when within radius of 4 blocks
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 4f));
        //looks around random
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
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
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return EntityLoader.RHINO.get().create(pLevel);
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
