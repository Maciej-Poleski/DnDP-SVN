package engine.card.bonus;

import engine.card.abilities.Abilities;

/**
 * 
 * @author bambucha
 */
public class ArmorBonusHandler extends BasicBonusHandler
{

    public ArmorBonusHandler(Bonusable cared, Abilities abilities)
    {
        super(cared, abilities);
        bonusTypePool.put(BonusType.Armor, new AdductBonus());
        bonusTypePool.put(BonusType.Shield, new AdductBonus());
        bonusTypePool.put(BonusType.Deflection, new MaximizedBonus());
        bonusTypePool.put(BonusType.Dodge, new AdductBonus());
        bonusTypePool.put(BonusType.Natural, new AdductBonus());
    }

    /**
     * Zwraca premię do pancerza z uwzglęnieniem bonusów.
     * @note bez uwzględnienia 
     * @return
     */
    public Integer getACBonus()
    {
        return countBonus();
    }

    /**
     * Zwraca premię do pancerza postaci pozbawinej premi ze zręczności do pancerza.
     * @return
     */
    public Integer getFlatFootetAC()
    {
        return countBonus() - bonusTypePool.get(BonusType.Dodge).getBonus();
    }

    /**
     * Zwraca premie do pancerza postaci podczas ataku dotykowego
     * @note
     * Nie uwzględnia Zręczności.
     * @return
     */
    public Integer getTouchAttaksAC()
    {
        return countBonus() - bonusTypePool.get(BonusType.Armor).getBonus() - bonusTypePool.get(BonusType.Shield).getBonus();
    }

}
