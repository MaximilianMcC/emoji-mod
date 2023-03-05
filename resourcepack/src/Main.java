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
            //TODO: change 1 - emojiList.size()
            for (int i = 25; i < 35; i++) {

                //TODO: Make a progress bar, and get remaining time
                System.out.print("\rGetting emoji with index of " + i);

                // Get the link to the current emoji, then scrape it
                String currentEmojiLink = emojiList.get(i).selectFirst("td a").attr("href");
                Document currentEmojiPage = Jsoup.connect("https://www.emojibase.com" + currentEmojiLink).get();

                // Get the shortcode
                String shortcode = currentEmojiPage.selectFirst("table tbody tr td:nth-child(6)").text();

                // Get the image url
                Elements images = currentEmojiPage.select("div.panel img");
                String imageUrl = "";
                if (emojiStyle == 1) imageUrl += images.get(3).attr("src"); // Twemoji
                else if (emojiStyle == 2) imageUrl += images.get(2).attr("src"); // Apple

                // Save the emoji in the emojis list
                Emoji emoji = new Emoji(shortcode, imageUrl);
                emojis.add(emoji);
            }


        } catch (IOException e) {
            System.out.println("\nError whilst getting emojis:");
            e.printStackTrace();
        }
    
        // Loop through all emojis
        for (Emoji emoji : emojis) {
            if (emoji.shortcode.equals("::")) //TODO: Remove the emojis from list
        }
    }

}
