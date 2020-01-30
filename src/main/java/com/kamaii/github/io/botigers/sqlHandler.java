package com.kamaii.github.io.botigers;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import com.kamaii.github.io.botigers.botiger;
import java.util.List;
import java.io.File;

public class sqlHandler {
    private File _database;
    private List <botiger> botigerList;
    public sqlHandler(File fil){
        if(!_database.exists()){
            //Create a new db
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
