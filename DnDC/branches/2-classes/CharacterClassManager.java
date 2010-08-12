package engine.card.classes;

import java.util.LinkedList;
import java.util.List;

/**
 * Klasa menadżere klas postaci pojedynaczej postaci.
 * 
 * @author bambucha
 */
public class CharacterClassManager
{
    private Character character;
    private List<CharacterClass> classList;
    private Integer level;
    
    /**
     * @param character
     */
    public CharacterClassManager(Character character)
    {
        super();
        this.character = character;
        classList = new LinkedList<CharacterClass>();
    }
    
    public Integer getLevel()
    {
        return level;
    }
}
