package business;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


public class Album {

    private String title;
    private String artist;
    private int duration;
    private String releaseDate;
    private UUID id;
    private LinkedList<Song> songs;

    public Album(String title, String artist, int duration, String releaseDate, UUID id, LinkedList<Song> songs) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.id = id;
        this.songs = songs;
    }

    public String getTitle(){
        return this.title;
    }

    public String getArtist(){
        return this.artist;
    }

    public String getReleaseDate(){
        return this.releaseDate;
    }

    public LinkedList<Song> getSongs() {
        return this.songs;
    }

    public int getDuration() {
        return this.duration;
    }

    public String toString(){
        String str;
        str = "Album " + this.title + "\nBy " + this.artist + "\nDuration " + this.duration + "\nReleased " + this.releaseDate + "\nSongs : ";
        for (int i=0; i < this.songs.size(); i++) {
            str += "\n" + this.songs.get(i);
        }
        return str;
    }

    public void addSong(){

    }



}
