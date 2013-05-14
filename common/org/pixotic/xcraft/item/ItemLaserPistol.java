package org.pixotic.xcraft.item;

import org.pixotic.xcraft.entity.projectile.EntityLaserBeam;
import org.pixotic.xcraft.lib.Reference;
import org.pixotic.xcraft.lib.Sounds;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLaserPistol extends Item {
    public ItemLaserPistol (int id) {
        super(id);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabMisc);
        this.setUnlocalizedName("laserPistol");
    }
    
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":laser-pistol-large");
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            //Laser weapons do not consume ammo
            //--par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, Sounds.LASER_SHOT, 0.5F, 1.0F);

        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(new EntityLaserBeam(par2World, par3EntityPlayer));
        }

        return par1ItemStack;
    }
    
}
