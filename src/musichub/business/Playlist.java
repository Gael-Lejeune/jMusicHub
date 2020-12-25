package business;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


public class Playlist{
	private String name;
	private UUID id;
	private LinkedList<Audio> audios = new LinkedList<Audio>();

	public Playlist(String name, UUID id, LinkedList<Audio> audios){
		this.name = name;
		this.id = id;
		this.audios = audios;
	}

	public String getName(){
		return this.name;
	}

	public LinkedList<Audio> getAudios(){
		return this.audios;
	}

	public String toString(){
		String str;
		str = "Playlist " + this.name;
		for (int i=0; i < this.audios.size(); i++) {
			str += "\n" + audios.get(i);
		}
		return str;
	}
}
