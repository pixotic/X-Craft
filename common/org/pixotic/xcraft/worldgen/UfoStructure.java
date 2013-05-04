package org.pixotic.xcraft.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import org.pixotic.xcraft.block.ModBlocks;

public class UfoStructure extends WorldGenerator {

    public int xLen;
    public int yLen;
    public int zLen;
    
    protected int doorBlock = Block.doorWood.blockID;
    protected int wallBlock = ModBlocks.alienAlloy.blockID;
    protected int windowBlock = Block.glass.blockID;
    protected int powersourceBlock = ModBlocks.alienPowerSource.blockID;
    //alienSeating
    //NavigationConsole
    //otherStuff
    
    public UfoStructure() {

    }
    
    public boolean validLocation(World world, Random rand, int x, int y, int z) {
        boolean returnVal = true;
        for (int ix = x; ix < x + this.xLen; ix++) {
            for (int iz = z; iz < z + this.zLen; iz++) {
                if (!world.canBlockSeeTheSky(ix, y, iz)) returnVal = false;
            }
        }
        
        return returnVal;
    }
    
    public boolean generate(World world, Random rand, int x, int y, int z) {
        //Stub function!
        
        return true;
    }
}