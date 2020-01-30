package com.kamaii.github.io.botigers;

import com.sun.media.jfxmedia.logging.Logger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
public final class Botigers extends JavaPlugin  implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Logger.logMsg(0,"Starting Botigers");
        sqlHandler sqlMan = new sqlHandler();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Logger.logMsg(0,"Stopping Botigers");
    }

    @EventHandler
    public void onPlayerJoin(){

    }
}
