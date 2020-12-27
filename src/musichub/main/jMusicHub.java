package main;

import business.*;
import util.*;
import org.w3c.dom.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;

import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


/**
 * 
 * explication supplémentaire si nécessaire
 *
 * @version 1.0
 *
 * @see UneAutreClasse
 * @author Jean Michel D.
 */
public class jMusicHub{

    private XMLReaderWriter xmlEditor;
    private LinkedList<Playlist> playlists;
    private LinkedList<Album> albums;
    private LinkedList<Audio> elements;

    /**
    *  Description de la methode
    */
    public jMusicHub()
    {
        this.xmlEditor = new XMLReaderWriter();
        this.playlists = this.xmlEditor.readPlaylistXML("files/playlists.xml");
        this.albums = this.xmlEditor.readAlbumXML("files/albums.xml");
        this.elements = this.xmlEditor.readElementXML("files/elements.xml");
    }

    /**
    *  Description de la methode
    */
    public void displayAlbumByReleaseDate() {

    }

    /**
    *  Description de la methode
    */
    public void displaySongByGenre() {

    }

    /**
    *  Description de la methode
    */
    public void displayPlaylists() {
        System.out.println("Existing playlists :\n");
        for (int i = 0; i < playlists.size() ; i++) {
            System.out.println(playlists.get(i) + "\n");
        }
    }

    /**
    *  Description de la methode
    */
    public void displayAlbums() {
        System.out.println("\n\n\nExisting albums :\n");
        for (int i = 0; i < albums.size() ; i++) {
            System.out.println(albums.get(i) + "\n");
        }
    }

    /**
    *  Description de la methode
    */
    public void displayElements() {
        System.out.println("\n\n\nExisting elements :\n");
        for (int i = 0; i < elements.size() ; i++) {
            System.out.println(elements.get(i) + "\n");
        }
    }

    /**
    *  Description de la methode
    */
    public void displayAudioBooks() {

    }

    /**
    *  Description de la methode
    */
    public void addSong() {

    }

    /**
    *  Description de la methode
    */
    public void addAudioBook() {

    }

    /**
    *  Description de la methode
    */
    public void addAlbum() {

    }

    /**
    *  Description de la methode
    */
    public void addSongToAlbum() {

    }

    /**
    *  Description de la methode
    */
    public void createPlaylistFromExisting() {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Name of your new playlist :");
        String name = scanner.nextLine();

        System.out.println("Generating UUID");
        UUID uuid = UUID.randomUUID();

        LinkedList<Audio> audios = new LinkedList<Audio>();
        System.out.println("Enter the name of the songs you wish to add or press enter to finish : ");
        String songname = "1";
        while (!songname.equals("")) {
            songname = scanner.nextLine();
            boolean found = false;
            for (int i = 0; i < this.elements.size(); i++) {
                if (this.elements.get(i).getTitle().equals(songname)) {
                    audios.add(this.elements.get(i));
                    System.out.println("Added song : " + this.elements.get(i));
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No song found.");
            }
        }
        if (audios.size()==0) {
            System.out.println("Empty playlist, abort creation.");
            return;
        }
        this.playlists.add(new Playlist(name, uuid, audios));
    }

    /**
    *  Description de la methode
    */
    public void deletePlaylist(String name) {
        for (int i = 0; i < this.playlists.size(); i++) {
            if (this.playlists.get(i).getName().equals(name)) {
                this.playlists.remove(i);
            }
        }
    }

    /**
    *  Description de la methode
    */
    public void save() {
        this.xmlEditor.writeElementXML("files/elements1.xml", elements);
        this.xmlEditor.writeAlbumXML("files/albums1.xml", albums);
        this.xmlEditor.writePlaylistXML("files/playlists1.xml", playlists);
    }

    /**
    *  Description de la methode
    */
    public void help() {

    }

    /**
    *  Description de la methode
    */
    public static void main(String[] args) {
        System.out.println("\n\nWelcome in jMusicHub,");
        System.out.println("Reading library...\n\n");
        jMusicHub jmusichub = new jMusicHub();

        // jmusichub.displayPlaylists();
        // jmusichub.displayAlbums();
        // jmusichub.displayElements();
        // jmusichub.deletePlaylist("MaPlaylist3");
        jmusichub.displayElements();
        jmusichub.displayPlaylists();
        jmusichub.createPlaylistFromExisting();
        jmusichub.displayPlaylists();

        jmusichub.save();
    }
}
