package com.kamaii.github.io.botigers;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.Random;
public class botiger{
        //Names
        public static String[] names = {
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
        public Villager.Profession profession;
        public boolean isAlive;
        //Go figure. Can be set by players in guihandler
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
        public botiger() {
                name = generateName();
                profession = entity.getProfession();
                isAsleep = entity.isSleeping();
                isAlive = !entity.isDead();
                Random r = new Random();
                intelligence = r.nextInt(10);
                luck = r.nextInt(10);
                affinity = 10;
                awakeTime = 0;
                seekRange = 8;
                bedTime = 17;
                alarm = 0;
                pathFinding = false;
        }
        public botiger(Player player, int id, FileConfiguration db){
                String stats = player.getUniqueId() + "." + id + ".";
                db.get(stats + "luck");
                db.get(stats + "profession");
        }
        public void kill() {
            entity.damage(99999); //Change this
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
