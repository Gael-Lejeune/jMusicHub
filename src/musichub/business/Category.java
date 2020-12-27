package business;

/*
 * Nom de classe : Category
 *
 * Description   :
 *
 * Version       : 1.6
 *
 * Date          : 26/12/2020
 *
 * Copyright     : Lejeune Gaël
 */


public enum Category
{
    JEUNESSE("Jeunesse"), ROMAN("Roman"), THEATRE("Theatre"),
    DISCOURS("Discours"), DOCUMENTAIRE("Documentaire");

    private String category;

    /**
     *  Description de la methode
     */
    private Category(String category)
    {
        this.category = category;
    }

    /**
     *  Description de la methode
     */
    public String toString()
    {
        return this.category;
    }
}
