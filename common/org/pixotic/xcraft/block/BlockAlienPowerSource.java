package org.pixotic.xcraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.ForgeDirection;

import org.pixotic.xcraft.XCraft;
import org.pixotic.xcraft.core.proxy.ClientProxy;
import org.pixotic.xcraft.lib.Reference;
import org.pixotic.xcraft.tileentity.TileEntityAlienPowerSource;
import org.pixotic.xcraft.world.XCraftTeleporter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAlienPowerSource extends BlockContainer {
    public BlockAlienPowerSource(int id, Material par2Material) {
        super(id, par2Material);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName("xcraftAlienPowerSource");
        this.setHardness(3.0f);
        this.setResistance(0.0f);
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":elerium");
    }
    
    @Override
    public boolean hasTileEntity() { 
        return true;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer playerEntity, int par6, float par7, float par8, float par9)
    {
        // Temporary! Clicking this will take you to the temp dim
        if ((playerEntity.ridingEntity == null) && (playerEntity.riddenByEntity == null) && ((playerEntity instanceof EntityPlayerMP))) {
            EntityPlayerMP thePlayer = (EntityPlayerMP)playerEntity;
            if (thePlayer.dimension != XCraft.XCraftDimID) {
                //thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, XCraft.XCraftDimID, new XCraftTeleporter(thePlayer.mcServer.worldServerForDimension(XCraft.XCraftDimID)));
            }
            else {
                //thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new XCraftTeleporter(thePlayer.mcServer.worldServerForDimension(0)));
            }
        }
        // End of temp code
        
        if(playerEntity.isSneaking())
            return false;
        
        //There should be something neat that happens, I guess. TODO: Add more neat stuff.
        //playerEntity.setEntityHealth(0);
        return true;
    }

    
    @Override
    public boolean isOpaqueCube() {
        return false;
    }
    
    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public int getLightValue (IBlockAccess world, int x, int y, int z) {
        return 15;
    }
    
    public TileEntity createNewTileEntity(World world) {
        return new TileEntityAlienPowerSource();
    }
    
    public int getRenderType() {
        return ClientProxy.renderID;
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {
        int direction = 0;
        int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        if (facing == 0) {
            direction = ForgeDirection.NORTH.ordinal();
        }
        else if (facing == 1) {
            direction = ForgeDirection.EAST.ordinal();
        }
        else if (facing == 2) {
            direction = ForgeDirection.SOUTH.ordinal();
        }
        else if (facing == 3) {
            direction = ForgeDirection.WEST.ordinal();
        }

        world.setBlockMetadataWithNotify(x, y, z, direction, 3);

        ((TileEntityAlienPowerSource) world.getBlockTileEntity(x, y, z)).setOrientation(direction);
    }
    
    
}
