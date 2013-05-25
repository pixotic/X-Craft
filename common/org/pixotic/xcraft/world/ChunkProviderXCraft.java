package org.pixotic.xcraft.world;

import java.util.List;
import java.util.Random;

import org.pixotic.xcraft.block.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;

public class ChunkProviderXCraft implements IChunkProvider {
    private Random rand;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    private World worldObj;
    private final boolean mapFeaturesEnabled;
    private MapGenBase caveGenerator = new MapGenCaves();
    private MapGenStronghold strongholdGenerator = new MapGenStronghold();
    private MapGenVillage villageGenerator = new MapGenVillage();
    private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
    private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
    private MapGenBase ravineGenerator = new MapGenRavine();
    private BiomeGenBase[] biomesForGeneration;
    double[] noise3;
    double[] noise1;
    double[] noise2;
    double[] noise5;
    double[] noise6;
    float[] parabolicField;
    int[][] field_73219_j = new int[32][32];
    
    public ChunkProviderXCraft(World par1World, long par2, boolean par4) {
        this.worldObj = par1World;
        this.mapFeaturesEnabled = par4;
        this.rand = new Random(par2);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
    }
    
    /**
    * Generates the shape of the terrain for the chunk though its all stone though the water is frozen if the
    * temperature is low enough
    */
    public void generateTerrain(int par1, int par2, byte[] par3ArrayOfByte) {

    }
    public void replaceBlocksForBiome(int par1, int par2, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase) {

    }
    public Chunk loadChunk(int par1, int par2) {
        return provideChunk(par1, par2);
    }
    public Chunk provideChunk(int par1, int par2) {
        this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
        byte[] var3 = new byte[32768];
        generateTerrain(par1, par2, var3);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
        replaceBlocksForBiome(par1, par2, var3, this.biomesForGeneration);
        this.caveGenerator.generate(this, this.worldObj, par1, par2, var3);
        this.ravineGenerator.generate(this, this.worldObj, par1, par2, var3);
        if (this.mapFeaturesEnabled) {
            this.mineshaftGenerator.generate(this, this.worldObj, par1, par2, var3);
            this.villageGenerator.generate(this, this.worldObj, par1, par2, var3);
            this.strongholdGenerator.generate(this, this.worldObj, par1, par2, var3);
            this.scatteredFeatureGenerator.generate(this, this.worldObj, par1, par2, var3);
        }
        Chunk var4 = new Chunk(this.worldObj, var3, par1, par2);
        byte[] var5 = var4.getBiomeArray();
        for (int var6 = 0; var6 < var5.length; var6++) {
            var5[var6] = ((byte)this.biomesForGeneration[var6].biomeID);
        }
        var4.generateSkylightMap();
        return var4;
    }
    public boolean chunkExists(int par1, int par2) {
        return true;
    }
    public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
        net.minecraft.block.BlockSand.fallInstantly = true;
        int var4 = par2 * 16;
        int var5 = par3 * 16;
        BiomeGenBase var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
        this.rand.setSeed(this.worldObj.getSeed());
        long var7 = this.rand.nextLong() / 2L * 2L + 1L;
        long var9 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(par2 * var7 + par3 * var9 ^ this.worldObj.getSeed());
        boolean var11 = false;
        if (this.mapFeaturesEnabled) {
            this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
            var11 = this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
            this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
            this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
        }
        if ((!var11) && (this.rand.nextInt(4) == 0)) {
            int var12 = var4 + this.rand.nextInt(16) + 8;
            int var13 = this.rand.nextInt(128);
            int var14 = var5 + this.rand.nextInt(16) + 8;
            new WorldGenLakes(Block.waterStill.blockID).generate(this.worldObj, this.rand, var12, var13, var14);
        }
        var6.decorate(this.worldObj, this.rand, var4, var5);
        SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
        var4 += 8;
        var5 += 8;
        for (int var12 = 0; var12 < 16; var12++) {
            for (int var13 = 0; var13 < 16; var13++) {
                int var14 = this.worldObj.getPrecipitationHeight(var4 + var12, var5 + var13);
                if (this.worldObj.isBlockFreezable(var12 + var4, var14 - 1, var13 + var5)) {
                    this.worldObj.setBlock(var12 + var4, var14 - 1, var13 + var5, Block.ice.blockID);
                }
                if (this.worldObj.canSnowAt(var12 + var4, var14, var13 + var5)) {
                    this.worldObj.setBlock(var12 + var4, var14, var13 + var5, Block.snow.blockID);
                }
            }
        }
        net.minecraft.block.BlockSand.fallInstantly = false;
    }
    public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
        return true;
    }
    public boolean unload100OldestChunks() {
        return false;
    }
    public boolean canSave() {
        return true;
    }
    public String makeString() {
        return "RandomLevelSource";
    }
    public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
        BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(par2, par4);
        return var5 == null ? null : var5.getSpawnableList(par1EnumCreatureType);
    }
    public ChunkPosition findClosestStructure(World par1World, String par2Str, int par3, int par4, int par5) {
        return ("Stronghold".equals(par2Str)) && (this.strongholdGenerator != null) ? this.strongholdGenerator.getNearestInstance(par1World, par3, par4, par5) : null;
    }
    public int getLoadedChunkCount() {
        return 0;
    }
    public boolean unloadQueuedChunks() {
        return false;
    }
    public void recreateStructures(int i, int j) {
    }
    //@Override
    public void func_104112_b() {
        //TODO Auto-generated method stub
    }
}