package engine.card.fleats;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import engine.Character;
import engine.benefit.Benefit;
import engine.card.Checkable;

/**
 * Klasa zajmująca się zarządzaniem atutami.
 * Również wszystkimi obowiązkami wynikającymi z piastującej funkcji. 
 * @author evil, bambucha
 */
public class DnDCharacterFleatManager implements CharacterFleatManager
{
    private Map<Fleat, CharacterFleat> characterFleatsMapping;
    private Character                  character;

    /**
     * Konstruktor.
     * 
     * @param character
     *            Postać
     */
    public DnDCharacterFleatManager(Character character)
    {
        this.character = character;
        characterFleatsMapping = new HashMap<Fleat, CharacterFleat>();

    }

    /**
     * Pobiera listę atutów.
     * 
     * @return
     */
    @Override
    public Collection<CharacterFleat> getAllCharacterFleats()
    {
        return characterFleatsMapping.values();
    }

    /**
     * Zwraca CharacterFleat dla danego Fleat
     * 
     * @param key
     * @return
     */
    @Override
    public CharacterFleat getCharacterFleat(Object key)
    {
        return characterFleatsMapping.get(key);
    }
    
    public boolean checkFleat(Fleat fleat)
    {
        boolean result = true;
        for (Checkable c : fleat.getDependency())
            result = result && c.check(character);
        return result;
    }
    
    public void setFleatBenefit(Fleat fleat)
    {
        for(Benefit b : fleat.getBenefits())
            b.apply(character);
    }
    
    public void unsetFleatBenefit(Fleat fleat)
    {
        for(Benefit b : fleat.getBenefits())
            b.abandon(character);
    }

    /**
     * Aktualizuje wszystkie atuty.
     */
    public void update()
    {
        for (CharacterFleat characterFleat : characterFleatsMapping.values())
            characterFleat.isPossible();
    }

}
