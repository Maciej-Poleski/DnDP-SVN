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
public class StateReactor extends Thread
{
    private Integer          time;
    private Queue<StateTask> queue     = new PriorityBlockingQueue<StateTask>();
    private Set<State>       statusSet = Collections
                                               .synchronizedSet(new HashSet<State>(
                                                       25));
    private Queue<Integer>   timeQueue = new LinkedList<Integer>();

    public StateReactor()
    {
        this.time = 0;
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
        if (statusSet.contains(x))
        {
            statusSet.remove(x);
            queue.remove(x);
        }
        else
            throw new IllegalArgumentException("Postać nie ma takiego statusu");
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                if (timeQueue.isEmpty())
                {
                    sleep(100);
                    continue;
                }
                if (timeQueue.poll().compareTo(time) > 1)
                {

                }
            }
        }
        catch(InterruptedException ex)
        {
            Logger.getLogger(StateReactor.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

}
