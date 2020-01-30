package com.kamaii.github.io.botigers;

import org.bukkit.entity.Villager;
import org.bukkit.entity.Player;
public class botiger{
        private int _id;
        private String _name;
        private Player _owner;
        private Villager _entity;
        private Villager.Profession _profession;
        private boolean _isAlive;

        //Go figure. Can be set by players in guihandler
        private int bedTime;
        private int alarm;

        //Botiger statblock

        //How far the botiger can see in blocks
        private int _seekRange;
        private int _speed;
        //How likely the bot is to pathfind the shortest path. Ranges from 0 to 100%
        //*However a max tick time exists that overrides this.
        private int _intelligence;
        private int _luck; //How likely a villager is to catch a fish,
        // find an ore behind a block, or get a crit.

        /*How much the villager likes you. Ranges from 0-10.
          A value of zero causes your botiger to quit. A value of > 7 sets stats to 100%
           < 6 90%  < 5 50% < 4 20% < 3 10%
          decays each hour after 10 hours of sleep debt
         */
        private int _affinity;
        private int _rest;
        private float _sleep;
        /*How much rest the villager has had since 0
         */
        //================

        public botiger(String name, Player owner, Villager entity, Villager.Profession profession) {
            _name = name;
            _profession = profession;
            _isAlive = true;
            _entity = entity;
        }

        public void kill() {
            _entity.damage(99999);
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
