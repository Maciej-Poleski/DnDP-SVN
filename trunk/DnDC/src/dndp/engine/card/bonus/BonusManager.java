/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package dndp.engine.card.bonus;

/**
 * 
 * @author evil
 */
public interface BonusManager
{

    /**
     * Zwraca bonus handler do zarejestrowanego składnika.
     * 
     * @param name
     *            Nazwa składnika
     * @return BonusHandlare zajmujący się nim.
     */
    BaseBonusHandler getBonusHandler(String name);

    /**
     * Rejestruje w menadżerze, jedno pole.
     * 
     * @param newBonus
     *            Pole wymagające
     * @param name
     *            Nawa pola
     */
    void registerBonus(String name, Bonusable newBonus);

}
