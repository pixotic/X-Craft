package org.pixotic.xcraft.client.renderer.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import org.pixotic.xcraft.client.model.ModelAlienPowerSource;


import cpw.mods.fml.client.FMLClientHandler;

public class ItemAlienPowerSourceRenderer implements IItemRenderer {
    private ModelAlienPowerSource modelAlienPowerSource;
    
    public ItemAlienPowerSourceRenderer() {
        modelAlienPowerSource = new ModelAlienPowerSource();
    }
    
    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }
    
    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }
    
    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch(type) {
            case ENTITY: {
                renderAlienPowerSource(0f, 0f, 0f, 0.5f);
                return;
            }
            case EQUIPPED: {
                renderAlienPowerSource(0f, 1f, 1f, 0.5f);
                return;
            }
            case INVENTORY: {
                renderAlienPowerSource(0f, 0f, 0f, 0.5f);
                return;
            }
            default:return;
        }
    }
    
    private void renderAlienPowerSource(float x, float y, float z, float scale) {
        GL11.glPushMatrix();
        
        //Disable lightcalcs for a sec
        GL11.glDisable(GL11.GL_LIGHTING);
        
        GL11.glTranslatef(x,  y,  z);
        GL11.glScalef(scale,  scale,  scale);
        GL11.glRotatef(180f,  0f,  1f,  0f);
        
        FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/xcraft/textures/models/AlienPowerSource.png");
        
        modelAlienPowerSource.render();
        
        //Let there be light
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
