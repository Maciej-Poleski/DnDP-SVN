package engine.card.fleats;

import engine.card.Checkable;
import engine.Character;
/**
 *
 * @author evil, bambucha
 */
public class FleatDependency implements Checkable
{
    private Fleat fleat;

    /**
     * Konstruktor.
     * @param fleat Atut.
     */
    public FleatDependency(Fleat fleat)
    {
        this.fleat = fleat;
    }

    /**
     * Sprawdza czy atut jest dostępny.
     * @param character
     * @return
     */
    @Override
    public boolean check(Character character)
    {
        return character.getCharacterFleat(fleat).getState()==CharacterFleat.State.ENABLED;
    }

}
