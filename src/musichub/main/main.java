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
        // System.out.println("Welcome in jMusicHub,");
        // System.out.println("Reading library...");
        //
        // XMLReaderWriter reader = new XMLReaderWriter();
        //
        // NodeList albums = reader.parseXMLFile("files/albums.xml");
        // System.out.println(albums);
        // reader.readAlbumsXML("files/albums.xml");
        //
        // NodeList playlists = reader.parseXMLFile("files/playlists.xml");
        // System.out.println(playlists);
        // reader.readPlaylistsXML("files/playlists.xml");

        MusicPlayer player = new MusicPlayer();
        player.play("files/test.mp3");

    }
}
