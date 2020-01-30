package com.kamaii.github.io.botigers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class configHandler extends JavaPlugin{
    public FileConfiguration db;
    public int botigerMax;
    public boolean doSleepDeprivation;
    public int botigerSpeedMax;
    //Max and min seek range of botigers (in chunks).
    public int botigerMaxSeek;
    public int botigerMinSeek;
    //Villager stat defaults
    public int maxSpeed;
    public int minSpeed;
    public int maxIntelligence;
    public int minIntelligence;

    public configHandler(){
        //Load config if config exists
        if(new File("//config//botigers.yml").exists()) {

        }
        //Otherwise create one with default values.
        else{
            db = getConfig();
            db.set("BotigerMax",3);
            db.set("AdminBotigerMax",0);
            db.set("DoSleepDeprivation",true);
            db.set("BotigerSpeedMax",100);
            db.set("BotigerSpeedMin",10);
            db.set("MinIntelligence",10);
            db.set("MaxIntelligence",100);
            db.set("BotigerMaxSeek",8);
            db.set("BotigerMinSeek",3);
            db.set("DoBotigerInvulnerability",true);
            try{
                db.save("//config//botigers.yml");
            }
            catch(IOException ex){
                getLogger().info("Error saving botigers.yml. Check write permissions.");

            }
        }
    }
}
