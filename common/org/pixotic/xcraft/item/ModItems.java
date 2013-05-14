package org.pixotic.xcraft.item;

import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {
    
    public static Item laserPistol;

    public static void init() {

        laserPistol = new ItemLaserPistol(2222);

        GameRegistry.registerItem(laserPistol, "laserPistol");
        LanguageRegistry.addName(laserPistol, "Laser Pistol");
                
        initItemRecipes();

    }

    private static void initItemRecipes() {

        //GameRegistry.addRecipe(new ItemStack(glassBell), new Object[] {"iii", "i i", "i i", Character.valueOf('i'), Block.glass });
    }
}
