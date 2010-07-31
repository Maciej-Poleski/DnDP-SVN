/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */

package engine.item.weapon;

import engine.Dice;

/**
 * Klasa opisująca atak broni opisywany przez atak wręcz postaci.
 * 
 * @author bambucha
 */
public class WeaponMeleeAttack extends WeaponAttack
{

    public WeaponMeleeAttack(Integer timesDice, Dice diceType,
            DamageType damageType)
    {
        super(timesDice, diceType, damageType);
    }
}
