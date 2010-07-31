package engine.item.weapon;

import java.util.LinkedList;
import java.util.List;

import engine.item.Attackable;
import engine.item.Item;
import engine.item.Value;

/**
 * Klasa abstrakcyjna broni
 * 
 * @par TODO Tłumacznie
 * @author bambucha
 */
public abstract class Weapon extends Item implements Attackable
{
    List<WeaponAttack> attackTypes = new LinkedList<WeaponAttack>();
    private WeaponType type;
    private Boolean    isMWW;
    private Boolean    isOneHand;

    public Weapon(String name, Double weight, Value value, Boolean isMWW,
            Boolean isOneHand)
    {
        super(name, weight, value);
        this.isMWW = isMWW;
        this.isOneHand = isOneHand;
        throw new UnsupportedOperationException("Nie skończone");
    }
}
