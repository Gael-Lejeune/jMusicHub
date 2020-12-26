package business;

/*
 * Nom de classe : Language
 *
 * Description   :
 *
 * Version       : 1.6
 *
 * Date          : 26/12/2020
 *
 * Copyright     : Lejeune Gaël
 */


public enum Language
{
    FRANCAIS("Français"), ANGLAIS("Anglais"), ITALIEN("Italien"),
    ESPAGNOL("Espagnol"), ALLEMAND("Allemand");

    private String language;

    /**
     *  Description de la methode
     */
    private Language(String language)
    {
        this.language = language;
    }

    /**
     *  Description de la methode
     */
    public String toString()
    {
        return this.language;
    }
}
