package engine.check;

import engine.Character;
import engine.card.fleats.CharacterFleat.State;
import engine.card.fleats.Fleat;

/**
 * Sprawdza czy postać posiada wymagany atut.
 * 
 * @author bambucha
 */
public class FleatCheck implements Checkable
{
    private final Fleat fleat;
    
    /**
     * @param fleat
     */
    public FleatCheck(Fleat fleat)
    {
        super();
        this.fleat = fleat;
    }



    /* (non-Javadoc)
     * @see engine.check.Checkable#check(engine.Character)
     */
    @Override
    public boolean check(Character character)
    {
        return character.getCharacterFleat(fleat).getState() == State.ENABLED;
    }
}
