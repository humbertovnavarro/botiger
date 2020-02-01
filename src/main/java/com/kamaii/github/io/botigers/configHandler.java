package com.kamaii.github.io.botigers;

import org.bukkit.configuration.file.FileConfiguration;
import sun.net.www.protocol.file.FileURLConnection;

import java.io.File;
import java.io.IOException;
public class configHandler{
    public FileConfiguration db;
    public int botigerMax;
    public boolean doSleepDeprivation;
    public int botigerSpeedMax;
    //Max and min seek range of botigers (in chunks).
    public int botigerMaxSeek;
    public int botigerMinSeek;
    //Villager stat defaults
    public int botigerSpeedMin;
    public int botigerMinIntelligence;
    public int botigerMaxIntelligence;
    public int adminBotigerMax;
    public boolean debugMode;
    public boolean doBotigerInvulnerability = true;

    /*
        Handles configuration on startup, including methods to change configuration at runtime.
     */
    public configHandler(Botigers main){
        //Load config if config exists
        if(main.FileConfigurationPath.exists()) {
            db = main.getConfig();
            //Load the values from the database, if they're not null, otherwise set them to their defaults
            debugMode = db.get("debug") != null ? (boolean)db.get("debug") : false;
            botigerMax = db.get("BotigerMax") != null ? (int)db.get("BotigerMax") : 3;
            adminBotigerMax= db.get("AdminBotigerMax") != null ? (int)db.get("AdminBotigerMax") : 2147483647;
            doSleepDeprivation = db.get("doSleepDeprivation") != null ? (boolean)db.get("DoSleepDeprivation") : true;
            botigerSpeedMin = db.get("BotigerMinIntelligence") != null ? (int)db.get("BotigerSpeedMax") : 10;
            botigerSpeedMax = db.get("BotigerMaxIntelligence") != null ? (int)db.get("BotigerSpeedMax") : 100;
            botigerMaxSeek = db.get("BotigerMaxSeek") != null ? (int)db.get("BotigerSpeedMax") : 8;
            botigerMinSeek = db.get("BotigerMinSeek") != null ? (int)db.get("BotigerSpeedMax") : 3;
            doBotigerInvulnerability = db.get("DoBotigerInvulnerability") != null ? (boolean)db.get("DoBotigerInvulnerability") : true;
        }
        //Otherwise create one with default values.
        else{
            main.getLogger().info("No yml detected, creating one.");
            db = main.getConfig();
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
            //Then we'll set the values here instead of loading them.
            botigerMax = 3;
            adminBotigerMax = 2147483647;
            doSleepDeprivation = true;
            botigerSpeedMax = 0;
            botigerSpeedMin = 10;
            botigerMinIntelligence = 10;
            botigerMaxIntelligence = 10;
            botigerMaxSeek = 8;
            botigerMinSeek= 3;
            doBotigerInvulnerability = true;
        }
    }
}
