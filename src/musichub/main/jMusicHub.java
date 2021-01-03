package main;

import business.*;
import util.*;
import org.w3c.dom.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;

import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


/**
 *
 * explication supplémentaire si nécessaire
 *
 * @version 1.0
 *
 * @see UneAutreClasse
 * @author Jean Michel D.
 */
public class jMusicHub{

    private XMLReaderWriter xmlEditor;
    private LinkedList<Playlist> playlists;
    private LinkedList<Album> albums;
    private LinkedList<Audio> elements;

    /**
    *  Description de la methode
    */
    public jMusicHub()
    {
        this.xmlEditor = new XMLReaderWriter();
        this.playlists = this.xmlEditor.readPlaylistXML("files/playlists.xml");
        this.albums = this.xmlEditor.readAlbumXML("files/albums.xml");
        this.elements = this.xmlEditor.readElementXML("files/elements.xml");
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
              date = albums.get(i).getRealeaseDate.split("/");
              date2 = albums.get(i).getReleaseDate.split("/");
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
      LinkedList<Audio> song = new LinkedList<Audio>();
      int node[], mem;
      boolean isASong = true;
      for(int i=0;i<elements.size()-1;i++)
      {
        try {
            this.elements.get(i).getGenre();
            isASong = true;
        } catch(IOException e) {
            isASong = false
        }
        if(isASong)
        {
            song.add(this.elements.get(i));
        }
      }
      for(int i=0;i<song.size()-1;i++)
      {
          node[i] = i;
      }
      for(int j=0;j<song.size()-1;j++)
      {
        for(int i=0;i<song.size()-2;i++)
        {    
          if(song.get(i).getGenre.compareTo(song.get(i+1).getGenre)>0)
          {
            mem = node[i];
            node[i] = node[i+1];
            node[i+1] = mem;
          }
        }
      }
      for(int i=0;i<song.size()-1;i++)
      {
          System.out.println(song.get(node[i]).toString());
      }
    }

    /**
    *  Description de la methode
    */
    public void displayPlaylists() {
        System.out.println("Existing playlists :\n");
        for (int i = 0; i < playlists.size() ; i++) {
            System.out.println(playlists.get(i) + "\n");
        }
    }

    /**
    *  Description de la methode
    */
    public void displayAlbums() {
        System.out.println("\n\n\nExisting albums :\n");
        for (int i = 0; i < albums.size() ; i++) {
            System.out.println(albums.get(i) + "\n");
        }
    }

    /**
    *  Description de la methode
    */
    public void displayElements() {
        System.out.println("\n\n\nExisting elements :\n");
        for (int i = 0; i < elements.size() ; i++) {
            System.out.println(elements.get(i) + "\n");
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
          if(audioBook.get(i).getAuthor.compareTo(audioBook.get(i+1).getAuthor)>0)
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
    *  Description de la methode
    */
    public void addSongToAlbum() {
        Scanner scan = new Scanner(System.in);
        LinkedList<Audio> songs = new LinkedList<Audio>();
        int number = 0;
        System.out.println("Album's name :");
        String nameAlbum = scan.nextLine();
        System.out.println("Song's name :");
        String nameSong = scan.nextLine();
        for(int i=0;i<this.elements.size()-1;i++)
        {
            if(this.elements.get(i).getTitle().equals(nameSong))
            {
                songs.add(elements);
            }
        }
        if(songs.size()>1)
        {
            for(int i=0;i<songs.size()-1;i++)
            {
                System.out.println(i+"- "+songs.get(i).getTitle());
            }
            do
            {
                System.out.println("Select the right music with number :");
                number = Integer.parseInt(scan.nextLine());
            }while(number<0||number>(songs.size()-1));
        }
        for(int i=0;i<this.albums.size()-1;i++);
        {
            if(this.albums.get(i).getTitle().equals(nameAlbum))
            {
                this.albums.get(i).addSong(songs.get(number));
            }
        }
    }

    /**
    *  Description de la methode
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
        if (audios.size()==0) {
            System.out.println("Empty playlist, abort creation.");
            return;
        }
        this.playlists.add(new Playlist(name, uuid, audios));
    }

    /**
    *  Description de la methode
    */
    public void deletePlaylist(String name) {
        for (int i = 0; i < this.playlists.size(); i++) {
            if (this.playlists.get(i).getName().equals(name)) {
                this.playlists.remove(i);
            }
        }
    }

    /**
    *  Description de la methode
    */
    public void save() {
        this.xmlEditor.writeElementXML("files/elements1.xml", elements);
        this.xmlEditor.writeAlbumXML("files/albums1.xml", albums);
        this.xmlEditor.writePlaylistXML("files/playlists1.xml", playlists);
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
    *  Description de la methode
    */
    public static void main(String[] args) {
        System.out.println("\n\nWelcome in jMusicHub,");
        System.out.println("Reading library...\n\n");
        jMusicHub jmusichub = new jMusicHub();

        // jmusichub.displayPlaylists();
        // jmusichub.displayAlbums();
        // jmusichub.displayElements();
        // jmusichub.deletePlaylist("MaPlaylist3");
        jmusichub.displayElements();
        jmusichub.displayPlaylists();
        jmusichub.createPlaylistFromExisting();
        jmusichub.displayPlaylists();

        jmusichub.save();
    }
}
