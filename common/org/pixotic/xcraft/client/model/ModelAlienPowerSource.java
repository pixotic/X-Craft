package org.pixotic.xcraft.client.model;

import org.lwjgl.opengl.GL11;
import org.pixotic.xcraft.tileentity.TileEntityAlienPowerSource;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.common.ForgeDirection;

public class ModelAlienPowerSource {
    
    private IModelCustom modelAlienPowerSource;
    
    public ModelAlienPowerSource() {
        modelAlienPowerSource = AdvancedModelLoader.loadModel("/mods/xcraft/models/AlienPowerSource.obj");
    }
    
    public void render() {
        modelAlienPowerSource.renderAll();
    }
    
    public void render(TileEntityAlienPowerSource block, double x, double y, double z) {
        
        //Push blank matrix onto stack
        GL11.glPushMatrix();
        
        //Move object to right position on block (true obj origin is center of object)
        GL11.glTranslatef((float)x + 0.5f, (float)y, (float)z + 0.5f);
        
        //Scale object down
        GL11.glScalef(0.2f,  0.2f, 0.2f);
        
        //Bind texture so ogl properly uses it
        FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/xcraft/textures/models/AlienPowerSource.png");
        
        //Render!
        this.render();
        
        //Pop matrix from stack
        GL11.glPopMatrix();
        
    }
    
}
