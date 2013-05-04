package org.pixotic.xcraft.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructurePlaceholderUfo extends WorldGenerator {

    public StructurePlaceholderUfo() {

    }
   
    public boolean generate(World world, Random rand, int x, int y, int z) {
        for (int ix = 0; ix < 6; ix++) {
            for (int iz = 0; iz < 6; iz++) {
                for (int iy = 0; iy < 3; iy++) {
                    world.setBlock(x + ix,  y + iy,  z + iz, Block.blockIron.blockID);
                    //janky temp code to remove everything above genned blocks
                    for (int i = iy + 1; i < 254; i++) {
                        world.setBlockToAir(x + ix,  y + i,  z + iz);
                    }
                }
            }
        }
                
        return true;
    }
}