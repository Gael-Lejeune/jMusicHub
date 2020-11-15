package business;

public enum Categorie
{
    JEUNESSE("Jeunesse"), ROMAN("Roman"), THEATRE("Théâtre"),
    DISCOURS("Discours"), DOCUMENTAIRE("Documentaire");

    private String type;

    private Categorie(String type)
    {
        this.type = type;
    }

    public String getTitre()
    {
        return this.type;
    }
}
