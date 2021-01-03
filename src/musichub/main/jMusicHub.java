package main;

import business.*;
import util.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;

/** JMusicHub Class is the main class of the JMusicHub program.
 *
 *
 * Version : 1.0
 *
 * Date : 30/02/2001
 *
 * @author Gaël Lejeune and Steve Chevreau-Manat
 */
public class JMusicHub{

    /**
      * XML editor allowing to read and write XML files
      * @see XMLReaderWriter
      */
    private XMLReaderWriter xmlEditor;

    /**
     * List of the registered playlists
     * @see Playlist
     */
    private LinkedList<Playlist> playlists;

    /**
     * List of the registered albums
     * @see Album
     */
    private LinkedList<Album> albums;

    /**
     * List of the registered audio elements
     * @see Audio
     */
    private LinkedList<Audio> elements;

    /**
     * Album constructor
     * Initialize all the attributes and fill the lists by reading the XML files
     *
     * @author Gaël Lejeune
     */
    public JMusicHub() {
        this.xmlEditor = new XMLReaderWriter();
        /* Load of all the XML files */
        try {
            this.playlists = this.xmlEditor.readPlaylistXML("files/playlists.xml");
            this.albums = this.xmlEditor.readAlbumXML("files/albums.xml");
            this.elements = this.xmlEditor.readElementXML("files/elements.xml");
        } catch (MissingFileException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *  Description de la methode
     */
    public void displayAlbumByReleaseDate()
    {
        String date[3];
        String date2[3];
        int node[], mem;
        for(int i=0;i<albums.size()-1;j++)
        {
            node[i]=i;
        }
        for(int j=0;j<albums.size()-1;j++)
        {
            for(int i=0;i<albums.size()-2;i++)
            {
              date = albums[i].getRealeaseDate.split("/");
              date2 = albums[i+1].getReleaseDate.split("/");
              if(Integer.parseInt(date[2])>Integer.parseInt(date2[2]))
              {
                mem = node[i];
                node[i] = node[i+1];
                node[i+1] = mem;
              }
              else if(Integer.parseInt(date[2])==Integer.parseInt(date2[2]))
              {
                if(Integer.parseInt(date[1])>Integer.parseInt(date2[1]))
                {
                  mem = node[i];
                  node[i] = node[i+1];
                  node[i+1] = mem;
                }
                else if(Integer.parseInt(date[1])==Integer.parseInt(date2[1]))
                {
                  if(Integer.parseInt(date[0])>Integer.parseInt(date2[0]))
                  {
                    mem = node[i];
                    node[i] = node[i+1];
                    node[i+1] = mem;
                  }
                }
              }
            }
            for(int i=0;i<albums.size()-1;i++)
            {
                System.out.println(albums.get(node[i]).toString()));
            }
    }

    /**
     *  Description de la methode
     */
    public void displaySongByGenre() {

    }

    /**
     * Displays all the registered playlists
     * @see         Playlist
     * @author      Gaël Lejeune
     */
    public void displayPlaylists() {
        System.out.println("Existing playlists :\n");
        for (int i = 0; i < this.playlists.size(); i++) {
            System.out.println(this.playlists.get(i) + "\n");
        }
    }

    /**
     * Asks and displays an specific registered playlist
     * @see         Playlist
     * @author      Gaël Lejeune
     */
    public void displaySpecificPlaylist() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Name of the playlist :");
        boolean found = false;
        String name = scanner.nextLine();
        for (int i = 0; i < this.playlists.size(); i++) {
            if (this.playlists.get(i).getName().equals(name)) {
                System.out.println(this.playlists.get(i) + "\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No playlist found.");
        }
    }

    /**
     * Displays all the registered albums
     * @see         Album
     * @author      Gaël Lejeune
     */
    public void displayAlbums() {
        System.out.println("\n\n\nExisting albums :\n");
        for (int i = 0; i < this.albums.size(); i++) {
            System.out.println(this.albums.get(i) + "\n");
        }
    }

    /**
     * Asks and displays an specific registered album
     * @see         Album
     * @author      Gaël Lejeune
     */
    public void displaySpecificAlbum() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Name of the album to display :");
        boolean found = false;
        String title = scanner.nextLine();  /* Album title entered by the user */
        for (int i = 0; i < this.albums.size(); i++) {
            if (this.albums.get(i).getTitle().equals(title)) {
                System.out.println(this.albums.get(i) + "\n");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No album found.");
        }
    }


    /**
     * Displays all the registered audio elements
     * @see         Album
     * @author      Gaël Lejeune
     */
    public void displayElements() {
        System.out.println("\n\n\nExisting elements :\n");
        for (int i = 0; i < this.elements.size(); i++) {
            System.out.println(this.elements.get(i) + "\n");
        }
    }

    /**
     *  Description de la methode
     */
    public void displayAudioBooks() {
      LinkedList<Audio> audioBook = new LinkedList<Audio>();
      int node[], mem;
      boolean isAnAudioBook = true;
      for(int i=0;i<elements.size()-1;i++)
      {
        try {
            this.elements.get(i).getCategory();
            isAnAudioBook = true;
        } catch(IOException e) {
            isAnAudioBook = false
        }
        if(isAnAudioBook)
        {
            audioBook.add(this.elements.get(i));
        }
      }
      for(int i=0;i<audioBook.size()-1;i++)
      {
          node[i] = i;
      }
      for(int j=0;j<audioBook.size()-1;j++)
      {
        for(int i=0;i<audioBook.size()-2;i++)
        {
          if(audioBook[i].getAuthor.compareTo(audioBook[i+1].getAuthor)>0)
          {
            mem = node[i];
            node[i] = node[i+1];
            node[i+1] = mem;
          }
        }
      }
      for(int i=0;i<audioBook.size()-1;i++)
      {
          System.out.println(audioBook.get(node[i]).toString());
      }
    }

    /**
    *  Description de la methode
    */
    public void addingSong() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Adding a music :\nTitle :");
        String title = scan.nextLine();
        System.out.println("Artist :");
        String artist = scan.nextLine();
        System.out.println("Duration :");
        int duration = Integer.parseInt(scan.nextLine());
        UUID uuid = UUID.randomUUID();
        System.out.println("Content :");
        String content = scan.nextLine();
        boolean found = true;
        while(found)
        {
          try {
            FileReader file = new FileReader(content);
            found = false;
          } catch(IOException e) {
            found = true;
            System.out.println("This content doesn't exist, choose an existing content :");
          } finally {
            try {
              file.close();
            } catch(IOException e) {
              System.out.println("Message " + e);
            }
          }
        }
        do
        {
          System.out.println("Genre : (Jazz/Classique/Hip-Hop/Rock/Pop/Rap/Metal)");
          genre = scan.nextLine();
        }while(genre!="Jazz"&&genre!="Classique"&&genre!="Hip-Hop"&&genre!="Rock"&&genre!="Pop"&&genre!="Rap"&&genre!="Metal");
        Genre musicGenre = new Genre(genre);
        datamusic = "Are you sure you want to add the "+duration+"-second "+title+" music from "+artist+" with the ID "+uuid+" and as a music genre the "+genre+" ? [y/n]");
        System.out.println(datamusic);
        do
        {
          touche = scan.nextLine();
        }while(touche!="y"&&touche!="n");
        if(touche==y)
        {
          this.elements.add(Song(title,artist,duration,uuid,content,musicGenre));
        }
    }

    /**
    *  Description de la methode
    */
    public void addingAudioBook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Adding an audio book :\nTitle :");
        String title = scan.nextLine();
        System.out.println("Artist :");
        String artist = scan.nextLine();
        System.out.println("Duration :");
        int duration = Integer.parseInt(scan.nextLine());
        UUID uuid = UUID.randomUUID();
        System.out.println("Content :");
        String content = scan.nextLine();
        boolean found = true;
        while(found)
        {
            try {
              FileReader file = file = new FileReader(content);
                found = false;
            } catch(IOException e) {
              found = true;
              System.out.println("This content doesn't exist, choose an existing content :");
            } finally {
              try {
                file.close();
              } catch(IOException e) {
                System.out.println("Message " + e);
              }
            }
        }
        do
        {
          System.out.println("Language : (Français/Anglais/Italien/Espagnol/Allemand)");
          language = scan.nextLine();
        }while(language!="Français" && language!="Anglais" && language!="Italien" && language!="Espagnol" && language!="Allemand");
        Language audioBookLanguage = new Language(language);
        do
        {
          System.out.println("Category : (Jeunesse/Roman/Théâtre/Discours/Documentaire)");
          category = scan.nextLine();
        }while(category!="Jeunesse" && category!="Roman" && category!="Theatre" && category!="Discours" && category!="Documentaire");
        Category audioBookCategory = new Category(category);
        audioBook = "Are you sure you want to add the "+artist+"\'s "+duration+"-second "+title+" audio book with ID "+id+" read in "+language+" and "+category+" type ? [y/n]");
        System.out.println(audioBook);
        do
        {
          touche = scan.nextLine();
        }while(touche!="y"&&touche!="n");
        if(touche==y)
        {
          this.elements.add(AudioBook(title,artist,duration,uuid,content,audioBookLanguage,audioBookCategory));
        }
    }

    /**
    *  Description de la methode
    */
    public void addingAlbum() {
        Scanner scan = new Scanner(System.in);
        LinkedList<Song> songs = new LinkedList<Song>();
        System.out.println("Adding an album :\nTitle :");
        String title = scan.nextLine();
        System.out.println("Artist :");
        String artist = scan.nextLine();
        System.out.println("Duration (in s):");
        int duration = Integer.parseInt(scan.nextLine());
        UUID uuid = UUID.randomUUID();
        do {
            System.out.println("Realease date : (day/month/year)");
            String date = scan.nextLine();
            String dateList[] = date.split("/");
        }while(!(dateList.length()==3&&(dateList[0]>=0&&dateList[0]<=31)&&(dateList[1]>=1&&dateList[1]<=12)&&dateList[2]>=1000));
        System.out.println("How many music is there in this album :");
        int numberMusic = Integer.parseInt(scan.nextLine());
        for(int i=0;i<numberMusic-1;i++)
        {
            songs.add(addingSong());
        }
        this.Album.add(Album(title,artist,duration,date,uuid,songs));
    }

    /**
     * Asks and add an existing song to a chosen album
     * @see         Album
     * @see         Song
     * @author      Gaël Lejeune
     */
    public void addSongToAlbum() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter the name of an album :");
        boolean found = false;
        String title = scanner.nextLine();
        int albumIndex = 0;
        for (int i = 0; i < this.albums.size(); i++) {
            if (this.albums.get(i).getTitle().equals(title)) {
                albumIndex = i;
                found = true;
            }
        }
        if (found) {
            System.out.println("Enter the name of the songs you wish to add or press enter to finish : ");
            String songname = "1";
            while (!songname.equals("")) {
                songname = scanner.nextLine();
                boolean songFound = false;
                for (int i = 0; i < this.elements.size(); i++) {
                    if (this.elements.get(i).getTitle().equals(songname)) {
                        this.albums.get(albumIndex).addSong((Song)this.elements.get(i));
                        System.out.println("Added song : " + this.elements.get(i));
                        songFound = true;
                    }
                }
                if (!songFound) {
                    System.out.println("No song found.");
                }
            }
        } else {
            System.out.println("No album found.");
        }
    }

    /**
     * Asks and add an existing audio to a chosen playlist
     * @see         Playlist
     * @see         Audio
     * @author      Gaël Lejeune
     */
    public void addSongToPlaylist() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter the name of a playlist :");
        boolean found = false;
        String name = scanner.nextLine();
        int playlistIndex = 0;
        for (int i = 0; i < this.playlists.size(); i++) {
            if (this.playlists.get(i).getName().equals(name)) {
                playlistIndex = i;
                found = true;
            }
        }
        if (found) {
            System.out.println("Enter the name of the songs you wish to add or press enter to finish : ");
            String songname = "1";
            while (!songname.equals("")) {
                songname = scanner.nextLine();
                boolean songFound = false;
                for (int i = 0; i < this.elements.size(); i++) {
                    if (this.elements.get(i).getTitle().equals(songname)) {
                        this.playlists.get(playlistIndex).addSong((Song)this.elements.get(i));
                        System.out.println("Added song : " + this.elements.get(i));
                        songFound = true;
                    }
                }
                if (!songFound) {
                    System.out.println("No song found.");
                }
            }
        } else {
            System.out.println("No playlist found.");
        }
    }

    /**
     * Asks the informations and the audios to create and register a playlist
     * @see         Playlist
     * @author      Gaël Lejeune
     */
    public void createPlaylistFromExisting() {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Name of your new playlist :");
        String name = scanner.nextLine();

        System.out.println("Generating UUID");
        UUID uuid = UUID.randomUUID();

        LinkedList<Audio> audios = new LinkedList<Audio>();
        System.out.println("Enter the name of the songs you wish to add or press enter to finish : ");
        String songname = "1";
        while (!songname.equals("")) {
            songname = scanner.nextLine();
            boolean found = false;
            for (int i = 0; i < this.elements.size(); i++) {
                if (this.elements.get(i).getTitle().equals(songname)) {
                    audios.add(this.elements.get(i));
                    System.out.println("Added song : " + this.elements.get(i));
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No song found.");
            }
        }
        if (audios.size() == 0) {
            System.out.println("Empty playlist, abort creation.");
            return;
        }
        this.playlists.add(new Playlist(name, uuid, audios));
    }

    /**
     * Asks and delete the chosen playlist
     * @see         Playlist
     * @author      Gaël Lejeune
     */
    public void deletePlaylist() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Name of the playlist to delete :");
        String name = scanner.nextLine();
        for (int i = 0; i < this.playlists.size(); i++) {
            if (this.playlists.get(i).getName().equals(name)) {
                this.playlists.remove(i);
            }
        }
    }

    /**
     * Create XML files containing the registered playlists, elements, and albums using the class XML editor
     * @see         XMLReaderWriter
     * @author      Gaël Lejeune
     */
    public void save() {
        this.xmlEditor.writeElementXML("files/elements1.xml", this.elements);
        this.xmlEditor.writeAlbumXML("files/albums1.xml", this.albums);
        this.xmlEditor.writePlaylistXML("files/playlists1.xml", this.playlists);
    }

    /**
     *  Description de la methode
     */
    public void help() {
        System.out.println("- c : add a new song");
        System.out.println("- a : addition of a new album");
        System.out.println("- + : add an existing song to an album");
        System.out.println("- l : added a new audio book");
        System.out.println("- p : Creation of a new playlist from existing songs and audiobooks");
        System.out.println("- - : delete a playlist");
        System.out.println("- s : save playlists, albums, songs and audiobooks in the respective xml files");
        System.out.println("- e : exit the jMusicHub");
        System.out.println("- h : help with details of previous commands");
    }

    /**
     * Execution of the JMusicHub program and interaction with the user using a terminal
     * @param       args Arguments of the function
     * @author Gaël Lejeune and Steve Chevreau-Manat
     */
    public static void main(String[] args) {
        System.out.println("\n\nWelcome in JMusicHub,");
        System.out.println("Reading library...\n\n");
        JMusicHub jmusichub = new JMusicHub();

        jmusichub.displayPlaylists();
        jmusichub.addSongToPlaylist();
        jmusichub.displayPlaylists();

        jmusichub.save();
    }
}
