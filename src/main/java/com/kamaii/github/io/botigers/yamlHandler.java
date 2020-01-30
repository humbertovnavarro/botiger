package com.kamaii.github.io.botigers;
import com.sun.source.util.Plugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import com.kamaii.github.io.botigers.botiger;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.IOException;
import java.util.List;
public class yamlHandler extends JavaPlugin {
    public FileConfiguration db;
    public yamlHandler() throws IOException {
        db = this.getConfig();
        db.set("player", 1);
        db.set("player.villagers.villager1", 1);
        db.set("player.villagers.villager2", 1);
        try {
            db.save("//config//botigers.yml");
        } catch (IOException ex) {
            getLogger().info("Error: the botigers.yml could not be saved. Does it exist? Maybe you don't have write access?");
        }

    }
    public botiger grabPlayerBotiger(Player player){
        //Spawn villager
        Villager thisVillager = (Villager)player.getWorld().spawnEntity(player.getLocation(),EntityType.VILLAGER);
        botiger pBotiger = new botiger("KamikazeeKreep",player,thisVillager, Villager.Profession.ARMORER);
        //Grab from yml database here.
        return pBotiger;
    }
    public void delBotiger ( Player player){

    }
    public void addBotiger ( Player player){


    }
    public void deployBotiger(Player player){

    }
    public void destroyBotiger(Player player){

    }
}
