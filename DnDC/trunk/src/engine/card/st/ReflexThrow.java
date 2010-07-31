package engine.card.st;

import javax.swing.event.ChangeListener;

import engine.card.abilities.AbilityType;

/**
 * Klasa rzutu obronego na refleks
 * 
 * @author bambucha
 */
public class ReflexThrow extends SavingThrow
{

    /**
     * Standardowy konstruktor
     * 
     * @param who
     *            Właściciel rzutu
     * @param view
     *            Widok rzutu
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
