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

        // NodeList albums = reader.parseXMLFile("files/albums.xml");
        LinkedList<Album> albumList = reader.loadAlbumsXML("files/albums.xml");
        System.out.println("\nAlbum list loaded");

        // NodeList playlists = reader.parseXMLFile("files/playlists.xml");
        LinkedList<Playlist> playlistList = reader.loadPlaylistsXML("files/playlists.xml");
        System.out.println("\nPlaylist list loaded");

        // NodeList elements = reader.parseXMLFile("files/elements.xml");
        LinkedList<Audio> elementList = reader.loadElementsXML("files/elements.xml");
        System.out.println("\nElement list loaded");


















        LinkedList<Chanson> chansonList = new LinkedList<Chanson>();
        Chanson chanson1 = new Chanson("Daisy", "Ashnikko", 160, "id1", "chemin1", Genre.JAZZ);
        Chanson chanson2 = new Chanson("Cry", "Ashnikko", 160, "id2", "chemin2", Genre.POP);
        chansonList.add(chanson1);
        chansonList.add(chanson2);
        LinkedList<Album> albumList = new LinkedList<Album>();
        Album album1 = new Album("Yes", "Ashnikko", 160*2, "10-12-2020", "id3", chansonList);
        System.out.println(album1);
        LinkedList<Audio> chansonList = new LinkedList<Audio>();

    }
}
