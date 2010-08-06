package engine.item.armor;

import engine.item.Value;

/**
 * Klasa na zbroje i inne "ubierane" na klatkę piersiową pancerze.
 * 
 * @par TODO Funkcje zakładanie i zdejmowania.
 * @author bambucha
 */
public class Plate extends Armor
{
    private Integer maxDexBonus;

    /**
     * Kosntruktor budujący całą zbroje od zera.
     * @param name
     * @param weight
     * @param value
     * @param ACBonus
     * @param armorPenalty
     * @param arcaneSpellFail
     * @param maxDexBonus
     * @see engine.item.Item
     * @see engine.item.Armor
     */
    public Plate(String name, Double weight, Value value, Integer ACBonus, Integer armorPenalty, Double arcaneSpellFail, Integer maxDexBonus)
    {
        super(name, weight, value, ACBonus, armorPenalty, arcaneSpellFail);
        this.maxDexBonus = maxDexBonus;
    }

    /**
     * Zwraca maksymalną premię ze zręczności do pancerza wynikającą ze zbroji
     * 
     * @return Wartość maksymalna
     */
    public Integer getMaxDexBonus()
    {
        return maxDexBonus;
    }

    /**
     * Ustawia maksymalną premię ze zręczności do pancerza wynikającą ze zbroji.
     * 
     * @param MaxDexBonus
     */
    public void setMaxDexBonus(Integer MaxDexBonus)
    {
        this.maxDexBonus = MaxDexBonus;
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
