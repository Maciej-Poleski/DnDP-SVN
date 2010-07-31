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
public class ReflexThrowTest {

    static CardPanel p = new CardPanel();
    static engine.Character t = new engine.Character(new CardPanel());
    static ReflexThrow test = new ReflexThrow(t,p.getSavingThrowsPanel().getReflexThrow());
    public ReflexThrowTest() {
        t.getDexterity().setValue(22);
    }

    @Test
    public void testCountModifier()
    {
        System.out.println("countModifier");
        ReflexThrow instance = test;
        Integer expResult = 6;
        Integer result = instance.countModifier();
        assertEquals(expResult, result);

    }

}