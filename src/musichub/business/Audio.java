package business;

public abstract class Audio
{
	protected String titre;
    protected String artiste;
    protected int duree;
    protected int id;

    // public Audio(String titre, String artiste, int duree, int id, int contenu){
	//
	// };

    public String getTitre()
    {
    	return this.titre;
    }
    public String getArtiste()
    {
    	return this.artiste;
    }
    public int getDuree()
    {
    	return this.duree;
    }
    public int getID()
    {
    	return this.id;
    }

	public void play(){
		
	};
}
