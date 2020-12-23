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

	public Boolean play() {
		//Lecture de toutes les musiques de la Playlist
		this.audio.get(this.audioIndex).play();
		if(this.audioIndex<this.audio.size()) {
			//Si il n'y a plus de musique arrêter la lecture
			audioIndex = 0;
			return false;
		}
		// else if(this.audio.get(this.audioIndex).audioEnd()){
			// audioIndex += 1;
			return true;
		// }
	}

	public void nextMusic() {
		//Passer à la musique suivante
		audioIndex += 1;
	}
	public void previousMusic(){
		//Revenir à la musique précédente
		audioIndex -= 1;
	}
	public void addMusicToPlaylist(Song song){
		this.audio.add(song);
	}
	public void addAlbumToPlaylist(Album album){
		this.audio.addAll(album.getSongs());
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
