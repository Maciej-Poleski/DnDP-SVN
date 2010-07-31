package engine.card.st;

import engine.Character;
import engine.card.abilities.AbilityType;
import javax.swing.event.ChangeListener;

/**
 * Klasa rzutu obronego na refleks
 * @author bambucha
 */
public class ReflexThrow extends SavingThrow
{


    /**
     * Standardowy konstruktor
     * @param who Właściciel rzutu
     * @param view Widok rzutu
     */
    public ReflexThrow(ChangeListener view)
    {
        super(view);
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.DEXTERITY;
    }

}
