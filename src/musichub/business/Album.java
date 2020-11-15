package business;

import java.util.LinkedList;
import java.util.List;

public class Album extends Audio
{
    private int realeaseDate;
    private ListedList<Chanson> music = new LinkedList<Chanson>();

    public Album(int realeaseDate, ListedList<Chanson> music)
    {
    	this.realeaseDate = realeaseDate;
    	this.music = music;
    }

    public int getRealeaseDate()
    { //Retourne la date de sortie
    	return this.realeaseDate;
    }
    public ListedList<Chanson> getMusicList()
    {
    	return this.music;
    }
}
