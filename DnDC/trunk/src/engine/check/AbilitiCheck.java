package engine.check;

import engine.Character;
import engine.card.abilities.AbilityType;

/**
 * Sprawdza czy atrybut ma wystarczającą wartośc.
 * 
 * @author bambucha
 */
public class AbilitiCheck implements Checkable
{
    private final AbilityType abilityType;
    private final Integer value;

    
    /**
     * Standardowy konstruktor
     * @param abilityType Atrybut do testów.
     * @param value Wymagana wartość.
     */
    public AbilitiCheck(AbilityType abilityType, Integer value)
    {
        super();
        this.abilityType = abilityType;
        this.value = value;
    }


    /* (non-Javadoc)
     * @see engine.check.Checkable#check(engine.Character)
     */
    @Override
    public boolean check(Character character)
    {
        return abilityType.getAbiliti(character).getValue() >= value;
    }

}
