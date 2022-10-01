package net.mtmb.emoji.events;

import java.util.Map;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.mtmb.emoji.Emojis;

public class PlayerChatEvent implements Listener {
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		
		// Get the player and the message
		String message = event.getMessage();

        // Get the emojis
        Map<String, String[]> emojis = Emojis.GetEmojis();

        // Find all emojis and replace with the emoji character
        for (Map.Entry<String, String[]> emoji : emojis.entrySet()) {
            
            String character = emoji.getKey();
            for (String emojiName : emoji.getValue()) {
                message = message.replace(emojiName, character);
            }
        }

		// Change the message then send it
		event.setMessage(message);
	}

}
