package com.kamaii.github.io.botigers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import java.util.List;
import java.util.Random;

public class botiger {
        //Names
        public static final String[] names = {
                "Arla", "Beech", "Javan", "Mac", "Kay", "Mcdowell", "Vijay", "Rudd", "Alfred", "Alani",
                "Theo", "Russell", "Humphrey", "Wynn", "Farhaan", "Reyna", "Jeanne", "Ali",
                "Shyam", "Iles", "Rafael", "Hernandez", "Morwenna", "Jennings", "Shelly", "Bowen",
                "Finnlay", "Gamble", "Kyal", "Schaefer", "Sheena", "Esquivel", "Lily-May", "Le",
                "Priscilla", "Betts", "Millicent", "Mellor", "Nikki", "Rosa", "Notch", "Humberto", "Rigoberto", "Alberto",
                "Carolyn", "Thornton", "Greg", "Marquez", "Juan", "Carlos", "Mary", "Joseph", "Crawford", "Smith",
                "Karen", "Rogers", "Nguyen", "Lee", "Thorn", "Flash", "Gordan", "Thom", "Yorke", "Queen", "Jonathan", "Joestar",
                "Star", "Platinum", "Advy", "Wilson", "Claymore", "Rainbow", "Taco", "Joe"
        };
        public int id;
        public String name;
        public Player owner;
        public Villager entity;
        public int bedTime;
        public int alarm;
        public int seekRange;
        public int agility;
        public int strength;
        public int intelligence;
        public int luck;
        public int affinity;
        public int wisdom;
        public int charisma;
        public float awakeTime;
        public boolean isAsleep;
        public int seekState;
        //Write
        public botiger(Player player, Villager target, FileConfiguration db) {
                owner = player;
                name = generateName();
                isAsleep = target.isSleeping();
                Random r = new Random();
                intelligence = r.nextInt(10) + 1;
                luck = r.nextInt(10) + 1;
                strength = r.nextInt(10) + 1;
                agility = r.nextInt(10) + 1;
                wisdom = r.nextInt(10) + 1;
                charisma = r.nextInt(10) + 1;
                affinity = 10;
                awakeTime = 0;
                seekRange = 8;
                bedTime = 17;
                alarm = 0;
                target.setAI(false);
                target.setCustomName(name);
                target.setHealth(19);
                target.setInvulnerable(true);
                db.set(this.name + ".active", true);
                db.set(this.name + ".agility",agility);
                db.set(this.name + ".strength",strength);
                db.set(this.name + ".wisdom",wisdom);
                db.set(this.name + ".charisma",charisma);
                db.set(this.name + ".luck", luck);
                db.set(this.name + ".intelligence", intelligence);
                db.set(this.name + ".awakeTime", awakeTime);
                db.set(this.name + ".alarm", alarm);
                db.set(this.name + ".seekRange", seekRange);
                db.set(this.name + ".affinity", affinity);
                db.set(this.name + ".player", player.getUniqueId().toString());
        }

        //Read
        public botiger(String _name, Villager target, FileConfiguration db) {
                if (db.getString(_name + ".player") != null) {
                        owner = Bukkit.getPlayer((String) db.get(_name + "player"));
                }
                if (db.getString(_name + ".player") != null) {
                        owner = Bukkit.getPlayer(db.getString(_name + "player"));
                }
                name = _name;
                luck = db.getInt(_name + ".luck");
                affinity = db.getInt(_name + ".affinity");
                awakeTime = db.getInt(_name + ".awakeTime");
                seekRange = db.getInt(_name + ".seekRange");
                bedTime = db.getInt(_name + ".bedTime");
                alarm = db.getInt(_name + ".alarm");
                target.setAI(false);
                target.setCustomName(name);
                target.setHealth(20);
                target.setInvulnerable(true);
        }

        private void rollStats(botiger bot) {

        }

        public void seek(Material mat) {
        }
        public void goSleep(FileConfiguration db) {
                
        }
        public String getPlayer(FileConfiguration db){
                return  db.getString(name + ".player");
        }
        public String generateName() {
                Random rand = new Random();
                String name = "";
                int r = 0;
                r = rand.nextInt(names.length);
                name += names[r] + " ";
                r = rand.nextInt(names.length);
                name += names[r] + " ";
                r = rand.nextInt(names.length);
                name += names[r];
                return name;
        }
}
