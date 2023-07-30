package com.dayofpi.super_block_world.entity.custom;

import com.dayofpi.super_block_world.entity.ModEntityTypes;
import com.dayofpi.super_block_world.item.ModItems;
import com.dayofpi.super_block_world.sound.ModSoundEvents;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class HammerEntity extends ThrowableItemProjectile {
    public HammerEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public HammerEntity(Level level, LivingEntity owner) {
        super(ModEntityTypes.HAMMER.get(), owner, level);
    }

    public HammerEntity(Level level, double x, double y, double z) {
        super(ModEntityTypes.HAMMER.get(), x, y, z, level);
    }

    private ParticleOptions getParticleParameters() {
        return new ItemParticleOption(ParticleTypes.ITEM, this.getItem());
    }

    public void handleEntityEvent(byte status) {
        super.handleEntityEvent(status);
        if (status != 3)
            return;
        ParticleOptions particleOptions = this.getParticleParameters();
        for (int i = 0; i < 8; ++i) {
            this.level().addParticle(particleOptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
        }
    }

    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.playSound(ModSoundEvents.HAMMER_BREAK.get(), 0.85F, 1.3F);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 6);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        BlockState blockstate = this.level().getBlockState(pResult.getBlockPos());
        if (blockstate.is(BlockTags.MINEABLE_WITH_PICKAXE) && blockstate.getDestroySpeed(this.level(), pResult.getBlockPos()) <= 1.5F) {
            this.level().destroyBlock(pResult.getBlockPos(), true);
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.HAMMER.get();
    }

    @Override
    protected float getGravity() {
        return 0.1F;
    }
}
