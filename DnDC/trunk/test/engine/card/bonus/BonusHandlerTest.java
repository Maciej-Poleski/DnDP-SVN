/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package engine.card.bonus;

import static org.junit.Assert.assertEquals;
import engine.card.abilities.Abiliti;
import gui.card.CardPanel;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.junit.Test;

/**
 * Z racji że w zorze określającym modyfikator jest użuta podłoga( nie formalnie) to określenie wartości staje się cięższe.
 * 
 * @author bambucha
 */
public class BonusHandlerTest
{
    engine.Character x    = new engine.Character(new CardPanel());
    Abiliti          t    = new Abiliti(new ChangeListener()
                          {
                              @Override
                              public void stateChanged(ChangeEvent e)
                              {}
                          });
    BonusHandler     test = new BonusHandler(t, x);

    public BonusHandlerTest()
    {

    }

    /**
     * Zwraca modyfilator jaki powinnien mieć atrybiut, przyz konkretynym bonusie.
     * 
     * @param bonus
     *            Bonus
     * @param t
     *            Atrubut
     * @return Modyfikator
     */
    private Integer getModifier(Integer bonus, Abiliti t)
    {
        return new Integer(((bonus - t.getValue()) + 10) / 2);
    }

    @Test
    public void testAddBonus()
    {
        Integer bonus1 = 3;
        Integer bonus2 = 5;
        Integer bonus3 = 1;
        test.addBonus(BonusType.Morale, bonus3);
        test.addBonus(BonusType.Enhancement, bonus2);
        assertEquals(getModifier(bonus3 + bonus2, t), t.getModifier());
        test.addBonus(BonusType.Luck, bonus1);
        assertEquals(getModifier(bonus3 + bonus2 + bonus1, t), t.getModifier());

    }

    @Test
    public void testRemoveBonus()
    {
        Integer bonus1 = 3;
        Integer bonus2 = 5;
        Integer bonus3 = 1;
        test.addBonus(BonusType.Morale, bonus3);
        test.addBonus(BonusType.Enhancement, bonus2);
        assertEquals(getModifier(bonus3 + bonus2, t), t.getModifier());
        test.addBonus(BonusType.Luck, bonus1);
        assertEquals(getModifier(bonus3 + bonus2 + bonus1, t), t.getModifier());
        test.removeBonus(BonusType.Morale, bonus3);
        assertEquals(getModifier(bonus2 + bonus1, t), t.getModifier());
        test.removeBonus(BonusType.Luck, bonus1);
        assertEquals(getModifier(bonus2, t), t.getModifier());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveBonusException()
    {
        Integer bonus1 = 3;
        Integer bonus2 = 5;
        Integer bonus3 = 1;
        test.addBonus(BonusType.Morale, bonus3);
        test.addBonus(BonusType.Enhancement, bonus2);
        assertEquals(getModifier(bonus3 + bonus2, t), t.getModifier());
        test.addBonus(BonusType.Luck, bonus1);
        assertEquals(getModifier(bonus3 + bonus2 + bonus1, t), t.getModifier());
        test.removeBonus(BonusType.Alchemical, bonus3);
        assertEquals(getModifier(bonus2 + bonus1, t), t.getModifier());
        test.removeBonus(BonusType.Luck, bonus1);
        assertEquals(getModifier(bonus2, t), t.getModifier());
    }

}
