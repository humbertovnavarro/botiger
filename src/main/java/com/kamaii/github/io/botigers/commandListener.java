package com.kamaii.github.io.botigers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/*
    Listens for chat commands and executes said commands.
 */
public class commandListener implements CommandExecutor {
    private boolean debugMode;
    private Botigers run;
    public commandListener(boolean debug){
        debugMode = debug;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(debugMode){//Listen for these commands
            if(command.getName().equalsIgnoreCase("botigersdebug")) {
                if (sender instanceof Player) {
                    //Add a botiger to players database.
                    if (args[1].equalsIgnoreCase("add")) {

                    }
                    //remove a botiger from players database
                    if (args[1].equalsIgnoreCase("remove")) {

                    }
                    //take a botiger from players database and deploy it in the world.
                    if (args[1].equalsIgnoreCase("deploy")) {

                    }
                    //destroy and pack a botiger thats already in the world. (in runtime botiger list, see Botigers.activeBotigers)
                    if (args[1].equalsIgnoreCase(("destroy"))) {
                        //If were not looking at a botiger ignore this.
                    }

                }
            }
            else{
                if(args[1].equalsIgnoreCase("add") && args[2] != null){
                   // run.yamlMan.addBotiger(args[2].toString());
                }
            }
        }
        else{ //No listeni :)
            if(command.getName().equalsIgnoreCase("botigers")){
            }
        }

        return false;
    }


}
