package com.example;

import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class Main {
    // Detect Duplicate Graphic files on Cloudinary
    public static void main(String[] args) {
        String urlStr = "https://res.cloudinary.com/ascension-enterprises/image/upload/v1569270776/samples/Java%20Boot%20Camp/6fy5iab9_pxd3rp.bmp";
//        urlStr =
        boolean fileExists = false;
        fileExists = testForDupes(urlStr);
        if(fileExists){
            System.out.println("Web File Exists");
        } else {
            System.out.println("Web File Does NOT Exist");
        }
    }

    public static boolean testForDupes(String urlStr){
        try {final URL url = new URL(urlStr);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            int responseCode = huc.getResponseCode();
            System.out.println("Response Code: "+ responseCode);
            if (!(responseCode == 200)) {
                return false;
            }
            // Handle response code here...
        } catch (UnknownHostException uhe) {
            // Handle exceptions as necessary
            // log exception
            System.out.println(uhe.getMessage().toString());
            return false;
        } catch (FileNotFoundException fnfe) {
            // Handle exceptions as necessary
            System.out.println(fnfe.getMessage().toString());
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
            // Handle exceptions as necessary
            // log exception
            return false;
        }
        return true;
    }
}
