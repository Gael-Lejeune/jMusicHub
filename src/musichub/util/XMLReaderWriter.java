package util;

import business.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.UUID;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.text.Normalizer;

/** XMLReaderWriter classe qui demontre comment lire et ecrire un fichier XML
* La classe lit un XML qui contient plusieurs elements <pre>{@code<client>}</pre> (mais n'en ecrit qu'un seul):
*  <pre>
* {@code
*   <?xml version="1.0" encoding="UTF-8" standalone="no"?>
*      <clients>
*		   <client>
*		      <UUID>4f392743-c9ba-4230-9b93-a1c79c0a13c4</UUID>
*			  <firstName>Brad</firstName>
*			  <lastName>Pitt</lastName>
*			  <address>150 Broadway St., New York</address>
*			</client>
*		</clients>
* }
* </pre>
*	@author Felicia Ionascu
*/

public class XMLReaderWriter{
	private TransformerFactory transformerFactory;
	private Transformer transformer;
	private DocumentBuilderFactory documentFactory;
	private DocumentBuilder documentBuilder;

	public XMLReaderWriter() {
		try {
			transformerFactory = TransformerFactory.newInstance();
			transformer = transformerFactory.newTransformer();
			documentFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentFactory.newDocumentBuilder();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
	}

	/**
	* La methode qui transforme le document en memoire en fichier XML sur le disque dur
	* @param document le document à transformer
	* @param filePath le chemin (répértoire et nom) du fichier XML à créer
	*/
	public void createXMLFile(Document document, String filePath){
		try {
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(filePath));

			// If you use
			// StreamResult result = new StreamResult(System.out);
			// the output will be pushed to the standard output ...
			// You can use that for debugging

			//transform the DOM Object to an XML File
			transformer.transform(domSource, streamResult);

		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
		System.out.println("Done creating XML File");
	}

	/**
	* La methode qui crée le document en memoire
	* @return le document créé
	*/
	public Document createXMLDocument() {
		return documentBuilder.newDocument();
	}

	/**
	* La methode qui lit un fichier XML et le transforme en liste de noeuds en mémoire
	* @param filePath le chemin (répértoire et nom) du fichier XML à lire
	* @return la liste des noeuds lus
	*/
	public NodeList parseXMLFile (String filePath) {
		NodeList elementNodes = null;
		try {
			Document document= documentBuilder.parse(new File(filePath));
			Element root = document.getDocumentElement();

			elementNodes = root.getChildNodes();
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return elementNodes;
	}

	// /**
	// * Methode pour démontrer la lecture d'un fichier XML qui contient plusieurs éléments
	// */
	// public void readAlbumsXML(String inputFile) {
	// 	NodeList nodes = this.parseXMLFile(inputFile);
	// 	if (nodes == null) return;
	//
	// 	for (int i = 0; i<nodes.getLength(); i++) {
	// 		if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE)   {
	// 			Element currentElement = (Element) nodes.item(i);
	// 			if (currentElement.getNodeName().equals("album")) 	{
	// 				try {
	// 					String title = currentElement.getElementsByTagName("title").item(0).getTextContent();
	// 					String artist = currentElement.getElementsByTagName("artist").item(0).getTextContent();
	// 					String duration = currentElement.getElementsByTagName("duration").item(0).getTextContent();
	// 					String releaseDate = currentElement.getElementsByTagName("releaseDate").item(0).getTextContent();
	// 					String uuid = null;
	// 					UUID uniqueID = null;
	// 					try {
	// 						uuid = currentElement.getElementsByTagName("UUID").item(0).getTextContent();
	// 					}
	// 					catch (Exception ex) {
	// 						System.out.println("Empty UUID, will create a new one");
	// 					}
	// 					if ((uuid == null)  || (uuid.isEmpty()))
	// 					uniqueID = UUID.randomUUID();
	// 					else uniqueID = UUID.fromString(uuid);
	// 					//verify that I read everything correctly:
	// 					System.out.println(title + " by " + artist);
	// 					System.out.println("Duration : " + duration);
	// 					System.out.println("Released : " + releaseDate);
	// 					System.out.println("ID : " + uniqueID.toString());
	// 				} catch (Exception ex) {
	// 					System.out.println("Something is wrong with the XML client element");
	// 				}
	// 			}
	// 		}
	// 	}
	// }
	//
	// public LinkedList<Album> loadAlbumsXML(String inputFile) {
	// 	LinkedList<Album> albumList = new LinkedList<Album>();
	// 	NodeList nodes = this.parseXMLFile(inputFile);
	// 	// if (nodes == null) return;
	//
	// 	for (int i = 0; i<nodes.getLength(); i++) {
	// 		if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE)   {
	// 			Element currentElement = (Element) nodes.item(i);
	// 			if (currentElement.getNodeName().equals("album")) 	{
	// 				try {
	// 					String title = currentElement.getElementsByTagName("title").item(0).getTextContent();
	// 					String artist = currentElement.getElementsByTagName("artist").item(0).getTextContent();
	// 					int duration = Integer.parseInt(currentElement.getElementsByTagName("duration").item(0).getTextContent());
	// 					String releaseDate = currentElement.getElementsByTagName("releaseDate").item(0).getTextContent();
	//
	//
	// 					LinkedList<Song> songsList = new LinkedList<Song>();
	// 					NodeList songs = currentElement.getElementsByTagName("songs");
	// 					System.out.println(songs);
	// 					System.out.println(nodes);
	//
	// 					for (int j = 0;  j < songs.getLength(); j++) {
	// 						Element song = (Element)songs.item(j);
	// 						System.out.println(song.getNodeName());
	// 						if (song.getNodeName().equals("song")){
	// 							String titleSong = song.getElementsByTagName("title").item(0).getTextContent();
	// 							String artistSong = song.getElementsByTagName("artist").item(0).getTextContent();
	// 							int durationSong = Integer.parseInt(song.getElementsByTagName("duration").item(0).getTextContent());
	// 							String contenuSong = song.getElementsByTagName("contenu").item(0).getTextContent();
	// 							String genreSong = song.getElementsByTagName("genre").item(0).getTextContent();
	// 							String uuidSong = null;
	// 							UUID uniqueIDSong = null;
	//
	// 							try {
	// 								uuidSong = song.getElementsByTagName("UUID").item(0).getTextContent();
	// 							}
	// 							catch (Exception ex) {
	// 								System.out.println("Empty UUID, will create a new one");
	// 							}
	// 							if ((uuidSong == null)  || (uuidSong.isEmpty()))
	// 							uniqueIDSong = UUID.randomUUID();
	// 							else uniqueIDSong = UUID.fromString(uuidSong);
	// 							songsList.add(new Song(titleSong, artistSong, durationSong,uuidSong, contenuSong, Genre.JAZZ));
	// 						}
	// 					}
	//
	// 					String uuid = null;
	// 					UUID uniqueID = null;
	// 					try {
	// 						uuid = currentElement.getElementsByTagName("UUID").item(0).getTextContent();
	// 					}
	// 					catch (Exception ex) {
	// 						System.out.println("Empty UUID, will create a new one");
	// 					}
	// 					if ((uuid == null)  || (uuid.isEmpty()))
	// 					uniqueID = UUID.randomUUID();
	// 					else uniqueID = UUID.fromString(uuid);
	// 					//verify that I read everything correctly:
	// 					albumList.add(new Album(title, artist, duration, releaseDate, uuid, songsList));
	// 					// System.out.println(title + " by " + artist);
	// 					// System.out.println("Duration : " + duration);
	// 					// System.out.println("Released : " + releaseDate);
	// 					// System.out.println("ID : " + uniqueID.toString());
	// 				} catch (Exception ex) {
	// 					System.out.println(ex.getMessage());
	// 					ex.printStackTrace();
	// 					System.out.println("Something is wrong with the XML client element");
	// 				}
	// 			}
	// 		}
	// 	}
	// 	return albumList;
	// }
	//
	// public void readElementsXML(String inputFile) {
	// 	NodeList nodes = this.parseXMLFile(inputFile);
	// 	if (nodes == null) return;
	//
	// 	for (int i = 0; i<nodes.getLength(); i++) {
	// 		if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE)   {
	// 			Element currentElement = (Element) nodes.item(i);
	// 			if (currentElement.getNodeName().equals("song")){
	// 				try {
	// 					String title = currentElement.getElementsByTagName("title").item(0).getTextContent();
	// 					String artist = currentElement.getElementsByTagName("artist").item(0).getTextContent();
	// 					String duration = currentElement.getElementsByTagName("duration").item(0).getTextContent();
	// 					String releaseDate = currentElement.getElementsByTagName("contenu").item(0).getTextContent();
	// 					String uuid = null;
	// 					UUID uniqueID = null;
	// 					try {
	// 						uuid = currentElement.getElementsByTagName("UUID").item(0).getTextContent();
	// 					}
	// 					catch (Exception ex) {
	// 						System.out.println("Empty UUID, will create a new one");
	// 					}
	// 					if ((uuid == null)  || (uuid.isEmpty()))
	// 					uniqueID = UUID.randomUUID();
	// 					else uniqueID = UUID.fromString(uuid);
	// 					//verify that I read everything correctly:
	// 					System.out.println("Song " + title + " by " + artist);
	// 					System.out.println("Duration : " + duration);
	// 					System.out.println("ID : " + uniqueID.toString());
	// 				} catch (Exception ex) {
	// 					System.out.println("Something is wrong with the XML client element");
	// 				}
	// 			}
	// 			else if (currentElement.getNodeName().equals("livreAudio")){
	// 				try {
	// 					String title = currentElement.getElementsByTagName("title").item(0).getTextContent();
	// 					String author = currentElement.getElementsByTagName("author").item(0).getTextContent();
	// 					String duration = currentElement.getElementsByTagName("duration").item(0).getTextContent();
	// 					String releaseDate = currentElement.getElementsByTagName("contenu").item(0).getTextContent();
	// 					String uuid = null;
	// 					UUID uniqueID = null;
	// 					try {
	// 						uuid = currentElement.getElementsByTagName("UUID").item(0).getTextContent();
	// 					}
	// 					catch (Exception ex) {
	// 						System.out.println("Empty UUID, will create a new one");
	// 					}
	// 					if ((uuid == null)  || (uuid.isEmpty()))
	// 					uniqueID = UUID.randomUUID();
	// 					else uniqueID = UUID.fromString(uuid);
	// 					//verify that I read everything correctly:
	// 					System.out.println("Audio-Book " + title + " by " + author);
	// 					System.out.println("Duration : " + duration);
	// 					System.out.println("ID : " + uniqueID.toString());
	// 				} catch (Exception ex) {
	// 					System.out.println("Something is wrong with the XML client element");
	// 				}
	// 			}
	// 		}
	// 	}
	// }
	// /**
	// * Methode pour démontrer la lecture d'un fichier XML qui contient plusieurs éléments
	// */
	// public void readPlaylistsXML(String inputFile) {
	// 	NodeList nodes = this.parseXMLFile(inputFile);
	// 	if (nodes == null) return;
	//
	// 	for (int i = 0; i<nodes.getLength(); i++) {
	// 		if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE)   {
	// 			Element currentElement = (Element) nodes.item(i);
	// 			if (currentElement.getNodeName().equals("playlist")) 	{
	// 				try {
	// 					String nom = currentElement.getElementsByTagName("nom").item(0).getTextContent();
	// 					String uuid = null;
	// 					UUID uniqueID = null;
	// 					try {
	// 						uuid = currentElement.getElementsByTagName("UUID").item(0).getTextContent();
	// 					}
	// 					catch (Exception ex) {
	// 						System.out.println("Empty UUID, will create a new one");
	// 					}
	// 					if ((uuid == null)  || (uuid.isEmpty()))
	// 					uniqueID = UUID.randomUUID();
	// 					else uniqueID = UUID.fromString(uuid);
	// 					//verify that I read everything correctly:
	// 					System.out.println("Playlist : " + nom);
	// 					System.out.println("ID : " + uniqueID.toString());
	// 				} catch (Exception ex) {
	// 					System.out.println("Something is wrong with the XML client element");
	// 				}
	// 			}
	// 		}
	// 	}
	// }
	//
	// /**
	// * Methode pour démontrer l'écriture d'un fichier XML avec un seul élément
	// */
	// public void writeXML(String outputFile) {
	// 	Document document = this.createXMLDocument();
	// 	if (document == null) return;
	//
	// 	// create root element
	// 	Element root = document.createElement("clients");
	// 	document.appendChild(root);
	//
	// 	//save one "client" element; create a loop to save more elements!!
	// 	Element client = document.createElement("client");
	// 	// clientUUID element
	// 	UUID uniqueID = UUID.fromString("4f392743-c9ba-4230-9b93-a1c79c0a13c4");
	// 	Element clientUUID = document.createElement("UUID");
	// 	clientUUID.appendChild(document.createTextNode(uniqueID.toString()));
	// 	client.appendChild(clientUUID);
	//
	// 	// firstName element
	// 	String firstName = "Brad";
	// 	Element firstNameElement = document.createElement("firstName");
	// 	firstNameElement.appendChild(document.createTextNode(firstName));
	// 	client.appendChild(firstNameElement);
	//
	// 	//lastName element
	// 	String lastName = "Pitt";
	// 	Element lastNameElement = document.createElement("lastName");
	// 	lastNameElement.appendChild(document.createTextNode(lastName));
	// 	client.appendChild(lastNameElement);
	//
	// 	//address element
	// 	String address = "150 Broadway St., New York";
	// 	Element addressElement = document.createElement("address");
	// 	addressElement.appendChild(document.createTextNode(address));
	// 	client.appendChild(addressElement);
	//
	// 	root.appendChild(client);
	//
	// 	this.createXMLFile(document, outputFile);
	// }


	private Song getSong(Element element) {
		// NodeList song = node.getChildNodes();
		String title = element.getElementsByTagName("title").item(0).getTextContent();
		String artist = element.getElementsByTagName("artist").item(0).getTextContent();
		int duration = Integer.parseInt(element.getElementsByTagName("duration").item(0).getTextContent());
		UUID id;
		String uuid = "";
		try {
			uuid = element.getElementsByTagName("UUID").item(0).getTextContent();
		}
		catch (Exception ex) {
			System.out.println("Empty UUID, will create a new one");
		}
		if ((uuid == null)  || (uuid.isEmpty()))
		id = UUID.randomUUID();
		else id = UUID.fromString(uuid);
		String content = element.getElementsByTagName("content").item(0).getTextContent();
		String genre = element.getElementsByTagName("genre").item(0).getTextContent();


		return new Song(title, artist, duration, id, content, Genre.valueOf(genre));
	}

	private AudioBook getAudioBook(Element element) {
		// NodeList song = node.getChildNodes();
		String title = element.getElementsByTagName("title").item(0).getTextContent();
		String author = element.getElementsByTagName("author").item(0).getTextContent();
		int duration = Integer.parseInt(element.getElementsByTagName("duration").item(0).getTextContent());
		UUID id;
		String uuid = "";
		try {
			uuid = element.getElementsByTagName("UUID").item(0).getTextContent();
		}
		catch (Exception ex) {
			System.out.println("Empty UUID, will create a new one");
		}
		if ((uuid == null)  || (uuid.isEmpty()))
		id = UUID.randomUUID();
		else id = UUID.fromString(uuid);
		String content = element.getElementsByTagName("content").item(0).getTextContent();
		String category = element.getElementsByTagName("category").item(0).getTextContent();
		String language = element.getElementsByTagName("language").item(0).getTextContent();


		return new AudioBook(title, author, duration, id, content,Language.valueOf(language), Category.valueOf(category));
	}

	Playlist getPlaylist(Element element) {
		LinkedList<Audio> audioList = new LinkedList<Audio>();
		String name = "";
		UUID uniqueID = null;

		try {
			name = element.getElementsByTagName("name").item(0).getTextContent();
			String uuid = null;
			try {
				uuid = element.getElementsByTagName("UUID").item(0).getTextContent();
			}
			catch (Exception ex) {
				System.out.println("Empty UUID, will create a new one");
			}
			if ((uuid == null)  || (uuid.isEmpty()))
			uniqueID = UUID.randomUUID();
			else uniqueID = UUID.fromString(uuid);
			//verify that I read everything correctly:
			NodeList audios = element.getElementsByTagName("audios").item(0).getChildNodes();
			// Node audio1 = audios.item(0);
			// System.out.println(audio1.getNodeName());
			for (int i = 0; i<audios.getLength(); i++) {
				if (audios.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element currentElement = (Element) audios.item(i);
					// System.out.println(audios.item(i).getNodeName());
					if (currentElement.getNodeName().equals("song")) {
						audioList.add(getSong(currentElement));
					} else if (currentElement.getNodeName().equals("audioBook")) {
						audioList.add(getAudioBook(currentElement));
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Something is wrong with the XML client element");
		}
		return new Playlist(name, uniqueID, audioList);
	}

	Album getAlbum(Element element) {
		LinkedList<Song> songList = new LinkedList<Song>();
		String title = "";
		String artist = "";
		int duration = 0;
		String releaseDate = "";
		UUID uniqueID = null;

		try {
			title = element.getElementsByTagName("title").item(0).getTextContent();
			artist = element.getElementsByTagName("artist").item(0).getTextContent();
			duration = Integer.parseInt(element.getElementsByTagName("duration").item(0).getTextContent());
			releaseDate = element.getElementsByTagName("releaseDate").item(0).getTextContent();
			String uuid = null;
			try {
				uuid = element.getElementsByTagName("UUID").item(0).getTextContent();
			}
			catch (Exception ex) {
				System.out.println("Empty UUID, will create a new one");
			}
			if ((uuid == null)  || (uuid.isEmpty()))
			uniqueID = UUID.randomUUID();
			else uniqueID = UUID.fromString(uuid);
			//verify that I read everything correctly:
			NodeList songs = element.getElementsByTagName("songs").item(0).getChildNodes();
			// Node audio1 = audios.item(0);
			// System.out.println(audio1.getNodeName());
			for (int i = 0; i<songs.getLength(); i++) {
				if (songs.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element currentElement = (Element) songs.item(i);
					// System.out.println(audios.item(i).getNodeName());
					songList.add(getSong(currentElement));
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Something is wrong with the XML client element");
		}
		return new Album(title, artist, duration, releaseDate, uniqueID, songList);
	}

	public LinkedList<Playlist> readPlaylistXML(String file){
		NodeList list = this.parseXMLFile(file);
		// System.out.println(list.getLength());
		LinkedList<Playlist> playlistList = new LinkedList<Playlist>();

		for (int i = 0; i<list.getLength(); i++) {
			if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element currentElement = (Element) list.item(i);
				if (currentElement.getNodeName().equals("playlist")) {
					playlistList.add(getPlaylist(currentElement));
				}
			}
		}
		return playlistList;
	}

	public LinkedList<Album> readAlbumXML(String file){
		NodeList list = this.parseXMLFile(file);
		// System.out.println(list.getLength());
		LinkedList<Album> albumList = new LinkedList<Album>();

		for (int i = 0; i<list.getLength(); i++) {
			if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element currentElement = (Element) list.item(i);
				if (currentElement.getNodeName().equals("album")) {
					albumList.add(getAlbum(currentElement));
				}
			}
		}
		return albumList;
	}

	public LinkedList<Audio> readElementXML(String file){
		NodeList list = this.parseXMLFile(file);
		// System.out.println(list.getLength());
		LinkedList<Audio> elementList = new LinkedList<Audio>();

		for (int i = 0; i<list.getLength(); i++) {
			if (list.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element currentElement = (Element) list.item(i);
				if (currentElement.getNodeName().equals("song")) {
					elementList.add(getSong(currentElement));
				} else if (currentElement.getNodeName().equals("audioBook")) {
					elementList.add(getAudioBook(currentElement));
				}
			}
		}
		return elementList;
	}

	public Element writeSongXML(Document document, Song audio){
		Element songElement = document.createElement("song");

		String title = audio.getTitle();
		Element titleElement = document.createElement("title");
		titleElement.appendChild(document.createTextNode(title));
		songElement.appendChild(titleElement);

		String artist = audio.getArtist();
		Element artistElement = document.createElement("artist");
		artistElement.appendChild(document.createTextNode(artist));
		songElement.appendChild(artistElement);

		String duration = String.valueOf(audio.getDuration());
		Element durationElement = document.createElement("duration");
		durationElement.appendChild(document.createTextNode(duration));
		songElement.appendChild(durationElement);

		UUID uniqueID = audio.getID();
		Element songUUID = document.createElement("UUID");
		songUUID.appendChild(document.createTextNode(uniqueID.toString()));
		songElement.appendChild(songUUID);

		String content = audio.getContent();
		Element contentElement = document.createElement("content");
		contentElement.appendChild(document.createTextNode(content));
		songElement.appendChild(contentElement);

		String genre = Normalizer.normalize(audio.getGenre().toString(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
		Element genreElement = document.createElement("genre");
		genreElement.appendChild(document.createTextNode(genre));
		songElement.appendChild(genreElement);

		return songElement;
	}

	public Element writeAudioBookXML(Document document, AudioBook audio){
		Element audioBookElement = document.createElement("audioBook");

		String title = audio.getTitle();
		Element titleElement = document.createElement("title");
		titleElement.appendChild(document.createTextNode(title));
		audioBookElement.appendChild(titleElement);

		String author = audio.getAuthor();
		Element authorElement = document.createElement("author");
		authorElement.appendChild(document.createTextNode(author));
		audioBookElement.appendChild(authorElement);

		String duration = String.valueOf(audio.getDuration());
		Element durationElement = document.createElement("duration");
		durationElement.appendChild(document.createTextNode(duration));
		audioBookElement.appendChild(durationElement);

		UUID uniqueID = audio.getID();
		Element songUUID = document.createElement("UUID");
		songUUID.appendChild(document.createTextNode(uniqueID.toString()));
		audioBookElement.appendChild(songUUID);

		String content = audio.getContent();
		Element contentElement = document.createElement("content");
		contentElement.appendChild(document.createTextNode(content));
		audioBookElement.appendChild(contentElement);

		String language = Normalizer.normalize(audio.getLanguage().toString(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
		Element languageElement = document.createElement("language");
		languageElement.appendChild(document.createTextNode(language));
		audioBookElement.appendChild(languageElement);

		String category = Normalizer.normalize(audio.getCategory().toString(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").toUpperCase();
		Element categoryElement = document.createElement("category");
		categoryElement.appendChild(document.createTextNode(category));
		audioBookElement.appendChild(categoryElement);

		return audioBookElement;
	}

	public void writeAlbumXML(String outputFile, LinkedList<Album> albumList){
		Document document = this.createXMLDocument();
		if (document == null) return;


		Element root = document.createElement("albums");
		document.appendChild(root);

		for (int i = 0; i < albumList.size() ; i++) {
			Album album = albumList.get(i);
			// System.out.println(album);
			Element albumElement = document.createElement("album");

			String title = album.getTitle();
			Element titleElement = document.createElement("title");
			titleElement.appendChild(document.createTextNode(title));
			albumElement.appendChild(titleElement);

			String artist = album.getArtist();
			Element artistElement = document.createElement("artist");
			artistElement.appendChild(document.createTextNode(artist));
			albumElement.appendChild(artistElement);

			String duration = String.valueOf(album.getDuration());
			Element durationElement = document.createElement("duration");
			durationElement.appendChild(document.createTextNode(duration));
			albumElement.appendChild(durationElement);

			String releaseDate = album.getReleaseDate();
			Element releaseDateElement = document.createElement("releaseDate");
			releaseDateElement.appendChild(document.createTextNode(releaseDate));
			albumElement.appendChild(releaseDateElement);

			UUID uniqueID = album.getID();
			Element songUUID = document.createElement("UUID");
			songUUID.appendChild(document.createTextNode(uniqueID.toString()));
			albumElement.appendChild(songUUID);

			Element songs = document.createElement("songs");
			LinkedList<Song> songList = album.getSongs();
			for (int j = 0; j < songList.size(); j++) {
				if (songList.get(j) instanceof Song) {
					songs.appendChild(writeSongXML(document, (Song)songList.get(j)));
				}
			}
			albumElement.appendChild(songs);
			root.appendChild(albumElement);
		}
		this.createXMLFile(document, outputFile);
	}

	public void writeElementXML(String outputFile, LinkedList<Audio> audioList) {
		Document document = this.createXMLDocument();
		if (document == null) return;

		// create root element
		Element root = document.createElement("elements");
		document.appendChild(root);

		for (int i = 0; i < audioList.size(); i++) {
			if (audioList.get(i) instanceof Song) {
				root.appendChild(writeSongXML(document, (Song)audioList.get(i)));
			} else if (audioList.get(i) instanceof AudioBook) {
				root.appendChild(writeAudioBookXML(document, (AudioBook)audioList.get(i)));
			}
		}
		this.createXMLFile(document, outputFile);
	}

	public void writePlaylistXML(String outputFile, LinkedList<Playlist> playlistList){
		Document document = this.createXMLDocument();
		if (document == null) return;


		Element root = document.createElement("playlists");
		document.appendChild(root);

		for (int i = 0; i < playlistList.size() ; i++) {
			Playlist playlist = playlistList.get(i);
			// System.out.println(album);
			Element playlistElement = document.createElement("playlist");

			String name = playlist.getName();
			Element nameElement = document.createElement("name");
			nameElement.appendChild(document.createTextNode(name));
			playlistElement.appendChild(nameElement);

			UUID uniqueID = playlist.getID();
			Element songUUID = document.createElement("UUID");
			songUUID.appendChild(document.createTextNode(uniqueID.toString()));
			playlistElement.appendChild(songUUID);

			Element audios = document.createElement("audios");
			LinkedList<Audio> audiosList = playlist.getAudios();
			for (int j = 0; j < audiosList.size(); j++) {
				if (audiosList.get(j) instanceof Song) {
					audios.appendChild(writeSongXML(document, (Song)audiosList.get(j)));
				} else if (audiosList.get(j) instanceof AudioBook) {
					audios.appendChild(writeAudioBookXML(document, (AudioBook)audiosList.get(j)));
				}
			}
			playlistElement.appendChild(audios);
			root.appendChild(playlistElement);
		}
		this.createXMLFile(document, outputFile);
	}

}
