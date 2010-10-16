package dndp.engine.item;

import dndp.engine.Character;

/**
 * Interfejs pozwalający na taka postaci przedmiotem.
 * 
 * @author bambucha
 */
public interface Attackable
{
    /**
     * Wytwarza AtackEvent w kierunku postaci.
     * 
     * @param who
     *            Zatakowany
     */
    public void Attack(Character who);
}
