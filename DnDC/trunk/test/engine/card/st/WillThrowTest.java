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
public class WillThrowTest {

    static CardPanel p = new CardPanel();
    static engine.Character t = new engine.Character(new CardPanel());
    static WillThrow test = new WillThrow(t,p.getSavingThrowsPanel().getWillThrow());
    public WillThrowTest() 
    {
        t.getWisdom().setValue(16);
    }

    @Test
    public void testCountModifier()
    {
        System.out.println("countModifier");
        WillThrow instance = test;
        Integer expResult = 3;
        Integer result = instance.countModifier();
        assertEquals(expResult, result);
    }

}