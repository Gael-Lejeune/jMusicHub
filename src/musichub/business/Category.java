package business;

public enum Category
{
    JEUNESSE("Jeunesse"), ROMAN("Roman"), THEATRE("Théâtre"),
    DISCOURS("Discours"), DOCUMENTAIRE("Documentaire");

    private String type;

    private Category(String type)
    {
        this.type = type;
    }

    public String getTitle()
    {
        return this.type;
    }
}
