package net.maxtheminerboy.emoji.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EmojiCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        // Check for if they are trying to do the emoji command
        if (!cmd.getName().equalsIgnoreCase("emoji")) return false;
        

        // Send a message explaining the emoji plugin
        sender.sendMessage(ChatColor.GREEN + "---------------- EMOJI ----------------");
        sender.sendMessage(ChatColor.GRAY + "This plugin allows you to send emojis.");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.GRAY + "To send a message, just type the emoji name");
        sender.sendMessage(ChatColor.GRAY + "in between two colons.");
        sender.sendMessage("");
        sender.sendMessage(ChatColor.GRAY + "For example, if you wanted to use the");
        sender.sendMessage(ChatColor.GRAY + "skull emoji, you would type" + ChatColor.AQUA + ":skull:" + ChatColor.GRAY + "in chat.");
        sender.sendMessage(ChatColor.GREEN + "---------------------------------------");
        sender.sendMessage(ChatColor.GRAY + "You can use the " + ChatColor.YELLOW + "/emoji" + ChatColor.AQUA + " list " + ChatColor.GRAY + "command to");
        sender.sendMessage(ChatColor.GRAY + "view a list of all emojis. Please note you need");
        sender.sendMessage(ChatColor.GRAY + "to have the emoji resource pack on to view emojis.");
        sender.sendMessage(ChatColor.GREEN + "---------------------------------------");


        
        // Return after the command executes
        return true;
    }

}
