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
public class FortitudeThrowTest
{

    static FortitudeThrow test = new FortitudeThrow();

    public FortitudeThrowTest()
    {}

    @Test
    public void testCountModifier()
    {
        assertEquals(AbilityType.STRENGHT, test.getAbilityName());
    }

}
