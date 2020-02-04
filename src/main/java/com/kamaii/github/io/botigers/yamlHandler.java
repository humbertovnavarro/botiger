package com.kamaii.github.io.botigers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
/*
    Methods for handling database of botigers.
 */
public class yamlHandler extends Thread{
    private FileConfiguration db;
    private configHandler cfg;
    private Botigers run;
    public yamlHandler(Botigers main, configHandler c){
        run = main;
        db = run.getConfig();
        cfg = c;
    }
    public String getPlayerUUID(String customName){
        String uuid = (String)db.get("botigers" + customName + ".player");
        return uuid;
    }
    public boolean checkEntityID(String id){
        if(db.get("botigers." + id) != null){
            return true;
        }
        else{
            return false;
        }
    }
    public int getIntelligence(botiger get){
        String entry = get.name + ".";
        if(db.get(entry + "intelligence") != null){
            return (int) db.get(entry + "intelligence");
        }else{
            run.getLogger().info("Error in botigers.yml. Could not fetch "  + entry + "intelligence");
            return 1;
        }
    }
    public int getBedtime(botiger get){
        String entry = get.name + ".";
        if(db.get(entry + "bedtime") != null){
            return (int) db.get(entry + "bedtime");
        }else{
            run.getLogger().info("Error in botigers.yml. Could not fetch "  + entry + "bedtime");
            return 1;
        }
    }
    public int getAlarm(botiger get){
        String entry = get.name + ".";
        if(db.get(entry + "bedtime") != null){
            return (int) db.get(entry + "alarm");
        }else{
            run.getLogger().info("Error in botigers.yml. Could not fetch "  + entry + "alarm");
            return 1;
        }
    }
    public void setIntelligence(botiger set){
        db.set("botigers." + set.name + ".intelligence",set.intelligence);
    }
    public void setBedtime(botiger set){
        db.set("botigers." + set.name + ".bedtime",set.bedTime);
    }
    public void setAlarm(botiger set){
        db.set("botigers." + set.name + ".alarm",set.alarm);
    }
    public int getBotigerCount(Player player){
        int botigerCount = 0;
        for(int i = 0; i < cfg.botigerMax; i++){
                if ( db.get(player.getUniqueId() + ".botigers." + i + ".active") != null && (boolean) db.get(player.getUniqueId() + ".botigers." + i + ".exists")) {
                    botigerCount++;
                }
        }
        return botigerCount;
    }
    public void setActive(botiger set){
        db.set("botigers." + set.name + "." + set.id + ".active",true);
    }
    public void setPlayer(String name, String player){
        db.set("botigers." + name + "." + ".player",player);
    }
    public botiger saveBotiger(Player eventPlayer,botiger add) {
        setActive(add);
        setAlarm(add);
        setBedtime(add);
        setIntelligence(add);
        return add;
    }
}
