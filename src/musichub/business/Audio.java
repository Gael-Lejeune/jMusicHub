package business;

public abstract class Audio
{
	protected String title;
    protected int duration;
    protected String id;
	protected String content;

    // public Audio(String title, String artist, int duration, int id, int contenu){
	//
	// };

    public String getTitle()
    {
    	return this.title;
    }
    public int getDuration()
    {
    	return this.duration;
    }
    public String getID()
    {
    	return this.id;
    }

	public void play(){

	};
}
