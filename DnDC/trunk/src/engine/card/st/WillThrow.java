package engine.card.st;

import engine.Character;
import engine.card.abilities.AbilityType;
import javax.swing.event.ChangeListener;

/**
 * Klasa rzutu obronego na Wolę.
 * @author bambucha
 */
public class WillThrow extends SavingThrow
{

    /**
     * Standardowy konstruktor
     * @see engine.card.st.SavingThrow
     * @param view Widok rzutu obronnego.
     */
    public WillThrow(ChangeListener view)
    {
        super(view);
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.WISDOM;
    }

}
