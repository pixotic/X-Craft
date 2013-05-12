package org.pixotic.xcraft.block;

import java.util.Random;

import org.pixotic.xcraft.lib.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class BlockAlienAlloyWindow extends Block {
    //@SideOnly(Side.CLIENT)
    //private Icon iconSides;
    @SideOnly(Side.CLIENT)
    private Icon iconEnds;
    
    public BlockAlienAlloyWindow(int id, Material par2Material) {
        super(id, par2Material);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName("alienAlloyWindow");
        this.setHardness(8.0f);
        this.setResistance(50.0f);
    }
    
    @SideOnly(Side.CLIENT)
    //public void registerIcons(IconRegister par1IconRegister) {
    //    this.blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":alien-alloy-ph");
    //}
    
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getIcon(int par1, int par2)
    {
        return (par1 == 1 || par1 == 0) ? this.iconEnds : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":alien-alloy-window-large");
        this.iconEnds = par1IconRegister.registerIcon(Reference.MOD_ID + ":alien-alloy-floor");
    }
    
    public int idDropped(int par1, Random random, int zero) {
        return ModBlocks.alienAlloy.blockID;
    }
    
}
