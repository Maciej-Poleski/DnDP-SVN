package engine.card.fleats;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import engine.Character;

/**
 *
 * @author evil, bambucha
 */
public class DnDCharacterFleatManager implements CharacterFleatManager
{
    private Map<Fleat,CharacterFleat> characterFleatsMapping;
    private Character character;

    /**
     * Konstruktor.
     * @param character Postać
     */
    public DnDCharacterFleatManager(Character character)
    {
        this.character = character;
        characterFleatsMapping=new HashMap<Fleat, CharacterFleat>();
        
    }

    /**
     * Pobiera listę atutów.
     * @return
     */
    @Override
    public Collection<CharacterFleat> getAllCharacterFleats()
    {
        return characterFleatsMapping.values();
    }

    /**
     * Zwraca CharacterFleat dla danego Fleat
     * @param key
     * @return
     */
    @Override
    public CharacterFleat getCharacterFleat(Object key)
    {
        return characterFleatsMapping.get(key);
    }

    /**
     * Zwraca postać zarejestrowaną w tym menadżerze.
     * @return
     */
    @Override
    public Character getCharacter()
    {
        return character;
    }

    /**
     * Aktualizuje wszystkie atuty.
     */
    public void update()
    {
        for(CharacterFleat characterFleat:characterFleatsMapping.values())
            characterFleat.isPossible();
    }

}
