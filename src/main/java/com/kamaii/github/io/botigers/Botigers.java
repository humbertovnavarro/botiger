package com.kamaii.github.io.botigers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Botigers extends JavaPlugin  implements Listener {
    public yamlHandler yamlMan;
    public configHandler cfg;
    @Override
    public void onEnable() {
        getLogger().info("Starting up listener...");
        getServer().getPluginManager().registerEvents(this, this);
        // Plugin startup logic
        getLogger().info("Starting Botiger...");
        // Load config
        getLogger().info("Loading config from botigers.yml...");
        cfg = new configHandler(this);
        //Load yaml database handler.
        getLogger().info("Starting up yaml handler.");
        yamlMan = new yamlHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Stopping Botiger...");
        getLogger().info("Saving botigers to disk..");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getDisplayName() +
                "(" + event.getPlayer().getUniqueId() + ")";
        getLogger().info("Attempting to load " + playerName + "'s botiger(s)...");

    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        String playerName = event.getPlayer().getDisplayName() +
                "(" + event.getPlayer().getUniqueId() + ")";

        getLogger().info("Attempting to unload " + playerName + "'s botiger(s)...");

    }
}
