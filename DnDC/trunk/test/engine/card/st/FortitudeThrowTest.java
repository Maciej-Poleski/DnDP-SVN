/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.card.st;

import gui.card.CardPanel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bambucha
 */
public class FortitudeThrowTest {

    static CardPanel p = new CardPanel();
    static engine.Character t = new engine.Character(new CardPanel());
    static FortitudeThrow test = new FortitudeThrow(t,p.getSavingThrowsPanel().getFortitudeThrow());
    public FortitudeThrowTest() {
        t.getStrenght().setValue(12);
    }

    @Test
    public void testCountModifier()
    {
        System.out.println("countModifier");
        FortitudeThrow instance = test;
        Integer expResult = 1;
        Integer result = instance.countModifier();
        assertEquals(expResult, result);
    }

}