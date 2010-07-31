package engine.item.weapon;

import engine.Dice;

/**
 * Klasa opisująca pojedynczy sposób ataku broni.
 * @author bambucha
 */
public abstract class WeaponAttack
{
    private Integer timesDice;
    private Dice diceType;
    private DamageType damageType;

    /**
     * Standardowy konstruktor towrzy atak danego typu z odpowidnim rzutem
     * @param timesDice Ilość kostek
     * @param diceType Typ kostek
     * @param damageType Typ obrażeń
     */
    public WeaponAttack(Integer timesDice, Dice diceType, DamageType damageType)
    {
        this.timesDice = timesDice;
        this.diceType = diceType;
        this.damageType = damageType;
    }
}
