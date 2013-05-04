package org.pixotic.xcraft.client.renderer.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

import org.lwjgl.opengl.GL11;
import org.pixotic.xcraft.client.model.ModelTest3DBlock;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemTest3DBlockRenderer implements IItemRenderer {
    private ModelTest3DBlock modelTest3DBlock;
    
    public ItemTest3DBlockRenderer() {
        modelTest3DBlock = new ModelTest3DBlock();
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
                renderTest3DBlock(0f, 0f, 0f, 0.5f);
                return;
            }
            case EQUIPPED: {
                renderTest3DBlock(0f, 1f, 1f, 0.5f);
                return;
            }
            case INVENTORY: {
                renderTest3DBlock(0f, 0f, 0f, 0.5f);
                return;
            }
            default:return;
        }
    }
    
    private void renderTest3DBlock(float x, float y, float z, float scale) {
        GL11.glPushMatrix();
        
        //Disable lightcalcs for a sec
        GL11.glDisable(GL11.GL_LIGHTING);
        
        GL11.glTranslatef(x,  y,  z);
        GL11.glScalef(scale,  scale,  scale);
        GL11.glRotatef(180f,  0f,  1f,  0f);
        
        FMLClientHandler.instance().getClient().renderEngine.bindTexture("/mods/xcraft/textures/models/TutBox.png");
        
        modelTest3DBlock.render();
        
        //Let there be light
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
