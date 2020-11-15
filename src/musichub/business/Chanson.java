package business;
// import business.Genre;

public class Chanson extends Audio
{
	private int contenu;
    private Genre genre;

    public Chanson(String titre, String artiste, int duree, int id, int contenu, Genre genre)
    {
    	this.titre = titre;
    	this.artiste = artiste;
    	this.duree = duree;
    	this.id = id;
    	this.contenu = contenu;
    	this.genre = genre;
    }

    public int getContenu()
    {
    	return this.contenu;
    }
    public Genre getGenre()
    {
    	return this.genre;
    }
}
