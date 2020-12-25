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
        this.xmlEditor = new XMLReaderWriter();
        this.playlists = this.xmlEditor.readPlaylistXML("files/playlists.xml");
        this.albums = this.xmlEditor.readAlbumXML("files/albums.xml");
        this.elements = this.xmlEditor.readElementXML("files/elements.xml");
    }

    public void displayAlbumByReleaseDate(){

    }

    public void displaySongByGenre(){

    }

    public void displayPlaylists(){
        System.out.println("Existing playlists :\n");
        for (int i = 0; i < playlists.size() ; i++) {
            System.out.println(playlists.get(i) + "\n");
        }
    }

    public void displayAlbums(){
        System.out.println("\n\n\nExisting albums :\n");
        for (int i = 0; i < albums.size() ; i++) {
            System.out.println(albums.get(i) + "\n");
        }
    }

    public void displayElements(){
        System.out.println("\n\n\nExisting elements :\n");
        for (int i = 0; i < elements.size() ; i++) {
            System.out.println(elements.get(i) + "\n");
        }
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

    public void deletePlaylist(String name){
        for (int i = 0; i < this.playlists.size(); i++) {
            if (this.playlists.get(i).getName().equals(name)) {
                
            }
        }
    }

    public void save(){
        this.xmlEditor.writeElementXML("files/elements1.xml", elements);
        this.xmlEditor.writeAlbumXML("files/albums1.xml", albums);
        this.xmlEditor.writePlaylistXML("files/playlists1.xml", playlists);
    }

    public void help(){

    }

    public static void main(String[] args) {
        System.out.println("\n\nWelcome in jMusicHub,");
        System.out.println("Reading library...\n\n");
        jMusicHub jmusichub = new jMusicHub();

        jmusichub.displayPlaylists();
        jmusichub.displayAlbums();
        jmusichub.displayElements();

        jmusichub.save();
    }
}
