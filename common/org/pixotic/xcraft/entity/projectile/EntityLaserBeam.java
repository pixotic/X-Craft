package org.pixotic.xcraft.entity.projectile;

import net.minecraft.entity.EntityLiving;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLaserBeam extends EntityThrowable {
    
    public EntityLaserBeam(World world) {
        super(world);
        int speed = 5;
        this.motionX*=speed;
        this.motionY*=speed;
        this.motionZ*=speed;
    }
    public EntityLaserBeam(World world, EntityLiving entity) {
        super(world, entity);
    }
    public EntityLaserBeam(World world, double par2, double par4, double par6) {
        super(world, par2, par4, par6);
    }
    
    @Override
    protected float getGravityVelocity() {
        return 0;
    }
    
    @Override
    protected void onImpact(MovingObjectPosition pos) {
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 1.0f, true);
        this.setDead();
    }
    
}
