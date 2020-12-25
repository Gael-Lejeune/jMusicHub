package business;
// import business.Genre;

public class Song extends Audio
{
    private Genre genre;
	protected String artist;


    public Song(String title, String artist, int duration, String id, String content, Genre genre)
    {
    	this.title = title;
    	this.artist = artist;
    	this.duration = duration;
    	this.id = id;
    	this.content = content;
    	this.genre = genre;
    }

    public Genre getGenre()
    {
    	return this.genre;
    }

    public String getArtist()
    {
    	return this.artist;
    }

    public String toString(){
        return this.title + " by " + this.artist
        + "\nDuration : " + this.duration
        + "\nGenre : " + this.genre;
    }
}
