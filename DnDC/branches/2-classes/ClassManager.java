package engine.card.classes;

import java.util.HashMap;
import java.util.Map;

/**
 * Klasa, singleton, przechowująca informacje o wszystkich klasach.
 * Możliwe że w przyuszłości, ilośc przechowywanych informacji będzie zredukowana do tylko nagłowków.
 * 
 * @par TODO
 * Pobieranie klas z Bazy danych.
 * 
 * @author bambucha
 */
public class ClassManager
{
    private static ClassManager instance;
    private Map<String,BasicClass> classMap;
    
    protected ClassManager()
    {
        classMap = new HashMap<String, BasicClass>();
        // FIXME
    }
    
    /**
     * Zwraca instancję obiektu.
     * Klasyczny wariant singletownowy.
     * @return Obiekt Klasy
     */
    public static ClassManager getInstance()
    {
        if(instance == null)
            instance = new ClassManager();
        return instance;
    }
    
    public BasicClass getClass(String name)
    {
        return classMap.get(name);
    }
}
