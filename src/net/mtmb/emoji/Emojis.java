package net.mtmb.emoji;

import java.util.HashMap;
import java.util.Map;

public class Emojis {
    
    // Get all the emojis
    public static String[][] emojiNames = {
        {":flushed:", ":flu"},
        {":skull:", ":sku"},
        {":sob:", ":sob"},
        {":nerd:", ":ner"},
        {":joy:", ":joy"}
    };

    // Add all the emojis
    public static Map<String, String[]> emojis = new HashMap<String, String[]>();
    public static Map<String, String[]> GetEmojis() {

        // Give them all a unicode character
        //TODO: Put all this in some external file
        emojis.put("\uE000", emojiNames[0]);
        emojis.put("\uE001", emojiNames[1]);
        emojis.put("\uE002", emojiNames[2]);
        emojis.put("\uE003", emojiNames[3]);
        emojis.put("\uE004", emojiNames[4]);
        
        return emojis;
    }
}
