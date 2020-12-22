package business;

public enum Language
{
    FRANCAIS("Français"), ANGLAIS("Anglais"), ITALIEN("Italien"),
    ESPAGNOL("Espagnol"), ALLEMAND("Allemand");

    private String language;

    private Language(String language)
    {
        this.language = language;
    }

    public String getLangue()
    {
        return this.language;
    }
}
