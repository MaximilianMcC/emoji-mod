package resourcepack.src;

public class Emoji {
    
    public String shortcode;
    public String imageUrl;
    public String hex;
    public String filename;

    // Emoji constructor
    public Emoji(String shortcode, String hex, String url) {

        // Assign all variables
        this.shortcode = shortcode;
        this.imageUrl = "https://www.emojibase.com" + url;
        this.hex = hex.replace("U+", "");
        this.filename = shortcode.replaceAll(":", "");
    }

}