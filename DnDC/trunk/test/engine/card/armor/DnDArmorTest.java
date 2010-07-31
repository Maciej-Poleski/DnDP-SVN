/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.card.armor;

import org.junit.Before;
import gui.card.CardPanel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bambucha
 */
public class DnDArmorTest
{
    static engine.Character main;
    static DnDArmor t;
    
    public DnDArmorTest()
    {
        
    }

    @BeforeClass
    public static void dupa()
    {
        main = new engine.Character(new CardPanel());
        t = new DnDArmor(main);
    }

    /**
     * Test of getArmorACBonus method, of class DnDArmor.
     */
    @Test
    public void testGetArmorACBonus()
    {
        System.out.println("getArmorACBonus");
        DnDArmor instance = t;
        Integer expResult = 0;
        Integer result = instance.getArmorACBonus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getShieldACBonus method, of class DnDArmor.
     */
    @Test
    public void testGetShieldACBonus()
    {
        System.out.println("getShieldACBonus");
        DnDArmor instance = t;
        Integer expResult = 0;
        Integer result = instance.getShieldACBonus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDextirityACBonus method, of class DnDArmor.
     */
    @Test
    public void testGetDextirityACBonus()
    {
        System.out.println("getDextirityACBonus");
        DnDArmor instance = t;
        Integer result = instance.getDextirityACBonus();
        assertEquals(main.getDexterity().getModifier(), result);
    }

    /**
     * Test of getSizeACBonus method, of class DnDArmor.
     */
    @Test
    public void testGetSizeACBonus()
    {
        System.out.println("getSizeACBonus");
        DnDArmor instance = t;
        Integer expResult = 0;
        Integer result = instance.getSizeACBonus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDeflectionACBonus method, of class DnDArmor.
     */
    @Test
    public void testGetDeflectionACBonus()
    {
        System.out.println("getDeflectionACBonus");
        DnDArmor instance = t;
        Integer expResult = 0;
        Integer result = instance.getDeflectionACBonus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAC method, of class DnDArmor.
     */
    @Test
    public void testGetAC()
    {
        System.out.println("getAC");
        DnDArmor instance = t;
        Integer expResult = 10;
        Integer result = instance.getAC();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProficiencyACBonus method, of class DnDArmor.
     */
    @Test
    public void testGetProficiencyACBonus()
    {
        System.out.println("getProficiencyACBonus");
        DnDArmor instance = t;
        Integer expResult = 0;
        Integer result = instance.getProficiencyACBonus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setArmorACBonus method, of class DnDArmor.
     */
    @Test
    public void testSetArmorACBonus()
    {
        System.out.println("setArmorACBonus");
        Integer newValue = 2;
        DnDArmor instance = t;
        instance.setArmorACBonus(newValue);
    }

    /**
     * Test of setArmorACBonus method, of class DnDArmor.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetArmorACBonusException()
    {
        System.out.println("setArmorACBonusException");
        Integer newValue = -2;
        DnDArmor instance = t;
        instance.setArmorACBonus(newValue);
        assertEquals(newValue, instance.getArmorACBonus());
    }

    /**
     * Test of setShieldACBonus method, of class DnDArmor.
     */
    @Test
    public void testSetShieldACBonus()
    {
        System.out.println("setShieldACBonus");
        Integer newValue = 2;
        DnDArmor instance = t;
        instance.setShieldACBonus(newValue);
        assertEquals(newValue, instance.getShieldACBonus());

    }

    /**
     * Test of setShieldACBonus method, of class DnDArmor.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetShieldACBonusException()
    {
        System.out.println("setShieldACBonusException");
        Integer newValue = -2;
        DnDArmor instance = t;
        instance.setShieldACBonus(newValue);

    }

    /**
     * Test of setDeflectionACBonus method, of class DnDArmor.
     */
    @Test
    public void testSetDeflectionACBonus()
    {
        System.out.println("setDeflectionACBonus");
        Integer newValue = 2;
        DnDArmor instance = t;
        instance.setDeflectionACBonus(newValue);
        assertEquals(newValue, instance.getDeflectionACBonus());
        newValue=4;
        instance.setDeflectionACBonus(newValue);
        assertEquals(newValue, instance.getDeflectionACBonus());
    }

    /**
     * Test of setDeflectionACBonus method, of class DnDArmor.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetDeflectionACBonusException()
    {
        System.out.println("setDeflectionACBonusException");
        Integer newValue = -2;
        DnDArmor instance = t;
        instance.setDeflectionACBonus(newValue);
    }



    /**
     * Test of setProficiencyACBonus method, of class DnDArmor.
     */
    @Test
    public void testSetProficiencyACBonus()
    {
        System.out.println("setProficiencyACBonus");
        Integer newValue = 2;
        DnDArmor instance = t;
        instance.setProficiencyACBonus(newValue);
        assertEquals(newValue, instance.getProficiencyACBonus());
        newValue = 4;
        instance.setProficiencyACBonus(newValue);
        assertEquals(newValue, instance.getProficiencyACBonus());

    }

    /**
     * Test of setProficiencyACBonus method, of class DnDArmor.
     */
    @Test (expected=IllegalArgumentException.class)
    public void testSetProficiencyACBonusExcepttion()
    {
        System.out.println("setProficiencyACBonusException");
        Integer newValue = -2;
        DnDArmor instance = t;
        instance.setProficiencyACBonus(newValue);
    }
}