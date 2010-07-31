package engine.item.armor;

import engine.item.Value;

/**
 * Klasa na tarcze
 * 
 * @author bambucha
 */

public class Shield extends Armor
{

    /**
     * Konstruktor służący do budowania obiektów.
     * 
     * @param name
     *            Nawa tarczy
     * @param weight
     *            Waga tarczy
     * @param value
     *            Wartość rynkowa tarczy
     * @param ACBonus
     *            Premia do KP tarczy
     * @param armorPenalty
     *            Kara do testów z pancerza
     * @param arcaneSpellFail
     *            Szansa na niepowodzenie zaklęć
     */
    public Shield(String name, Double weight, Value value, Integer ACBonus,
            Integer armorPenalty, Double arcaneSpellFail)
    {
        super(name, weight, value, ACBonus, armorPenalty, arcaneSpellFail);
    }

    @Override
    public Boolean putOn()
    {
        if (getOwner().getEq().getShield() == null)
        {
            getOwner().getEq().setShield(this);
            getOwner().setShieldACBonus(getACBonus());
            return true;
        }
        getOwner().getEq().getShield().takeOff();
        return this.putOn();
    }

    @Override
    public Boolean takeOff()
    {
        getOwner().setShieldACBonus(
                getOwner().getShieldACBonus() - getACBonus());
        getOwner().getEq().setArmor(null);
        return getOwner().getBackpack().add(this);
    }

}
