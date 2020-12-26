package business;

/*
 * Nom de classe : Genre
 *
 * Description   :
 *
 * Version       : 1.6
 *
 * Date          : 26/12/2020
 *
 * Copyright     : Lejeune Gaël
 */


public enum Genre
{
    JAZZ("Jazz"), CLASSIQUE("Classique"), HIPHOP("Hip-Hop"),
    ROCK("Rock"), POP("Pop"), RAP("Rap"), METAL("Metal");

    private String genre;

    /**
     *  Description de la methode
     */
    private Genre(String genre)
    {
        this.genre = genre;
    }

    /**
     *  Description de la methode
     */
    public String toString()
    {
        return this.genre;
    }
}
