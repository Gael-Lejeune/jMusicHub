package main;
import business.*;
import util.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;

import org.w3c.dom.*;
import java.io.IOException;
import java.io.File;
import java.util.UUID;

public class Main{
    public static void main(String[] args) {
        System.out.println("Welcome in jMusicHub,");
        System.out.println("Reading library...");

        XMLReaderWriter reader = new XMLReaderWriter();

        NodeList albums = reader.parseXMLFile("files/albums.xml");
        System.out.println("Album list loaded");
        System.out.println(albums);
        reader.readAlbumsXML("files/albums.xml");


        NodeList elements = reader.parseXMLFile("files/elements.xml");
        System.out.println("Element list loaded");
        System.out.println(elements);
        reader.readElementsXML("files/elements.xml");

        NodeList playlists = reader.parseXMLFile("files/playlists.xml");
        System.out.println("Playlist list loaded");
        System.out.println(playlists);
        reader.readPlaylistsXML("files/playlists.xml");














        // try {
        //     AudioPlayer audioPlayer = new AudioPlayer();
        //
        //     audioPlayer.play();
        //     Scanner sc = new Scanner(System.in);
        //
        //     while (true)
        //     {
        //         System.out.println("1. pause");
        //         System.out.println("2. resume");
        //         System.out.println("3. restart");
        //         System.out.println("4. stop");
        //         System.out.println("5. Jump to specific time");
        //         int c = sc.nextInt();
        //         audioPlayer.gotoChoice(c);
        //         if (c == 4)
        //         break;
        //     }
        //     sc.close();
        // }
        //
        // catch (Exception ex)
        // {
        //     System.out.println("Error with playing sound.");
        //     ex.printStackTrace();
        //
        //   }
    }
}
