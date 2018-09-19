package com.company;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    static final String removeChar = ".?/,';:!@#$%^&*~`";

    public static void main(String[] args) {
        System.out.println("Please enter ur URL");
        Scanner s = new Scanner(System.in);
        String url = s.nextLine();
        String webPageStr = urlToString(url);
        System.out.println(webPageStr);

        System.out.println("What do you want to search?");
        String searchKeyWord = s.nextLine();
        System.out.println("Do you want case sensitive? Y/N");
        boolean flag = true;
        boolean userRespond = false;

        String[] webPageTtoStrArray = webPageStr.split(" ");
        //webPageTtoStrArray = cleanUp(webPageTtoStrArray);
        int stringCount = 0;
        for(String c : webPageTtoStrArray){
            if(!userRespond) {
                if (c.toLowerCase().contains(searchKeyWord.toLowerCase())) {
                    stringCount++;
                }
            } else {
                if(c.contains(searchKeyWord)){
                    stringCount++;
                }
            }
        }
        System.out.println("'" + searchKeyWord + "'" + " appeared " + stringCount + " times");

    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static String[] cleanUp(final String[] input) {
        String[] result = input;
        for (int k = 0; k < result.length; k++) {
           char[] currentStringToArray = result[k].toCharArray();
           for (int i = 0; i < currentStringToArray.length; i++) {
               if(removeChar.contains(String.valueOf(currentStringToArray[i]))){
                   currentStringToArray[i] = ' ';
               }
               result[k] = String.valueOf(currentStringToArray[i]);
           }
        }
        return result;
    }
}
