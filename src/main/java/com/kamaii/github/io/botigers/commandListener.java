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
        return true;
    }

}
