package resourcepack.src;

public class Emoji {
    
    String name;
    String shortcode;
    String hexCode;

    // Emoji constructor
    public Emoji(String name, String shortcode, String unicode) {

        // Assign all variables
        this.name = name;
        this.shortcode = shortcode;
        this.hexCode = unicode;
    }

}