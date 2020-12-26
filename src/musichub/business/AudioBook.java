package business;

import java.util.UUID;

/*
 * Nom de classe : AudioBook
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
public class AudioBook extends Audio
{
	private String author;
    private Language language;
    private Category category;

	/**
	 *  Description de la methode
	 */
    public AudioBook(String title, String author, int duration, UUID id, String content, Language language, Category category)
    {
    	this.title = title;
    	this.author = author;
    	this.duration = duration;
    	this.id = id;
    	this.content = content;
    	this.language = language;
    	this.category = category;
    }

	/**
	 *  Description de la methode
	 */
    public String getAuthor()
    {
    	return this.author;
    }

	/**
     *  Description de la methode
     */
    public Language getLanguage()
    {
    	return this.language;
    }

	/**
     *  Description de la methode
     */
    public Category getCategory()
    {
    	return this.category;
    }

	/**
	 *  Description de la methode
	 */
	public String toString(){
		return this.title + " written by " + this.author + " : " + this.duration;
	}

}
