package com.kamaii.github.io.botigers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import java.util.Random;

public class botiger{
        //Names
        public static final String[] names = {
                "Arla", "Beech","Javan" ,"Mac", "Kay", "Mcdowell", "Vijay" ,"Rudd",
                "Theo" ,"Russell", "Humphrey", "Wynn", "Farhaan", "Reyna", "Jeanne","Ali",
                "Shyam","Iles", "Rafael", "Hernandez", "Morwenna", "Jennings", "Shelly", "Bowen",
                "Finnlay","Gamble", "Kyal", "Schaefer", "Sheena", "Esquivel", "Lily-May", "Le",
                "Priscilla","Betts", "Millicent" , "Mellor", "Nikki","Rosa", "Notch", "Humberto", "Rigoberto", "Alberto",
                "Carolyn","Thornton", "Greg", "Marquez", "Juan", "Carlos", "Mary", "Joseph", "Crawford", "Smith",
                "Karen", "Rogers", "Nguyen" , "Lee", "Thorn", "Flash", "Gordan", "Thom","Yorke","Queen","Jonathan","Joestar",
                "Star","Platinum","Advy","Wilson","Claymore","Rainbow", "Taco","Joe"
        };
        public int id;
        public String name;
        public Player owner;
        public Villager entity;
        public int bedTime;
        public int alarm;
        public int seekRange;
        public int speed;
        public int intelligence;
        public int luck;
        public int affinity;
        public float awakeTime;
        public boolean isAsleep;
        public boolean pathFinding = false;
        //Write
        public botiger(Player player, Villager target, FileConfiguration db) {
                owner = player;
                name = generateName();
                isAsleep = target.isSleeping();
                Random r = new Random();
                intelligence = r.nextInt(10);
                luck = r.nextInt(10);
                affinity = 10;
                awakeTime = 0;
                seekRange = 8;
                bedTime = 17;
                alarm = 0;
                pathFinding = false;
                target.setAI(false);
                target.setCustomName(name);
                target.setHealth(19);
                target.setInvulnerable(true);
                db.set(this.name,true);
                db.set(this.name + ".affinity",affinity);
                db.set(this.name + ".intelligence",intelligence);
                db.set(this.name + ".awakeTime",awakeTime);
                db.set(this.name + ".seekRange",seekRange);
                db.set(this.name + ".affinity",affinity);
                db.set(this.name + ".alarm", alarm);
                db.set(this.name + ".awakeTime",awakeTime);
                db.set(this.name + ".player",player.getUniqueId().toString());
                db.set(this.name + ".pathfinding",false);
        }
        //Read
        public botiger(String _name, Villager target,FileConfiguration db){
                String vilName = target.getCustomName().toString();
                if(db.getString(vilName + ".player") != null){
                       owner = Bukkit.getPlayer((String)db.get(vilName + "player"));
                }
                if(db.getString(vilName + ".player") != null ){
                        owner = Bukkit.getPlayer(db.getString(vilName + "player"));
                }
                luck = db.getInt(vilName + ".intelligence");
                name = _name;
                isAsleep = target.isSleeping();
                luck = db.getInt(vilName + ".intelligence");
                affinity = db.getInt(vilName + ".affinity");
                awakeTime = db.getInt(vilName + ".awakeTime");
                seekRange = db.getInt(vilName + ".seekRange");
                bedTime = db.getInt(vilName + ".bedTime");
                alarm = db.getInt(vilName  + ".alarm");
                pathFinding = false;
                target.setAI(false);
                target.setCustomName(name);
                target.setHealth(20);
                target.setInvulnerable(true);
        }
        private void rollStats(botiger bot){

        }
        public void seek(){
        }
        public void goSleep() {

        }
        public String generateName(){
                Random rand = new Random();
                String name = "";
                int r = 0;
                r = rand.nextInt(names.length);
                name += names[r] + " ";
                name += names[r] + " ";
                name += names[r];
                return name;
        }
}
