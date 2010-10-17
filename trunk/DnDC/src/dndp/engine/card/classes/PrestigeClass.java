package dndp.engine.card.classes;

import dndp.engine.benefit.Benefit;
import dndp.engine.card.skills.Skill;
import dndp.engine.check.Checkable;

/**
 * 
 * 
 * @author bambucha
 */
public class PrestigeClass extends BaseClass
{
    private final Checkable[] conditions;

    public PrestigeClass(String name, Benefit[][] levelBenefitsList, AttackBonusLevel bonusType, boolean highFortitudeBonus,
            boolean highReflexeBonus, boolean highWillBonus, Skill[] classFleats, Checkable[] conditions)
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
