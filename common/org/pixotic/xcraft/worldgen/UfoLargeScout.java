package org.pixotic.xcraft.worldgen;

import java.util.Arrays;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;
import net.minecraft.world.World;

public class UfoLargeScout extends UfoStructure {

    public UfoLargeScout() {
        this.xLen = 17;
        this.yLen = 5;
        this.zLen = 17;
    }
       
    public boolean generate(World world, Random rand, int x, int y, int z) {
        System.out.println("Large Scout landing at " + x + "," + y + "," + z);
        int endX = x + this.xLen;
        int endY = y + this.yLen;
        int endZ = z + this.zLen;
        
        
        //Clear the space
        for (int ix = x; ix < endX; ix++) {
            for (int iz = z; iz < endZ; iz++) {
                for (int iy = endY; iy > y; iy--) {
                    //This is top to bottom so there's no plant entities on the floor of my shiny new UFO
                    world.setBlockToAir(ix, iy, iz);
                }
            }
        }
        System.out.println("Done clearing space");
        
        //floors, ceilings, exterior walls
        for (int ix = x; ix < endX; ix++) {
            for (int iz = z; iz < endZ; iz++) {
                if ((ix == x+4 || ix == endX-5) && (iz == z+4 || iz == endZ-5)) {
                    world.setBlock(ix, y, iz, wallBlock);
                    world.setBlock(ix, endY-1, iz, wallBlock);
                }
                
                if ((ix >= x+5) && (ix <= x+11)) {
                    world.setBlock(ix, y, iz, wallBlock);
                    world.setBlock(ix, endY-1, iz, wallBlock);
 
                    if ((iz == z || iz == endZ - 1) || 
                        ((ix == x+5 || ix == x+11) && (Arrays.asList(z, z+1, z+2, endZ-3, endZ-2, endZ-1).contains(iz) == true))) {
                        for (int iy = y; iy < endY; iy ++) {
                            world.setBlock(ix, iy, iz, wallBlock);
                        }
                    }
                }
                if ((iz >= z+5) && (iz <= z+11)) {
                    world.setBlock(ix, y, iz, wallBlock);
                    world.setBlock(ix, endY-1, iz, wallBlock);
                    if ((ix == x || ix == endX - 1) || 
                        ((iz == z+5 || iz == z+11) && (Arrays.asList(x, x+1, x+2, endX-3, endX-2, endX-1).contains(ix) == true))) {
                        for (int iy = y; iy < endY; iy ++) {
                            world.setBlock(ix, iy, iz, wallBlock);
                        }
                    }
                }
                if (((ix == x + 3 || ix == endX-4) && (iz == z+4 || iz == endZ - 5)) ||
                    ((ix == x + 4 || ix == endX-5) && (iz == z+3 || iz == endZ - 4))){
                    for (int iy = y; iy < endY; iy ++) {
                        world.setBlock(ix, iy, iz, wallBlock);
                    }
                }
            }
        }
        
        //Windows, internal walls, in/external doors        
        for (int ix = x; ix < endX; ix++) {
            for (int iz = z; iz < endZ; iz++) {
                
                //interior walls
                if (ix == x+5 && (iz >= z+5 && iz <= z+11)) {
                    for (int iy = y+1; iy < endY-1; iy++) {
                        world.setBlock(ix, iy, iz, interiorWall);
                    }
                }
                if (ix == x+6 && (iz == z+5 || iz == z+11)) {
                    for (int iy = y+1; iy < endY-1; iy++) {
                        world.setBlock(ix, iy, iz, interiorWall);
                    }
                }
                if (ix == x+7 && (Arrays.asList(z+1,z+3,z+4,z+5,z+11).contains(iz) == true)) {
                    for (int iy = y+1; iy < endY-1; iy++) {
                        world.setBlock(ix, iy, iz, interiorWall);
                    }
                }
                if (ix == x+8 && (Arrays.asList(z+3,z+5,z+11).contains(iz) == true)) {
                    for (int iy = y+1; iy < endY-1; iy++) {
                        world.setBlock(ix, iy, iz, interiorWall);
                    }
                }
                if (ix == x+9 && (Arrays.asList(z+3,z+5,z+11,z+12,z+13,z+15).contains(iz) == true)) {
                    for (int iy = y+1; iy < endY-1; iy++) {
                        world.setBlock(ix, iy, iz, interiorWall);
                    }
                }
                if (ix == x+10 && (Arrays.asList(z+3,z+5,z+11).contains(iz) == true)) {
                    for (int iy = y+1; iy < endY-1; iy++) {
                        world.setBlock(ix, iy, iz, interiorWall);
                    }
                }
                if (ix == x+11 && ((iz == z+3)||(iz>=z+5 && iz<=z+11))) {
                    for (int iy = y+1; iy < endY-1; iy++) {
                        world.setBlock(ix, iy, iz, interiorWall);
                    }
                }
                
                //windows
                
                if ((ix == x+7 || ix == x+9) && (iz == z || iz == endZ-1)) {
                    world.setBlock(ix, y+2, iz, windowBlock);
                }
                if ((ix == x+1 || ix == endX -2) && (iz == z+5 || iz == endZ-6)) {
                    world.setBlock(ix, y+2, iz, windowBlock);
                }
                if ((iz == z+7 || iz == z+9) && (ix == x || ix == endX-1)) {
                    world.setBlock(ix, y+2, iz, windowBlock);
                }
                if ((iz == z+1 || iz == endZ -2) && (ix == x+5 || ix == endX-6)) {
                    world.setBlock(ix, y+2, iz, windowBlock);
                }
            }
        }
        //clear blocks above doors
        world.setBlockToAir(x, y+2, z+8);
        world.setBlockToAir(x+11, y+2, z+8);
        ItemDoor.placeDoorBlock(world, x, y+1, z+8, 0, Block.doorWood);
        
        ItemDoor.placeDoorBlock(world, x+7, y+1, z+2, 0, Block.doorWood);
        world.setBlock(x+7, y+3, z+2, interiorWall);
        
        ItemDoor.placeDoorBlock(world, x+9, y+1, z+3, 1, Block.doorWood);
        world.setBlock(x+9, y+3, z+3, interiorWall);
        
        ItemDoor.placeDoorBlock(world, x+9, y+1, z+14, 0, Block.doorWood);
        world.setBlock(x+9, y+3, z+14, interiorWall);
        
        ItemDoor.placeDoorBlock(world, x+11, y+1, z+8, 2, Block.doorWood);
        
        //Power Source
        world.setBlock(x+8, y+1, z+8, powerSource);
        
        //Seating
        world.setBlock(endX - 3, y + 1, z + 7, Block.cloth.blockID, 9, 3);
        world.setBlock(endX - 3, y + 1, z + 9, Block.cloth.blockID, 9, 3);
        
        //Nav consoles
        world.setBlock(endX - 2, y + 1, z + 7, Block.cloth.blockID, 2, 3);
        world.setBlock(endX - 2, y + 1, z + 9, Block.cloth.blockID, 2, 3);
                
        return true;
    }
}