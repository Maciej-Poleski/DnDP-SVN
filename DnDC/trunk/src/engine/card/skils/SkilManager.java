package engine.card.skils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import engine.Character;
import engine.Dice;
import engine.card.abilities.AbilityType;

/**
 * Klasa opiekująca się umiejetnoscieami bohaterów
 * 
 * @par TODO Dodanie wyjątku informującą że test jest niemożliwy. Miejsca w
 *      kodzie oznaczone FIXME.<br/>
 *      Pobieranie umiejętności z bazy danych w konstruktorze.<br/>
 * @author bambucha
 */
public class SkilManager
{
    private Character                  main;
    private Map<String, CharacterSkil> skilSet = new HashMap<String, CharacterSkil>();

    // Przyśpieszenie zapytania po nazwie umiejętności. Dodanie klucza powinno
    // wyglądać put(CharacterSkil.getSkil.getName,CharacterSkill)

    public SkilManager(Character main)
    {
        this.main = main;
    }

    /**
     * Funkcja zwraca modyfikatr od atrybutu do umijętności.
     * 
     * @param arg
     *            Nazwa atrybutu
     * @return Wartość modyfikatora
     */
    private int getAbilitiModifier(AbilityType arg)
    {
        switch (arg)
        {
            case STRENGHT:
                return main.getStrenght().getModifier();
            case DEXTERITY:
                return main.getDexterity().getModifier();
            case CONSTRUCTION:
                return main.getConstitution().getModifier();
            case INTELLIGENCE:
                return main.getInteligence().getModifier();
            case WISDOM:
                return main.getWisdom().getModifier();
            case CHARISMA:
                return main.getCharisma().getModifier();
            default:
                return 0;
        }
    }

    /**
     * Wykonuje test danej umiejętności.
     * 
     * @param skilToTest
     *            Umiejętnośc do testowania
     * @return Wynikt testu
     */
    private Integer testSkil(CharacterSkil skilToTest)
    {
        if (skilToTest.getSkil().isTrain() && skilToTest.getRank() == 0)
            throw new UnsupportedOperationException(); // FIXME
        if (skilToTest.getSkil().isArmorInterrupt())
            return Dice.D20.throwTheDice()
                    + skilToTest.getRank()
                    + skilToTest.getBonus()
                    + getAbilitiModifier(skilToTest.getSkil()
                            .getAbilitiModifier())
                    - main.getEq().getArmor().getArmorPenalty();
        return Dice.D20.throwTheDice() + skilToTest.getRank()
                + skilToTest.getBonus()
                + getAbilitiModifier(skilToTest.getSkil().getAbilitiModifier());
    }

    /**
     * Wykonuje test umijętności, wyszukując ją wg nazwy.
     * 
     * @param name
     * @return
     */
    public Integer testSkil(String name)
    {
        CharacterSkil t = skilSet.get(name);
        if (t != null)
            return testSkil(t);
        else
            throw new UnsupportedOperationException(); // FIXME
    }

    /**
     * Zwraca set z nazwami umiejętności.
     * 
     * @see java.util.Map
     * @return
     */
    public Set<String> getSkilNameSet()
    {
        return skilSet.keySet();
    }

}
