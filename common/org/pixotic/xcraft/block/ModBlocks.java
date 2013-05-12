package org.pixotic.xcraft.block;

//import org.pixotic.xcraft.block.BlockName;
import org.pixotic.xcraft.block.BlockAlienAlloy;
//import org.pixotic.xcraft.lib.BlockIds;
//import org.pixotic.xcraft.lib.Strings;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


//import com.pahimar.ee3.lib.BlockIds;
//import com.pahimar.ee3.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class ModBlocks {

    /* Mod block instances */
    //public status Block blockname;
    //public static Block test3DBlock;
    public static Block alienAlloy;
    public static Block alienAlloyWindow;
    public static Block alienPowerSource;
    public static Block baseSmallRadar;

    public static void init() {

        //blockName = new BlockNameClass(BlockIds.BLOCKNAME);
        //test3DBlock = new BlockTest3DBlock(2223, Material.rock);
        alienAlloy = new BlockAlienAlloy(2222, Material.iron);
        alienAlloyWindow = new BlockAlienAlloyWindow(2225, Material.iron);
        alienPowerSource = new BlockAlienPowerSource(2223, Material.rock);
        baseSmallRadar = new BlockBaseSmallRadar(2224, Material.iron);

        //GameRegistry.registerBlock(blockName, Strings.BLOCKNAME_NAME);
        //GameRegistry.registerBlock(test3DBlock, "test3DBlock");
        //LanguageRegistry.addName(test3DBlock, "3d Test Block");
        GameRegistry.registerBlock(alienAlloy, "alienAlloy");
        LanguageRegistry.addName(alienAlloy, "Alien Alloy");
        GameRegistry.registerBlock(alienAlloyWindow, "alienAlloyWindow");
        LanguageRegistry.addName(alienAlloyWindow, "UFO Window");
        GameRegistry.registerBlock(alienPowerSource, "alienPowerSource");
        LanguageRegistry.addName(alienPowerSource, "Alien Power Source");
        GameRegistry.registerBlock(baseSmallRadar, "baseSmallRadar");
        LanguageRegistry.addName(baseSmallRadar, "Small Radar");
        
        
        initBlockRecipes();

    }

    private static void initBlockRecipes() {

        //GameRegistry.addRecipe(new ItemStack(glassBell), new Object[] {"iii", "i i", "i i", Character.valueOf('i'), Block.glass });
    }
    
}
