package com.legends.edumia.dynamictrees.entity;

import com.legends.edumia.dynamictrees.api.substance.SubstanceEffect;
import com.legends.edumia.dynamictrees.init.DTRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;


public class LingeringEffectorEntity extends Entity implements IEntityAdditionalSpawnData {

    private BlockPos blockPos;
    private SubstanceEffect effect;

    public LingeringEffectorEntity(EntityType<? extends LingeringEffectorEntity> entityTypeIn, Level level) {
        super(entityTypeIn, level);
        this.blockPos = BlockPos.ZERO;
    }

    @SuppressWarnings("unused")
    private LingeringEffectorEntity(Level level) {
        super(DTRegistries.LINGERING_EFFECTOR.get(), level);
    }

    public LingeringEffectorEntity(Level level, BlockPos pos, SubstanceEffect effect) {
        this(DTRegistries.LINGERING_EFFECTOR.get(), level);
        this.maxUpStep = 1f;
        this.noPhysics = true;
        this.setBlockPos(pos);
        this.effect = effect;

        if (this.effect != null) {
            // Search for existing effectors with the same effect in the same place.
            for (final LingeringEffectorEntity effector : level.getEntitiesOfClass(LingeringEffectorEntity.class, new AABB(pos))) {
                if (effector.getEffect() != null && effector.getEffect().getName().equals(effect.getName())) {
                    effector.kill(); // Kill old effector if it's the same.
                }
            }
        }
    }

    public void setBlockPos(BlockPos pos) {
        this.blockPos = pos;
        setPos(this.blockPos.getX() + 0.5, this.blockPos.getY(), this.blockPos.getZ() + 0.5);
    }

    public SubstanceEffect getEffect() {
        return this.effect;
    }
    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_20139_) {

    }

    @Override
    public void writeSpawnData(FriendlyByteBuf buffer) {

    }

    @Override
    public void readSpawnData(FriendlyByteBuf additionalData) {

    }
}
