package com.kamaii.github.io.botigers;

import org.bukkit.World;
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
        public static final String hiddenTag = "     ";
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
        public pathFinder pather;
        public yamlHandler db;

        //For new botigers
        public botiger(Player player, Villager target, int _id) {
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
                target.setCustomName(name + " " + player.getUniqueId().toString() + " " + id);
                target.setHealth(69);
                target.setInvulnerable(true);
                id = _id;
        }
        public botiger(int id, FileConfiguration db, World world, Villager ent,Player player){
                if(ent.getHealth() == 69){
                        if(ent.getCustomName().contains(player.getUniqueId().toString())){
                                String stats = player.getUniqueId() + "." + id + ".";
                                luck = (int)db.get(stats + "luck");
                                intelligence = (int)db.get(stats + "intelligence");
                                db.set(stats + "alive",true);
                        }
                }
        }
        private void rollStats(botiger bot){

        }
        public void seek(){
        }
        public void pathFindOre() {


        }
        public void pathFindMobs() {

        }
        public void pathFindFish() {

        }

        public void pathFindNextPatrolStop() {

        }

        public void goSleep() {

        }
        public String generateName(){
                String newName = "";
                Random r = new Random();
                int rand = r.nextInt() * (names.length + 1);
                newName += names[rand];
                rand = r.nextInt() * (names.length + 1);
                newName += " " + names[rand];
                return newName;
        }
}
