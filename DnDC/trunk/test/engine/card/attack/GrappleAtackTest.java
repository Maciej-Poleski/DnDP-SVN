/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.card.attack;

import engine.card.attack.TotalBonusToAttack;
import engine.card.attack.BaseAttack;
import engine.card.attack.GrappleAttack;
import gui.card.CardPanel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bambucha
 */
public class GrappleAtackTest
{
    static engine.Character main = new engine.Character(new CardPanel());
    static GrappleAttack dupa = new GrappleAttack(main);

    public GrappleAtackTest() 
    {
        main.getStrenght().setValue(16);
        main.getDexterity().setValue(13);
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
    public void testCountAttacksModifier()
    {
        System.out.println("countAttacksModifier");
        GrappleAttack instance = dupa;
        instance.countAttacksModifier();
        assertEquals(instance.atackModifier, new Integer(3));
    }

    @Test
    public void testGetAttacks()
    {
        System.out.println("getAttacks");
        BaseAttack instance = dupa;
        TotalBonusToAttack expResult = new TotalBonusToAttack(new Integer[]{3});
        TotalBonusToAttack result = instance.getAttacks();
        assertEquals(instance.atackModifier, new Integer(3));
        assertArrayEquals(expResult.getMainHand(), result.getMainHand());
    }

}