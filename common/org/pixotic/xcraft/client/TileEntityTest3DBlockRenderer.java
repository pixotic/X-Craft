package org.pixotic.xcraft.client;

import org.pixotic.xcraft.client.model.ModelTest3DBlock;
import org.pixotic.xcraft.tileentity.TileTest3DBlock;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTest3DBlockRenderer extends TileEntitySpecialRenderer {
    
    private ModelTest3DBlock modelTest3DBlock = new ModelTest3DBlock();
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        modelTest3DBlock.render((TileTest3DBlock)tileEntity, x, y, z);
    }

}
