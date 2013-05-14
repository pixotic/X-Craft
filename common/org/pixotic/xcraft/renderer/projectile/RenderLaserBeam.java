package org.pixotic.xcraft.renderer.projectile;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class RenderLaserBeam extends Render {

    @Override
    public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
        this.loadTexture("/item/arrows.png");
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d0, (float)d1, (float)d2);
        GL11.glRotatef(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f1 - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * f1, 0.0F, 0.0F, 1.0F);
        Tessellator tessellator = Tessellator.instance;
        byte b0 = 0;
        float f2 = 0.0F;
        float f3 = 0.5F;
        float f4 = (float)(0 + b0 * 10) / 32.0F;
        float f5 = (float)(5 + b0 * 10) / 32.0F;
        float f6 = 0.0F;
        float f7 = 0.15625F;
        float f8 = (float)(5 + b0 * 10) / 32.0F;
        float f9 = (float)(10 + b0 * 10) / 32.0F;
        float f10 = 0.05625F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        

        GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(f10, f10, f10);
        GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
        GL11.glNormal3f(f10, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.addVertex(-7.0D, -2.0D, -2.0D, (double)f6, (double)f8);
        tessellator.addVertex(-7.0D, -2.0D, 2.0D, (double)f7, (double)f8);
        tessellator.addVertex(-7.0D, 2.0D, 2.0D, (double)f7, (double)f9);
        tessellator.addVertex(-7.0D, 2.0D, -2.0D, (double)f6, (double)f9);
        tessellator.draw();
        GL11.glNormal3f(-f10, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.addVertex(-7.0D, 2.0D, -2.0D, (double)f6, (double)f8);
        tessellator.addVertex(-7.0D, 2.0D, 2.0D, (double)f7, (double)f8);
        tessellator.addVertex(-7.0D, -2.0D, 2.0D, (double)f7, (double)f9);
        tessellator.addVertex(-7.0D, -2.0D, -2.0D, (double)f6, (double)f9);
        tessellator.draw();

        for (int i = 0; i < 4; ++i)
        {
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, f10);
            tessellator.startDrawingQuads();
            tessellator.addVertex(-8.0D, -2.0D, 0.0D, (double)f2, (double)f4);
            tessellator.addVertex(8.0D, -2.0D, 0.0D, (double)f3, (double)f4);
            tessellator.addVertex(8.0D, 2.0D, 0.0D, (double)f3, (double)f5);
            tessellator.addVertex(-8.0D, 2.0D, 0.0D, (double)f2, (double)f5);
            tessellator.draw();
        }

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }
    

}
