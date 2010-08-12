package engine.card.description;

import engine.PersonalityTypes;

/**
 * Klasa reperzętująca bóstwo.
 * 
 * @author bambucha
 */
public class God
{
    private String           name;
    private String           description;
    private PersonalityTypes character;

    // Konstruktor stworzony na potrzeby testów opisu będą osobne testy
    public God()
    {
        name = "pelor";
        description = "strong";
        character = PersonalityTypes.ND;
    }

    /**
     * @par TODO napisać wywołanie do bazy danych
     * @param name
     */
    public God(String name)
    {

    }

    public String getName()
    {
        return this.name;
    }

    public PersonalityTypes getCharacter()
    {
        return character;
    }

    public String getDescription()
    {
        return description;
    }

}
