package dndp.engine.item.armor;

import dndp.engine.benefit.Benefit;
import dndp.engine.item.Value;

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
    public Shield(String name, Double weight, Value value, Benefit[] benefits, Integer armorPenalty, Double arcaneSpellFail)
    {
        super(name, weight, value, benefits, armorPenalty, arcaneSpellFail);
    }

    @Override
    public void putOn()
    {
        if (getManager().getShield() != null)
            getManager().getShield().takeOff();
        getManager().applyItemBenefits(this);
        getManager().setShield(this);
        if(getParent() != null)
            getParent().remove(this);

    }

    @Override
    public void takeOff()
    {
        getManager().store(getManager().getShield());
        getManager().applyItemBenefits(this);
        getManager().setShield(null);
    }

}
