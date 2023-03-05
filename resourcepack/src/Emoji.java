package resourcepack.src;

public class Emoji {
    
    public String shortcode;
    public String imageUrl;

    // Emoji constructor
    public Emoji(String shortcode, String url) {

        // Assign all variables
        this.shortcode = shortcode;
        this.imageUrl = "https://www.emojibase.com" + url;
    }

}