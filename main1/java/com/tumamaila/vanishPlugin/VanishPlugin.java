package com.tumamaila.vanishPlugin;

import com.tumamaila.vanishPlugin.commands.VanishCommand;
import com.tumamaila.vanishPlugin.events.joinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class VanishPlugin extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic


        getCommand("vanish").setExecutor(new VanishCommand(this));

        getServer().getPluginManager().registerEvents(new joinEvent(this), this);
    }

}
