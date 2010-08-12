package engine.card.armor;

import engine.card.abilities.Abilities;
import engine.card.abilities.AbilityType;
import engine.card.bonus.ArmorBonusHandler;
import engine.card.bonus.BonusManager;
import engine.card.bonus.Bonusable;
import engine.item.BasicEquipmentManager;

/**
 * Klasa licząca Klasę pancerza dla postaci.
 * 
 * @author bambucha
 */
public class DnDArmor implements Armor, Bonusable
{

    private final Integer         BASE = 10;
    private Abilities             abilities;
    private BasicEquipmentManager equipmentManager;
    private ArmorBonusHandler     bonusHandler;

    /**
     * Standardowy konstruktor
     * 
     * @param abilities
     * @param equipmentManager
     */
    public DnDArmor(Abilities abilities, BasicEquipmentManager equipmentManager, BonusManager bonusManager)
    {
        super();
        this.abilities = abilities;
        this.equipmentManager = equipmentManager;
        bonusManager.registerBonus("armor", this);
        this.bonusHandler = (ArmorBonusHandler) bonusManager.getBonusHandler("armor");
        
    }

    /**
     * Zwraca premię do pancerza od zręczności
     * 
     * @return premia do pancerza
     */
    private Integer getDextirityACBonus()
    {
        return Math.min(this.abilities.getDexterity().getModifier(), equipmentManager.getMaximumDexterityACBonus());
    }

    /**
     * Zwraca Klasę Pancerza postaci nieprzygotowane
     * 
     * @return Klasa Pancerza Postaci
     */
    @Override
    public Integer getFlatFootetAC()
    {
        return BASE + bonusHandler.getFlatFootetAC();
    }

    /**
     * Zwraca Klasę Pancerza postaci przeciwko ataką dodtykowym
     * 
     * @return Klasa Pancerza
     */
    @Override
    public Integer getTouchAttaksAC()
    {
        return BASE + bonusHandler.getTouchAttaksAC() + getDextirityACBonus();
    }

    @Override
    public Integer getAC()
    {
        return BASE + bonusHandler.getACBonus() + getDextirityACBonus();
    }

    @Override
    public void setBonus(Integer bonus)
    {
        
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.NONE;
    }

}
