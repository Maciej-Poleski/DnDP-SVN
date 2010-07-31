package engine.card.st;

import javax.swing.event.ChangeListener;

import engine.card.abilities.AbilityType;

/**
 * Klasa rzutu na wytwałość
 * 
 * @author bambucha
 */
public class FortitudeThrow extends SavingThrow
{

    /**
     * Standardowy kostruktor
     * 
     * @param who
     *            Postać
     * @param view
     *            Widok rzutu
     * @see engine.card.st.SavingThrow
     */
    public FortitudeThrow(ChangeListener view)
    {
        super(view);
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.STRENGHT;
    }
}
