package org.pixotic.xcraft.block;

//import org.pixotic.xcraft.block.BlockName;
import org.pixotic.xcraft.block.BlockAlienAlloy;
//import org.pixotic.xcraft.lib.BlockIds;
//import org.pixotic.xcraft.lib.Strings;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;

//import com.pahimar.ee3.lib.BlockIds;
//import com.pahimar.ee3.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class ModBlocks {

    /* Mod block instances */
    //public status Block blockname;
    public static Block alienAlloy;
    public static Block test3DBlock;

    public static void init() {

        //blockName = new BlockNameClass(BlockIds.BLOCKNAME);
        alienAlloy = new BlockAlienAlloy(2222, Material.iron);
        test3DBlock = new BlockTest3DBlock(2223, Material.rock);

        //GameRegistry.registerBlock(blockName, Strings.BLOCKNAME_NAME);
        GameRegistry.registerBlock(alienAlloy, "alienAlloy");
        LanguageRegistry.addName(alienAlloy, "Alien Alloy");
        
        GameRegistry.registerBlock(test3DBlock, "test3DBlock");
        LanguageRegistry.addName(test3DBlock, "3d Test Block");
        
        initBlockRecipes();

    }

    private static void initBlockRecipes() {

        //GameRegistry.addRecipe(new ItemStack(glassBell), new Object[] {"iii", "i i", "i i", Character.valueOf('i'), Block.glass });
    }
    
}
