package engine.card.fleats;

import engine.card.Checkable;

/**
 * 
 * @author evil, bambucha
 */
public class CharacterFleat
{
    /**
     * Możliwe stany atutu danej postaci.
     */
    public enum State
    {
        /**
         * Możliwy, wyłączony
         */
        ABLE,
        /**
         * Możliwy, włączony
         */
        ENABLED,
        /**
         * Niemożliwy, wyłączony
         */
        DISABLED,
    }

    private Fleat                    fleat;
    private State                    state;
    private DnDCharacterFleatManager characterFleatManager;

    /**
     * Inicjalizuje ten atut danej postaci.
     * 
     * @param fleat
     *            Dany atut.
     * @param characterFleatManager
     *            Menadżer atutów danej postaci.
     */
    public CharacterFleat(Fleat fleat,
            DnDCharacterFleatManager characterFleatManager)
    {
        this.fleat = fleat;
        this.state = State.DISABLED;
        this.characterFleatManager = characterFleatManager;
    }

    /**
     * Sprawdza czy atut można zastosować.
     * 
     * @return
     */
    public boolean isPossible()
    {
        if (state != State.DISABLED)
            return true;
        boolean result = true;
        for (Checkable c : fleat.getDependency())
            result = result && c.check(characterFleatManager.getCharacter());

        if (result)
            state = State.ABLE;

        return result;
    }

    /**
     * Zwraca status tego atutu u danej postaci.
     * 
     * @return
     */
    public State getState()
    {
        return state;
    }

}
