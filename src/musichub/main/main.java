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
import java.util.LinkedList;




public class Main{
    public void displayAlbumByReleaseDate(){

    }

    public void displayAlbumByGenre(){

    }

    public void displayPlaylists(){

    }

    public void displayAudioBooks(){

    }

    public void addSong(){

    }

    public void addAudioBook(){

    }

    public void addAlbum(){

    }

    public void addSongToAlbum(){

    }

    public void createPlaylist(){

    }

    public void deletePlaylist(){

    }

    public void save(){

    }

    public void help(){

    }

    public static void main(String[] args) {
        System.out.println("Welcome in jMusicHub,");
        System.out.println("Reading library...");
        XMLReaderWriter reader = new XMLReaderWriter();

        // // NodeList albums = reader.parseXMLFile("files/albums.xml");
        // LinkedList<Album> albumList = reader.loadAlbumsXML("files/albums.xml");
        // System.out.println("\nAlbum list loaded");
        //
        // // NodeList playlists = reader.parseXMLFile("files/playlists.xml");
        // LinkedList<Playlist> playlistList = reader.loadPlaylistsXML("files/playlists.xml");
        // System.out.println("\nPlaylist list loaded");
        //
        // // NodeList elements = reader.parseXMLFile("files/elements.xml");
        // LinkedList<Audio> elementList = reader.loadElementsXML("files/elements.xml");
        // System.out.println("\nElement list loaded");
        //



        try {
            LinkedList<Playlist> playlists = reader.readPlaylistXML("files/playlists.xml");
            System.out.println(playlists.get(0));
        } catch (Exception ex) {
            ex.printStackTrace();
        }






        // LinkedList<Song> songList = new LinkedList<Song>();
        // Song song1 = new Song("Daisy", "Ashnikko", 160, "id1", "chemin1", Genre.JAZZ);
        // Song song2 = new Song("Cry", "Ashnikko", 160, "id2", "chemin2", Genre.POP);
        // songList.add(song1);
        // songList.add(song2);
        // LinkedList<Album> albumList = new LinkedList<Album>();
        // Album album1 = new Album("Yes", "Ashnikko", 160*2, "10-12-2020", "id3", songList);
        // System.out.println(album1);

    }
}
