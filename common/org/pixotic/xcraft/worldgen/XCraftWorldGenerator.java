package org.pixotic.xcraft.worldgen;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class XCraftWorldGenerator implements IWorldGenerator {
    
    public XCraftWorldGenerator() {
        
    }
    
    @Override
    public void generate (Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        if (world.provider.isHellWorld)
        {
            //Aliens in hell? We'll see.
            //generateNether(random, chunkX * 16, chunkZ * 16, world);
        }
        else { //if (world.provider.terrainType != WorldType.FLAT) {
            //There is an x% chance of generating a UFO
            //In this case we'll just fudge it for testing
            double ufoChance = Math.random();
            if (ufoChance < 1) { //1 needs to be the chance percentage as a double)
                
            }
        }
    }
}