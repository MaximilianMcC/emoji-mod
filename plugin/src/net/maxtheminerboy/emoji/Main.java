package net.maxtheminerboy.emoji;

import org.bukkit.plugin.java.JavaPlugin;

import net.maxtheminerboy.emoji.commands.EmojiCommand;

public class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {

        // Announce that the plugin is on
        getLogger().info("Emoji is enabled!");

        // Register all of the commands
        getCommand("emoji").setExecutor(new EmojiCommand());
    }

}
