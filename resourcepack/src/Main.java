package resourcepack.src;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {
    
    public static void main(String[] args) {

        System.out.println("Emoji resourcepack generator\n");

        // Ask for what emoji style they want
        System.out.println("Please choose an emoji style:");
        System.out.println("1)\tTwemoji/Discord");
        System.out.println("2)\tApple");
        
        Scanner scanner = new Scanner(System.in);
        int emojiStyleInput = scanner.nextInt();
        scanner.close();

        // Set the emoji style (default is twemoji)
        EmojiStyle emojiStyle = EmojiStyle.TWEMOJI;
        if (emojiStyleInput == 2) emojiStyle = EmojiStyle.APPLE;



        // Get the list of emojis, their shortcode, and the url to the image
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
                //TODO: Use multi-threadding to spead up the process.
                System.out.print("\rGetting emoji with index of " + i);

                // Get the link to the current emoji, then scrape it
                String currentEmojiLink = emojiList.get(i).selectFirst("td a").attr("href");
                Document currentEmojiPage = Jsoup.connect("https://www.emojibase.com" + currentEmojiLink).get();

                // Get the shortcode
                String shortcode = currentEmojiPage.selectFirst("table tbody tr td:nth-child(6)").text();
                if (shortcode.equals("::")) continue;

                // Get the hex code
                String hexCode = currentEmojiPage.selectFirst("table tbody tr td:nth-child(2)").text().replace("U+", "");

                // Get the image url
                Elements images = currentEmojiPage.select("div.panel img");
                String imageUrl = "";
                if (emojiStyle == EmojiStyle.TWEMOJI) imageUrl += images.get(3).attr("src"); // Twemoji
                else if (emojiStyle == EmojiStyle.APPLE) imageUrl += images.get(2).attr("src"); // Apple

                // Save the emoji in the emojis list
                Emoji emoji = new Emoji(shortcode, hexCode, imageUrl);
                emojis.add(emoji);
            }


        } catch (IOException e) {
            System.out.println("\nError whilst getting emojis:");
            e.printStackTrace();
        }


        // Make the resourcepack root directory
        String resourcePackFolder = "./Emojis";
        if (emojiStyle == EmojiStyle.TWEMOJI) resourcePackFolder += " (Twemoji)";
        else if (emojiStyle == EmojiStyle.APPLE) resourcePackFolder += " (Apple)";
        File resourcePackRoot = new File(resourcePackFolder);
        resourcePackRoot.mkdir();

        // Make the mcmeta file
        try {
            File mcmetaFile = new File(resourcePackRoot, "pack.mcmeta");
            mcmetaFile.createNewFile();
            FileWriter fileWriter = new FileWriter(mcmetaFile);
            fileWriter.write("{ \"pack\": { \"pack_format\": 9, \"description\": \"Emojis for Minecraft\" } }");
            fileWriter.close();

        } catch (Exception e) {
            System.err.println("\nError while making mcmeta file:");
            e.printStackTrace();
        }

        // Make the assets and minecraft directories
        File minecraftFolder = new File(resourcePackRoot, "/assets/minecraft");
        minecraftFolder.mkdirs();

        // Make the font folder, and json file inside
        File fontFolder = new File(minecraftFolder, "font");
        fontFolder.mkdir();
        try {
            File mcmetaFile = new File(resourcePackRoot, "default.json");
            mcmetaFile.createNewFile();
            FileWriter fileWriter = new FileWriter(mcmetaFile);

            //TODO: Get a json library to make this easier
            // Add the start of the json file
            fileWriter.write("{ \"providers\": [");

            // Add all of the emojis
            for (Emoji emoji : emojis) {
                
                // fileWriter.write();

            }

            // Add the end of the json file
            fileWriter.write("]}");

            fileWriter.close();

        } catch (Exception e) {
            System.err.println("\nError while making default fonts file:");
            e.printStackTrace();
        }


    }

}
