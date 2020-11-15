package business;

public enum Genre
{
    JAZZ("Jazz"), CLASSIQUE("Classique"), HIPHOP("Hip-Hop"),
    ROCK("Rock"), POP("Pop"), RAP("Rap"), METAL("Metal");

    private String type;

    private Genre(String type)
    {
        this.type = titre;
    }

    public String getGenre()
    {
        return this.type;
    }
}
