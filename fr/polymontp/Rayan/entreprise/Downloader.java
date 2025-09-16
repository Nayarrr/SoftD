package fr.polymontp.Rayan.entreprise;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;


public class Downloader{
    public static String[] urls;

    public static void getURl(String file) throws IOException{
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            List<String> urlList = new ArrayList<>();
            String url;

            while((url = br.readLine()) != null){
                urlList.add(url);
            }
            Downloader.urls = urlList.toArray(new String[0]);
            br.close();
        }
        catch(Exception e){
            System.out.println("toi etre caca ");
        }
        
    }

    public static void downloadFromURL(String urlString) throws IOException{
        
        //get extension
        //create directory
        //get fileName
        //Open stream on the filename
        //get url 
        //open stream on url
        //read one char from the inputStream
        //Write one char in the InputStream

        String extension = urlString.substring(urlString.lastIndexOf("."));
        String directoryName = "downloads" + extension;
        File directory = new File(directoryName);
        if (!directory.exists()){
            directory.mkdir();
        }
        String fileName = urlString.substring(urlString.lastIndexOf("/") +1);
        InputStream inputStream = new URL(urlString).openStream();
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(directoryName + "/" + fileName));
        int data = inputStream.read();
        while(data != -1){
            outputStream.write(data);
            data = inputStream.read();

        }
        outputStream.close();
        inputStream.close();    
    }

    public static void main(String args[]){
        try{
            getURl("Bookmarks.txt");
        }
        catch(Exception e){
            System.err.println("Toi caca lala");
        }
        for (String url : urls){
            try{
                downloadFromURL(url);
            }
            catch(Exception e){
                System.err.println("Toi caca lalalolo");
                System.err.println(url);
            }
        }
    }



}