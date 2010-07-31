package engine.card.armor;

import engine.Character;

/**
 * Klasa licząca Klasę pancerza dla postaci.
 * @author bambucha
 */
public class DnDArmor implements Armor
{

    private final Integer BASE = 10;
    private Integer plate; //ze zbroji
    private Integer shield; //z tarczy
    private Integer natural; //naturalny
    private Integer deflection; //z odbicia
    private Integer proficiency; //z biegłości
    private Integer dodge; //unikowa
    private Integer AC; //pełne AC
    private Character main;

    /**
     * Tworzy pusztą część od KP.
     * @param main
     */
    public DnDArmor(Character main)
    {
        this.main = main;
        this.plate = new Integer(0);
        this.shield = new Integer(0);
        this.natural = new Integer(0);
        this.proficiency = new Integer(0);
        this.deflection = new Integer(0);
        this.dodge = new Integer(0);
        this.countAC();
    }

    /**
     * Funkcja licząca całe KP, z uwzględnieniem wszystkich modyfikatorów.
     */
    private synchronized void countAC()
    {
        this.AC = this.BASE;
        this.AC += this.plate;
        this.AC += this.shield;
        this.AC += this.main.getDexterity().getModifier();
        this.AC += this.natural;
        this.AC += this.deflection;
        this.AC += this.proficiency;
        this.AC += this.dodge;
    }

    /**
     * Zwraca premię do pancerza zbroi
     * @return premia do pancerza
     */
    @Override
    public Integer getArmorACBonus()
    {
        return this.plate;
    }

    /**
     * Zwraca premię do pancerza tarczy
     * @return premia do pancerza
     */
    @Override
    public Integer getShieldACBonus()
    {
        return this.shield;
    }

    /**
     * Zwraca premię do pancerza od zręczności
     * @return premia do pancerza
     */
    @Override
    public Integer getDextirityACBonus()
    {
        if(main.getEq().getArmor() != null)
            return Math.min(this.main.getDexterity().getModifier(),main.getEq().getArmor().getMaxDexBonus());
        else
            return this.main.getDexterity().getModifier();
    }

    /**
     * Zwraca premię do pancerza wynikającą z rozmiaru
     * @return premia do pancerza
     */
    @Override
    public Integer getSizeACBonus()
    {
        return main.getSize().bonus;
    }

    /**
     * Zwraca premię z odbicia do pancerza
     * @return premia do pancerza
     */
    @Override
    public Integer getDeflectionACBonus()
    {
        return this.deflection;
    }

    /**
     * Zwraca premię z biegłości do pancerza
     * @return premia do pancerza
     */
    @Override
    public Integer getProficiencyACBonus()
    {
        return this.proficiency;
    }

    /**
     * Zwraca KP postacie, dla "normalnych ataków"
     * @return Klasa Pancerza postaci
     */
    @Override
    public synchronized Integer getAC()
    {
        this.countAC();
        return this.AC;
    }

    /**
     * Ustawia premię z zbroi do Klasy Pancerza
     * @param newValue Nowa wartość premii
     */
    @Override
    public void setArmorACBonus(Integer newValue)
    {
        if (newValue < 0)
            throw new IllegalArgumentException("Nie może być ujemna");
        this.plate = newValue;
    }

    /**
     * Ustawia nową wartość premie od tarczy do Klasy Pancerza
     * @param newValue Nowa wartość premii
     */
    @Override
    public void setShieldACBonus(Integer newValue)
    {
        if (newValue < 0)
            throw new IllegalArgumentException("Nie może być ujemna");
        this.shield = newValue;
    }

    /**
     * Ustawawia nową wartość premii z odbicia do Klasy Pancerza
     * @param newValue Nowa wartość premii
     */
    @Override
    public void setDeflectionACBonus(Integer newValue)
    {
        if (newValue < 0)
            throw new IllegalArgumentException("Nie może być ujemna");
        this.deflection = newValue;
    }

    /**
     * Ustawia nową wartość premii z biegłości do Klasy Pancerza.
     * @param newValue Nowa wartość premii
     */
    @Override
    public void setProficiencyACBonus(Integer newValue)
    {
        if (newValue < 0)
            throw new IllegalArgumentException("Nie może być ujemna");
        this.proficiency = newValue;
    }

    /**
     * Zwraca Klasę Pancerza postaci nieprzygotowane
     * @return Klasa Pancerza Postaci
     */
    @Override
    public Integer getFlatFootetAC()
    {
        return this.plate + this.shield + this.natural + this.deflection + this.proficiency;
    }

    /**
     * Zwraca Klasę Pancerza postaci przeciwko ataką dodtykowym
     * @return Klasa Pancerza
     */
    @Override
    public Integer getTouchAttaksAC()
    {
        return this.getDextirityACBonus() + this.natural + this.dodge + this.deflection + this.proficiency;
    }

    /**
     * Zwraca warość premii unikowej do Klasy Pancerza
     * @return Wartość premii
     */
    @Override
    public Integer getDodgeACBonus()
    {
        return this.dodge;
    }

    /**
     * Ustawawia nową wartość premii unikowej do Klasy Pancerza
     * @param newValue Nowa wartość premii
     */
    @Override
    public void setDodgeACBonus(Integer newValue)
    {
        if (newValue < 0)
            throw new IllegalArgumentException("Nie może być ujemna");
        this.dodge = newValue;
    }
}
