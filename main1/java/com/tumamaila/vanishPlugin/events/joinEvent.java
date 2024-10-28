package com.tumamaila.vanishPlugin.events;

import com.tumamaila.vanishPlugin.VanishPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class joinEvent implements Listener {

    VanishPlugin plugin;

    public joinEvent(VanishPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void Playerjoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        for(int i = 0; i < plugin.invisible_list.size(); i++) {
            player.hidePlayer(plugin, plugin.invisible_list.get(i));
        }
    }

}
