/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.card.bonus;

import static org.junit.Assert.assertEquals;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.junit.Test;

import engine.Character;
import engine.card.abilities.Abiliti;

/**
 *
 * @author bambucha
 */
public class BonusManagerTest
{
    Abiliti s = new Abiliti(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e){        }
    });
    Abiliti d = new Abiliti(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e){      }
    });
    Abiliti w = new Abiliti(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e){       }
    });
    
    static Character a = new Character(null);
    static DnDBonusManager t = new DnDBonusManager(a);

    /**
     * Zwraca modyfilator jaki powinnien mieć atrybiut, przyz konkretynym bonusie.
     * @param bonus Bonus
     * @param t Atrubut
     * @return Modyfikator
     */
    private Integer getModifier(Integer bonus,Abiliti t)
    {
        return new Integer( ((bonus - t.getValue()) +10)/2);
    }

    public BonusManagerTest()
    {
    }

    @Test
    public void testRegisterAndGetBonusBonus()
    {
        Integer bonus = 2;
        t.registerBonus("strenght", s);
        t.registerBonus("dexterity", d);
        t.registerBonus("wisdom", w);
        t.getBonusHandler("strenght").addBonus(BonusType.Luck, bonus);
        t.getBonusHandler("strenght").addBonus(BonusType.Competence, bonus);
        t.getBonusHandler("dexterity").addBonus(BonusType.Luck, bonus);;
        t.getBonusHandler("wisdom").addBonus(BonusType.Luck, bonus);;
        assertEquals(getModifier(2*bonus, s),s.getModifier());
        assertEquals(getModifier(bonus, d),d.getModifier());
        assertEquals(getModifier(bonus, w),w.getModifier());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSecondRegisterException()
    {
        t.registerBonus("strenght", s);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetBonsuException()
    {
        Integer bonus = 2;
        t.getBonusHandler("stredfht").addBonus(BonusType.Luck, bonus);
    }

}