package com.kamaii.github.io.botigers;

import org.bukkit.block.Block;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Player;
public class botiger{
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
        public float isAsleep;
        public botiger() {
                name = getRandomName();
        }
        public void kill() {
            entity.damage(99999); //Change this
        }
        private String getRandomName(){
                
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
}
