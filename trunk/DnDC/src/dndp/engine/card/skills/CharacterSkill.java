package dndp.engine.card.skills;

import java.util.Observable;

import dndp.engine.card.abilities.AbilityType;
import dndp.engine.card.bonus.BonusManager;
import dndp.engine.card.bonus.Bonusable;

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
public class CharacterSkill extends Observable implements Bonusable
{
    private Skill    skil;
    private Boolean isClasses;
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
    public CharacterSkill(Skill skil, BonusManager bonusManager)
    {
        this.skil = skil;
        this.rank = new Integer(0);
        this.bonus = new Integer(0);
        this.isClasses = false;
        bonusManager.registerBonus(skil.getName(), this);
    }

    /**
     * Zwraca opis umiejętności
     * 
     * @return Opis umiejętności
     */
    public Skill getSkil()
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
        notifyObservers();
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
        notifyObservers();
    }

    @Override
    public AbilityType getAbilityName()
    {
        return getSkil().getAbilitiModifier();
    }

    /**
     * Zwraca iformację czy umiejętność jest umiejętnością klasową postaci.
     * @return true, jeśli klasowa
     */
    public Boolean isClasses()
    {
        return isClasses;
    }

    /**
     * Ustwia czy umiejętność jest klasowa dla postaci.
     * @param isClasses Status umiejętności.
     */
    public void setClasses(Boolean isClasses)
    {
        this.isClasses = isClasses;
    }
}
