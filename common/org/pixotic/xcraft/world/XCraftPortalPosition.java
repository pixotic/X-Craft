package org.pixotic.xcraft.world;

import net.minecraft.util.ChunkCoordinates;

public class XCraftPortalPosition extends ChunkCoordinates {
    public long field_85087_d;
    final XCraftTeleporter field_85088_e;
    
    public XCraftPortalPosition(XCraftTeleporter teleporter, int par2, int par3, int par4, long par5) {
        super(par2, par3, par4);
        this.field_85088_e = teleporter;
        this.field_85087_d = par5;
    }
}