package engine.card.bonus;

import java.util.EnumMap;

import engine.card.abilities.Abilities;

/**
 * Zajmuje się całym pakietem wszytkich premi dla jednego atrybutu, umiejętności.
 * 
 * @author bambucha
 */
public class BasicBonusHandler
{
    private Bonusable                   cared;
    private Abilities                   abilities;
    protected EnumMap<BonusType, Bonus> bonusTypePool = new EnumMap<BonusType, Bonus>(BonusType.class);

    /**
     * 
     * @param cared
     * @param abilities
     */
    public BasicBonusHandler(Bonusable cared, Abilities abilities)
    {
        this.abilities = abilities;
        this.cared = cared;
        bonusTypePool.put(BonusType.Alchemical, new MaximizedBonus());
        bonusTypePool.put(BonusType.Circumstance, new AdductBonus());
        bonusTypePool.put(BonusType.Competence, new MaximizedBonus());
        bonusTypePool.put(BonusType.Enhancement, new AdductBonus());
        bonusTypePool.put(BonusType.Insight, new MaximizedBonus());
        bonusTypePool.put(BonusType.Luck, new MaximizedBonus());
        bonusTypePool.put(BonusType.Morale, new MaximizedBonus());
        bonusTypePool.put(BonusType.Profane, new MaximizedBonus());
        bonusTypePool.put(BonusType.Racial, new AdductBonus());
        bonusTypePool.put(BonusType.Resistance, new MaximizedBonus());
        bonusTypePool.put(BonusType.Sacred, new MaximizedBonus());
    }

    protected Integer countBonus()
    {
        int temp = 0;
        for (Bonus t : bonusTypePool.values())
            temp += t.getBonus();
        if(cared.getAbilityName().getAbiliti(abilities) != null)
            return temp + cared.getAbilityName().getAbiliti(abilities).getModifier();
        return temp;
    }

    /**
     * Dodaje bonus do pola i aktualizuje warość bonusu w polu.
     * 
     * @param x
     *            Typ premmi
     * @param bonus
     *            Wartosć premi
     */
    public void addBonus(BonusType x, Integer bonus)
    {
        Bonus b = bonusTypePool.get(x);
        if(b == null)
            throw new IllegalArgumentException("To pole nie ma takiego typu bonusu");
        b.addBonus(bonus);
        cared.setBonus(countBonus());
    }

    /**
     * Usuwa premię z pola i katualizuje bonus.
     * 
     * @param x
     *            Typ premii
     * @param bonus
     *            Wartość premii
     */
    public void removeBonus(BonusType x, Integer bonus)
    {
        Bonus b = bonusTypePool.get(x);
        if(b == null)
            throw new IllegalArgumentException("To pole nie ma takiego typu bonusu");
        b.removeBonus(bonus);
        cared.setBonus(countBonus());
    }
}
