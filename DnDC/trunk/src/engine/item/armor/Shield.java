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
        throw new UnsupportedOperationException("Brak implementacji");
    }

    @Override
    public Boolean takeOff()
    {
        throw new UnsupportedOperationException("Brak implementacji");
    }

}
