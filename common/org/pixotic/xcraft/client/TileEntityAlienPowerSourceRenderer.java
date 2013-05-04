package org.pixotic.xcraft.client;

import org.pixotic.xcraft.client.model.ModelAlienPowerSource;
import org.pixotic.xcraft.tileentity.TileEntityAlienPowerSource;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAlienPowerSourceRenderer extends TileEntitySpecialRenderer {
    
    private ModelAlienPowerSource modelAlienPowerSource = new ModelAlienPowerSource();
    
    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick) {
        modelAlienPowerSource.render((TileEntityAlienPowerSource)tileEntity, x, y, z);
    }

}
