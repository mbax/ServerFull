package org.kitteh.serverfull;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerFull extends JavaPlugin implements Listener {

    private String message = null;
    
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.message = this.getConfig().getString("message");
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void playerJoin(PlayerLoginEvent event) {
        if(event.getResult()==Result.KICK_FULL){
            if(message!=null){
                event.setKickMessage(message);
            }
        }
    }
}