package engine.card.st;

import engine.Character;
import engine.card.abilities.AbilityType;
import javax.swing.event.ChangeListener;

/**
 * Klasa rzutu na wytwałość
 * @author bambucha
 */
public class FortitudeThrow extends SavingThrow
{

    /**
     * Standardowy kostruktor
     * @param who Postać
     * @param view Widok rzutu
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
