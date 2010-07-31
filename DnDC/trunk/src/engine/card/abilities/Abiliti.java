package engine.card.abilities;

import engine.card.bonus.Bonusable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Klasa atrybutu stworzona na potrzeby enkapsulację modyfikatora i wartości.
 * Implementuje Bonusable, by uwzględnić modyfikatory z usprawnienia.
 * @author bambucha
 * @see engine.card.abilities.Abilities
 * @see engine.card.abilities.DnDAbilities
 */
public class Abiliti implements Bonusable
{
    Integer value;
    Integer modifier;
    Integer bonus;
    ChangeListener view;

    /**
     * Konstruktor budujący atrybut o wartości 10.
     * Dodatkowy argument to interfejs widoku danego obiektu
     * @param view Widok dla atrybutu
     */
    public Abiliti(ChangeListener view)
    {
        this.value = 10;
        this.modifier = 0;
        this.bonus = 0;
        this.view = view;
    }

    /**
     * Zwraca modyfikator atrybutu
     * @return wartość modyfikatora
     */
    public Integer getModifier()
    {
        return modifier;
    }

    /**
     * Zwraca wartość atrybutu
     * @return wartość atrybutu
     */
    public Integer getValue()
    {
        return value;
    }

    /**
     * Zmienia wartość atrybutu na inną.
     * @param value nowa wartość atrybutu
     * @throws IllegalArgumentException Gdy wartość atrybutu jest ujemna
     */
    public synchronized  void setValue(Integer value)
    {
        if(value < 0)
            throw new IllegalArgumentException("Ujmny atrybut");
        this.value = value;
        this.modifier = (this.value + this.bonus - 10)/2;
        view.stateChanged(new ChangeEvent(this));

    }

    @Override
    public synchronized  void  setBonus(Integer bonus)
    {
        this.bonus = bonus;
        this.modifier = (this.value + this.bonus - 10)/2;
        view.stateChanged(new ChangeEvent(this));
    }

    @Override
    public AbilityType getAbilityName()
    {
        return AbilityType.NONE;
    }
}
