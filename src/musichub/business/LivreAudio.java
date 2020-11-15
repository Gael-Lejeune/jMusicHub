package business;

public class LivreAudio extends Audio
{
	private int contenu;
    private Langue langue;
    private Categorie categorie;

    public LivreAudio(String titre, String artiste, int duree, int id, int contenu, Langue langue, Categorie categorie)
    {
    	this.titre = titre;
    	this.artiste = artiste;
    	this.duree = duree;
    	this.id = id;
    	this.contenu = contenu;
    	this.langue = langue;
    	this.categorie = categorie;
    }

    public int getContenu()
    {
    	return this.contenu;
    }
    public Langue getLangue()
    {
    	return this.langue;
    }
    public Categorie getCategorie()
    {
    	return this.categorie;
    }
}
