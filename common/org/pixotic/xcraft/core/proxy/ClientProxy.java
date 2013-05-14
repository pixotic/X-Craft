package org.pixotic.xcraft.core.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import org.pixotic.xcraft.client.TileEntityAlienPowerSourceRenderer;
import org.pixotic.xcraft.client.renderer.item.ItemAlienPowerSourceRenderer;
import org.pixotic.xcraft.entity.projectile.EntityLaserBeam;
import org.pixotic.xcraft.renderer.projectile.RenderLaserBeam;
import org.pixotic.xcraft.tileentity.TileEntityAlienPowerSource;

import org.pixotic.xcraft.client.audio.SoundHandler;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;


public class ClientProxy extends CommonProxy
{
    public static final int renderID = RenderingRegistry.getNextAvailableRenderId();
    
    @Override
    public void InitRendering()
    {
        EntityRegistry.registerGlobalEntityID(EntityLaserBeam.class, "laserBeam", EntityRegistry.findGlobalUniqueEntityId());
        RenderingRegistry.registerEntityRenderingHandler(EntityLaserBeam.class,  new RenderLaserBeam());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAlienPowerSource.class, new TileEntityAlienPowerSourceRenderer());
        MinecraftForgeClient.registerItemRenderer(2223, new ItemAlienPowerSourceRenderer());
    }
    
    @Override
    public void registerSoundHandler() {

        MinecraftForge.EVENT_BUS.register(new SoundHandler());
    }
}