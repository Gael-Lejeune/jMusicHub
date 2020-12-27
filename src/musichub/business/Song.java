package business;

import java.util.UUID;

/*
 * Nom de classe : Song
 *
 * Description   :
 *
 * Version       : 1.6
 *
 * Date          : 26/12/2020
 *
 * Copyright     : Lejeune Gaël
 */

 /**
  * description de la classe.
  * explication supplémentaire si nécessaire
  *
  * @version 1.0
  *
  * @see UneAutreClasse
  * @author Jean Michel D.
  */
public class Song extends Audio
{
    private Genre genre;
	protected String artist;

    /**
     *  Description de la methode
     */
    public Song(String title, String artist, int duration, UUID id, String content, Genre genre)
    {
    	this.title = title;
    	this.artist = artist;
    	this.duration = duration;
    	this.id = id;
    	this.content = content;
    	this.genre = genre;
    }

    /**
     *  Description de la methode
     */
    public Genre getGenre()
    {
    	return this.genre;
    }

    /**
     *  Description de la methode
     */
    public String getArtist()
    {
    	return this.artist;
    }

    /**
     *  Description de la methode
     */
    public String toString() {
        return this.title + " by " + this.artist
        + "\nDuration : " + this.duration
        + "\nGenre : " + this.genre;
    }
}
