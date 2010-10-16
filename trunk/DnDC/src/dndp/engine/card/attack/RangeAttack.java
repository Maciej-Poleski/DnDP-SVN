package dndp.engine.card.attack;

import dndp.engine.Character;
import dndp.engine.card.abilities.AbilityType;

/**
 * Klasa obsługująca ataki dystansowe
 * 
 * @author bambucha
 */
public class RangeAttack extends BaseAttack
{

    /**
     * Standardowy konstruktor z postacią
     * 
     * @param main
     */
    public RangeAttack(Character main)
    {
        super(main);
    }

    /**
     * Liczy premię do ataków dystansowych. Uwględnia modyfikatro ze zręcznośći
     * i rozmiar. Nie uwzględnia kary za odległość.
     */
    @Override
    protected void countAttacksModifier()
    {
        atackModifier = main.getDexterity().getModifier()
                + main.getSize().getBaseModifier();
    }

    @Override
    public AbilityType getAbilityName()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
