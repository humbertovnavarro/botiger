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
import org.bukkit.World;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Botigers extends JavaPlugin  implements Listener {
    //Handles operation of botiger database
    public yamlHandler yamlMan;
    //Does handling of the configuration within the database.
    public configHandler cfg;
    //A list of all active botigers (see botiger class)
    public List<botiger> activeBotigers;
    public static final File FileConfigurationPath = new File("./plugins/botigers/botigers.yml");
    @Override
    public void onEnable() {
        activeBotigers = new ArrayList<botiger>();
        getLogger().info("Starting up listener...");
        getServer().getPluginManager().registerEvents(this, this);
        // Plugin startup logic
        getLogger().info("Starting Botiger...");
        // Load config
        getLogger().info("Loading config from botigers.yml...");
        cfg = new configHandler(this);
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
            public void run(){
                for(int i = 0; i < activeBotigers.size(); i++){
                    if(activeBotigers.get(i).pathFinding){
                        activeBotigers.get(i).pather.next();
                    }
                }
            }
        }, 20, 20);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Stopping Botiger...");
        getLogger().info("Saving botigers to disk..");
        saveConfig();
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getDisplayName() +
                "(" + event.getPlayer().getUniqueId() + ")";
        getLogger().info("Attempting to load " + playerName + "'s botiger(s)...");
        saveConfig();
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getDisplayName() +
                "(" + event.getPlayer().getUniqueId() + ")";
        getLogger().info("Attempting to unload " + playerName + "'s botiger(s)...");
        saveConfig();
    }

    public void saveConfig(){
        try{
            this.getConfig().save(FileConfigurationPath);}
        catch(IOException ex){
            getLogger().info(ex.getStackTrace().toString());
        }
    }
}
