package business;

import java.util.LinkedList;
import java.util.List;

public class Album {

    private String titre;
    private String artiste;
    private int duree;
    private String dateSortie;
    private int id;
    private LinkedList<Chanson> musique;

    public Album(String titre, String artiste, int duree, String dateSortie, int id, LinkedList<Chanson> musique) {
    	this.titre = titre;
    	this.artiste = artiste;
    	this.duree = duree;
    	this.dateSortie = dateSortie;
    	this.id = id;
    	this.musique = musique;
    }

    public String getTitre(){
    	return this.titre;
    }

    public String getaArtiste(){
    	return this.artiste;
    }

    public LinkedList<Chanson> getMusique() {
    	return this.musique;
    }
}
