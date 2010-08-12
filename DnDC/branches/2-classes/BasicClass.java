package engine.card.classes;

import engine.benefit.Benefit;
import engine.card.skils.Skil;

/**
 * Przedstawia pojedynczą klasę postaci.
 * 
 * @author bambucha
 */
public class BasicClass
{
    private final String          name;
    private final Benefit[][]     levelBenefitsList;
    private final AttackBonusType bonusType;
    private final boolean         highFortitudeBonus;
    private final boolean         highReflexeBonus;
    private final boolean         highWillBonus;
    private final Skil[]          classFleats;

    /**
     * Standardowy konstruktor klasy postaci.
     * 
     * @param name
     *            Nazwa klasy postaci.
     * @param levelBenefitsList
     *            Lista premi w zależności od lvl.
     * @param bonusType
     *            Wysokość bazowej premi do ataku.
     * @param highFortitudeBonus
     *            Czy klasa ma wyski rzut na wytrzymałość.
     * @param highReflexeBonus
     *            Czy klasa ma wysoki rzut na refleks.
     * @param highWillBonus
     *            Czy klasa ma wysoki rzut na wolę.
     * @param classList
     *            Lista
     */
    public BasicClass(String name, Benefit[][] levelBenefitsList, AttackBonusType bonusType, boolean highFortitudeBonus,
            boolean highReflexeBonus, boolean highWillBonus, Skil[] classFleats)
    {
        super();
        this.name = name;
        this.levelBenefitsList = levelBenefitsList;
        this.bonusType = bonusType;
        this.highFortitudeBonus = highFortitudeBonus;
        this.highReflexeBonus = highReflexeBonus;
        this.highWillBonus = highWillBonus;
        this.classFleats = classFleats;
    }

    public String getName()
    {
        return name;
    }

    public Benefit[][] getLevelBenefitsList()
    {
        return levelBenefitsList;
    }

    public AttackBonusType getBonusType()
    {
        return bonusType;
    }

    public boolean isHighFortitudeBonus()
    {
        return highFortitudeBonus;
    }

    public boolean isHighReflexeBonus()
    {
        return highReflexeBonus;
    }

    public boolean isHighWillBonus()
    {
        return highWillBonus;
    }

    public Skil[] getClassFleats()
    {
        return classFleats;
    }

}
