package engine.card.classes;

import engine.benefit.Benefit;
import engine.card.Checkable;
import engine.card.skils.Skil;

/**
 * 
 * 
 * @author bambucha
 */
public class PrestigeClass extends BaseClass
{
    private final Checkable[] conditions;

    public PrestigeClass(String name, Benefit[][] levelBenefitsList, AttackBonusLevel bonusType, boolean highFortitudeBonus,
            boolean highReflexeBonus, boolean highWillBonus, Skil[] classFleats, Checkable[] conditions)
    {
        super(name, levelBenefitsList, bonusType, highFortitudeBonus, highReflexeBonus, highWillBonus, classFleats);
        this.conditions = conditions;
    }

    @Override
    public boolean isUseInMulticlass()
    {
        return false;
    }

    @Override
    public Checkable[] getConditions()
    {
        return conditions;
    }

}
