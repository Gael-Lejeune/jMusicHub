package business;

public enum Langue{
    FRANCAIS("Français"),
    ANGLAIS("Anglais"),
    ITALIEN("Italien"),
    ESPAGNOL("Espagnol"),
    ALLEMAND("Allemand");

    private String titre;

    private Langue(String titre){
        this.titre = titre;
    }

    public String getTitre(){
        return this.titre;
    }

}
