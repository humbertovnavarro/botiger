package com.kamaii.github.io.botigers;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.World;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Botigers extends JavaPlugin  implements Listener {
    public static final File FileConfigurationPath = new File("./plugins/botigers/botigers.yml");
    private configHandler cfg;
    private List<botiger> botigerList;
    private yamlHandler db;
    @Override
    public void onEnable() {
        cfg = new configHandler(this);
        db = new yamlHandler(this,cfg);
        botigerList = new ArrayList<botiger>();
        this.getServer().getPluginManager().registerEvents(this, this);

    }
    @Override
    public void onDisable() {
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        log("What the fuck?");
    }
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Entity clicked = event.getRightClicked();
        if(clicked.toString().equals("CraftVillager")){
            if(clicked.getCustomName() != null){
                if(db.checkEntityID(clicked.getCustomName())){
                    if(db.getPlayerUUID(clicked.getCustomName()).equals(event.getPlayer().getUniqueId().toString())){
                        event.getPlayer().sendMessage("This is your botiger.");
                    }
                }
            }
            else if(((Villager)event.getRightClicked()).getVillagerLevel() >= 5){
                if(event.getPlayer().isSneaking()){
                    int id = db.getBotigerCount(event.getPlayer());
                    if(id + 1 < cfg.botigerMax) {
                        botigerList.add(db.saveBotiger(event.getPlayer(),new botiger(event.getPlayer(), (Villager) event.getRightClicked())));
                        db.setPlayer(event.getPlayer().getUniqueId().toString(), event.getRightClicked().getCustomName());
                        try{
                            this.getConfig().save(FileConfigurationPath);
                        }catch(Exception ex){
                            log("Error saving yml!");
                        }

                    }
                    else{
                        event.getPlayer().sendMessage("You have too many botigers.");
                    }
                }else {
                    event.getPlayer().sendMessage("This villager is available for hire.");
                }
            }else{
                event.getPlayer().sendMessage("This villager is level " + ((Villager) event.getRightClicked()).getVillagerLevel());
            }
        }
    }
    public void log(String msg){
        getLogger().info(msg);
    }
}
