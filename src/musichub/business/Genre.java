package business;

public enum Genre
{
    JAZZ("Jazz"), CLASSIQUE("Classique"), HIPHOP("Hip-Hop"),
    ROCK("Rock"), POP("Pop"), RAP("Rap"), METAL("Metal");

    private String genre;

    private Genre(String genre)
    {
        this.genre = genre;
    }

    public String toString()
    {
        return this.genre;
    }
}
