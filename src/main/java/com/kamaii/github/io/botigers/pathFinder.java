package com.kamaii.github.io.botigers;
/*
    Calculates paths based on block data and other information

 */

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Villager;

public class pathFinder {
    //How far to look for blocks.
    Block target;
    private int seekRange;
    //How lazy should we be about finding paths 0 being pick the first valid route, 10 being pick the optimal route.
    private int intelligence;
    //How often we should step the botiger. ranges from 0 to 10
    private int stepHigh; //How often we should refresh the villagers movement in high quality mode.
    private int stepLow; //How often we should refresh the villagers movement in low quality mode.
    private int resolution; //Place a step point every x meters.
    //private Vector3[] pathPoints;
    public pathFinder(Villager vil){
        vil.getFacing();
        
    }
}
