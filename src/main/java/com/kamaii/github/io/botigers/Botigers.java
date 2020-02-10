package com.kamaii.github.io.botigers;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Botigers extends JavaPlugin  implements Listener {
    //Where we save the file.
    public static final File FileConfigurationPath = new File("./plugins/botigers/botigers.yml");
    private configHandler cfg;
    private List<botiger> botigerList;
    private FileConfiguration db;
    @Override
    public void onEnable() {
        cfg = new configHandler(this);
        db = this.getConfig();
        botigerList = new ArrayList<botiger>();
        this.getServer().getPluginManager().registerEvents(this, this);

    }
    @Override
    public void onDisable() {
        log("Shutting down botigers");
        try{
            db.save(FileConfigurationPath);
        }
        catch(IOException ex){
            log("Error saving botigers.yml to " + FileConfigurationPath);
        }
    }
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        //Notice me senpai uwu
        Player eventPlayer = event.getPlayer();
        Entity clicked = event.getRightClicked();

        if(clicked.toString().equals("CraftVillager")){
            //If the villager has a custom name
            if(clicked.getCustomName() != null){
                //If this a botiger in the db
                if(db.getBoolean(clicked.getCustomName().toString())){
                    //If the uuid of the botigers player matches event player
                    if(db.getString(clicked.getCustomName().toString() + ".player").equals(eventPlayer.getUniqueId().toString()) ){
                        //open botiger interact menu.
                    }
                }
            }
            //If it is not a botiger
            else if(((Villager)clicked).getVillagerLevel() >= 5){
                //If player is sneaking and villager is master level, add them to the worker list if player below worker limit
                if(eventPlayer.isSneaking()){
                    int id = db.getInt(eventPlayer.getUniqueId().toString() + ".botigerCount");
                    if(id + 1 < cfg.botigerMax) {
                        botigerList.add(new botiger(eventPlayer,(Villager)clicked,db));
                        db.set(eventPlayer.getUniqueId().toString() + ".botigerCount", id + 1);
                        //Lets also save the config to prevent any server crashing mishaps
                        try{
                            this.getConfig().save(FileConfigurationPath);
                        }catch(Exception ex){
                            log("Error saving yml!");
                        }

                    }
                    else{
                        eventPlayer.sendMessage("You have too many botigers.");
                    }
                }else {
                    Villager trader = (Villager)clicked;
                    eventPlayer.sendMessage("This villager is available for hire.");

                }
            }else{
                eventPlayer.sendMessage("This villager is level " + ((Villager) clicked).getVillagerLevel());
            }
        }
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
    }
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        for(int i = 0; i < botigerList.size(); i ++){
            if(botigerList.get(i).getPlayer(db).equals(event.getPlayer().getUniqueId().toString())){
                botigerList.get(i).goSleep(db);
            }
        }
    }
    public void log(String msg){
        getLogger().info(msg);
    }
}
