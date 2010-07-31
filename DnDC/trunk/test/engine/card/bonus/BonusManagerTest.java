/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.card.bonus;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import engine.card.abilities.Abiliti;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testGetInstance()
    {
        assertNotNull(DnDBonusManager.getInstance());
    }

    @Test
    public void testRegisterAndGetBonusBonus()
    {
        Integer bonus = 2;
        DnDBonusManager.getInstance().registerBonus("strenght", s);
        DnDBonusManager.getInstance().registerBonus("dexterity", d);
        DnDBonusManager.getInstance().registerBonus("wisdom", w);
        DnDBonusManager.getInstance().getBonusHandler("strenght").addBonus(BonusType.Luck, bonus);
        DnDBonusManager.getInstance().getBonusHandler("strenght").addBonus(BonusType.Competence, bonus);
        DnDBonusManager.getInstance().getBonusHandler("dexterity").addBonus(BonusType.Luck, bonus);;
        DnDBonusManager.getInstance().getBonusHandler("wisdom").addBonus(BonusType.Luck, bonus);;
        assertEquals(getModifier(2*bonus, s),s.getModifier());
        assertEquals(getModifier(bonus, d),d.getModifier());
        assertEquals(getModifier(bonus, w),w.getModifier());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testSecondRegisterException()
    {
        Integer bonus = 2;
        DnDBonusManager.getInstance().registerBonus("strenght", s);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testGetBonsuException()
    {
        Integer bonus = 2;
        DnDBonusManager.getInstance().getBonusHandler("stredfht").addBonus(BonusType.Luck, bonus);
    }

}