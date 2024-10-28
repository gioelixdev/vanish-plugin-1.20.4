package com.tumamaila.vanishPlugin.commands;

import com.tumamaila.vanishPlugin.VanishPlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {


    VanishPlugin plugin;

    public VanishCommand(VanishPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] strings) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (plugin.invisible_list.contains(player)) {
                for (Player people : Bukkit.getOnlinePlayers()) {
                    people.showPlayer(plugin, player);
                }
               plugin.invisible_list.remove(player);
               player.sendMessage("Adesso ti vedono tutti");
            }else if (!plugin.invisible_list.contains(player)) {
                for (Player people : Bukkit.getOnlinePlayers()) {
                    people.hidePlayer(plugin, player);
                }
                plugin.invisible_list.add(player);
                player.sendMessage("Adesso un ti vede nessuno");
            }

        }



        return true;
    }
}
