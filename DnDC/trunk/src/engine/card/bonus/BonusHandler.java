package engine.card.bonus;

import java.util.EnumMap;

import engine.card.abilities.Abilities;
import engine.card.abilities.AbilityType;

/**
 * Zajmuje się całym pakietem wszytkich premi dla jednego atrybutu,
 * umiejętności.
 * 
 * @author bambucha
 */
public class BonusHandler
{
    private Bonusable                 cared;
    private EnumMap<BonusType, Bonus> bonusTypePool = new EnumMap<BonusType, Bonus>(
                                                            BonusType.class);
    private Abilities                 abilities;

    /**
     * 
     * @param cared
     * @param abilities
     */
    public BonusHandler(Bonusable cared, Abilities abilities)
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

    private Integer countBonus()
    {
        int temp = 0;
        for (Bonus t : bonusTypePool.values())
            temp += t.getBonus();
        return temp + getAbilitiModifier(cared.getAbilityName());
    }

    /**
     * Funkcja zwraca modyfikatr od atrybutu do umijętności.
     * 
     * @param arg
     *            Nazwa atrybutu
     * @return Wartość modyfikatora
     */
    private int getAbilitiModifier(AbilityType arg)
    {
        switch (arg)
        {
            case STRENGHT:
                return abilities.getStrenght().getModifier();
            case DEXTERITY:
                return abilities.getDexterity().getModifier();
            case CONSTRUCTION:
                return abilities.getConstitution().getModifier();
            case INTELLIGENCE:
                return abilities.getInteligence().getModifier();
            case WISDOM:
                return abilities.getWisdom().getModifier();
            case CHARISMA:
                return abilities.getCharisma().getModifier();
            case NONE:
            default:
                return 0;
        }
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
        bonusTypePool.get(x).addBonus(bonus);
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
        bonusTypePool.get(x).removeBonus(bonus);
        cared.setBonus(countBonus());
    }
}
