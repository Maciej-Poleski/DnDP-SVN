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
public class ReflexThrowTest
{
    static ReflexThrow test = new ReflexThrow(null);

    public ReflexThrowTest()
    {

    }

    @Test
    public void testCountModifier()
    {
        assertEquals(AbilityType.DEXTERITY, test.getAbilityName());

    }

}
