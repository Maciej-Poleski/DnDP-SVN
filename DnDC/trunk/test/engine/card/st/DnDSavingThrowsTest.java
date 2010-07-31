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
public class DnDSavingThrowsTest
{

    static CardPanel p = new CardPanel();
    static engine.Character d = new engine.Character(p);
    static DnDSavingThrows test = new DnDSavingThrows(d,p.getSavingThrowsPanel());

    public DnDSavingThrowsTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Test
    public void testGetForttiude()
    {
        System.out.println("getForttiude");
        DnDSavingThrows instance = test;
        SavingThrow result = instance.getForttiude();
        assertTrue(result instanceof FortitudeThrow);
    }

    @Test
    public void testGetReflex()
    {
        System.out.println("getReflex");
        DnDSavingThrows instance = test;
        SavingThrow result = instance.getReflex();
        assertTrue(result instanceof ReflexThrow);
    }

    @Test
    public void testGetWill()
    {
        System.out.println("getWill");
        DnDSavingThrows instance = test;
        SavingThrow result = instance.getWill();
        assertTrue(result instanceof WillThrow);
    }

    @Test
    public void testGetSpellResistance()
    {
        System.out.println("getSpellResistance");
        DnDSavingThrows instance = test;
        Double expResult = 0.0;
        Double result = instance.getSpellResistance();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetSpellResistance()
    {
        System.out.println("setSpellResistance");
        Double newValue = 2.5;
        DnDSavingThrows instance = test;
        instance.setSpellResistance(newValue);
        assertEquals(instance.getSpellResistance(), newValue);
    }

    @Test(expected=NullPointerException.class)
    public void testNullExceptionSetSpellResistance()
    {
        System.out.println("setSpellResistance");
        Double newValue = null;
        DnDSavingThrows instance = test;
        instance.setSpellResistance(newValue);
        assertEquals(instance.getSpellResistance(), newValue);
    }

}