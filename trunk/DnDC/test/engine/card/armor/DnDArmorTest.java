/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package engine.card.armor;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import engine.benefit.Benefit;
import engine.card.bonus.DnDBonusManager;
import engine.item.Value;
import engine.item.armor.Plate;

/**
 * 
 * @author bambucha
 */
public class DnDArmorTest
{
    engine.Character main;
    DnDBonusManager  bonusManager;
    DnDArmor         t;

    Plate            plate;
    Plate            nd;

    public DnDArmorTest()
    {
        main = new engine.Character();
        bonusManager = new DnDBonusManager(main);
        t = new DnDArmor(main, main, bonusManager);
        plate = new Plate("xxx", 1.0, new Value(1, 2, 1, 1), new Benefit[0], 1, 1.0, 1);
        nd = new Plate("xxx", 1.0, new Value(1, 2, 1, 1), new Benefit[0], 1, 1.0, 3);
    }

    @BeforeClass
    public static void dupa()
    {

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
     * Test of getAC method, of class DnDArmor.
     */
    @Test
    public void testGetACDex()
    {
        main.getDexterity().setValue(20);
        System.out.println("getAC");
        DnDArmor instance = t;
        Integer expResult = 15;
        Integer result = instance.getAC();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAC method, of class DnDArmor.
     */
    @Test
    public void testGetACPlate()
    {
        System.out.println("getAC");
        main.getDexterity().setValue(20);
        main.putOn(plate);
        DnDArmor instance = t;
        Integer expResult = 11;
        Integer result = instance.getAC();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAC method, of class DnDArmor.
     */
    @Test
    public void testGetACCPlate()
    {
        System.out.println("getAC");
        main.getDexterity().setValue(20);
        main.putOn(plate);
        DnDArmor instance = t;
        Integer expResult = 11;
        Integer result = instance.getAC();
        assertEquals(expResult, result);
        main.putOn(nd);
        expResult = 13;
        result = instance.getAC();
        assertEquals(expResult, result);

    }

}
