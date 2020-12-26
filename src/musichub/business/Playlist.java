package business;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/*
 * Nom de classe : Playlist
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
public class Playlist{
	private String name;
	private UUID id;
	private LinkedList<Audio> audios = new LinkedList<Audio>();

	/**
	 *  Description de la methode
	 */
	public Playlist(String name, UUID id, LinkedList<Audio> audios){
		this.name = name;
		this.id = id;
		this.audios = audios;
	}

	/**
	 *  Description de la methode
	 */
	public String getName(){
		return this.name;
	}

	/**
	 *  Description de la methode
	 */
	public LinkedList<Audio> getAudios(){
		return this.audios;
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
	public String toString(){
		String str;
		str = "Playlist " + this.name;
		for (int i=0; i < this.audios.size(); i++) {
			str += "\n" + audios.get(i);
		}
		return str;
	}
}
