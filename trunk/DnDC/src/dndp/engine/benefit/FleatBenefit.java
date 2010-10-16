package dndp.engine.benefit;

import dndp.engine.Character;
import dndp.engine.card.fleats.Fleat;

/**
 * Klasa kapsułkując premię będącą atutem.
 * 
 * @author bambucha
 */
public class FleatBenefit implements Benefit
{
    private Fleat fleat;
    
    
    /**
     * @param fleat
     */
    public FleatBenefit(Fleat fleat)
    {
        this.fleat = fleat;
    }

    /* (non-Javadoc)
     * @see engine.benefit.Benefit#apply(engine.Character)
     */
    @Override
    public void apply(Character benefitTarget)
    {
        benefitTarget.getCharacterFleat(fleat).active();
    }

    /* (non-Javadoc)
     * @see engine.benefit.Benefit#abandon(engine.Character)
     */
    @Override
    public void abandon(Character benefitTarget)
    {
        benefitTarget.getCharacterFleat(fleat).deactive();
    }

}
