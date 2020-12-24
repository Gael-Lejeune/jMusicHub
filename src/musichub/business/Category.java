package business;

public enum Category
{
    JEUNESSE("Jeunesse"), ROMAN("Roman"), THEATRE("Théâtre"),
    DISCOURS("Discours"), DOCUMENTAIRE("Documentaire");

    private String category;

    private Category(String category)
    {
        this.category = category;
    }

    public String toString()
    {
        return this.category;
    }
}
