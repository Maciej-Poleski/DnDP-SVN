package engine.item;

import engine.benefit.Benefit;

/**
 * Klasae bazowa, dla wszystkich przedmiotów, które można umieścić w ekwipunku.
 * 
 * @author evil, bambucha
 */
public abstract class Item implements Carryable, Wearable
{
    private final String     name;     // Na razie bez niczego
    private final Benefit[]  benefits; // Premie zapewniane przez postać.
    private Double           weight;   // Waga przedmiotu
    private Value            value;    // wartość przedmiotu
    
    private Inventory        inventory; // Umiejscownie przedmiotu w ekwipunku
    private EquipmentManager manager;  // Menadżer przedmiotów postaci która wykorezystuje przedmiot.

    /**
     * Konstruktor dla klas potomnych. buduje przedmiot z klas potomnych.
     * 
     * @param name
     *            Nazwa przedmiotu
     * @param weight
     *            Waga przedmiotu
     * @param value
     *            Wartość rynkowa przedmiotu
     * @param benefits Tablica z premiami wynikającymi z używania przedmiotów.
     */
    public Item(String name, Double weight, Value value,Benefit[] benefits)
    {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.benefits = benefits;
    }

    /**
     * Zwraca referencję do ekwipunku w którym jest trzymany przdmiot, lub null przeciwnym przypadku.
     * 
     * @return [ekwiputnek|null]
     */
    public Inventory getInventory()
    {
        return inventory;
    }

    /**
     * Ustawia ekwipunek, nadrzędny konter przedmiotów.
     * 
     * @param inventory
     */
    public void setInventory(Inventory inventory)
    {
        this.inventory = inventory;
    }

    /**
     * Zwraca nazwę przedmiotu
     * 
     * @return Nazwa przedmiotu
     */
    public String getName()
    {
        return name;
    }

    /**
     * Zwraca menagera ekwipunku postaci posiadającej przedmiot.
     * 
     * @return Menadżer ekwipunku
     */
    public EquipmentManager getManager()
    {
        if (manager == null && inventory != null)
            manager = inventory.getManager();
        return manager;
    }

    /**
     * Ustawia menadżera ekwipunku.
     * 
     * @param menager
     *            Menadżer ekwipunku.
     */
    public void setManager(EquipmentManager menager)
    {
        this.manager = menager;
    }

    /**
     * Zwraca wagę przedmiotu
     * 
     * @return Waga przedmiotu
     */
    public Double getWeight()
    {
        return weight;
    }

    /**
     * Ustawia wagę przedmiotu
     * 
     * @param weight
     *            Nowa waga przedmiotu
     * @exception IllegalArgumentException
     *                weight &lt 0
     */
    public void setWeight(Double weight)
    {
        if (weight < 0)
            throw new IllegalArgumentException("Ujemna waga(weight < 0)");
        this.weight = weight;
    }

    /**
     * Zwraca warotść przedmiotu
     * 
     * @return Wartość przedmiotu
     */
    public Value getValue()
    {
        return value;
    }

    /**
     * Ustawia warotść przedmiotu
     * 
     * @param value
     */
    public void setValue(Value value)
    {
        if (value == null)
            throw new NullPointerException("Nie może być null");
        this.value = value;
    }
    
    /**
     * Zwraca listę premi wynijącą z założenia przedmiotu
     */
    public Benefit[] getBenefits()
    {
        return benefits;
    }

    /**
     * Zwraca nazwę przedmiotu.<br/>
     * Bez znaku nowej lini na końcu
     * 
     * @return Nazwa przedmiotu
     */
    @Override
    public String toString()
    {
        return name + ' ' + weight + ' ' + value;
    }

    @Override
    public void leaveBehind()
    {
        manager = null;
        inventory = null;
    }

    @Override
    public void pickUp(EquipmentManager picker)
    {
        manager = picker;
    }

}
