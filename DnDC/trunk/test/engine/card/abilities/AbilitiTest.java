/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package engine.card.abilities;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test klasy przechowującej umiejętności.
 * @author bambucha
 */
public class AbilitiTest {

    public AbilitiTest() {
    }



    @Test

    public void testGetModifier() {
        System.out.println("getModifier");
        Abiliti instance = new Abiliti(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        Integer expResult = 0;
        Integer result = instance.getModifier();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Abiliti instance = new Abiliti(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        Integer expResult = 10;
        Integer result = instance.getValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetValue() throws Exception {
        System.out.println("setValue");
        final Integer value = 12;
        Abiliti instance = new Abiliti(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                assertEquals(((Abiliti)e.getSource()).getValue(), value);
            }
        });
        instance.setValue(value);
        assertEquals(instance.getValue(), value);
    }

    @Test (expected=IllegalArgumentException.class)
    public void testSetValueException() throws Exception {
        System.out.println("setValueException");
        Integer value = -12;
        Abiliti instance = new Abiliti(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        instance.setValue(value);
        assertEquals(instance.getValue(), value);
    }

    @Test
    public void testSetAndGetValue() throws Exception {
        System.out.println("setValue");
        final Integer value = 14;
        final Integer exp = 2;
        Abiliti instance = new Abiliti(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                assertEquals(((Abiliti)e.getSource()).getModifier(), exp);
            }
        });
        instance.setValue(value);
        assertEquals("Powinno być 2",(Object)instance.getModifier(),exp);
    }

    @Test
    public void testSetBonus()
    {
        Integer value = 4;
        Abiliti instance = new Abiliti(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                
            }
        });
        instance.setBonus(value);
        assertEquals((instance.getValue() -10 + value)/2, instance.getModifier().intValue());
    }

}