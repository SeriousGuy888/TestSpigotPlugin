package me.seriousguy888.testspigotplugin;

import me.seriousguy888.testspigotplugin.events.OnDeath;
import me.seriousguy888.testspigotplugin.commands.Feed;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;

public final class TestSpigotPlugin extends JavaPlugin implements Listener{
    public static final String PREFIX = "[SeriousGuy888's TestSpigotPlugin] ";

    @Override
    public void onEnable() { //ON PLUGIN STARTUP
        System.out.println(PREFIX + "Initiating plugin...");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new OnDeath(), this);

        getCommand("feed").setExecutor(new Feed());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("news")) {
            Player player = (Player) sender;
            player.sendMessage("§3" + getConfig().getString("News"));
        }
        if(command.getName().equals("setnews")) {
            if(sender.hasPermission("cheeztest.setnews")) {
                getConfig().set("News", "quacccccccck");
            }
            else {
                sender.sendMessage("§cYou do not have the required permission to use this command.\n§cIf you believe this to be a mistake, contact a server administrator and ask for the permission node \"cheeztest.setnews\".");
            }
        }
        return false;
    }

    @Override
    public void onDisable() { //ON PLUGIN SHUTDOWN
        System.out.println(PREFIX + "Shutting down...");
    }
}
