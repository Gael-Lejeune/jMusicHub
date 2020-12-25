package main;

import business.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.UUID;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import util.*;




public class jMusicHub{

    private XMLReaderWriter xmlEditor;
    private LinkedList<Playlist> playlists;
    private LinkedList<Album> albums;
    private LinkedList<Audio> elements;


    public jMusicHub()
    {
        xmlEditor = new XMLReaderWriter();
        playlists = xmlEditor.readPlaylistXML("files/playlists.xml");
        albums = xmlEditor.readAlbumXML("files/albums.xml");
        elements = xmlEditor.readElementXML("files/elements.xml");
    }

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
        writeElementXML("files/elements1.xml", elements);
        writeAlbumXML("files/albums1.xml", albums);
        writePlaylistXML("files/playlists1.xml", playlists);
    }

    public void help(){

    }

    public static void main(String[] args) {

        jMusicHub jmusichub = new jMusicHub();
        System.out.println("\n\nWelcome in jMusicHub,");
        System.out.println("Reading library...\n\n");

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
            System.out.println("Existing playlists :\n");
            for (int i = 0; i < playlists.size() ; i++) {
                System.out.println(playlists.get(i) + "\n");
            }

            System.out.println("\n\n\nExisting albums :\n");
            for (int i = 0; i < albums.size() ; i++) {
                System.out.println(albums.get(i) + "\n");
            }
            System.out.println("\n\n\nExisting elements :\n");
            for (int i = 0; i < elements.size() ; i++) {
                System.out.println(elements.get(i) + "\n");
            }

            save();

        }
        catch (Exception ex) {
            System.out.println("erreur");
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
