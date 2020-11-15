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

    public String getLangue()
    {
        return this.langue;
    }
}
