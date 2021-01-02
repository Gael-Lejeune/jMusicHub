package main;

import business.*;
import util.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;

/** JMusicHub Class is the main class of the JMusicHub program.
 *
 *
 * Version : 1.0
 *
 * Date : 30/02/2001
 *
 * @author Gaël Lejeune and Steve Chevreau-Manat
 */
public class JMusicHub{

    /**
      * XML editor allowing to read and write XML files
      * @see XMLReaderWriter
      */
    private XMLReaderWriter xmlEditor;

    /**
     * List of the registered playlists
     * @see Playlist
     */
    private LinkedList<Playlist> playlists;

    /**
     * List of the registered albums
     * @see Album
     */
    private LinkedList<Album> albums;

    /**
     * List of the registered audio elements
     * @see Audio
     */
    private LinkedList<Audio> elements;

    /**
     * Album constructor
     * Initialize all the attributes and fill the lists by reading the XML files
     *
     * @author Gaël Lejeune
     */
    public JMusicHub() {
        this.xmlEditor = new XMLReaderWriter();
        /* Load of all the XML files */
        try {
            this.playlists = this.xmlEditor.readPlaylistXML("files/playlists.xml");
            this.albums = this.xmlEditor.readAlbumXML("files/albums.xml");
            this.elements = this.xmlEditor.readElementXML("files/elements.xml");
        } catch (MissingFileException ex) {
            System.out.println(ex.getMessage());
        }
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
     * Displays all the registered playlists
     * @see         Playlist
     * @author      Gaël Lejeune
     */
    public void displayPlaylists() {
        System.out.println("Existing playlists :\n");
        for (int i = 0; i < this.playlists.size(); i++) {
            System.out.println(this.playlists.get(i) + "\n");
        }
    }

    /**
     * Asks and displays an specific registered playlist
     * @see         Playlist
     * @author      Gaël Lejeune
     */
    public void displaySpecificPlaylist() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Name of the playlist :");
        boolean found = false;
        String name = scanner.nextLine();
        for (int i = 0; i < this.playlists.size(); i++) {
            if (this.playlists.get(i).getName().equals(name)) {
                System.out.println(this.playlists.get(i) + "\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No playlist found.");
        }
    }

    /**
     * Displays all the registered albums
     * @see         Album
     * @author      Gaël Lejeune
     */
    public void displayAlbums() {
        System.out.println("\n\n\nExisting albums :\n");
        for (int i = 0; i < this.albums.size(); i++) {
            System.out.println(this.albums.get(i) + "\n");
        }
    }

    /**
     * Asks and displays an specific registered album
     * @see         Album
     * @author      Gaël Lejeune
     */
    public void displaySpecificAlbum() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Name of the album to display :");
        boolean found = false;
        String title = scanner.nextLine();  /* Album title entered by the user */
        for (int i = 0; i < this.albums.size(); i++) {
            if (this.albums.get(i).getTitle().equals(title)) {
                System.out.println(this.albums.get(i) + "\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No album found.");
        }
    }


    /**
     * Displays all the registered audio elements
     * @see         Album
     * @author      Gaël Lejeune
     */
    public void displayElements() {
        System.out.println("\n\n\nExisting elements :\n");
        for (int i = 0; i < this.elements.size(); i++) {
            System.out.println(this.elements.get(i) + "\n");
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
     * Asks and add an existing song to a chosen album
     * @see         Album
     * @see         Song
     * @author      Gaël Lejeune
     */
    public void addSongToAlbum() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter the name of an album :");
        boolean found = false;
        String title = scanner.nextLine();
        int albumIndex = 0;
        for (int i = 0; i < this.albums.size(); i++) {
            if (this.albums.get(i).getTitle().equals(title)) {
                albumIndex = i;
                found = true;
            }
        }
        if (found) {
            System.out.println("Enter the name of the songs you wish to add or press enter to finish : ");
            String songname = "1";
            while (!songname.equals("")) {
                songname = scanner.nextLine();
                boolean songFound = false;
                for (int i = 0; i < this.elements.size(); i++) {
                    if (this.elements.get(i).getTitle().equals(songname)) {
                        this.albums.get(albumIndex).addSong((Song)this.elements.get(i));
                        System.out.println("Added song : " + this.elements.get(i));
                        songFound = true;
                    }
                }
                if (!songFound) {
                    System.out.println("No song found.");
                }
            }
        } else {
            System.out.println("No album found.");
        }
    }

    /**
     * Asks and add an existing audio to a chosen playlist
     * @see         Playlist
     * @see         Audio
     * @author      Gaël Lejeune
     */
    public void addSongToPlaylist() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter the name of a playlist :");
        boolean found = false;
        String name = scanner.nextLine();
        int playlistIndex = 0;
        for (int i = 0; i < this.playlists.size(); i++) {
            if (this.playlists.get(i).getName().equals(name)) {
                playlistIndex = i;
                found = true;
            }
        }
        if (found) {
            System.out.println("Enter the name of the songs you wish to add or press enter to finish : ");
            String songname = "1";
            while (!songname.equals("")) {
                songname = scanner.nextLine();
                boolean songFound = false;
                for (int i = 0; i < this.elements.size(); i++) {
                    if (this.elements.get(i).getTitle().equals(songname)) {
                        this.playlists.get(playlistIndex).addSong((Song)this.elements.get(i));
                        System.out.println("Added song : " + this.elements.get(i));
                        songFound = true;
                    }
                }
                if (!songFound) {
                    System.out.println("No song found.");
                }
            }
        } else {
            System.out.println("No playlist found.");
        }
    }

    /**
     * Asks the informations and the audios to create and register a playlist
     * @see         Playlist
     * @author      Gaël Lejeune
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
        if (audios.size() == 0) {
            System.out.println("Empty playlist, abort creation.");
            return;
        }
        this.playlists.add(new Playlist(name, uuid, audios));
    }

    /**
     * Asks and delete the chosen playlist
     * @see         Playlist
     * @author      Gaël Lejeune
     */
    public void deletePlaylist() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Name of the playlist to delete :");
        String name = scanner.nextLine();
        for (int i = 0; i < this.playlists.size(); i++) {
            if (this.playlists.get(i).getName().equals(name)) {
                this.playlists.remove(i);
            }
        }
    }

    /**
     * Create XML files containing the registered playlists, elements, and albums using the class XML editor
     * @see         XMLReaderWriter
     * @author      Gaël Lejeune
     */
    public void save() {
        this.xmlEditor.writeElementXML("files/elements1.xml", this.elements);
        this.xmlEditor.writeAlbumXML("files/albums1.xml", this.albums);
        this.xmlEditor.writePlaylistXML("files/playlists1.xml", this.playlists);
    }

    /**
     *  Description de la methode
     */
    public void help() {

    }

    /**
     * Execution of the JMusicHub program and interaction with the user using a terminal
     * @param       args Arguments of the function
     * @author Gaël Lejeune and Steve Chevreau-Manat
     */
    public static void main(String[] args) {
        System.out.println("\n\nWelcome in JMusicHub,");
        System.out.println("Reading library...\n\n");
        JMusicHub jmusichub = new JMusicHub();

        jmusichub.displayPlaylists();
        jmusichub.addSongToPlaylist();
        jmusichub.displayPlaylists();

        jmusichub.save();
    }
}
