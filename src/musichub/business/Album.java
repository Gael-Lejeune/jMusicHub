package business;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/*
 * Nom de classe : Album
 *
 * Description   : Classe contenant les informations d'un album fait de chansons
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
public class Album {
    private String title;
    private String artist;
    private int duration;
    private String releaseDate;
    private UUID id;
    private LinkedList<Song> songs;

    /**
     * description de la méthode.
     * explication supplémentaire si nécessaire
     *
     * @return      description de la valeur de retour
     * @param       arg1 description du 1er argument
     *    :           :         :
     * @param       argN description du Neme argument
     * @exception   Exception1  description de la première exception
     *    :           :         :
     * @exception ExceptionN  description de la Neme exception
     *
     * @see UneAutreClasse#UneAutreMethode
     * @author   Jean Dupond
     */
    public Album(String title, String artist, int duration, String releaseDate, UUID id, LinkedList<Song> songs) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.id = id;
        this.songs = songs;
    }

    /**
     * description de la méthode.
     * explication supplémentaire si nécessaire
     *
     * @return      description de la valeur de retour
     * @param       arg1 description du 1er argument
     *    :           :         :
     * @param       argN description du Neme argument
     * @exception   Exception1  description de la première exception
     *    :           :         :
     * @exception ExceptionN  description de la Neme exception
     *
     * @see UneAutreClasse#UneAutreMethode
     * @author   Jean Dupond
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * description de la méthode.
     * explication supplémentaire si nécessaire
     *
     * @return      description de la valeur de retour
     * @param       arg1 description du 1er argument
     *    :           :         :
     * @param       argN description du Neme argument
     * @exception   Exception1  description de la première exception
     *    :           :         :
     * @exception ExceptionN  description de la Neme exception
     *
     * @see UneAutreClasse#UneAutreMethode
     * @author   Jean Dupond
     */
    public String getArtist(){
        return this.artist;
    }

    public String getReleaseDate(){
        return this.releaseDate;
    }

    /**
     * description de la méthode.
     * explication supplémentaire si nécessaire
     *
     * @return      description de la valeur de retour
     * @param       arg1 description du 1er argument
     *    :           :         :
     * @param       argN description du Neme argument
     * @exception   Exception1  description de la première exception
     *    :           :         :
     * @exception ExceptionN  description de la Neme exception
     *
     * @see UneAutreClasse#UneAutreMethode
     * @author   Jean Dupond
     */
    public LinkedList<Song> getSongs() {
        return this.songs;
    }

    /**
     * description de la méthode.
     * explication supplémentaire si nécessaire
     *
     * @return      description de la valeur de retour
     * @param       arg1 description du 1er argument
     *    :           :         :
     * @param       argN description du Neme argument
     * @exception   Exception1  description de la première exception
     *    :           :         :
     * @exception ExceptionN  description de la Neme exception
     *
     * @see UneAutreClasse#UneAutreMethode
     * @author   Jean Dupond
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * description de la méthode.
     * explication supplémentaire si nécessaire
     *
     * @return      description de la valeur de retour
     * @param       arg1 description du 1er argument
     *    :           :         :
     * @param       argN description du Neme argument
     * @exception   Exception1  description de la première exception
     *    :           :         :
     * @exception ExceptionN  description de la Neme exception
     *
     * @see UneAutreClasse#UneAutreMethode
     * @author   Jean Dupond
     */
    public UUID getID()
    {
        return this.id;
    }

    /**
     * description de la méthode.
     * explication supplémentaire si nécessaire
     *
     * @return      description de la valeur de retour
     * @param       arg1 description du 1er argument
     *    :           :         :
     * @param       argN description du Neme argument
     * @exception   Exception1  description de la première exception
     *    :           :         :
     * @exception ExceptionN  description de la Neme exception
     *
     * @see UneAutreClasse#UneAutreMethode
     * @author   Jean Dupond
     */
    public String toString(){
        String str;
        str = "Album " + this.title + "\nBy " + this.artist + "\nDuration " + this.duration + "\nReleased " + this.releaseDate + "\nSongs : ";
        for (int i=0; i < this.songs.size(); i++) {
            str += "\n" + this.songs.get(i);
        }
        return str;
    }

    /**
     * description de la méthode.
     * explication supplémentaire si nécessaire
     *
     * @return      description de la valeur de retour
     * @param       arg1 description du 1er argument
     *    :           :         :
     * @param       argN description du Neme argument
     * @exception   Exception1  description de la première exception
     *    :           :         :
     * @exception ExceptionN  description de la Neme exception
     *
     * @see UneAutreClasse#UneAutreMethode
     * @author   Jean Dupond
     */
    public void addSong(){

    }



}
