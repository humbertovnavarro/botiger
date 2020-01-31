package com.kamaii.github.io.botigers;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import java.io.IOException;
import com.kamaii.github.io.botigers.botiger;
import org.bukkit.plugin.java.JavaPlugin;
import sun.security.krb5.Config;
import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.IOException;
import java.util.List;
//Handles database portion.
public class yamlHandler{
    FileConfiguration db;
    public yamlHandler(Botigers main){
        db = main.getConfig();
        db.set("player", 1);
        db.set("player.villagers.villager1", 1);
        db.set("player.villagers.villager2", 1);
        try {
            db.save("//config//botigers.yml");
        } catch (IOException ex) {
            main.getLogger().info("Error: the botigers.yml could not be saved. Does it exist? Maybe you don't have write access?");
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
