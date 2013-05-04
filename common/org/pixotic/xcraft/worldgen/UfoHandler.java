package org.pixotic.xcraft.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;

public class UfoHandler implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
        }
    }
    
    private void generateSurface(World world, Random rand, int y, int z) {
        if(rand.nextInt(10)==1) {
            int RandPosX = y + rand.nextInt(16);
            int RandPosZ = z + rand.nextInt(16);
            for(int height = 255; height>0; height--) {
                if(
                  world.getBlockId(RandPosX, height -1 , RandPosZ)== Block.sand.blockID 
                  || world.getBlockId(RandPosX, height -1, RandPosZ)== Block.dirt.blockID
                  || world.getBlockId(RandPosX, height -1, RandPosZ) == Block.grass.blockID
                ) {
                    //if ((new UfoLargeScout()).validLocation(world, rand, RandPosX, height, RandPosZ)) {
                    //    (new UfoLargeScout()).generate(world, rand, RandPosX, height, RandPosZ);
                    //}
                    if ((new UfoMediumScout()).validLocation(world, rand, RandPosX, height, RandPosZ)) {
                        (new UfoMediumScout()).generate(world, rand, RandPosX, height, RandPosZ);
                    }
                                        
                    break;
                }
            }
        }
    }
}
