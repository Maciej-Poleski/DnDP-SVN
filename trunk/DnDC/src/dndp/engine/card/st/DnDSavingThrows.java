package dndp.engine.card.st;

import dndp.engine.card.bonus.BonusManager;

/**
 * Klasa opiekująca sie rzutami obronnymi
 * 
 * @author bambucha
 */
public class DnDSavingThrows implements SavingThrows
{
    private SavingThrow forttiude;
    private SavingThrow reflex;
    private SavingThrow will;
    private Double      spell;

    /**
     * Standardowy konstruktor.
     * 
     * @param bonusManager
     *            Menadżer bonusów.
     * @param view
     *            Widok rzutów.
     */
    public DnDSavingThrows(BonusManager bonusManager)
    {
        forttiude = new FortitudeThrow();
        bonusManager.registerBonus("FortitudeThrow", forttiude);
        reflex = new ReflexThrow();
        bonusManager.registerBonus("ReflexThrow", reflex);
        will = new WillThrow();
        bonusManager.registerBonus("WillThrow", will);
        spell = 0.0;
    }

    @Override
    public SavingThrow getForttiude()
    {
        return forttiude;
    }

    @Override
    public SavingThrow getReflex()
    {
        return reflex;
    }

    @Override
    public SavingThrow getWill()
    {
        return will;
    }

    @Override
    public Double getSpellResistance()
    {
        return spell;
    }

    @Override
    public void setSpellResistance(Double newValue)
    {
        if(newValue < 0)
            throw new IllegalArgumentException("Nie może być < 0");
        spell = newValue;
    }

}
