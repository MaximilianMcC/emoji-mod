package resourcepack.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Emoji resourcepack generator\n");

        // Ask for what emoji style they want
        System.out.println("Please choose an emoji style:");
        System.out.println("1)\tTwemoji/Discord");
        System.out.println("2)\tApple");
        
        Scanner scanner = new Scanner(System.in);
        int emojiStyle = scanner.nextInt();
        scanner.close();



        // Get the list of emojis, and their shortcode
        System.out.println("Getting emojis\nThis could take a while.");
        ArrayList<Emoji> emojis = new ArrayList<Emoji>();

        try {

            // Get the website, so we can scrape it for emojis
            Document emojiWebsite = Jsoup.connect("https://www.emojibase.com/").get();

            // Get all of the emojis from the different categories
            Elements emojiList = emojiWebsite.select("table tbody tr");
            System.out.println("Total emojis found: " + emojiList.size());

            // Iterate over each emoji. Go to the page, then get the image, and shortcode.
            for (int i = 1; i < emojiList.size(); i++) {
                System.out.println("Getting emoji with index of " + i);

                // Get the link to the current emoji, then scrape it
                String currentEmojiLink = emojiList.get(i).select("td a").text();
                System.out.println(currentEmojiLink);
                Document currentEmojiPage = Jsoup.connect(currentEmojiLink).get();

                // Get the shortcode
                String shortcode = currentEmojiPage.select("table tbody tr td:nth-child(6)").text();
                System.out.println(shortcode);

                // Get the image

                


            }


        } catch (IOException e) {
            System.out.println("Error when getting shortcodes:");
            e.printStackTrace();
        }
    }

}
