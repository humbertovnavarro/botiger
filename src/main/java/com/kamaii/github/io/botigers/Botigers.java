package com.kamaii.github.io.botigers;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

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
        //Load yaml database handler.
        cfg = new configHandler(this);
        getLogger().info("Starting up yaml handler.");
        yamlMan = new yamlHandler(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Stopping Botiger...");
        getLogger().info("Saving botigers to disk..");
        try{
        this.getConfig().save("./plugins/botigers/botigers.yml");}
        catch(IOException ex){
            getLogger().info(ex.getStackTrace().toString());
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getDisplayName() +
                "(" + event.getPlayer().getUniqueId() + ")";
        getLogger().info("Attempting to load " + playerName + "'s botiger(s)...");
        Location l = event.getPlayer().getLocation();
        botiger debugBotiger = new botiger("Jerry", event.getPlayer(),(Villager)event.getPlayer().getWorld().spawnEntity(l,EntityType.VILLAGER), Villager.Profession.ARMORER);
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getDisplayName() +
                "(" + event.getPlayer().getUniqueId() + ")";

        getLogger().info("Attempting to unload " + playerName + "'s botiger(s)...");
        try{
            this.getConfig().save("./plugins/botigers/botigers.yml");}
        catch (IOException ex){
            this.getLogger().info(ex.getStackTrace().toString());
        }
    }
}
