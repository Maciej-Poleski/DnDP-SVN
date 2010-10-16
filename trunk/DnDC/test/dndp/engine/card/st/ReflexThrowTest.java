/*
 * To change this template, choose Tools | Templates and open the template in the editor.
 */

package dndp.engine.card.st;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dndp.engine.card.abilities.AbilityType;


/**
 * 
 * @author bambucha
 */
public class ReflexThrowTest
{
    static ReflexThrow test = new ReflexThrow();

    public ReflexThrowTest()
    {

    }

    @Test
    public void testCountModifier()
    {
        assertEquals(AbilityType.DEXTERITY, test.getAbilityName());

    }

}
