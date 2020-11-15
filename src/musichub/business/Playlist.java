package business;

import java.util.LinkedList;
import java.util.List;

public class Playlist
{
	private String nom;
	private int id;
	private ListedList<Audio> music = new LinkedList<Audio>();
	private static int musicNumber = 0;

	public Playlist(String nom, int id, ListedList<Audio> music)
	{
		this.nom = nom;
		this.id = id;
		this.music = music;
	}

	public Boolean playPlaylist()
    { //Lecture de toutes les musiques de l'Album
    	this.music.get(this.musicNumber).play();
    	if(this.musicNumber<this.music.size())
    	{ //Si il n'y a plus de musique arrêté la lecture
    		musicNumber = 0;
    		return 0;
    	}
    	else if(this.music.get(this.musicNumber).musicEnd())
    	{ //Si
    		musicNumber += 1;
    		return 1;
    	}
    }
    public void nextMusic()
    { //Passer à la musique suivante
    	musicNumber += 1;
    }
    public void previousMusic()
    { //Revenir à la musique précédente
    	musicNumber -= 1;
    }
    public void addMusicToPlaylist()
    {

    }
    public void addAlbumToPlaylist()
    {

    }
}
