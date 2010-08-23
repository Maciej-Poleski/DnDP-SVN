/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package engine.card.st;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import engine.card.abilities.AbilityType;

/**
 * 
 * @author bambucha
 */
public class WillThrowTest
{

    static WillThrow test = new WillThrow();

    public WillThrowTest()
    {}

    @Test
    public void testCountModifier()
    {
        assertEquals(AbilityType.WISDOM, test.getAbilityName());
    }

}
