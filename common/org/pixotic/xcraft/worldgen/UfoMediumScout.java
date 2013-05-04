package org.pixotic.xcraft.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;
import net.minecraft.world.World;

public class UfoMediumScout extends UfoStructure {

    public UfoMediumScout() {
        this.xLen = 9;
        this.yLen = 5;
        this.zLen = 9;
    }
       
    public boolean generate(World world, Random rand, int x, int y, int z) {
        System.out.println("UFO landing at " + x + "," + y + "," + z);
        int endX = x + this.xLen;
        int endY = y + this.yLen;
        int endZ = z + this.zLen;
        
        //Generate a multidim array that will describe what blocks get placed where
        //int[] arrUfo = new int[]{};
        //Yeah that's not working...
        
        //Let's start simple, solid mass of wall blocks
        for (int ix = x; ix < endX; ix++) {
            for (int iz = z; iz < endZ; iz++) {
                for (int iy = y; iy < endY; iy++) {
                    //arrUfo[]ix][iy][iz] = wallBlock;
                    world.setBlock(ix, iy, iz, wallBlock);
                }
            }
        }
        
        //Okay now let's hollow it out
        for (int ix = x + 1; ix < endX - 1; ix++) {
            for (int iz = z + 1; iz < endZ - 1; iz++) {
                for (int iy = y + 1; iy < endY -1; iy++) {
                    //arrUfo[ix][iy][iz] = 0;
                    world.setBlockToAir(ix, iy, iz);
                }
            }
        }
        
        //Add some windows
        /*for (int ix = x; ix < endX; ix++) {
            for (int iz = z; iz < endZ; iz++) {
                for (int iy = y; iy < endY; iy++) {
                    System.out.println("Window check: X: " + x + "/" + ix + "/" + endX);
                    System.out.println("Window check: y: " + y + "/" + iy + "/" + endY);
                    System.out.println("Window check: z: " + z + "/" + iz + "/" + endZ);
                    if (
                        ((ix == x || ix == (endX -1)) && ((iz - endZ == 3) || (iz - endZ == 5)))
                     || ((iz == z || iz == (endZ -1)) && ((ix - endX == 3) || (ix - endX == 5)))
                     && ((iy - endY == 2) || (iy - endY == 3))
                    ) {
                        //arrUfo[ix][iy][iz] = windowBlock;
                        System.out.println("Glass at " + x + " " + y + " " + z);
                        world.setBlock(ix, iy, iz, windowBlock);
                    }
                }
            }
        }*/
        //fuck this for a game of soldiers...
        world.setBlock(x + 3, y + 2, z, windowBlock);
        world.setBlock(x + 5, y + 2, z, windowBlock);
        world.setBlock(x + 3, y + 2, endZ -1, windowBlock);
        world.setBlock(x + 5, y + 2, endZ -1, windowBlock);
        world.setBlock(x, y + 2, z + 3, windowBlock);
        world.setBlock(x, y + 2, z + 5, windowBlock);
        
        world.setBlock(x + 4, y + 1, z + 4, powersourceBlock);
        
        //Lay-zee aliens
        world.setBlock(endX - 3, y + 1, z + 3, Block.cloth.blockID, 9, 3);
        world.setBlock(endX - 3, y + 1, z + 5, Block.cloth.blockID, 9, 3);
        world.setBlock(endX - 5, y + 1, z + 6, Block.cloth.blockID, 9, 3);
        world.setBlock(endX - 7, y + 1, z + 3, Block.cloth.blockID, 9, 3);
        world.setBlock(endX - 7, y + 1, z + 5, Block.cloth.blockID, 9, 3);
        
        //Navigation Consoles
        world.setBlock(endX - 2, y + 1, z + 3, Block.cloth.blockID, 2, 3);
        world.setBlock(endX - 2, y + 1, z + 5, Block.cloth.blockID, 2, 3);
        
        
        //Manually place the door, because I'm lazy and want to test this already
        //arrUfo[x+3][y+2][z] = doorBlock;
        world.setBlockToAir(x+4, y+2, z);
        ItemDoor.placeDoorBlock(world, x+4, y+1, z, 1, Block.doorWood);
        //world.setBlock(x+3, y+1, z, doorBlock);

        //Okay, we're done defining. Time to iterate that sucker!
        
        /*for (int i1 = 0; i1 < arrUfo.length; i1++) {
            for (int i2 = 0; i2 < arrUfo[i1].length; i2++) {
                for (int i3 = 0; i3 < arrUfo[i1][i2].length; i3++) {
                    if (arrUfo[i1][i2][i3] == 0) {
                        world.setBlockToAir(i1, i2, i3);
                    } else {
                        world.setBlock(i1, i2, i3, (int)arrUfo[i1][i2][i3]);
                    }
                }
            }
        }*/
        
        //world.setBlock(x + ix,  y + iy,  z + iz, Block.blockIron.blockID);
                
        return true;
    }
}