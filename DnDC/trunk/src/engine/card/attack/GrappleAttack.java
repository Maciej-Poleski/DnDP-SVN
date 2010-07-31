package engine.card.attack;

import engine.Character;
import engine.card.abilities.AbilityType;
import java.util.Arrays;

/**
 * Implementacja licząca premie do walk w zwarciu
 * @author bambucha
 */
public class GrappleAttack extends BaseAttack
{

    /**
     * Strandardowy konstruktor z użyciem postaci
     * @param main
     */
    public GrappleAttack(Character main)
    {
        super(main);
    }

    /**
     * Metodal licząca premie(nie bazową) do ataków w zwarciu.
     * Uwzględnia rozmiar i modyfikator z siły
     */
    @Override
    protected void countAttacksModifier()
    {
        atackModifier = main.getStrenght().getModifier();
        switch (main.getSize())
        {
            case FINE:
                atackModifier += -16;
                break;
            case DIMINUTIVE:
                atackModifier += -12;
                break;
            case TINY:
                atackModifier += -8;
                break;
            case SMALL:
                atackModifier += -4;
                break;
            case MEDIUM:
                atackModifier += 0;
                break;
            case LARGE:
                atackModifier += 4;
                break;
            case HUGE:
                atackModifier += 8;
                break;
            case GARANTUAN:
                atackModifier += 12;
                break;
            case COLOSSAL:
                atackModifier += 16;
                break;
        }
    }

    @Override
    public TotalBonusToAttack getAttacks()
    {
        TotalBonusToAttack t = super.getAttacks();
        return new TotalBonusToAttack(Arrays.copyOfRange(t.getMainHand(), 0, 1));
    }

    @Override
    public AbilityType getAbilityName()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
