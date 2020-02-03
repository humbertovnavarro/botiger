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
    public yamlHandler(Botigers main){
        run = main;
        db = run.getConfig();
        cfg = run.cfg;
    }
    public void delBotiger(Player player, int id){
            int botigerCount = getBotigerCount(player);
            player.sendMessage(botigerCount + "/" + cfg.botigerMax + " botigers deployed.");
            if (botigerCount < cfg.botigerMax) {
                db.set(player.getUniqueId().toString() + ".botigers." + id +  ".exists", true);
            } else {
                player.sendMessage("You have too many botigers!");
            }
    }
    public void addBotiger ( Player player, botiger pBotiger){
            int botigerCount = getBotigerCount(player);
            if (botigerCount + 1 <= cfg.botigerMax) {
                String botigerEntry = player.getUniqueId().toString() + ".botigers." + botigerCount + ".";
                db.set(botigerEntry + "exists", true);
                db.set(botigerEntry + "active", false);
                db.set(botigerEntry + "profession",pBotiger.profession);
                db.set(botigerEntry + "bedtime",pBotiger.bedTime);
                db.set(botigerEntry + "alarm",pBotiger.alarm);
                db.set(botigerEntry + "affinity",pBotiger.affinity);
                db.set(botigerEntry + "intelligence",pBotiger.intelligence);
                db.set(botigerEntry + "speed",pBotiger.speed);
                db.set(botigerEntry + "strength",pBotiger.awakeTime);
                db.set(botigerEntry + "luck",pBotiger.luck);
                db.set(botigerEntry + "isAsleep",pBotiger.isAsleep);
            } else {
                player.sendMessage("You have too many botigers!");
            }
    }
    public void deployBotiger(Player player, int idNum, Villager ent){
        String uuid = player.getUniqueId().toString();
        String activeBotiger = uuid + ".botigers." + idNum + ".active";
        String existsBotiger = uuid + ".botigers." + idNum + ".exists";
            if (db.get(existsBotiger) != null && (boolean) db.get(existsBotiger)) {
                player.sendMessage(("This botiger does not exist."));
            } else if (db.get(activeBotiger) != null && (boolean) db.get(activeBotiger)) {
                player.sendMessage(("This botiger is already deployed."));
            } else {
                run.activeBotigers.add(new botiger(idNum, this.db,ent.getWorld(),ent));
                db.set(activeBotiger,true);
            }
    }
    public void destroyBotiger(Player player, int idNum){
        String uuid = player.getUniqueId().toString();
        String activeBotiger = uuid + ".botigers." + idNum + ".active";
        String existsBotiger = uuid + ".botigers." + idNum + ".exists";
        String botigerName   = uuid + ".botigers." + idNum + ".name";
        String botigerProfession = uuid + ".botigers." + idNum + ".profession";
            if (db.get(existsBotiger) != null && (boolean) db.get(existsBotiger)) {
                player.sendMessage(("This botiger doesn't exist."));
            } else if (!(boolean) db.get(activeBotiger)) {
                player.sendMessage(("This botiger is not out."));
            } else {
                db.set(activeBotiger, false);
                int count = run.activeBotigers.size();
                for (int i = 0; i < count; i++) {
                    if (run.activeBotigers.get(i).id == idNum) {
                        run.activeBotigers.remove(i);
                    }
                }
            }
    }
    public int getBotigerCount(Player player){
        int botigerCount = 0;
        for(int i = 0; i < cfg.botigerMax; i++){
                if ( db.get(player.getUniqueId() + ".botigers." + i + ".exists") != null && (boolean) db.get(player.getUniqueId() + ".botigers." + i + ".exists")) {
                    botigerCount++;
                }
        }
        return botigerCount;
    }
}
