package net.mtmb.emoji.commands;

import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.mtmb.emoji.Emojis;

public class EmojiCommand implements CommandExecutor {
	
	// Emoji command
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("emoji")) {

			// Get the player
			Player player = (Player)sender;

			// Check for args
			if (args.length == 0) {

				// Plugin info
				player.sendMessage(ChatColor.AQUA + "-- Emoji ---------------------");
				player.sendMessage("This plugin allows you to send emoji in the Minecraft chat. You can view all of the different emojis by using the \"" + ChatColor.GRAY + "/emoji " + ChatColor.AQUA + "list" + ChatColor.RESET + "\" command.");
				player.sendMessage(ChatColor.AQUA + "-----------------------------");
				
			}
			else if (args[0].equalsIgnoreCase("list")) {

				// Get the emojis
				Map<String, String[]> emojis = Emojis.GetEmojis();
				
				// Show a list of all emojis
				player.sendMessage(ChatColor.AQUA + "-- Emoji List ----------------");
				for (Map.Entry<String, String[]> currentEmoji : emojis.entrySet()) {

					String emojiList = "";
					for (String emoji : currentEmoji.getValue()) {
						emojiList += " " + emoji;
					}

					// Send the emoji list
					player.sendMessage(currentEmoji.getKey() + " >" + ChatColor.GRAY + emojiList);
				}
				player.sendMessage(ChatColor.AQUA + "-----------------------------");
	
				return true;
			}


		}

		// If the command didn't work
		return false;
	}

}
