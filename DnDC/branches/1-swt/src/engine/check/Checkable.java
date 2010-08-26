/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package engine.check;

/**
 * Interfejs sprawdzający...
 * Jeżeli postać spełnia warunki 
 * 
 * @author evil, bambucha
 */
public interface Checkable
{
    /**
     * Sprawdza czy można zastosować.
     * 
     * @param character
     *            Postać na rzecz której dokonuje sie sprawdzanie.
     * @return true Jeżeli można.
     */
    boolean check(engine.Character character);
}
