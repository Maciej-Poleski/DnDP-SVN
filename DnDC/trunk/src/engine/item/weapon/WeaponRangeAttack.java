/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package engine.item.weapon;

import engine.Dice;

/**
 * Klasa opisująca ataki broni, używające dystansowego ataku postaci.
 * 
 * @author bambucha
 */
public class WeaponRangeAttack extends WeaponAttack
{

    public WeaponRangeAttack(Integer timesDice, Dice diceType,
            DamageType damageType)
    {
        super(timesDice, diceType, damageType);
    }

}
