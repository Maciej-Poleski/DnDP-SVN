package engine.card.skils;

import engine.card.abilities.AbilityType;
import engine.card.bonus.BonusManager;
import engine.card.bonus.Bonusable;

/**
 * Klasa opiekująca się umiejętnościami bohatera. Używa Skil, jako informacji o
 * umijętności.
 * 
 * @par TODO Połączenie setRang z levelem postaci, zgodnie z wytycznymi, tj.
 *      Maksymaną ilość rang jaka może być zainwestowana w umiejętność zachodzi
 *      zgodnie równaniem
 * @f$ rank_{max} = lvl+3 @f$ gdzie lvl to suma poziomów klas postaci.
 * @author bambucha
 */
public class CharacterSkil implements Bonusable
{
    private Skil    skil;
    private Integer rank;
    private Integer bonus;

    /**
     * Konstruktor z opisu umiejętności
     * 
     * @param skil
     *            Opis umiejętności
     * @param bonusManager
     *            Menadżer bonusów.
     */
    public CharacterSkil(Skil skil, BonusManager bonusManager)
    {
        this.skil = skil;
        this.rank = new Integer(0);
        bonusManager.registerBonus(skil.getName(), this);
    }

    /**
     * Zwraca opis umiejętności
     * 
     * @return Opis umiejętności
     */
    public Skil getSkil()
    {
        return skil;
    }

    /**
     * Zwraca ilość rang umiejętności.
     * 
     * @return Ranga
     */
    public Integer getRank()
    {
        return rank;
    }

    /**
     * Ustawia ilośc rang umiejętności
     * 
     * @param rank
     */
    public void setRank(Integer rank)
    {
        if (rank < 0)
            throw new IllegalArgumentException("rank nie może być ujemne");
        this.rank = rank;
    }

    /**
     * Zwraca modyfikator. Modyfikator odnosi się do umiejętności danej postaci.
     * Jest to zbiorcze miejsce na wszystkie modyfikatory.
     * 
     * @return
     */
    public Integer getBonus()
    {
        return bonus;
    }

    /**
     * Ustawia modyfikatory do umiejętności.
     * 
     * @param bonus
     */
    @Override
    public void setBonus(Integer bonus)
    {
        if (bonus == null)
            throw new NullPointerException();
        this.bonus = bonus;
    }

    @Override
    public AbilityType getAbilityName()
    {
        return getSkil().getAbilitiModifier();
    }

}
