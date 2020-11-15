package business;

public enum Langue
{
    FRANCAIS("Français"), ANGLAIS("Anglais"), ITALIEN("Italien"),
    ESPAGNOL("Espagnol"), ALLEMAND("Allemand");

    private String langue;

    private Langue(String langue)
    {
        this.langue = langue;
    }

    public String getLangue(String titre)
    {
        return this.langue;
    }
}
