package org.pixotic.xcraft.world;
import java.util.List;

import org.pixotic.xcraft.block.ModBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenXcraft extends BiomeGenBase
{
    private WorldGenerator CombatTheatre;
    public final Material blockMaterial;
    public BiomeGenXcraft(int par1) {
        super(par1);
        this.blockMaterial = Material.water;
        this.minHeight = 0.1F;
        this.maxHeight = 0.6F;
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.topBlock = ((byte)Block.sponge.blockID);
        this.fillerBlock = ((byte)Block.blockRedstone.blockID);
        this.setBiomeName("X-Craft Combat Theatre");

        /** this changes the water colour, its set to red now but ggole the java colours **/
        this.waterColorMultiplier = 0xE42D17;
    }
}
