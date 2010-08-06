package engine.card.state;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * Klasa obsługująca stany postaci. Kontroluje wszystkie stany postaci, efekty
 * działąjące na postac. Koncepcja jest dziwna i dość mętna. Klasa mocno
 * rowojowa, prawdopodobnie wielowątkowa :)
 * 
 * 
 * @author bambucha
 */
public class StateManager
{
    private Set<State> statusSet = Collections.synchronizedSet(new HashSet<State>(25));

    public StateManager()
    {
        
    }

    /**
     * Dodaje dany stan na czas nieokreślony
     * 
     * @param x
     *            Efekt Status
     */
    public void add(State x)
    {
        throw new UnsupportedOperationException("Brak implementacji");
    }

    /**
     * Dodaje dany stan na określony czas
     * 
     * @param x
     *            Stan do dodania
     * @param lenght
     *            Czas trwania efektu
     */
    public void add(State x, Integer lenght)
    {
        throw new UnsupportedOperationException("Brak implementacji");
    }

    /**
     * Usuwa dany status z postaci, również gdy jest to efekt czasowy
     * 
     * @param x
     */
    public void remove(State x)
    {
        throw new UnsupportedOperationException("Brak implemetacji");
    }

}
