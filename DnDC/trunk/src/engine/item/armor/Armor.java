package engine.item.armor;

import engine.item.Item;
import engine.item.Value;
import engine.item.Wearable;

/**
 * Klasa implemetująca część wspólną pancerzy, tarcz i innych
 * 
 * @author bambucha
 */
public abstract class Armor extends Item implements Wearable
{
    private Integer ACBonus;
    private Integer armorPenalty;
    private Double  arcaneSpellFail;

    /**
     * Konstruktro dla klas dzieci
     * 
     * @param name
     *            Nazwa
     * @param weight
     *            Waga
     * @param value
     *            Wartość
     * @param ACBonus
     *            Premia do pancerza
     * @param armorPenalty
     *            Kara do testów
     * @param arcaneSpellFail
     *            Szansa Niepowodzenia Czarów
     */
    public Armor(String name, Double weight, Value value, Integer ACBonus,
            Integer armorPenalty, Double arcaneSpellFail)
    {
        super(name, weight, value);
        this.ACBonus = ACBonus;
        this.armorPenalty = armorPenalty;
        this.arcaneSpellFail = arcaneSpellFail;
    }

    /**
     * Zwraca premię do AC pancerza
     * 
     * @return
     */
    public Integer getACBonus()
    {
        return ACBonus;
    }

    /**
     * Ustawia nową premię do pancerza
     * 
     * @param ACBonus
     *            Premia
     */
    public void setACBonus(Integer ACBonus)
    {
        this.ACBonus = ACBonus;
    }

    /**
     * Zwraca karę do testów umiejętności z pancerza
     * 
     * @return Kara
     */
    public Integer getArmorPenalty()
    {
        return armorPenalty;
    }

    /**
     * Ustawia karę do testów umiejętności z pancerza
     * 
     * @param ArmorPenalty
     *            Kara do testów umiejętności
     */
    public void setArmorPenalty(Integer ArmorPenalty)
    {
        this.armorPenalty = ArmorPenalty;
    }

    /**
     * Zwraca nie
     * 
     * @return
     */
    public Double getArcaneSpellFail()
    {
        return arcaneSpellFail;
    }

    /**
     * 
     * @param arcaneSpellFail
     */
    public void setArcaneSpellFail(Double arcaneSpellFail)
    {
        this.arcaneSpellFail = arcaneSpellFail;
    }

}
