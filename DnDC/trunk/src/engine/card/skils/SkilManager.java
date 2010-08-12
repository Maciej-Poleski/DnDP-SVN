package engine.card.skils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import engine.Dice;
import engine.item.BasicEquipmentManager;

/**
 * Klasa opiekująca się umiejetnoscieami bohaterów
 * 
 * @par TODO Dodanie wyjątku informującą że test jest niemożliwy. Miejsca w kodzie oznaczone FIXME.<br/>
 *      Pobieranie umiejętności z bazy danych w konstruktorze.<br/>
 * 
 * @author bambucha
 */
public class SkilManager
{
    private BasicEquipmentManager      baseEquipmentManager;
    private Map<String, CharacterSkil> skilSet;

    // Przyśpieszenie zapytania po nazwie umiejętności. Dodanie klucza powinno
    // wyglądać put(CharacterSkil.getSkil.getName,CharacterSkill)

    public SkilManager(BasicEquipmentManager main)
    {
        this.baseEquipmentManager = main;
        this.skilSet = new HashMap<String, CharacterSkil>();
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
        if(skilToTest.getSkil().isTrain() && skilToTest.getRank() == 0)
            throw new UnsupportedOperationException(); // FIXME
        if(skilToTest.getSkil().isArmorInterrupt())
            return Dice.D20.throwTheDice() + skilToTest.getRank() + skilToTest.getBonus() - baseEquipmentManager.getCurrentArmorPently();
        return Dice.D20.throwTheDice() + skilToTest.getRank() + skilToTest.getBonus();
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
        if(t != null)
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
