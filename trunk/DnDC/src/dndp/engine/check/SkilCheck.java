package dndp.engine.check;

import dndp.engine.Character;
import dndp.engine.card.skils.Skil;

/**
 * Sprawdza czy postać ma wystarczającą ilośc rank w danej umiejętności.
 * 
 * @author bambucha
 */
public class SkilCheck implements Checkable
{
    private final Skil skil;
    private final Integer rank;
    
    /**
     * @param skil
     * @param rank
     */
    public SkilCheck(Skil skil, Integer rank)
    {
        super();
        this.skil = skil;
        this.rank = rank;
    }



    /* (non-Javadoc)
     * @see engine.check.Checkable#check(engine.Character)
     */
    @Override
    public boolean check(Character character)
    {
        return character.getSkil(skil.getName()).getRank() >= rank;
    }

}
