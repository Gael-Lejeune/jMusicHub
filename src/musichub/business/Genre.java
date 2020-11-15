package business;

public enum Genre{
    JAZZ("Jazz"),
    CLASSIQUE("Classique"),
    HIPHOP("Hip-Hop"),
    ROCK("Rock"),
    POP("Pop"),
    RAP("Rap");

    private String titre;

    private Genre(String titre){
        this.titre = titre;
    }

    public String getTitre(){
        return this.titre;
    }

};
