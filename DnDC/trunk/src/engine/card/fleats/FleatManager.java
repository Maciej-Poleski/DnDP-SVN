package engine.card.fleats;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Globalny Menadżer Atutów.
 * @par TODO
 * Inicjalizować z bazy danych.
 * 
 * @author evil, bambucha
 */
public final class FleatManager
{

    private static FleatManager fleatManager;
    private Map<String, Fleat> fleats;

    /**
     * Konstruktor. MA czytać z bazy danych.
     * @par TODO
     * Inicjalizować z bazy danych
     */
    private FleatManager()
    {
        fleats = new HashMap<String, Fleat>();
        // TODO 
    }

    /**
     * Zwraca instancję singletonu.
     * @return Instancja Menadżera Atutów.
     */
    public static synchronized FleatManager getInstance()
    {
        if (fleatManager == null)
            fleatManager = new FleatManager();
        return fleatManager;
    }

    /**
     * Pobiera Atut na podstawie jego nazwy.
     * @param key Nazwa atutu.
     * @return Atut
     */
    public Fleat getFleat(Object key)
    {
        return fleats.get(key);
    }

    /**
     * Zwraca wszystkie atuty z bazy.
     * @return
     */
    public Collection<Fleat> getAllFleats()
    {
        return fleats.values();
    }


}
