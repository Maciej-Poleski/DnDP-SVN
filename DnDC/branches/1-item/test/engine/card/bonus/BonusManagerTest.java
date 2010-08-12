/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package engine.card.bonus;

import static org.junit.Assert.assertEquals;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.junit.Test;

import engine.Character;
import engine.card.abilities.Abiliti;
import gui.card.CardPanel;

/**
 * 
 * @author bambucha
 */
public class BonusManagerTest
{
    static Abiliti         s = new Abiliti(new ChangeListener()
                             {

                                 @Override
                                 public void stateChanged(ChangeEvent e)
                                 {}
                             });
    static Abiliti         d = new Abiliti(new ChangeListener()
                             {

                                 @Override
                                 public void stateChanged(ChangeEvent e)
                                 {}
                             });
    static Abiliti         w = new Abiliti(new ChangeListener()
                             {

                                 @Override
                                 public void stateChanged(ChangeEvent e)
                                 {}
                             });

    static Character       a = new Character(new CardPanel());
    static DnDBonusManager t = new DnDBonusManager(a);

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

    public BonusManagerTest()
    {}

    @Test
    public void testRegisterAndGetBonus()
    {
        t.registerBonus("s", s);
        t.getBonusHandler("s").addBonus(BonusType.Sacred, 2);
        assertEquals(s.getModifier(), getModifier(2, s));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSecondRegisterException()
    {
        t.registerBonus("s", s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBonsuException()
    {
        t.getBonusHandler("stredfht");
    }

}
