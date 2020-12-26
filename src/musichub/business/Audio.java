package business;

import java.util.UUID;

/*
 * Nom de classe : Audio
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
public abstract class Audio
{
	protected String title;
    protected int duration;
    protected UUID id;
	protected String content;

	/**
	 *  Description de la methode
	 */
    public String getTitle()
    {
    	return this.title;
    }

	/**
     *  Description de la methode
     */
    public int getDuration()
    {
    	return this.duration;
    }

	/**
     *  Description de la methode
     */
    public UUID getID()
    {
    	return this.id;
    }

	/**
     *  Description de la methode
     */
    public String getContent()
    {
    	return this.content;
    }

}
