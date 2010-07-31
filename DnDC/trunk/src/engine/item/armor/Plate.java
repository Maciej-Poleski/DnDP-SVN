package engine.item.armor;

import engine.item.Value;

/**
 * Klasa na zbroje i inne "ubierane" na klatkę piersiową pancerze.
 * 
 * @par TODO Dodanie konstruktora całej zbroji
 * @author bambucha
 */
public class Plate extends Armor
{
    private Integer maxDexBonus;

    public Plate(String name, Double weight, Value value, Integer ACBonus,
            Integer armorPenalty, Double arcaneSpellFail, Integer maxDexBonus)
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
        if (getOwner().getEq().getArmor() == null)
        {
            getOwner().getEq().setArmor(this);
            getOwner().setArmorACBonus(getACBonus());
            return true;
        }
        getOwner().getEq().getArmor().takeOff();
        return this.putOn();
    }

    @Override
    public Boolean takeOff()
    {
        getOwner().setArmorACBonus(getOwner().getArmorACBonus() - getACBonus());
        getOwner().getEq().setArmor(null);
        return getOwner().getBackpack().add(this);
    }

}
