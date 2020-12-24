package business;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;


public class Playlist{
	private String name;
	private UUID id;
	private LinkedList<Audio> audio = new LinkedList<Audio>();
	private static int audioIndex = 0;

	public Playlist(String name, UUID id, LinkedList<Audio> audio){
		this.name = name;
		this.id = id;
		this.audio = audio;
	}

	public String toString(){
		String str;
		str = "Playlist " + this.name;
		for (int i=0; i < this.audio.size(); i++) {
			str += "\n" + audio.get(i);
		}
		return str;
	}
}
