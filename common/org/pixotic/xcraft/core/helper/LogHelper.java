package org.pixotic.xcraft.core.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.pixotic.xcraft.lib.Reference;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {

    private static Logger xcraftLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {

        xcraftLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        xcraftLogger.log(logLevel, message);
    }

}
