package net.mtmb.emoji;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import net.mtmb.emoji.commands.EmojiCommand;
import net.mtmb.emoji.events.PlayerChatEvent;

public final class Main extends JavaPlugin {

    // When the plugin turns on
    @Override
    public void onEnable() {

        // Enable listeners
        Bukkit.getPluginManager().registerEvents(new PlayerChatEvent(), this);

        // Enable commands
        this.getCommand("emoji").setExecutor(new EmojiCommand());

        // Say that the plugin is on
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE+"Emoji is "+ChatColor.GREEN+"enabled!");        
    }

    @Override
    public void onDisable() {
        // When the plugin turns off

        // Say that the plugin is off
        getServer().getConsoleSender().sendMessage(ChatColor.WHITE+"Emoji is "+ChatColor.RED+"disabled!");        
    }

}