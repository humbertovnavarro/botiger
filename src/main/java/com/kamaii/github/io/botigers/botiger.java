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
        public static final String hiddenTag = "§8§1§9§2";
        //Constructer for new botigers at runtime
        public botiger(Player player, Villager target) {
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
                target.setCustomName(name);
                target.setHealth(19);
                target.setInvulnerable(true);
        }
        public botiger(){
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
