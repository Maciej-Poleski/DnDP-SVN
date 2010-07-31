package engine.card.attack;

import engine.Character;
import engine.card.abilities.AbilityType;

/**
 * Klasa obsługująca atak wręcz
 * 
 * @author bambucha
 */
public class MeleeAttack extends BaseAttack
{

    /**
     * Standardowy konstruktor z postacią
     * 
     * @param main
     */
    public MeleeAttack(Character main)
    {
        super(main);
    }

    /**
     * Liczy premie(nie bazową) do ataku wręcz. Uwzględnia rozmiar i Siłę
     */
    @Override
    protected void countAttacksModifier()
    {
        atackModifier = main.getStrenght().getModifier() + main.getSize().bonus;
    }

    @Override
    public AbilityType getAbilityName()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
