package org.pixotic.xcraft;

import org.pixotic.xcraft.block.ModBlocks;
import org.pixotic.xcraft.core.proxy.CommonProxy;
import org.pixotic.xcraft.lib.Reference;
import org.pixotic.xcraft.tileentity.TileTest3DBlock;
import org.pixotic.xcraft.worldgen.UfoHandler;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod( modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class XCraft {
    
    @Instance("xcraft")
    public static XCraft Instance;
    
    @SidedProxy(clientSide = "org.pixotic.xcraft.core.proxy.ClientProxy", serverSide = "org.pixotic.xcraft.core.proxy.CommonProxy")
    public static CommonProxy Proxy;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.init();
    }
    
    @Init
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerTileEntity(TileTest3DBlock.class, "tileTest3DBlock");
        GameRegistry.registerWorldGenerator(new UfoHandler());
        Proxy.InitRendering();
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
    
}