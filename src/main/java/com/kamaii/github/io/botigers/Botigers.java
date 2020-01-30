package com.kamaii.github.io.botigers;

import com.sun.media.jfxmedia.logging.Logger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.Threading;
public final class Botigers extends JavaPlugin  implements Listener {
    public sqlHandler sqlMan;
    public configHandler cfg;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Starting Botiger...");
        getLogger().info("Loading config from botigers.yml...");
        cfg = new configHandler();
        getLogger().info("Starting up sqlite handler.");
        sqlMan = new sqlHandler(cfg.getSQLDatabase());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Stopping Botiger...");
        getLogger().info("Saving botigers to disk..");
    }

    @EventHandler
    public void onPlayerJoin(){
        getLogger().info("Attempting to load " + playerName + "'s botiger(s)...");
        /*We want to do an a* here on a new thread. The search task should be
          be able to be stopped at any time. It should also init with a random
          cooldown before even beggining, as to avoid malicious lagging of the
          server. In the event a player leaves before the cooldown period, we want
          to cancel the search.
         */
       // sqlMan.search(Player); <--returns List<botiger> datatype see sqlHandler.

        if(searchAbort){
            getLogger().info( playerName + " left too fast! aborting...");
        }
    }
}
