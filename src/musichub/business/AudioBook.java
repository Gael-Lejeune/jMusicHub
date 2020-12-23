package business;

public class AudioBook extends Audio
{
	private String content;
	private String author;
    private Language language;
    private Category category;

    public AudioBook(String title, String author, int duration, String id, String content, Language language, Category category)
    {
    	this.title = title;
    	this.author = author;
    	this.duration = duration;
    	this.id = id;
    	this.content = content;
    	this.language = language;
    	this.category = category;
    }

    public String getContent()
    {
    	return this.content;
    }
    public Language getLanguage()
    {
    	return this.language;
    }
    public Category getCategory()
    {
    	return this.category;
    }
}
