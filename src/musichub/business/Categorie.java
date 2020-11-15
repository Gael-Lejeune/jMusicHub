package business;

public enum Categorie{
    JEUNESSE("Jeunesse"),
    ROMAN("Roman"),
    THEATRE("Théâtre"),
    DISCOURS("Discours"),
    DOCUMENTAIRE("Documentaire");

    private String titre;

    private Categorie(String titre){
        this.titre = titre;
    }

    public String getTitre(){
        return this.titre;
    }

};
