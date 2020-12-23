package business;

import java.util.LinkedList;
import java.util.List;

public class Album {

    private String title;
    private String artist;
    private int duration;
    private String releaseDate;
    private String id;
    private LinkedList<Song> songs;

    public Album(String title, String artist, int duration, String releaseDate, String id, LinkedList<Song> songs) {
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

    public LinkedList<Song> getSongs() {
        return this.songs;
    }

    public String toString(){
        String str;
        str = "Album " + this.title + "\nBy " + this.artist + "\nDuration " + this.duration + "\nReleased " + this.releaseDate + "\nSongs : ";
        for (int i=0; i < this.songs.size(); i++) {
            str += "\n      " + this.songs.get(i).getTitle() + " : " + this.songs.get(i).getDuration();
        }
        return str;
    }

    public void addSong(){

    }



}
