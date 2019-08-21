package me.seriousguy888.testspigotplugin.commands;

import me.seriousguy888.testspigotplugin.TestSpigotPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Feed implements CommandExecutor {
    Plugin plugin = TestSpigotPlugin.getPlugin(TestSpigotPlugin.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("cheeztest.feed")) {
                player.setFoodLevel(20);
                player.setSaturation(20);

                player.sendMessage("§aYou have been granted max hunger and saturation!");
            }
            else {
                player.sendMessage("§cYou do not have the required permissions!\n§cIf you believe this to be an error, contact a server administrator and ask for the permission node \"cheeztest.feed\".");
            }
        }
        else {
            System.out.println("§cOnly a player may execute this command.");
        }

        return false;
    }
}
