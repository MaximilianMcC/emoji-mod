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
        {":joy:", ":joy"},
        {":triumph:", ":tri"},
        {":pensive:", ":pe"},
        {":joy_cat:", ":joyc"},
        {":exploding:", ":exp"},
        {":nauseated:", ":nau"},
        {":yawn:", ":yaw"}
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
        emojis.put("\uE005", emojiNames[5]);
        emojis.put("\uE006", emojiNames[6]);
        emojis.put("\uE007", emojiNames[7]);
        emojis.put("\uE008", emojiNames[8]);
        emojis.put("\uE009", emojiNames[9]);
        emojis.put("\uE010", emojiNames[10]);
        
        return emojis;
    }
}
